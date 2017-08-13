package ve.com.plasmodium.model.dao;

import java.util.Map;

import org.apache.log4j.Logger;

import ve.com.plasmodium.control.GlobalDataBean;
import ve.com.plasmodium.model.vo.LocationDTO;

public interface LocatioDAO {
	
    public static final Logger logger = Logger.getLogger(LocatioDAO.class);
    
    public boolean getLocationDetail(String placeID, String txt1, GlobalDataBean gd);
    
    public boolean newLocation(LocationDTO locationDTO);

}
