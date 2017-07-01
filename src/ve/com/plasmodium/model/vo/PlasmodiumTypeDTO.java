package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class PlasmodiumTypeDTO implements Serializable{
	
	private static final long serialVersionUID = -6413742488576935913L;
	
	public int idPlasmodiumType;
	public String name;
	public String description;
	public int idLetalidad;
	
	public int getIdLetalidad() {
		return idLetalidad;
	}

	public void setIdLetalidad(int idLetalidad) {
		this.idLetalidad = idLetalidad;
	}

	public PlasmodiumTypeDTO() {}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdPlasmodiumType() {
		return idPlasmodiumType;
	}

	public void setIdPlasmodiumType(int idPlasmodiumType) {
		this.idPlasmodiumType = idPlasmodiumType;
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
		PlasmodiumTypeDTO other = (PlasmodiumTypeDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "plasmodiumTypeDTO [" + (name != null ? "name=" + name : "") + "]";
	}

}