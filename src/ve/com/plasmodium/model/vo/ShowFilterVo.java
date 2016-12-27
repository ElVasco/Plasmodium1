package ve.com.plasmodium.model.vo;

public class ShowFilterVo {

	/**
	 * The property name
	 */
	private String propertyName;
	/**
	 * Do I have to show this property?
	 */
	private boolean show;
	/**
	 * Do I have to filter by this property?
	 * (Filter if string is not empty)
	 */
	private String filter;	
	/**
	 * Do I have to order by this property?
	 */
	private int order;	


	public ShowFilterVo(String propertyName, boolean show, String filter, int order) {
		super();
		this.propertyName=propertyName;
		this.show=show;
		this.filter=filter;
		this.order=order;
	}


	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String isFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}

}
