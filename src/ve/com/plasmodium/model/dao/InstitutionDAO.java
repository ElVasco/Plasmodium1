package ve.com.plasmodium.model.dao;

import java.util.List;

import org.apache.log4j.Logger;

import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.exception.DAOException;
import ve.com.plasmodium.model.vo.DispoVo;

public interface CardDAO {
    public static final Logger logger = Logger.getLogger(CardDAO.class);

    public List<DispoVo> DisponibleDistribHibrido() throws DAOException, CustomException; 

    public List<DispoVo> DisponibleDistrib() throws DAOException, CustomException; 
    
    public boolean updateDistributerManuf (short company, short distributer, int user, int from, int to); 
    
    
}
