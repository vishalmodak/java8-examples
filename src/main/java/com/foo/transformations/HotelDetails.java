package com.foo.transformations;

public class HotelDetails {
    private long hotelId;
    private String hotelName;
    private String locationCity;
    
    
    public HotelDetails(long hotelId, String hotelName, String locationCity) {
        super();
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.locationCity = locationCity;
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

    @Override
    public String toString() {
        return "HotelDetails [hotelId=" + hotelId + ", hotelName=" + hotelName
                + ", locationCity=" + locationCity + "]";
    }
    
    
}
