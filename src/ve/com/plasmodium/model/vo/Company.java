package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	private int institution;
	private String name;
	
	public Company(){}
	
	public Company(int institution, String name){
		this.institution = institution;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInstitution() {
		return institution;
	}
	public void setName(int institution) {
		this.institution = institution;
	}
}
