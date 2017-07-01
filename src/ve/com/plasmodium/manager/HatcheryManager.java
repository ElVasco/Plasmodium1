package ve.com.plasmodium.manager;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.HatcheryDAO;
import ve.com.plasmodium.model.vo.HatcheryDTO;

public class HatcheryManager {

	public static final Logger logger = Logger.getLogger(HatcheryManager.class);

	final HatcheryDAO hatcheryDAO;

	public HatcheryManager(short aFactoryNumber){
    	this.hatcheryDAO = DAOFactory.getDAOFactory(aFactoryNumber).getHatcheryDAO();
    }
	
	public void getHatcheryList(List<HatcheryDTO> hatcheryList){
		try {
	    	hatcheryDAO.getHatcheryList(hatcheryList);
		} catch (Exception e) {
			logger.error("Exception hatcheryManager - hatcheryList NOT FOUND", e);
		}
	}

	public HatcheryDTO hatcheryDetail(String hatchery) {
		try {
	    	return hatcheryDAO.hatcheryDetail(hatchery);
		} catch (Exception e) {
			 logger.error("Exception hatcheryManager - hatcheryDetail NOT FOUND", e);
			 return null;
		}
	}
	
	public int addHatchery(HatcheryDTO hatchery) {
	   	try{
    		return hatcheryDAO.addHatchery(hatchery);
    	}catch (Exception e){
    		logger.error("Exception hatcheryManager - AddHatchery ", e);
    		return -1;
    	}
	}

	public int updateHatchery(HatcheryDTO hatchery) {
	   	try{
    		return hatcheryDAO.updateHatchery(hatchery);
    	}catch (Exception e){
    		logger.error("Exception hatcheryManager - UpdateHatchery ", e);
    		return -1;
    	}
	}
}