package ve.com.plasmodium.util;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.to.SimpleDecimalTo;

public class Format {

	public static final Logger logger = Logger.getLogger(Format.class);
    
	/**
	 * Un numero de referencia basado en un sub string de los milisegundos de la fecha
	 */
	public static String miliRef (){
	    	Long milis = Calendar.getInstance().getTimeInMillis();
		String milisString = milis.toString();
		String referencia = milisString.substring(5,11);

		return referencia;
	 }
    

	
	    public static String amountGUIFormat(String anAmount) {
		
		String formatedNumber;
		boolean negativo = false;

		if (anAmount.indexOf('.') >= 0) {
		    throw new NumberFormatException("Se esta pasando un String representado un Decimal. El metodo espera un String representado un Entero");
		}
		
		if (anAmount.indexOf('-') >= 0) {
		    anAmount = anAmount.replaceAll("-","0");
		    logger.warn("Se realizo un movimiento que da un monto negativo. El monto es " + anAmount);
		    negativo = true;
		}
		
		
		Integer numberI = Integer.parseInt(anAmount);	
		String numberS = numberI.toString();
		
		if (numberS.length() == 2)  {
		    numberS = "0" + numberS;
		}
		if (numberS.length() == 1)  {
		    numberS = "00" + numberS;
		}

		int size = numberS.length();
		
		StringBuffer stringBuffer = new StringBuffer();
		if (negativo) {stringBuffer.append('-');}
		stringBuffer.append(numberS.substring(0,size-2));
		stringBuffer.append('.');
		stringBuffer.append(numberS.substring(size-2,size));
		formatedNumber = stringBuffer.toString();
		
		return formatedNumber;
	    }
	
	
	
	    /**
	     * @param usaDate A date with american format but with out date sepataror;
	     * as this date 19650916
	     * @return a date with our local format;
	     * as 16/09/1965
	     */
	    public static String simpleDate(String usaDate) {
		StringBuffer formateDate = new StringBuffer();
		formateDate.append(usaDate.substring(6, 8)); //Day
		formateDate.append('/'); //Separator
		formateDate.append(usaDate.substring(4, 6)); // Month
		formateDate.append('/'); //Separator
		formateDate.append(usaDate.substring(0, 4)); // Year
		return formateDate.toString() ;
	    }
	
	
	
	
	
	
	public final static String smartFill(String stringToBeFilled, int fieldSize, String fillerChar, String sideToBeFfille) {
	String fieldConvert = stringToBeFilled;

	int cuantoFalta = fieldSize - fieldConvert.length();
	if (cuantoFalta > 0) {

	    if (sideToBeFfille.equalsIgnoreCase("L")) {
		for (int i = 0; i < cuantoFalta; i++) {
		    fieldConvert = fillerChar + fieldConvert;
		}
	    }// end if Left

	    else if (sideToBeFfille.equalsIgnoreCase("R")) {
		for (int i = 0; i < cuantoFalta; i++) {
		    fieldConvert = fieldConvert + fillerChar;
		}
	    }// end if Right

	}

	return fieldConvert;
    }
	
	
	

	
	
	
	
	
	public final static String fillLeft(Object aObject, int db2FieldSize){
		String fieldConvert = null;
		if (aObject instanceof String) {
			fieldConvert = (String )aObject;
			}
		else if (aObject instanceof BigDecimal) {
			fieldConvert = (String )aObject.toString();
			}
		else if (aObject instanceof Integer){
			fieldConvert = aObject.toString();
		}
		
		   int cuantoFalta = db2FieldSize - fieldConvert.length();
			if (cuantoFalta > 0) {
			for (int i = 0; i< cuantoFalta ; i++) {
				fieldConvert =  "0" + fieldConvert;
			}
			}
		   
		   return fieldConvert;
	}
	
	
	public final static String roundRemovePoint(Object aObject, int decimales){
		
		String roundedPaded = null;
		
		if (aObject instanceof String) {
			BigDecimal aBigDecimal = new BigDecimal((String) aObject);
			BigDecimal res = aBigDecimal.setScale(decimales, BigDecimal.ROUND_HALF_EVEN);
			roundedPaded = padZeros(res.toString(), decimales);
			}
		else if (aObject instanceof BigDecimal) {
			BigDecimal res = ( (BigDecimal)aObject).setScale(decimales, BigDecimal.ROUND_HALF_EVEN);
			roundedPaded = padZeros(res.toString(), decimales);
			}
		
		String result = "";
		 int posi = roundedPaded.indexOf('.');
		  result = roundedPaded.substring(0,posi);
		   result = result + roundedPaded.substring(posi+1);
		   roundedPaded = result;
		
		   return roundedPaded;
	}
	
	
	
	
	public final static String formatAS400(String aObject){
		int DB2FIELDSIZE = 13;
		int DECIMALS = 2;
		String roundedPaded = null;
		
		roundedPaded = padZeros(aObject, DECIMALS);
	
		String result = "";
		 int posi = roundedPaded.indexOf('.');
		  result = roundedPaded.substring(0,posi); //ENTERO
		   result = result + roundedPaded.substring(posi+1, (posi+1)+2); // ENTERO MAS DECIMALES SIN EL PUNTO
		   roundedPaded = result;
				   
		   int cuantoFalta = DB2FIELDSIZE -	roundedPaded.length();
			if (cuantoFalta > 0) {
			for (int i = 0; i< cuantoFalta ; i++) {
				roundedPaded =  "0" + roundedPaded;
			}
			}

		   return roundedPaded;

	}
	

	
	
	
	
	
	
	public final static SimpleDecimalTo splitIntegerDotDecimal(String aNumber, int decimalesToKeep){
		String temp = aNumber;
		SimpleDecimalTo simpleDecimalTo = new SimpleDecimalTo();
		
		//String result = "";
		
		
		 int posi = temp.indexOf('.');
		 simpleDecimalTo.setIntegerPart(temp.substring(0,posi));
		 simpleDecimalTo.setDecimalPart(temp.substring(posi+1));		 
		  //result = temp.substring(0,posi);
		  // result = result + temp.substring(posi+1);
		   //temp = result;
		
		   return simpleDecimalTo;
	}
	
	
	
	
	
	
	
	public final static String removePoint(Object aObject, int decimales){
		String roundedPaded = null;
		
		if (aObject instanceof String) {
			roundedPaded = padZeros((String)aObject, decimales);
			}
		else if (aObject instanceof BigDecimal) {
			roundedPaded = padZeros((String) aObject.toString(), decimales);
			}
		
		String result = "";
		 int posi = roundedPaded.indexOf('.');
		  result = roundedPaded.substring(0,posi);
		   result = result + roundedPaded.substring(posi+1);
		   roundedPaded = result;
		
		   return roundedPaded;
	}
	
	
	/**
	 *	Permite redondear un numero en formato string rellenando los decimales
	 *  faltaltantes con Zeros
	 * @param numero
	 * @param decimales
	 * @return
	 */
	private  final static String padZeros(String numero, int decimales){
		int indice = numero.indexOf('.'); 
		int decimalesActuales = numero.length() - indice - 1; // le resto el punto
		int cuantoFalta = decimales - decimalesActuales;

		if (indice == -1) {
			numero = numero + ".";
			for (int i = 0; i< cuantoFalta ; i++) {
				numero = numero + "0";
			}	
		}
		else {
			for (int i = 0; i< cuantoFalta ; i++) {
				numero = numero + "0";
			}	
		}
		return numero;
	}
	
	
	
	/**
	* Fast work around to add decibal to amount from denominaciones GUI
	 * @param numero
	 * @param decimales
	 * @return
	 */
	public  final static String leisyDecimal(String numero){
		return numero + ".00";
	}
	
	
	public final static String getFechaProceso() {
		
		  String fechaProceso = null;	
			
		  Calendar rightNow = Calendar.getInstance(); 

		  String day = Integer.toString( rightNow.get( Calendar.DAY_OF_MONTH) ); 
		  if ( day.length() == 1) { day = 0 + day;}  
		  
		  String month = Integer.toString( rightNow.get( Calendar.MONTH) + 1 );  
		  if ( month.length() == 1) { month = 0 + month;}  

		  String year = Integer.toString( rightNow.get( Calendar.YEAR));

		  fechaProceso = year +"-"+ month +"-"+ day;

		  return  fechaProceso;
	}
	
	public final static String getDateProceso() {
		
		  String fechaProceso = null;	
			
		  Calendar rightNow = Calendar.getInstance(); 

		  String day = Integer.toString( rightNow.get( Calendar.DAY_OF_MONTH) ); 
		  if ( day.length() == 1) { day = 0 + day;}  
		  
		  String month = Integer.toString( rightNow.get( Calendar.MONTH) + 1 );  
		  if ( month.length() == 1) { month = 0 + month;}  

		  //String year = Integer.toString( rightNow.get( Calendar.YEAR));

		  String hour = Integer.toString( rightNow.get( Calendar.HOUR));
		  if ( hour.length() == 1) { hour = 0 + hour;}
		  String minute = Integer.toString( rightNow.get( Calendar.MINUTE));
		  if ( minute.length() == 1) { minute = 0 + minute;}
		  String second = Integer.toString( rightNow.get( Calendar.SECOND));
		  if ( second.length() == 1) { second = 0 + second;}
		  
		  fechaProceso = month +""+ day+""+hour+""+minute+""+second;
		  return  fechaProceso;
	}	
	
	public static double latinDecimalToDouble (String decimal){
		decimal = decimal.replaceAll("\\.", "");
		decimal = decimal.replaceAll(",", ".");
		return Double.parseDouble(decimal);
	}
	
}
