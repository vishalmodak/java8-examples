package com.foo.transformations;

import java.util.List;

public class Hotel {
    public long hotelId;
    public String hotelName;
    public String locationCity;
    public Double totalPrice;
    public Double avgDailyRate;
    public List<Review> reviewsList;
    
    public Hotel(long hotelId, String hotelName, String locationCity, List<Review> reviews) {
        super();
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.locationCity = locationCity;
        this.reviewsList = reviews;
    }
    
    public Hotel(long hotelId, String hotelName, String locationCity,
            Double totalPrice, Double avgDailyRate) {
        super();
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.locationCity = locationCity;
        this.totalPrice = totalPrice;
        this.avgDailyRate = avgDailyRate;
    }
    
    public long getHotelId() {
        return hotelId;
    }
    public String getHotelName() {
        return hotelName;
    }
    public String getLocationCity() {
        return locationCity;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public Double getAvgDailyRate() {
        return avgDailyRate;
    }
    public List<Review> getReviewsList() {
        return reviewsList;
    }

    @Override
    public String toString() {
        return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName
                + ", locationCity=" + locationCity + ", totalPrice="
                + totalPrice + ", avgDailyRate=" + avgDailyRate + "]";
    }
    
    
}
