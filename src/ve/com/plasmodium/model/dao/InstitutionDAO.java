package ve.com.plasmodium.model.dao;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.InstitutionDTO;
import ve.com.plasmodium.model.vo.InstitutionTypeDTO;

public interface InstitutionDAO {
    public static final Logger logger = Logger.getLogger(InstitutionDAO.class);

	public void institutionDetail(InstitutionDTO institutionDTO, String institution);

	public void institutionList(List<InstitutionDTO> institution, String selectedInstitutionType);

	public void getIntitutionTypeList(List<InstitutionTypeDTO> institutionTypeList); 
	
	public int addInstitutionType(InstitutionTypeDTO institutionType);
	
	public int changeInstitutionType(InstitutionTypeDTO institutionType);
	
	public int addInstitution(InstitutionDTO institution);
	
	public int changeInstitution(InstitutionDTO institution);
    
}
