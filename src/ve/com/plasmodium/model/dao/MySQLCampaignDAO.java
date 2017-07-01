package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ve.com.plasmodium.model.vo.CampaignDTO;
import ve.com.plasmodium.util.Utils;

public class MySQLCampaignDAO implements CampaignDAO{

	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	public void initSQLData(){
		conn = MySQLDAOFactory.createConnection();
		preparedStatement = null;
		resultSet = null;
	}

	@Override
	public void getCampaignList(List<CampaignDTO> campaignList) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getCampanasList);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				CampaignDTO campDTO = new CampaignDTO();
				campDTO.setId(resultSet.getString("id"));
				campDTO.setName(resultSet.getString("name"));
				campDTO.setDescription(resultSet.getString("descripcion"));
				logger.debug("resultSet.getString(descripcion)" + resultSet.getString("descripcion"));
				campaignList.add(campDTO);
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
	}

	@Override
	public CampaignDTO campaignDetail(String campaign) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getCampanasDetail);
			preparedStatement.setInt(1, Integer.parseInt(campaign));
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				CampaignDTO campDetail = new CampaignDTO();
				campDetail.setId(resultSet.getString("id"));
				campDetail.setName(resultSet.getString("name"));
				campDetail.setDescription(resultSet.getString("descripcion"));
				logger.debug("resultSet.getString(name)" + resultSet.getString("name"));
				return campDetail;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return null;
	}

	@Override
	public int addCampaign(CampaignDTO campaign) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.addCampanas);
			preparedStatement.setString(1, campaign.getName());
			preparedStatement.setString(2, campaign.getDescription());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate();
			if(result!=1){
				result = -1;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());

		return 0;
	}

	@Override
	public int updateCampaign(CampaignDTO campaign) {
		initSQLData();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.updateCampanas);
			preparedStatement.setString(1, campaign.getDescription());
			preparedStatement.setString(2,campaign.getName());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			int result  = preparedStatement.executeUpdate();
			logger.debug("Resultado -> " + result);
			if(result > 0){
				return result = 0;
			}
		}catch (Exception e){
			logger.error("Exception " +this.getClass().getSimpleName() + " - " + Utils.getMethodName(), e);
			MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		}
		MySQLDAOFactory.closeConection(conn, this.getClass().getSimpleName() + " - " + Utils.getMethodName());
		return -1;
	}
}