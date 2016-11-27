package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class InstitutionDTO implements Serializable {

	private static final long serialVersionUID = -1977342721293261236L;
	private String name;
	private LocationDTO location;
	private InstitutionTypeDTO institutionType;
	
	public InstitutionDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public InstitutionTypeDTO getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(InstitutionTypeDTO institutionType) {
		this.institutionType = institutionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((institutionType == null) ? 0 : institutionType.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		InstitutionDTO other = (InstitutionDTO) obj;
		if (institutionType == null) {
			if (other.institutionType != null)
				return false;
		} else if (!institutionType.equals(other.institutionType))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InstitutionDTO [" + (name != null ? "name=" + name + ", " : "")
				+ (location != null ? "location=" + location + ", " : "")
				+ (institutionType != null ? "institutionType=" + institutionType : "") + "]";
	}




}
