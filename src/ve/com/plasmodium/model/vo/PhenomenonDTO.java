package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class PhenomenonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 413568142997132300L;

	private String id;
	private String name;
	private String description;
	private String idPhenomenonType;

	public PhenomenonDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getIdPhenomenonType() {
		return idPhenomenonType;
	}

	public void setIdPhenomenonType(String idPhenomenonType) {
		this.idPhenomenonType = idPhenomenonType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((idPhenomenonType == null) ? 0 : idPhenomenonType.hashCode());
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
		PhenomenonDTO other = (PhenomenonDTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (idPhenomenonType == null) {
			if (other.idPhenomenonType != null)
				return false;
		} else if (!idPhenomenonType.equals(other.idPhenomenonType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhenomenonDTO [id=" + id + ", name=" + name + ", description=" + description + ", phenomenonTypeDTO="
				+ idPhenomenonType + "]";
	}
}
