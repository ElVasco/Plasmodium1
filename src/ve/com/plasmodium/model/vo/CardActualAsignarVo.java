package ve.com.plasmodium.model.vo;

import java.math.BigDecimal;

public class CardActualAsignarVo {

	private short userDistributer;  // almacen desde el que se realiza la asignacion
	private short distributer; // a quien se realiza la asignacion
	private short warehouse; 
	private int user;
	private short company;
	private String routeN;
	private short route;
	private short denom;
	private int cluster;
	private int desde;
	private int hasta;
	private int cantidad;
	private String date;
	private BigDecimal monto;
	private BigDecimal montoFacial;
	private int manuf_no;
	private boolean status;
	private short clientId;
	private String clientN;
	private String controlNumber;
	private short promotion;
	private String value;
	private String distributerName;
	private short denomValue;

	// Campos adicionales necesarios en segunda 
	//  parte del Wizard de asignacion a distribuidor
	//  para poder actualizar las tarjetas
	private short distributerUsr;


	public CardActualAsignarVo(short userDistributer, int user, short company, short distributer, short denom, int cluster, int desde, int hasta, int cantidad, BigDecimal monto, String distrib) {
		super();
		this.userDistributer = userDistributer;
		this.user = user;
		this.company = company;
		this.distributer = distributer;
		this.denom = denom;
		this.cluster = cluster;
		this.desde = desde;
		this.hasta = hasta;
		this.cantidad = cantidad;
		this.monto = monto;
		this.distributerName = distrib;
	}

	public CardActualAsignarVo( short Distributer,  String control_num, short denom, String date, short clientId,  short route,   BigDecimal monto_facial, BigDecimal importe, int manuf_no, boolean promocion, String value ) {
		super();
		this.distributer = Distributer;
		this.controlNumber = control_num;
		this.denom = denom;
		this.date = date;
		this.clientId = clientId;

		this.route = route;

		this.montoFacial = monto_facial;
		if(promocion){
			this.value = value+" - Promocion";
		}else{
			this.value = value+"";
		}
		this.monto = importe;
		this.manuf_no = manuf_no;
		this.status = promocion;
	}

	public CardActualAsignarVo(String control_num, short route, short denom, int desde, int hasta, int cantidad, BigDecimal monto, int count, boolean promocion ) {
		super();
		this.controlNumber = control_num;
		this.route = route;
		this.denom = denom;
		this.desde = desde;
		this.hasta = hasta;
		this.monto = monto;
		this.cantidad = count;
		this.monto = monto;
		this.status = promocion;

	}

	public CardActualAsignarVo(short userDistributer, short warehouse, int user, short company, short distributer, String routeName, short denom, int desde, int hasta, int cantidad, BigDecimal monto, int cluster) {
		super();
		this.userDistributer = userDistributer;
		this.user = user;
		this.setWarehouse(warehouse);
		this.company = company;
		this.routeN = routeName;
		this.distributer = distributer;
		this.denom = denom;
		this.desde = desde;
		this.hasta = hasta;
		this.cantidad = cantidad;
		this.monto = monto;
		this.cluster=cluster;
	}

	public CardActualAsignarVo(String userDistributer, String user, String company, String distributer, String denom, String desde, String hasta, String cantidad, String monto) {
		super();
		this.userDistributer = Short.parseShort(userDistributer); 
		this.user = Integer.parseInt(user);
		this.company = Short.parseShort(company); 
		this.distributer = Short.parseShort(distributer); 
		this.denom = Short.parseShort(denom); ;
		this.desde = Integer.parseInt(desde);
		this.hasta = Integer.parseInt(hasta);
		this.cantidad = Integer.parseInt(cantidad);
		this.monto = new BigDecimal(monto);
	}

	/*public CardActualAsignarVo (short company, short distributer, short route, short denom, int desde, int hasta, int cantidad, String monto, String montoFacial){
		super();
		this.company = company; 
		this.distributer = distributer; 
		this.route = route;
		this.denom = denom;
		this.desde = desde;
		this.hasta = hasta;
		this.cantidad = cantidad;
		this.monto = new BigDecimal(monto);
		this.montoFacial = new BigDecimal(montoFacial);
    }*/

	public CardActualAsignarVo (short company, short distributer, short route, short denom, int desde, int hasta, int cantidad, String monto, String montoFacial, String value, short promotion){
		super();
		this.company = company; 
		this.distributer = distributer; 
		this.route = route;
		this.denom = denom;
		this.desde = desde;
		this.hasta = hasta;
		this.cantidad = cantidad;
		this.monto = new BigDecimal(monto);
		this.montoFacial = new BigDecimal(montoFacial);
		if(monto.compareTo("0.0000")==0){
			this.value = value+" - Promocion";
		}else{
			this.value = value;
		}
		this.promotion=promotion;
	}

	public CardActualAsignarVo (short company, short distributer, short route, short denom, int desde, int hasta, int cantidad, BigDecimal monto, BigDecimal montoFacial){
		super();
		this.company = company; 
		this.distributer = distributer; 
		this.route = route;
		this.denom = denom;
		this.desde = desde;
		this.hasta = hasta;
		this.cantidad = cantidad;
		this.monto = monto;
		this.montoFacial = montoFacial;
	}

	public CardActualAsignarVo (short company, short distributer, short route, short denom, String value, int desde, int hasta, int cantidad){
		super();
		this.company = company; 
		this.distributer = distributer; 
		this.route = route;
		this.denom = denom;
		this.value=value;
		this.desde = desde;
		this.hasta = hasta;
		this.cantidad = cantidad;
	}

	public CardActualAsignarVo(){
		super();
	}

	public CardActualAsignarVo(CardActualAsignarVo toCopy) {
		super();
		this.userDistributer=toCopy.userDistributer;
		this.user=toCopy.user;
		this.company=toCopy.company;
		this.routeN=toCopy.routeN;
		this.distributer=toCopy.distributer;
		this.route=toCopy.route;
		this.denom=toCopy.denom;
		this.desde=toCopy.desde;
		this.hasta=toCopy.hasta;
		this.cantidad=toCopy.cantidad;
		this.date=toCopy.date;
		this.monto=toCopy.monto;
		this.montoFacial=toCopy.montoFacial;
		this.manuf_no=toCopy.manuf_no;
		this.status=toCopy.status;
		this.clientId=toCopy.clientId;
		this.clientN=toCopy.clientN;
		this.controlNumber=toCopy.controlNumber;
		this.promotion=toCopy.promotion;
		this.value=toCopy.value;
		this.distributerName=toCopy.distributerName;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public short getCompany() {
		return company;
	}
	public void setCompany(short company) {
		this.company = company;
	}
	public short getDenom() {
		return denom;
	}
	public void setDenom(short denom) {
		this.denom = denom;
	}
	public short getRoute() {
		return route;
	}
	public void setRoute(short route) {
		this.route = route;
	}    
	public int getDesde() {
		return desde;
	}
	public void setDesde(int desde) {
		this.desde = desde;
	}
	public short getDistributer() {
		return distributer;
	}
	public void setDistributer(short distributer) {
		this.distributer = distributer;
	}
	public void setRouteN(String routeN) {
		this.routeN = routeN;
	}

	public String getRouteN() {
		return routeN;
	}

	public int getHasta() {
		return hasta;
	}
	public void setHasta(int hasta) {
		this.hasta = hasta;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getMontoFacial() {
		return montoFacial;
	}
	public void setMontoFacial(BigDecimal montoFacial) {
		this.montoFacial = montoFacial;
	}
	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public short getUserDistributer() {
		return userDistributer;
	}

	public void setUserDistributer(short userDistributer) {
		this.userDistributer = userDistributer;
	}

	public short getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(short warehouse) {
		this.warehouse = warehouse;
	}

	public void setManuf_no(int manuf_no) {
		this.manuf_no = manuf_no;
	}

	public int getManuf_no() {
		return manuf_no;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}


	public String getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setClientId(short clientId) {
		this.clientId = clientId;
	}

	public short getClientId() {
		return clientId;
	}

	public void setClientN(String clientN) {
		this.clientN = clientN;
	}

	public String getClientN() {
		return clientN;
	}

	/**
	 * @param promotion the promotion to set
	 */
	 public void setPromotion(short promotion) {
		this.promotion = promotion;
	}

	/**
	 * @return the promotion
	 */
	 public short getPromotion() {
		return promotion;
	}

	/**
	 * @param distributerUsr the distributerUsr to set
	 */
	 public void setDistributerUsr(short distributerUsr) {
		 this.distributerUsr = distributerUsr;
	 }

	 /**
	  * @return the distributerUsr
	  */
	 public short getDistributerUsr() {
		 return distributerUsr;
	 }

	 public void setValue(String value) {
		 this.value = value;
	 }

	 public String getValue() {
		 return value;
	 }

	 public void setDistributerName(String distributerName) {
		 this.distributerName = distributerName;
	 }

	 public String getDistributerName() {
		 return distributerName;
	 }

	public int getCluster() {
		return cluster;
	}

	public void setCluster(int cluster) {
		this.cluster = cluster;
	}

	public short getDenomValue() {
		return denomValue;
	}

	public void setDenomValue(short denomValue) {
		this.denomValue = denomValue;
	}
}
