package ve.com.plasmodium.model.dao;

//  MySQL concrete DAO Factory implementation
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ve.com.plasmodium.exception.DAOException;

public class MySQLDAOFactory extends DAOFactory {

	public static final Logger logger = Logger.getLogger(MySQLDAOFactory.class);

	private static MySQLDAOFactory INSTANCE = null;

	public static MySQLDAOFactory getInstance(){
		if(INSTANCE == null){
			INSTANCE = new MySQLDAOFactory();
		}
		return INSTANCE;
	}

	//   method to create MySQL connections
	public static Connection createConnection() {
		// Use DRIVER and DB_URL to create a connection
		// Recommend connection pool implementation/usage
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			// Buscara en el contexto java:comp/env/jdbc/mysqlnew especificamente en el archivo context.xml de la aplicacion
			Context envContext  = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mysqlPlasmodium");
			conn = ds.getConnection();
		}
		catch (NamingException e) {
			logger.error("NamingException MySQLDAOFactory - createConnection ", e);
			new DAOException(SQLConstant.ERROR_NAMING, e.getRootCause());
		}
		catch (SQLException e) {
			logger.error("SQLException MySQLDAOFactory - createConnection ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}

		return conn;
	}

	public static void closeConection(Connection conn, String classFunction){
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception " + classFunction +" - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
	}

	public InstitutionDAO getInstitutionDAO() {
		return new MySQLInstitutionDAO();
	}

	public GlobalDAO getGlobalDAO() {
		return new MySQLGlobalDAO();
	}

	public UserDAO getUserDAO() {
		return new MySQLUserDAO();
	}


	public AuthorizationDAO getAuthorizationDAO() {
		return new MySQLAuthorizationDAO();
	}

	public LocatioDAO getLocatioDAO() {
		return new MySQLLocatioDAO();
	}

	@Override
	public PlasmodiumDAO getPlasmodiumDAO() {
		return new MYSQLPlasmodiumDAO();
	}

	@Override
	public PhenomenonDAO getPhenomenonDAO() {
		return new MySQLPhenomenonDAO();
	}

	@Override
	public HatcheryDAO getHatcheryDAO() {
		return new MySQLHatcheryDAO();
	}

	@Override
	public CampaignDAO getCampaignDAO() {
		return new MySQLCampaignDAO();
	}

	@Override
	public DemarcationDAO getDemarcationDAO() {
		return new MySQLDemarcationDAO();
	}
}