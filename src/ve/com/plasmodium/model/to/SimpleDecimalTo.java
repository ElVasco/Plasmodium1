package ve.com.plasmodium.model.to;

import org.apache.log4j.Logger;

public class SimpleDecimalTo {
    
	public static final Logger logger = Logger.getLogger(SimpleDecimalTo.class);
    
    private String integerPart;
    private String decimalPart;
    public String getDecimalPart() {
        return decimalPart;
    }
    public void setDecimalPart(String decimalPart) {
        this.decimalPart = decimalPart;
    }
    public String getIntegerPart() {
        return integerPart;
    }
    public void setIntegerPart(String integerPart) {
        this.integerPart = integerPart;
    }

    

}
