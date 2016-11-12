package ve.com.plasmodium.model.dao;

import org.apache.log4j.Logger;

/**
 * @author Serprog, S.A Leonardo Djekki R.
 * 
 * Esta clase contiene todas las instrucciones SQL utilizada por la aplicacion,
 * esto permite un menejo centralizado de las mismas y un mejor mantenimiento.
 * 
 * Esta clase tambien contiene todos los mensajes de error utilizados en el proceso
 * de acceso de los datos.
 *   
 */
public final class SQLConstant { 

	public static final Logger logger = Logger.getLogger(SQLConstant.class);


	private SQLConstant(){
		//This ensures that nobody can subclass the GlobalValues AND override the functionality
	}

	// List of DAO types supported BY the DAO factoy
	public final static short MYSQL = 1;
	public final static short DB2 = 2;

	public final static String  ERROR_DELETE = "NO SE PUEDE ELIMINAR EL REGISTRO.";
	public final static String  ERROR_UPDATE = "IMPOSIBLE ACTUALIZAR EL REGISTRO.";
	public final static String  ERROR_INSERT = "IMPOSIBLE INSERTAR REGISTRO.";
	public final static String  ERROR_FIND = "NO SE HA ENCONTRADO EL REGISTRO/REGISTROS REQUERIDO.";
	public final static String  ERROR_COUNT = "ERROR AL DETERMINAR CANTIDAD DE REGISTROS.";
	public final static String  ERROR_NAMING = "ERROR DE CONFIGURACION CON JNDI Y DATASOURCE.";
	public final static String  ERROR_CONNECTION = "ERROR NO SE PUEDE OBTENER CONEXION JNDI DESDE EL DATASOURCE.";
	public final static String  ERROR_CLOSING_CONNECTION = "ERROR AL CERRAR CONEXION LUEGO DE ACTUALIZAR REGISTRO.";
	public final static String  ERROR_ROLLBACK = "ERROR AL EJECUTAR ROLLBACK. VERIFIQUE SI SUS ULTIMOS CAMBIOS FUERON TOMADOS EN CUENTA.";
	public final static String  ERROR_AUTOCOMMIT = "ERROR AL DESACTIVAR EL AUTOCOMMIT.";
	public final static String  ERROR_CLOSING_STATEMENT = "ERROR AL CERRAR PREPARE STATEMENT.";
	public final static String  ERROR_FINALLY= "ERROR AL REALIZAR FINALIZACION DE OBJETOS DE CONEXION.";
	public final static String  ERROR_UPDATE_CUENTAS = "IMPOSIBLE ACTUALIZAR CUENTAS ASOCIADAS A LOS MOVIMIENTOS";


	public final static String CUSTOM_MESSAGE_INVENTARIO_FIND = "Oficina no posee la divisa requerida. Verifique transaccion y/o solicite a centro de acopio asignacion de divisa.";
	public final static String  CUSTOM_MESSAGE_DISPONIBILIDAD = "No Existe disponibilidad para la transaccion. Intente monto o denominacion diferente. Consulte Inventario.";
	public final static String  CUSTOM_MESSAGE_FALLO_VENTA = "Ocurrio un problema a nivel de Base de Datos al tratar de realizar la Venta. La venta no se realizo.";
	public final static String  CUSTOM_MESSAGE_FALLO_COMPRA = "Ocurrio un problema a nivel de Base de Datos al tratar de realizar la Compra. La compra no se realizo.";
	public final static String CUSTOM_MESSAGE_SIN_DISPONIBILIDAD_MONTO = "Saldo disponible no es suficiente para realizar asignacion. Consulte Inventario Consolidado";
	public final static String CUSTOM_MESSAGE_SIN_DISPONIBILIDAD_DENOMINACION = " Revise las denominaciones usadas en la Asignacion. Consulte Inventario Consolidado";
	public final static String CUSTOM_MESSAGE_FALLO_DEBITO = "Ocurrio un problema al intentar realizar el debito de la cuenta";
	public final static String CUSTOM_MESSAGE_FALLO_CREDITO = "Ocurrio un problema al intentar realizar el credito de la cuenta";
	public final static String CUSTOM_MESSAGE_FALLO_ASIENTOS = "Fallo el proceso de realizar los asientos ";
	public final static String CUSTOM_MESSAGE_NO_POSIBLE = "No es posible realizar el movimiento ";
	public final static String CUSTOM_MESSAGE_CLIENTE_NO_EXISTE = "Cliente no Existe. Por favor verifique que el numero de Cedula / RIF sea el correcto he intente nuevamente. Primer caracter debe ir en mayuscula ";
	public final static String  CUSTOM_MESSAGE_ACTUALIZACION = "Ocurrio un problema al intentar actualizar con la informacion suministrada";
	public final static String  CUSTOM_MESSAGE_DESCONOCIDO = "Transaccion no fue realizada. Ocurrio un error. ";
	public final static String  CUSTOM_MESSAGE_MONTO_DECIMAL = ": Verifique que utiliza Un Punto para indicar los decimales, que el monto comienza con un numero y que no incluyo mas de un punto";
	public final static String  CUSTOM_MESSAGE_MONTO_CERO = ": Monto no puede ser cero. Verifique que introdujo el numero de unidades de al menos una denominacion ";
	public final static String  CUSTOM_MESSAGE_COMENTARIO_LONGITUD = ": La longitud del campo excede el maximo fijado que es 45 caracteres. El numero actual de caracteres en el campo es de : ";
	/////////   Inicio instrucciones SQL para DB local usando MySQL    /////////  	


	//String referencia, String codigotransaccion, String banco, String oficinaorigen, String oficinadestino, String moneda, String cuentacontable, String cuentaibs, String debito, String credito, String descripcion
	/**
	 * Instruccion SQL para insertar asiento.
	 */
	protected final static String INSERT_ASIENTO =
			"INSERT INTO asientosimde (refere, banco, ofcorg, ofcdes, moneda, ctacon, ctacli, valor, concep, fecpro, tipmov, mone01 ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";		


	//String referencia, String codigotransaccion, String banco, String oficinaorigen, String oficinadestino, String moneda, String cuentacontable, String cuentaibs, String debito, String credito, String descripcion
	/**
	 * Instruccion SQL para insertar asignacion de  divisa a oficina en tabla asignacion.
	 */
	protected final static String UPDATE_STATUS_ASIGNACION =
			"UPDATE asignacion SET  STATUS=? WHERE ID=?";

	/** 
	 * Instruccion SQL para insertar una compra de divisa.
	 */
	protected final static String INSERT_COMPRA =
			"INSERT INTO compra (AGENCIA, CEDULA, NOMBRE, CUENTACLIENTE, SECTOR, ACTIVIDAD, FONDOSPROVIENEN, DIVISASDESTINO, MONEDA, INSTRUMENTO, TIPOCAMBIO, MONTO, MONTOUNO, MONTOCINCO, MONTODIEZ, MONTOVEINTE, MONTOCINCUENTA, MONTOCIEN, MONTODOSCIENTOS, MONTOQUINIENTOS, VERSION, REFERENCIA ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE(),? )";	


	protected final static String DELETE_SOLICITUD_EFECTIVO_BY_KEY 	=
			"DELETE FROM solicitud WHERE ID = ?";


	protected final static String SELECT_COMPRA_LEGITIMACION 	=
			"SELECT  AGENCIA, CEDULA, NOMBRE, CUENTACLIENTE, ACTIVIDAD, FONDOSPROVIENEN, DIVISASDESTINO, MONEDA, TIPOCAMBIO, MONTO, VERSION, REFERENCIA FROM compra";



	protected final static String SELECT_COMPRA_BY_DATE =
			// "SELECT AGENCIA, CEDULA, NOMBRE, CUENTACLIENTE, ACTIVIDAD, FONDOSPROVIENEN, DIVISASDESTINO, MONEDA, TIPOCAMBIO, MONTO, VERSION, REFERENCIA FROM compra WHERE( version >= date('2008-06-01 00:00:00') AND version < date('2008-07-01 00:00:00'))";
			"SELECT AGENCIA, CEDULA, NOMBRE, CUENTACLIENTE, ACTIVIDAD, FONDOSPROVIENEN, DIVISASDESTINO, MONEDA, TIPOCAMBIO, MONTO, VERSION, REFERENCIA FROM compra WHERE( version >= date(?) AND version < date(?))";



	protected final static String SELECT_VENTA_BY_DATE =
			"SELECT AGENCIA, CEDULA, NOMBRE, CUENTACLIENTE, ACTIVIDAD, FONDOSPROVIENEN, DIVISASDESTINO, MONEDA, TIPOCAMBIO, MONTO, VERSION, REFERENCIA FROM venta WHERE( version >= date(?) AND version < date(?))";


	/**
	 * Instruccion SQL para actualizar registro en tabla asientoconfig con los valores de las cuentas
	 * contables asociadas a los asientos
	 */	
	protected final static String UPDATE_TASAS =
			"UPDATE asientoconfig SET  USDCOMISIONFIJAVENTA=?, USDCOMISIONFIJACOMPRA=?, USDPORCENTAJECOMISIONVARIABLE=?, USDTCCOMPRA=?, USDTCVENTA=?, EURCOMISIONFIJAVENTA=?, EURCOMISIONFIJACOMPRA=?, EURPORCENTAJECOMISIONVARIABLE=?, EURTCCOMPRA=?, EURTCVENTA=?, USDCOMISIONBCV=?, EURCOMISIONBCV=?, VERSION=SYSDATE()  WHERE STATUS=?";


	/**
	 * Instruccion SQL para actualizar registro en tabla inventario, previamente
	 *  se debera leer la tabla para determinar los valores en los campos que va a actualizar
	 *  y proceder a realizar la suma o resta en los campos, de acuerdo a a la logica de negocio
	 */	
	protected final static String UPDATE_INVENTARIO =
			"UPDATE inventario SET  DEBE=?, HABER=?, SALDO=?, STATUS=?, VERSION=SYSDATE(), MONTOUNO=?, MONTOCINCO=?, MONTODIEZ=?, MONTOVEINTE=?, MONTOCINCUENTA=?, MONTOCIEN=?, MONTODOSCIENTOS=?, MONTOQUINIENTOS=? WHERE AGENCIA=? AND MONEDA=? AND INSTRUMENTO=?";




	protected final static String SELECT_INVENTARIO_ALL =
			"SELECT ID, AGENCIA, MONEDA, INSTRUMENTO, DEBE, HABER, SALDO, STATUS, VERSION, MONTOUNO, MONTOCINCO, MONTODIEZ, MONTOVEINTE, MONTOCINCUENTA, MONTOCIEN, MONTODOSCIENTOS, MONTOQUINIENTOS FROM inventario ORDER BY (AGENCIA)";

	protected final static String SELECT_INVENTARIO_BY_KEY =
			"SELECT ID, AGENCIA, MONEDA, INSTRUMENTO, DEBE, HABER, SALDO, STATUS, VERSION, MONTOUNO, MONTOCINCO, MONTODIEZ, MONTOVEINTE, MONTOCINCUENTA, MONTOCIEN, MONTODOSCIENTOS, MONTOQUINIENTOS FROM inventario  WHERE ( AGENCIA=?)";



	protected final static String SELECT_ASIGNACION_TRANSITO_BY_KEY =
			"SELECT ID, CENTROACOPIO, OFICINA, MONEDA, INSTRUMENTO, TIPOCAMBIO, MONTO, COMPROBANTESERVICIO, VERSION, STATUS, MONTOUNO, MONTOCINCO, MONTODIEZ, MONTOVEINTE, MONTOCINCUENTA, MONTOCIEN, MONTODOSCIENTOS, MONTOQUINIENTOS FROM asignacion WHERE ( STATUS='transito' AND OFICINA =? ) ORDER BY (INSTRUMENTO)";



	protected final static String SELECT_AUTORIZACION_ALL =
			"SELECT CEDULA, AUTORIZACION, STATUS, MONEDA, MONTO FROM autorizacioncadivi ORDER BY (CEDULA)";



	// Determina si determinado cliente tiene una autorizacion CADIVI cargada y activa en el sistema
	protected final static String COUNT_AUTORIZACIONCADIVI_BY_KEY 	=
			"SELECT COUNT(*)  FROM autorizacioncadivi WHERE CEDULA =? AND STATUS=? ";	

	///////////////////////////////////////////////////////////////////////////
	public final static String SELECT_USER = 
			"SELECT A.id_user,A.num_ident,  A.first_name, A.fist_last_name, A.email, A.position, A.id_level, A.login, A.password, A.active, A.institution, B.name FROM user AS A STRAIGHT_JOIN institution AS B ON A.institution=B.id_institution WHERE  A.login =?;;";

	public final static String SELECT_USER2 = 
			"SELECT A.user, A.client, A.doc,  A.name, A.lastname,  A.email, A.jobtitle, A.level, A.login, A.pwd_web, A.active, A.version, A.company, A.employer, B.name, B.is_distributer, A.route FROM user AS A STRAIGHT_JOIN company AS B  ON A.employer=B.company WHERE  A.user =?;";

	public final static String GET_MASTER_CLIENT = 
			"SELECT getMasterClient(?,?)";

	// Todas las companias que son distribuidoras
	public final static String SELECT_DISTRIBUTER_BY_COMPANY =
			"SELECT A.company, A.name,  A.client_company, A.is_distributer FROM company AS A WHERE  A.is_distributer";

	// Todas las companias distribuidoras hijas del employer del empleado signed en el sistema
	public final static String SELECT_HIJOS_DISTRIBUTER =
			"SELECT A.company, A.name,  A.client_company, A.is_distributer FROM company AS A WHERE A.client_company=? AND  A.is_distributer";

	public final static String Usuarios = 
			"SELECT user, name FROM user WHERE employer=?";

	public final static String UsuarioDetail = 
			"SELECT u.id_user ,u.institution ,u.num_ident ,u.first_name,u.fist_last_name,u.email,u.position,u.id_level,u.login,u.active FROM user AS u WHERE u.id_user=?";

	public final static String DeleteUser = 
			"UPDATE user SET active=? WHERE user=?";

	public static final String getLevels = "SELECT l.level, l.description FROM sec_level_profile AS lp STRAIGHT_JOIN sec_profile_rol AS pr ON lp.profile=pr.profile STRAIGHT_JOIN sec_rol AS r ON r.rol=pr.rol STRAIGHT_JOIN sec_level AS l ON r.rol_name=concat('ASSIGN_LEVEL',l.level) WHERE lp.level=?;";
	
	public static final String getServiceCompany = "SELECT service_company, c.name FROM arrangement AS a STRAIGHT_JOIN company AS c ON a.service_company=c.company WHERE a.seller_company=?;";
			
	public static final String insertUserArrangement = "insert into user_arrangement values (?,?,?);";
	public final static String AddUser = 
			"INSERT INTO user (user,company,employer,doc,name,lastname,email,jobtitle,level,login,valid_to,active,version,pwd_web) VALUE(IF(((SELECT COUNT(*) FROM user AS u1 )>0),(SELECT MAX(user)+1 FROM user AS u2 ),1),?,?,?,?,'C.A',?,?,?,?,CONVERT_TZ('2038-01-17 23:59:59','UTC',(SELECT @@global.system_time_zone)),true,1,md5(?))";
	//Buscar las denominaciones existentes para la compaï¿½ia a partir del company del usuario
	//SELECT p.denom, p.value FROM packing p WHERE p.company=<user.company>

	public final static String SELECT_PACKING_listByCompany = 
			"SELECT p.denom, p.value FROM packing p WHERE p.company=?";

	public static final String validateUser = 
			"SELECT login FROM user WHERE login=? AND pwd_web=MD5(?)";
	
	public static final String validateUserExist = 
			"SELECT count(*) FROM user WHERE login=?";

	public static final String updatePwd = 
			"UPDATE user SET pwd_web=MD5(?) WHERE login=?";


	// ultima version 

	//**********************************************************************AUTHORIZATION *****************************************************************************
	public final static String getAllRoles =
			"SELECT rol_name,rol FROM sec_rol ORDER BY rol";


	//**********************************************************************USER *****************************************************************************
	// -1.- Buscar los datos del usuario (LOGIN)
	// SELECT * FROM user WHERE login='<user_dado>' AND pwd=PASSWORD('<password_dado>');
	public final static String user_datosUsuarios = 
			"SELECT * FROM user WHERE login='?' AND pwd=PASSWORD('?')";

	//**********************************************************************ASIGNACION A DISTRIBUIDORES*****************************************************************************
	// 0.- Buscar los ditribuidores hijos
	// SELECT company, name FROM company WHERE client_company=<user.employer> AND is_distributer=true;
	public final static String distributer_distribuidoresHijos =
			"SELECT company, name FROM company WHERE client_company=? AND is_distributer=true ";

	public final static String distributer_master =
			"(SELECT company, name FROM company WHERE company=?) UNION (SELECT company, name FROM company WHERE client_company=? AND name LIKE 'ALMACEN%' AND is_distributer=true) UNION (SELECT company, name FROM company WHERE client_company=? AND name NOT LIKE 'ALMACEN%' AND is_distributer=true ORDER BY name desc)";
	
	public final static String distributerhijos_master =
			"SELECT company, name FROM company WHERE client_company=? AND is_distributer=true AND name NOT LIKE 'ALMACEN%'";
	
	public final static String distributer_distribuidoresHijos_User =
			"SELECT company, name FROM company WHERE client_company=? AND is_distributer=true AND name NOT LIKE 'A%'";

	public final static String distributer_distribuidoresWarehouse =
			"SELECT company, name  FROM company WHERE company=? OR (client_company=? AND name LIKE 'A%') ORDER BY name DESC;";
	// 1.- Buscar las denominaciones existentes para la compaï¿½ia a partir del company del usuario
	// SELECT p.denom, p.value FROM packing p WHERE p.company=<user.company>
	public final static String distributer_denominaciones =
			"SELECT p.denom, p.value FROM packing p WHERE p.company=?";

	//2.- Buscar rango de  la proxima Tarjeta Disponible para la compaï¿½ia del ususario. (Para el distribuidor normal)
	//SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) FROM (SELECT c.manuf_no AS m_no, p.value AS val FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=<user.company> AND c.distributer IS NULL ORDER BY m_no ASC LIMIT <numero de Tarjetas) AS RESULT;
	public final static String distributer_simpleRangoTarjetasDisponibles =
			"SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) AS bolivares, name AS company, val AS denom FROM (SELECT co.name AS name, manuf_no AS m_no, p.value AS val FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN company AS co ON co.company=? WHERE c.company=? AND c.distributer=? AND c.selling_route IS NULL AND c.bill IS NULL AND c.denom = ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61, 7, 11) AND s.confirmation in (1))=1 ORDER BY m_no ASC LIMIT ?) AS result;";

	public final static String distributer_simpleRangoTarjetasDisponiblesConFacing =
			"SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) AS bolivares, name AS company, val AS denom FROM (SELECT co.name AS name, manuf_no AS m_no, p.value AS val FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN company AS co ON co.company=? WHERE c.company=? AND c.distributer=? AND c.selling_route IS NULL AND c.bill IS NULL AND c.denom = ? AND c.cluster = ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61, 7, 11) AND s.confirmation in (1))=1 ORDER BY m_no ASC LIMIT ?) AS result;";

	//3.- Asignar las Tarjetas al Distribuidor:
	//UPDATE card SET distributer=<distribuidor_seleccionado>, distrib_date=CURDATE(), distrib_usr=<user.user> WHERE company=<user.company> AND distributer IS NULL AND manuf_no BETWEEN <desde> AND <hasta>;
	public final static String distributer_simpleAsignarTarjetasDistribuidor =
			"UPDATE card AS c SET distributer=?, distrib_date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))), distrib_usr=? WHERE company=? AND distributer=? AND selling_route IS NULL AND manuf_no BETWEEN ? AND ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61,7, 11) AND s.confirmation in (1))=1 AND c.denom=?";


	// 4.- Tarjetas Disponibles para Asignar:
	//SELECT c.denom, p.value, COUNT(*), COUNT(*)*p.value FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=<user.company> AND c.distributer IS NULL GROUP BY c.denom;
	public final static String distributer_simpleTarjetasDisponibles = 
			"SELECT c.denom, CONCAT('Cluster ',LPAD(cl.cluster,3,'0'), ' - ',IF(cl.facial IS NULL,CONCAT('Cluster ',LPAD(cl.cluster,3,'0')),cl.facial)) AS facing, p.value, COUNT(*) AS cantidad, COUNT(*)*p.value AS monto, cl.cluster FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN cluster AS cl ON c.company=cl.company AND c.denom=cl.denom AND c.cluster=cl.cluster WHERE c.company=? AND c.distributer=? AND selling_route IS NULL AND bill IS NULL AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61,7, 11) AND s.confirmation in (1))=1 GROUP BY c.denom, facing WITH ROLLUP;";

	public final static String distributer_simpleTarjetasDisponiblesConFacing = 
			"SELECT c.denom, CONCAT('Cluster ',LPAD(cl.cluster,3,'0'), ' - ',IF(cl.facial IS NULL,CONCAT('Cluster ',LPAD(cl.cluster,3,'0')),cl.facial)) AS facing, p.value, COUNT(*) AS cantidad, COUNT(*)*p.value AS monto,  FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN cluster AS cl ON c.company=cl.company AND c.denom=cl.denom AND c.cluster=cl.cluster WHERE c.company=? AND c.distributer=? AND c.cluster=?  AND selling_route IS NULL AND bill IS NULL AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61,7, 11) AND s.confirmation in (1))=1 GROUP BY c.denom, facing WITH ROLLUP;";


	//"SELECT b.bill, b.control_number, ?*(sum(cl.value)-(SELECT sum(cl.value) FROM status AS s STRAIGHT_JOIN bill AS b ON b.deposit=? STRAIGHT_JOIN card AS c ON s.company=c.company AND s.denom=c.denom AND s.cluster=c.cluster AND s.lot=c.lot AND s.sublot=c.sublot AND s.serial=c.serial AND b.bill=c.bill STRAIGHT_JOIN cluster AS cl ON c.company=cl.company AND c.denom=cl.denom AND c.cluster=cl.cluster  WHERE  status between 80 AND 99)), b.bill_date FROM bill AS b STRAIGHT_JOIN card AS c ON b.company=c.company AND b.bill=c.bill STRAIGHT_JOIN cluster AS cl ON c.company=cl.company AND c.denom=cl.denom AND c.cluster=cl.cluster WHERE b.company=? AND b.distributer=? AND b.selling_route=? AND b.deposit =? GROUP BY c.bill";
	//
	//SELECT client_company IS NOT NULL AND 1 =< (SELECT COUNT(company) FROM company WHERE client_company=<company a evaluar>)  FROM COMPANY WHERE company=<company a evaluar>;
	public final static String distributer_isHibrido =
			"SELECT c.client_company IS NULL FROM company AS co STRAIGHT_JOIN company AS c ON c.company=co.client_company WHERE  co.company=?;";
	//"SELECT client_company IS NULL  FROM company WHERE company=?;";

	//LOS PROXIMOS QUERIES SE UTILIZAN EN ASIGANCION AL DISTRIBUIDOR EN EL CASO DE SER UN DISTRIBUIDOR HIBRIDO.

	//6.- Buscar la proxima tarjeta disponible para la el distribuidor hibrido, a partir del usuario. substituye el query2 para los hibridos.
	//SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) FROM (SELECT manuf_no AS m_no, p.value AS val FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=<user.company> AND c.distributer=<user.employer> AND c.selling_route IS NULL ORDER BY m_no ASC LIMIT <num_de_tarjetas>) AS result;
	public final static String distributer_hibridoRangoTarjetasDisponibles =
			"SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) AS bolivares, name AS company, val AS denom FROM (SELECT co.name AS name, manuf_no AS m_no, p.value AS val FROM card AS c  STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN company AS co ON co.company=? WHERE c.company=? AND c.distributer=? AND c.selling_route IS NULL AND c.bill IS NULL AND c.denom = ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (6, 7, 11) AND s.confirmation in (1))=1 ORDER BY m_no ASC LIMIT ?) AS result;";    

	public final static String distributer_hibridoRangoTarjetasDisponiblesConFacing =
			"SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) AS bolivares, name AS company, val AS denom FROM (SELECT co.name AS name, manuf_no AS m_no, p.value AS val FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN company AS co ON co.company=? WHERE c.company=? AND c.distributer=? AND c.selling_route IS NULL AND c.bill IS NULL AND c.denom = ? AND c.cluster = ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (6, 7, 11) AND s.confirmation in (1))=1 ORDER BY m_no ASC LIMIT ?) AS result;";    


	// 7.- Asignar las Tarjetas al Distribuidor HIJO DEL DISTRIBUIDOR HIBRIDO, SUBSTITUYE QUERY3 para los hibridos.
	//UPDATE card SET distributer=<distribuidor_seleccionado>, distrib_date=CURDATE(), distrib_usr=<user.user> WHERE company=<user.company> AND distributer=<user.employer> AND selling_route IS NULL AND manuf_no BETWEEN <desde> AND <hasta>;
	public final static String distributer_hibridoAsignarTarjetasDistribuidor =
			"UPDATE card AS c SET distributer=?, distrib_date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))), distrib_usr=? WHERE company=? AND distributer=? AND selling_route IS NULL AND manuf_no BETWEEN ? AND ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (6,7, 11) AND s.confirmation in (1))=1";

	// 8.- Tarjetas Disponibles en el Distribuidor Hibrido para Asignar: Substituye al query4 para los distribuidores hibridos.
	// SELECT c.denom, p.value, COUNT(*), COUNT(*)*p.value FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=<user.company> AND c.distributer=<user.employer> AND selling_route IS NULL GROUP BY c.denom;
	public final static String distributer_hibridoTarjetasDisponibles = 
			"SELECT c.denom, CONCAT('Cluster ', cl.cluster, ' - ', IF(cl.facial IS NULL,CONCAT('Cluster ',cl.cluster),cl.facial)) AS facing, p.value, COUNT(*) AS cantidad, COUNT(*)*p.value AS monto, cl.cluster FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN cluster AS cl ON c.company=cl.company AND c.denom=cl.denom AND c.cluster=cl.cluster WHERE c.company=? AND c.distributer=? AND selling_route IS NULL AND bill IS NULL AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (6,7, 11) AND s.confirmation in (1))=1 GROUP BY c.denom, facing WITH ROLLUP;";

	public final static String distributer_hibridoTarjetasDisponiblesConDenom = 
			"SELECT c.denom, CONCAT('Cluster ', cl.cluster, ' - ', IF(cl.facial IS NULL,CONCAT('Cluster ',cl.cluster),cl.facial)) AS facing, p.value, COUNT(*) AS cantidad, COUNT(*)*p.value AS monto, cl.cluster FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN cluster AS cl ON c.company=cl.company AND c.denom=cl.denom AND c.cluster=cl.cluster WHERE c.company=? AND c.distributer=? AND c.denom=? AND selling_route IS NULL AND bill IS NULL AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (6,7, 11) AND s.confirmation in (1))=1 GROUP BY c.denom, facing WITH ROLLUP;";

	public final static String distributer_hibridoTarjetasDisponiblesConFacing = 
			"SELECT c.denom, CONCAT('Cluster ', cl.cluster, ' - ', IF(cl.facial IS NULL,CONCAT('Cluster ',cl.cluster),cl.facial)) AS facing, p.value, COUNT(*) AS cantidad, COUNT(*)*p.value AS monto  FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN cluster AS cl ON c.company=cl.company AND c.denom=cl.denom AND c.cluster=cl.cluster WHERE c.company=? AND c.distributer=? AND c.cluster=? AND selling_route IS NULL AND bill IS NULL AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (6,7, 11) AND s.confirmation in (1))=1 GROUP BY c.denom, facing WITH ROLLUP;";

	public final static String distributer_hibridoTarjetasDisponiblesConFacingConDenom = 
			"SELECT c.denom, CONCAT('Cluster ', cl.cluster, ' - ', IF(cl.facial IS NULL,CONCAT('Cluster ',cl.cluster),cl.facial)) AS facing, p.value, COUNT(*) AS cantidad, COUNT(*)*p.value AS monto  FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN cluster AS cl ON c.company=cl.company AND c.denom=cl.denom AND c.cluster=cl.cluster WHERE c.company=? AND c.distributer=? AND c.denom=? AND c.cluster=? AND selling_route IS NULL AND bill IS NULL AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (6,7, 11) AND s.confirmation in (1))=1 GROUP BY c.denom, facing WITH ROLLUP;";
	
	public final static String addAssignment = "INSERT INTO assignment (company, user, FROM_distributer,  to_distributer, to_route, denom, FROM_manuf_no, to_manuf_no, date, is_assignment) values(?,?,?,?,NULL,?,?,?,DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))),?);";
	public final static String addAssignmentRoute = "INSERT INTO assignment (company, user, FROM_distributer,  to_distributer, to_route, denom, FROM_manuf_no, to_manuf_no, date, is_assignment) values(?,?,?,?,?,?,?,?,DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))),?);";

	
	public final static String delete_status_reversodistributer=
			"DELETE FROM status WHERE company=? AND denom=? AND cluster=? AND lot=? AND sublot=? AND serial=? AND status >6";
	/*public final static String distributer_hibridoTarjetasDisponiblesDistributer = 
	"SELECT c.denom, p.value, COUNT(*) AS cantidad, COUNT(*)*p.value AS monto FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND c.distributer=? AND selling_route IS NULL AND bill IS NULL GROUP BY c.denom";
	 */

	/*public final static String distributer_hibridoTarjetasDisponiblesDistributerHijo = 
	"SELECT c.denom, p.value, COUNT(*) AS cantidad, COUNT(*)*p.value AS monto FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND c.distributer=? ? ? AND selling_route IS NULL AND bill IS NULL GROUP BY c.denom";*/
	/*public final static String disponible =
	"SELECT (SELECT count(*) FROM card WHERE distributer=? AND denom=?)>=?";*/

	// **********************************************************************ASIGNACION A RUTAS*****************************************************************************

	// 9.- BUSCAR LAS RUTAS DE UN DISTRIBUIDOR A PARTIR DEL COMPANY DEL USUARIO(PARA EL DROP DOWN BOX DE RUTA).
	// SELECT s.selling_route, s.name, c.description FROM selling_route AS s STRAIGHT_JOIN city AS c ON s.state=c.state AND s.city=c.city WHERE s.company=<user.employer>;
	public final static String route_rutasDelUsuario =
			"SELECT s.selling_route, s.name, c.description FROM selling_route AS s STRAIGHT_JOIN municipality AS c ON s.state=c.state AND s.municipality=c.municipality WHERE s.company=? AND active=TRUE";

	// 10.- Buscar las denominaciones posibles 
	//es el mismo query 1
	//1.- Buscar las denominaciones existentes para la compaï¿½ia a partir del company del usuario
	//SELECT p.denom, p.value FROM packing p WHERE p.company=<user.company>
	public final static String route_denominacionesParaCompania =
			"SELECT p.denom, p.value FROM packing p WHERE p.company=?";


	// 11.- BUSCAR LA proxima tarjeta disponible para del subditribuidor para asignar a la ruta a partir de la company del user.
	// el mismo query 6.-
	//SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) FROM (SELECT manuf_no AS m_no, p.value AS val FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=<user.company> AND c.distributer=<user.employer> AND c.selling_route IS NULL ORDER BY m_no ASC LIMIT <num_de_tarjetas>) AS result;
	public final static String route_hibridoRangoTarjetasDisponibles =
			"SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) AS bolivares, cl, val AS denom FROM (SELECT manuf_no AS m_no, p.value AS val, c.cluster as cl FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND c.distributer=? AND c.selling_route IS NULL AND c.bill IS NULL AND c.denom = ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61,7, 11) AND s.confirmation in (1))=1 ORDER BY m_no ASC LIMIT ?) AS result";    

	public final static String route_hibridoRangoTarjetasDisponiblesConFacing =
			"SELECT MIN(m_no), MAX(m_no), COUNT(m_no), val*COUNT(m_no) AS bolivares, cl, val AS denom FROM (SELECT manuf_no AS m_no, p.value AS val, c.cluster as cl FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND c.distributer=? AND c.selling_route IS NULL AND c.bill IS NULL AND c.denom = ? AND c.cluster=? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61,7, 11) AND s.confirmation in (1))=1 ORDER BY m_no ASC LIMIT ?) AS result";    



	// 12.- Asignar las tarjetas a la routa:
	//UPDATE card SET selling_route=<ruta_seleccionada>, route_date=CURDATE(), route_usr=<user.user> WHERE company=<user.company> AND distributer=<user.employer> AND selling_route IS NULL AND manuf_no BETWEEN <desde> AND <hasta>;
	public final static String route_AsignarTarjetasRuta = 
			"UPDATE card AS c SET distributer=?, selling_route=?, route_date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))), route_usr=? WHERE company=? AND distributer=? AND selling_route IS NULL AND manuf_no BETWEEN ? AND ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61,7, 11) AND s.confirmation in (1))=1 AND c.denom=?";

	/*public final static String route_hibridoTarjetasDisponiblesRoute = 
	"SELECT c.denom, p.value, count(*) AS cantidad, count(*)*p.value AS monto FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND c.distributer=? AND c.denom=? AND c.selling_route=?";*/

	public final static String delete_status_reversoRuta=
			"DELETE FROM status WHERE company=? AND denom=? AND cluster=? AND lot=? AND sublot=? AND serial=? AND status in (8,10,12)";

	//**********************************************************************CREACIï¿½N DE FACTURA*****************************************************************************

	//Listar la ruta a la que se le va va atada la factura. 

	//14.- Listar los Clientes Pertenecientes a la ruta (para el dropdownbox de seleccionar el cliente).
	//SELECT c.client, c.rif, c.store, c.name FROM client AS c WHERE c.distributer=<user.employer> AND c.selling_route=<ruta seleccionada>;
	public final static String bill_clientesDeLaRuta =
			"SELECT c.client, c.rif, c.name, c.store FROM client AS c WHERE c.distributer=? AND c.selling_route=?";

	//15 Listar las Tarjetas disponibles en el maletin por denomicacion
	// SELECT p.value, c.manuf_no FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=<user.company> AND c.distributer=<user.employer> AND selling_route=<ruta seleccionada> AND bill IS NULL ORDER BY c.denom, c.manuf_no;
	public final static String bill_TarjetasEnMaletin =
			"SELECT c.company, c.manuf_no, p.value FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND c.distributer=? AND selling_route=? AND bill IS NULL AND c.denom=? ORDER BY c.denom, c.manuf_no";    

	//16 Crear la Factura (Entrada en la tabla Factura):
	//INSERT INTO bill (company,control_number,distributer,selling_route,bill_date,client,deposit,approved,approval_usr)VALUES (<user.company>,<control_no_dado>,<user.employer>,<selling_route_seleccionada>,<fecha_introducida>,<cliente_seleccionado>,2,TRUE,<user.user>);
	public final static String bill_crearFactura = 
			"INSERT INTO bill (company,control_number,distributer,selling_route,bill_date,client,deposit,approved,approval_usr)VALUES (?,?,?,?,?,?,?,?,?) ";

	// 16.1 Buscar el Id de la factura recien creada:
	public final static String bill_buscarFacturaNueva = 
			"SELECT bill FROM bill WHERE company=? AND distributer=? AND control_number=?";

	//17 Modificar las Tarjetas para incluir la referencia hacia la Factura recien creada.
	//UPDATE card AS C SET bill=<bill_id_recien_creado>, approved=TRUE (Si el que la esta creando es un supervisor) WHERE c.company=<user.company> AND c.distributer=<user.employer> AND selling_route=<ruta seleccionada> AND bill IS NULL AND manuf_no IN (seriales seleccionados separados por coma) ORDER BY c.denom, c.manuf_no;
	public final static String bill_agregarNumeroFacturaEnTarjeta  =
			"UPDATE card AS c SET bill=?, approved=? WHERE c.company=? AND c.distributer=? AND selling_route=? AND bill IS NULL AND manuf_no BETWEEN ? AND ? AND 0=(SELECT count(*) FROM status AS s1 WHERE (SELECT IF(count(*)=1,FALSE,TRUE) FROM status AS s2 WHERE s2.company=c.company AND s2.denom=c.denom AND s2.cluster=c.cluster AND s2.lot=c.lot AND s2.sublot=c.sublot AND s2.serial=c.serial AND s2.status=13) AND s1.company=c.company AND s1.denom=c.denom AND s1.cluster=c.cluster AND s1.lot=c.lot AND s1.sublot=c.sublot AND s1.serial=c.serial AND s1.status=10 AND set_time>=(SELECT SUBSTR(MAX(CONCAT(set_time,' ',status)),1,20) FROM status AS s2 WHERE s2.company=c.company AND s2.denom=c.denom AND s2.cluster=c.cluster AND s2.lot=c.lot AND s2.sublot=c.sublot AND s2.serial=c.serial AND s2.status IN (8,12) AND s2.confirmation=1)) AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61,7, 11) AND s.confirmation in (1))=1 AND denom=?";    

	public final static String bill_datosTarjeta  =
			"SELECT company, denom, cluster, lot, sublot, serial FROM card WHERE company=? AND manuf_no BETWEEN ? AND ? AND denom=?";

	public final static String bill_datoTarjeta  =
			"SELECT company, denom, cluster, lot, sublot, serial FROM card WHERE company=? AND manuf_no=?";

	public final static String bill_deletePromotioEnTarjeta  =
			"DELETE FROM status WHERE company=? AND denom=? AND cluster=? AND lot=? AND sublot=? AND serial=? AND (status=9 OR (status BETWEEN 80 AND 99))";    

	public final static String bill_updateNullBillEnTarjetas  =
			"UPDATE card SET bill=null WHERE company=? AND manuf_no BETWEEN ? AND ? AND denom=?";
	//18 Calcular el total de la factura
	//SELECT ?*SUM(p.value) FROM bill AS b STRAIGHT_JOIN card AS c ON b.bill=c.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE b.company=<user.company> AND b.bill=<id factura a calcular> AND 0 = (SELECT COUNT(*) FROM status AS s WHERE s.company=c.company AND s.denom=c.denom AND s.cluster=c.cluster AND c.lot=s.lot AND s.sublot=c.sublot AND s.serial=c.serial AND s.status BETWEEN 80 AND 99);
	public final static String bill_TotalFacturaSinPromocion = 
			"SELECT ?*SUM(p.value) FROM bill AS b STRAIGHT_JOIN card AS c ON b.bill=c.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE b.company=? AND b.bill=? AND 0 = (SELECT COUNT(*) FROM status AS s WHERE s.company=c.company AND s.denom=c.denom AND s.cluster=c.cluster AND c.lot=s.lot AND s.sublot=c.sublot AND s.serial=c.serial AND s.status BETWEEN 80 AND 99)";
	//NUEVO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	//18.1 Calcular el total de una linea de la factura
	public final static String bill_TotalAsignacionTarjetas = 
			"SELECT COUNT(*), SUM(p.value), SUM(?*p.value), p.value  FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND c.distributer=? AND selling_route=? AND bill IS NULL AND c.denom=? AND manuf_no BETWEEN ? AND ? AND (SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status in (61,11, 7) AND s.confirmation in (1))=1";

	public final static String bill_TarjetasEnMaletinDistributer =
			"SELECT c.company, c.manuf_no, p.value FROM card AS c STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND c.distributer=? ? ? AND c.bill IS NULL AND c.selling_route IS NULL ORDER BY c.manuf_no";

	public final static String bill_UpdateCardsRoute = 
			"UPDATE card SET selling_route=NULL, route_usr=?, route_date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))) WHERE company=? AND distributer=? AND selling_route=? AND denom=? AND manuf_no>=? AND manuf_no<=? AND bill IS NULL";

	public final static String bill_buscarSeriales = "SELECT denom, cluster, lot, sublot, serial, manuf_no FROM card AS c WHERE c.company=? AND c.distributer=? AND selling_route=? AND bill=? AND manuf_no BETWEEN ? AND ?;";

	public final static String insertStatus = "INSERT INTO status (company, denom, cluster, lot, sublot, serial, status, user, confirmation, log_code, trace) VALUES (?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE user=?, set_time=now(), confirmation=?, log_code=?, trace=?, sim=NULL;";

	public final static String bill_IfDistributerPadre =
			"SELECT c.client_company IS NULL FROM company AS co STRAIGHT_JOIN company AS c ON c.company=co.client_company WHERE co.company=?";

	public final static String bill_AsignacionDistributerPadre =
			"UPDATE card AS c SET c.distributer=(SELECT client_company FROM company WHERE company=?),distrib_date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))), distrib_usr=? WHERE c.distributer=? AND ? AND c.manuf_no>=? AND c.manuf_no<=? ? AND bill IS NULL AND selling_route IS NULL";

	public final static String bill_AsignacionDistributerRoot =
			"UPDATE card AS c SET c.distributer=NULL, distrib_date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))), distrib_usr=? WHERE c.distributer=? AND c.denom=? AND c.manuf_no>=? AND c.manuf_no<=? AND bill IS NULL AND selling_route IS NULL";

	public final static String bill_e_Update  =
			"UPDATE bill SET control_number=?, bill_date=? WHERE company=? AND distributer=? AND selling_route=? AND bill=?";

	public final static String billInf  =
			"SELECT c.name, r.name, DATE_FORMAT(b.bill_date, '%d/%m/%Y'), b.control_number, d.control_number, ba.name, DATE_FORMAT(d.deposit_date, '%d/%m/%Y'), if((d.approved AND d.deposit!=2),CONCAT('Aprobado ',if(d.concil_date IS NOT NULL,'y Conciliado',' y En espera de Conciliacion')),'En espera de Aprobacion') AS estatus, cl.name AS cliente,  CONCAT(SUBSTRING_INDEX(c.name, ' ', 1),'R',LPAD(cl.selling_route,2,'0'),'C',LPAD(cl.client,6,'0')) AS NUC FROM bill AS b STRAIGHT_JOIN  deposit AS d ON b.company=d.company AND b.deposit=d.deposit STRAIGHT_JOIN company AS c ON b.distributer=c.company STRAIGHT_JOIN client AS cl ON cl.company=b.company AND b.client=cl.client STRAIGHT_JOIN selling_route AS r ON b.distributer=r.company AND b.selling_route=r.selling_route STRAIGHT_JOIN bank AS ba ON ba.company=IF(b.distributer<235,d.company,235) AND ba.bank=d.bank WHERE b.company=? AND b.bill=?;"; //TODO corregir como obtiene el banco del deposito de la factura

	public final static String billInf_arch  =
			"SELECT c.name, r.name, DATE_FORMAT(b.bill_date, '%d/%m/%Y'), b.control_number, d.control_number, ba.name, DATE_FORMAT(d.deposit_date, '%d/%m/%Y'), if((d.approved AND d.deposit!=2),CONCAT('Aprobado ',if(d.concil_date IS NOT NULL,'y Conciliado',' y En espera de Conciliacion')),'En espera de Aprobacion') AS estatus, cl.name AS cliente,  CONCAT(SUBSTRING_INDEX(c.name, ' ', 1),'R',LPAD(cl.selling_route,2,'0'),'C',LPAD(cl.client,6,'0')) AS NUC FROM arch_bill AS b STRAIGHT_JOIN  arch_deposit AS d ON b.company=d.company AND b.deposit=d.deposit STRAIGHT_JOIN company AS c ON b.distributer=c.company STRAIGHT_JOIN client AS cl ON cl.company=b.company AND b.client=cl.client STRAIGHT_JOIN selling_route AS r ON b.distributer=r.company AND b.selling_route=r.selling_route STRAIGHT_JOIN bank AS ba ON ba.company=IF(b.distributer<235,d.company,235) AND ba.bank=d.bank WHERE b.company=? AND b.bill=?;"; //TODO corregir como obtiene el banco del deposito de la factura

	public static String selectAllClusters =
			"SELECT DISTINCT(CONCAT(cluster, facial)) AS distinto, cluster, CONCAT('Cluster ',cluster,IF(facial is null,'',CONCAT(' - ',facial))) AS facial FROM cluster WHERE company=? GROUP BY distinto ORDER BY cluster;";
	
	public static String getApprovedUsers = "SELECT c.date, CONCAT(u.name,' ',u.lastname), u.login FROM client AS c STRAIGHT_JOIN user AS u ON c.company=u.company AND c.client=u.client WHERE c.company=? AND c.date BETWEEN ? and ? ORDER BY c.date;";
	
	public static String getBankName = "SELECT name FROM bank WHERE company=? AND bank=?";
	
	//******* QUERIES PARA RELLENAR EL CUBO DE REPORTE DE ANALISIS DE LIQUIDACIÓN ******//	
	public static String getIndustryAndLocation = "SELECT cl.industry, cl.state, cl.municipality, cl.city, cl.distributer FROM card AS c STRAIGHT_JOIN bill AS b ON c.company=b.company AND c.bill=b.bill STRAIGHT_JOIN client AS cl ON b.company=cl.company AND b.client=cl.client WHERE c.company=? AND c.denom=? AND c.cluster=? AND c.lot=? AND c.sublot=? AND c.serial=?";
	public static String getIndustryAndLocation2 = "SELECT pos.industry, pos.state, pos.municipality, pos.city, c.user_company, c.amount FROM e_card AS c STRAIGHT_JOIN e_pos AS pos ON c.user_company=pos.company AND c.user=pos.user AND c.e_pos=pos.e_pos WHERE c.company=? AND c.denom=? AND c.cluster=? AND c.lot=? AND c.sublot=? AND c.serial=?";
	public static String getIndustryAndLocation3 = "SELECT cl.industry, cl.state, cl.municipality, cl.city, cl.distributer, ec.amount FROM e_card AS ec STRAIGHT_JOIN user AS u ON ec.user_company=u.company AND ec.user=u.user STRAIGHT_JOIN client AS cl ON u.company=cl.company AND u.client=cl.client WHERE ec.company=? AND ec.denom=? AND ec.cluster=? AND ec.lot=? AND ec.sublot=? AND ec.serial=?";
	public static String getLocation = "SELECT location FROM dim_location WHERE state=? AND municipality=? AND city=?;";
	public static String getPacking = "SELECT packing FROM dim_packing WHERE company=? AND denom=? AND cluster=? AND promotion=?";
	public static String getPacking2 = "SELECT packing FROM dim_packing WHERE company=? AND amount=? AND promotion=?";
	public static String getPromotion = "SELECT IFNULL((SELECT status FROM status AS s WHERE company=? AND denom=? AND cluster=? AND lot=? AND sublot=? AND s.serial=? AND s.status between 80 AND 99 limit 1),9) AS promocion";
	public static String getMethod = "SELECT method FROM dim_method WHERE company=? AND channel=? AND payment_type=? AND payment_method=?;";
	public static String getNetwork = "SELECT network, level FROM (SELECT IF(level_3=?, level_3, IF(level_2=?, level_2, IF(level_1=?, level_1, company))) AS distributer, IF(level_2 is null, 1, IF(level_3 is null, 2, 3)) AS level, network FROM dim_network WHERE company=?) AS q1 WHERE distributer=? ORDER BY level;";
	public static String getTime = "SELECT time FROM dim_time WHERE date_value=?;";
	public static String getNewPacking = "SELECT IFNULL(MAX(packing)+1,1) FROM dim_packing WHERE company=?;";
	public static String addPacking = "INSERT INTO dim_packing (company,packing,denom,cluster,promotion) VALUES(?,?,?,?,?);";
	public static String addPacking2 = "INSERT INTO dim_packing (company,packing,denom,cluster,promotion,amount) VALUES(?,?,?,?,?,?);";
	public static String addTime = "INSERT INTO dim_time (time,date_value) VALUES(?,?);";
	public static String addLiquidationFact = "INSERT INTO fact_liquidation (company,method,network,packing,industry,location,time,total_money,total_charge) VALUES(?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE total_money=total_money+?, total_charge=total_charge+1";
	public static String getPackingValue = "SELECT value FROM packing WHERE company=? AND denom=?";
	//***********************************************************************************//
	
	
	public static String searchStatus13or14 = "SELECT * FROM status WHERE company=? AND denom=? AND cluster=? AND lot=? AND sublot=? AND serial=? AND status IN (13,14)";
	public static String addRechargeFact = "INSERT INTO fact_recharge (company,method,network,packing,industry,location,time,total_money,total_charge) VALUES(?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE total_money=total_money+?, total_charge=total_charge+1";
	public static String getChownPermissions = "SELECT CONCAT(directory_user,':',directory_group) FROM company WHERE company=?";
	

	//**********************************************************************CREACIï¿½N DE DEPOSITO*****************************************************************************

	//19 Listar los Bancos Disponibles segun el user.
	//SELECT bank, name FROM bank WHERE company=<user.company>;
	public final static String banks_disponiblesParaUsuario =
			"SELECT bank, name, account_number FROM bank WHERE company=?";

	public final static String depositBankApproved =
			"SELECT b.bank, b.name, b.account_number, count(*) AS Numero  FROM deposit AS d STRAIGHT_JOIN bank AS b ON b.bank=d.bank  AND b.company=IF(d.distributer<235,d.company,235) WHERE d.company=? AND d.distributer=(IF (9999 !=9999, 9999 ,d.distributer)) AND d.approved=0 AND d.concil_date IS NULL AND d.deposit_aux=2 AND (select count(*) from bill where company=d.company and deposit=d.deposit)=0 GROUP BY d.bank;"; //TODO obtener bancos de smartcall no hardcoded
	
	public final static String depositBankApprovedGRE =
			"SELECT b.bank, b.name, b.account_number, count(*) AS Numero FROM deposit AS d JOIN bank AS b ON b.bank=d.bank  AND b.company=d.company WHERE d.company=? AND d.distributer IN (IF (? !=9999, ? ,d.distributer)) AND d.deposit_usr=(IF (? !=9999, ? ,d.deposit_usr)) AND d.approved=0 AND d.concil_date IS NULL AND d.deposit_aux=2 AND d.deposit_date BETWEEN ? AND ? GROUP BY d.bank;";
	//21 Listar las facturas pendientes por relacionar al recibo
	//SELECT b.bill, b.bill_date, b.control_number FROM bill AS b WHERE b.company=<user.company> AND b.distributer=<user.employer> AND b.selling_route=<routa selecionada> AND b.approved IS FALSE;
	//OJO DEPOSITO DUMMY
	public final static String deposit_billsAvailable = 
			"SELECT b.bill, b.control_number AS control, b.bill_date AS fecha, ?*SUM(IF(((SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status between 80 AND 99 )=1) ,0,p.value)) AS total, 1 FROM bill AS b left join card AS c ON b.company=c.company AND b.bill=c.bill left join packing AS p ON c.company=p.company AND c.denom=p.denom WHERE b.company=? AND b.distributer=? AND b.selling_route=? AND  b.deposit=2 AND b.control_number!='NULL' GROUP BY  control,  fecha;";

	public final static String deposit_billsAvailable_e = 
			"SELECT b.bill, b.control_number AS control, b.bill_date AS fecha, eb.amount*i.percent AS total, 2 FROM bill AS b STRAIGHT_JOIN e_buy AS eb ON b.company=eb.company AND b.bill=eb.bill STRAIGHT_JOIN importe AS i ON b.company=i.company WHERE b.company=? AND b.distributer=? AND b.selling_route=? AND  b.deposit=2 AND b.control_number!='NULL' GROUP BY  control,  fecha;";
	//"SELECT b.bill, b.control_number, if((SELECT count(*) FROM card AS c WHERE c.bill=b.bill)=0,'Asignar',(SELECT ?*SUM((SELECT IF((MAX(status) between 80 AND 99),0,p.value) FROM status AS s1 STRAIGHT_JOIN packing AS p ON s1.company=p.company AND s1.denom=p.denom WHERE s1.company=c.company AND s1.denom=c.denom AND s1.cluster=c.cluster AND s1.lot=c.lot AND s1.sublot=c.sublot AND s1.serial = c.serial))FROM bill AS b STRAIGHT_JOIN card AS c ON b.company=c.company AND b.bill=c.bill STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial WHERE b.company=? AND b.distributer=? AND b.selling_route=? AND b.deposit=2 AND s.status=1 GROUP BY c.bill)), b.bill_date FROM bill AS b WHERE b.company=? AND b.distributer=? AND b.selling_route=? AND b.deposit=2 GROUP BY b.bill;"; //Deposito Dummy
	//SELECT b.bill, b.control_number, (SELECT IF((MAX(status) between 80 AND 99),0,p.value) FROM status AS s1 STRAIGHT_JOIN packing AS p ON s1.company=p.company AND s1.denom=p.denom WHERE s1.company=c.company AND s1.denom=c.denom AND s1.cluster=c.cluster AND s1.lot=c.lot AND s1.sublot=c.sublot AND s1.serial = c.serial), b.bill_date FROM bill AS b STRAIGHT_JOIN card AS c ON b.company=c.company AND b.bill=c.bill STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial WHERE b.company=? AND b.distributer=? AND b.selling_route=? AND b.deposit=2;
	public final static String bill_CorreccionBill =
			"SELECT b.control_number, ca.denom, b.bill_date, b.client, cl.name, b.selling_route, r.name, p.value, p.value*? AS facial, ca.manuf_no,if((SELECT ca.manuf_no FROM status AS s WHERE s.company=ca.company AND s.denom=ca.denom AND s.cluster=ca.cluster AND s.lot=ca.lot AND s.sublot=ca.sublot AND s.serial=ca.serial AND s.status between 80 AND 99)>0,1,0)AS promocion FROM bill AS b STRAIGHT_JOIN card AS ca ON b.company=ca.company AND b.bill=ca.bill STRAIGHT_JOIN client AS cl ON b.company=cl.company AND b.client=cl.client STRAIGHT_JOIN selling_route AS r ON  ca.distributer=r.company  AND  b.selling_route=r.selling_route STRAIGHT_JOIN packing AS p ON ca.company=p.company AND ca.denom=p.denom WHERE ca.company=? AND ca.bill=? ORDER BY ca.manuf_no;";
	public final static String bill_e =
			"SELECT b.bill, b.control_number, eb.amount, eb.amount*i.percent, b.bill_date FROM bill AS b STRAIGHT_JOIN e_buy AS eb ON b.company=eb.company AND b.client=eb.client AND b.bill=eb.bill STRAIGHT_JOIN importe AS i ON i.company=b.company AND i.importe=1 WHERE b.company=? AND b.distributer=? AND b.selling_route=? AND b.client=? AND b.control_number='NULL'";

	public final static String bill_CorreccionBill2 =
			"SELECT b.control_number,0, b.bill_date,b.client, 0, b.selling_route, 0, 0, 0, 0, 0 FROM bill AS b WHERE b.bill=?";

	public final static String bill_updateBill =
			"UPDATE card AS c SET bill=null , distrib_usr=?, distrib_DATE=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT co.time_zone FROM company AS co JOIN user AS u ON u.company=co.company WHERE u.user=?))) WHERE manuf_no BETWEEN ? AND ?";

	public final static String bill_deleteStatusBill =
			"DELETE FROM status WHERE denom=? AND cluster=? AND lot=? AND sublot=? AND serial=? AND status BETWEEN 80 AND 99";

	public final static String bill_searchCardBill =
			"SELECT denom, cluster, lot, sublot, serial FROM card WHERE manuf_no=?";
	public final static String bill_updateBills =
			"update bill set control_number=? , selling_route=? , bill_date=? , client=? WHERE bill=?";
	//"INSERT INTO bill (company,control_number,distributer,selling_route,bill_date,client,deposit,approved,approval_usr)VALUES (?,?,?,?,?,?,?,?,?) ";

	public final static String deposit_createDeposit = "INSERT INTO deposit (company, control_number, deposit_date, bank, distributer, selling_route, deposit_usr, approved, approval_usr, concil_date, deposit_aux, amount) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

	public final static String deposit_updateBill =  "UPDATE bill SET deposit=? WHERE bill=?";
	//22 CALCULAR EL VALOR DEL DEPOSITO (SUMATORIA DE TODAS LAS FACTURAS SELECCIONADAS) ESTO ES PARA COMPROBAR SI EL MONTO INDICADO ES VALIDO
	//SELECT ?*SUM(p.value) FROM bill AS b STRAIGHT_JOIN card AS c ON b.bill=c.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE b.company=<user.company> AND b.bill IN (<ID'S DE FACTURAS A CALCULAR) AND 0 = (SELECT COUNT(*) FROM status AS s WHERE s.company=c.company AND s.denom=c.denom AND s.cluster=c.cluster AND c.lot=s.lot AND s.sublot=c.sublot AND s.serial=c.serial AND s.status BETWEEN 80 AND 99);

	//23 INSERTAR LA NUEVA FACTURA EN LA TABLA BILL
	//INSERT INTO deposit VALUES (company,control_number,deposit_date,bank,distributer,selling_route,deposit_usr,approved,approval_usr,conciliated,concil_date) VALUES (<user.company>,<numero de planilla>,'<fecha indicada>',,5,1,1,true,1,true,'20090101');

	//INSERTAR
	//update deposit set control_number='33336666', deposit_date='2009-08-22', bank=1, distributer=19, selling_route=1, deposit_usr=8, amount=140 WHERE deposit_aux=69
	public final static String deposit_depositsUpdatePrincipal = 
			"UPDATE deposit SET control_number=?, deposit_date=?, bank=?, distributer=?, selling_route=?, deposit_usr=?, amount=?, approval_usr=?, approved=?, concil_date=? WHERE company=? AND deposit=?" ;
	public final static String deposit_depositsUpdateAux = 
			"UPDATE deposit SET control_number=?, deposit_date=?, bank=?, distributer=?, selling_route=?, deposit_usr=?, amount=?, approved=?, approval_usr=?, concil_date=? WHERE company=? AND deposit_aux=? AND control_number!=?";
	public final static String deposit_depositsUpdateAuxDif = 
			"UPDATE deposit SET control_number=?, deposit_date=?, bank=?, distributer=?, selling_route=?, deposit_usr=?, amount=?, approved=?, approval_usr=?, concil_date=? WHERE company=? AND deposit_aux=? AND control_number=?";
	public final static String deposit_createDepositsUpdateAux = 
			"INSERT INTO deposit VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public final static String deposit_depositsUpdateAuxExist = 
			"SELECT count(*), amount FROM deposit WHERE deposit_aux=?";
	public final static String deposit_detailDeposit = 
			"SELECT b.bill, d.control_number AS rafaga, b.control_number, ?*SUM(IF(((SELECT count(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status BETWEEN 80 AND 99 )=1) ,0,p.value)) AS total, d.deposit_date, d.company, b.bill_date,d.deposit_aux, d.selling_route, d.distributer FROM bill AS b STRAIGHT_JOIN card AS c ON b.company=c.company AND b.bill=c.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN deposit AS d ON b.deposit=d.deposit WHERE b.deposit=?  GROUP BY b.bill;";
	public final static String deposit_cantDeposit = 
			"SELECT d.control_number AS ragaga, d.deposit_date, d.bank AS banco, d.deposit_aux, d.amount, d.approved FROM deposit AS d WHERE d.deposit=? or d.deposit_aux=?;";
	public final static String deposit_depositsAvailable =
			"SELECT d.deposit, d.control_number, d.deposit_date FROM deposit AS d WHERE d.company=? AND d.distributer=? AND d.selling_route=? AND d.deposit_aux=2 AND approved=false;";	
	public final static String deposit_depositsAvailable_bill =
			"SELECT COUNT(*) FROM bill WHERE deposit=? ";
	public final static String deposit_depositsAvailable_delete_aux =
			"DELETE FROM DEPOSIT WHERE deposit_aux=?";
	public final static String deposit_depositsAvailable_delete =
			"DELETE FROM DEPOSIT WHERE deposit=?";
	public final static String deposit_updateDeposit =
			"UPDATE bill AS b STRAIGHT_JOIN deposit AS d ON b.deposit=d.deposit SET b.deposit=2, d.deposit_usr=?  WHERE b.bill=?";
	public final static String deposit_updateDepositEnd =
			"UPDATE deposit AS d SET d.control_number=?, d.deposit_date=?, d.bank=?, d.selling_route=?, d.deposit_usr=? WHERE d.deposit=?";
	public final static String deleteDeposit =
			"DELETE FROM deposit WHERE company=? AND distributer=? AND (deposit=? OR deposit_aux=?)";
	public final static String deleteRefBillDeposit =
			"UPDATE bill SET deposit=2 WHERE company=? AND distributer=? AND deposit=?";
	public final static String checkRafagaDeposit =
			" SELECT SUM(dep) FROM ( SELECT COUNT(*) AS dep FROM deposit WHERE company=? AND control_number=? AND bank=? AND amount=? AND deposit_date=? UNION SELECT COUNT(*) FROM arch_deposit WHERE company=? AND control_number=? AND bank=? AND amount=? AND deposit_date=? ) AS t1";
	public final static String checkRafagaDepositUpdate =
			" SELECT SUM(dep) FROM ( SELECT COUNT(*) AS dep FROM deposit WHERE company=? AND control_number=? AND bank=? AND amount=? AND deposit_date=? AND deposit!=? UNION SELECT COUNT(*) FROM arch_deposit WHERE company=? AND control_number=? AND bank=? AND amount=? AND deposit_date=? AND deposit!=?) AS t1";
	public final static String checkRafagaDepositAuxUpdate =
			" SELECT SUM(dep) FROM ( SELECT COUNT(*) AS dep FROM deposit WHERE company=? AND control_number=? AND bank=? AND amount=? AND deposit_date=? AND deposit_aux!=? UNION SELECT COUNT(*) FROM arch_deposit WHERE company=? AND control_number=? AND bank=? AND amount=? AND deposit_date=?) AS t1";

	//DEPOSITOS DE GRE5/CC
	public final static String servicesCompanyList =
			" SELECT DISTINCT service_company, co.name FROM arrangement STRAIGHT_JOIN company AS co ON co.company=service_company WHERE seller_company=(IF (? != 9999, ?, seller_company));";
	public final static String chainList =
			" SELECT co.company, co.name FROM company AS co JOIN arrangement as a ON a.seller_company=co.company WHERE co.client_company=? AND service_company=(IF (? != 9999, ?, a.service_company)) group by co.company;";
	public final static String userSellerList =
			" SELECT u.user, u.login, u.name  FROM user_arrangement AS ua STRAIGHT_JOIN user AS u ON u.user=ua.user STRAIGHT_JOIN e_pos AS ep ON u.company=ep.company and u.user=ep.user  WHERE ua.service_company=(IF (? != 9999, ?, service_company)) AND ua.seller_company=? GROUP BY u.user;";
	public final static String posList =
			" SELECT e_pos, CONCAT(e_pos,' - ',description) FROM e_pos WHERE company=? AND user=? AND active=1;";
	public final static String updateDeposit = 
			"UPDATE deposit SET control_number=?, deposit_date=?, bank=?, distributer=?, selling_route=?, deposit_usr=?, amount=? WHERE company=? AND deposit=?";
	public final static String updateDepositAux = 
			"UPDATE deposit SET control_number=?, deposit_date=?, bank=?, distributer=?, selling_route=?, deposit_usr=?, amount=? WHERE company=? AND deposit_aux=? AND amount>0";
	public final static String updateDepositDif = 
			"UPDATE deposit SET control_number=?, deposit_date=?, bank=?, distributer=?, selling_route=?, deposit_usr=?, amount=? WHERE company=? AND deposit_aux=? AND amount<0";
	public final static String approvedDeposit = 
			"UPDATE deposit SET control_number=?, deposit_date=?, bank=? WHERE company=? AND deposit=? AND deposit_aux=?";
	public final static String approvedDepositList = 
			"UPDATE deposit SET approved=?, approval_usr=?, concil_date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))) WHERE company=? AND (deposit=? OR deposit_aux=?);";
	public final static String updateDepositIntoAccountsToPay = 
			"UPDATE account_to_pay SET deposit=?,set_time=set_time WHERE payer_company=? AND user=? AND account_to_pay=?";
	public final static String deleteDepositIntoAccountToPay = 
			"UPDATE account_to_pay SET deposit=null WHERE deposit=?";
	public final static String check_deposit = 
			"SELECT COUNT(*) FROM deposit WHERE company=? AND distributer=? AND selling_route=? AND deposit_usr=? AND bank=? AND amount=? AND control_number=? AND deposit_date=? ";
	public final static String depositApproved = 
			"SELECT dep.deposit, dep.deposit_date,  dep.amount, dep.control_number, b.name, IF(b1.bank IS NULL,'','Principal') ,de.deposit, de.deposit_date,  de.amount, de.control_number, b1.name, IF(b1.bank IS NULL,null,'Complementario'), IF(dep.company=dep.distributer,'VI','CC') AS id FROM deposit as dep LEFT OUTER JOIN deposit AS de ON dep.company=de.company AND dep.deposit=de.deposit_aux AND de.amount>0 JOIN bank AS b ON IF(dep.distributer<235,dep.company,235)=b.company AND dep.bank=b.bank LEFT OUTER JOIN bank AS b1 ON IF(de.distributer<235,de.company,235)=b1.company AND de.bank=b1.bank LEFT OUTER JOIN bill AS a2p ON a2p.deposit=dep.deposit WHERE dep.company=? AND dep.distributer=(IF (? !=9999, ? ,dep.distributer)) AND dep.bank=(IF ( ? !=9999, ? ,dep.bank)) AND dep.deposit_aux=2 AND dep.deposit!=2 AND dep.concil_date IS NULL AND a2p.deposit IS NULL AND dep.deposit_date BETWEEN ? AND ? AND dep.approved= ? AND dep.deposit_usr=(IF (? !=9999, ? ,dep.deposit_usr))  GROUP BY  id, dep.deposit_date, dep.deposit;"; //TODO No obtener banco smartcall hardcoded
	//NO LOS NECESITAS SI HACES RESTORE DEL BACKUP QUE TE ESTOY LLEVANDO.
	//QUERIES NECESARIOS PARA LA CREACIï¿½N DE DEPOSITO DUMMY.
	//INSERT INTO selling_route (company, selling_route, name,state,city)VALUES (5,1,'DUMMY',1,1);
	//INSERT INTO deposit (company,control_number,deposit_date,bank,distributer,selling_route,deposit_usr,approved,approval_usr,conciliated,concil_date) VALUES (1,1,'20090101',1,5,1,1,true,1,true,'20090101');

	//*******************************************************************MANTENIMIENTO DE RUTA*****************************************************************************

	public final static String route_routedetail =
			"SELECT s.selling_route, s.name, s.state, s.municipality, s.city FROM selling_route AS s WHERE s.company=? AND s.selling_route=?";	
	//SELECT name, st.state, st.description FROM crypto_prd.`client` STRAIGHT_JOIN crypto_prd.state AS st ON s.state=st.state WHERE company=1 AND client=1 AND selling_route=2
	public final static String route_rutasState =
			"SELECT st.state, st.description FROM state AS st";	

	public final static String route_rutasCity =
			"SELECT st.state, c.municipality, c.description FROM state AS st STRAIGHT_JOIN municipality AS c ON st.state=c.state WHERE st.state=?";	

	public final static String route_changeRoute = 
			"UPDATE selling_route AS s SET s.name=?, s.state=?, s.municipality=?, s.city=? WHERE s.company=? AND selling_route=?";

	public final static String route_deleteRoute = 
			"UPDATE selling_route AS s SET active=? WHERE s.company=? AND selling_route=?";

	public final static String route_addRoute = 
			"INSERT INTO selling_route VALUE(?,IF((SELECT count(*) FROM selling_route s WHERE company=?)> 0,(SELECT MAX(s.selling_route)+1 FROM selling_route s WHERE company=?),1),?,?,?,?,TRUE)";

	public final static String route_routeName =
			"SELECT r.name FROM selling_route AS r WHERE r.company=? AND r.selling_route=?";

	public final static String route_distributerName =
			"SELECT d.name FROM company AS d WHERE d.company=?";
	
	
	//**********************************************************************MANTENIMIENTO DE CLIENTE************************************************************************

	public final static String client_clientdetail =
			//   distributer,  client,     name,  rif,   store,   state,    stateName,       city,  cityName,       municipality,  municipalityName,  street,  industry,  industryName,  phone1,   phone2 	
			"SELECT cl.client, cl.name, cl.rif, cl.street, cl.state, cl.municipality, cl.city, cl.phone_1, cl.phone_2, cl.industry, CONCAT(SUBSTRING_INDEX(c.name, ' ', 1),'R',LPAD(cl.selling_route,2,'0'),'C',LPAD(cl.client,6,'0')) AS NUC, email FROM client AS cl STRAIGHT_JOIN company AS c ON cl.distributer=c.company WHERE cl.company=? AND cl.client=?;";
	public final static String search_repeat =
			"SELECT count(*) FROM client WHERE company=? AND rif=? AND distributer=? AND selling_route=?";	


	public final static String search_Nuc =
			"SELECT  CONCAT(SUBSTRING_INDEX(c.name, ' ', 1),'R',LPAD(cl.selling_route,2,'0'),'C',LPAD(cl.client,6,'0')) AS NUC   FROM company AS c STRAIGHT_JOIN client AS cl ON c.company=cl.distributer WHERE cl.company=? AND cl.distributer=? AND cl.selling_route=? AND cl.rif=?";

	public final static String client_addClient =
			"INSERT INTO client (company,client,rif,store,distributer,selling_route,name,street,state,municipality,city,phone_1,phone_2,industry,date,email) VALUE(?,IF((SELECT MAX(c1.client) FROM client AS c1 WHERE c1.company=?) is NULL,1,(SELECT MAX(c2.client)+1 FROM client AS c2 WHERE c2.company=?)),?,IF((SELECT MAX(c3.client) FROM client AS c3 WHERE c3.rif=? AND c3.company=?) is NULL,1,(SELECT MAX(c4.client)+1 FROM client AS c4 WHERE c4.rif=? AND c4.company=?)),?,?,?,?,?,?,?,?,?,?,DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))),?)";

	public final static String client_changeClient =
			"update client set  rif=?, selling_route=?, name=?, street=?, state=?, municipality=?,  city=?, phone_1=?, phone_2=?, industry=?, email=? WHERE client=? AND company=?";

	public final static String client_clientList =
			"SELECT s.client, s.name, s.rif FROM client AS s WHERE s.company=? ORDER BY s.rif";	

	public final static String client_clientCity =
			"SELECT c.city, c.description FROM city AS c WHERE c.state=? AND c.municipality=?";	

	public final static String client_clientInRuta =
			"SELECT cl.client, CONCAT(SUBSTRING_INDEX(c.name, ' ', 1),'R',LPAD(cl.selling_route,2,'0'),'C',LPAD(cl.client,6,'0')) AS NUC, cl.name FROM company AS c STRAIGHT_JOIN client AS cl ON c.company=cl.distributer WHERE cl.company=? AND cl.distributer=? AND cl.selling_route=? ORDER BY cl.name";

	public final static String client_clientMunicipality =
			"SELECT m.municipality, m.description FROM municipality AS m WHERE m.state=?";

	public final static String client_clientIndustry =
			"SELECT s.industry, s.description FROM industry AS s;";


	public final static String client_rifRepeat =
			"SELECT (SELECT COUNT(rif) FROM client WHERE rif=?) > 0";

	public final static String client_rifRepeatMaxStore =
			"SELECT MAX(store)+1 FROM client WHERE rif=?";


	//**********************************************************************REPORTERIA************************************************************************
	public final static String report_isRootDistributer =
			"SELECT client_company, is_distributer FROM company WHERE company=?";

	public final static String report_set_time=
			"CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)";
	
	public final static String report_from=
			"(SELECT company,time_zone FROM company WHERE company=?) AS t1 JOIN";
	
	public final static String contador =
			"SELECT count(*) FROM(SELECT c.manuf_no FROM card AS c WHERE c.distributer=? AND c.selling_route=? AND c.denom=? AND c.manuf_no BETWEEN ? AND ?)AS result";

	public final static String getAverageReport1 = 
			"SELECT CONCAT(YEAR(date),'-',MONTH(date)) AS yearmonth, ROUND(AVG(recargas)) FROM (SELECT DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)) AS date, count(*) AS recargas FROM (SELECT company,time_zone FROM company WHERE company=?) AS t1 JOIN status AS s FORCE INDEX (index_company_status) ON s.company=t1.company WHERE status IN (13,14) AND confirmation in (1,2) AND DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)) BETWEEN ? AND ? GROUP BY date) AS diario GROUP BY yearmonth ORDER BY YEAR(date),MONTH(date);";

	public final static String getAverageReport1_arch = 
			"SELECT CONCAT(YEAR(date),'-',MONTH(date)) AS yearmonth, ROUND(AVG(recargas)) FROM ((SELECT DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)) AS date, count(*) AS recargas FROM (SELECT company,time_zone FROM company WHERE company=?) AS t1 JOIN status as s FORCE INDEX (index_company_status) ON s.company=t1.company WHERE status IN (13,14) AND confirmation in (1,2) AND DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)) BETWEEN ? AND ? GROUP BY date) UNION (SELECT DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)) AS date, count(*) AS recargas FROM (SELECT company,time_zone FROM company WHERE company=?) AS t1 JOIN arch_status AS s ON s.company=t1.company WHERE status IN (13,14) AND confirmation in (1,2) AND DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)) BETWEEN ? AND ? GROUP BY date)) AS diario GROUP BY yearmonth ORDER BY YEAR(date),MONTH(date);";

	public final static String getAverageReport2 =
			"SELECT CONCAT(YEAR(date),'-',MONTH(date)) AS yearmonth, ROUND(AVG(vendidas)) FROM (SELECT b.bill_date AS date, count(*) AS vendidas FROM bill AS b STRAIGHT_JOIN card AS c ON b.company=c.company AND c.bill=b.bill WHERE b.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY date) AS diario GROUP BY yearmonth ORDER BY YEAR(date),MONTH(date);";

	public final static String getAverageReport2_arch =
			"SELECT CONCAT(YEAR(date),'-',MONTH(date)) AS yearmonth, ROUND(AVG(vendidas)) FROM ((SELECT b.bill_date AS date, count(*) AS vendidas FROM bill AS b STRAIGHT_JOIN card AS c ON b.company=c.company AND c.bill=b.bill WHERE b.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY date) UNION (SELECT b.bill_date AS date, count(*) AS vendidas FROM arch_bill AS b STRAIGHT_JOIN arch_card AS c ON c.company=b.company AND c.bill=b.bill WHERE c.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY date)) AS diario GROUP BY yearmonth ORDER BY YEAR(date),MONTH(date);";

	public final static String getAverageReport3 =
			"SELECT T31.yearmonth, T31.recargas, T32.vendidas, T31.recargas-T32.vendidas AS Vs FROM (SELECT DATE_FORMAT(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone),'%Y-%c') AS yearmonth, COUNT(*) AS recargas FROM (SELECT company,time_zone FROM company WHERE company=?) AS t1 JOIN status AS s ON t1.company=s.company WHERE status between 13 AND 14 AND confirmation in (1,2) AND DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)) BETWEEN ? AND ? GROUP BY yearmonth) AS T31 STRAIGHT_JOIN (SELECT CONCAT(YEAR(bill_date),'-',MONTH(bill_date)) AS yearmonth, COUNT(*) AS vendidas FROM bill AS b STRAIGHT_JOIN card AS c ON c.company=b.company AND c.bill=b.bill WHERE b.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY yearmonth ORDER BY YEAR(bill_date),MONTH(bill_date)) AS T32 ON T31.yearmonth=T32.yearmonth;";

	public final static String getAverageReport3_arch =
			"SELECT yearmonth, SUM(recargas), SUM(vendidas), SUM(Vs) FROM ((SELECT T31.yearmonth, T31.recargas, T32.vendidas, T31.recargas-T32.vendidas AS Vs FROM (SELECT DATE_FORMAT(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone),'%Y-%c') AS yearmonth, COUNT(*) AS recargas FROM (SELECT company,time_zone FROM company WHERE company=?) AS t1 JOIN status AS s ON t1.company=s.company WHERE status between 13 AND 14 AND confirmation in (1,2) AND DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t1.time_zone)) BETWEEN ? AND ? GROUP BY yearmonth) AS T31 STRAIGHT_JOIN (SELECT CONCAT(YEAR(bill_date),'-',MONTH(bill_date)) AS yearmonth, COUNT(*) AS vendidas FROM bill AS b STRAIGHT_JOIN card AS c ON c.company=b.company AND c.bill=b.bill WHERE b.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY yearmonth ORDER BY YEAR(bill_date),MONTH(bill_date)) AS T32 ON T31.yearmonth=T32.yearmonth) UNION (SELECT T31.yearmonth, T31.recargas, T32.vendidas, T31.recargas-T32.vendidas AS Vs FROM (SELECT DATE_FORMAT(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t2.time_zone),'%Y-%c') AS yearmonth, COUNT(*) AS recargas FROM (SELECT company,time_zone FROM company WHERE company=?) AS t2 JOIN arch_status AS s2 ON s2.company=t2.company WHERE status between 13 AND 14 AND confirmation in (1,2) AND DATE(CONVERT_TZ(set_time,(SELECT @@global.system_time_zone),t2.time_zone)) BETWEEN ? AND ? GROUP BY yearmonth ORDER BY  YEAR(set_time),MONTH(set_time)) AS T31 STRAIGHT_JOIN (SELECT CONCAT(YEAR(bill_date),'-',MONTH(bill_date)) AS yearmonth, COUNT(*) AS vendidas FROM arch_bill AS b STRAIGHT_JOIN arch_card AS c ON c.company=b.company AND c.bill=b.bill WHERE c.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY yearmonth ORDER BY YEAR(bill_date),MONTH(bill_date)) AS T32 ON T31.yearmonth=T32.yearmonth)) AS t GROUP BY yearmonth;";

	public final static String getAverageReport4 =
			"SELECT CONCAT(YEAR(date),'-',MONTH(date)) AS yearmonth, TRUNCATE(AVG(recargas),2) FROM (SELECT DATE(CONVERT_TZ(s.set_time,(SELECT @@global.system_time_zone),t1.time_zone)) AS date, AVG(p.value) AS recargas FROM (SELECT company,time_zone FROM company WHERE company=?) AS t1 JOIN status AS s ON t1.company=s.company JOIN packing AS p ON s.company=p.company AND s.denom=p.denom WHERE s.status between 13 AND 14 AND s.confirmation in (1,2) AND DATE(CONVERT_TZ(s.set_time,(SELECT @@global.system_time_zone),t1.time_zone)) BETWEEN ? AND ? GROUP BY date) AS diario GROUP BY yearmonth ORDER BY YEAR(date),MONTH(date);";

	public final static String getAverageReport4_arch =
			"SELECT CONCAT(YEAR(date),'-',MONTH(date)) AS yearmonth, TRUNCATE(AVG(recargas),2) FROM ((SELECT DATE("+report_set_time+") AS date, AVG(p.value) AS recargas FROM "+report_from+" status AS s ON t1.company=s.company JOIN packing AS p ON s.company=p.company AND s.denom=p.denom WHERE s.status between 13 AND 14 AND s.confirmation in (1,2) AND DATE("+report_set_time+") BETWEEN ? AND ? GROUP BY date) UNION (SELECT DATE("+report_set_time+") AS date, AVG(p.value) AS recargas FROM "+report_from+" arch_status AS s ON t1.company=s.company JOIN packing AS p ON s.company=p.company AND s.denom=p.denom WHERE s.status between 13 AND 14 AND s.confirmation in (1,2) AND DATE("+report_set_time+") BETWEEN ? AND ? GROUP BY date)) AS diario GROUP BY yearmonth;";
	
	public final static String getAverageReport5 =
			"SELECT CONCAT(YEAR(date),'-',MONTH(date)) AS yearmonth, TRUNCATE(AVG(vendidas),2) FROM (SELECT b.bill_date AS date, AVG(p.value) AS vendidas FROM bill AS b STRAIGHT_JOIN card AS c ON b.company=c.company AND c.bill=b.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE b.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY date) AS diario GROUP BY yearmonth ORDER BY YEAR(date),MONTH(date);";

	public final static String getAverageReport5_arch =
			"SELECT CONCAT(YEAR(date),'-',MONTH(date)) AS yearmonth, TRUNCATE(AVG(vendidas),2) FROM ((SELECT b.bill_date AS date, AVG(p.value) AS vendidas FROM bill AS b STRAIGHT_JOIN card AS c ON b.company=c.company AND c.bill=b.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE b.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY date) UNION (SELECT b.bill_date AS date, AVG(p.value) AS vendidas FROM arch_bill AS b STRAIGHT_JOIN arch_card AS c ON c.company=b.company AND c.bill=b.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom WHERE c.company=? AND b.deposit!=2 AND b.bill_date BETWEEN ? AND ? GROUP BY date)) AS diario GROUP BY yearmonth ORDER BY YEAR(date),MONTH(date);";

	public final static String getAverageReport6 =
			"SELECT status AS Estatus, date("+report_set_time+") AS Dia, p.value AS Denominacion, count(*) AS Tarjetas FROM "+report_from+" status AS s ON t1.company=s.company STRAIGHT_JOIN packing AS p ON s.company=p.company AND s.denom=p.denom WHERE status IN (7, 11) AND date("+report_set_time+") BETWEEN ? AND ? GROUP BY Estatus, Dia, Denominacion WITH ROLLUP;";

	public final static String getAverageReport6_arch =
			"SELECT Estatus, Dia, Denominacion, SUM(Tarjetas) FROM ((SELECT status AS Estatus, date("+report_set_time+") AS Dia, p.value AS Denominacion, count(*) AS Tarjetas FROM "+report_from+" status AS s ON t1.company=s.company STRAIGHT_JOIN packing AS p ON s.company=p.company AND s.denom=p.denom WHERE status IN (7, 11) AND date("+report_set_time+") BETWEEN ? AND ? GROUP BY Dia) UNION (SELECT status AS Estatus, date("+report_set_time+") AS Dia, p.value AS Denominacion, count(*) AS Tarjetas FROM "+report_from+" arch_status AS s ON t1.company=s.company STRAIGHT_JOIN packing AS p ON s.company=p.company AND s.denom=p.denom WHERE status IN (7, 11) AND date("+report_set_time+") BETWEEN ? AND ? GROUP BY Dia)) AS t GROUP BY Estatus, Dia, Denominacion WITH ROLLUP;";

	public final static String getAverageReport7 =
			"SELECT HOUR("+report_set_time+") AS Hora, COUNT(*) AS Recargas FROM "+report_from+" status AS s FORCE INDEX (index_company_status) ON t1.company=s.company WHERE status in (13,14) AND DATE("+report_set_time+")=? GROUP BY hora WITH ROLLUP;";

	public final static String getAverageReport7_arch =
			"SELECT Hora, SUM(Recargas) FROM ((SELECT HOUR("+report_set_time+") AS Hora, COUNT(*) AS Recargas FROM "+report_from+" status AS s FORCE INDEX (index_company_status) ON t1.company=s.company WHERE status in (13,14) AND DATE("+report_set_time+")=?) UNION (SELECT HOUR("+report_set_time+") AS Hora, COUNT(*) AS Recargas FROM "+report_from+" arch_status AS s ON t1.company=s.company WHERE status in (13,14) AND DATE("+report_set_time+")=?)) AS t GROUP BY hora WITH ROLLUP;";

	public final static String getAverageReport8 =
			"SELECT if(SUBSTRING(co.name,4,1)='0',SUBSTRING(co.name,1,3),SUBSTRING(co.name,1,4)) AS distribuidor, p.value AS denom, COUNT(c.manuf_no), p.value*COUNT(c.manuf_no) FROM deposit AS d STRAIGHT_JOIN bill AS b ON b.company=d.company AND b.deposit=d.deposit STRAIGHT_JOIN card AS c ON c.company=b.company AND c.bill=b.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN company AS co ON co.company=c.distributer WHERE d.company=? AND d.amount>0 AND d.concil_date BETWEEN ? AND ? GROUP BY distribuidor, denom WITH ROLLUP;";

	public final static String getAverageReport8_arch =
			"SELECT distribuidor, denom, SUM(Ntarjetas), SUM(total) FROM ((SELECT IF(SUBSTRING(co.name,4,1)='0',SUBSTRING(co.name,1,3),SUBSTRING(co.name,1,4)) AS distribuidor, p.value AS denom, COUNT(c.manuf_no) AS Ntarjetas, p.value*count(c.manuf_no) AS total FROM deposit AS d STRAIGHT_JOIN bill AS b ON b.company=d.company AND b.deposit=d.deposit STRAIGHT_JOIN card AS c ON c.company=b.company AND c.bill=b.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN company AS co ON co.company=c.distributer WHERE d.company=? AND d.amount>0 AND d.concil_date BETWEEN ? AND ? GROUP BY distribuidor, denom) UNION (SELECT IF(SUBSTRING(co.name,4,1)='0',SUBSTRING(co.name,1,3),SUBSTRING(co.name,1,4)) AS distribuidor, p.value AS denom, COUNT(c.manuf_no) AS Ntarjetas, p.value*count(c.manuf_no) AS total FROM arch_deposit AS d STRAIGHT_JOIN arch_bill AS b ON b.company=d.company AND b.deposit=d.deposit STRAIGHT_JOIN arch_card AS c ON c.company=b.company AND c.bill=b.bill STRAIGHT_JOIN packing AS p ON c.company=p.company AND c.denom=p.denom STRAIGHT_JOIN company AS co ON co.company=c.distributer WHERE d.company=? AND d.amount>0 AND d.concil_date BETWEEN ? AND ? GROUP BY distribuidor, denom)) AS t GROUP BY distribuidor, denom WITH ROLLUP; ";

	public final static String getStatusReport5A =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')) AS Tarjeta, c.manuf_no AS Consecutivo, status AS Estatus, confirmation AS Confirm, "+report_set_time+" AS Fecha, co.name AS Empresa, u.login AS Usuario, sim AS Sim FROM "+report_from+" card c ON t1.company=c.company STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial STRAIGHT_JOIN user AS u ON c.company=u.company AND s.user=u.user STRAIGHT_JOIN company AS co ON u.employer=co.company WHERE c.manuf_no=? GROUP BY Estatus, Confirm, Fecha, Tarjeta, Consecutivo, Empresa, Usuario ORDER BY Fecha;";

	public final static String getStatusReport5A_arch =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')) AS Tarjeta, c.manuf_no AS Consecutivo, status AS Estatus, confirmation AS Confirm, "+report_set_time+" AS Fecha, co.name AS Empresa, u.login AS Usuario, sim AS Sim FROM "+report_from+" arch_card c ON t1.company=c.company STRAIGHT_JOIN arch_status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial STRAIGHT_JOIN user AS u ON c.company=u.company AND s.user=u.user STRAIGHT_JOIN company AS co ON u.employer=co.company WHERE c.manuf_no=? GROUP BY Estatus, Confirm, Fecha, Tarjeta, Consecutivo, Empresa, Usuario ORDER BY Fecha;";

	public final static String getStatusArchReport5A =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')) AS Tarjeta, c.manuf_no AS Consecutivo, status AS Estatus, confirmation AS Confirm, "+report_set_time+" AS Fecha, co.name AS Empresa, u.login AS Usuario, sim AS Sim FROM "+report_from+" card c ON t1.company=c.company STRAIGHT_JOIN arch_status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial STRAIGHT_JOIN user AS u ON c.company=u.company AND s.user=u.user STRAIGHT_JOIN company AS co ON u.employer=co.company WHERE c.manuf_no=? GROUP BY Estatus, Confirm, Fecha, Tarjeta, Consecutivo, Empresa, Usuario ORDER BY Fecha;";

	public final static String getStatusReport5B =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')) AS Tarjeta, c.manuf_no AS Consecutivo, status AS Estatus, confirmation AS Confirm, "+report_set_time+" AS Fecha, co.name AS Empresa, u.login AS Usuario, sim AS Sim FROM "+report_from+" card c ON t1.company=c.company STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial STRAIGHT_JOIN user AS u ON c.company=u.company AND s.user=u.user STRAIGHT_JOIN company AS co ON u.employer=co.company WHERE c.denom=? AND c.cluster=? AND c.lot=? AND c.sublot=? AND c.serial=? GROUP BY Estatus, Confirm, Fecha, Tarjeta, Consecutivo, Empresa, Usuario ORDER BY Fecha;";

	public final static String getStatusReport5B_arch =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')) AS Tarjeta, c.manuf_no AS Consecutivo, status AS Estatus, confirmation AS Confirm, "+report_set_time+" AS Fecha, co.name AS Empresa, u.login AS Usuario, sim AS Sim FROM "+report_from+" arch_card c ON t1.company=c.company STRAIGHT_JOIN arch_status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial STRAIGHT_JOIN user AS u ON c.company=u.company AND s.user=u.user STRAIGHT_JOIN company AS co ON u.employer=co.company WHERE c.denom=? AND c.cluster=? AND c.lot=? AND c.sublot=? AND c.serial=? GROUP BY Estatus, Confirm, Fecha, Tarjeta, Consecutivo, Empresa, Usuario ORDER BY Fecha;";

	public final static String getStatusArchReport5B =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')) AS Tarjeta, c.manuf_no AS Consecutivo, status AS Estatus, confirmation AS Confirm, "+report_set_time+" AS Fecha, co.name AS Empresa, u.login AS Usuario, sim AS Sim FROM "+report_from+" card c ON t1.company=c.company STRAIGHT_JOIN arch_status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial STRAIGHT_JOIN user AS u ON c.company=u.company AND s.user=u.user STRAIGHT_JOIN company AS co ON u.employer=co.company WHERE c.denom=? AND c.cluster=? AND c.lot=? AND c.sublot=? AND c.serial=? GROUP BY Estatus, Confirm, Fecha, Tarjeta, Consecutivo, Empresa, Usuario ORDER BY Fecha;";

	public final static String getStatusReport5C =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')) AS Tarjeta, c.manuf_no AS Consecutivo, status AS Estatus, confirmation AS Confirm, "+report_set_time+" AS Fecha, co.name AS Empresa, u.login AS Usuario, sim AS Sim FROM "+report_from+" card c ON t1.company=c.company STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial STRAIGHT_JOIN user AS u ON c.company=u.company AND s.user=u.user STRAIGHT_JOIN company AS co ON u.employer=co.company WHERE c.pin=LPAD(?,20,'0') GROUP BY Estatus, Confirm, Fecha, Tarjeta, Consecutivo, Empresa, Usuario ORDER BY Fecha;";

	public final static String getStatusReport5C_arch =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')) AS Tarjeta, c.manuf_no AS Consecutivo, status AS Estatus, confirmation AS Confirm, "+report_set_time+" AS Fecha, co.name AS Empresa, u.login AS Usuario, sim AS Sim FROM "+report_from+" arch_card c ON t1.company=c.company STRAIGHT_JOIN arch_status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial STRAIGHT_JOIN user AS u ON c.company=u.company AND s.user=u.user STRAIGHT_JOIN company AS co ON u.employer=co.company WHERE c.pin=LPAD(?,20,'0') GROUP BY Estatus, Confirm, Fecha, Tarjeta, Consecutivo, Empresa, Usuario ORDER BY Fecha;";

	public final static String getStatusReport6 =
			"SELECT c.manuf_no AS consecutivo, MID(MAX(CONCAT("+report_set_time+",LPAD(status,3,'0'))),20,3) AS status, MID(MAX(CONCAT("+report_set_time+",confirmation)),20,2) AS confirmation, IFNULL(co.name,'') AS distribuidor, c.distrib_date AS fecha_distribuidor, IFNULL(ud.name,'')  AS usuario_distribuidor, IFNULL(r.name,'') AS ruta, IFNULL(c.route_date,'') AS fecha_ruta, IFNULL(ur.name,'') AS usuario_ruta, IFNULL(b.control_number,'') AS factura, IFNULL(b.bill_date,'') AS fecha_factura, IFNULL(ub.name,'') AS usuario_factura FROM "+report_from+" card AS c ON t1.company=c.company STRAIGHT_JOIN company AS co ON c.distributer=co.company STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status!=9 AND s.status NOT BETWEEN 80 AND 99 LEFT JOIN user AS ud ON c.company=ud.company AND c.distrib_usr=ud.user LEFT JOIN selling_route AS r ON r.company=c.distributer AND r.selling_route=c.selling_route LEFT JOIN user AS ur ON c.company=ur.company AND c.route_usr=ur.user LEFT JOIN bill AS b ON b.company=c.company AND b.bill=c.bill LEFT JOIN user AS ub ON c.company=ub.company AND b.approval_usr=ub.user WHERE (c.bill <> 0 OR c.bill is null) AND c.manuf_no between ? AND ? AND c.distributer in @@@ GROUP BY c.company, c.manuf_no;";
	public final static String getStatusReport6_arch =
			"(SELECT c.manuf_no AS consecutivo, MID(MAX(CONCAT("+report_set_time+",LPAD(status,3,'0'))),20,3) AS status, MID(MAX(CONCAT("+report_set_time+",confirmation)),20,2) AS confirmation,  IFNULL(co.name,'') AS distribuidor, c.distrib_date AS fecha_distribuidor, IFNULL(ud.name,'')  AS usuario_distribuidor, IFNULL(r.name,'') AS ruta, IFNULL(c.route_date,'') AS fecha_ruta, IFNULL(ur.name,'') AS usuario_ruta, IFNULL(b.control_number,'') AS factura, IFNULL(b.bill_date,'') AS fecha_factura, IFNULL(ub.name,'') AS usuario_factura FROM "+report_from+" card AS c ON t1.company=c.company STRAIGHT_JOIN company AS co ON c.distributer=co.company STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status!=9 AND s.status NOT BETWEEN 80 AND 99 LEFT JOIN user AS ud ON c.company=ud.company AND c.distrib_usr=ud.user LEFT JOIN selling_route AS r ON r.company=c.distributer AND r.selling_route=c.selling_route LEFT JOIN user AS ur ON c.company=ur.company AND c.route_usr=ur.user LEFT JOIN bill AS b ON b.company=c.company AND b.bill=c.bill LEFT JOIN user AS ub ON c.company=ub.company AND b.approval_usr=ub.user WHERE (c.bill <> 0 OR c.bill is null) AND c.company=? AND c.manuf_no between ? AND ? AND c.distributer in @@@ GROUP BY c.company, c.manuf_no) UNION (SELECT CONCAT(c.manuf_no,' || Archivada') AS consecutivo, MID(MAX(CONCAT(set_time,LPAD(status,3,'0'))),20,3) AS status, MID(MAX(CONCAT(set_time,confirmation)),20,2) AS confirmation, IFNULL(co.name,'') AS distribuidor, c.distrib_date AS fecha_distribuidor, IFNULL(ud.name,'')  AS usuario_distribuidor, IFNULL(r.name,'') AS ruta, IFNULL(c.route_date,'') AS fecha_ruta, IFNULL(ur.name,'') AS usuario_ruta, IFNULL(b.control_number,'') AS factura, IFNULL(b.bill_date,'') AS fecha_factura, IFNULL(ub.name,'') AS usuario_factura FROM arch_card AS c STRAIGHT_JOIN company AS co ON c.distributer=co.company LEFT JOIN arch_status AS sa ON c.company=sa.company AND c.denom=sa.denom AND c.cluster=sa.cluster AND c.lot=sa.lot AND c.sublot=sa.sublot AND c.serial=sa.serial AND sa.status!=9 AND sa.status NOT BETWEEN 80 AND 99 LEFT JOIN user AS ud ON c.company=ud.company AND c.distrib_usr=ud.user LEFT JOIN selling_route AS r ON r.company=c.distributer AND r.selling_route=c.selling_route LEFT JOIN user AS ur ON c.company=ur.company AND c.route_usr=ur.user LEFT JOIN arch_bill AS b ON b.company=c.company AND b.bill=c.bill LEFT JOIN user AS ub ON c.company=ub.company AND b.approval_usr=ub.user WHERE c.manuf_no between ? AND ? AND c.distributer in @@@ GROUP BY c.company, c.manuf_no) ORDER BY consecutivo;";

	public final static String getAssignmentHistory = "SELECT CONCAT(u.name,' ', u.lastname) AS usuario, (IF(a.is_assignment, d1.name, IF(a.to_route IS NULL, d2.name, r.name))) AS origen, (IF(a.is_assignment, IF(a.to_route IS NULL, d2.name, r.name), d1.name)) AS destino, a.date, p.value, (a.to_manuf_no-a.from_manuf_no+1) AS cant, a.from_manuf_no AS desde, a.to_manuf_no AS hasta, p.value*(a.to_manuf_no-a.from_manuf_no+1) AS monto FROM assignment AS a STRAIGHT_JOIN company AS d1 ON d1.company=a.from_distributer STRAIGHT_JOIN company AS d2 ON d2.company=a.to_distributer STRAIGHT_JOIN packing AS p ON a.denom=p.denom AND a.company=p.company STRAIGHT_JOIN user AS u ON a.user=u.user AND a.company=u.company LEFT JOIN selling_route AS r ON r.selling_route=a.to_route AND r.company=a.to_distributer WHERE a.company=? AND d1.company=? AND a.date BETWEEN ? AND ? ORDER BY date;";
	
	
	
	///////////////////******************************************************* CTAR *************************

	public final static String getAllPacking =
			"SELECT denom, value FROM packing WHERE company=?;";

	public final static String getClosingReportDeposits =
			"SELECT d.deposit, ba.account_number, DATE_FORMAT(d.deposit_date, '%d%m%Y'), CONCAT(CAST(d.control_number AS UNSIGNED)), CEILING(d.amount), d2.deposit, ba2.account_number, DATE_FORMAT(d2.deposit_date, '%d%m%Y'), CONCAT(CAST(d2.control_number AS UNSIGNED)), CEILING(d2.amount) FROM deposit AS d STRAIGHT_JOIN bank AS ba ON IF(d.distributer<235,d.company,235)=ba.company AND d.bank=ba.bank LEFT JOIN deposit AS d2 ON d2.deposit_aux=d.deposit and d2.amount>0 LEFT JOIN bank AS ba2 ON IF(d2.distributer<235,d2.company,235)=ba2.company AND d2.bank=ba2.bank WHERE d.company=? AND d.distributer IN (@) AND d.approved IS TRUE AND d.deposit_date<CURRENT_DATE() AND d.concil_date IS NULL AND d.amount>0 AND 0<(SELECT COUNT(*) FROM bill AS b WHERE b.deposit=d.deposit)"; //TODO Obtener depositos de Smartcall no harcoded
	
	public final static String getECardClosingReportDeposits =
			"SELECT d.deposit, ba.account_number, DATE_FORMAT(d.deposit_date, '%d%m%Y'), CONCAT(CAST(d.control_number AS UNSIGNED)), CEILING(d.amount), d2.deposit, ba2.account_number, DATE_FORMAT(d2.deposit_date, '%d%m%Y'), CONCAT(CAST(d2.control_number AS UNSIGNED)), CEILING(d2.amount) FROM deposit AS d STRAIGHT_JOIN bank AS ba ON d.company=ba.company AND d.bank=ba.bank JOIN account_to_pay AS atp1 ON d.deposit=atp1.deposit JOIN account_to_pay_relation AS atpr ON atp1.payer_company=atpr.agent_company AND atp1.user=atpr.agent_user AND atp1.account_to_pay=atpr.agent_account_to_pay JOIN account_to_pay AS atp2 ON atp2.payer_company=atpr.seller_company AND atp2.user=atpr.seller_user AND atp2.account_to_pay=atpr.seller_account_to_pay JOIN e_card AS ec ON ec.user_company=atp2.payer_company AND ec.user=atp2.user AND ec.account_to_pay=atp2.account_to_pay LEFT JOIN deposit AS d2 ON d2.deposit_aux=d.deposit AND d2.amount>0 LEFT JOIN bank AS ba2 ON d2.company=ba2.company AND d2.bank=ba2.bank WHERE d.company=? AND d.approved IS TRUE AND d.concil_date IS NULL AND d.amount>0 AND ec.user_company != ? AND d.deposit_date<CURRENT_DATE() GROUP BY d.deposit ORDER BY d.deposit ASC;";
	
	public static final String getVIClosingReportDeposits =  //este es el de vendedores externos ver si es el mismo del precierre
			"SELECT d.deposit, ba.account_number, DATE_FORMAT(d.deposit_date, '%d%m%Y'), CONCAT(CAST(d.control_number AS UNSIGNED)), CEILING(d.amount), d2.deposit, ba2.account_number, DATE_FORMAT(d2.deposit_date, '%d%m%Y'), CONCAT(CAST(d2.control_number AS UNSIGNED)), CEILING(d2.amount) FROM deposit AS d STRAIGHT_JOIN bank AS ba ON d.company=ba.company AND d.bank=ba.bank JOIN account_to_pay AS atp1 ON d.deposit=atp1.deposit JOIN account_to_pay_relation AS atpr ON atp1.payer_company=atpr.agent_company AND atp1.user=atpr.agent_user AND atp1.account_to_pay=atpr.agent_account_to_pay JOIN account_to_pay AS atp2 ON atp2.payer_company=atpr.seller_company AND atp2.user=atpr.seller_user AND atp2.account_to_pay=atpr.seller_account_to_pay LEFT JOIN deposit AS d2 ON d2.deposit_aux=d.deposit AND d2.amount>0 LEFT JOIN bank AS ba2 ON d2.company=ba2.company AND d2.bank=ba2.bank WHERE d.company=? AND d.approved IS TRUE AND d.deposit_date<CURRENT_DATE() AND d.concil_date IS NULL AND d.amount>0 AND atp2.deposit IS NULL GROUP BY d.deposit ORDER BY d.deposit ASC;";
	
	public final static String getClosingReportPromotion =
			"SELECT CONCAT(c.denom,LPAD(c.cluster,3,'0'),LPAD(c.lot,5,'0'),LPAD(c.sublot,5,'0'),LPAD(c.serial,2,'0')), s.status FROM deposit AS d STRAIGHT_JOIN bill AS b ON d.deposit=b.deposit STRAIGHT_JOIN card AS c ON b.company=c.company AND b.bill=c.bill STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial WHERE d.company=? AND d.distributer IN (@) AND d.approved IS TRUE AND d.concil_date IS NULL AND d.amount>0 AND s.status BETWEEN 80 AND 99 GROUP BY d.deposit ASC;";

	public final static String updateConciliatedDeposits =
			"UPDATE deposit SET concil_date=? WHERE company=? AND distributer IN (@) AND approved IS TRUE AND concil_date IS NULL AND deposit_date<CURRENT_DATE();";

	public final static String buscarSeriales = 
			"SELECT denom, cluster, lot, sublot, serial, manuf_no FROM card AS c WHERE c.company=? AND manuf_no BETWEEN ? AND ?;";

	///////////////////******************************************************* CRYPTO *************************

	public final static String getStatusBySerial =
			"SELECT CONCAT(denom,LPAD(cluster,3,'0'),LPAD(lot,5,'0'),LPAD(sublot,5,'0'),LPAD(serial,2,'0')) AS serial,  CONCAT(denom,LPAD(cluster,3,'0'),LPAD(lot,5,'0'),LPAD(sublot,5,'0'),LPAD(serial,2,'0'),'   ||   ',MID(MAX(CONCAT("+report_set_time+",status)),20,2) ,'   ||   ',MID(MAX(CONCAT("+report_set_time+",confirmation)),20,2),'   ||   ',MAX(DATE("+report_set_time+")) ,'   ||   ',MID(MAX(CONCAT("+report_set_time+",if(((LPAD(sim,1,'0'))='N' OR (LPAD(sim,1,'0')) IS NULL ),'Null',sim ))),20,12)) AS result FROM "+report_from+" status AS s ON t1.company=s.company WHERE denom=? AND cluster=? AND lot=? AND sublot=? AND serial=? GROUP BY serial;";

	public final static String getStatusByConsecutive =
			"SELECT c.manuf_no AS consecutivo,  CONCAT(c.manuf_no,'   ||   ',MID(MAX(CONCAT("+report_set_time+",status)),20,2) ,'   ||   ',MID(MAX(CONCAT("+report_set_time+",confirmation)),20,2),'   ||   ',MAX(DATE("+report_set_time+")) ,'   ||   ',MID(MAX(CONCAT("+report_set_time+",if(((LPAD(sim,1,'0'))='N' OR (LPAD(sim,1,'0')) IS NULL ),'Null',sim ))),20,12)) AS result FROM "+report_from+" card AS c ON t1.company=c.company STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial WHERE c.manuf_no=? GROUP BY c.manuf_no;";

	public final static String statusFinder =
			"SELECT MID(MAX(CONCAT("+report_set_time+",status)),20,2) FROM "+report_from+" status AS s ON t1.company=s.company WHERE denom=? AND cluster=? AND lot=? AND sublot=? AND serial=? ";

	public final static String listCardStatus =
			"SELECT  c.manuf_no AS ser, CONCAT(MID(MAX(CONCAT("+report_set_time+",s.status)),20,2),'') AS sta, CONCAT(MID(MAX(CONCAT("+report_set_time+",s.confirmation)),20,2),'') AS conf FROM "+report_from+" card AS c ON t1.company=c.company STRAIGHT_JOIN status AS s ON c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial WHERE c.distributer=? AND c.selling_route=? AND c.manuf_no between ? AND ? AND c.bill IS NULL  AND s.status IN(61,7,8,10,11,12,13,14) AND (SELECT count(*) FROM status AS s1 WHERE c.company=s1.company AND c.denom=s1.denom AND c.cluster=s1.cluster AND c.lot=s1.lot AND c.sublot=s1.sublot AND c.serial=s1.serial AND s1.status IN (7,11,13,14))=0 GROUP BY c.manuf_no ORDER BY sta, ser ASC;";

	public final static String listserialStatusDenom =
			" SELECT c.company, c.denom, c.cluster, c.lot, c.sublot, c.serial FROM card AS c WHERE c.company=? AND c.distributer=? AND c.selling_route=? AND c.bill IS NULL AND c.manuf_no BETWEEN ? AND ? AND 0=(SELECT COUNT(*) FROM status AS s WHERE c.company=s.company AND c.denom=s.denom AND c.cluster=s.cluster AND c.lot=s.lot AND c.sublot=s.sublot AND c.serial=s.serial AND s.status IN (7,11,13,14)) GROUP BY c.denom, c.cluster, c.lot, c.sublot, c.serial order BY c.manuf_no ";

	public final static String listserialStatusDistributer =
			" SELECT c.company, c.denom, c.cluster, c.lot, c.sublot, c.serial FROM card AS c WHERE c.company=? AND c.distributer=? AND c.selling_route IS NULL AND c.bill IS NULL AND c.manuf_no BETWEEN ? AND ? GROUP BY c.serial order BY c.manuf_no ";

	public final static String updateDistributerManuf =
			" UPDATE card SET distributer=?, distrib_usr=?, distrib_date=DATE(CONVERT_TZ(NOW(),(SELECT @@global.system_time_zone),(SELECT time_zone FROM company WHERE company=?))) WHERE company=? AND distributer=? AND manuf_no BETWEEN ? AND ? ";



	//IS  ********************* DEPOSITOS IS *************************

	public final static String createDepositIS = //OJO ESTA APROBANDO EL DEPOSITO AUTOMATICAMENTE, HAY QUE CAMBIARLO A FALSE CUANDO SE IMPLEMENTE EL VALIDAR DEPOSITO.
			"INSERT INTO deposit (company, control_number, deposit_date, bank, distributer, selling_route, deposit_usr, approved, approval_usr, concil_date, deposit_aux, amount) values (?,?,?,?,?,?,?,true,?,NULL,2,?);";

	public final static String createEcard = //OJO HARDCODED el null del e_pos y del e_buy)
			"INSERT INTO e_card VALUES (?,?,?,?,?,?,?,(SELECT client FROM client WHERE company=? AND user=?),NULL,NULL,?);";

	public final static String createEstatus = //OJO HARDCODED EL ESTATUS, CONFIRMATION, LOG_CODE, TRACE 
			"INSERT INTO e_status VALUES (?,?,?,?,?,?,14,UTC_TIME(),UTC_DATE(),?,1,617283,928741,?);";

	public final static String reportCardTransIS = 
			"SELECT u.login AS name, ec.e_pos AS pos, c.name AS company, CONCAT(ec.denom,LPAD(ec.cluster,3,'0'),LPAD(ec.lot,5,'0'),LPAD(ec.sublot,5,'0'),LPAD(ec.serial,2,'0')) AS serial, DATE(CONVERT_TZ(CONCAT(s.set_date,' ',s.set_time),'UTC',(SELECT time_zone FROM company WHERE company=t1.company))) AS date, ec.amount AS amount, st.sim AS smartcard FROM "+report_from+" e_card AS ec ON ec.user_company=t1.company STRAIGHT_JOIN e_status AS st ON st.company=ec.company AND  st.denom=ec.denom AND st.cluster=ec.cluster AND st.lot=ec.lot AND st.sublot=ec.sublot and st.serial=ec.serial STRAIGHT_JOIN user AS u ON ec.user_company=u.company AND ec.user=u.user STRAIGHT_JOIN company AS c ON ec.company=c.company WHERE st.status = 1 and date(CONVERT_TZ(CONCAT(s.set_date,' ',s.set_time),'UTC',(SELECT time_zone FROM company WHERE company=t1.company))) BETWEEN ? AND ? AND s.set_date BETWEEN SUBDATE(?,INTERVAL 1 DAY) AND ADDDATE(?,INTERVAL 1 DAY) ORDER BY company, date DESC";


	public final static String reportDepositTransIS = 
			"SELECT de.deposit_date AS date, de.control_number AS description, de.amount AS amount, ba.name AS bank, if(de.approved, 'APROBADO', 'PENDIENTE') AS approved FROM deposit AS de STRAIGHT_JOIN bank AS ba ON IF(de.distributer<235,de.company,235)=ba.company AND de.bank=ba.bank WHERE de.company = ? AND de.selling_route = ? AND de.distributer = ?"+
					" AND de.deposit_date BETWEEN ? AND ? ORDER BY de.deposit_date DESC"; //TODO obtener bancos de smartcall no hardcoded

	public final static String reportDepositIS =
			" SELECT cl.name, dep.deposit_date, ba.name, dep.control_number, FORMAT(dep.amount,2), IF(dep.approved,'Aprobado','Por Aprobar'), IF(dep.concil_date IS NOT NULL,'Conciliado','Por Conciliar'), IF(dep.concil_date IS NULL,'',dep.concil_date)"+ 
					" FROM deposit AS dep "+
					" STRAIGHT_JOIN user AS eu ON dep.company=eu.company AND dep.deposit_usr=eu.user"+ 
					" STRAIGHT_JOIN client AS cl ON eu.company=cl.company AND eu.client=cl.client "+
					" STRAIGHT_JOIN bank AS ba ON IF(dep.distributer<235,dep.company,235)=ba.company AND dep.bank=ba.bank "+
					" WHERE dep.company=1 AND dep.deposit_usr=4 AND dep.deposit_date between 20110301 AND 20110312 AND ba.bank=2 AND dep.approved IS TRUE AND dep.concil_date IS NULL"+ 
					" ORDER BY cl.name ASC, dep.deposit_date DESC, ba.name, dep.control_number, FORMAT(dep.amount,2);"; //TODO Obtener bancos de smartcall no hardcoded


	public final static String reportBalanceIS =
			"SELECT if(count(d.amount)!=0,sum(d.amount),0)-(SELECT if(count(c.amount)!=0,sum(c.amount),0) FROM e_card AS c WHERE c.company=? AND c.user=?) - (SELECT if(count(t.amount)!=0,sum(t.amount),0) FROM e_transfer AS t WHERE t.company=? AND t.user=?) FROM deposit AS d WHERE d.company=? AND d.deposit_usr=?;";

	//public static final String getUsersForTransfer = "SELECT u_hijo.user, u_hijo.login FROM client AS c_padre STRAIGHT_JOIN user AS u_hijo ON c_padre.company=u_hijo.company STRAIGHT_JOIN client AS c_hijo ON c_hijo.company=u_hijo.company AND u_hijo.client=c_hijo.client AND c_hijo.parent=c_padre.client WHERE c_padre.parent is NULL AND c_hijo.parent is NOT NULL AND c_padre.company=? AND c_padre.client=?;";
	public static final String getUsersForTransfer = "SELECT u.user, u.login FROM client AS c STRAIGHT_JOIN user AS u ON u.company=c.company AND u.client=c.client WHERE c.company=? AND c.parent=?";

	public static final String getServiceCompanies = "SELECT company, name FROM user_arrangement AS a STRAIGHT_JOIN company AS c ON c.company=a.service_company WHERE a.seller_company=? AND a.user=?";

	public static final String reportSalesByLocIS = "SELECT st.description, mun.description, ct.description, COUNT(*), FORMAT(AVG(dep.amount),2), FORMAT(SUM(dep.amount),2)"+
			" FROM deposit AS dep"+ 
			" JOIN user AS eu ON dep.company=eu.company AND dep.deposit_usr=eu.user"+ 
			" STRAIGHT_JOIN client AS cl ON eu.company=cl.company AND eu.client=cl.client"+
			" STRAIGHT_JOIN state AS st ON cl.state=st.state"+
			" STRAIGHT_JOIN municipality AS mun ON cl.state=mun.state AND cl.municipality=mun.municipality"+ 
			" STRAIGHT_JOIN city AS ct ON cl.state=ct.state AND cl.municipality=ct.municipality AND cl.city=ct.city"+  
			" WHERE eu.company=? AND dep.deposit_date between ? AND ? AND eu.user=?"+
			" GROUP BY st.description, mun.description, ct.description ASC;";

	public static final String reportSalesByLocMasterIS = "SELECT st.description, mun.description, ct.description, COUNT(*), FORMAT(AVG(dep.amount),2), FORMAT(SUM(dep.amount),2)"+
			" FROM deposit AS dep"+
			" STRAIGHT_JOIN user AS eu ON dep.company=eu.company AND dep.deposit_usr=eu.user"+ 
			" STRAIGHT_JOIN client AS cl ON eu.company=cl.company AND eu.client=cl.client"+
			" STRAIGHT_JOIN state AS st ON cl.state=st.state"+
			" STRAIGHT_JOIN municipality AS mun ON cl.state=mun.state AND cl.municipality=mun.municipality"+ 
			" STRAIGHT_JOIN city AS ct ON cl.state=ct.state AND cl.municipality=ct.municipality AND cl.city=ct.city"+  
			" WHERE eu.company=? AND dep.deposit_date between ? AND ?"+
			" GROUP BY st.description, mun.description, ct.description ASC WITH ROLLUP;";

	public static final String findClients = "SELECT cl.client, cl.name FROM client AS cl WHERE cl.company=?;";

	public static final String findUsersFromCLient = "SELECT eu.user, eu.login FROM user AS eu WHERE company=? AND client=?;";

	public static final String findManufacturers = "SELECT manufacturer, description FROM manufacturer WHERE company=?;";

	public static final String findFacing = "SELECT DISTINCT(cluster) , CONCAT('Cluster ', cluster, ' - ', IF(facial IS NULL,CONCAT('Cluster ',cluster),facial)) FROM cluster WHERE company=? GROUP BY cluster;";

	public static final String pinLotRequest = "INSERT INTO pin_ticket (company,pin_ticket,denom,quantity,user,processed,manufacturer,facial_description) VALUES (?,(SELECT IF(MAX(pin_ticket) is NULL,0,MAX(pin_ticket))+1 FROM (SELECT pin_ticket,company FROM pin_ticket) AS t WHERE company = ?),?,?,?,?,?,?) ;";

	public static final String getPendingRequest = "SELECT pa.value,pt.quantity,ma.description,date(pt.timestamp),pt.pin_ticket, pt.facial_description FROM pin_ticket AS pt STRAIGHT_JOIN manufacturer AS ma ON pt.company=ma.company AND pt.manufacturer=ma.manufacturer STRAIGHT_JOIN packing AS pa ON pa.company=pt.company AND pa.denom=pt.denom WHERE pt.company=? AND pt.processed=0 AND ma.manufacturer=? AND pa.denom=? ORDER BY date(pt.timestamp) DESC, ma.manufacturer, pt.denom ASC;";

	public static final String bill_CheckArchBill = "SELECT * FROM arch_bill WHERE company=? AND distributer=? AND control_number=?;";

	//IS
	//public static final String getLevels = "SELECT l.level, l.description FROM sec_level AS l STRAIGHT_JOIN sec_level_profile AS lp ON l.level=lp.level STRAIGHT_JOIN sec_profile AS p ON lp.profile=p.profile STRAIGHT_JOIN sec_profile_rol AS pr ON p.profile=pr.profile STRAIGHT_JOIN sec_rol AS r ON pr.rol=r.rol WHERE r.rol_name like '%IS%CREDIT%USER%' AND l.description like 'Vendedor%' ORDER BY l.level ASC;";

	public static final String getPaths = "SELECT IF(directory IS NOT NULL,directory,'/home/'), IF(directory_user IS NOT NULL,directory_user,'root'), IF(directory_group IS NOT NULL,directory_group,'root'), IF(directory_opp IS NOT NULL,directory_opp,'/home/'), IF(directory_opp_user IS NOT NULL,directory_opp_user,'root'), IF(directory_opp_group IS NOT NULL,directory_opp_group,'root'), IF(name IS NOT NULL,name,'FILE') FROM company WHERE company=?;";

	//*********************************************************************Pagos de ticket************************************************************************
	public static final String findTicket_to_cash = "SELECT FORMAT((?/percent),2) FROM deduction WHERE company=?;";

	public static final String checkUser = "SELECT e_customer FROM e_customer WHERE company=? AND account_no=?;";
	
	public static final String getDeduction = "SELECT percent FROM deduction WHERE company=? AND CURDATE() BETWEEN valid_FROM AND valid_to;";
	public static final String reportHistoricClosure = "CALL getClosureReport(?,?,?);";
	
	public static final String usersToApprove = "SELECT u.user, u.name, u.lastname FROM user AS u, client AS cl WHERE u.company = cl.company AND u.client = cl.client AND u.company=? AND u.level=45 AND cl.state = ? AND cl.municipality = ? AND cl.city = ?;";
	public static final String pendingStates = "SELECT st.state, st.description, count(*) FROM state AS st, user AS u, client AS cl WHERE st.state = cl.state AND cl.company = u.company AND cl.client = u.client AND u.level = 45 AND u.company = ? AND u.active=1 GROUP BY st.state;";
	public static final String pendingMunicipalities = "SELECT m.municipality,m.description, count(*) FROM municipality AS m, user AS u, client AS cl WHERE m.state = cl.state AND m.municipality = cl.municipality AND cl.company = u.company AND cl.client = u.client AND u.level = 45 AND u.company = ? AND m.state = ? GROUP BY m.municipality;";
	public static final String pendingCities = "SELECT c.city, c.description, count(*) FROM city AS c, user AS u, client AS cl WHERE c.state = cl.state AND c.municipality = cl.municipality AND c.city = cl.city AND cl.company = u.company AND cl.client = u.client AND u.level = 45 AND u.company = ? AND c.state = ? AND c.municipality = ? GROUP BY c.city;";
	public static final String authorizedApproversMailList = "SELECT u.email FROM user AS u, sec_level_profile AS slp, sec_profile_rol AS spr, sec_rol AS sr WHERE u.level = slp.level AND slp.profile = spr.profile AND spr.rol = sr.rol AND sr.rol_name = 'IS_APPROVE_USER' AND u.level NOT IN (98,99) AND u.company = ?;";
	public static final String authorizedDepApproversMailList = "SELECT u.email FROM user AS u, sec_level_profile AS slp, sec_profile_rol AS spr, sec_rol AS sr WHERE u.level = slp.level AND slp.profile = spr.profile AND spr.rol = sr.rol AND sr.rol_name = 'IS_APPROVE_DEPOSIT' AND u.level NOT IN (98,99) AND u.company = ?;";
	public static final String depositNotificationData = "SELECT d.control_number, u.email, d.bank FROM deposit AS d, user AS u WHERE d.deposit_usr = u.user AND d.deposit = ?;";
	
	//********************************************************************cubo de información de recargas*************************************************************
	
	public static final String getChannel = "SELECT channel,description_channel FROM dim_method WHERE company=? GROUP BY channel;";
	
	public static final String getCompany = " SELECT a.service_company, c.name FROM arrangement AS a JOIN company AS c ON a.service_company=c.company WHERE a.seller_company=?;";
	
	public static final String getCondition = " SELECT DISTINCT dp.promotion, IF(dp.promotion=9, 'Liquidada', CONCAT('Tarjeta Promocional Codigo ', dp.promotion)) FROM dim_packing AS dp WHERE dp.company=? ORDER BY dp.promotion;";
	
	public static final String getUserPayment = "SELECT DISTINCT(payment_method) ,description_payment_method FROM dim_method WHERE company=?;";

	public static final String getRedPayment = "SELECT payment_type,description_type FROM dim_method WHERE company=? AND channel=? GROUP BY payment_type;";
	
	public static final String getDistributers = "SELECT cdn.level_1,name FROM dim_network AS cdn STRAIGHT_JOIN company AS c ON c.company=cdn.level_1 WHERE cdn.company=? GROUP BY name";
	
	public static final String getDistributers2 = "SELECT cdn.level_2,name FROM dim_network AS cdn STRAIGHT_JOIN company AS c ON c.company=cdn.level_2 WHERE cdn.company=? AND cdn.level_1=? GROUP BY name";
	
	public static final String getDistributers3 = "SELECT cdn.level_3,name FROM dim_network AS cdn STRAIGHT_JOIN company AS c ON c.company=cdn.level_3 WHERE cdn.company=? AND cdn.level_1=? AND cdn.level_2=? GROUP BY name";
	
	//********************************************************************Commercial Networks****************************************************************************
	
	public static final String sellerCompany = "SELECT co.company, co.name FROM arrangement AS ar STRAIGHT_JOIN company AS co ON co.company=ar.seller_company WHERE ar.service_company=? AND ar.seller_company!=? GROUP BY co.company, co.name;";
	
	public static final String sellerCompanyList = "SELECT co.company, co.name FROM arrangement AS ar STRAIGHT_JOIN company AS co ON co.company=ar.seller_company GROUP BY co.company;";
			
	public static final String getECardPreClosingReportZone = "SELECT  service_company, seller_company, SUM(txn), FORMAT(SUM(total_txn_amount),2), FORMAT(SUM(total_deposit_amount),2) FROM (SELECT cs.name AS service_company, sc.name AS seller_company, COUNT(*) AS txn, SUM(ec.amount)  AS total_txn_amount, SUM(d.amount+IFNULL(d_aux.amount,0))/COUNT(*) AS total_deposit_amount FROM deposit AS d JOIN account_to_pay AS atp1 ON d.distributer=atp1.payer_company AND d.deposit=atp1.deposit JOIN account_to_pay_relation AS atpr ON atp1.payer_company=atpr.agent_company AND atp1.user=atpr.agent_user AND atp1.account_to_pay=atpr.agent_account_to_pay JOIN account_to_pay AS atp2 ON atp2.payer_company=atpr.seller_company AND atp2.user=atpr.seller_user AND atp2.account_to_pay=atpr.seller_account_to_pay JOIN e_card AS ec ON ec.user_company=atp2.payer_company AND ec.user=atp2.user AND ec.account_to_pay=atp2.account_to_pay JOIN company AS cs ON ec.company=cs.company JOIN company AS sc ON ec.user_company=sc.company LEFT OUTER JOIN deposit AS d_aux ON d.deposit=d_aux.deposit_aux AND d_aux.amount>0 WHERE d.company=? AND d.distributer = ? AND d.concil_date IS NULL AND d.amount>0 AND d.approved = TRUE AND	ec.user_company != ?  AND d.deposit_date<curdate() GROUP BY service_company, seller_company, d.deposit) AS t1 GROUP BY service_company, seller_company;";	

	public static final String validationClose = "SELECT COUNT(DISTINCT CONCAT(ec.company,ec.denom,ec.cluster,ec.lot,ec.sublot,ec.serial)) FROM e_card AS ec STRAIGHT_JOIN e_buy AS eb ON eb.company=ec.company AND eb.e_buy=ec.e_buy WHERE	ec.company=? AND eb.deposit IS NULL AND ec.closeout_date < CURDATE();";
	
	public static final String depositsByASellerCompany = "SELECT d.deposit, ba.account_number, DATE_FORMAT(d.deposit_date, '%d%m%Y'), CONCAT(CAST(d.control_number AS UNSIGNED)), CEILING(d.amount), d2.deposit, ba2.account_number, DATE_FORMAT(d2.deposit_date, '%d%m%Y'), CONCAT(CAST(d2.control_number AS UNSIGNED)), CEILING(d2.amount) FROM deposit AS d JOIN bank as ba ON d.company=ba.company AND d.bank=ba.bank JOIN account_to_pay AS atp1 ON d.deposit=atp1.deposit JOIN account_to_pay_relation AS atpr ON atp1.payer_company=atpr.agent_company AND atp1.user=atpr.agent_user AND atp1.account_to_pay=atpr.agent_account_to_pay JOIN account_to_pay AS atp2 ON atp2.payer_company=atpr.seller_company AND atp2.user=atpr.seller_user AND atp2.account_to_pay=atpr.seller_account_to_pay LEFT JOIN deposit AS d2 ON d2.deposit_aux=d.deposit AND d2.amount>0 LEFT JOIN bank AS ba2 ON d2.company=ba2.company AND d2.bank=ba2.bank WHERE d.company=? AND d.approved IS TRUE AND d.deposit_date<CURRENT_DATE() AND d.concil_date IS NULL AND d.amount>0 AND atp2.payer_company=? GROUP BY d.deposit ORDER BY d.deposit ASC;";
	
	public static final String depositsNumberByASellerCompany = "SELECT d.deposit FROM deposit AS d JOIN bank as ba ON d.company=ba.company AND d.bank=ba.bank JOIN account_to_pay AS atp1 ON d.deposit=atp1.deposit JOIN account_to_pay_relation AS atpr ON atp1.payer_company=atpr.agent_company AND atp1.user=atpr.agent_user AND atp1.account_to_pay=atpr.agent_account_to_pay JOIN account_to_pay AS atp2 ON atp2.payer_company=atpr.seller_company AND atp2.user=atpr.seller_user AND atp2.account_to_pay=atpr.seller_account_to_pay LEFT JOIN deposit AS d2 ON d2.deposit_aux=d.deposit AND d2.amount>0 LEFT JOIN bank AS ba2 ON d2.company=ba2.company AND d2.bank=ba2.bank WHERE d.company=? AND d.approved IS TRUE AND d.deposit_date<CURRENT_DATE() AND d.concil_date IS NULL AND d.amount>0 AND atp2.payer_company=? GROUP BY d.deposit ORDER BY d.deposit ASC;";
	
	public static final String updateConciliatedDepositsByID = "UPDATE deposit SET concil_date=? WHERE deposit=? OR deposit_aux=?";
	
	//********************************************************************POS AND ELECTRONIC RECHARGES****************************************************************************
	
	public static final String agentCompany = "SELECT co.company, co.name FROM arrangement AS ar STRAIGHT_JOIN company AS co ON co.company=ar.seller_company WHERE ar.service_company=? AND ar.seller_company=? GROUP BY co.company, co.name;";
	
	public static final String eposDelUsuario = "SELECT pos.e_pos AS e_pos, pos.description AS descripcion, ind.description AS industria, st.description AS estado, mun.description AS municipio, ci.description AS ciudad FROM user AS eu STRAIGHT_JOIN e_pos AS pos ON eu.user=pos.user AND eu.company=pos.company LEFT JOIN industry AS ind ON pos.industry=ind.industry LEFT JOIN city AS ci ON pos.state=ci.state AND pos.municipality=ci.municipality AND pos.city=ci.city LEFT JOIN municipality as mun ON ci.state=mun.state AND ci.municipality=mun.municipality LEFT JOIN state AS st ON mun.state=st.state WHERE eu.user=?;";
	
	public static final String eposDetail = "SELECT pos.company AS compania, pos.user AS usuario, pos.e_pos AS e_pos, pos.description AS descripcion, ind.industry AS industria, st.state AS estado, mun.municipality AS municipio, ci.city AS ciudad, pos.active AS activo FROM e_pos as pos STRAIGHT_JOIN industry AS ind ON pos.industry=ind.industry STRAIGHT_JOIN city AS ci ON pos.state=ci.state AND pos.municipality=ci.municipality AND pos.city=ci.city STRAIGHT_JOIN municipality as mun ON ci.state=mun.state AND ci.municipality=mun.municipality STRAIGHT_JOIN state AS st ON mun.state=st.state WHERE pos.company=? AND pos.user=? AND pos.e_pos=?;";
	
	public static final String outsideVendorsList = "SELECT user, CONCAT(login,' - ',name,' ',lastname) FROM user AS eu WHERE eu.company=? AND 0 != (SELECT count(*) FROM user_arrangement AS ua WHERE ua.seller_company=eu.company AND ua.user=eu.user);";
	
	public static final String findClientFromUser = "SELECT u.company, u.client FROM user AS eu WHERE company=? AND user=?;";
	
	public static final String getVIPreClosingReportZone = "SELECT  service_company, SUM(txn), FORMAT(SUM(total_txn_amount),2), FORMAT(SUM(total_deposit_amount),2) FROM (SELECT cs.name AS service_company, COUNT(*) AS txn, SUM(ec.amount)  AS total_txn_amount, SUM(d.amount+IFNULL(d_aux.amount,0))/COUNT(*) AS total_deposit_amount FROM deposit AS d JOIN account_to_pay AS atp1 ON d.distributer=atp1.payer_company AND d.deposit=atp1.deposit JOIN	account_to_pay_relation AS atpr ON atp1.payer_company=atpr.agent_company AND atp1.user=atpr.agent_user AND atp1.account_to_pay=atpr.agent_account_to_pay JOIN account_to_pay AS atp2 ON atp2.payer_company=atpr.seller_company AND atp2.user=atpr.seller_user AND atp2.account_to_pay=atpr.seller_account_to_pay JOIN e_card AS ec ON ec.user_company=atp2.payer_company AND ec.user=atp2.user AND ec.account_to_pay=atp2.account_to_pay JOIN company AS cs ON ec.company=cs.company LEFT OUTER JOIN deposit AS d_aux ON d.company=d_aux.company AND d.deposit=d_aux.deposit_aux AND d_aux.amount>0 WHERE d.company=? AND d.distributer = ? AND d.concil_date IS NULL AND d.approved = TRUE AND d.amount>0 AND	ec.user_company = ?  AND d.deposit_date<curdate() GROUP BY service_company, d.deposit) AS t1 GROUP BY service_company;";	
	
	public static final String getServiceCompanyUser = "SELECT service_company, c.name FROM user_arrangement AS a STRAIGHT_JOIN company AS c ON a.service_company=c.company WHERE a.seller_company=? AND a.user=?;";
	
	public static final String getUserEpos = "(SELECT user AS usuario, name AS nombre FROM user WHERE company=? AND user=?) UNION (SELECT u2.user AS usuario, u2.name AS nombre FROM user AS u JOIN client AS c ON u.company=c.company AND u.client=c.client JOIN client AS c2 ON c.company=c2.company AND c.client=c2.parent JOIN user AS u2 ON u2.company=c2.company AND u2.client=c2.client WHERE u.company=? AND u.user=?);";
	
	public static final String getEpos = "SELECT e_pos, description FROM e_pos WHERE company=? AND user=?;";

	/********************************** report Type ********************************/
	
	public static final short AccountPerPay = 1;
	public static final short AccountToCharge = 2;
	public static final short Analitic = 3;

	
	
	
	//************************************ VIDEO ******************************//
	public static final String videoList = "SELECT id_video,description,link FROM user_video AS uv JOIN video AS v ON uv.video_id=v.id_video WHERE user_id=?;";
	
	public static final String videoListComp = "SELECT v.id_video,description,link FROM company_video AS uv JOIN video AS v ON uv.id_video=v.id_video WHERE uv.id_company=?;";
	
	public static final String userList = "SELECT user,name FROM user WHERE company=?;";
}	

