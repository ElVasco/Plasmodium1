package ve.com.plasmodium.util;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getMethodName() {
	    return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

}
