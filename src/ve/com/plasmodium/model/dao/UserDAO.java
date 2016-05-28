package ve.com.plasmodium.model.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ve.com.plasmodium.exception.CustomException;
import ve.com.plasmodium.exception.DAOException;
import ve.com.plasmodium.model.vo.UserVo;
public interface UserDAO {
    public static final Logger logger = Logger.getLogger(UserDAO.class);

	/**
	 * Trae los datos del usuario segun un login suministrado (momento de entrada al sistema)
	 * @param login
	 * @return
	 * @throws DAOException
	 * @throws CustomException
	 */
    public UserVo datosUsuario(String login) throws DAOException, CustomException;
  
    /**
     * 
     * @param user The id of the user
     * @return A object of type UserVo containing all the details of the user
     * @throws DAOException
     * @throws CustomException
     */
    public UserVo datosUsuario(int user) throws DAOException, CustomException;
    
     /**
     * 
     * @param login
     * @return
     * @throws DAOException
     * @throws CustomException
     */
    public UserVo user_datosUsuarios(String login) throws DAOException, CustomException;

	/**
	 * Trae una lista de usuarios  
	 * @param distributer
	 * @param distrib
	 * @return Lista de usuario
	 */
	public List<SelectItem> listaUsuario(List<SelectItem> distributer, short distrib);

	/**
	 * Trae la lista de usuarios que hayan hecho depositos en la compañia 
	 * vendedora especificada  
	 * @param company	La compañia vendedora
	 * @return Lista de usuario	La lista con los Id de los usuarios
	 */
	public List<String> listaUsuarioRecargasElect(Short company);
	
	/**
	 * Trae la informacion de un usuario seleccionado
	 * @param userIDS
	 * @return Objeto UserVo
	 */
	public UserVo usuarioDetail(short userIDS);

	/**
	 * Cambia informacion de un usuario en especifico del sistema
	 * @param company 
	 * @param user
	 * @param doc
	 * @param login
	 * @param name
	 * @param mail
	 * @param cargo
	 * @param level
	 * @param serviceCompany 
	 * @param pass
	 * @return Valor boolean 
	 */
	public boolean changeUser(Short company, String user, String doc, String login, String name, String mail, String cargo, String level, List<String> serviceCompany, String pass, String max_unsettled_balance, String max_selling_amount, String max_days_card_unsettled);

	/**
	 * Desactiva un usuario especifio del sistema
	 * @param user
	 * @return Valor boolean
	 */
	public boolean deleteUser(String user, boolean operacion);

	/**
	 * Agrega un usuario al sistema
	 * @param company
	 * @param employer
	 * @param doc
	 * @param login
	 * @param name
	 * @param mail
	 * @param cargo
	 * @param level
	 * @param pass
	 * @return Valor boolean
	 */
	public int addUser(short company, String employer, String doc, String login, String name, String mail, String cargo, String level, String pass);

	/**
	 * Valida clave actual del usuario
	 * @param login
	 * @param pwd
	 * @return Valos boolean
	 */
	public boolean validatePassword(String login, String pwd);

	/**
	 * Actualiza la clave del usuario
	 * @param login
	 * @param pwdNew
	 * @return Valor boolean
	 */
	public boolean updatePass(String login, String pwdNew);

	
	public List<SelectItem> getUsersToApprove(Short company, Short state, Integer municipality, Integer city);
  
	public List<SelectItem> getLevels(short level);
	
	/** Return the level that must be assigned to every new not approved user
	  * @return An int representing the level**/
	public Short getNewUsersLevel();

	public float getDeduction(short company);

	public List<SelectItem> getPendingStates(Short company);
	
	public List<SelectItem> getPendingMunicipalities(Short company, Short state);
	
	public List<SelectItem> getPendingCities(Short company, Short state, Integer municipality);

	public List<SelectItem> getServiceCompany(Short company);

	public boolean approveUser(short company, String user, String level,
			List<String> serviceCompany, String max_unsettled_balance,
			String max_selling_amount, String max_days_card_unsettled);
	
	public List<String> getAuthorizedApproversMailList(Short company);

	public List<String> getAuthorizedDepApproversMailList(Short company);

	public boolean validUserExist(String login);
}
