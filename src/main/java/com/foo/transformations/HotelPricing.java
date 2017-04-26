package com.foo.transformations;

import java.util.List;

public class HotelPricing {
    
    private long hotelId;
    private boolean isAvailable;
    private Double totalPrice;
    private List<Double> dailyRate;
    private Double discounts;

    public HotelPricing(long hotelId, boolean isAvailable,
            Double totalPrice, List<Double> dailyRate, Double discounts) {
        super();
        this.hotelId = hotelId;
        this.isAvailable = isAvailable;
        this.totalPrice = totalPrice;
        this.dailyRate = dailyRate;
        this.discounts = discounts;
    }

    public long getHotelId() {
        return hotelId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public List<Double> getDailyRate() {
        return dailyRate;
    }

    public Double getDiscounts() {
        return discounts;
    }

    @Override
    public String toString() {
        return "HotelPricing [hotelId=" + hotelId + ", isAvailable="
                + isAvailable + ", totalPrice=" + totalPrice + ", dailyRate="
                + dailyRate + ", discounts=" + discounts + "]";
    }
    
    
}
