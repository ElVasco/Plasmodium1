package ve.com.plasmodium.manager;

import java.net.URL;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

import ve.com.plasmodium.control.GlobalDataBean;
import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.LocatioDAO;

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
			JSONArray msg = (JSONArray) ve.com.plasmodium.util.Utils.getUrlJson(url).get("results");;
		} catch (Exception e) {
			 logger.error("Exception LocationManager - searchJsonLatLng ", e);
		}
	}
    
}
