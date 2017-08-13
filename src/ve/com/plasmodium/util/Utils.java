package ve.com.plasmodium.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.faces.context.FacesContext;
import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ve.com.plasmodium.control.GlobalDataBean;
import ve.com.plasmodium.model.vo.LocationDTO;

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
	
	public static List<String> geocoding(String addr, Map<String, LocationDTO> locationList) throws Exception
	{
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		addr = addr.replace(" ", "%20");
		List<String> result = new ArrayList<String>();
	    // build a URL
	    String s = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + addr + "&" + gd.getParam().get("param.key.google");
	    URL url = new URL(s);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String json = new String();
	    while (scan.hasNext())
	    	json += scan.nextLine();
	    scan.close();
	 
		//now parse
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);
		JSONObject jb = (JSONObject) obj;

		//now read
		JSONArray jsonObject1 = (JSONArray) jb.get("predictions");
		for (int i = 0; i < jsonObject1.size(); i++) {
			JSONObject jsonObject2 = (JSONObject)jsonObject1.get(i);
			result.add(jsonObject2.get("description").toString());
			LocationDTO l = new LocationDTO();
			l.setPlaceId(jsonObject2.get("place_id").toString());
			locationList.put(jsonObject2.get("description").toString(),l);
		}
		return result;
	}

}
