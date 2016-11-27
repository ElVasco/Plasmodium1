package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import ve.com.plasmodium.model.vo.InstitutionDTO;
import ve.com.plasmodium.util.Utils;

public class MySQLInstitutionDAO implements InstitutionDAO {


	public void institutionDetail(InstitutionDTO institutionDTO, String institution) {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getInstitutionDetail);
			preparedStatement.setString(1, institution);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			//TODO MEGA FUNCION PARSEADOR DE TODA MIERDA
			if(resultSet.next()){
				;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

}
