import java.util.Date;
import java.util.Map.Entry;

public class Test1 {

    public static void main(String[] args) {
        
        SearchCriteria searchCriteria = SearchCriteria.newBuilder()
                .setDestination("San Francisco")
                .setStartDate(new Date())
                .setEndDate(new Date())
                .setGuestCount(4)
                .setRooms(2)
                .setOfferCode("GOLD20")
                .build();
        
        
    }

    public static StringBuilder buildMap(Map<String, String> paramMap, StringBuilder builder) {
        builder.append("something");
        try {
            for (Entry<String, String> entry : paramMap.entrySet()) {
                if (entry.getValue() == null) {
                    throw new NullPointerException();
                }
                builder.append(entry.getKey() + "=" + entry.getValue()).append(",");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return builder;
    }
    

}
