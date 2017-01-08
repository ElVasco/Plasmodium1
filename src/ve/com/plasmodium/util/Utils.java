package ve.com.plasmodium.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public static String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	public static JSONObject getUrlJson(URL url){
		HttpsURLConnection con;
		String input, aux ="";
		JSONObject json = null;
		try {
			con = (HttpsURLConnection)url.openConnection();
			if(con!=null){
				BufferedReader br = 
						new BufferedReader(
								new InputStreamReader(con.getInputStream()));
				
				while ((input = br.readLine()) != null){
					aux += input;
				}
				br.close();
				aux = new String(aux.getBytes("ISO-8859-1"), "UTF-8");
				json = (JSONObject) new JSONParser().parse(aux);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

}
