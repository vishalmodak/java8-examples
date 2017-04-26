import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    public Currency currency;
    public BigDecimal value;
    
    public Money() { }
    
    public Currency getCurrency() {
        return currency;
    }
    
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    
    public BigDecimal getValue() {
        return value;
    }
    
    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
