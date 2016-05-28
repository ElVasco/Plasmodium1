package ve.com.plasmodium.model.vo;

import javax.faces.model.SelectItem;

public class ClientDetailVo extends SelectItem{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private short company;
    private short distributer;
    private int client;
    private String name;
    private String nuc;
    private String rif;
    private short store;
    private short route;
    private short state;
    private String stateName;
    private short city;
    private String cityName;
    private short municipality;
    private String municipalityName;
    private short industry;
    private String industryName;
    private String phone1;
    private String phone2;
    private String email;
    private String street;
    
    
    public ClientDetailVo(short distributer, int client, String name, String rif, short store) {
	super();
	this.distributer = distributer;
	this.client = client;
	this.name = name;
	this.rif = rif;
	this.store=store;
	super.setValue(client);
	super.setLabel(this.toString());
    }

    public ClientDetailVo(String name, String rif,  String street, short state, short municipality, short city, String phone1, String phone2, short industry, String nuc, String email) {
    	super();
    	this.name = name;
    	this.nuc = nuc;
    	this.rif = rif;
    	this.state = state;
    	this.city = city;
    	this.municipality = municipality;
    	this.street = street;
    	this.industry = industry;
    	this.phone1 = phone1;
    	this.phone2 = phone2;
    	this.email = email;
    }
    
	public void setDistributer(short distributer) {
	this.distributer = distributer;
    }

    public short getDistributer() {
	return distributer;
    }

    public void setClient(int client) {
	this.client = client;
    }

    public int getClient() {
	return client;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setNuc(String nuc) {
		this.nuc = nuc;
	}

	public String getNuc() {
		return nuc;
	}

	public void setRif(String rif) {
	this.rif = rif;
    }

    public String getRif() {
	return rif;
    }

    public void setStore(short store) {
	this.store = store;
    }

    public short getStore() {
	return store;
    }
    
    public void setCompany(short company) {
		this.company = company;
	}

	public short getCompany() {
		return company;
	}

	public void setRoute(short route) {
		this.route = route;
	}

	public short getRoute() {
		return route;
	}

	public void setState(short state) {
		this.state = state;
	}

	public short getState() {
		return state;
	}

	public void setCity(short city) {
		this.city = city;
	}

	public short getCity() {
		return city;
	}

	public void setMunicipality(short municipality) {
		this.municipality = municipality;
	}

	public short getMunicipality() {
		return municipality;
	}

	public void setIndustry(short industry) {
		this.industry = industry;
	}

	public short getIndustry() {
		return industry;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet() {
		return street;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setMunicipalityName(String municipalityName) {
		this.municipalityName = municipalityName;
	}

	public String getMunicipalityName() {
		return municipalityName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString(){
	return rif+" | "+name;
    }
    
}
