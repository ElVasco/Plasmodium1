package org.security.SecureFilter;

import java.util.Collection;
//import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;


public class MySecureResourceFilter implements FilterInvocationSecurityMetadataSource {

	//public static final Logger logger = Logger.getLogger(MySecureResourceFilter.class);

	public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException {
		//logger.debug("MySecureResourceFilter getAttributes");
		FilterInvocation fi = (FilterInvocation) filter;
		String url = fi.getRequestUrl();
		//logger.debug("url :  " + url);
		String roles = "";

		if(url.equalsIgnoreCase("/pages/script/**")) {
			roles="LOG_IN";
		}else if(url.contains("a4j")) {
			roles="LOG_IN";
		}else if(url.contains("/log/novaredlog.log")) {
			roles="VIEWER_LOG";
		}else if(url.contains("/log/novaredlog.html")) {
			roles="VIEWER_LOG";
		} else if(url.equalsIgnoreCase("/pages/accessdenied.jsf")) {
			roles="ACCESS_DENIED";
		} else if(url.equalsIgnoreCase("/pages/Epos.jsf")) {
			roles="IS_VIEW_POS_WEB,IS_CREATE_POS_WEB,IS_UPDATE_POS_WEB,IS_DELETE_POS_WEB";
		} else if(url.equalsIgnoreCase("/pages/ReporteCuentasporPagar.jsf")) {
			roles="LIST_ACCOUNTTOPAY,LIST_ALL_ACCOUNTTOPAY";
		} else if(url.equalsIgnoreCase("/pages/ReporteCuentasporCobrar.jsf")) {
			roles="LIST_ALL_ACCOUNTTOPAY";
		} else if(url.equalsIgnoreCase("/pages/MenuInicio.jsf")) {
			roles="START_MENU";
		} else if(url.contains("/log/novared.log")) {
			roles="SESSION_LOG";
		} else if(url.equalsIgnoreCase("/pages/cambioclave.jsf")) {
			roles="CHANGE_PASSWORD,IS_CHANGE_PASS";
		} else if(url.equalsIgnoreCase("/pages/menuadministrador.jsf")) {
			roles="ADMIN_MENU";
		} else if(url.equalsIgnoreCase("/pages/bankedit.jsf")) {
			roles="CREATE_BANK,MODIFY_BANK,VIEW_BANK,DELETE_BANK";
		} else if(url.equalsIgnoreCase("/pages/rutas.jsf")) {
			roles="CREATE_ROUTE,MODIFY_ROUTE,DELETE_ROUTE,VIEW_ROUTE";
		} else if(url.equalsIgnoreCase("/pages/clientes.jsf")) {
			roles="CREATE_CLIENT,MODIFY_CLIENT,DELETE_CLIENT,VIEW_CLIENT";
		} else if(url.equalsIgnoreCase("/pages/user.jsf")) {
			roles="CREATE_USER,MODIFY_USER,DELETE_USER,VIEW_USER";
		} else if(url.equalsIgnoreCase("/pages/cambiodeestatus.jsf")) {
			roles="CHANGE_STATUS_NVRD,CHANGE_STATUS_MANUF,CHANGE_STATUS_DISTRIB";
		} else if(url.equalsIgnoreCase("/pages/recargamanual.jsf")) {
			roles="CHANGE_STATUS_NVRD,CHANGE_STATUS_DIRECTV";
		} else if(url.equalsIgnoreCase("/pages/menudistribuidor.jsf")) {
			roles="DISTRIB_MENU";
		} else if(url.equalsIgnoreCase("/pages/AsignarDistribuidor.jsf")) {
			roles="DISTRIB_ZONE";
		} else if(url.equalsIgnoreCase("/pages/reversodistribuidor.jsf")) {
			roles="REVERSE_ZONE";
		} else if(url.equalsIgnoreCase("/pages/asignarruta.jsf")) {
			roles="DISTRIB_ROUTE";
		} else if(url.equalsIgnoreCase("/pages/reversoruta.jsf")) {
			roles="REVERSE_ROUTE";
		} else if(url.equalsIgnoreCase("/pages/menuvendedor.jsf")) {
			roles="SALES_MENU";
		} else if(url.equalsIgnoreCase("/pages/menucomprador.jsf")) {
			roles="IS_BUYS_MENU";
		} else if(url.equalsIgnoreCase("/pages/rutasactdes.jsf")) {
			roles="ACTIVE_ROUTE";
		} else if(url.equalsIgnoreCase("/pages/DesactivarTarjetasRobadasRutas.jsf")){
			roles="ACTIVE_ROUTE_STOLEN";
		} else if(url.equalsIgnoreCase("/pages/agregarfactura.jsf")) {
			roles="CREATE_BILL";
		} else if(url.equalsIgnoreCase("/pages/corregirfactura.jsf")) {
			roles="MODIFY_BILL";
		} else if(url.equalsIgnoreCase("/pages/visualizarfactura.jsf")) {
			roles="CREATE_BILL,MODIFY_BILL";
		} else if(url.equalsIgnoreCase("/pages/agregardeposito.jsf")) {
			roles="CREATE_DEPOSIT";
		} else if(url.equalsIgnoreCase("/pages/corregirdeposito.jsf")) {
			roles="MODIFY_DEPOSIT";
		} else if(url.equalsIgnoreCase("/pages/corregirdepositodistribuidor.jsf")) {
			roles="APPROVE_DEPOSIT";
		} else if(url.equalsIgnoreCase("/pages/corregirdepositodistribuidorlista.jsf")) {
			roles="APPROVE_DEPOSIT";
		} else if(url.equalsIgnoreCase("/pages/visualizardeposito.jsf")) {
			roles="CREATE_DEPOSIT,MODIFY_DEPOSIT,APPROVE_DEPOSIT";
		} else if(url.equalsIgnoreCase("/pages/creaciondepines.jsf")) {
			roles="CREATE_PIN";
		} else if(url.equalsIgnoreCase("/pages/creaciondepinesporrequerimiento.jsf")) {
			roles="CREATE_PIN";
		} else if(url.equalsIgnoreCase("/pages/aprobarusuario.jsf")) {
			roles="IS_APPROVE_USER";
		} else if(url.equalsIgnoreCase("/pages/menureporte.jsf")) {
			roles="REPORTS_MENU, REPORTS_MENUQ";
		} else if(url.equalsIgnoreCase("/pages/reportelogistica.jsf")) {
			roles="LOGISTIC_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reportedistribucion.jsf")) {
			roles="DISTRIBUTION_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reporteinventario.jsf")) {
			roles="STOCK_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/printpreview.jsf")) {
			roles="STOCK_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reporteestatus.jsf")) {
			roles="STATUS_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reporteventas.jsf")) {
			roles="SALES_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reporteventasop.jsf")) {
			roles="OP_SALES_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/ReporteDepositosRecargasElectronicas.jsf")) {
			roles="LIST_DEPOSIT_COMPANY, LIST_DEPOSIT_USER, LIST_DEPOSIT_USER_COMPANY";
		} else if(url.equalsIgnoreCase("/pages/reportedepositos.jsf")) {
			roles="DEPOSIT_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reportefacturas.jsf")) {
			roles="BILL_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reportepromedio.jsf")) {
			roles="AVERAGE_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reportecontrol.jsf")) {
			roles="CONTROL_REPORTS, CONTROL_REPORTSQ";
		} else if(url.equalsIgnoreCase("/pages/reporteresultado.jsf")) {
			roles="LIST_ALL_ACCOUNTTOPAY,LIST_ACCOUNTTOPAY,LIST_DEPOSIT_USER,LIST_DEPOSIT_USER_COMPANY,LIST_DEPOSIT_COMPANY,STOCK_REPORTS,STATUS_REPORTS,SALES_REPORTS,OP_SALES_REPORTS,DEPOSIT_REPORTS,AVERAGE_REPORTS,PRECLOSING_REPORT,PRECLOSING_REPORT_GRE,SERVICES_REPORTS,RECHARGE_REPORTS,TRAFFIC_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reporteresultadoquorum.jsf")) {
			roles="STOCK_REPORTS,STATUS_REPORTS,SALES_REPORTS,OP_SALES_REPORTS,DEPOSIT_REPORTS,AVERAGE_REPORTS,PRECLOSING_REPORT";
		} else if(url.equalsIgnoreCase("/pages/reporteresultadoquorumprint.jsf")) {
			roles="STOCK_REPORTS,STATUS_REPORTS,SALES_REPORTS,OP_SALES_REPORTS,DEPOSIT_REPORTS,AVERAGE_REPORTS,PRECLOSING_REPORT";
		} else if(url.equalsIgnoreCase("/pages/reporterecargas.jsf")) {
			roles="RECHARGE_REPORTS,ACC_NUM_RECHARGE_REPORT,RECHARGE_ACTIVITY_REPORT,ACC_NUM_DETAILED_RECHARGE_SUMMARY,ACC_NUM_SUMMARRY_RECHARGE_REPORT";
		} else if(url.equalsIgnoreCase("/pages/reporteservicios.jsf")) {
			roles="ACTIVITY_0900_REPORT_1,ACTIVITY_0900_REPORT_2,ACTIVITY_SMS_REPORT_1,ACTIVITY_SMS_REPORT_2";
		} else if(url.equalsIgnoreCase("/pages/reportetrafico.jsf")) {
			roles="TRAFFIC_REPORTS,CONSOLIDATED_TRAFFIC_REPORT,DETAILED_TRAFFIC_REPORT";
		} else if(url.equalsIgnoreCase("/pages/reportesaldo.jsf")) {
			roles="GET_BALANCE";
		} else if(url.equalsIgnoreCase("/pages/reportebalance.jsf")) {
			roles="GET_BALANCE";
		} else if(url.equalsIgnoreCase("/pages/editordeprecios.jsf")) {
			roles="UPDATE_PRICING";
		} else if(url.equalsIgnoreCase("/pages/reportecliente.jsf")) {
			roles="CLIENT_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reporteresultadoquorum.jsf")) {
			roles="REPORTS_MENU";
		} else if(url.equalsIgnoreCase("/pages/reportetrafico.jsf")) {
			roles="TRAFFIC_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/reporteservicios.jsf")) {
			roles="SERVICES_REPORTS";
		} else if(url.equalsIgnoreCase("/pages/editordeprecios.jsf")) {
			roles="PRICING_EDITOR";
		} else if(url.equalsIgnoreCase("/pages/reporteconciliacion.jsf")) {
			roles="CREATE_CONCILIATION_FILE";
		} else if(url.equalsIgnoreCase("/pages/conciliacionbolsaunica.jsf")) {
			roles="CREATE_CONCILIATION_FILE";
		} else if(url.equalsIgnoreCase("/pages/conciliacionresultado.jsf")) {
			roles="CREATE_CONCILIATION_FILE";
		} else if(url.equalsIgnoreCase("/pages/menucierre.jsf")) {
			roles="CLOSEOUT_MENU";
		} else if(url.equalsIgnoreCase("/pages/precierre.jsf")) {
			roles="PRECLOSING_REPORT,PRECLOSING_REPORT_GRE";
		} else if(url.equalsIgnoreCase("/pages/precierrecadena.jsf")) {
			roles="PRECLOSING_REPORT,PRECLOSING_REPORT_GRE";
		} else if(url.equalsIgnoreCase("/pages/precierrezona.jsf")) {
			roles="PRECLOSING_REPORT_ZONE";
		} else if(url.equalsIgnoreCase("/pages/reporteprecierrecadena.jsf")) {
			roles="PRECLOSING_REPORT_ZONE_GRE";
		} else if(url.equalsIgnoreCase("/pages/cierre.jsf")) {
			roles="CLOSEOUT";
		}  else if(url.equalsIgnoreCase("/pages/cierrecadena.jsf")) {
			roles="CLOSING_REPORTS_GRE";
		}/*else if(url.equalsIgnoreCase("/pages/vendedorexterno.jsf")) {
			roles="IS_USER_REGISTER";
		}*/ else if(url.equalsIgnoreCase("/pages/agregardepositovi.jsf")) {
			roles="IS_REGISTER_PAYMENT";
		} else if(url.equalsIgnoreCase("/pages/apdepositolista.jsf")) {
			roles="IS_APPROVE_DEPOSIT";
		} else if(url.equalsIgnoreCase("/pages/distribucionsaldovi.jsf")) {
			roles="IS_E_TRANSFER";
		} else if(url.equalsIgnoreCase("/pages/pagoelectronicovi.jsf")) {
			roles="IS_REGISTER_PAYMENT";
		} else if(url.equalsIgnoreCase("/pages/reporteventasvi.jsf")) {
			roles="IS_SALES_REPORT";
		} else if(url.equalsIgnoreCase("/pages/reportedepositosvi.jsf")) {
			roles="IS_DEPOSIT_REPORT";
		} else if(url.equalsIgnoreCase("/pages/venderpinvirtualvi.jsf")) {
			roles="IS_SELL_PIN";
		} else if(url.equalsIgnoreCase("/pages/reportesaldovi.jsf")) {
			roles="IS_BALANCE_USER";
		} else if(url.equalsIgnoreCase("/pages/registrosubusuario.jsf")) {
			roles="IS_SUBUSER_REGISTER";
		} else if(url.equalsIgnoreCase("/pages/reporteposventasvi.jsf")) {
			roles="IS_POS_SALES_REPORT,IS_SALES_INDUSTRY_REPORT,IS_POS_SALES_LOCATION_REPORT,IS_POS_SALES_INDUSTRY_REPORT";
		} else if(url.equalsIgnoreCase("/pages/reporteresultadovi.jsf")) {
			roles="STOCK_REPORTS,STATUS_REPORTS,SALES_REPORTS,OP_SALES_REPORTS,DEPOSIT_REPORTS,AVERAGE_REPORTS,PRECLOSING_REPORT";
		} else if(url.equalsIgnoreCase("/pages/reversosaldovi.jsf")) {
			roles="IS_D_TRANSFER";
		} else if(url.equalsIgnoreCase("/pages/solicitudpines.jsf")) {
			roles="PIN_GENERATION_REQUEST";
		} else if(url.equalsIgnoreCase("/pages/confirmarrecargasanitas.jsf")) {
			roles="CONFIRM_CUSTOMER_BUY";
		} else if(url.equalsIgnoreCase("/pages/recargasaldosanitas.jsf")) {
			roles="RECHARGE_TICKETS";
		} else if(url.equalsIgnoreCase("/pages/recargasaldosanitastdc.jsf")) {
			roles="CREDIT_CARD_PAYMENT";
		} else if(url.equalsIgnoreCase("/pages/reversocierre.jsf")) {
			roles="REVERSE_REPORT";
		} else if(url.equalsIgnoreCase("/pages/liquidacioncadena.jsf")) {
			roles="CHAIN_LIQUIDATION";
		} else if(url.equalsIgnoreCase("/pages/liquidaciongre5.jsf")) {
			roles="GRE5_LIQUIDATION";
		}		

		//logger.debug("roles :  " + roles);
		String[] strings = roles.split(",");
		return roles!=""?SecurityConfig.createList(strings):null;

	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		//logger.debug("MySecureResourceFilter getAllConfigAttributes");
		return null;
	}

	public boolean supports(Class<?> clazz) {
		//logger.debug("MySecureResourceFilter supports");
		return FilterInvocation.class.isAssignableFrom(clazz);
	}
}



