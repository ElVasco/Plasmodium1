package ve.com.plasmodium.model.vo;

import javax.faces.model.SelectItem;

public class StateDetailVo extends SelectItem{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private short distributer;
    private short route;
    private String name;
    private short city;
    private short state;
    private String cityName;
    private String stateName;
    
    public StateDetailVo(short distributer, short route, String name, short city, short state, String cityName, String stateName) {
    					//"SELECT s.selling_route, s.name, c.city, c.description, st.state, st.description 
    super();
	this.distributer = distributer;
	this.setRoute(route);
	this.name = name;
	this.city = city;
	this.state= state;
	this.cityName= cityName;
	this.stateName= stateName;
	super.setValue(route);
	super.setLabel(this.toString());
    }

    public void setDistributer(short distributer) {
	this.distributer = distributer;
    }

    public short getDistributer() {
	return distributer;
    }

    public void setRoute(short route) {
		this.route = route;
	}

	public short getRoute() {
		return route;
	}

	public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
    
    public void setCity(short city) {
	this.city = city;
    }

    public short getCity() {
	return city;
    }

    public void setState(short state) {
	this.state = state;
    }

    public short getState() {
	return state;
    }
    
    public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateName() {
		return stateName;
	}

	public String toString(){
	return stateName+" | "+cityName;
    }
     
}
