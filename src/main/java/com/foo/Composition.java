package com.foo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Composition {
    
    public static void main(String[] args) {
        HotelPrice price = new HotelPrice();
        price.rates = Arrays.asList(100d, 90d, 80d, 70d);
        price.discountPct = 0.15d;
        price.taxesPct = 0.1d;
        price.feesPct = 0.02d;

        System.out.println(price.getTotalPriceInclusiveTaxesFeesUsingAndThen());
        System.out.println(price.getTotalPriceInclusiveTaxesFeesUsingCompose());
        System.out.println(price.getTotalPriceExclusive());
        
        Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());

    }

}

class HotelPrice {
    Double taxesPct;
    Double feesPct;
    Double discountPct;
    List<Double> rates;
    
    Function<List<Double>, Double> calculateBasePrice = (dailyRates) -> dailyRates.stream().reduce(0d, (prevRate, currRate) -> prevRate + currRate);
    Function<Double, Double> calculateTaxes = (basePrice) -> basePrice * taxesPct;
    Function<Double, Double> calculateFees = (basePrice) -> basePrice * feesPct;
    Function<Double, Double> calculateDiscounts = (basePrice) -> basePrice * discountPct;
    Function<Double, Double> deductDiscounts = (basePrice) -> basePrice - calculateDiscounts.apply(basePrice);
    Function<Double, Double> addTaxes = (basePrice) -> basePrice + calculateTaxes.apply(basePrice);
    Function<Double, Double> addFees = (basePrice) -> basePrice + calculateFees.apply(basePrice);
    
    Function<List<Double>, Double> totalPriceInclusive1 = calculateBasePrice.andThen(deductDiscounts)
                                                                            .andThen(addTaxes)
                                                                            .andThen(addFees);
    
    Function<List<Double>, Double> totalPriceInclusive2 = addFees.compose(addTaxes).compose(deductDiscounts).compose(calculateBasePrice);
    
    Function<List<Double>, Double> totalPriceExclusive = calculateBasePrice.andThen(deductDiscounts);
    
    public Double getTotalPriceInclusiveTaxesFeesUsingAndThen() {
        return totalPriceInclusive1.apply(rates);
    }
    
    public Double getTotalPriceInclusiveTaxesFeesUsingCompose() {
        return totalPriceInclusive2.apply(rates);
    }
    
    public Double getTotalPriceExclusive() {
        return totalPriceExclusive.apply(rates);
    }
    
    public Double getBasePrice() {
        return calculateBasePrice.apply(rates);
    }
    
}
