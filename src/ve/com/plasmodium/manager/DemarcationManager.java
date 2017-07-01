package ve.com.plasmodium.manager;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.DemarcationDAO;
import ve.com.plasmodium.model.vo.DemarcationDTO;

public class DemarcationManager {

	public static final Logger logger = Logger.getLogger(DemarcationManager.class);

	final DemarcationDAO demarcationDAO;

	public DemarcationManager(short aFactoryNumber) {
		this.demarcationDAO = DAOFactory.getDAOFactory(aFactoryNumber).getDemarcationDAO();
	}

	public void getDemarcationList(List<DemarcationDTO> demarcationList){
		try {
	    	demarcationDAO.getDemarcationList(demarcationList);
		} catch (Exception e) {
			logger.error("Exception demarcationManager - demarcationList NOT FOUND", e);
		}
	}

	public DemarcationDTO demarcationDetail(String demarcation) {
		try {
	    	return demarcationDAO.demarcationDetail(demarcation);
		} catch (Exception e) {
			 logger.error("Exception demarcationManager - demarcationDetail NOT FOUND", e);
			 return null;
		}
	}
	
	public int addDemarcation(DemarcationDTO demarcation) {
	   	try{
    		return demarcationDAO.addDemarcation(demarcation);
    	}catch (Exception e){
    		logger.error("Exception demarcationManager - AddDemarcation ", e);
    		return -1;
    	}
	}

	public int updateDemarcation(DemarcationDTO demarcation) {
	   	try{
    		return demarcationDAO.updateDemarcation(demarcation);
    	}catch (Exception e){
    		logger.error("Exception demarcationManager - UpdateDemarcation ", e);
    		return -1;
    	}
	}
}