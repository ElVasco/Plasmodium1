package ve.com.plasmodium.model.vo;

import javax.faces.model.SelectItem;

public class EposDetailVo extends SelectItem{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7859484171748139126L;
    private short company;
    private int user;
    private int id;
    private String description;
    private Short city;
    private Short municipality;
    private Short state;
    private Short industry;
    private boolean active;
    
    public EposDetailVo(short company, int user, int ePosId, String description, Short industry, Short state, Short municipality, Short city, boolean active) {
    	super();
    	this.id = ePosId;
    	this.company = company;
    	this.user = user;
    	this.description = description;
    	this.city = city;
    	this.municipality = municipality;
    	this.state = state;
    	this.industry = industry;
    	this.active = active;
    	super.setValue(ePosId);
    	super.setLabel(this.toString());
    }

	public short getCompany() {
		return company;
	}

	public void setCompany(short company) {
		this.company = company;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getCodigo() {
		return id;
	}

	public void setCodigo(int ePosId) {
		this.id = ePosId;
	}

	public String getDescripcion() {
		return description;
	}

	public void setDescripcion(String descripcion) {
		this.description = descripcion;
	}

	public Short getCity() {
		return city;
	}

	public void setCity(Short city) {
		this.city = city;
	}

	public Short getMunicipality() {
		return municipality;
	}

	public void setMunicipality(Short municipality) {
		this.municipality = municipality;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Short getIndustry() {
		return industry;
	}

	public void setIndustry(Short industry) {
		this.industry = industry;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

     
}
