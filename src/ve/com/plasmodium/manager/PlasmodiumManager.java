package ve.com.plasmodium.manager;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.LethalityDTO;
import ve.com.plasmodium.model.vo.PlasmodiumDTO;
import ve.com.plasmodium.model.vo.PlasmodiumTypeDTO;
import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.PlasmodiumDAO;

public class PlasmodiumManager {

    public static final Logger logger = Logger.getLogger(PlasmodiumManager.class);

    final PlasmodiumDAO plasmodiumDAO;

    public PlasmodiumManager(short aFactoryNumber) {
    	this.plasmodiumDAO = DAOFactory.getDAOFactory(aFactoryNumber).getPlasmodiumDAO();
    }

	public PlasmodiumDTO plasmodiumDetail(String plasmodium) {
		try {
	    	return plasmodiumDAO.plasmodiumDetail(plasmodium);
		} catch (Exception e) {
			 logger.error("Exception plasmodiumManager - plasmodiumDetail NOT FOUND", e);
			 return null;
		}
	}

	public void plasmodiumList(List<PlasmodiumDTO> plasmodium, String selectedPlasmodiumType) {
		try {
	    	plasmodiumDAO.plasmodiumList(plasmodium, selectedPlasmodiumType);
		} catch (Exception e) {
			 logger.error("Exception plasmodiumManager - plasmodiumList ", e);
		}
	}

	public void getPlasmodiumTypeList(List<PlasmodiumTypeDTO> plasmodiumTypeList) {
		try {
	    	plasmodiumDAO.getPlasmodiumTypeList(plasmodiumTypeList);
		} catch (Exception e) {
			 logger.error("Exception plasmodiumManager - plasmodiumList ", e);
		}
	}

	public void getLetalidadList(List<LethalityDTO> letalidadList) {
		try {
	    	plasmodiumDAO.getLetalidadList(letalidadList);
		} catch (Exception e) {
			 logger.error("Exception plasmodiumManager - plasmodiumList ", e);
		}
	}

    public int addPlasmodium(PlasmodiumDTO plasmodiumDTO) {
    	try{
    		return plasmodiumDAO.addPlasmodium(plasmodiumDTO);
    	}catch (Exception e){
    		logger.error("Exception plasmodiumManager - plasmodiumType ", e);
    		return -1;
    	}
    }
    
    public int updatePlasmodium(PlasmodiumDTO plasmodiumDTO) {
    	try{
    		return plasmodiumDAO.updatePlasmodium(plasmodiumDTO);
    	}catch (Exception e){
    		logger.error("Exception plasmodiumManager - plasmodiumType ", e);
    		return -1;
    	}
    }
}