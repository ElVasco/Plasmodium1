package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ve.com.plasmodium.model.vo.InstitutionDTO;
import ve.com.plasmodium.model.vo.InstitutionTypeDTO;
import ve.com.plasmodium.model.vo.LocationDTO;
import ve.com.plasmodium.util.Utils;

public class MySQLInstitutionDAO implements InstitutionDAO {

	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public void initSQLData(){
		conn = MySQLDAOFactory.createConnection();
		preparedStatement = null;
		resultSet = null;
	}
	
	public void institutionDetail(InstitutionDTO institutionDTO, String institution) {
		initSQLData();
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

	public void institutionList(List<InstitutionDTO> institutionList, String institutionType) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getInstitutionList);
			preparedStatement.setString(1, institutionType);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				InstitutionDTO institution = new InstitutionDTO();
				institution.setInstitutionType(new InstitutionTypeDTO());
				institution.setLocation(new LocationDTO());
				institution.setName(resultSet.getString("name"));
				institution.setIdIstitution(resultSet.getInt("id_institution"));
				institution.getInstitutionType().setIdIstitutionType(resultSet.getInt("id_institution_type"));
				institution.getInstitutionType().setName(resultSet.getString("name1"));
				institution.getLocation().setIdLocation(resultSet.getInt("id_location"));
				institution.getLocation().setLatitude(resultSet.getString("latitude"));
				institution.getLocation().setLongitude(resultSet.getString("longitude"));
				institution.getLocation().setLongitude(resultSet.getString("longitude"));
				institution.getLocation().setState(resultSet.getString("administrative_area_level_1"));
				institution.getLocation().setCity(resultSet.getString("locality"));
				institution.getLocation().setMunicipality(resultSet.getString("administrative_area_level_2"));
				institution.getLocation().setRoute(resultSet.getString("route"));
				institution.getLocation().setPlaceId(resultSet.getString("place_ID"));
				institution.getLocation().setDemarcation(resultSet.getString("demarcation"));
				institutionList.add(institution);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}


	public void getIntitutionTypeList(List<InstitutionTypeDTO> institutionTypeList) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getInstitutionTypeList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				InstitutionTypeDTO institution = new InstitutionTypeDTO();
				institution.setIdIstitutionType(resultSet.getInt("id_institution_type"));
				institution.setName(resultSet.getString("name"));
				institutionTypeList.add(institution);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

}
