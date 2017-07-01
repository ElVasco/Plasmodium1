package ve.com.plasmodium.manager;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.DAOFactory;
import ve.com.plasmodium.model.dao.PhenomenonDAO;
import ve.com.plasmodium.model.vo.PhenomenonDTO;
import ve.com.plasmodium.model.vo.PhenomenonTypeDTO;

public class PhenomenonManager {

	public static final Logger logger = Logger.getLogger(PlasmodiumManager.class);

    final PhenomenonDAO phenomenonDAO;

	public PhenomenonManager(short aFactoryNumber){
    	this.phenomenonDAO = DAOFactory.getDAOFactory(aFactoryNumber).getPhenomenonDAO();
    }

	public void getPhenomenonTypeList(List<PhenomenonTypeDTO> phenomenonTypeList){
		try {
	    	phenomenonDAO.getPhenomenonTypeList(phenomenonTypeList);
		} catch (Exception e) {
			logger.error("Exception phenomenonManager - phenomenonTypeList NOT FOUND", e);
		}
	}

	public PhenomenonTypeDTO phenomenonTypeDetail(String phenomenonType) {
		try {
	    	return phenomenonDAO.phenomenonTypeDetail(phenomenonType);
		} catch (Exception e) {
			 logger.error("Exception phenomenonManager - phenomenonTypeDetail NOT FOUND", e);
			 return null;
		}
	}
	
	public int addPhenomenonType(PhenomenonTypeDTO phenomenonType) {
	   	try{
    		return phenomenonDAO.addPhenomenonType(phenomenonType);
    	}catch (Exception e){
    		logger.error("Exception plasmodiumManager - AddPhenomenonType ", e);
    		return -1;
    	}
	}

	public int updatePhenomenonType(PhenomenonTypeDTO phenomenonType, String selectedPhenomenonType) {
	   	try{
    		return phenomenonDAO.updatePhenomenonType(phenomenonType, selectedPhenomenonType);
    	}catch (Exception e){
    		logger.error("Exception plasmodiumManager - UpdatePhenomenonType ", e);
    		return -1;
    	}
	}

	public void getPhenomenonList(List<PhenomenonDTO> phenomenonList){
		try {
	    	phenomenonDAO.getPhenomenonList(phenomenonList);
		} catch (Exception e) {
			logger.error("Exception phenomenonManager - phenomenonTypeList NOT FOUND", e);
		}
	}

	public PhenomenonDTO phenomenonDetail(String phenomenon) {
		try {
	    	return phenomenonDAO.phenomenonDetail(phenomenon);
		} catch (Exception e) {
			 logger.error("Exception phenomenonManager - phenomenonDetail NOT FOUND", e);
			 return null;
		}
	}
	
	public int addPhenomenon(PhenomenonDTO phenomenon) {
	   	try{
    		return phenomenonDAO.addPhenomenon(phenomenon);
    	}catch (Exception e){
    		logger.error("Exception plasmodiumManager - AddPhenomenonType ", e);
    		return -1;
    	}
	}

	public int updatePhenomenon(PhenomenonDTO phenomenon) {
	   	try{
    		return phenomenonDAO.updatePhenomenon(phenomenon);
    	}catch (Exception e){
    		logger.error("Exception plasmodiumManager - UpdatePhenomenonType ", e);
    		return -1;
    	}
	}
}