package ve.com.plasmodium.control;

import java.util.Collection;
import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.apache.log4j.Logger;

@ManagedBean(name="AuthorizationBean")
@SessionScoped
public class AuthorizationBean { 

	public static final Logger logger = Logger.getLogger(AuthorizationBean.class);

	private boolean ACCESS_DENIED = false;
	private boolean ACC_NUM_DETAILED_RECHARGE_SUMMARY = false;
	private boolean ACC_NUM_RECHARGE_REPORT = false;
	private boolean ACC_NUM_SUMMARRY_RECHARGE_REPORT = false;
	private boolean ACTIVE_ROUTE = false;
	private boolean ACTIVE_ROUTE_STOLEN = false;
	private boolean ACTIVITY_0900_REPORT_1 = false;
	private boolean ACTIVITY_0900_REPORT_2 = false;
	private boolean ACTIVITY_0900_REPORT_3 = false;
	private boolean ACTIVITY_CONCIL_REPORT = false;
	private boolean ACTIVITY_SMS_REPORT_1 = false;
	private boolean ACTIVITY_SMS_REPORT_2 = false;
	private boolean ACTIVITY_SMS_REPORT_3 = false;
	private boolean ADD_CUSTOMER_BUY = false;
	private boolean ADD_E_POS = false;
	private boolean ADD_E_POS_TOPUP = false;
	private boolean ADMIN_MENU = false;
	private boolean ANALYTICAL_LIQUIDATION_REPORT = false;
	private boolean ANALYTICAL_RECHARGE_REPORT = false;
	private boolean ANALYTICAL_REPORTS = false;
	private boolean APPROVE_DEPOSIT = false;
	private boolean APPROVE_DEPOSIT_GRE = false;
	private boolean ASSIGNMENT_HISTORY = false;
	private boolean ASSIGN_LEVEL1 = false;
	private boolean ASSIGN_LEVEL10 = false;
	private boolean ASSIGN_LEVEL11 = false;
	private boolean ASSIGN_LEVEL12 = false;
	private boolean ASSIGN_LEVEL13 = false;
	private boolean ASSIGN_LEVEL14 = false;
	private boolean ASSIGN_LEVEL15 = false;
	private boolean ASSIGN_LEVEL16 = false;
	private boolean ASSIGN_LEVEL17 = false;
	private boolean ASSIGN_LEVEL18 = false;
	private boolean ASSIGN_LEVEL19 = false;
	private boolean ASSIGN_LEVEL2 = false;
	private boolean ASSIGN_LEVEL20 = false;
	private boolean ASSIGN_LEVEL21 = false;
	private boolean ASSIGN_LEVEL22 = false;
	private boolean ASSIGN_LEVEL23 = false;
	private boolean ASSIGN_LEVEL24 = false;
	private boolean ASSIGN_LEVEL25 = false;
	private boolean ASSIGN_LEVEL26 = false;
	private boolean ASSIGN_LEVEL27 = false;
	private boolean ASSIGN_LEVEL28 = false;
	private boolean ASSIGN_LEVEL29 = false;
	private boolean ASSIGN_LEVEL3 = false;
	private boolean ASSIGN_LEVEL30 = false;
	private boolean ASSIGN_LEVEL31 = false;
	private boolean ASSIGN_LEVEL32 = false;
	private boolean ASSIGN_LEVEL33 = false;
	private boolean ASSIGN_LEVEL34 = false;
	private boolean ASSIGN_LEVEL35 = false;
	private boolean ASSIGN_LEVEL36 = false;
	private boolean ASSIGN_LEVEL37 = false;
	private boolean ASSIGN_LEVEL38 = false;
	private boolean ASSIGN_LEVEL39 = false;
	private boolean ASSIGN_LEVEL4 = false;
	private boolean ASSIGN_LEVEL40 = false;
	private boolean ASSIGN_LEVEL41 = false;
	private boolean ASSIGN_LEVEL42 = false;
	private boolean ASSIGN_LEVEL43 = false;
	private boolean ASSIGN_LEVEL44 = false;
	private boolean ASSIGN_LEVEL45 = false;
	private boolean ASSIGN_LEVEL46 = false;
	private boolean ASSIGN_LEVEL47 = false;
	private boolean ASSIGN_LEVEL48 = false;
	private boolean ASSIGN_LEVEL49 = false;
	private boolean ASSIGN_LEVEL5 = false;
	private boolean ASSIGN_LEVEL50 = false;
	private boolean ASSIGN_LEVEL51 = false;
	private boolean ASSIGN_LEVEL52 = false;
	private boolean ASSIGN_LEVEL53 = false;
	private boolean ASSIGN_LEVEL54 = false;
	private boolean ASSIGN_LEVEL55 = false;
	private boolean ASSIGN_LEVEL56 = false;
	private boolean ASSIGN_LEVEL57 = false;
	private boolean ASSIGN_LEVEL58 = false;
	private boolean ASSIGN_LEVEL59 = false;
	private boolean ASSIGN_LEVEL6 = false;
	private boolean ASSIGN_LEVEL60 = false;
	private boolean ASSIGN_LEVEL61 = false;
	private boolean ASSIGN_LEVEL62 = false;
	private boolean ASSIGN_LEVEL63 = false;
	private boolean ASSIGN_LEVEL64 = false;
	private boolean ASSIGN_LEVEL65 = false;
	private boolean ASSIGN_LEVEL66 = false;
	private boolean ASSIGN_LEVEL67 = false;
	private boolean ASSIGN_LEVEL68 = false;
	private boolean ASSIGN_LEVEL69 = false;
	private boolean ASSIGN_LEVEL7 = false;
	private boolean ASSIGN_LEVEL70 = false;
	private boolean ASSIGN_LEVEL71 = false;
	private boolean ASSIGN_LEVEL72 = false;
	private boolean ASSIGN_LEVEL73 = false;
	private boolean ASSIGN_LEVEL74 = false;
	private boolean ASSIGN_LEVEL75 = false;
	private boolean ASSIGN_LEVEL76 = false;
	private boolean ASSIGN_LEVEL77 = false;
	private boolean ASSIGN_LEVEL78 = false;
	private boolean ASSIGN_LEVEL79 = false;
	private boolean ASSIGN_LEVEL8 = false;
	private boolean ASSIGN_LEVEL80 = false;
	private boolean ASSIGN_LEVEL81 = false;
	private boolean ASSIGN_LEVEL82 = false;
	private boolean ASSIGN_LEVEL83 = false;
	private boolean ASSIGN_LEVEL84 = false;
	private boolean ASSIGN_LEVEL85 = false;
	private boolean ASSIGN_LEVEL86 = false;
	private boolean ASSIGN_LEVEL87 = false;
	private boolean ASSIGN_LEVEL88 = false;
	private boolean ASSIGN_LEVEL89 = false;
	private boolean ASSIGN_LEVEL9 = false;
	private boolean ASSIGN_LEVEL90 = false;
	private boolean ASSIGN_LEVEL91 = false;
	private boolean ASSIGN_LEVEL92 = false;
	private boolean ASSIGN_LEVEL93 = false;
	private boolean ASSIGN_LEVEL94 = false;
	private boolean ASSIGN_LEVEL95 = false;
	private boolean ASSIGN_LEVEL96 = false;
	private boolean ASSIGN_LEVEL97 = false;
	private boolean ASSIGN_LEVEL98 = false;
	private boolean ASSIGN_LEVEL99 = false;
	private boolean AVERAGE_RECHARGE_MONTH = false;
	private boolean AVERAGE_REPORTS = false;
	private boolean AVERAGE_SALE_MONTH = false;
	private boolean BILL_REPORTS = false;
	private boolean BILL_REPORT_BRIEF = false;
	private boolean BILL_REPORT_DETAIL = false;
	private boolean CARD_DISTRIB_CONTROL = false;
	private boolean CARD_STATUS_CONTROL = false;
	private boolean CARD_STATUS_CONTROL_RESTRICTED = false;
	private boolean CHAIN_LIQUIDATION = false;
	private boolean CHANGE_PASS = false;
	private boolean CHANGE_PASSWORD = false;
	private boolean CHANGE_PASSWORD_WEB_SERVICE = false;
	private boolean CHANGE_STATUS_10 = false;
	private boolean CHANGE_STATUS_11 = false;
	private boolean CHANGE_STATUS_12 = false;
	private boolean CHANGE_STATUS_13 = false;
	private boolean CHANGE_STATUS_14 = false;
	private boolean CHANGE_STATUS_2 = false;
	private boolean CHANGE_STATUS_3 = false;
	private boolean CHANGE_STATUS_5 = false;
	private boolean CHANGE_STATUS_6 = false;
	private boolean CHANGE_STATUS_61 = false;
	private boolean CHANGE_STATUS_7 = false;
	private boolean CHANGE_STATUS_8 = false;
	private boolean CHANGE_STATUS_CONTROL = false;
	private boolean CHANGE_STATUS_DIRECTV = false;
	private boolean CHANGE_STATUS_DIRECTV_2 = false;
	private boolean CHANGE_STATUS_DIRECTV_3 = false;
	private boolean CHANGE_STATUS_DIRECTV_4 = false;
	private boolean CHANGE_STATUS_DIRECTV_5 = false;
	private boolean CHANGE_STATUS_DIRECTV_6 = false;
	private boolean CHANGE_STATUS_DIRECTV_61 = false;
	private boolean CHANGE_STATUS_DIRECTV_8 = false;
	private boolean CHANGE_STATUS_DISTRIB = false;
	private boolean CHANGE_STATUS_E_DEBIT = false;
	private boolean CHANGE_STATUS_IVR = false;
	private boolean CHANGE_STATUS_MANUF = false;
	private boolean CHANGE_STATUS_NVRD = false;
	private boolean CLIENT_HISTORIC_SALES = false;
	private boolean CLIENT_LIST = false;
	private boolean CLIENT_REPORTS = false;
	private boolean CLIENT_ROUTE_ABSOLUTE_SALES = false;
	private boolean CLIENT_ROUTE_RELATIVE_SALES = false;
	private boolean CLIENT_SALES = false;
	private boolean CLOSEOUT = false;
	private boolean CLOSEOUT_MENU = false;
	private boolean CLOSE_TRANSACTION_LIST = false;
	private boolean CLOSING_GRE = false;
	private boolean CLOSING_LOG_REPORT = false;
	private boolean CLOSING_REPORTS = false;
	private boolean CLOSING_REPORTS_GRE = false;
	private boolean CONCIL_CARD_DETAIL = false;
	private boolean CONFIRM_CUSTOMER_BUY = false;
	private boolean CONFIRM_E_CARD_TOPUP = false;
	private boolean CONFIRM_STATUS_E_DEBIT = false;
	private boolean CONSOLIDATED_TRAFFIC_REPORT = false;
	private boolean CONTROL_REPORTS = false;
	private boolean CREATE_BANK = false;
	private boolean CREATE_BILL = false;
	private boolean CREATE_CLIENT = false;
	private boolean CREATE_COMPANY = false;
	private boolean CREATE_CONCILIATION_FILE = false;
	private boolean CREATE_CONCILIATION_FILE_TOPUP = false;
	private boolean CREATE_CUSTOMER = false;
	private boolean CREATE_DEPOSIT = false;
	private boolean CREATE_DEPOSIT_CHAIN = false;
	private boolean CREATE_DEPOSIT_GRE = false;
	private boolean CREATE_E_CARD_TOPUP = false;
	private boolean CREATE_E_DEBIT = false;
	private boolean CREATE_PIN = false;
	private boolean CREATE_PROMOTION = false;
	private boolean CREATE_ROUTE = false;
	private boolean CREATE_USER = false;
	private boolean CREDIT_CARD_PAYMENT = false;
	private boolean DEBIT_PRODUCT_TO_CUSTOMER = false;
	private boolean DELETE_BANK = false;
	private boolean DELETE_CLIENT = false;
	private boolean DELETE_COMPANY = false;
	private boolean DELETE_E_POS = false;
	private boolean DELETE_E_POS_TOPUP = false;
	private boolean DELETE_PRICING = false;
	private boolean DELETE_PROMOTION = false;
	private boolean DELETE_ROUTE = false;
	private boolean DELETE_USER = false;
	private boolean DENOM_DISTRIBUTER_OP_SALES = false;
	private boolean DENOM_GENERAL_SALES = false;
	private boolean DENOM_GENERAL_OP_SALES = false;
	private boolean DENOM_RECHARGE_REPORT = false;
	private boolean DENOM_ROUTE_OP_SALES = false;
	private boolean DENOM_ROUTE_SALES = false;
	private boolean DENOM_ZONES_OP_SALES = false;
	private boolean DENOM_ZONES_SALES = false;
	private boolean DEPOSIT_DETAIL_SERIAL = false;
	private boolean DEPOSIT_REPORTS = false;
	private boolean DETAILED_TRAFFIC_REPORT = false;
	private boolean DISPLAY_CITY = false;
	private boolean DISPLAY_COMPANY = false;
	private boolean DISPLAY_DATE = false;
	private boolean DISPLAY_DENOM = false;
	private boolean DISPLAY_DISTRIBUTER = false;
	private boolean DISPLAY_FACIAL = false;
	private boolean DISPLAY_INDUSTRY = false;
	private boolean DISPLAY_METHOD_RECHARGE = false;
	private boolean DISPLAY_MUNICIPALITY = false;
	private boolean DISPLAY_PROMTION = false;
	private boolean DISPLAY_STATE = false;
	private boolean DISTRIBUTER_LOGISTIC_STOCK = false;
	private boolean DISTRIBUTER_OP_SALES = false;
	private boolean DISTRIBUTER_SALES = false;
	private boolean DISTRIBUTER_STOCK = false;
	private boolean DISTRIBUTION_REPORTS = false;
	private boolean DISTRIB_MENU = false;
	private boolean DISTRIB_ROUTE = false;
	private boolean DISTRIB_WAREHOUSE = false;
	private boolean DISTRIB_ZONE = false;
	private boolean DISTRIB_ZONE_WAREHOUSE = false;
	private boolean DISTRIB_ZONE_WAREHOUSE_MASTER = false;
	private boolean DIST_STATUS = false;
	private boolean EDIT = false;
	private boolean ELECTRONIC_LIQUIDATION_MENU = false;
	private boolean EMAIL = false;
	private boolean GENERAL_DEPOSIT = false;
	private boolean GENERAL_OP_SALES = false;
	private boolean GENERAL_PROMOTIONS_SALES = false;
	private boolean GENERAL_SALES = false;
	private boolean GENERAL_STATUS = false;
	private boolean GENERAL_STOCK = false;
	private boolean GET_BALANCE = false;
	private boolean GET_LAST_SUCCESSFULL_TOPUP = false;
	private boolean GET_PRICING_LIST = false;
	private boolean GET_PRICING_QUANTITY = false;
	private boolean GRE5_LIQUIDATION = false;
	private boolean INDICATOR_AMOUNT_RECHARGE = false;
	private boolean INDICATOR_RECHARGE = false;
	private boolean INSERT_WEB_PAYMENT_DATA = false;
	private boolean IS_APPROVED_USERS_REPORT = false;
	private boolean IS_APPROVE_DEPOSIT = false;
	private boolean IS_APPROVE_USER = false;
	private boolean IS_BALANCE_USER = false;
	private boolean IS_BUYS_MENU = false;
	private boolean IS_CHANGE_PASS = false;
	private boolean IS_CLOSEOUT_POS = false;
	private boolean IS_CREATE_POS = false;
	private boolean IS_CREATE_POS_WEB = false;
	private boolean IS_CREDIT_USER = false;
	private boolean IS_DELETE_POS = false;
	private boolean IS_DELETE_POS_WEB = false;
	private boolean IS_DEPOSIT_INDUSTRY_REPORT = false;
	private boolean IS_DEPOSIT_REPORT = false;
	private boolean IS_DEPOSIT_REPORT_GEOGRAPHIC = false;
	private boolean IS_DEPOSIT_REPORT_HISTORY = false;
	private boolean IS_D_TRANSFER = false;
	private boolean IS_E_TRANSFER = false;
	private boolean IS_NON_APPROVED_USER = false;
	private boolean IS_NON_CREDIT_USER = false;
	private boolean IS_POS_SALES_INDUSTRY_REPORT = false;
	private boolean IS_POS_SALES_LOCATION_REPORT = false;
	private boolean IS_POS_SALES_REPORT = false;
	private boolean IS_PREAPPROVED_NON_CREDIT_USER = false;
	private boolean IS_REGISTER_PAYMENT = false;
	private boolean IS_SALES_INDUSTRY_REPORT = false;
	private boolean IS_SALES_LIST = false;
	private boolean IS_SALES_LOCATION_REPORT = false;
	private boolean IS_SALES_REPORT = false;
	private boolean IS_SALES_REPORT_HISTORY = false;
	private boolean IS_SALES_REPORT_RESUME = false;
	private boolean IS_SALES_REPORT_TOTALS = false;
	private boolean IS_SELL_PIN = false;
	private boolean IS_SHOW_BALANCE = false;
	private boolean IS_SUBUSER_REGISTER = false;
	private boolean IS_UPDATE_POS = false;
	private boolean IS_UPDATE_POS_WEB = false;
	private boolean IS_USERS_REPORTS = false;
	private boolean IS_USER_REGISTER = false;
	private boolean IS_VIEW_POS_WEB = false;
	private boolean LAST_RECHARGE_POS = false;
	private boolean LIST_ACCOUNTTOPAY = false;
	private boolean LIST_ALL_ACCOUNTTOPAY = false;
	private boolean LIST_DEPOSIT_COMPANY = false;
	private boolean LIST_DEPOSIT_USER = false;
	private boolean LIST_DEPOSIT_USER_COMPANY = false;
	private boolean LOGISTIC_REPORTS = false;
	private boolean LOG_IN = false;
	private boolean LOG_IN_WEB_SERVICE = false;
	private boolean LOST_CARDS = false;
	private boolean MODIFY_BANK = false;
	private boolean MODIFY_BILL = false;
	private boolean MODIFY_CLIENT = false;
	private boolean MODIFY_COMPANY = false;
	private boolean MODIFY_DEPOSIT = false;
	private boolean MODIFY_DEPOSIT_CHAIN = false;
	private boolean MODIFY_DEPOSIT_GRE = false;
	private boolean MODIFY_PROMOTION = false;
	private boolean MODIFY_ROUTE = false;
	private boolean MODIFY_USER = false;
	private boolean OP_SALES_REPORTS = false;
	private boolean PIN_GENERATION_REQUEST = false;
	private boolean POSID_DETAILED_RECHARGE_REPORT_1 = false;
	private boolean POSID_DETAILED_RECHARGE_REPORT_2 = false;
	private boolean POSID_DETAILED_RECHARGE_REPORT_3 = false;
	private boolean PRECLOSING_REPORT = false;
	private boolean PRECLOSING_REPORT_GRE = false;
	private boolean PRECLOSING_REPORT_ZONE = false;
	private boolean PRECLOSING_REPORT_ZONE_GRE = false;
	private boolean PRICING_EDITOR = false;
	private boolean PRINT = false;
	private boolean PRINT_STATUS = false;
	private boolean PRINT_STATUS_BY_PIN = false;
	private boolean RANKING_REPORT_MAX = false;
	private boolean RANKING_REPORT_MIN = false;
	private boolean RECHARGE_ACTIVITY_REPORT = false;
	private boolean RECHARGE_CARDS = false;
	private boolean RECHARGE_TICKETS = false;
	private boolean RECHARGE_REPORTS = false;
	private boolean RED_PAYMENT = false;
	private boolean REPORTS_MENU = false;
	private boolean REVERSE_REPORT = false;
	private boolean REVERSE_ROUTE = false;
	private boolean REVERSE_WAREHOUSE = false;
	private boolean REVERSE_ZONE = false;
	private boolean ROUTE_DEPOSIT = false;
	private boolean ROUTE_LOGISTIC_STOCK = false;
	private boolean ROUTE_OP_SALES = false;
	private boolean ROUTE_PROMOTIONS_SALES = false;
	private boolean ROUTE_SALES = false;
	private boolean ROUTE_STATUS = false;
	private boolean ROUTE_STOCK = false;
	private boolean ROUTE_STOCK_DETAIL = false;
	private boolean SALES_MENU = false;
	private boolean SALES_REPORTS = false;
	private boolean SERIAL_DETAILED_RECHARGE_REPORT = false;
	private boolean SERVICES_REPORTS = false;
	private boolean SESSION_LOG = false;
	private boolean START_MENU = false;
	private boolean STATE_GENERAL_OP_SALES = false;
	private boolean STATE_ROUTE_OP_SALES = false;
	private boolean STATE_ZONES_OP_SALES = false;
	private boolean STATUS_REPORTS = false;
	private boolean STOCK_REPORTS = false;
	private boolean SUBDISTRIBUTER_LOGISTIC_STOCK = false;
	private boolean SWITCH_DISTRIBUTER = false;
	private boolean TICKET_AVERAGE_RECHARGE = false;
	private boolean TICKET_AVERAGE_SALE = false;
	private boolean TOTALS_RECHARGE_SALE = false;
	private boolean TOTALS_STATUS = false;
	private boolean TRAFFIC_REPORTS = false;
	private boolean UNDO_CUSTOMER_BUY = false;
	private boolean UNDO_E_CARD_TOPUP = false;
	private boolean UNUSED_BALANCE_REPORT = false;
	private boolean UPDATE_E_POS = false;
	private boolean UPDATE_E_POS_TOPUP = false;
	private boolean UPDATE_PRICING = false;
	private boolean USER_CALLCENTER = false;
	private boolean USER_PAYMENT = false;
	private boolean VIEW = false;
	private boolean VIEWER_LOG = false;
	private boolean VIEW_BANK = false;
	private boolean VIEW_CLIENT = false;
	private boolean VIEW_COMPANY = false;
	private boolean VIEW_PROMOTION = false;
	private boolean VIEW_ROUTE = false;
	private boolean VIEW_USER = false;
	private boolean ZONES_DEPOSIT = false;
	private boolean ZONES_LOGISTIC_STOCK = false;
	private boolean ZONES_OP_SALES = false;
	private boolean ZONES_PROMOTIONS_SALES = false;
	private boolean ZONES_SALES = false;
	private boolean ZONES_STATUS = false;
	private boolean ZONES_STOCK = false;

	
	public AuthorizationBean(){
		//AuthorizationManager authorizationManager = new AuthorizationManager(SQLConstant.MYSQL);
		SecurityContext sg = (SecurityContext) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("SPRING_SECURITY_CONTEXT");
		//authorizationManager.getAllRoles();
		Collection<? extends GrantedAuthority> ga = sg.getAuthentication().getAuthorities();
		/*for(int i =0 ; ga.size() > i ; i++){
			setValueToRol(company,((Map<String, Object>) ga).get(i).toString(),true);
		}*/
		Iterator<? extends GrantedAuthority> i = ga.iterator();
		while(i.hasNext()) {
			GrantedAuthority aux = (GrantedAuthority) i.next();
			setValueToRol(aux.toString(),true);
		}
	}
	
	/**
	 * Inicia los valores en TRUE de los roles 
	 * pertenecientes al usuario respectivo
	 * @param value Valor Boolean para iniciar el Rol
	 * @param index Valor del rol pertenecientes al usuario
	 * @param company Compa�ia a la cual pertenece el usuario  
	 * */
	public void setValueToRol(String rolName, boolean value){
		switch (rolName) {
			case("ACCESS_DENIED"): ACCESS_DENIED= value; break;
			case("ACC_NUM_DETAILED_RECHARGE_SUMMARY"): ACC_NUM_DETAILED_RECHARGE_SUMMARY = value; break;
			case("ACC_NUM_RECHARGE_REPORT"): ACC_NUM_RECHARGE_REPORT = value; break;
			case("ACC_NUM_SUMMARRY_RECHARGE_REPORT"): ACC_NUM_SUMMARRY_RECHARGE_REPORT = value; break;
			case("ACTIVE_ROUTE"): ACTIVE_ROUTE = value; break;
			case("ACTIVE_ROUTE_STOLEN"): ACTIVE_ROUTE_STOLEN = value; break;
			case("ACTIVITY_0900_REPORT_1"): ACTIVITY_0900_REPORT_1 = value; break;
			case("ACTIVITY_0900_REPORT_2"): ACTIVITY_0900_REPORT_2 = value; break;
			case("ACTIVITY_0900_REPORT_3"): ACTIVITY_0900_REPORT_3 = value; break;
			case("ACTIVITY_CONCIL_REPORT"): ACTIVITY_CONCIL_REPORT = value; break;
			case("ACTIVITY_SMS_REPORT_1"): ACTIVITY_SMS_REPORT_1 = value; break;
			case("ACTIVITY_SMS_REPORT_2"): ACTIVITY_SMS_REPORT_2 = value; break;
			case("ACTIVITY_SMS_REPORT_3"): ACTIVITY_SMS_REPORT_3 = value; break;
			case("ADD_CUSTOMER_BUY"): ADD_CUSTOMER_BUY = value; break;
			case("ADD_E_POS"): ADD_E_POS = value; break;
			case("ADD_E_POS_TOPUP"): ADD_E_POS_TOPUP = value; break;
			case("ADMIN_MENU"): ADMIN_MENU = value; break;
			case("ANALYTICAL_LIQUIDATION_REPORT"): ANALYTICAL_LIQUIDATION_REPORT = value; break;
			case("ANALYTICAL_RECHARGE_REPORT"): ANALYTICAL_RECHARGE_REPORT = value; break;
			case("ANALYTICAL_REPORTS"): ANALYTICAL_REPORTS = value; break;
			case("APPROVE_DEPOSIT"): APPROVE_DEPOSIT = value; break;
			case("APPROVE_DEPOSIT_GRE"): APPROVE_DEPOSIT_GRE = value; break;
			case("ASSIGNMENT_HISTORY"): ASSIGNMENT_HISTORY = value; break;
			case("ASSIGN_LEVEL1"): ASSIGN_LEVEL1 = value; break;
			case("ASSIGN_LEVEL10"): ASSIGN_LEVEL10 = value; break;
			case("ASSIGN_LEVEL11"): ASSIGN_LEVEL11 = value; break;
			case("ASSIGN_LEVEL12"): ASSIGN_LEVEL12 = value; break;
			case("ASSIGN_LEVEL13"): ASSIGN_LEVEL13 = value; break;
			case("ASSIGN_LEVEL14"): ASSIGN_LEVEL14 = value; break;
			case("ASSIGN_LEVEL15"): ASSIGN_LEVEL15 = value; break;
			case("ASSIGN_LEVEL16"): ASSIGN_LEVEL16 = value; break;
			case("ASSIGN_LEVEL17"): ASSIGN_LEVEL17 = value; break;
			case("ASSIGN_LEVEL18"): ASSIGN_LEVEL18 = value; break;
			case("ASSIGN_LEVEL19"): ASSIGN_LEVEL19 = value; break;
			case("ASSIGN_LEVEL2"): ASSIGN_LEVEL2 = value; break;
			case("ASSIGN_LEVEL20"): ASSIGN_LEVEL20 = value; break;
			case("ASSIGN_LEVEL21"): ASSIGN_LEVEL21 = value; break;
			case("ASSIGN_LEVEL22"): ASSIGN_LEVEL22 = value; break;
			case("ASSIGN_LEVEL23"): ASSIGN_LEVEL23 = value; break;
			case("ASSIGN_LEVEL24"): ASSIGN_LEVEL24 = value; break;
			case("ASSIGN_LEVEL25"): ASSIGN_LEVEL25 = value; break;
			case("ASSIGN_LEVEL26"): ASSIGN_LEVEL26 = value; break;
			case("ASSIGN_LEVEL27"): ASSIGN_LEVEL27 = value; break;
			case("ASSIGN_LEVEL28"): ASSIGN_LEVEL28 = value; break;
			case("ASSIGN_LEVEL29"): ASSIGN_LEVEL29 = value; break;
			case("ASSIGN_LEVEL3"): ASSIGN_LEVEL3 = value; break;
			case("ASSIGN_LEVEL30"): ASSIGN_LEVEL30 = value; break;
			case("ASSIGN_LEVEL31"): ASSIGN_LEVEL31 = value; break;
			case("ASSIGN_LEVEL32"): ASSIGN_LEVEL32 = value; break;
			case("ASSIGN_LEVEL33"): ASSIGN_LEVEL33 = value; break;
			case("ASSIGN_LEVEL34"): ASSIGN_LEVEL34 = value; break;
			case("ASSIGN_LEVEL35"): ASSIGN_LEVEL35 = value; break;
			case("ASSIGN_LEVEL36"): ASSIGN_LEVEL36 = value; break;
			case("ASSIGN_LEVEL37"): ASSIGN_LEVEL37 = value; break;
			case("ASSIGN_LEVEL38"): ASSIGN_LEVEL38 = value; break;
			case("ASSIGN_LEVEL39"): ASSIGN_LEVEL39 = value; break;
			case("ASSIGN_LEVEL4"): ASSIGN_LEVEL4 = value; break;
			case("ASSIGN_LEVEL40"): ASSIGN_LEVEL40 = value; break;
			case("ASSIGN_LEVEL41"): ASSIGN_LEVEL41 = value; break;
			case("ASSIGN_LEVEL42"): ASSIGN_LEVEL42 = value; break;
			case("ASSIGN_LEVEL43"): ASSIGN_LEVEL43 = value; break;
			case("ASSIGN_LEVEL44"): ASSIGN_LEVEL44 = value; break;
			case("ASSIGN_LEVEL45"): ASSIGN_LEVEL45 = value; break;
			case("ASSIGN_LEVEL46"): ASSIGN_LEVEL46 = value; break;
			case("ASSIGN_LEVEL47"): ASSIGN_LEVEL47 = value; break;
			case("ASSIGN_LEVEL48"): ASSIGN_LEVEL48 = value; break;
			case("ASSIGN_LEVEL49"): ASSIGN_LEVEL49 = value; break;
			case("ASSIGN_LEVEL5"): ASSIGN_LEVEL5 = value; break;
			case("ASSIGN_LEVEL50"): ASSIGN_LEVEL50 = value; break;
			case("ASSIGN_LEVEL51"): ASSIGN_LEVEL51 = value; break;
			case("ASSIGN_LEVEL52"): ASSIGN_LEVEL52 = value; break;
			case("ASSIGN_LEVEL53"): ASSIGN_LEVEL53 = value; break;
			case("ASSIGN_LEVEL54"): ASSIGN_LEVEL54 = value; break;
			case("ASSIGN_LEVEL55"): ASSIGN_LEVEL55 = value; break;
			case("ASSIGN_LEVEL56"): ASSIGN_LEVEL56 = value; break;
			case("ASSIGN_LEVEL57"): ASSIGN_LEVEL57 = value; break;
			case("ASSIGN_LEVEL58"): ASSIGN_LEVEL58 = value; break;
			case("ASSIGN_LEVEL59"): ASSIGN_LEVEL59 = value; break;
			case("ASSIGN_LEVEL6"): ASSIGN_LEVEL6 = value; break;
			case("ASSIGN_LEVEL60"): ASSIGN_LEVEL60 = value; break;
			case("ASSIGN_LEVEL61"): ASSIGN_LEVEL61 = value; break;
			case("ASSIGN_LEVEL62"): ASSIGN_LEVEL62 = value; break;
			case("ASSIGN_LEVEL63"): ASSIGN_LEVEL63 = value; break;
			case("ASSIGN_LEVEL64"): ASSIGN_LEVEL64 = value; break;
			case("ASSIGN_LEVEL65"): ASSIGN_LEVEL65 = value; break;
			case("ASSIGN_LEVEL66"): ASSIGN_LEVEL66 = value; break;
			case("ASSIGN_LEVEL67"): ASSIGN_LEVEL67 = value; break;
			case("ASSIGN_LEVEL68"): ASSIGN_LEVEL68 = value; break;
			case("ASSIGN_LEVEL69"): ASSIGN_LEVEL69 = value; break;
			case("ASSIGN_LEVEL7"): ASSIGN_LEVEL7 = value; break;
			case("ASSIGN_LEVEL70"): ASSIGN_LEVEL70 = value; break;
			case("ASSIGN_LEVEL71"): ASSIGN_LEVEL71 = value; break;
			case("ASSIGN_LEVEL72"): ASSIGN_LEVEL72 = value; break;
			case("ASSIGN_LEVEL73"): ASSIGN_LEVEL73 = value; break;
			case("ASSIGN_LEVEL74"): ASSIGN_LEVEL74 = value; break;
			case("ASSIGN_LEVEL75"): ASSIGN_LEVEL75 = value; break;
			case("ASSIGN_LEVEL76"): ASSIGN_LEVEL76 = value; break;
			case("ASSIGN_LEVEL77"): ASSIGN_LEVEL77 = value; break;
			case("ASSIGN_LEVEL78"): ASSIGN_LEVEL78 = value; break;
			case("ASSIGN_LEVEL79"): ASSIGN_LEVEL79 = value; break;
			case("ASSIGN_LEVEL8"): ASSIGN_LEVEL8 = value; break;
			case("ASSIGN_LEVEL80"): ASSIGN_LEVEL80 = value; break;
			case("ASSIGN_LEVEL81"): ASSIGN_LEVEL81 = value; break;
			case("ASSIGN_LEVEL82"): ASSIGN_LEVEL82 = value; break;
			case("ASSIGN_LEVEL83"): ASSIGN_LEVEL83 = value; break;
			case("ASSIGN_LEVEL84"): ASSIGN_LEVEL84 = value; break;
			case("ASSIGN_LEVEL85"): ASSIGN_LEVEL85 = value; break;
			case("ASSIGN_LEVEL86"): ASSIGN_LEVEL86 = value; break;
			case("ASSIGN_LEVEL87"): ASSIGN_LEVEL87 = value; break;
			case("ASSIGN_LEVEL88"): ASSIGN_LEVEL88 = value; break;
			case("ASSIGN_LEVEL89"): ASSIGN_LEVEL89 = value; break;
			case("ASSIGN_LEVEL9"): ASSIGN_LEVEL9 = value; break;
			case("ASSIGN_LEVEL90"): ASSIGN_LEVEL90 = value; break;
			case("ASSIGN_LEVEL91"): ASSIGN_LEVEL91 = value; break;
			case("ASSIGN_LEVEL92"): ASSIGN_LEVEL92 = value; break;
			case("ASSIGN_LEVEL93"): ASSIGN_LEVEL93 = value; break;
			case("ASSIGN_LEVEL94"): ASSIGN_LEVEL94 = value; break;
			case("ASSIGN_LEVEL95"): ASSIGN_LEVEL95 = value; break;
			case("ASSIGN_LEVEL96"): ASSIGN_LEVEL96 = value; break;
			case("ASSIGN_LEVEL97"): ASSIGN_LEVEL97 = value; break;
			case("ASSIGN_LEVEL98"): ASSIGN_LEVEL98 = value; break;
			case("ASSIGN_LEVEL99"): ASSIGN_LEVEL99 = value; break;
			case("AVERAGE_RECHARGE_MONTH"): AVERAGE_RECHARGE_MONTH = value; break;
			case("AVERAGE_REPORTS"): AVERAGE_REPORTS = value; break;
			case("AVERAGE_SALE_MONTH"): AVERAGE_SALE_MONTH = value; break;
			case("BILL_REPORTS"): BILL_REPORTS = value; break;
			case("BILL_REPORT_BRIEF"): BILL_REPORT_BRIEF = value; break;
			case("BILL_REPORT_DETAIL"): BILL_REPORT_DETAIL = value; break;
			case("CARD_DISTRIB_CONTROL"): CARD_DISTRIB_CONTROL = value; break;
			case("CARD_STATUS_CONTROL"): CARD_STATUS_CONTROL = value; break;
			case("CARD_STATUS_CONTROL_RESTRICTED"): CARD_STATUS_CONTROL_RESTRICTED = value; break;
			case("CHAIN_LIQUIDATION"): CHAIN_LIQUIDATION = value; break;
			case("CHANGE_PASS"): CHANGE_PASS = value; break;
			case("CHANGE_PASSWORD"): CHANGE_PASSWORD = value; break;
			case("CHANGE_PASSWORD_WEB_SERVICE"): CHANGE_PASSWORD_WEB_SERVICE = value; break;
			case("CHANGE_STATUS_CONTROL"): CHANGE_STATUS_CONTROL = value; break;
			case("CHANGE_STATUS_10"): CHANGE_STATUS_10 = value; break;
			case("CHANGE_STATUS_11"): CHANGE_STATUS_11 = value; break;
			case("CHANGE_STATUS_12"): CHANGE_STATUS_12 = value; break;
			case("CHANGE_STATUS_13"): CHANGE_STATUS_13 = value; break;
			case("CHANGE_STATUS_14"): CHANGE_STATUS_14 = value; break;
			case("CHANGE_STATUS_2"): CHANGE_STATUS_2 = value; break;
			case("CHANGE_STATUS_3"): CHANGE_STATUS_3 = value; break;
			case("CHANGE_STATUS_5"): CHANGE_STATUS_5 = value; break;
			case("CHANGE_STATUS_6"): CHANGE_STATUS_6 = value; break;
			case("CHANGE_STATUS_61"): CHANGE_STATUS_61 = value; break;
			case("CHANGE_STATUS_7"): CHANGE_STATUS_7 = value; break;
			case("CHANGE_STATUS_8"): CHANGE_STATUS_8 = value; break;
			case("CHANGE_STATUS_DIRECTV"): CHANGE_STATUS_DIRECTV = value; break;
			case("CHANGE_STATUS_DIRECTV_2"): CHANGE_STATUS_DIRECTV_2 = value; break;
			case("CHANGE_STATUS_DIRECTV_3"): CHANGE_STATUS_DIRECTV_3 = value; break;
			case("CHANGE_STATUS_DIRECTV_4"): CHANGE_STATUS_DIRECTV_4 = value; break;
			case("CHANGE_STATUS_DIRECTV_5"): CHANGE_STATUS_DIRECTV_5 = value; break;
			case("CHANGE_STATUS_DIRECTV_6"): CHANGE_STATUS_DIRECTV_6 = value; break;
			case("CHANGE_STATUS_DIRECTV_61"): CHANGE_STATUS_DIRECTV_61 = value; break;
			case("CHANGE_STATUS_DIRECTV_8"): CHANGE_STATUS_DIRECTV_8 = value; break;
			case("CHANGE_STATUS_DISTRIB"): CHANGE_STATUS_DISTRIB = value; break;
			case("CHANGE_STATUS_E_DEBIT"): CHANGE_STATUS_E_DEBIT = value; break;
			case("CHANGE_STATUS_IVR"): CHANGE_STATUS_IVR = value; break;
			case("CHANGE_STATUS_MANUF"): CHANGE_STATUS_MANUF = value; break;
			case("CHANGE_STATUS_NVRD"): CHANGE_STATUS_NVRD = value; break;
			case("CLIENT_HISTORIC_SALES"): CLIENT_HISTORIC_SALES = value; break;
			case("CLIENT_LIST"): CLIENT_LIST = value; break;
			case("CLIENT_REPORTS"): CLIENT_REPORTS = value; break;
			case("CLIENT_ROUTE_ABSOLUTE_SALES"): CLIENT_ROUTE_ABSOLUTE_SALES = value; break;
			case("CLIENT_ROUTE_RELATIVE_SALES"): CLIENT_ROUTE_RELATIVE_SALES = value; break;
			case("CLIENT_SALES"): CLIENT_SALES = value; break;
			case("CLOSEOUT"): CLOSEOUT = value; break;
			case("CLOSEOUT_MENU"): CLOSEOUT_MENU = value; break;
			case("CLOSE_TRANSACTION_LIST"): CLOSE_TRANSACTION_LIST = value; break;
			case("CLOSING_GRE"): CLOSING_GRE = value; break;
			case("CLOSING_LOG_REPORT"): CLOSING_LOG_REPORT = value; break;
			case("CLOSING_REPORTS"): CLOSING_REPORTS = value; break;
			case("CLOSING_REPORTS_GRE"): CLOSING_REPORTS_GRE = value; break;
			case("CONCIL_CARD_DETAIL"): CONCIL_CARD_DETAIL = value; break;
			case("CONFIRM_CUSTOMER_BUY"): CONFIRM_CUSTOMER_BUY = value; break;
			case("CONFIRM_E_CARD_TOPUP"): CONFIRM_E_CARD_TOPUP = value; break;
			case("CONFIRM_STATUS_E_DEBIT"): CONFIRM_STATUS_E_DEBIT = value; break;
			case("CONSOLIDATED_TRAFFIC_REPORT"): CONSOLIDATED_TRAFFIC_REPORT = value; break;
			case("CONTROL_REPORTS"): CONTROL_REPORTS = value; break;
			case("CREATE_BANK"): CREATE_BANK = value; break;
			case("CREATE_BILL"): CREATE_BILL = value; break;
			case("CREATE_CLIENT"): CREATE_CLIENT = value; break;
			case("CREATE_COMPANY"): CREATE_COMPANY = value; break;
			case("CREATE_CONCILIATION_FILE"): CREATE_CONCILIATION_FILE = value; break;
			case("CREATE_CONCILIATION_FILE_TOPUP"): CREATE_CONCILIATION_FILE_TOPUP = value; break;
			case("CREATE_CUSTOMER"): CREATE_CUSTOMER = value; break;
			case("CREATE_DEPOSIT"): CREATE_DEPOSIT = value; break;
			case("CREATE_DEPOSIT_CHAIN"): CREATE_DEPOSIT_CHAIN = value; break;
			case("CREATE_DEPOSIT_GRE"): CREATE_DEPOSIT_GRE = value; break;
			case("CREATE_E_CARD_TOPUP"): CREATE_E_CARD_TOPUP = value; break;
			case("CREATE_E_DEBIT"): CREATE_E_DEBIT = value; break;
			case("CREATE_PIN"): CREATE_PIN = value; break;
			case("CREATE_PROMOTION"): CREATE_PROMOTION = value; break;
			case("CREATE_ROUTE"): CREATE_ROUTE = value; break;
			case("CREATE_USER"): CREATE_USER = value; break;
			case("CREDIT_CARD_PAYMENT"): CREDIT_CARD_PAYMENT = value; break;
			case("DEBIT_PRODUCT_TO_CUSTOMER"): DEBIT_PRODUCT_TO_CUSTOMER = value; break;
			case("DELETE_BANK"): DELETE_BANK = value; break;
			case("DELETE_CLIENT"): DELETE_CLIENT = value; break;
			case("DELETE_COMPANY"): DELETE_COMPANY = value; break;
			case("DELETE_E_POS"): DELETE_E_POS = value; break;
			case("DELETE_E_POS_TOPUP"): DELETE_E_POS_TOPUP = value; break;
			case("DELETE_PRICING"): DELETE_PRICING = value; break;
			case("DELETE_PROMOTION"): DELETE_PROMOTION = value; break;
			case("DELETE_ROUTE"): DELETE_ROUTE = value; break;
			case("DELETE_USER"): DELETE_USER = value; break;
			case("DENOM_DISTRIBUTER_OP_SALES"): DENOM_DISTRIBUTER_OP_SALES = value; break;
			case("DENOM_GENERAL_OP_SALES"): DENOM_GENERAL_OP_SALES = value; break;
			case("DENOM_GENERAL_SALES"): DENOM_GENERAL_SALES = value; break;
			case("DENOM_RECHARGE_REPORT"): DENOM_RECHARGE_REPORT = value; break;
			case("DENOM_ROUTE_OP_SALES"): DENOM_ROUTE_OP_SALES = value; break;
			case("DENOM_ROUTE_SALES"): DENOM_ROUTE_SALES = value; break;
			case("DENOM_ZONES_OP_SALES"): DENOM_ZONES_OP_SALES = value; break;
			case("DENOM_ZONES_SALES"): DENOM_ZONES_SALES = value; break;
			case("DEPOSIT_DETAIL_SERIAL"): DEPOSIT_DETAIL_SERIAL = value; break;
			case("DEPOSIT_REPORTS"): DEPOSIT_REPORTS = value; break;
			case("DETAILED_TRAFFIC_REPORT"): DETAILED_TRAFFIC_REPORT = value; break;
			case("DISPLAY_CITY"): DISPLAY_CITY = value; break;
			case("DISPLAY_COMPANY"): DISPLAY_COMPANY = value; break;
			case("DISPLAY_DATE"): DISPLAY_DATE = value; break;
			case("DISPLAY_DENOM"): DISPLAY_DENOM = value; break;
			case("DISPLAY_DISTRIBUTER"): DISPLAY_DISTRIBUTER = value; break;
			case("DISPLAY_FACIAL"): DISPLAY_FACIAL = value; break;
			case("DISPLAY_INDUSTRY"): DISPLAY_INDUSTRY = value; break;
			case("DISPLAY_METHOD_RECHARGE"): DISPLAY_METHOD_RECHARGE = value; break;
			case("DISPLAY_MUNICIPALITY"): DISPLAY_MUNICIPALITY = value; break;
			case("DISPLAY_PROMTION"): DISPLAY_PROMTION = value; break;
			case("DISPLAY_STATE"): DISPLAY_STATE = value; break;
			case("DISTRIBUTER_LOGISTIC_STOCK"): DISTRIBUTER_LOGISTIC_STOCK = value; break;
			case("DISTRIBUTER_OP_SALES"): DISTRIBUTER_OP_SALES = value; break;
			case("DISTRIBUTER_SALES"): DISTRIBUTER_SALES = value; break;
			case("DISTRIBUTER_STOCK"): DISTRIBUTER_STOCK = value; break;
			case("DISTRIBUTION_REPORTS"): DISTRIBUTION_REPORTS = value; break;
			case("DISTRIB_MENU"): DISTRIB_MENU = value; break;
			case("DISTRIB_ROUTE"): DISTRIB_ROUTE = value; break;
			case("DISTRIB_WAREHOUSE"): DISTRIB_WAREHOUSE = value; break;
			case("DISTRIB_ZONE"): DISTRIB_ZONE = value; break;
			case("DISTRIB_ZONE_WAREHOUSE"): DISTRIB_ZONE_WAREHOUSE = value; break;
			case("DISTRIB_ZONE_WAREHOUSE_MASTER"): DISTRIB_ZONE_WAREHOUSE_MASTER = value; break;
			case("DIST_STATUS"): DIST_STATUS = value; break;
			case("EDIT"): EDIT = value; break;
			case("ELECTRONIC_LIQUIDATION_MENU"): ELECTRONIC_LIQUIDATION_MENU = value; break;
			case("EMAIL"): EMAIL = value; break;
			case("GENERAL_DEPOSIT"): GENERAL_DEPOSIT = value; break;
			case("GENERAL_OP_SALES"): GENERAL_OP_SALES = value; break;
			case("GENERAL_PROMOTIONS_SALES"): GENERAL_PROMOTIONS_SALES = value; break;
			case("GENERAL_SALES"): GENERAL_SALES = value; break;
			case("GENERAL_STATUS"): GENERAL_STATUS = value; break;
			case("GENERAL_STOCK"): GENERAL_STOCK = value; break;
			case("GET_BALANCE"): GET_BALANCE = value; break;
			case("GET_LAST_SUCCESSFULL_TOPUP"): GET_LAST_SUCCESSFULL_TOPUP = value; break;
			case("GET_PRICING_LIST"): GET_PRICING_LIST = value; break;
			case("GET_PRICING_QUANTITY"): GET_PRICING_QUANTITY = value; break;
			case("GRE5_LIQUIDATION"): GRE5_LIQUIDATION = value; break;
			case("INDICATOR_AMOUNT_RECHARGE"): INDICATOR_AMOUNT_RECHARGE = value; break;
			case("INDICATOR_RECHARGE"): INDICATOR_RECHARGE = value; break;
			case("INSERT_WEB_PAYMENT_DATA"): INSERT_WEB_PAYMENT_DATA = value; break;
			case("IS_APPROVED_USERS_REPORT"): IS_APPROVED_USERS_REPORT = value; break;
			case("IS_APPROVE_DEPOSIT"): IS_APPROVE_DEPOSIT = value; break;
			case("IS_APPROVE_USER"): IS_APPROVE_USER = value; break;
			case("IS_BALANCE_USER"): IS_BALANCE_USER = value; break;
			case("IS_BUYS_MENU"): IS_BUYS_MENU = value; break;
			case("IS_CHANGE_PASS"): IS_CHANGE_PASS = value; break;
			case("IS_CLOSEOUT_POS"): IS_CLOSEOUT_POS = value; break;
			case("IS_CREATE_POS"): IS_CREATE_POS = value; break;
			case("IS_CREATE_POS_WEB"): IS_CREATE_POS_WEB = value; break;
			case("IS_CREDIT_USER"): IS_CREDIT_USER = value; break;
			case("IS_DELETE_POS"): IS_DELETE_POS = value; break;
			case("IS_DELETE_POS_WEB"): IS_DELETE_POS_WEB = value; break;
			case("IS_DEPOSIT_INDUSTRY_REPORT"): IS_DEPOSIT_INDUSTRY_REPORT = value; break;
			case("IS_DEPOSIT_REPORT"): IS_DEPOSIT_REPORT = value; break;
			case("IS_DEPOSIT_REPORT_GEOGRAPHIC"): IS_DEPOSIT_REPORT_GEOGRAPHIC = value; break;
			case("IS_DEPOSIT_REPORT_HISTORY"): IS_DEPOSIT_REPORT_HISTORY = value; break;
			case("IS_D_TRANSFER"): IS_D_TRANSFER = value; break;
			case("IS_E_TRANSFER"): IS_E_TRANSFER = value; break;
			case("IS_NON_APPROVED_USER"): IS_NON_APPROVED_USER = value; break;
			case("IS_NON_CREDIT_USER"): IS_NON_CREDIT_USER = value; break;
			case("IS_POS_SALES_INDUSTRY_REPORT"): IS_POS_SALES_INDUSTRY_REPORT = value; break;
			case("IS_POS_SALES_LOCATION_REPORT"): IS_POS_SALES_LOCATION_REPORT = value; break;
			case("IS_POS_SALES_REPORT"): IS_POS_SALES_REPORT = value; break;
			case("IS_PREAPPROVED_NON_CREDIT_USER"): IS_PREAPPROVED_NON_CREDIT_USER = value; break;
			case("IS_REGISTER_PAYMENT"): IS_REGISTER_PAYMENT = value; break;
			case("IS_SALES_INDUSTRY_REPORT"): IS_SALES_INDUSTRY_REPORT = value; break;
			case("IS_SALES_LIST"): IS_SALES_LIST = value; break;
			case("IS_SALES_LOCATION_REPORT"): IS_SALES_LOCATION_REPORT = value; break;
			case("IS_SALES_REPORT"): IS_SALES_REPORT = value; break;
			case("IS_SALES_REPORT_HISTORY"): IS_SALES_REPORT_HISTORY = value; break;
			case("IS_SALES_REPORT_RESUME"): IS_SALES_REPORT_RESUME = value; break;
			case("IS_SALES_REPORT_TOTALS"): IS_SALES_REPORT_TOTALS = value; break;
			case("IS_SELL_PIN"): IS_SELL_PIN = value; break;
			case("IS_SHOW_BALANCE"): IS_SHOW_BALANCE = value; break;
			case("IS_SUBUSER_REGISTER"): IS_SUBUSER_REGISTER = value; break;
			case("IS_UPDATE_POS"): IS_UPDATE_POS = value; break;
			case("IS_UPDATE_POS_WEB"): IS_UPDATE_POS_WEB = value; break;
			case("IS_USERS_REPORTS"): IS_USERS_REPORTS = value; break;
			case("IS_USER_REGISTER"): IS_USER_REGISTER = value; break;
			case("IS_VIEW_POS_WEB"): IS_VIEW_POS_WEB = value; break;
			case("LAST_RECHARGE_POS"): LAST_RECHARGE_POS = value; break;
			case("LIST_ACCOUNTTOPAY"): LIST_ACCOUNTTOPAY = value; break;
			case("LIST_ALL_ACCOUNTTOPAY"): LIST_ALL_ACCOUNTTOPAY = value; break;
			case("LIST_DEPOSIT_COMPANY"): LIST_DEPOSIT_COMPANY = value; break;
			case("LIST_DEPOSIT_USER"): LIST_DEPOSIT_USER = value; break;
			case("LIST_DEPOSIT_USER_COMPANY"): LIST_DEPOSIT_USER_COMPANY = value; break;
			case("LOGISTIC_REPORTS"): LOGISTIC_REPORTS = value; break;
			case("LOG_IN"): LOG_IN = value; break;
			case("LOG_IN_WEB_SERVICE"): LOG_IN_WEB_SERVICE = value; break;
			case("LOST_CARDS"): LOST_CARDS = value; break;
			case("MODIFY_BANK"): MODIFY_BANK = value; break;
			case("MODIFY_BILL"): MODIFY_BILL = value; break;
			case("MODIFY_CLIENT"): MODIFY_CLIENT = value; break;
			case("MODIFY_COMPANY"): MODIFY_COMPANY = value; break;
			case("MODIFY_DEPOSIT"): MODIFY_DEPOSIT = value; break;
			case("MODIFY_DEPOSIT_CHAIN"): MODIFY_DEPOSIT_CHAIN = value; break;
			case("MODIFY_DEPOSIT_GRE"): MODIFY_DEPOSIT_GRE = value; break;
			case("MODIFY_PROMOTION"): MODIFY_PROMOTION = value; break;
			case("MODIFY_ROUTE"): MODIFY_ROUTE = value; break;
			case("MODIFY_USER"): MODIFY_USER = value; break;
			case("OP_SALES_REPORTS"): OP_SALES_REPORTS = value; break;
			case("PIN_GENERATION_REQUEST"): PIN_GENERATION_REQUEST = value; break;
			case("POSID_DETAILED_RECHARGE_REPORT_1"): POSID_DETAILED_RECHARGE_REPORT_1 = value; break;
			case("POSID_DETAILED_RECHARGE_REPORT_2"): POSID_DETAILED_RECHARGE_REPORT_2 = value; break;
			case("POSID_DETAILED_RECHARGE_REPORT_3"): POSID_DETAILED_RECHARGE_REPORT_3 = value; break;
			case("PRECLOSING_REPORT"): PRECLOSING_REPORT = value; break;
			case("PRECLOSING_REPORT_GRE"): PRECLOSING_REPORT_GRE = value; break;
			case("PRECLOSING_REPORT_ZONE"): PRECLOSING_REPORT_ZONE = value; break;
			case("PRECLOSING_REPORT_ZONE_GRE"): PRECLOSING_REPORT_ZONE_GRE = value; break;
			case("PRICING_EDITOR"): PRICING_EDITOR = value; break;
			case("PRINT"): PRINT = value; break;
			case("PRINT_STATUS"): PRINT_STATUS = value; break;
			case("PRINT_STATUS_BY_PIN"): PRINT_STATUS_BY_PIN = value; break;
			case("RANKING_REPORT_MAX"): RANKING_REPORT_MAX = value; break;
			case("RANKING_REPORT_MIN"): RANKING_REPORT_MIN = value; break;
			case("RECHARGE_ACTIVITY_REPORT"): RECHARGE_ACTIVITY_REPORT = value; break;
			case("RECHARGE_CARDS"): RECHARGE_CARDS = value; break;
			case("RECHARGE_TICKETS"): RECHARGE_TICKETS = value; break;
			case("RECHARGE_REPORTS"): RECHARGE_REPORTS = value; break;
			case("RED_PAYMENT"): RED_PAYMENT = value; break;
			case("REPORTS_MENU"): REPORTS_MENU = value; break;
			case("REVERSE_REPORT"): REVERSE_REPORT = value; break;
			case("REVERSE_ROUTE"): REVERSE_ROUTE = value; break;
			case("REVERSE_WAREHOUSE"): REVERSE_WAREHOUSE = value; break;
			case("REVERSE_ZONE"): REVERSE_ZONE = value; break;
			case("ROUTE_DEPOSIT"): ROUTE_DEPOSIT = value; break;
			case("ROUTE_LOGISTIC_STOCK"): ROUTE_LOGISTIC_STOCK = value; break;
			case("ROUTE_OP_SALES"): ROUTE_OP_SALES = value; break;
			case("ROUTE_PROMOTIONS_SALES"): ROUTE_PROMOTIONS_SALES = value; break;
			case("ROUTE_SALES"): ROUTE_SALES = value; break;
			case("ROUTE_STATUS"): ROUTE_STATUS = value; break;
			case("ROUTE_STOCK"): ROUTE_STOCK = value; break;
			case("ROUTE_STOCK_DETAIL"): ROUTE_STOCK_DETAIL = value; break;
			case("SALES_MENU"): SALES_MENU = value; break;
			case("SALES_REPORTS"): SALES_REPORTS = value; break;
			case("SERIAL_DETAILED_RECHARGE_REPORT"): SERIAL_DETAILED_RECHARGE_REPORT = value; break;
			case("SERVICES_REPORTS"): SERVICES_REPORTS = value; break;
			case("SESSION_LOG"): SESSION_LOG = value; break;
			case("START_MENU"): START_MENU = value; break;
			case("STATE_GENERAL_OP_SALES"): STATE_GENERAL_OP_SALES = value; break;
			case("STATE_ROUTE_OP_SALES"): STATE_ROUTE_OP_SALES = value; break;
			case("STATE_ZONES_OP_SALES"): STATE_ZONES_OP_SALES = value; break;
			case("STATUS_REPORTS"): STATUS_REPORTS = value; break;
			case("STOCK_REPORTS"): STOCK_REPORTS = value; break;
			case("SUBDISTRIBUTER_LOGISTIC_STOCK"): SUBDISTRIBUTER_LOGISTIC_STOCK = value; break;
			case("SWITCH_DISTRIBUTER"): SWITCH_DISTRIBUTER = value; break;
			case("TICKET_AVERAGE_RECHARGE"): TICKET_AVERAGE_RECHARGE = value; break;
			case("TICKET_AVERAGE_SALE"): TICKET_AVERAGE_SALE = value; break;
			case("TOTALS_RECHARGE_SALE"): TOTALS_RECHARGE_SALE = value; break;
			case("TOTALS_STATUS"): TOTALS_STATUS = value; break;
			case("TRAFFIC_REPORTS"): TRAFFIC_REPORTS = value; break;
			case("UNDO_CUSTOMER_BUY"): UNDO_CUSTOMER_BUY = value; break;
			case("UNDO_E_CARD_TOPUP"): UNDO_E_CARD_TOPUP = value; break;
			case("UNUSED_BALANCE_REPORT"): UNUSED_BALANCE_REPORT = value; break;
			case("UPDATE_E_POS"): UPDATE_E_POS = value; break;
			case("UPDATE_E_POS_TOPUP"): UPDATE_E_POS_TOPUP = value; break;
			case("UPDATE_PRICING"): UPDATE_PRICING = value; break;
			case("USER_CALLCENTER"): USER_CALLCENTER = value; break;
			case("USER_PAYMENT"): USER_PAYMENT = value; break;
			case("VIEW"): VIEW = value; break;
			case("VIEWER_LOG"): VIEWER_LOG = value; break;
			case("VIEW_BANK"): VIEW_BANK = value; break;
			case("VIEW_CLIENT"): VIEW_CLIENT = value; break;
			case("VIEW_COMPANY"): VIEW_COMPANY = value; break;
			case("VIEW_PROMOTION"): VIEW_PROMOTION = value; break;
			case("VIEW_ROUTE"): VIEW_ROUTE = value; break;
			case("VIEW_USER"): VIEW_USER = value; break;
			case("ZONES_DEPOSIT"): ZONES_DEPOSIT = value; break;
			case("ZONES_LOGISTIC_STOCK"): ZONES_LOGISTIC_STOCK = value; break;
			case("ZONES_OP_SALES"): ZONES_OP_SALES = value; break;
			case("ZONES_PROMOTIONS_SALES"): ZONES_PROMOTIONS_SALES = value; break;
			case("ZONES_SALES"): ZONES_SALES = value; break;
			case("ZONES_STATUS"): ZONES_STATUS = value; break;
			case("ZONES_STOCK"): ZONES_STOCK = value; break;	
		}
	}

	public boolean isACCESS_DENIED() {
		return ACCESS_DENIED;
	}

	public void setACCESS_DENIED(boolean aCCESS_DENIED) {
		ACCESS_DENIED = aCCESS_DENIED;
	}

	public boolean isACC_NUM_DETAILED_RECHARGE_SUMMARY() {
		return ACC_NUM_DETAILED_RECHARGE_SUMMARY;
	}

	public void setACC_NUM_DETAILED_RECHARGE_SUMMARY(
			boolean aCC_NUM_DETAILED_RECHARGE_SUMMARY) {
		ACC_NUM_DETAILED_RECHARGE_SUMMARY = aCC_NUM_DETAILED_RECHARGE_SUMMARY;
	}

	public boolean isACC_NUM_RECHARGE_REPORT() {
		return ACC_NUM_RECHARGE_REPORT;
	}

	public void setACC_NUM_RECHARGE_REPORT(boolean aCC_NUM_RECHARGE_REPORT) {
		ACC_NUM_RECHARGE_REPORT = aCC_NUM_RECHARGE_REPORT;
	}

	public boolean isACC_NUM_SUMMARRY_RECHARGE_REPORT() {
		return ACC_NUM_SUMMARRY_RECHARGE_REPORT;
	}

	public void setACC_NUM_SUMMARRY_RECHARGE_REPORT(
			boolean aCC_NUM_SUMMARRY_RECHARGE_REPORT) {
		ACC_NUM_SUMMARRY_RECHARGE_REPORT = aCC_NUM_SUMMARRY_RECHARGE_REPORT;
	}

	public boolean isACTIVE_ROUTE() {
		return ACTIVE_ROUTE;
	}

	public void setACTIVE_ROUTE(boolean aCTIVE_ROUTE) {
		ACTIVE_ROUTE = aCTIVE_ROUTE;
	}

	public boolean isACTIVE_ROUTE_STOLEN() {
		return ACTIVE_ROUTE_STOLEN;
	}

	public void setACTIVE_ROUTE_STOLEN(boolean aCTIVE_ROUTE_STOLEN) {
		ACTIVE_ROUTE_STOLEN = aCTIVE_ROUTE_STOLEN;
	}

	public boolean isACTIVITY_0900_REPORT_1() {
		return ACTIVITY_0900_REPORT_1;
	}

	public void setACTIVITY_0900_REPORT_1(boolean aCTIVITY_0900_REPORT_1) {
		ACTIVITY_0900_REPORT_1 = aCTIVITY_0900_REPORT_1;
	}

	public boolean isACTIVITY_0900_REPORT_2() {
		return ACTIVITY_0900_REPORT_2;
	}

	public void setACTIVITY_0900_REPORT_2(boolean aCTIVITY_0900_REPORT_2) {
		ACTIVITY_0900_REPORT_2 = aCTIVITY_0900_REPORT_2;
	}

	public boolean isACTIVITY_0900_REPORT_3() {
		return ACTIVITY_0900_REPORT_3;
	}

	public void setACTIVITY_0900_REPORT_3(boolean aCTIVITY_0900_REPORT_3) {
		ACTIVITY_0900_REPORT_3 = aCTIVITY_0900_REPORT_3;
	}

	public boolean isACTIVITY_CONCIL_REPORT() {
		return ACTIVITY_CONCIL_REPORT;
	}

	public void setACTIVITY_CONCIL_REPORT(boolean aCTIVITY_CONCIL_REPORT) {
		ACTIVITY_CONCIL_REPORT = aCTIVITY_CONCIL_REPORT;
	}

	public boolean isACTIVITY_SMS_REPORT_1() {
		return ACTIVITY_SMS_REPORT_1;
	}

	public void setACTIVITY_SMS_REPORT_1(boolean aCTIVITY_SMS_REPORT_1) {
		ACTIVITY_SMS_REPORT_1 = aCTIVITY_SMS_REPORT_1;
	}

	public boolean isACTIVITY_SMS_REPORT_2() {
		return ACTIVITY_SMS_REPORT_2;
	}

	public void setACTIVITY_SMS_REPORT_2(boolean aCTIVITY_SMS_REPORT_2) {
		ACTIVITY_SMS_REPORT_2 = aCTIVITY_SMS_REPORT_2;
	}

	public boolean isACTIVITY_SMS_REPORT_3() {
		return ACTIVITY_SMS_REPORT_3;
	}

	public void setACTIVITY_SMS_REPORT_3(boolean aCTIVITY_SMS_REPORT_3) {
		ACTIVITY_SMS_REPORT_3 = aCTIVITY_SMS_REPORT_3;
	}

	public boolean isADD_CUSTOMER_BUY() {
		return ADD_CUSTOMER_BUY;
	}

	public void setADD_CUSTOMER_BUY(boolean aDD_CUSTOMER_BUY) {
		ADD_CUSTOMER_BUY = aDD_CUSTOMER_BUY;
	}

	public boolean isADD_E_POS() {
		return ADD_E_POS;
	}

	public void setADD_E_POS(boolean aDD_E_POS) {
		ADD_E_POS = aDD_E_POS;
	}

	public boolean isADD_E_POS_TOPUP() {
		return ADD_E_POS_TOPUP;
	}

	public void setADD_E_POS_TOPUP(boolean aDD_E_POS_TOPUP) {
		ADD_E_POS_TOPUP = aDD_E_POS_TOPUP;
	}

	public boolean isADMIN_MENU() {
		return ADMIN_MENU;
	}

	public void setADMIN_MENU(boolean aDMIN_MENU) {
		ADMIN_MENU = aDMIN_MENU;
	}

	public boolean isANALYTICAL_LIQUIDATION_REPORT() {
		return ANALYTICAL_LIQUIDATION_REPORT;
	}

	public void setANALYTICAL_LIQUIDATION_REPORT(
			boolean aNALYTICAL_LIQUIDATION_REPORT) {
		ANALYTICAL_LIQUIDATION_REPORT = aNALYTICAL_LIQUIDATION_REPORT;
	}

	public boolean isANALYTICAL_RECHARGE_REPORT() {
		return ANALYTICAL_RECHARGE_REPORT;
	}

	public void setANALYTICAL_RECHARGE_REPORT(boolean aNALYTICAL_RECHARGE_REPORT) {
		ANALYTICAL_RECHARGE_REPORT = aNALYTICAL_RECHARGE_REPORT;
	}

	public boolean isANALYTICAL_REPORTS() {
		return ANALYTICAL_REPORTS;
	}

	public void setANALYTICAL_REPORTS(boolean aNALYTICAL_REPORTS) {
		ANALYTICAL_REPORTS = aNALYTICAL_REPORTS;
	}

	public boolean isAPPROVE_DEPOSIT() {
		return APPROVE_DEPOSIT;
	}

	public void setAPPROVE_DEPOSIT(boolean aPPROVE_DEPOSIT) {
		APPROVE_DEPOSIT = aPPROVE_DEPOSIT;
	}

	public boolean isAPPROVE_DEPOSIT_GRE() {
		return APPROVE_DEPOSIT_GRE;
	}

	public void setAPPROVE_DEPOSIT_GRE(boolean aPPROVE_DEPOSIT_GRE) {
		APPROVE_DEPOSIT_GRE = aPPROVE_DEPOSIT_GRE;
	}

	public boolean isASSIGNMENT_HISTORY() {
		return ASSIGNMENT_HISTORY;
	}

	public void setASSIGNMENT_HISTORY(boolean aSSIGNMENT_HISTORY) {
		ASSIGNMENT_HISTORY = aSSIGNMENT_HISTORY;
	}

	public boolean isASSIGN_LEVEL1() {
		return ASSIGN_LEVEL1;
	}

	public void setASSIGN_LEVEL1(boolean aSSIGN_LEVEL1) {
		ASSIGN_LEVEL1 = aSSIGN_LEVEL1;
	}

	public boolean isASSIGN_LEVEL10() {
		return ASSIGN_LEVEL10;
	}

	public void setASSIGN_LEVEL10(boolean aSSIGN_LEVEL10) {
		ASSIGN_LEVEL10 = aSSIGN_LEVEL10;
	}

	public boolean isASSIGN_LEVEL11() {
		return ASSIGN_LEVEL11;
	}

	public void setASSIGN_LEVEL11(boolean aSSIGN_LEVEL11) {
		ASSIGN_LEVEL11 = aSSIGN_LEVEL11;
	}

	public boolean isASSIGN_LEVEL12() {
		return ASSIGN_LEVEL12;
	}

	public void setASSIGN_LEVEL12(boolean aSSIGN_LEVEL12) {
		ASSIGN_LEVEL12 = aSSIGN_LEVEL12;
	}

	public boolean isASSIGN_LEVEL13() {
		return ASSIGN_LEVEL13;
	}

	public void setASSIGN_LEVEL13(boolean aSSIGN_LEVEL13) {
		ASSIGN_LEVEL13 = aSSIGN_LEVEL13;
	}

	public boolean isASSIGN_LEVEL14() {
		return ASSIGN_LEVEL14;
	}

	public void setASSIGN_LEVEL14(boolean aSSIGN_LEVEL14) {
		ASSIGN_LEVEL14 = aSSIGN_LEVEL14;
	}

	public boolean isASSIGN_LEVEL15() {
		return ASSIGN_LEVEL15;
	}

	public void setASSIGN_LEVEL15(boolean aSSIGN_LEVEL15) {
		ASSIGN_LEVEL15 = aSSIGN_LEVEL15;
	}

	public boolean isASSIGN_LEVEL16() {
		return ASSIGN_LEVEL16;
	}

	public void setASSIGN_LEVEL16(boolean aSSIGN_LEVEL16) {
		ASSIGN_LEVEL16 = aSSIGN_LEVEL16;
	}

	public boolean isASSIGN_LEVEL17() {
		return ASSIGN_LEVEL17;
	}

	public void setASSIGN_LEVEL17(boolean aSSIGN_LEVEL17) {
		ASSIGN_LEVEL17 = aSSIGN_LEVEL17;
	}

	public boolean isASSIGN_LEVEL18() {
		return ASSIGN_LEVEL18;
	}

	public void setASSIGN_LEVEL18(boolean aSSIGN_LEVEL18) {
		ASSIGN_LEVEL18 = aSSIGN_LEVEL18;
	}

	public boolean isASSIGN_LEVEL19() {
		return ASSIGN_LEVEL19;
	}

	public void setASSIGN_LEVEL19(boolean aSSIGN_LEVEL19) {
		ASSIGN_LEVEL19 = aSSIGN_LEVEL19;
	}

	public boolean isASSIGN_LEVEL2() {
		return ASSIGN_LEVEL2;
	}

	public void setASSIGN_LEVEL2(boolean aSSIGN_LEVEL2) {
		ASSIGN_LEVEL2 = aSSIGN_LEVEL2;
	}

	public boolean isASSIGN_LEVEL20() {
		return ASSIGN_LEVEL20;
	}

	public void setASSIGN_LEVEL20(boolean aSSIGN_LEVEL20) {
		ASSIGN_LEVEL20 = aSSIGN_LEVEL20;
	}

	public boolean isASSIGN_LEVEL21() {
		return ASSIGN_LEVEL21;
	}

	public void setASSIGN_LEVEL21(boolean aSSIGN_LEVEL21) {
		ASSIGN_LEVEL21 = aSSIGN_LEVEL21;
	}

	public boolean isASSIGN_LEVEL22() {
		return ASSIGN_LEVEL22;
	}

	public void setASSIGN_LEVEL22(boolean aSSIGN_LEVEL22) {
		ASSIGN_LEVEL22 = aSSIGN_LEVEL22;
	}

	public boolean isASSIGN_LEVEL23() {
		return ASSIGN_LEVEL23;
	}

	public void setASSIGN_LEVEL23(boolean aSSIGN_LEVEL23) {
		ASSIGN_LEVEL23 = aSSIGN_LEVEL23;
	}

	public boolean isASSIGN_LEVEL24() {
		return ASSIGN_LEVEL24;
	}

	public void setASSIGN_LEVEL24(boolean aSSIGN_LEVEL24) {
		ASSIGN_LEVEL24 = aSSIGN_LEVEL24;
	}

	public boolean isASSIGN_LEVEL25() {
		return ASSIGN_LEVEL25;
	}

	public void setASSIGN_LEVEL25(boolean aSSIGN_LEVEL25) {
		ASSIGN_LEVEL25 = aSSIGN_LEVEL25;
	}

	public boolean isASSIGN_LEVEL26() {
		return ASSIGN_LEVEL26;
	}

	public void setASSIGN_LEVEL26(boolean aSSIGN_LEVEL26) {
		ASSIGN_LEVEL26 = aSSIGN_LEVEL26;
	}

	public boolean isASSIGN_LEVEL27() {
		return ASSIGN_LEVEL27;
	}

	public void setASSIGN_LEVEL27(boolean aSSIGN_LEVEL27) {
		ASSIGN_LEVEL27 = aSSIGN_LEVEL27;
	}

	public boolean isASSIGN_LEVEL28() {
		return ASSIGN_LEVEL28;
	}

	public void setASSIGN_LEVEL28(boolean aSSIGN_LEVEL28) {
		ASSIGN_LEVEL28 = aSSIGN_LEVEL28;
	}

	public boolean isASSIGN_LEVEL29() {
		return ASSIGN_LEVEL29;
	}

	public void setASSIGN_LEVEL29(boolean aSSIGN_LEVEL29) {
		ASSIGN_LEVEL29 = aSSIGN_LEVEL29;
	}

	public boolean isASSIGN_LEVEL3() {
		return ASSIGN_LEVEL3;
	}

	public void setASSIGN_LEVEL3(boolean aSSIGN_LEVEL3) {
		ASSIGN_LEVEL3 = aSSIGN_LEVEL3;
	}

	public boolean isASSIGN_LEVEL30() {
		return ASSIGN_LEVEL30;
	}

	public void setASSIGN_LEVEL30(boolean aSSIGN_LEVEL30) {
		ASSIGN_LEVEL30 = aSSIGN_LEVEL30;
	}

	public boolean isASSIGN_LEVEL31() {
		return ASSIGN_LEVEL31;
	}

	public void setASSIGN_LEVEL31(boolean aSSIGN_LEVEL31) {
		ASSIGN_LEVEL31 = aSSIGN_LEVEL31;
	}

	public boolean isASSIGN_LEVEL32() {
		return ASSIGN_LEVEL32;
	}

	public void setASSIGN_LEVEL32(boolean aSSIGN_LEVEL32) {
		ASSIGN_LEVEL32 = aSSIGN_LEVEL32;
	}

	public boolean isASSIGN_LEVEL33() {
		return ASSIGN_LEVEL33;
	}

	public void setASSIGN_LEVEL33(boolean aSSIGN_LEVEL33) {
		ASSIGN_LEVEL33 = aSSIGN_LEVEL33;
	}

	public boolean isASSIGN_LEVEL34() {
		return ASSIGN_LEVEL34;
	}

	public void setASSIGN_LEVEL34(boolean aSSIGN_LEVEL34) {
		ASSIGN_LEVEL34 = aSSIGN_LEVEL34;
	}

	public boolean isASSIGN_LEVEL35() {
		return ASSIGN_LEVEL35;
	}

	public void setASSIGN_LEVEL35(boolean aSSIGN_LEVEL35) {
		ASSIGN_LEVEL35 = aSSIGN_LEVEL35;
	}

	public boolean isASSIGN_LEVEL36() {
		return ASSIGN_LEVEL36;
	}

	public void setASSIGN_LEVEL36(boolean aSSIGN_LEVEL36) {
		ASSIGN_LEVEL36 = aSSIGN_LEVEL36;
	}

	public boolean isASSIGN_LEVEL37() {
		return ASSIGN_LEVEL37;
	}

	public void setASSIGN_LEVEL37(boolean aSSIGN_LEVEL37) {
		ASSIGN_LEVEL37 = aSSIGN_LEVEL37;
	}

	public boolean isASSIGN_LEVEL38() {
		return ASSIGN_LEVEL38;
	}

	public void setASSIGN_LEVEL38(boolean aSSIGN_LEVEL38) {
		ASSIGN_LEVEL38 = aSSIGN_LEVEL38;
	}

	public boolean isASSIGN_LEVEL39() {
		return ASSIGN_LEVEL39;
	}

	public void setASSIGN_LEVEL39(boolean aSSIGN_LEVEL39) {
		ASSIGN_LEVEL39 = aSSIGN_LEVEL39;
	}

	public boolean isASSIGN_LEVEL4() {
		return ASSIGN_LEVEL4;
	}

	public void setASSIGN_LEVEL4(boolean aSSIGN_LEVEL4) {
		ASSIGN_LEVEL4 = aSSIGN_LEVEL4;
	}

	public boolean isASSIGN_LEVEL40() {
		return ASSIGN_LEVEL40;
	}

	public void setASSIGN_LEVEL40(boolean aSSIGN_LEVEL40) {
		ASSIGN_LEVEL40 = aSSIGN_LEVEL40;
	}

	public boolean isASSIGN_LEVEL41() {
		return ASSIGN_LEVEL41;
	}

	public void setASSIGN_LEVEL41(boolean aSSIGN_LEVEL41) {
		ASSIGN_LEVEL41 = aSSIGN_LEVEL41;
	}

	public boolean isASSIGN_LEVEL42() {
		return ASSIGN_LEVEL42;
	}

	public void setASSIGN_LEVEL42(boolean aSSIGN_LEVEL42) {
		ASSIGN_LEVEL42 = aSSIGN_LEVEL42;
	}

	public boolean isASSIGN_LEVEL43() {
		return ASSIGN_LEVEL43;
	}

	public void setASSIGN_LEVEL43(boolean aSSIGN_LEVEL43) {
		ASSIGN_LEVEL43 = aSSIGN_LEVEL43;
	}

	public boolean isASSIGN_LEVEL44() {
		return ASSIGN_LEVEL44;
	}

	public void setASSIGN_LEVEL44(boolean aSSIGN_LEVEL44) {
		ASSIGN_LEVEL44 = aSSIGN_LEVEL44;
	}

	public boolean isASSIGN_LEVEL45() {
		return ASSIGN_LEVEL45;
	}

	public void setASSIGN_LEVEL45(boolean aSSIGN_LEVEL45) {
		ASSIGN_LEVEL45 = aSSIGN_LEVEL45;
	}

	public boolean isASSIGN_LEVEL46() {
		return ASSIGN_LEVEL46;
	}

	public void setASSIGN_LEVEL46(boolean aSSIGN_LEVEL46) {
		ASSIGN_LEVEL46 = aSSIGN_LEVEL46;
	}

	public boolean isASSIGN_LEVEL47() {
		return ASSIGN_LEVEL47;
	}

	public void setASSIGN_LEVEL47(boolean aSSIGN_LEVEL47) {
		ASSIGN_LEVEL47 = aSSIGN_LEVEL47;
	}

	public boolean isASSIGN_LEVEL48() {
		return ASSIGN_LEVEL48;
	}

	public void setASSIGN_LEVEL48(boolean aSSIGN_LEVEL48) {
		ASSIGN_LEVEL48 = aSSIGN_LEVEL48;
	}

	public boolean isASSIGN_LEVEL49() {
		return ASSIGN_LEVEL49;
	}

	public void setASSIGN_LEVEL49(boolean aSSIGN_LEVEL49) {
		ASSIGN_LEVEL49 = aSSIGN_LEVEL49;
	}

	public boolean isASSIGN_LEVEL5() {
		return ASSIGN_LEVEL5;
	}

	public void setASSIGN_LEVEL5(boolean aSSIGN_LEVEL5) {
		ASSIGN_LEVEL5 = aSSIGN_LEVEL5;
	}

	public boolean isASSIGN_LEVEL50() {
		return ASSIGN_LEVEL50;
	}

	public void setASSIGN_LEVEL50(boolean aSSIGN_LEVEL50) {
		ASSIGN_LEVEL50 = aSSIGN_LEVEL50;
	}

	public boolean isASSIGN_LEVEL51() {
		return ASSIGN_LEVEL51;
	}

	public void setASSIGN_LEVEL51(boolean aSSIGN_LEVEL51) {
		ASSIGN_LEVEL51 = aSSIGN_LEVEL51;
	}

	public boolean isASSIGN_LEVEL52() {
		return ASSIGN_LEVEL52;
	}

	public void setASSIGN_LEVEL52(boolean aSSIGN_LEVEL52) {
		ASSIGN_LEVEL52 = aSSIGN_LEVEL52;
	}

	public boolean isASSIGN_LEVEL53() {
		return ASSIGN_LEVEL53;
	}

	public void setASSIGN_LEVEL53(boolean aSSIGN_LEVEL53) {
		ASSIGN_LEVEL53 = aSSIGN_LEVEL53;
	}

	public boolean isASSIGN_LEVEL54() {
		return ASSIGN_LEVEL54;
	}

	public void setASSIGN_LEVEL54(boolean aSSIGN_LEVEL54) {
		ASSIGN_LEVEL54 = aSSIGN_LEVEL54;
	}

	public boolean isASSIGN_LEVEL55() {
		return ASSIGN_LEVEL55;
	}

	public void setASSIGN_LEVEL55(boolean aSSIGN_LEVEL55) {
		ASSIGN_LEVEL55 = aSSIGN_LEVEL55;
	}

	public boolean isASSIGN_LEVEL56() {
		return ASSIGN_LEVEL56;
	}

	public void setASSIGN_LEVEL56(boolean aSSIGN_LEVEL56) {
		ASSIGN_LEVEL56 = aSSIGN_LEVEL56;
	}

	public boolean isASSIGN_LEVEL57() {
		return ASSIGN_LEVEL57;
	}

	public void setASSIGN_LEVEL57(boolean aSSIGN_LEVEL57) {
		ASSIGN_LEVEL57 = aSSIGN_LEVEL57;
	}

	public boolean isASSIGN_LEVEL58() {
		return ASSIGN_LEVEL58;
	}

	public void setASSIGN_LEVEL58(boolean aSSIGN_LEVEL58) {
		ASSIGN_LEVEL58 = aSSIGN_LEVEL58;
	}

	public boolean isASSIGN_LEVEL59() {
		return ASSIGN_LEVEL59;
	}

	public void setASSIGN_LEVEL59(boolean aSSIGN_LEVEL59) {
		ASSIGN_LEVEL59 = aSSIGN_LEVEL59;
	}

	public boolean isASSIGN_LEVEL6() {
		return ASSIGN_LEVEL6;
	}

	public void setASSIGN_LEVEL6(boolean aSSIGN_LEVEL6) {
		ASSIGN_LEVEL6 = aSSIGN_LEVEL6;
	}

	public boolean isASSIGN_LEVEL60() {
		return ASSIGN_LEVEL60;
	}

	public void setASSIGN_LEVEL60(boolean aSSIGN_LEVEL60) {
		ASSIGN_LEVEL60 = aSSIGN_LEVEL60;
	}

	public boolean isASSIGN_LEVEL61() {
		return ASSIGN_LEVEL61;
	}

	public void setASSIGN_LEVEL61(boolean aSSIGN_LEVEL61) {
		ASSIGN_LEVEL61 = aSSIGN_LEVEL61;
	}

	public boolean isASSIGN_LEVEL62() {
		return ASSIGN_LEVEL62;
	}

	public void setASSIGN_LEVEL62(boolean aSSIGN_LEVEL62) {
		ASSIGN_LEVEL62 = aSSIGN_LEVEL62;
	}

	public boolean isASSIGN_LEVEL63() {
		return ASSIGN_LEVEL63;
	}

	public void setASSIGN_LEVEL63(boolean aSSIGN_LEVEL63) {
		ASSIGN_LEVEL63 = aSSIGN_LEVEL63;
	}

	public boolean isASSIGN_LEVEL64() {
		return ASSIGN_LEVEL64;
	}

	public void setASSIGN_LEVEL64(boolean aSSIGN_LEVEL64) {
		ASSIGN_LEVEL64 = aSSIGN_LEVEL64;
	}

	public boolean isASSIGN_LEVEL65() {
		return ASSIGN_LEVEL65;
	}

	public void setASSIGN_LEVEL65(boolean aSSIGN_LEVEL65) {
		ASSIGN_LEVEL65 = aSSIGN_LEVEL65;
	}

	public boolean isASSIGN_LEVEL66() {
		return ASSIGN_LEVEL66;
	}

	public void setASSIGN_LEVEL66(boolean aSSIGN_LEVEL66) {
		ASSIGN_LEVEL66 = aSSIGN_LEVEL66;
	}

	public boolean isASSIGN_LEVEL67() {
		return ASSIGN_LEVEL67;
	}

	public void setASSIGN_LEVEL67(boolean aSSIGN_LEVEL67) {
		ASSIGN_LEVEL67 = aSSIGN_LEVEL67;
	}

	public boolean isASSIGN_LEVEL68() {
		return ASSIGN_LEVEL68;
	}

	public void setASSIGN_LEVEL68(boolean aSSIGN_LEVEL68) {
		ASSIGN_LEVEL68 = aSSIGN_LEVEL68;
	}

	public boolean isASSIGN_LEVEL69() {
		return ASSIGN_LEVEL69;
	}

	public void setASSIGN_LEVEL69(boolean aSSIGN_LEVEL69) {
		ASSIGN_LEVEL69 = aSSIGN_LEVEL69;
	}

	public boolean isASSIGN_LEVEL7() {
		return ASSIGN_LEVEL7;
	}

	public void setASSIGN_LEVEL7(boolean aSSIGN_LEVEL7) {
		ASSIGN_LEVEL7 = aSSIGN_LEVEL7;
	}

	public boolean isASSIGN_LEVEL70() {
		return ASSIGN_LEVEL70;
	}

	public void setASSIGN_LEVEL70(boolean aSSIGN_LEVEL70) {
		ASSIGN_LEVEL70 = aSSIGN_LEVEL70;
	}

	public boolean isASSIGN_LEVEL71() {
		return ASSIGN_LEVEL71;
	}

	public void setASSIGN_LEVEL71(boolean aSSIGN_LEVEL71) {
		ASSIGN_LEVEL71 = aSSIGN_LEVEL71;
	}

	public boolean isASSIGN_LEVEL72() {
		return ASSIGN_LEVEL72;
	}

	public void setASSIGN_LEVEL72(boolean aSSIGN_LEVEL72) {
		ASSIGN_LEVEL72 = aSSIGN_LEVEL72;
	}

	public boolean isASSIGN_LEVEL73() {
		return ASSIGN_LEVEL73;
	}

	public void setASSIGN_LEVEL73(boolean aSSIGN_LEVEL73) {
		ASSIGN_LEVEL73 = aSSIGN_LEVEL73;
	}

	public boolean isASSIGN_LEVEL74() {
		return ASSIGN_LEVEL74;
	}

	public void setASSIGN_LEVEL74(boolean aSSIGN_LEVEL74) {
		ASSIGN_LEVEL74 = aSSIGN_LEVEL74;
	}

	public boolean isASSIGN_LEVEL75() {
		return ASSIGN_LEVEL75;
	}

	public void setASSIGN_LEVEL75(boolean aSSIGN_LEVEL75) {
		ASSIGN_LEVEL75 = aSSIGN_LEVEL75;
	}

	public boolean isASSIGN_LEVEL76() {
		return ASSIGN_LEVEL76;
	}

	public void setASSIGN_LEVEL76(boolean aSSIGN_LEVEL76) {
		ASSIGN_LEVEL76 = aSSIGN_LEVEL76;
	}

	public boolean isASSIGN_LEVEL77() {
		return ASSIGN_LEVEL77;
	}

	public void setASSIGN_LEVEL77(boolean aSSIGN_LEVEL77) {
		ASSIGN_LEVEL77 = aSSIGN_LEVEL77;
	}

	public boolean isASSIGN_LEVEL78() {
		return ASSIGN_LEVEL78;
	}

	public void setASSIGN_LEVEL78(boolean aSSIGN_LEVEL78) {
		ASSIGN_LEVEL78 = aSSIGN_LEVEL78;
	}

	public boolean isASSIGN_LEVEL79() {
		return ASSIGN_LEVEL79;
	}

	public void setASSIGN_LEVEL79(boolean aSSIGN_LEVEL79) {
		ASSIGN_LEVEL79 = aSSIGN_LEVEL79;
	}

	public boolean isASSIGN_LEVEL8() {
		return ASSIGN_LEVEL8;
	}

	public void setASSIGN_LEVEL8(boolean aSSIGN_LEVEL8) {
		ASSIGN_LEVEL8 = aSSIGN_LEVEL8;
	}

	public boolean isASSIGN_LEVEL80() {
		return ASSIGN_LEVEL80;
	}

	public void setASSIGN_LEVEL80(boolean aSSIGN_LEVEL80) {
		ASSIGN_LEVEL80 = aSSIGN_LEVEL80;
	}

	public boolean isASSIGN_LEVEL81() {
		return ASSIGN_LEVEL81;
	}

	public void setASSIGN_LEVEL81(boolean aSSIGN_LEVEL81) {
		ASSIGN_LEVEL81 = aSSIGN_LEVEL81;
	}

	public boolean isASSIGN_LEVEL82() {
		return ASSIGN_LEVEL82;
	}

	public void setASSIGN_LEVEL82(boolean aSSIGN_LEVEL82) {
		ASSIGN_LEVEL82 = aSSIGN_LEVEL82;
	}

	public boolean isASSIGN_LEVEL83() {
		return ASSIGN_LEVEL83;
	}

	public void setASSIGN_LEVEL83(boolean aSSIGN_LEVEL83) {
		ASSIGN_LEVEL83 = aSSIGN_LEVEL83;
	}

	public boolean isASSIGN_LEVEL84() {
		return ASSIGN_LEVEL84;
	}

	public void setASSIGN_LEVEL84(boolean aSSIGN_LEVEL84) {
		ASSIGN_LEVEL84 = aSSIGN_LEVEL84;
	}

	public boolean isASSIGN_LEVEL85() {
		return ASSIGN_LEVEL85;
	}

	public void setASSIGN_LEVEL85(boolean aSSIGN_LEVEL85) {
		ASSIGN_LEVEL85 = aSSIGN_LEVEL85;
	}

	public boolean isASSIGN_LEVEL86() {
		return ASSIGN_LEVEL86;
	}

	public void setASSIGN_LEVEL86(boolean aSSIGN_LEVEL86) {
		ASSIGN_LEVEL86 = aSSIGN_LEVEL86;
	}

	public boolean isASSIGN_LEVEL87() {
		return ASSIGN_LEVEL87;
	}

	public void setASSIGN_LEVEL87(boolean aSSIGN_LEVEL87) {
		ASSIGN_LEVEL87 = aSSIGN_LEVEL87;
	}

	public boolean isASSIGN_LEVEL88() {
		return ASSIGN_LEVEL88;
	}

	public void setASSIGN_LEVEL88(boolean aSSIGN_LEVEL88) {
		ASSIGN_LEVEL88 = aSSIGN_LEVEL88;
	}

	public boolean isASSIGN_LEVEL89() {
		return ASSIGN_LEVEL89;
	}

	public void setASSIGN_LEVEL89(boolean aSSIGN_LEVEL89) {
		ASSIGN_LEVEL89 = aSSIGN_LEVEL89;
	}

	public boolean isASSIGN_LEVEL9() {
		return ASSIGN_LEVEL9;
	}

	public void setASSIGN_LEVEL9(boolean aSSIGN_LEVEL9) {
		ASSIGN_LEVEL9 = aSSIGN_LEVEL9;
	}

	public boolean isASSIGN_LEVEL90() {
		return ASSIGN_LEVEL90;
	}

	public void setASSIGN_LEVEL90(boolean aSSIGN_LEVEL90) {
		ASSIGN_LEVEL90 = aSSIGN_LEVEL90;
	}

	public boolean isASSIGN_LEVEL91() {
		return ASSIGN_LEVEL91;
	}

	public void setASSIGN_LEVEL91(boolean aSSIGN_LEVEL91) {
		ASSIGN_LEVEL91 = aSSIGN_LEVEL91;
	}

	public boolean isASSIGN_LEVEL92() {
		return ASSIGN_LEVEL92;
	}

	public void setASSIGN_LEVEL92(boolean aSSIGN_LEVEL92) {
		ASSIGN_LEVEL92 = aSSIGN_LEVEL92;
	}

	public boolean isASSIGN_LEVEL93() {
		return ASSIGN_LEVEL93;
	}

	public void setASSIGN_LEVEL93(boolean aSSIGN_LEVEL93) {
		ASSIGN_LEVEL93 = aSSIGN_LEVEL93;
	}

	public boolean isASSIGN_LEVEL94() {
		return ASSIGN_LEVEL94;
	}

	public void setASSIGN_LEVEL94(boolean aSSIGN_LEVEL94) {
		ASSIGN_LEVEL94 = aSSIGN_LEVEL94;
	}

	public boolean isASSIGN_LEVEL95() {
		return ASSIGN_LEVEL95;
	}

	public void setASSIGN_LEVEL95(boolean aSSIGN_LEVEL95) {
		ASSIGN_LEVEL95 = aSSIGN_LEVEL95;
	}

	public boolean isASSIGN_LEVEL96() {
		return ASSIGN_LEVEL96;
	}

	public void setASSIGN_LEVEL96(boolean aSSIGN_LEVEL96) {
		ASSIGN_LEVEL96 = aSSIGN_LEVEL96;
	}

	public boolean isASSIGN_LEVEL97() {
		return ASSIGN_LEVEL97;
	}

	public void setASSIGN_LEVEL97(boolean aSSIGN_LEVEL97) {
		ASSIGN_LEVEL97 = aSSIGN_LEVEL97;
	}

	public boolean isASSIGN_LEVEL98() {
		return ASSIGN_LEVEL98;
	}

	public void setASSIGN_LEVEL98(boolean aSSIGN_LEVEL98) {
		ASSIGN_LEVEL98 = aSSIGN_LEVEL98;
	}

	public boolean isASSIGN_LEVEL99() {
		return ASSIGN_LEVEL99;
	}

	public void setASSIGN_LEVEL99(boolean aSSIGN_LEVEL99) {
		ASSIGN_LEVEL99 = aSSIGN_LEVEL99;
	}

	public boolean isAVERAGE_RECHARGE_MONTH() {
		return AVERAGE_RECHARGE_MONTH;
	}

	public void setAVERAGE_RECHARGE_MONTH(boolean aVERAGE_RECHARGE_MONTH) {
		AVERAGE_RECHARGE_MONTH = aVERAGE_RECHARGE_MONTH;
	}

	public boolean isAVERAGE_REPORTS() {
		return AVERAGE_REPORTS;
	}

	public void setAVERAGE_REPORTS(boolean aVERAGE_REPORTS) {
		AVERAGE_REPORTS = aVERAGE_REPORTS;
	}

	public boolean isAVERAGE_SALE_MONTH() {
		return AVERAGE_SALE_MONTH;
	}

	public void setAVERAGE_SALE_MONTH(boolean aVERAGE_SALE_MONTH) {
		AVERAGE_SALE_MONTH = aVERAGE_SALE_MONTH;
	}

	public boolean isBILL_REPORTS() {
		return BILL_REPORTS;
	}

	public void setBILL_REPORTS(boolean bILL_REPORTS) {
		BILL_REPORTS = bILL_REPORTS;
	}

	public boolean isBILL_REPORT_BRIEF() {
		return BILL_REPORT_BRIEF;
	}

	public void setBILL_REPORT_BRIEF(boolean bILL_REPORT_BRIEF) {
		BILL_REPORT_BRIEF = bILL_REPORT_BRIEF;
	}

	public boolean isBILL_REPORT_DETAIL() {
		return BILL_REPORT_DETAIL;
	}

	public void setBILL_REPORT_DETAIL(boolean bILL_REPORT_DETAIL) {
		BILL_REPORT_DETAIL = bILL_REPORT_DETAIL;
	}

	public boolean isCARD_DISTRIB_CONTROL() {
		return CARD_DISTRIB_CONTROL;
	}

	public void setCARD_DISTRIB_CONTROL(boolean cARD_DISTRIB_CONTROL) {
		CARD_DISTRIB_CONTROL = cARD_DISTRIB_CONTROL;
	}

	public boolean isCARD_STATUS_CONTROL() {
		return CARD_STATUS_CONTROL;
	}

	public void setCARD_STATUS_CONTROL(boolean cARD_STATUS_CONTROL) {
		CARD_STATUS_CONTROL = cARD_STATUS_CONTROL;
	}

	public boolean isCARD_STATUS_CONTROL_RESTRICTED() {
		return CARD_STATUS_CONTROL_RESTRICTED;
	}

	public void setCARD_STATUS_CONTROL_RESTRICTED(
			boolean cARD_STATUS_CONTROL_RESTRICTED) {
		CARD_STATUS_CONTROL_RESTRICTED = cARD_STATUS_CONTROL_RESTRICTED;
	}

	public boolean isCHAIN_LIQUIDATION() {
		return CHAIN_LIQUIDATION;
	}

	public void setCHAIN_LIQUIDATION(boolean cHAIN_LIQUIDATION) {
		CHAIN_LIQUIDATION = cHAIN_LIQUIDATION;
	}

	public boolean isCHANGE_PASS() {
		return CHANGE_PASS;
	}

	public void setCHANGE_PASS(boolean cHANGE_PASS) {
		CHANGE_PASS = cHANGE_PASS;
	}

	public boolean isCHANGE_PASSWORD() {
		return CHANGE_PASSWORD;
	}

	public void setCHANGE_PASSWORD(boolean cHANGE_PASSWORD) {
		CHANGE_PASSWORD = cHANGE_PASSWORD;
	}

	public boolean isCHANGE_PASSWORD_WEB_SERVICE() {
		return CHANGE_PASSWORD_WEB_SERVICE;
	}

	public void setCHANGE_PASSWORD_WEB_SERVICE(boolean cHANGE_PASSWORD_WEB_SERVICE) {
		CHANGE_PASSWORD_WEB_SERVICE = cHANGE_PASSWORD_WEB_SERVICE;
	}

	public boolean isCHANGE_STATUS_CONTROL() {
		return CHANGE_STATUS_CONTROL;
	}

	public void setCHANGE_STATUS_CONTROL(boolean cHANGE_STATUS_CONTROL) {
		CHANGE_STATUS_CONTROL = cHANGE_STATUS_CONTROL;
	}

	public boolean isCHANGE_STATUS_10() {
		return CHANGE_STATUS_10;
	}

	public void setCHANGE_STATUS_10(boolean cHANGE_STATUS_10) {
		CHANGE_STATUS_10 = cHANGE_STATUS_10;
	}

	public boolean isCHANGE_STATUS_11() {
		return CHANGE_STATUS_11;
	}

	public void setCHANGE_STATUS_11(boolean cHANGE_STATUS_11) {
		CHANGE_STATUS_11 = cHANGE_STATUS_11;
	}

	public boolean isCHANGE_STATUS_12() {
		return CHANGE_STATUS_12;
	}

	public void setCHANGE_STATUS_12(boolean cHANGE_STATUS_12) {
		CHANGE_STATUS_12 = cHANGE_STATUS_12;
	}

	public boolean isCHANGE_STATUS_13() {
		return CHANGE_STATUS_13;
	}

	public void setCHANGE_STATUS_13(boolean cHANGE_STATUS_13) {
		CHANGE_STATUS_13 = cHANGE_STATUS_13;
	}

	public boolean isCHANGE_STATUS_14() {
		return CHANGE_STATUS_14;
	}

	public void setCHANGE_STATUS_14(boolean cHANGE_STATUS_14) {
		CHANGE_STATUS_14 = cHANGE_STATUS_14;
	}

	public boolean isCHANGE_STATUS_2() {
		return CHANGE_STATUS_2;
	}

	public void setCHANGE_STATUS_2(boolean cHANGE_STATUS_2) {
		CHANGE_STATUS_2 = cHANGE_STATUS_2;
	}

	public boolean isCHANGE_STATUS_3() {
		return CHANGE_STATUS_3;
	}

	public void setCHANGE_STATUS_3(boolean cHANGE_STATUS_3) {
		CHANGE_STATUS_3 = cHANGE_STATUS_3;
	}

	public boolean isCHANGE_STATUS_5() {
		return CHANGE_STATUS_5;
	}

	public void setCHANGE_STATUS_5(boolean cHANGE_STATUS_5) {
		CHANGE_STATUS_5 = cHANGE_STATUS_5;
	}

	public boolean isCHANGE_STATUS_6() {
		return CHANGE_STATUS_6;
	}

	public void setCHANGE_STATUS_6(boolean cHANGE_STATUS_6) {
		CHANGE_STATUS_6 = cHANGE_STATUS_6;
	}

	public boolean isCHANGE_STATUS_61() {
		return CHANGE_STATUS_61;
	}

	public void setCHANGE_STATUS_61(boolean cHANGE_STATUS_61) {
		CHANGE_STATUS_61 = cHANGE_STATUS_61;
	}

	public boolean isCHANGE_STATUS_7() {
		return CHANGE_STATUS_7;
	}

	public void setCHANGE_STATUS_7(boolean cHANGE_STATUS_7) {
		CHANGE_STATUS_7 = cHANGE_STATUS_7;
	}

	public boolean isCHANGE_STATUS_8() {
		return CHANGE_STATUS_8;
	}

	public void setCHANGE_STATUS_8(boolean cHANGE_STATUS_8) {
		CHANGE_STATUS_8 = cHANGE_STATUS_8;
	}

	public boolean isCHANGE_STATUS_DIRECTV() {
		return CHANGE_STATUS_DIRECTV;
	}

	public void setCHANGE_STATUS_DIRECTV(boolean cHANGE_STATUS_DIRECTV) {
		CHANGE_STATUS_DIRECTV = cHANGE_STATUS_DIRECTV;
	}

	public boolean isCHANGE_STATUS_DIRECTV_2() {
		return CHANGE_STATUS_DIRECTV_2;
	}

	public void setCHANGE_STATUS_DIRECTV_2(boolean cHANGE_STATUS_DIRECTV_2) {
		CHANGE_STATUS_DIRECTV_2 = cHANGE_STATUS_DIRECTV_2;
	}

	public boolean isCHANGE_STATUS_DIRECTV_3() {
		return CHANGE_STATUS_DIRECTV_3;
	}

	public void setCHANGE_STATUS_DIRECTV_3(boolean cHANGE_STATUS_DIRECTV_3) {
		CHANGE_STATUS_DIRECTV_3 = cHANGE_STATUS_DIRECTV_3;
	}

	public boolean isCHANGE_STATUS_DIRECTV_4() {
		return CHANGE_STATUS_DIRECTV_4;
	}

	public void setCHANGE_STATUS_DIRECTV_4(boolean cHANGE_STATUS_DIRECTV_4) {
		CHANGE_STATUS_DIRECTV_4 = cHANGE_STATUS_DIRECTV_4;
	}

	public boolean isCHANGE_STATUS_DIRECTV_5() {
		return CHANGE_STATUS_DIRECTV_5;
	}

	public void setCHANGE_STATUS_DIRECTV_5(boolean cHANGE_STATUS_DIRECTV_5) {
		CHANGE_STATUS_DIRECTV_5 = cHANGE_STATUS_DIRECTV_5;
	}

	public boolean isCHANGE_STATUS_DIRECTV_6() {
		return CHANGE_STATUS_DIRECTV_6;
	}

	public void setCHANGE_STATUS_DIRECTV_6(boolean cHANGE_STATUS_DIRECTV_6) {
		CHANGE_STATUS_DIRECTV_6 = cHANGE_STATUS_DIRECTV_6;
	}

	public boolean isCHANGE_STATUS_DIRECTV_61() {
		return CHANGE_STATUS_DIRECTV_61;
	}

	public void setCHANGE_STATUS_DIRECTV_61(boolean cHANGE_STATUS_DIRECTV_61) {
		CHANGE_STATUS_DIRECTV_61 = cHANGE_STATUS_DIRECTV_61;
	}

	public boolean isCHANGE_STATUS_DIRECTV_8() {
		return CHANGE_STATUS_DIRECTV_8;
	}

	public void setCHANGE_STATUS_DIRECTV_8(boolean cHANGE_STATUS_DIRECTV_8) {
		CHANGE_STATUS_DIRECTV_8 = cHANGE_STATUS_DIRECTV_8;
	}

	public boolean isCHANGE_STATUS_DISTRIB() {
		return CHANGE_STATUS_DISTRIB;
	}

	public void setCHANGE_STATUS_DISTRIB(boolean cHANGE_STATUS_DISTRIB) {
		CHANGE_STATUS_DISTRIB = cHANGE_STATUS_DISTRIB;
	}

	public boolean isCHANGE_STATUS_E_DEBIT() {
		return CHANGE_STATUS_E_DEBIT;
	}

	public void setCHANGE_STATUS_E_DEBIT(boolean cHANGE_STATUS_E_DEBIT) {
		CHANGE_STATUS_E_DEBIT = cHANGE_STATUS_E_DEBIT;
	}

	public boolean isCHANGE_STATUS_IVR() {
		return CHANGE_STATUS_IVR;
	}

	public void setCHANGE_STATUS_IVR(boolean cHANGE_STATUS_IVR) {
		CHANGE_STATUS_IVR = cHANGE_STATUS_IVR;
	}

	public boolean isCHANGE_STATUS_MANUF() {
		return CHANGE_STATUS_MANUF;
	}

	public void setCHANGE_STATUS_MANUF(boolean cHANGE_STATUS_MANUF) {
		CHANGE_STATUS_MANUF = cHANGE_STATUS_MANUF;
	}

	public boolean isCHANGE_STATUS_NVRD() {
		return CHANGE_STATUS_NVRD;
	}

	public void setCHANGE_STATUS_NVRD(boolean cHANGE_STATUS_NVRD) {
		CHANGE_STATUS_NVRD = cHANGE_STATUS_NVRD;
	}

	public boolean isCLIENT_HISTORIC_SALES() {
		return CLIENT_HISTORIC_SALES;
	}

	public void setCLIENT_HISTORIC_SALES(boolean cLIENT_HISTORIC_SALES) {
		CLIENT_HISTORIC_SALES = cLIENT_HISTORIC_SALES;
	}

	public boolean isCLIENT_LIST() {
		return CLIENT_LIST;
	}

	public void setCLIENT_LIST(boolean cLIENT_LIST) {
		CLIENT_LIST = cLIENT_LIST;
	}

	public boolean isCLIENT_REPORTS() {
		return CLIENT_REPORTS;
	}

	public void setCLIENT_REPORTS(boolean cLIENT_REPORTS) {
		CLIENT_REPORTS = cLIENT_REPORTS;
	}

	public boolean isCLIENT_ROUTE_ABSOLUTE_SALES() {
		return CLIENT_ROUTE_ABSOLUTE_SALES;
	}

	public void setCLIENT_ROUTE_ABSOLUTE_SALES(boolean cLIENT_ROUTE_ABSOLUTE_SALES) {
		CLIENT_ROUTE_ABSOLUTE_SALES = cLIENT_ROUTE_ABSOLUTE_SALES;
	}

	public boolean isCLIENT_ROUTE_RELATIVE_SALES() {
		return CLIENT_ROUTE_RELATIVE_SALES;
	}

	public void setCLIENT_ROUTE_RELATIVE_SALES(boolean cLIENT_ROUTE_RELATIVE_SALES) {
		CLIENT_ROUTE_RELATIVE_SALES = cLIENT_ROUTE_RELATIVE_SALES;
	}

	public boolean isCLIENT_SALES() {
		return CLIENT_SALES;
	}

	public void setCLIENT_SALES(boolean cLIENT_SALES) {
		CLIENT_SALES = cLIENT_SALES;
	}

	public boolean isCLOSEOUT() {
		return CLOSEOUT;
	}

	public void setCLOSEOUT(boolean cLOSEOUT) {
		CLOSEOUT = cLOSEOUT;
	}

	public boolean isCLOSEOUT_MENU() {
		return CLOSEOUT_MENU;
	}

	public void setCLOSEOUT_MENU(boolean cLOSEOUT_MENU) {
		CLOSEOUT_MENU = cLOSEOUT_MENU;
	}

	public boolean isCLOSE_TRANSACTION_LIST() {
		return CLOSE_TRANSACTION_LIST;
	}

	public void setCLOSE_TRANSACTION_LIST(boolean cLOSE_TRANSACTION_LIST) {
		CLOSE_TRANSACTION_LIST = cLOSE_TRANSACTION_LIST;
	}

	public boolean isCLOSING_GRE() {
		return CLOSING_GRE;
	}

	public void setCLOSING_GRE(boolean cLOSING_GRE) {
		CLOSING_GRE = cLOSING_GRE;
	}

	public boolean isCLOSING_LOG_REPORT() {
		return CLOSING_LOG_REPORT;
	}

	public void setCLOSING_LOG_REPORT(boolean cLOSING_LOG_REPORT) {
		CLOSING_LOG_REPORT = cLOSING_LOG_REPORT;
	}

	public boolean isCLOSING_REPORTS() {
		return CLOSING_REPORTS;
	}

	public void setCLOSING_REPORTS(boolean cLOSING_REPORTS) {
		CLOSING_REPORTS = cLOSING_REPORTS;
	}

	public boolean isCLOSING_REPORTS_GRE() {
		return CLOSING_REPORTS_GRE;
	}

	public void setCLOSING_REPORTS_GRE(boolean cLOSING_REPORTS_GRE) {
		CLOSING_REPORTS_GRE = cLOSING_REPORTS_GRE;
	}

	public boolean isCONCIL_CARD_DETAIL() {
		return CONCIL_CARD_DETAIL;
	}

	public void setCONCIL_CARD_DETAIL(boolean cONCIL_CARD_DETAIL) {
		CONCIL_CARD_DETAIL = cONCIL_CARD_DETAIL;
	}

	public boolean isCONFIRM_CUSTOMER_BUY() {
		return CONFIRM_CUSTOMER_BUY;
	}

	public void setCONFIRM_CUSTOMER_BUY(boolean cONFIRM_CUSTOMER_BUY) {
		CONFIRM_CUSTOMER_BUY = cONFIRM_CUSTOMER_BUY;
	}

	public boolean isCONFIRM_E_CARD_TOPUP() {
		return CONFIRM_E_CARD_TOPUP;
	}

	public void setCONFIRM_E_CARD_TOPUP(boolean cONFIRM_E_CARD_TOPUP) {
		CONFIRM_E_CARD_TOPUP = cONFIRM_E_CARD_TOPUP;
	}

	public boolean isCONFIRM_STATUS_E_DEBIT() {
		return CONFIRM_STATUS_E_DEBIT;
	}

	public void setCONFIRM_STATUS_E_DEBIT(boolean cONFIRM_STATUS_E_DEBIT) {
		CONFIRM_STATUS_E_DEBIT = cONFIRM_STATUS_E_DEBIT;
	}

	public boolean isCONSOLIDATED_TRAFFIC_REPORT() {
		return CONSOLIDATED_TRAFFIC_REPORT;
	}

	public void setCONSOLIDATED_TRAFFIC_REPORT(boolean cONSOLIDATED_TRAFFIC_REPORT) {
		CONSOLIDATED_TRAFFIC_REPORT = cONSOLIDATED_TRAFFIC_REPORT;
	}

	public boolean isCONTROL_REPORTS() {
		return CONTROL_REPORTS;
	}

	public void setCONTROL_REPORTS(boolean cONTROL_REPORTS) {
		CONTROL_REPORTS = cONTROL_REPORTS;
	}

	public boolean isCREATE_BANK() {
		return CREATE_BANK;
	}

	public void setCREATE_BANK(boolean cREATE_BANK) {
		CREATE_BANK = cREATE_BANK;
	}

	public boolean isCREATE_BILL() {
		return CREATE_BILL;
	}

	public void setCREATE_BILL(boolean cREATE_BILL) {
		CREATE_BILL = cREATE_BILL;
	}

	public boolean isCREATE_CLIENT() {
		return CREATE_CLIENT;
	}

	public void setCREATE_CLIENT(boolean cREATE_CLIENT) {
		CREATE_CLIENT = cREATE_CLIENT;
	}

	public boolean isCREATE_COMPANY() {
		return CREATE_COMPANY;
	}

	public void setCREATE_COMPANY(boolean cREATE_COMPANY) {
		CREATE_COMPANY = cREATE_COMPANY;
	}

	public boolean isCREATE_CONCILIATION_FILE() {
		return CREATE_CONCILIATION_FILE;
	}

	public void setCREATE_CONCILIATION_FILE(boolean cREATE_CONCILIATION_FILE) {
		CREATE_CONCILIATION_FILE = cREATE_CONCILIATION_FILE;
	}

	public boolean isCREATE_CONCILIATION_FILE_TOPUP() {
		return CREATE_CONCILIATION_FILE_TOPUP;
	}

	public void setCREATE_CONCILIATION_FILE_TOPUP(
			boolean cREATE_CONCILIATION_FILE_TOPUP) {
		CREATE_CONCILIATION_FILE_TOPUP = cREATE_CONCILIATION_FILE_TOPUP;
	}

	public boolean isCREATE_CUSTOMER() {
		return CREATE_CUSTOMER;
	}

	public void setCREATE_CUSTOMER(boolean cREATE_CUSTOMER) {
		CREATE_CUSTOMER = cREATE_CUSTOMER;
	}

	public boolean isCREATE_DEPOSIT() {
		return CREATE_DEPOSIT;
	}

	public void setCREATE_DEPOSIT(boolean cREATE_DEPOSIT) {
		CREATE_DEPOSIT = cREATE_DEPOSIT;
	}

	public boolean isCREATE_DEPOSIT_CHAIN() {
		return CREATE_DEPOSIT_CHAIN;
	}

	public void setCREATE_DEPOSIT_CHAIN(boolean cREATE_DEPOSIT_CHAIN) {
		CREATE_DEPOSIT_CHAIN = cREATE_DEPOSIT_CHAIN;
	}

	public boolean isCREATE_DEPOSIT_GRE() {
		return CREATE_DEPOSIT_GRE;
	}

	public void setCREATE_DEPOSIT_GRE(boolean cREATE_DEPOSIT_GRE) {
		CREATE_DEPOSIT_GRE = cREATE_DEPOSIT_GRE;
	}

	public boolean isCREATE_E_CARD_TOPUP() {
		return CREATE_E_CARD_TOPUP;
	}

	public void setCREATE_E_CARD_TOPUP(boolean cREATE_E_CARD_TOPUP) {
		CREATE_E_CARD_TOPUP = cREATE_E_CARD_TOPUP;
	}

	public boolean isCREATE_E_DEBIT() {
		return CREATE_E_DEBIT;
	}

	public void setCREATE_E_DEBIT(boolean cREATE_E_DEBIT) {
		CREATE_E_DEBIT = cREATE_E_DEBIT;
	}

	public boolean isCREATE_PIN() {
		return CREATE_PIN;
	}

	public void setCREATE_PIN(boolean cREATE_PIN) {
		CREATE_PIN = cREATE_PIN;
	}

	public boolean isCREATE_PROMOTION() {
		return CREATE_PROMOTION;
	}

	public void setCREATE_PROMOTION(boolean cREATE_PROMOTION) {
		CREATE_PROMOTION = cREATE_PROMOTION;
	}

	public boolean isCREATE_ROUTE() {
		return CREATE_ROUTE;
	}

	public void setCREATE_ROUTE(boolean cREATE_ROUTE) {
		CREATE_ROUTE = cREATE_ROUTE;
	}

	public boolean isCREATE_USER() {
		return CREATE_USER;
	}

	public void setCREATE_USER(boolean cREATE_USER) {
		CREATE_USER = cREATE_USER;
	}

	public boolean isDEBIT_PRODUCT_TO_CUSTOMER() {
		return DEBIT_PRODUCT_TO_CUSTOMER;
	}

	public boolean isCREDIT_CARD_PAYMENT() {
		return CREDIT_CARD_PAYMENT;
	}

	public void setCREDIT_CARD_PAYMENT(boolean cREDIT_CARD_PAYMENT) {
		CREDIT_CARD_PAYMENT = cREDIT_CARD_PAYMENT;
	}

	public void setDEBIT_PRODUCT_TO_CUSTOMER(boolean dEBIT_PRODUCT_TO_CUSTOMER) {
		DEBIT_PRODUCT_TO_CUSTOMER = dEBIT_PRODUCT_TO_CUSTOMER;
	}

	public boolean isDELETE_BANK() {
		return DELETE_BANK;
	}

	public void setDELETE_BANK(boolean dELETE_BANK) {
		DELETE_BANK = dELETE_BANK;
	}

	public boolean isDELETE_CLIENT() {
		return DELETE_CLIENT;
	}

	public void setDELETE_CLIENT(boolean dELETE_CLIENT) {
		DELETE_CLIENT = dELETE_CLIENT;
	}

	public boolean isDELETE_COMPANY() {
		return DELETE_COMPANY;
	}

	public void setDELETE_COMPANY(boolean dELETE_COMPANY) {
		DELETE_COMPANY = dELETE_COMPANY;
	}

	public boolean isDELETE_E_POS() {
		return DELETE_E_POS;
	}

	public void setDELETE_E_POS(boolean dELETE_E_POS) {
		DELETE_E_POS = dELETE_E_POS;
	}

	public boolean isDELETE_E_POS_TOPUP() {
		return DELETE_E_POS_TOPUP;
	}

	public void setDELETE_E_POS_TOPUP(boolean dELETE_E_POS_TOPUP) {
		DELETE_E_POS_TOPUP = dELETE_E_POS_TOPUP;
	}

	public boolean isDELETE_PRICING() {
		return DELETE_PRICING;
	}

	public void setDELETE_PRICING(boolean dELETE_PRICING) {
		DELETE_PRICING = dELETE_PRICING;
	}

	public boolean isDELETE_PROMOTION() {
		return DELETE_PROMOTION;
	}

	public void setDELETE_PROMOTION(boolean dELETE_PROMOTION) {
		DELETE_PROMOTION = dELETE_PROMOTION;
	}

	public boolean isDELETE_ROUTE() {
		return DELETE_ROUTE;
	}

	public void setDELETE_ROUTE(boolean dELETE_ROUTE) {
		DELETE_ROUTE = dELETE_ROUTE;
	}

	public boolean isDELETE_USER() {
		return DELETE_USER;
	}

	public void setDELETE_USER(boolean dELETE_USER) {
		DELETE_USER = dELETE_USER;
	}

	public boolean isDENOM_DISTRIBUTER_OP_SALES() {
		return DENOM_DISTRIBUTER_OP_SALES;
	}

	public void setDENOM_DISTRIBUTER_OP_SALES(boolean dENOM_DISTRIBUTER_OP_SALES) {
		DENOM_DISTRIBUTER_OP_SALES = dENOM_DISTRIBUTER_OP_SALES;
	}

	public boolean isDENOM_GENERAL_SALES() {
		return DENOM_GENERAL_SALES;
	}

	public void setDENOM_GENERAL_SALES(boolean dENOM_GENERAL_SALES) {
		DENOM_GENERAL_SALES = dENOM_GENERAL_SALES;
	}

	public boolean isDENOM_GENERAL_OP_SALES() {
		return DENOM_GENERAL_OP_SALES;
	}

	public void setDENOM_GENERAL_OP_SALES(boolean dENOM_GENERAL_OP_SALES) {
		DENOM_GENERAL_OP_SALES = dENOM_GENERAL_OP_SALES;
	}

	public boolean isDENOM_RECHARGE_REPORT() {
		return DENOM_RECHARGE_REPORT;
	}

	public void setDENOM_RECHARGE_REPORT(boolean dENOM_RECHARGE_REPORT) {
		DENOM_RECHARGE_REPORT = dENOM_RECHARGE_REPORT;
	}

	public boolean isDENOM_ROUTE_OP_SALES() {
		return DENOM_ROUTE_OP_SALES;
	}

	public void setDENOM_ROUTE_OP_SALES(boolean dENOM_ROUTE_OP_SALES) {
		DENOM_ROUTE_OP_SALES = dENOM_ROUTE_OP_SALES;
	}

	public boolean isDENOM_ROUTE_SALES() {
		return DENOM_ROUTE_SALES;
	}

	public void setDENOM_ROUTE_SALES(boolean dENOM_ROUTE_SALES) {
		DENOM_ROUTE_SALES = dENOM_ROUTE_SALES;
	}

	public boolean isDENOM_ZONES_OP_SALES() {
		return DENOM_ZONES_OP_SALES;
	}

	public void setDENOM_ZONES_OP_SALES(boolean dENOM_ZONES_OP_SALES) {
		DENOM_ZONES_OP_SALES = dENOM_ZONES_OP_SALES;
	}

	public boolean isDENOM_ZONES_SALES() {
		return DENOM_ZONES_SALES;
	}

	public void setDENOM_ZONES_SALES(boolean dENOM_ZONES_SALES) {
		DENOM_ZONES_SALES = dENOM_ZONES_SALES;
	}

	public boolean isDEPOSIT_DETAIL_SERIAL() {
		return DEPOSIT_DETAIL_SERIAL;
	}

	public void setDEPOSIT_DETAIL_SERIAL(boolean dEPOSIT_DETAIL_SERIAL) {
		DEPOSIT_DETAIL_SERIAL = dEPOSIT_DETAIL_SERIAL;
	}

	public boolean isDEPOSIT_REPORTS() {
		return DEPOSIT_REPORTS;
	}

	public void setDEPOSIT_REPORTS(boolean dEPOSIT_REPORTS) {
		DEPOSIT_REPORTS = dEPOSIT_REPORTS;
	}

	public boolean isDETAILED_TRAFFIC_REPORT() {
		return DETAILED_TRAFFIC_REPORT;
	}

	public void setDETAILED_TRAFFIC_REPORT(boolean dETAILED_TRAFFIC_REPORT) {
		DETAILED_TRAFFIC_REPORT = dETAILED_TRAFFIC_REPORT;
	}

	public boolean isDISPLAY_CITY() {
		return DISPLAY_CITY;
	}

	public void setDISPLAY_CITY(boolean dISPLAY_CITY) {
		DISPLAY_CITY = dISPLAY_CITY;
	}

	public boolean isDISPLAY_COMPANY() {
		return DISPLAY_COMPANY;
	}

	public void setDISPLAY_COMPANY(boolean dISPLAY_COMPANY) {
		DISPLAY_COMPANY = dISPLAY_COMPANY;
	}

	public boolean isDISPLAY_DATE() {
		return DISPLAY_DATE;
	}

	public void setDISPLAY_DATE(boolean dISPLAY_DATE) {
		DISPLAY_DATE = dISPLAY_DATE;
	}

	public boolean isDISPLAY_DENOM() {
		return DISPLAY_DENOM;
	}

	public void setDISPLAY_DENOM(boolean dISPLAY_DENOM) {
		DISPLAY_DENOM = dISPLAY_DENOM;
	}

	public boolean isDISPLAY_DISTRIBUTER() {
		return DISPLAY_DISTRIBUTER;
	}

	public void setDISPLAY_DISTRIBUTER(boolean dISPLAY_DISTRIBUTER) {
		DISPLAY_DISTRIBUTER = dISPLAY_DISTRIBUTER;
	}

	public boolean isDISPLAY_FACIAL() {
		return DISPLAY_FACIAL;
	}

	public void setDISPLAY_FACIAL(boolean dISPLAY_FACIAL) {
		DISPLAY_FACIAL = dISPLAY_FACIAL;
	}

	public boolean isDISPLAY_INDUSTRY() {
		return DISPLAY_INDUSTRY;
	}

	public void setDISPLAY_INDUSTRY(boolean dISPLAY_INDUSTRY) {
		DISPLAY_INDUSTRY = dISPLAY_INDUSTRY;
	}

	public boolean isDISPLAY_METHOD_RECHARGE() {
		return DISPLAY_METHOD_RECHARGE;
	}

	public void setDISPLAY_METHOD_RECHARGE(boolean dISPLAY_METHOD_RECHARGE) {
		DISPLAY_METHOD_RECHARGE = dISPLAY_METHOD_RECHARGE;
	}

	public boolean isDISPLAY_MUNICIPALITY() {
		return DISPLAY_MUNICIPALITY;
	}

	public void setDISPLAY_MUNICIPALITY(boolean dISPLAY_MUNICIPALITY) {
		DISPLAY_MUNICIPALITY = dISPLAY_MUNICIPALITY;
	}

	public boolean isDISPLAY_PROMTION() {
		return DISPLAY_PROMTION;
	}

	public void setDISPLAY_PROMTION(boolean dISPLAY_PROMTION) {
		DISPLAY_PROMTION = dISPLAY_PROMTION;
	}

	public boolean isDISPLAY_STATE() {
		return DISPLAY_STATE;
	}

	public void setDISPLAY_STATE(boolean dISPLAY_STATE) {
		DISPLAY_STATE = dISPLAY_STATE;
	}

	public boolean isDISTRIBUTER_LOGISTIC_STOCK() {
		return DISTRIBUTER_LOGISTIC_STOCK;
	}

	public void setDISTRIBUTER_LOGISTIC_STOCK(boolean dISTRIBUTER_LOGISTIC_STOCK) {
		DISTRIBUTER_LOGISTIC_STOCK = dISTRIBUTER_LOGISTIC_STOCK;
	}

	public boolean isDISTRIBUTER_OP_SALES() {
		return DISTRIBUTER_OP_SALES;
	}

	public void setDISTRIBUTER_OP_SALES(boolean dISTRIBUTER_OP_SALES) {
		DISTRIBUTER_OP_SALES = dISTRIBUTER_OP_SALES;
	}

	public boolean isDISTRIBUTER_SALES() {
		return DISTRIBUTER_SALES;
	}

	public void setDISTRIBUTER_SALES(boolean dISTRIBUTER_SALES) {
		DISTRIBUTER_SALES = dISTRIBUTER_SALES;
	}

	public boolean isDISTRIBUTER_STOCK() {
		return DISTRIBUTER_STOCK;
	}

	public void setDISTRIBUTER_STOCK(boolean dISTRIBUTER_STOCK) {
		DISTRIBUTER_STOCK = dISTRIBUTER_STOCK;
	}

	public boolean isDISTRIBUTION_REPORTS() {
		return DISTRIBUTION_REPORTS;
	}

	public void setDISTRIBUTION_REPORTS(boolean dISTRIBUTION_REPORTS) {
		DISTRIBUTION_REPORTS = dISTRIBUTION_REPORTS;
	}

	public boolean isDISTRIB_MENU() {
		return DISTRIB_MENU;
	}

	public void setDISTRIB_MENU(boolean dISTRIB_MENU) {
		DISTRIB_MENU = dISTRIB_MENU;
	}

	public boolean isDISTRIB_ROUTE() {
		return DISTRIB_ROUTE;
	}

	public void setDISTRIB_ROUTE(boolean dISTRIB_ROUTE) {
		DISTRIB_ROUTE = dISTRIB_ROUTE;
	}

	public boolean isDISTRIB_WAREHOUSE() {
		return DISTRIB_WAREHOUSE;
	}

	public void setDISTRIB_WAREHOUSE(boolean dISTRIB_WAREHOUSE) {
		DISTRIB_WAREHOUSE = dISTRIB_WAREHOUSE;
	}

	public boolean isDISTRIB_ZONE() {
		return DISTRIB_ZONE;
	}

	public void setDISTRIB_ZONE(boolean dISTRIB_ZONE) {
		DISTRIB_ZONE = dISTRIB_ZONE;
	}

	public boolean isDISTRIB_ZONE_WAREHOUSE() {
		return DISTRIB_ZONE_WAREHOUSE;
	}

	public void setDISTRIB_ZONE_WAREHOUSE(boolean dISTRIB_ZONE_WAREHOUSE) {
		DISTRIB_ZONE_WAREHOUSE = dISTRIB_ZONE_WAREHOUSE;
	}

	public boolean isDISTRIB_ZONE_WAREHOUSE_MASTER() {
		return DISTRIB_ZONE_WAREHOUSE_MASTER;
	}

	public void setDISTRIB_ZONE_WAREHOUSE_MASTER(
			boolean dISTRIB_ZONE_WAREHOUSE_MASTER) {
		DISTRIB_ZONE_WAREHOUSE_MASTER = dISTRIB_ZONE_WAREHOUSE_MASTER;
	}

	public boolean isDIST_STATUS() {
		return DIST_STATUS;
	}

	public void setDIST_STATUS(boolean dIST_STATUS) {
		DIST_STATUS = dIST_STATUS;
	}

	public boolean isEDIT() {
		return EDIT;
	}

	public void setEDIT(boolean eDIT) {
		EDIT = eDIT;
	}

	public boolean isELECTRONIC_LIQUIDATION_MENU() {
		return ELECTRONIC_LIQUIDATION_MENU;
	}

	public void setELECTRONIC_LIQUIDATION_MENU(boolean eLECTRONIC_LIQUIDATION_MENU) {
		ELECTRONIC_LIQUIDATION_MENU = eLECTRONIC_LIQUIDATION_MENU;
	}

	public boolean isEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(boolean eMAIL) {
		EMAIL = eMAIL;
	}

	public boolean isGENERAL_DEPOSIT() {
		return GENERAL_DEPOSIT;
	}

	public void setGENERAL_DEPOSIT(boolean gENERAL_DEPOSIT) {
		GENERAL_DEPOSIT = gENERAL_DEPOSIT;
	}

	public boolean isGENERAL_OP_SALES() {
		return GENERAL_OP_SALES;
	}

	public void setGENERAL_OP_SALES(boolean gENERAL_OP_SALES) {
		GENERAL_OP_SALES = gENERAL_OP_SALES;
	}

	public boolean isGENERAL_PROMOTIONS_SALES() {
		return GENERAL_PROMOTIONS_SALES;
	}

	public void setGENERAL_PROMOTIONS_SALES(boolean gENERAL_PROMOTIONS_SALES) {
		GENERAL_PROMOTIONS_SALES = gENERAL_PROMOTIONS_SALES;
	}

	public boolean isGENERAL_SALES() {
		return GENERAL_SALES;
	}

	public void setGENERAL_SALES(boolean gENERAL_SALES) {
		GENERAL_SALES = gENERAL_SALES;
	}

	public boolean isGENERAL_STATUS() {
		return GENERAL_STATUS;
	}

	public void setGENERAL_STATUS(boolean gENERAL_STATUS) {
		GENERAL_STATUS = gENERAL_STATUS;
	}

	public boolean isGENERAL_STOCK() {
		return GENERAL_STOCK;
	}

	public void setGENERAL_STOCK(boolean gENERAL_STOCK) {
		GENERAL_STOCK = gENERAL_STOCK;
	}

	public boolean isGET_BALANCE() {
		return GET_BALANCE;
	}

	public void setGET_BALANCE(boolean gET_BALANCE) {
		GET_BALANCE = gET_BALANCE;
	}

	public boolean isGET_LAST_SUCCESSFULL_TOPUP() {
		return GET_LAST_SUCCESSFULL_TOPUP;
	}

	public void setGET_LAST_SUCCESSFULL_TOPUP(boolean gET_LAST_SUCCESSFULL_TOPUP) {
		GET_LAST_SUCCESSFULL_TOPUP = gET_LAST_SUCCESSFULL_TOPUP;
	}

	public boolean isGET_PRICING_LIST() {
		return GET_PRICING_LIST;
	}

	public void setGET_PRICING_LIST(boolean gET_PRICING_LIST) {
		GET_PRICING_LIST = gET_PRICING_LIST;
	}

	public boolean isGET_PRICING_QUANTITY() {
		return GET_PRICING_QUANTITY;
	}

	public void setGET_PRICING_QUANTITY(boolean gET_PRICING_QUANTITY) {
		GET_PRICING_QUANTITY = gET_PRICING_QUANTITY;
	}

	public boolean isGRE5_LIQUIDATION() {
		return GRE5_LIQUIDATION;
	}

	public void setGRE5_LIQUIDATION(boolean gRE5_LIQUIDATION) {
		GRE5_LIQUIDATION = gRE5_LIQUIDATION;
	}

	public boolean isINDICATOR_AMOUNT_RECHARGE() {
		return INDICATOR_AMOUNT_RECHARGE;
	}

	public void setINDICATOR_AMOUNT_RECHARGE(boolean iNDICATOR_AMOUNT_RECHARGE) {
		INDICATOR_AMOUNT_RECHARGE = iNDICATOR_AMOUNT_RECHARGE;
	}

	public boolean isINDICATOR_RECHARGE() {
		return INDICATOR_RECHARGE;
	}

	public void setINDICATOR_RECHARGE(boolean iNDICATOR_RECHARGE) {
		INDICATOR_RECHARGE = iNDICATOR_RECHARGE;
	}

	public boolean isINSERT_WEB_PAYMENT_DATA() {
		return INSERT_WEB_PAYMENT_DATA;
	}

	public void setINSERT_WEB_PAYMENT_DATA(boolean iNSERT_WEB_PAYMENT_DATA) {
		INSERT_WEB_PAYMENT_DATA = iNSERT_WEB_PAYMENT_DATA;
	}

	public boolean isIS_APPROVED_USERS_REPORT() {
		return IS_APPROVED_USERS_REPORT;
	}

	public void setIS_APPROVED_USERS_REPORT(boolean iS_APPROVED_USERS_REPORT) {
		IS_APPROVED_USERS_REPORT = iS_APPROVED_USERS_REPORT;
	}

	public boolean isIS_APPROVE_DEPOSIT() {
		return IS_APPROVE_DEPOSIT;
	}

	public void setIS_APPROVE_DEPOSIT(boolean iS_APPROVE_DEPOSIT) {
		IS_APPROVE_DEPOSIT = iS_APPROVE_DEPOSIT;
	}

	public boolean isIS_APPROVE_USER() {
		return IS_APPROVE_USER;
	}

	public void setIS_APPROVE_USER(boolean iS_APPROVE_USER) {
		IS_APPROVE_USER = iS_APPROVE_USER;
	}

	public boolean isIS_BALANCE_USER() {
		return IS_BALANCE_USER;
	}

	public void setIS_BALANCE_USER(boolean iS_BALANCE_USER) {
		IS_BALANCE_USER = iS_BALANCE_USER;
	}

	public boolean isIS_BUYS_MENU() {
		return IS_BUYS_MENU;
	}

	public void setIS_BUYS_MENU(boolean iS_BUYS_MENU) {
		IS_BUYS_MENU = iS_BUYS_MENU;
	}

	public boolean isIS_CHANGE_PASS() {
		return IS_CHANGE_PASS;
	}

	public void setIS_CHANGE_PASS(boolean iS_CHANGE_PASS) {
		IS_CHANGE_PASS = iS_CHANGE_PASS;
	}

	public boolean isIS_CLOSEOUT_POS() {
		return IS_CLOSEOUT_POS;
	}

	public void setIS_CLOSEOUT_POS(boolean iS_CLOSEOUT_POS) {
		IS_CLOSEOUT_POS = iS_CLOSEOUT_POS;
	}

	public boolean isIS_CREATE_POS() {
		return IS_CREATE_POS;
	}

	public void setIS_CREATE_POS(boolean iS_CREATE_POS) {
		IS_CREATE_POS = iS_CREATE_POS;
	}

	public boolean isIS_CREATE_POS_WEB() {
		return IS_CREATE_POS_WEB;
	}

	public void setIS_CREATE_POS_WEB(boolean iS_CREATE_POS_WEB) {
		IS_CREATE_POS_WEB = iS_CREATE_POS_WEB;
	}

	public boolean isIS_CREDIT_USER() {
		return IS_CREDIT_USER;
	}

	public void setIS_CREDIT_USER(boolean iS_CREDIT_USER) {
		IS_CREDIT_USER = iS_CREDIT_USER;
	}

	public boolean isIS_DELETE_POS() {
		return IS_DELETE_POS;
	}

	public void setIS_DELETE_POS(boolean iS_DELETE_POS) {
		IS_DELETE_POS = iS_DELETE_POS;
	}

	public boolean isIS_DELETE_POS_WEB() {
		return IS_DELETE_POS_WEB;
	}

	public void setIS_DELETE_POS_WEB(boolean iS_DELETE_POS_WEB) {
		IS_DELETE_POS_WEB = iS_DELETE_POS_WEB;
	}

	public boolean isIS_DEPOSIT_INDUSTRY_REPORT() {
		return IS_DEPOSIT_INDUSTRY_REPORT;
	}

	public void setIS_DEPOSIT_INDUSTRY_REPORT(boolean iS_DEPOSIT_INDUSTRY_REPORT) {
		IS_DEPOSIT_INDUSTRY_REPORT = iS_DEPOSIT_INDUSTRY_REPORT;
	}

	public boolean isIS_DEPOSIT_REPORT() {
		return IS_DEPOSIT_REPORT;
	}

	public void setIS_DEPOSIT_REPORT(boolean iS_DEPOSIT_REPORT) {
		IS_DEPOSIT_REPORT = iS_DEPOSIT_REPORT;
	}

	public boolean isIS_DEPOSIT_REPORT_GEOGRAPHIC() {
		return IS_DEPOSIT_REPORT_GEOGRAPHIC;
	}

	public void setIS_DEPOSIT_REPORT_GEOGRAPHIC(boolean iS_DEPOSIT_REPORT_GEOGRAPHIC) {
		IS_DEPOSIT_REPORT_GEOGRAPHIC = iS_DEPOSIT_REPORT_GEOGRAPHIC;
	}

	public boolean isIS_DEPOSIT_REPORT_HISTORY() {
		return IS_DEPOSIT_REPORT_HISTORY;
	}

	public void setIS_DEPOSIT_REPORT_HISTORY(boolean iS_DEPOSIT_REPORT_HISTORY) {
		IS_DEPOSIT_REPORT_HISTORY = iS_DEPOSIT_REPORT_HISTORY;
	}

	public boolean isIS_D_TRANSFER() {
		return IS_D_TRANSFER;
	}

	public void setIS_D_TRANSFER(boolean iS_D_TRANSFER) {
		IS_D_TRANSFER = iS_D_TRANSFER;
	}

	public boolean isIS_E_TRANSFER() {
		return IS_E_TRANSFER;
	}

	public void setIS_E_TRANSFER(boolean iS_E_TRANSFER) {
		IS_E_TRANSFER = iS_E_TRANSFER;
	}

	public boolean isIS_NON_APPROVED_USER() {
		return IS_NON_APPROVED_USER;
	}

	public void setIS_NON_APPROVED_USER(boolean iS_NON_APPROVED_USER) {
		IS_NON_APPROVED_USER = iS_NON_APPROVED_USER;
	}

	public boolean isIS_NON_CREDIT_USER() {
		return IS_NON_CREDIT_USER;
	}

	public void setIS_NON_CREDIT_USER(boolean iS_NON_CREDIT_USER) {
		IS_NON_CREDIT_USER = iS_NON_CREDIT_USER;
	}

	public boolean isIS_POS_SALES_INDUSTRY_REPORT() {
		return IS_POS_SALES_INDUSTRY_REPORT;
	}

	public void setIS_POS_SALES_INDUSTRY_REPORT(boolean iS_POS_SALES_INDUSTRY_REPORT) {
		IS_POS_SALES_INDUSTRY_REPORT = iS_POS_SALES_INDUSTRY_REPORT;
	}

	public boolean isIS_POS_SALES_LOCATION_REPORT() {
		return IS_POS_SALES_LOCATION_REPORT;
	}

	public void setIS_POS_SALES_LOCATION_REPORT(boolean iS_POS_SALES_LOCATION_REPORT) {
		IS_POS_SALES_LOCATION_REPORT = iS_POS_SALES_LOCATION_REPORT;
	}

	public boolean isIS_POS_SALES_REPORT() {
		return IS_POS_SALES_REPORT;
	}

	public void setIS_POS_SALES_REPORT(boolean iS_POS_SALES_REPORT) {
		IS_POS_SALES_REPORT = iS_POS_SALES_REPORT;
	}

	public boolean isIS_PREAPPROVED_NON_CREDIT_USER() {
		return IS_PREAPPROVED_NON_CREDIT_USER;
	}

	public void setIS_PREAPPROVED_NON_CREDIT_USER(
			boolean iS_PREAPPROVED_NON_CREDIT_USER) {
		IS_PREAPPROVED_NON_CREDIT_USER = iS_PREAPPROVED_NON_CREDIT_USER;
	}

	public boolean isIS_REGISTER_PAYMENT() {
		return IS_REGISTER_PAYMENT;
	}

	public void setIS_REGISTER_PAYMENT(boolean iS_REGISTER_PAYMENT) {
		IS_REGISTER_PAYMENT = iS_REGISTER_PAYMENT;
	}

	public boolean isIS_SALES_INDUSTRY_REPORT() {
		return IS_SALES_INDUSTRY_REPORT;
	}

	public void setIS_SALES_INDUSTRY_REPORT(boolean iS_SALES_INDUSTRY_REPORT) {
		IS_SALES_INDUSTRY_REPORT = iS_SALES_INDUSTRY_REPORT;
	}

	public boolean isIS_SALES_LIST() {
		return IS_SALES_LIST;
	}

	public void setIS_SALES_LIST(boolean iS_SALES_LIST) {
		IS_SALES_LIST = iS_SALES_LIST;
	}

	public boolean isIS_SALES_LOCATION_REPORT() {
		return IS_SALES_LOCATION_REPORT;
	}

	public void setIS_SALES_LOCATION_REPORT(boolean iS_SALES_LOCATION_REPORT) {
		IS_SALES_LOCATION_REPORT = iS_SALES_LOCATION_REPORT;
	}

	public boolean isIS_SALES_REPORT() {
		return IS_SALES_REPORT;
	}

	public void setIS_SALES_REPORT(boolean iS_SALES_REPORT) {
		IS_SALES_REPORT = iS_SALES_REPORT;
	}

	public boolean isIS_SALES_REPORT_HISTORY() {
		return IS_SALES_REPORT_HISTORY;
	}

	public void setIS_SALES_REPORT_HISTORY(boolean iS_SALES_REPORT_HISTORY) {
		IS_SALES_REPORT_HISTORY = iS_SALES_REPORT_HISTORY;
	}

	public boolean isIS_SALES_REPORT_RESUME() {
		return IS_SALES_REPORT_RESUME;
	}

	public void setIS_SALES_REPORT_RESUME(boolean iS_SALES_REPORT_RESUME) {
		IS_SALES_REPORT_RESUME = iS_SALES_REPORT_RESUME;
	}

	public boolean isIS_SALES_REPORT_TOTALS() {
		return IS_SALES_REPORT_TOTALS;
	}

	public void setIS_SALES_REPORT_TOTALS(boolean iS_SALES_REPORT_TOTALS) {
		IS_SALES_REPORT_TOTALS = iS_SALES_REPORT_TOTALS;
	}

	public boolean isIS_SELL_PIN() {
		return IS_SELL_PIN;
	}

	public void setIS_SELL_PIN(boolean iS_SELL_PIN) {
		IS_SELL_PIN = iS_SELL_PIN;
	}

	public boolean isIS_SHOW_BALANCE() {
		return IS_SHOW_BALANCE;
	}

	public void setIS_SHOW_BALANCE(boolean iS_SHOW_BALANCE) {
		IS_SHOW_BALANCE = iS_SHOW_BALANCE;
	}

	public boolean isIS_SUBUSER_REGISTER() {
		return IS_SUBUSER_REGISTER;
	}

	public void setIS_SUBUSER_REGISTER(boolean iS_SUBUSER_REGISTER) {
		IS_SUBUSER_REGISTER = iS_SUBUSER_REGISTER;
	}

	public boolean isIS_UPDATE_POS() {
		return IS_UPDATE_POS;
	}

	public void setIS_UPDATE_POS(boolean iS_UPDATE_POS) {
		IS_UPDATE_POS = iS_UPDATE_POS;
	}

	public boolean isIS_UPDATE_POS_WEB() {
		return IS_UPDATE_POS_WEB;
	}

	public void setIS_UPDATE_POS_WEB(boolean iS_UPDATE_POS_WEB) {
		IS_UPDATE_POS_WEB = iS_UPDATE_POS_WEB;
	}

	public boolean isIS_USERS_REPORTS() {
		return IS_USERS_REPORTS;
	}

	public void setIS_USERS_REPORTS(boolean iS_USERS_REPORTS) {
		IS_USERS_REPORTS = iS_USERS_REPORTS;
	}

	public boolean isIS_USER_REGISTER() {
		return IS_USER_REGISTER;
	}

	public void setIS_USER_REGISTER(boolean iS_USER_REGISTER) {
		IS_USER_REGISTER = iS_USER_REGISTER;
	}

	public boolean isIS_VIEW_POS_WEB() {
		return IS_VIEW_POS_WEB;
	}

	public void setIS_VIEW_POS_WEB(boolean iS_VIEW_POS_WEB) {
		IS_VIEW_POS_WEB = iS_VIEW_POS_WEB;
	}

	public boolean isLAST_RECHARGE_POS() {
		return LAST_RECHARGE_POS;
	}

	public void setLAST_RECHARGE_POS(boolean lAST_RECHARGE_POS) {
		LAST_RECHARGE_POS = lAST_RECHARGE_POS;
	}

	public boolean isLIST_ACCOUNTTOPAY() {
		return LIST_ACCOUNTTOPAY;
	}

	public void setLIST_ACCOUNTTOPAY(boolean lIST_ACCOUNTTOPAY) {
		LIST_ACCOUNTTOPAY = lIST_ACCOUNTTOPAY;
	}

	public boolean isLIST_ALL_ACCOUNTTOPAY() {
		return LIST_ALL_ACCOUNTTOPAY;
	}

	public void setLIST_ALL_ACCOUNTTOPAY(boolean lIST_ALL_ACCOUNTTOPAY) {
		LIST_ALL_ACCOUNTTOPAY = lIST_ALL_ACCOUNTTOPAY;
	}

	public boolean isLIST_DEPOSIT_COMPANY() {
		return LIST_DEPOSIT_COMPANY;
	}

	public void setLIST_DEPOSIT_COMPANY(boolean lIST_DEPOSIT_COMPANY) {
		LIST_DEPOSIT_COMPANY = lIST_DEPOSIT_COMPANY;
	}

	public boolean isLIST_DEPOSIT_USER() {
		return LIST_DEPOSIT_USER;
	}

	public void setLIST_DEPOSIT_USER(boolean lIST_DEPOSIT_USER) {
		LIST_DEPOSIT_USER = lIST_DEPOSIT_USER;
	}

	public boolean isLIST_DEPOSIT_USER_COMPANY() {
		return LIST_DEPOSIT_USER_COMPANY;
	}

	public void setLIST_DEPOSIT_USER_COMPANY(boolean lIST_DEPOSIT_USER_COMPANY) {
		LIST_DEPOSIT_USER_COMPANY = lIST_DEPOSIT_USER_COMPANY;
	}

	public boolean isLOGISTIC_REPORTS() {
		return LOGISTIC_REPORTS;
	}

	public void setLOGISTIC_REPORTS(boolean lOGISTIC_REPORTS) {
		LOGISTIC_REPORTS = lOGISTIC_REPORTS;
	}

	public boolean isLOG_IN() {
		return LOG_IN;
	}

	public void setLOG_IN(boolean lOG_IN) {
		LOG_IN = lOG_IN;
	}

	public boolean isLOG_IN_WEB_SERVICE() {
		return LOG_IN_WEB_SERVICE;
	}

	public void setLOG_IN_WEB_SERVICE(boolean lOG_IN_WEB_SERVICE) {
		LOG_IN_WEB_SERVICE = lOG_IN_WEB_SERVICE;
	}

	public boolean isLOST_CARDS() {
		return LOST_CARDS;
	}

	public void setLOST_CARDS(boolean lOST_CARDS) {
		LOST_CARDS = lOST_CARDS;
	}

	public boolean isMODIFY_BANK() {
		return MODIFY_BANK;
	}

	public void setMODIFY_BANK(boolean mODIFY_BANK) {
		MODIFY_BANK = mODIFY_BANK;
	}

	public boolean isMODIFY_BILL() {
		return MODIFY_BILL;
	}

	public void setMODIFY_BILL(boolean mODIFY_BILL) {
		MODIFY_BILL = mODIFY_BILL;
	}

	public boolean isMODIFY_CLIENT() {
		return MODIFY_CLIENT;
	}

	public void setMODIFY_CLIENT(boolean mODIFY_CLIENT) {
		MODIFY_CLIENT = mODIFY_CLIENT;
	}

	public boolean isMODIFY_COMPANY() {
		return MODIFY_COMPANY;
	}

	public void setMODIFY_COMPANY(boolean mODIFY_COMPANY) {
		MODIFY_COMPANY = mODIFY_COMPANY;
	}

	public boolean isMODIFY_DEPOSIT() {
		return MODIFY_DEPOSIT;
	}

	public void setMODIFY_DEPOSIT(boolean mODIFY_DEPOSIT) {
		MODIFY_DEPOSIT = mODIFY_DEPOSIT;
	}

	public boolean isMODIFY_DEPOSIT_CHAIN() {
		return MODIFY_DEPOSIT_CHAIN;
	}

	public void setMODIFY_DEPOSIT_CHAIN(boolean mODIFY_DEPOSIT_CHAIN) {
		MODIFY_DEPOSIT_CHAIN = mODIFY_DEPOSIT_CHAIN;
	}

	public boolean isMODIFY_DEPOSIT_GRE() {
		return MODIFY_DEPOSIT_GRE;
	}

	public void setMODIFY_DEPOSIT_GRE(boolean mODIFY_DEPOSIT_GRE) {
		MODIFY_DEPOSIT_GRE = mODIFY_DEPOSIT_GRE;
	}

	public boolean isMODIFY_PROMOTION() {
		return MODIFY_PROMOTION;
	}

	public void setMODIFY_PROMOTION(boolean mODIFY_PROMOTION) {
		MODIFY_PROMOTION = mODIFY_PROMOTION;
	}

	public boolean isMODIFY_ROUTE() {
		return MODIFY_ROUTE;
	}

	public void setMODIFY_ROUTE(boolean mODIFY_ROUTE) {
		MODIFY_ROUTE = mODIFY_ROUTE;
	}

	public boolean isMODIFY_USER() {
		return MODIFY_USER;
	}

	public void setMODIFY_USER(boolean mODIFY_USER) {
		MODIFY_USER = mODIFY_USER;
	}

	public boolean isOP_SALES_REPORTS() {
		return OP_SALES_REPORTS;
	}

	public void setOP_SALES_REPORTS(boolean oP_SALES_REPORTS) {
		OP_SALES_REPORTS = oP_SALES_REPORTS;
	}

	public boolean isPIN_GENERATION_REQUEST() {
		return PIN_GENERATION_REQUEST;
	}

	public void setPIN_GENERATION_REQUEST(boolean pIN_GENERATION_REQUEST) {
		PIN_GENERATION_REQUEST = pIN_GENERATION_REQUEST;
	}

	public boolean isPOSID_DETAILED_RECHARGE_REPORT_1() {
		return POSID_DETAILED_RECHARGE_REPORT_1;
	}

	public void setPOSID_DETAILED_RECHARGE_REPORT_1(
			boolean pOSID_DETAILED_RECHARGE_REPORT_1) {
		POSID_DETAILED_RECHARGE_REPORT_1 = pOSID_DETAILED_RECHARGE_REPORT_1;
	}

	public boolean isPOSID_DETAILED_RECHARGE_REPORT_2() {
		return POSID_DETAILED_RECHARGE_REPORT_2;
	}

	public void setPOSID_DETAILED_RECHARGE_REPORT_2(
			boolean pOSID_DETAILED_RECHARGE_REPORT_2) {
		POSID_DETAILED_RECHARGE_REPORT_2 = pOSID_DETAILED_RECHARGE_REPORT_2;
	}

	public boolean isPOSID_DETAILED_RECHARGE_REPORT_3() {
		return POSID_DETAILED_RECHARGE_REPORT_3;
	}

	public void setPOSID_DETAILED_RECHARGE_REPORT_3(
			boolean pOSID_DETAILED_RECHARGE_REPORT_3) {
		POSID_DETAILED_RECHARGE_REPORT_3 = pOSID_DETAILED_RECHARGE_REPORT_3;
	}

	public boolean isPRECLOSING_REPORT() {
		return PRECLOSING_REPORT;
	}

	public void setPRECLOSING_REPORT(boolean pRECLOSING_REPORT) {
		PRECLOSING_REPORT = pRECLOSING_REPORT;
	}

	public boolean isPRECLOSING_REPORT_GRE() {
		return PRECLOSING_REPORT_GRE;
	}

	public void setPRECLOSING_REPORT_GRE(boolean pRECLOSING_REPORT_GRE) {
		PRECLOSING_REPORT_GRE = pRECLOSING_REPORT_GRE;
	}

	public boolean isPRECLOSING_REPORT_ZONE() {
		return PRECLOSING_REPORT_ZONE;
	}

	public void setPRECLOSING_REPORT_ZONE(boolean pRECLOSING_REPORT_ZONE) {
		PRECLOSING_REPORT_ZONE = pRECLOSING_REPORT_ZONE;
	}

	public boolean isPRECLOSING_REPORT_ZONE_GRE() {
		return PRECLOSING_REPORT_ZONE_GRE;
	}

	public void setPRECLOSING_REPORT_ZONE_GRE(boolean pRECLOSING_REPORT_ZONE_GRE) {
		PRECLOSING_REPORT_ZONE_GRE = pRECLOSING_REPORT_ZONE_GRE;
	}

	public boolean isPRICING_EDITOR() {
		return PRICING_EDITOR;
	}

	public void setPRICING_EDITOR(boolean pRICING_EDITOR) {
		PRICING_EDITOR = pRICING_EDITOR;
	}

	public boolean isPRINT() {
		return PRINT;
	}

	public void setPRINT(boolean pRINT) {
		PRINT = pRINT;
	}

	public boolean isPRINT_STATUS() {
		return PRINT_STATUS;
	}

	public void setPRINT_STATUS(boolean pRINT_STATUS) {
		PRINT_STATUS = pRINT_STATUS;
	}

	public boolean isPRINT_STATUS_BY_PIN() {
		return PRINT_STATUS_BY_PIN;
	}

	public void setPRINT_STATUS_BY_PIN(boolean pRINT_STATUS_BY_PIN) {
		PRINT_STATUS_BY_PIN = pRINT_STATUS_BY_PIN;
	}

	public boolean isRANKING_REPORT_MAX() {
		return RANKING_REPORT_MAX;
	}

	public void setRANKING_REPORT_MAX(boolean rANKING_REPORT_MAX) {
		RANKING_REPORT_MAX = rANKING_REPORT_MAX;
	}

	public boolean isRANKING_REPORT_MIN() {
		return RANKING_REPORT_MIN;
	}

	public void setRANKING_REPORT_MIN(boolean rANKING_REPORT_MIN) {
		RANKING_REPORT_MIN = rANKING_REPORT_MIN;
	}

	public boolean isRECHARGE_ACTIVITY_REPORT() {
		return RECHARGE_ACTIVITY_REPORT;
	}

	public void setRECHARGE_ACTIVITY_REPORT(boolean rECHARGE_ACTIVITY_REPORT) {
		RECHARGE_ACTIVITY_REPORT = rECHARGE_ACTIVITY_REPORT;
	}

	public boolean isRECHARGE_CARDS() {
		return RECHARGE_CARDS;
	}

	public void setRECHARGE_CARDS(boolean rECHARGE_CARDS) {
		RECHARGE_CARDS = rECHARGE_CARDS;
	}

	public boolean isRECHARGE_TICKETS() {
		return RECHARGE_TICKETS;
	}

	public void setRECHARGE_TICKETS(boolean rECHARGE_TICKETS) {
		RECHARGE_TICKETS = rECHARGE_TICKETS;
	}

	public boolean isRECHARGE_REPORTS() {
		return RECHARGE_REPORTS;
	}

	public void setRECHARGE_REPORTS(boolean rECHARGE_REPORTS) {
		RECHARGE_REPORTS = rECHARGE_REPORTS;
	}

	public boolean isRED_PAYMENT() {
		return RED_PAYMENT;
	}

	public void setRED_PAYMENT(boolean rED_PAYMENT) {
		RED_PAYMENT = rED_PAYMENT;
	}

	public boolean isREPORTS_MENU() {
		return REPORTS_MENU;
	}

	public void setREPORTS_MENU(boolean rEPORTS_MENU) {
		REPORTS_MENU = rEPORTS_MENU;
	}

	public boolean isREVERSE_REPORT() {
		return REVERSE_REPORT;
	}

	public void setREVERSE_REPORT(boolean rEVERSE_REPORT) {
		REVERSE_REPORT = rEVERSE_REPORT;
	}

	public boolean isREVERSE_ROUTE() {
		return REVERSE_ROUTE;
	}

	public void setREVERSE_ROUTE(boolean rEVERSE_ROUTE) {
		REVERSE_ROUTE = rEVERSE_ROUTE;
	}

	public boolean isREVERSE_WAREHOUSE() {
		return REVERSE_WAREHOUSE;
	}

	public void setREVERSE_WAREHOUSE(boolean rEVERSE_WAREHOUSE) {
		REVERSE_WAREHOUSE = rEVERSE_WAREHOUSE;
	}

	public boolean isREVERSE_ZONE() {
		return REVERSE_ZONE;
	}

	public void setREVERSE_ZONE(boolean rEVERSE_ZONE) {
		REVERSE_ZONE = rEVERSE_ZONE;
	}

	public boolean isROUTE_DEPOSIT() {
		return ROUTE_DEPOSIT;
	}

	public void setROUTE_DEPOSIT(boolean rOUTE_DEPOSIT) {
		ROUTE_DEPOSIT = rOUTE_DEPOSIT;
	}

	public boolean isROUTE_LOGISTIC_STOCK() {
		return ROUTE_LOGISTIC_STOCK;
	}

	public void setROUTE_LOGISTIC_STOCK(boolean rOUTE_LOGISTIC_STOCK) {
		ROUTE_LOGISTIC_STOCK = rOUTE_LOGISTIC_STOCK;
	}

	public boolean isROUTE_OP_SALES() {
		return ROUTE_OP_SALES;
	}

	public void setROUTE_OP_SALES(boolean rOUTE_OP_SALES) {
		ROUTE_OP_SALES = rOUTE_OP_SALES;
	}

	public boolean isROUTE_PROMOTIONS_SALES() {
		return ROUTE_PROMOTIONS_SALES;
	}

	public void setROUTE_PROMOTIONS_SALES(boolean rOUTE_PROMOTIONS_SALES) {
		ROUTE_PROMOTIONS_SALES = rOUTE_PROMOTIONS_SALES;
	}

	public boolean isROUTE_SALES() {
		return ROUTE_SALES;
	}

	public void setROUTE_SALES(boolean rOUTE_SALES) {
		ROUTE_SALES = rOUTE_SALES;
	}

	public boolean isROUTE_STATUS() {
		return ROUTE_STATUS;
	}

	public void setROUTE_STATUS(boolean rOUTE_STATUS) {
		ROUTE_STATUS = rOUTE_STATUS;
	}

	public boolean isROUTE_STOCK() {
		return ROUTE_STOCK;
	}

	public void setROUTE_STOCK(boolean rOUTE_STOCK) {
		ROUTE_STOCK = rOUTE_STOCK;
	}

	public boolean isROUTE_STOCK_DETAIL() {
		return ROUTE_STOCK_DETAIL;
	}

	public void setROUTE_STOCK_DETAIL(boolean rOUTE_STOCK_DETAIL) {
		ROUTE_STOCK_DETAIL = rOUTE_STOCK_DETAIL;
	}

	public boolean isSALES_MENU() {
		return SALES_MENU;
	}

	public void setSALES_MENU(boolean sALES_MENU) {
		SALES_MENU = sALES_MENU;
	}

	public boolean isSALES_REPORTS() {
		return SALES_REPORTS;
	}

	public void setSALES_REPORTS(boolean sALES_REPORTS) {
		SALES_REPORTS = sALES_REPORTS;
	}

	public boolean isSERIAL_DETAILED_RECHARGE_REPORT() {
		return SERIAL_DETAILED_RECHARGE_REPORT;
	}

	public void setSERIAL_DETAILED_RECHARGE_REPORT(
			boolean sERIAL_DETAILED_RECHARGE_REPORT) {
		SERIAL_DETAILED_RECHARGE_REPORT = sERIAL_DETAILED_RECHARGE_REPORT;
	}

	public boolean isSERVICES_REPORTS() {
		return SERVICES_REPORTS;
	}

	public void setSERVICES_REPORTS(boolean sERVICES_REPORTS) {
		SERVICES_REPORTS = sERVICES_REPORTS;
	}

	public boolean isSESSION_LOG() {
		return SESSION_LOG;
	}

	public void setSESSION_LOG(boolean sESSION_LOG) {
		SESSION_LOG = sESSION_LOG;
	}

	public boolean isSTART_MENU() {
		return START_MENU;
	}

	public void setSTART_MENU(boolean sTART_MENU) {
		START_MENU = sTART_MENU;
	}

	public boolean isSTATE_GENERAL_OP_SALES() {
		return STATE_GENERAL_OP_SALES;
	}

	public void setSTATE_GENERAL_OP_SALES(boolean sTATE_GENERAL_OP_SALES) {
		STATE_GENERAL_OP_SALES = sTATE_GENERAL_OP_SALES;
	}

	public boolean isSTATE_ROUTE_OP_SALES() {
		return STATE_ROUTE_OP_SALES;
	}

	public void setSTATE_ROUTE_OP_SALES(boolean sTATE_ROUTE_OP_SALES) {
		STATE_ROUTE_OP_SALES = sTATE_ROUTE_OP_SALES;
	}

	public boolean isSTATE_ZONES_OP_SALES() {
		return STATE_ZONES_OP_SALES;
	}

	public void setSTATE_ZONES_OP_SALES(boolean sTATE_ZONES_OP_SALES) {
		STATE_ZONES_OP_SALES = sTATE_ZONES_OP_SALES;
	}

	public boolean isSTATUS_REPORTS() {
		return STATUS_REPORTS;
	}

	public void setSTATUS_REPORTS(boolean sTATUS_REPORTS) {
		STATUS_REPORTS = sTATUS_REPORTS;
	}

	public boolean isSTOCK_REPORTS() {
		return STOCK_REPORTS;
	}

	public void setSTOCK_REPORTS(boolean sTOCK_REPORTS) {
		STOCK_REPORTS = sTOCK_REPORTS;
	}

	public boolean isSUBDISTRIBUTER_LOGISTIC_STOCK() {
		return SUBDISTRIBUTER_LOGISTIC_STOCK;
	}

	public void setSUBDISTRIBUTER_LOGISTIC_STOCK(
			boolean sUBDISTRIBUTER_LOGISTIC_STOCK) {
		SUBDISTRIBUTER_LOGISTIC_STOCK = sUBDISTRIBUTER_LOGISTIC_STOCK;
	}

	public boolean isSWITCH_DISTRIBUTER() {
		return SWITCH_DISTRIBUTER;
	}

	public void setSWITCH_DISTRIBUTER(boolean sWITCH_DISTRIBUTER) {
		SWITCH_DISTRIBUTER = sWITCH_DISTRIBUTER;
	}

	public boolean isTICKET_AVERAGE_RECHARGE() {
		return TICKET_AVERAGE_RECHARGE;
	}

	public void setTICKET_AVERAGE_RECHARGE(boolean tICKET_AVERAGE_RECHARGE) {
		TICKET_AVERAGE_RECHARGE = tICKET_AVERAGE_RECHARGE;
	}

	public boolean isTICKET_AVERAGE_SALE() {
		return TICKET_AVERAGE_SALE;
	}

	public void setTICKET_AVERAGE_SALE(boolean tICKET_AVERAGE_SALE) {
		TICKET_AVERAGE_SALE = tICKET_AVERAGE_SALE;
	}

	public boolean isTOTALS_RECHARGE_SALE() {
		return TOTALS_RECHARGE_SALE;
	}

	public void setTOTALS_RECHARGE_SALE(boolean tOTALS_RECHARGE_SALE) {
		TOTALS_RECHARGE_SALE = tOTALS_RECHARGE_SALE;
	}

	public boolean isTOTALS_STATUS() {
		return TOTALS_STATUS;
	}

	public void setTOTALS_STATUS(boolean tOTALS_STATUS) {
		TOTALS_STATUS = tOTALS_STATUS;
	}

	public boolean isTRAFFIC_REPORTS() {
		return TRAFFIC_REPORTS;
	}

	public void setTRAFFIC_REPORTS(boolean tRAFFIC_REPORTS) {
		TRAFFIC_REPORTS = tRAFFIC_REPORTS;
	}

	public boolean isUNDO_CUSTOMER_BUY() {
		return UNDO_CUSTOMER_BUY;
	}

	public void setUNDO_CUSTOMER_BUY(boolean uNDO_CUSTOMER_BUY) {
		UNDO_CUSTOMER_BUY = uNDO_CUSTOMER_BUY;
	}

	public boolean isUNDO_E_CARD_TOPUP() {
		return UNDO_E_CARD_TOPUP;
	}

	public void setUNDO_E_CARD_TOPUP(boolean uNDO_E_CARD_TOPUP) {
		UNDO_E_CARD_TOPUP = uNDO_E_CARD_TOPUP;
	}

	public boolean isUNUSED_BALANCE_REPORT() {
		return UNUSED_BALANCE_REPORT;
	}

	public void setUNUSED_BALANCE_REPORT(boolean uNUSED_BALANCE_REPORT) {
		UNUSED_BALANCE_REPORT = uNUSED_BALANCE_REPORT;
	}

	public boolean isUPDATE_E_POS() {
		return UPDATE_E_POS;
	}

	public void setUPDATE_E_POS(boolean uPDATE_E_POS) {
		UPDATE_E_POS = uPDATE_E_POS;
	}

	public boolean isUPDATE_E_POS_TOPUP() {
		return UPDATE_E_POS_TOPUP;
	}

	public void setUPDATE_E_POS_TOPUP(boolean uPDATE_E_POS_TOPUP) {
		UPDATE_E_POS_TOPUP = uPDATE_E_POS_TOPUP;
	}

	public boolean isUPDATE_PRICING() {
		return UPDATE_PRICING;
	}

	public void setUPDATE_PRICING(boolean uPDATE_PRICING) {
		UPDATE_PRICING = uPDATE_PRICING;
	}

	public boolean isUSER_CALLCENTER() {
		return USER_CALLCENTER;
	}

	public void setUSER_CALLCENTER(boolean uSER_CALLCENTER) {
		USER_CALLCENTER = uSER_CALLCENTER;
	}

	public boolean isUSER_PAYMENT() {
		return USER_PAYMENT;
	}

	public void setUSER_PAYMENT(boolean uSER_PAYMENT) {
		USER_PAYMENT = uSER_PAYMENT;
	}

	public boolean isVIEW() {
		return VIEW;
	}

	public void setVIEW(boolean vIEW) {
		VIEW = vIEW;
	}

	public boolean isVIEWER_LOG() {
		return VIEWER_LOG;
	}

	public void setVIEWER_LOG(boolean vIEWER_LOG) {
		VIEWER_LOG = vIEWER_LOG;
	}

	public boolean isVIEW_BANK() {
		return VIEW_BANK;
	}

	public void setVIEW_BANK(boolean vIEW_BANK) {
		VIEW_BANK = vIEW_BANK;
	}

	public boolean isVIEW_CLIENT() {
		return VIEW_CLIENT;
	}

	public void setVIEW_CLIENT(boolean vIEW_CLIENT) {
		VIEW_CLIENT = vIEW_CLIENT;
	}

	public boolean isVIEW_COMPANY() {
		return VIEW_COMPANY;
	}

	public void setVIEW_COMPANY(boolean vIEW_COMPANY) {
		VIEW_COMPANY = vIEW_COMPANY;
	}

	public boolean isVIEW_PROMOTION() {
		return VIEW_PROMOTION;
	}

	public void setVIEW_PROMOTION(boolean vIEW_PROMOTION) {
		VIEW_PROMOTION = vIEW_PROMOTION;
	}

	public boolean isVIEW_ROUTE() {
		return VIEW_ROUTE;
	}

	public void setVIEW_ROUTE(boolean vIEW_ROUTE) {
		VIEW_ROUTE = vIEW_ROUTE;
	}

	public boolean isVIEW_USER() {
		return VIEW_USER;
	}

	public void setVIEW_USER(boolean vIEW_USER) {
		VIEW_USER = vIEW_USER;
	}

	public boolean isZONES_DEPOSIT() {
		return ZONES_DEPOSIT;
	}

	public void setZONES_DEPOSIT(boolean zONES_DEPOSIT) {
		ZONES_DEPOSIT = zONES_DEPOSIT;
	}

	public boolean isZONES_LOGISTIC_STOCK() {
		return ZONES_LOGISTIC_STOCK;
	}

	public void setZONES_LOGISTIC_STOCK(boolean zONES_LOGISTIC_STOCK) {
		ZONES_LOGISTIC_STOCK = zONES_LOGISTIC_STOCK;
	}

	public boolean isZONES_OP_SALES() {
		return ZONES_OP_SALES;
	}

	public void setZONES_OP_SALES(boolean zONES_OP_SALES) {
		ZONES_OP_SALES = zONES_OP_SALES;
	}

	public boolean isZONES_PROMOTIONS_SALES() {
		return ZONES_PROMOTIONS_SALES;
	}

	public void setZONES_PROMOTIONS_SALES(boolean zONES_PROMOTIONS_SALES) {
		ZONES_PROMOTIONS_SALES = zONES_PROMOTIONS_SALES;
	}

	public boolean isZONES_SALES() {
		return ZONES_SALES;
	}

	public void setZONES_SALES(boolean zONES_SALES) {
		ZONES_SALES = zONES_SALES;
	}

	public boolean isZONES_STATUS() {
		return ZONES_STATUS;
	}

	public void setZONES_STATUS(boolean zONES_STATUS) {
		ZONES_STATUS = zONES_STATUS;
	}

	public boolean isZONES_STOCK() {
		return ZONES_STOCK;
	}

	public void setZONES_STOCK(boolean zONES_STOCK) {
		ZONES_STOCK = zONES_STOCK;
	}

}