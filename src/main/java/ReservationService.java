import java.util.Date;

public class ReservationService {

    public boolean reserve(HotelCriteria criteria) {
        SearchCriteria hotel = findHotel(criteria.getHotelId());
//        checkInventory();
//        updateInventory();
        
        return true;
    }

    
    private SearchCriteria findHotel(int hotelId) {
        //query the database
        //return the given hotel
        SearchCriteria hyatt = new SearchCriteria();
        hyatt.setHotelId(1001);
        hyatt.setHotelName("Grand Hyatt");
        hyatt.setAvailableInventory(20);
        hyatt.setAddress("michigan ave, chicago");
        return hyatt;
    }
    
}

class HotelCriteria {
    
    private String location;
    private int hotelId;
    private Date checkInDate;
    private Date checkOutDate;
    private int rooms;
    
    
    public int getHotelId() {
        return hotelId;
    }
    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
    public Date getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public int getRooms() {
        return rooms;
    }
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    
    
    
}