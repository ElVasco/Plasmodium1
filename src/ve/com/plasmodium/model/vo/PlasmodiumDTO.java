package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class PlasmodiumDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8091132031798295338L;
	
	private String id;
	private String name;
	private String description;
	private LethalityDTO letalLevel;
	private String letalidad;
	public PlasmodiumTypeDTO plasmodiumType;
	
	public PlasmodiumDTO (){
		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public LethalityDTO getLetalLevel() {
		return letalLevel;
	}
	public void setLetalLevel(LethalityDTO letalLevel) {
		this.letalLevel = letalLevel;
	}
	
	public String getLetalidad() {
		return letalidad;
	}
	public void setLetalidad(String string) {
		this.letalidad = string;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((letalLevel == null) ? 0 : letalLevel.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PlasmodiumDTO)) {
			return false;
		}
		PlasmodiumDTO other = (PlasmodiumDTO) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (letalLevel == null) {
			if (other.letalLevel != null) {
				return false;
			}
		} else if (!letalLevel.equals(other.letalLevel)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	public PlasmodiumTypeDTO getPlasmodiumType() {
		return plasmodiumType;
	}

	public void setPlasmodiumType(PlasmodiumTypeDTO plasmodiumType) {
		this.plasmodiumType = plasmodiumType;
	}
}
