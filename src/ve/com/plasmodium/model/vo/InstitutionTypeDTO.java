package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class InstitutionTypeDTO implements Serializable {

	private static final long serialVersionUID = -6413742488576935913L;
	public int idIstitutionType;
	public String name;
	
	public InstitutionTypeDTO() {}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIdIstitutionType() {
		return idIstitutionType;
	}

	public void setIdIstitutionType(int idIstitutionType) {
		this.idIstitutionType = idIstitutionType;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstitutionTypeDTO other = (InstitutionTypeDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InstitutionTypeDTO [" + (name != null ? "name=" + name : "") + "]";
	}

}
