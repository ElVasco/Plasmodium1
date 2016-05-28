package ve.com.plasmodium.model.dao;

import java.util.Map;

import org.apache.log4j.Logger;

public interface AuthorizationDAO {
    
    public static final Logger logger = Logger.getLogger(AuthorizationDAO.class);

    /**
     * Given a company ID, this method returns a list with all the roles associated to that company 
     * @return roles list
     */
    public Map<String,Integer> getAllRoles();

}
