package ve.com.plasmodium.manager;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.dao.InstitutionDAO;
import ve.com.plasmodium.model.vo.InstitutionDTO;
import ve.com.plasmodium.model.vo.InstitutionTypeDTO;
import ve.com.plasmodium.model.vo.PlasmodiumDTO;
import ve.com.plasmodium.model.dao.DAOFactory;

public class InstitutionManager {

    public static final Logger logger = Logger.getLogger(InstitutionManager.class);

    final InstitutionDAO institutionDAO;

    public InstitutionManager(short aFactoryNumber) {
    	this.institutionDAO = DAOFactory.getDAOFactory(aFactoryNumber).getInstitutionDAO();
    }

	public void institutionDetail(InstitutionDTO institutionDTO, String institution) {
		try {
	    	institutionDAO.institutionDetail(institutionDTO, institution);
		} catch (Exception e) {
			 logger.error("Exception institutionManager - institutionDetail ", e);
		}
	}

	public void institutionList(List<InstitutionDTO> institution, String selectedInstitutionType) {
		try {
	    	institutionDAO.institutionList(institution, selectedInstitutionType);
		} catch (Exception e) {
			 logger.error("Exception institutionManager - institutionList ", e);
		}
	}

	public void getIntitutionTypeList(List<InstitutionTypeDTO> institutionTypeList) {
		try {
	    	institutionDAO.getIntitutionTypeList(institutionTypeList);
		} catch (Exception e) {
			 logger.error("Exception institutionManager - institutionList ", e);
		}
	}

    public int addInstitutionType(InstitutionTypeDTO instiTypeDTO) {
    	try{
    		return institutionDAO.addInstitutionType(instiTypeDTO);
    	}catch (Exception e){
    		logger.error("Exception institutionTypeManager - adding institutionType ", e);
    		return -1;
    	}
    }

    public int changeInstitutionType(InstitutionTypeDTO instiTypeDTO) {
    	try{
    		return institutionDAO.changeInstitutionType(instiTypeDTO);
    	}catch (Exception e){
    		logger.error("Exception institutionTypeManager - cambiando institutionType ", e);
    		return -1;
    	}
    }

    public int addInstitution(InstitutionDTO instiDTO) {
    	try{
    		return institutionDAO.addInstitution(instiDTO);
    	}catch (Exception e){
    		logger.error("Exception institutionTypeManager - adding institutionType ", e);
    		return -1;
    	}
    }

    public int changeInstitution(InstitutionDTO instiDTO) {
    	try{
    		return institutionDAO.changeInstitution(instiDTO);
    	}catch (Exception e){
    		logger.error("Exception institutionTypeManager - cambiando institutionType ", e);
    		return -1;
    	}
    }
}