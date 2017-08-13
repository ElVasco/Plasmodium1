package ve.com.plasmodium.manager;

import java.net.URL;
import java.util.Scanner;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ve.com.plasmodium.control.GlobalDataBean;
import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.LocatioDAO;
import ve.com.plasmodium.model.vo.LocationDTO;

public class LocationManager {

    public static final Logger logger = Logger.getLogger(LocationManager.class);

    final LocatioDAO locatioDAO;

    public LocationManager(short aFactoryNumber) {
    	this.locatioDAO = DAOFactory.getDAOFactory(aFactoryNumber).getLocatioDAO();
    }
    
	public void searchJsonLatLng(LocatioDAO loc) {
		try {
			GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
			gd.getParam();
			URL url = new URL(gd.getParam().get("param.url.google.latlng") + "&" + gd.getParam().get("param.key.google"));
			JSONArray msg = (JSONArray) ve.com.plasmodium.util.Utils.getUrlJson(url).get("results");
		} catch (Exception e) {
			 logger.error("Exception LocationManager - searchJsonLatLng ", e);
		}
	}

	public void getLocationDetail(String placeId, String txt1) {
		GlobalDataBean gd = (GlobalDataBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("GlobalData");
		if(!locatioDAO.getLocationDetail(placeId, txt1, gd)){
			try {
				LocationDTO l = new LocationDTO(); 
				l.setPlaceId(placeId);
				String urlStr = "https://maps.googleapis.com/maps/api/place/details/json?place_id=" + placeId + "&" + gd.getParam().get("param.key.google");
				URL url = new URL(urlStr);
			    String json = new String();
			    Scanner scan = new Scanner(url.openStream());
			    while (scan.hasNext())
			    	json += scan.nextLine();
			    scan.close();
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(json);
				JSONObject jb = (JSONObject) obj;
				JSONObject jsonObject1 = (JSONObject) jb.get("result");
				JSONObject jsonObject2 = (JSONObject) jsonObject1.get("geometry");
				JSONObject jsonObject3 = (JSONObject) jsonObject2.get("location");
				String aux = jsonObject3.get("lat").toString();
				l.setLatitude(aux);
				l.setLongitude(jsonObject3.get("lng").toString());
				JSONArray jsonObject4 = (JSONArray) jsonObject1.get("address_components");
				for (int i = 0; i < jsonObject4.size(); i++) {
					JSONObject jsonObject5 = (JSONObject)jsonObject4.get(i);
					JSONArray jsonObject6 = (JSONArray) jsonObject5.get("types");
					String type = jsonObject6.get(0).toString();
					switch(type){
					case "country":
						l.setCountry(jsonObject5.get("long_name").toString());
						break;
					case "administrative_area_level_1":
						l.setAdministrative_area_level_1(jsonObject5.get("long_name").toString());
						break;
					case "administrative_area_level_2":
						l.setAdministrative_area_level_2(jsonObject5.get("long_name").toString());
						break;
					case "locality":
						l.setLocality(jsonObject5.get("long_name").toString());
						break;
					case "route":
						l.setRoute(jsonObject5.get("long_name").toString());
						break;
					}					
				}
				locatioDAO.newLocation(l);
				gd.getLocationList().replace(txt1, l);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}
    
}
