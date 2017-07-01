package ve.com.plasmodium.model.dao;


import org.apache.log4j.Logger;

//Abstract class DAO Factory
/**
 * @author wcsadmin
 *
 */
public abstract class DAOFactory {

	public static final Logger logger = Logger.getLogger (DAOFactory.class);

	// List of DAO types supported by this factoy
	//public static final int MYSQL = 1;
	//public static final int DB2 = 2;


	//There will be a method for each DAO that can be
	//created. The concrete factories will have to
	// implement these methods.
	public abstract InstitutionDAO getInstitutionDAO();
	public abstract LocatioDAO getLocatioDAO();
	public abstract GlobalDAO getGlobalDAO();
	public abstract UserDAO getUserDAO();

	public abstract PlasmodiumDAO getPlasmodiumDAO();
	public abstract PhenomenonDAO getPhenomenonDAO();
	public abstract HatcheryDAO getHatcheryDAO();
	public abstract CampaignDAO getCampaignDAO();
	public abstract DemarcationDAO getDemarcationDAO();

	public abstract AuthorizationDAO getAuthorizationDAO();
	//IS

	//report

	/**
	 * @return
	 */
	public static DAOFactory getDAOFactory(int factory){

		switch (factory) {
		case SQLConstant.MYSQL:
			return MySQLDAOFactory.getInstance();
		case SQLConstant.DB2: 
			//  return new DB2DAOFactory();
		default:
			return null;
		}	
	}
			
}