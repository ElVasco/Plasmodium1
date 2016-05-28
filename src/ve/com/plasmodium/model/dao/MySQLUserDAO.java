package ve.com.plasmodium.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.exception.DAOException;
import ve.com.plasmodium.model.vo.UserVo;

public class MySQLUserDAO implements UserDAO {

	public UserVo user_datosUsuarios(String login) throws DAOException, CustomException {
		return null;
	}

	public UserVo datosUsuario(String login) throws DAOException, CustomException {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;

		UserVo userVo = null;	 
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.SELECT_USER);
			preparedStatement.setString(1, login);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			if (resulSet.next()) {
				//System.out.println("Trajo un registro de user");
				userVo = new UserVo();
				logger.debug("apenas corro el query, user es: "+resulSet.getShort("A.user"));
				userVo.setUser(resulSet.getInt("A.user"));
				userVo.setClient(resulSet.getInt("A.client"));
				userVo.setDoc(resulSet.getString("A.doc"));
				userVo.setName(resulSet.getString("A.name"));
				userVo.setLastname(resulSet.getString("A.lastname"));
				userVo.setEmail(resulSet.getString("A.email"));
				userVo.setJobtitle(resulSet.getString("A.jobtitle"));
				userVo.setLevel(resulSet.getShort("A.level"));
				userVo.setLogin(resulSet.getString("A.login"));
				userVo.setPwd(resulSet.getBytes("A.pwd_web"));
				userVo.setPassword(resulSet.getString("A.pwd_web"));
				//userVo.setPassword(resulSet.getString("A.password"));
				userVo.setActive(resulSet.getBoolean("A.active"));
				userVo.setVersion(resulSet.getLong("A.version"));
				userVo.setEmployer(resulSet.getShort("A.employer"));
				userVo.setCompany(resulSet.getShort("A.company"));
				userVo.setNameCompany(resulSet.getString("B.name"));
				userVo.setIs_distributer(resulSet.getBoolean("B.is_Distributer"));
				userVo.setRoute(resulSet.getShort("A.route"));
			} else {
				System.out.println("no trajo registros");
				userVo = null;
			}
			if(userVo!=null){
			preparedStatement = null;
			preparedStatement = conn.prepareStatement(SQLConstant.GET_MASTER_CLIENT);
			preparedStatement.setInt(1, userVo.getCompany());
			preparedStatement.setInt(2, userVo.getClient());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = null;
			resulSet = preparedStatement.executeQuery();
			if (resulSet.next()) {				
				userVo.setMasterClient(resulSet.getInt(1));	
				logger.debug("El MasterClient es: " + userVo.getMasterClient());
			} else {
				System.out.println("no trajo registros en getMasterClient");
				userVo = null;
			}
			}			
		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - datosUsuario ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - datosUsuario - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return userVo;
	}

	public UserVo datosUsuario(int user) throws DAOException, CustomException {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;

		UserVo userVo = null;	 
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.SELECT_USER2);
			preparedStatement.setInt(1, user);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			if (resulSet.next()) {
				//System.out.println("Trajo un registro de user");
				userVo = new UserVo();
				logger.debug("apenas corro el query, user es: "+resulSet.getShort("A.user"));
				userVo.setUser(resulSet.getInt("A.user"));
				userVo.setClient(resulSet.getInt("A.client"));
				userVo.setDoc(resulSet.getString("A.doc"));
				userVo.setName(resulSet.getString("A.name"));
				userVo.setLastname(resulSet.getString("A.lastname"));
				userVo.setEmail(resulSet.getString("A.email"));
				userVo.setJobtitle(resulSet.getString("A.jobtitle"));
				userVo.setLevel(resulSet.getShort("A.level"));
				userVo.setLogin(resulSet.getString("A.login"));
				userVo.setPwd(resulSet.getBytes("A.pwd_web"));
				userVo.setPassword(resulSet.getString("A.pwd_web"));
				//userVo.setPassword(resulSet.getString("A.password"));
				userVo.setActive(resulSet.getBoolean("A.active"));
				userVo.setVersion(resulSet.getLong("A.version"));
				userVo.setEmployer(resulSet.getShort("A.employer"));
				userVo.setCompany(resulSet.getShort("A.company"));
				userVo.setNameCompany(resulSet.getString("B.name"));
				userVo.setIs_distributer(resulSet.getBoolean("B.is_Distributer"));
				userVo.setRoute(resulSet.getShort("A.route"));
			} else {
				System.out.println("no trajo registros");
				userVo = null;
			}
			if(userVo!=null){
			preparedStatement = null;
			preparedStatement = conn.prepareStatement(SQLConstant.GET_MASTER_CLIENT);
			preparedStatement.setInt(1, userVo.getCompany());
			preparedStatement.setInt(2, userVo.getClient());
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = null;
			resulSet = preparedStatement.executeQuery();
			if (resulSet.next()) {				
				userVo.setMasterClient(resulSet.getInt(1));	
				logger.debug("El MasterClient es: " + userVo.getMasterClient());
			} else {
				System.out.println("no trajo registros en getMasterClient");
				userVo = null;
			}
			}			
		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - datosUsuario ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - datosUsuario - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return userVo;
	}

	public List<SelectItem> listaUsuario(short distributer) {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <SelectItem> userList = new ArrayList<SelectItem>();
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.Usuarios);
			preparedStatement.setShort(1, distributer);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			//		    Short company = 9999; // Will means Distributer null so user need to select a distributer from the dropdown box
			String descriptionUser ="Seleccione un Usuario";
			String userIdString = "9999"; // Will means Distributer null so user need to select a distributer from the dropdown box
			userList.add(new SelectItem(userIdString, descriptionUser));
			while (resulSet.next()) {

				userIdString = resulSet.getString(1);
				descriptionUser = resulSet.getString(2);
				userList.add(new SelectItem(userIdString, descriptionUser));
			}    

		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - listaUsuario ", e);
		}
		return userList;

	}

	/** Return the level that must be assigned to every new not approved user
	  * @param company	The company where the user will work 
	  * @return An int representing the level
	  **/
	public Short getNewUsersLevel() {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		Short level = 45;
		try {
			String query = "SELECT level FROM sec_level_profile AS lp" +
					" JOIN sec_profile_rol AS pr ON lp.profile=pr.profile" +
					" JOIN sec_rol AS rol ON pr.rol=rol.rol" +
					" WHERE rol.rol_name='IS_NON_APPROVED_USER';"; 
			preparedStatement = conn.prepareStatement(query);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			if (resulSet.next()) 
				level = resulSet.getShort(1);
			    
		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - getNewUsersLevel ", e);
		}
		return level;
	}

	public UserVo usuarioDetail(short userIDS) {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UserVo result = null;

		try {
			preparedStatement = conn.prepareStatement(SQLConstant.UsuarioDetail);
			preparedStatement.setShort(1, userIDS);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = new UserVo (resultSet.getInt("u.user"), resultSet.getString("u.doc"), resultSet.getString("u.name") , resultSet.getString("u.lastname"), resultSet.getString("u.email"), resultSet.getString("u.jobtitle"), resultSet.getShort("u.level"),resultSet.getString("u.login"),resultSet.getString("i.description"));
				result.setActive(resultSet.getBoolean("u.active"));	
			}

		}catch (Exception e) {
			logger.error("Exception MySQLUserDAO - usuarioDetail ", e);
		}
		return result;
	}

	public List<SelectItem> listaUsuario(List<SelectItem> distributer, short distrib) {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <SelectItem> userList = new ArrayList<SelectItem>();
		String select, query, where;
		select = "SELECT user, name FROM user ";
		where=" WHERE employer IN( ";
		String descriptionUser;
		String userIdString ;


		if(distrib==999){
			for(int i=1;i<distributer.size();i++){
				if(distributer.get(i).getValue().toString().compareTo("999")==0){
					where=where+" 5 ";//hardcode distribuidor maestro 5
				}else{
					if(i!=1)
						where=where+" , ";
					where=where+distributer.get(i).getValue().toString();
				}
			}
		}else{
			where=where+distrib;
		}

		where=where+")";
		where+=distrib==1?" AND level=12":"";
		query=select+where;
		try{
			descriptionUser ="Seleccione un usuario";			
			userIdString = "9999";
			userList.add(new SelectItem(userIdString, descriptionUser));
			preparedStatement = conn.prepareStatement(query);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				userIdString=resulSet.getString(1);
				descriptionUser=resulSet.getString(2);
				//				logger.debug("llenando lista con usuarios  " + userId + " " + descriptionUser);
				userList.add(new SelectItem(userIdString, descriptionUser));
			}
			/*if(distrib!=999){
		    descriptionUser ="Agregar nueva Usuario...";
		    userId=999;
		    userList.add(new SelectItem(userId, descriptionUser));
			}*/
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - listaUsuario ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - listaUsuario - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return userList;
	}

	/** Obtain all the users that have made a deposit from the specified seller company **/
	public List<String> listaUsuarioRecargasElect(Short company) {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <String> userList = new ArrayList<String>();
		String query;
		query  = "SELECT distinct eu.company, eu.user " +
				"FROM user AS eu LEFT JOIN deposit AS dep ON dep.deposit_usr=eu.user " +
				"WHERE eu.company = "+company+" AND dep.deposit_usr IS NOT NULL;";
		String userIdString ;

		try{
			preparedStatement = conn.prepareStatement(query);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				userIdString=resulSet.getString(2);
				//logger.debug("llenando lista con usuarios  " + userId);
				userList.add(userIdString);
			}
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - listaUsuarioRecargasElect ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - listaUsuarioRecargasElect - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return userList;
	}
	
	public List<SelectItem> getUsersToApprove(Short company, Short state, Integer municipality, Integer city) {
		logger.debug("entro al getUsersToApprove en MySQLUserDAO \n");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <SelectItem> userList = new ArrayList<SelectItem>();
		String descriptionUser;
		String userIdString;
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.usersToApprove);
			preparedStatement.setShort(1, company);
			preparedStatement.setShort(2, state);
			preparedStatement.setInt(3, municipality);
			preparedStatement.setInt(4, city);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				userIdString=resulSet.getString(1);
				descriptionUser=resulSet.getString(2) + " " + resulSet.getString(3);
				userList.add(new SelectItem(userIdString, descriptionUser));
			}
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getUsersToApprove ", e);
		}
		return userList;
	}

	public List<SelectItem> getLevels(short level) {
		logger.debug("entro al getLevels en MySQLUserDAO \n");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <SelectItem> levelList = new ArrayList<SelectItem>();
		String descriptionUser;
		Short userId;
		String userIdString;
		Short i=0;
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getLevels);
			preparedStatement.setShort(1, level);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				i++;
				userId=resulSet.getShort(1);
				descriptionUser=userId + " - " + resulSet.getString(2);
				userIdString = userId+"";
				levelList.add(new SelectItem(userIdString, descriptionUser));
			}
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getLevels ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getLevels - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return levelList;
	}

	public boolean approveUser(short company, String user, String level,List<String> serviceCompany, String max_unsettled_balance,String max_selling_amount, String max_days_card_unsettled){
		boolean result = false;
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		String query ="UPDATE client SET date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))) WHERE client = (SELECT client FROM user WHERE company=? AND user = ?)";
		try {
			for(int i=0;serviceCompany.size()>i;i++){
				preparedStatement = null;
				preparedStatement = conn.prepareStatement(SQLConstant.insertUserArrangement);
				preparedStatement.setShort(1, company);
				preparedStatement.setString(2, user);
				preparedStatement.setString(3, serviceCompany.get(i));
				logger.debug("Statement a ejecutarse " + preparedStatement.toString());
				result = preparedStatement.executeUpdate()==1;
			}
			preparedStatement = null;
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setShort(1, company);
			preparedStatement.setShort(2, company);
			preparedStatement.setString(3, user);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate()==1;

			query ="UPDATE user SET level=?, active="+(level.compareTo("999")!=0);
			if(max_unsettled_balance.compareTo("0")!=0) 
				query += ", max_unsettled_balance=?, max_selling_amount=?, max_days_card_unsettled=? ";
			query += " WHERE company=? AND user=?";
			preparedStatement = conn.prepareStatement(query);
			if(max_unsettled_balance.compareTo("0")!=0) {
				preparedStatement.setString(1, level);
				preparedStatement.setString(2, max_unsettled_balance);
				preparedStatement.setString(3, max_selling_amount);
				preparedStatement.setString(4, max_days_card_unsettled);
				preparedStatement.setShort(5, company);
				preparedStatement.setString(6, user);
			}else{
				preparedStatement.setString(1, level);
				preparedStatement.setShort(2, company);
				preparedStatement.setString(3, user);
			}
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate()==1;
		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - approveUser ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - approveUser ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;		
	}

	public boolean changeUser(Short company, String user, String doc, String login, String name, String mail, String cargo, String level, List<String> serviceCompany, String pass, String max_unsettled_balance, String max_selling_amount, String max_days_card_unsettled) {
		logger.debug("el max_unsettled_balance es : " + max_unsettled_balance);
		boolean result = true;
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		String select, query, where;
		select="update user set doc=?,login=?,name=?,email=?,jobtitle=?,level=?,active=true";
		if(max_unsettled_balance.compareTo("")!=0) {
			select+=", max_unsettled_balance=?, max_selling_amount=?, max_days_card_unsettled=?";
		}
		if(pass.compareTo("2222")!=0  && pass.compareTo("")!=0){
			select=select+",pwd_web=md5(?) ";
		}
		where=" where user=?";
		query=select+where;
		try {
			/*for(int i=0;serviceCompany.size()>i;i++){
				preparedStatement = null;
				preparedStatement = conn.prepareStatement(SQLConstant.insertUserArrangement);
				preparedStatement.setShort(1, company);
				preparedStatement.setString(2, user);
				preparedStatement.setString(3, serviceCompany.get(i));
				result = preparedStatement.executeUpdate()==1;
			}*/
			if(result){
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, doc);
				preparedStatement.setString(2, login);
				preparedStatement.setString(3, name);
				preparedStatement.setString(4, mail);
				preparedStatement.setString(5, cargo);
				preparedStatement.setString(6, level);
				if(max_unsettled_balance.compareTo("")!=0) {
					preparedStatement.setString(7, max_unsettled_balance);
					preparedStatement.setString(8, max_selling_amount);
					preparedStatement.setString(9, max_days_card_unsettled);
					if(pass.compareTo("2222")!=0 && pass.compareTo("")!=0){
						preparedStatement.setString(10, pass);
						preparedStatement.setString(11, user);
					}else{
						preparedStatement.setString(10, user);
					}
				} else {
					if(pass.compareTo("2222")!=0 && pass.compareTo("")!=0){
						preparedStatement.setString(7, pass);
						preparedStatement.setString(8, user);
					}else{
						preparedStatement.setString(7, user);
					}
				}
				logger.debug("Statement a ejecutarse " + preparedStatement.toString());
				result = preparedStatement.executeUpdate()==1;

			}
		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - changeUser ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - changeUser ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}


	public boolean deleteUser(String user, boolean operacion) {
		boolean result = false;
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.DeleteUser);
			preparedStatement.setBoolean(1, operacion);
			preparedStatement.setString(2, user);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate()==1;

		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - deleteUser ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - deleteUser - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}

	public int addUser(short company, String employer, String doc, String login, String name, String mail, String cargo, String level, String pass) {
		int result = 0;
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.AddUser);
			preparedStatement.setShort(1, company);
			preparedStatement.setString(2, employer);
			preparedStatement.setString(3, doc);
			preparedStatement.setString(4, name);
			preparedStatement.setString(5, mail);
			preparedStatement.setString(6, cargo);
			preparedStatement.setString(7, level);
			preparedStatement.setString(8, login);
			preparedStatement.setString(9, pass);

			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate();
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e){
			logger.error("MySQLIntegrityConstraintViolationException MySQLUserDAO - addUser ", e);
			result = -1;
		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - addUser ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - addUser - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}

	public boolean updatePass(String login, String pwdNew) {
		boolean result = false;
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.updatePwd);
			preparedStatement.setString(1, pwdNew);
			preparedStatement.setString(2, login);

			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			result = preparedStatement.executeUpdate()==1;

		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - updatePass ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - updatePass - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;  
	}

	public boolean validatePassword(String login, String pwd) {
		boolean result = false;
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.validateUser);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, pwd);

			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();
			result = resultSet.next();

		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - validatePassword ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - validatePassword - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}

	public float getDeduction(short company) {
		float result = 1;
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement(SQLConstant.getDeduction);
			preparedStatement.setShort(1, company);

			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				result = resultSet.getFloat(1);
			}

		} catch (Exception e) {
			logger.error("Exception MySQLUserDAO - getDeduction ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getDeduction - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}

	public List<SelectItem> getPendingStates(Short company) {
		logger.debug("entro a getPendingStates en MySQLUserDAO \n");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <SelectItem> stateList = new ArrayList<SelectItem>();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.pendingStates);
			preparedStatement.setShort(1, company);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				stateList.add(new SelectItem(resulSet.getString(1), resulSet.getString(2)+" ("+resulSet.getString(3)+")"));
			}
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getPendingStates ", e);
		}

		return stateList;
	}

	public List<SelectItem> getPendingMunicipalities(Short company, Short state) {
		logger.debug("entro a getPendingMunicipalities en MySQLUserDAO \n");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <SelectItem> municipalityList = new ArrayList<SelectItem>();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.pendingMunicipalities);
			preparedStatement.setShort(1, company);
			preparedStatement.setShort(2, state);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				municipalityList.add(new SelectItem(resulSet.getString(1), resulSet.getString(2)+" ("+resulSet.getString(3)+")"));
			}
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getPendingMunicipalities ", e);
		}

		return municipalityList;
	}

	public List<SelectItem> getPendingCities(Short company, Short state, Integer municipality) {
		logger.debug("entro a getPendingCities en MySQLUserDAO \n");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <SelectItem> cityList = new ArrayList<SelectItem>();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.pendingCities);
			preparedStatement.setShort(1, company);
			preparedStatement.setShort(2, state);
			preparedStatement.setInt(3, municipality);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				cityList.add(new SelectItem(resulSet.getString(1), resulSet.getString(2)+" ("+resulSet.getString(3)+")"));
			}
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getPendingCities ", e);
		}

		return cityList;
	}

	public List<String> getAuthorizedApproversMailList(Short company) {
		logger.debug("entro a getAuthorizedApproversMailList en MySQLUserDAO \n");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <String> mailList = new ArrayList<String>();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.authorizedApproversMailList);
			preparedStatement.setShort(1, company);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				mailList.add(resulSet.getString(1));
			}
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getAuthorizedApproversMailList ", e);
		}
		return mailList;
	}
	
	public List<String> getAuthorizedDepApproversMailList(Short company) {
		logger.debug("entro a getAuthorizedApproversMailList en MySQLUserDAO \n");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List<String> mailList = new ArrayList<String>();
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.authorizedDepApproversMailList);
			preparedStatement.setShort(1, company);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				mailList.add(resulSet.getString(1));
			}
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getAuthorizedApproversMailList ", e);
		}
		return mailList;
	}

	public List<SelectItem> getServiceCompany(Short company) {
		logger.debug("entro al getServiceCompany en MySQLUserDAO \n");
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		List <SelectItem> serviceCompany = new ArrayList<SelectItem>();
		String descriptionUser;
		Short userId;
		String userIdString;
		Short i=0;
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.getServiceCompany);
			preparedStatement.setShort(1, company);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()){
				i++;
				userId=resulSet.getShort(1);
				descriptionUser=userId + " - " + resulSet.getString(2);
				userIdString = userId+"";
				serviceCompany.add(new SelectItem(userIdString, descriptionUser));
			}
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getServiceCompany ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getLevels - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return serviceCompany;
	}


	public boolean validUserExist(String login) {
		final Connection conn = MySQLDAOFactory.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resulSet = null;
		boolean result=false;
		try{
			preparedStatement = conn.prepareStatement(SQLConstant.validateUserExist);
			preparedStatement.setString(1, login);
			logger.debug("Statement a ejecutarse " + preparedStatement.toString());
			resulSet = preparedStatement.executeQuery();
			if (resulSet.next()) 
				result = resulSet.getInt(1)==0;
		}catch(Exception e){
			logger.error("Exception MySQLUserDAO - validUserExist ", e);
		}
		try {
			conn.close();
		}catch (Exception e){
			logger.error("Exception MySQLUserDAO - getLevels - close ", e);
			new DAOException(SQLConstant.ERROR_CONNECTION, e.getCause());
		}
		return result;
	}
}

