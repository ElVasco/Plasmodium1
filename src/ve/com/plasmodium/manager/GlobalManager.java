package ve.com.plasmodium.manager;

import java.util.Map;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.GlobalDAO;

public class GlobalManager {

    public static final Logger logger = Logger.getLogger(GlobalManager.class);

    final GlobalDAO globalDAO;

    public GlobalManager(short aFactoryNumber) {
    	this.globalDAO = DAOFactory.getDAOFactory(aFactoryNumber).getGlobalDAO();
    }
    
	public void searchParameter(Map<String,String> maps) {
		try {
			globalDAO.searchParameter(maps);
		} catch (Exception e) {
			 logger.error("Exception GlobalManager - searchParameter ", e);
		}
	}
    
}
