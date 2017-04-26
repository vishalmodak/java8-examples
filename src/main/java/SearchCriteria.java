import java.util.Date;

public class SearchCriteria {
    private final String hotelName;
    private final String destination;
    private final Date startDate;
    private final Date endDate;
    private final int rooms;
    private final int guestCount;
    private final String offerCode;
    
    private SearchCriteria(String hotelName, String destination, Date startDate,
            Date endDate, int rooms, int guestCount, String offerCode) {
        super();
        this.hotelName = hotelName;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rooms = rooms;
        this.guestCount = guestCount;
        this.offerCode = offerCode;
    }

    public static SearchCriteriaBuilder newBuilder() {
        return new SearchCriteriaBuilder();
    }

    public String getHotelName() {
        return this.hotelName;
    }

    public String getDestination() {
        return this.destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public int getRooms() {
        return this.rooms;
    }

    public int getGuestCount() {
        return this.guestCount;
    }

    public String getOfferCode() {
        return this.offerCode;
    }

    public static class SearchCriteriaBuilder {
        private String name;
        private String destination;
        private Date startDate;
        private Date endDate;
        private int rooms;
        private int guestCount;
        private String offerCode;
        
        public SearchCriteriaBuilder() {
        }
        
        public SearchCriteriaBuilder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public SearchCriteriaBuilder setRooms(int rooms) {
            this.rooms = rooms;
            return this;
        }
        
        public SearchCriteriaBuilder setGuestCount(int guestCount) {
            this.guestCount = guestCount;
            return this;
        }

        public SearchCriteriaBuilder setOfferCode(String offerCode) {
            this.offerCode = offerCode;
            return this;
        }
        
        public SearchCriteriaBuilder setHotelName(String hotelName) {
            this.name = hotelName;
            return this;
        }
        
        public SearchCriteriaBuilder setDestination(String destination) {
            this.destination = destination;
            return this;
        }
        
        public SearchCriteriaBuilder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }
        
        public SearchCriteria build() {
            return new SearchCriteria(name, destination, startDate, endDate, rooms, guestCount, offerCode);
        }
    }
}

