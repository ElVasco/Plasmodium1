package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class LethalityDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5103803175368405657L;
	private String id;
	private String lethality;
	
	public LethalityDTO (){
		
	}
	
	public String getLethality() {
		return lethality;
	}
	public void setLethality(String lethality) {
		this.lethality = lethality;
	}
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lethality == null) ? 0 : lethality.hashCode());
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
		if (!(obj instanceof LethalityDTO)) {
			return false;
		}
		LethalityDTO other = (LethalityDTO) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lethality == null) {
			if (other.lethality != null) {
				return false;
			}
		} else if (!lethality.equals(other.lethality)) {
			return false;
		}
		return true;
	}

}
