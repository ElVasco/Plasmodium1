package ve.com.plasmodium.model.vo;

public class AssignmentHistoryVo {

	private String routeName;
	private String routeDate;
	private int denom;
	private int count;
	private int desde;
	private int hasta;
	private int monto;



	public AssignmentHistoryVo(String routeName, String routeDate, int denom, int count, int desde, int hasta, int monto) {
		super();
		this.routeName = routeName;
		this.routeDate = routeDate;
		this.denom = denom;
		this.count = count;
		this.desde = desde;
		this.hasta = hasta;
		this.monto = monto;
	}
	
	

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRouteDate() {
		return routeDate;
	}

	public void setRouteDate(String routeDate) {
		this.routeDate = routeDate;
	}

	public int getDenom() {
		return denom;
	}

	public void setDenom(int denom) {
		this.denom = denom;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}


}
