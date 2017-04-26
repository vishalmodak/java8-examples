package com.foo.transformations;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HotelComposer {

    public static void main(String[] args) {
        HotelPricing[] hotelPrices = {
                new HotelPricing(1, true, 100d, asList(75d, 25d), 10d),
                new HotelPricing(2, false, null, null, null),
                new HotelPricing(3, true, 200d, asList(75d, 50d, 75d), 30d),
        };

        HotelDetails[] hotelDetails = {
                new HotelDetails(1, "Grand Park Hyatt", "Paris"),
                new HotelDetails(2, "The Park Hyatt", "Tokyo"),
                new HotelDetails(3, "Hyatt Regency", "Chicago")
        };
        Map<Long, HotelDetails> idToHotelDetails = asList(hotelDetails)
                .stream()
                .collect(Collectors.toMap(HotelDetails::getHotelId, Function.identity()));
        
        Map<Long, HotelPricing> idToPricing = asList(hotelPrices)
                .stream()
                .collect(Collectors.toMap(HotelPricing::getHotelId, Function.identity()));
                        
        List<Hotel> hotels = idToHotelDetails.keySet()
                            .stream()
                            .filter(id -> idToPricing.get(id).isAvailable())
                            .map(id -> new Hotel(id, idToHotelDetails.get(id).getHotelName(), 
                                                    idToHotelDetails.get(id).getLocationCity(), 
                                                    idToPricing.get(id).getTotalPrice(), 
                                                    idToPricing.get(id).getDailyRate().stream().mapToDouble(a-> a).average().getAsDouble())
                            )
                            .collect(Collectors.toList());
        System.out.println(hotels);
        
        

    }

}
