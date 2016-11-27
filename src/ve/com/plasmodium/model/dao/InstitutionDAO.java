package ve.com.plasmodium.model.dao;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.InstitutionDTO;

public interface InstitutionDAO {
    public static final Logger logger = Logger.getLogger(InstitutionDAO.class);

	public void institutionDetail(InstitutionDTO institutionDTO, String institution); 
    
    
}
