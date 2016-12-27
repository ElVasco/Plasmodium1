package ve.com.plasmodium.converter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

import org.apache.log4j.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class AmountConverter implements Converter {
	public static final Logger logger = Logger.getLogger(AmountConverter.class);
			
	private NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
	private DecimalFormat df = (DecimalFormat)nf;
	
	public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
		df.applyPattern("###,###,###,###,##0.00");
        ParsePosition parsePosition = new ParsePosition(0);
        df.setParseBigDecimal(true);
        
        BigDecimal result = (BigDecimal)df.parse(value,parsePosition);
        if(result == null) {
        	logger.debug("AmountConverter: Failed to parse: " + value);
        }
        else if(parsePosition.getIndex() < value.length()) {
        	logger.debug("AmountConverter: " + value + " parsed incomplete. ParsePos:" + parsePosition.getIndex() + ", "
        			+ "Parse Result: " + result);
        }
        else {
        	logger.debug("AmountConverter: "+ value + " parsed OK. ParsePos: " + parsePosition.getIndex() +", Parse Result: "
        			+ result);
        } 
        return result;
	}

	public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
		df.applyPattern("###,###,###,###,##0.00");
		String result = value.toString();
		try {
			result = df.format(value);
		} catch (Exception e) {
			logger.debug("AmountConverter: "+ value + " failed parse to decimal format.");
		}
		return result;
	}
}
