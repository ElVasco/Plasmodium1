package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class LocationDTO implements Serializable {

	private static final long serialVersionUID = 3287347008117589066L;
	private String latitude;
	private String longitude;
	private String state;
	private String city;
	private String municipality;
	private String demarcation;
	
	
	public LocationDTO () {}
	
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getDemarcation() {
		return demarcation;
	}
	public void setDemarcation(String demarcation) {
		this.demarcation = demarcation;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((demarcation == null) ? 0 : demarcation.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((municipality == null) ? 0 : municipality.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		LocationDTO other = (LocationDTO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (demarcation == null) {
			if (other.demarcation != null)
				return false;
		} else if (!demarcation.equals(other.demarcation))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (municipality == null) {
			if (other.municipality != null)
				return false;
		} else if (!municipality.equals(other.municipality))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "LocationDTO [" + (latitude != null ? "latitude=" + latitude + ", " : "")
				+ (longitude != null ? "longitude=" + longitude + ", " : "")
				+ (state != null ? "state=" + state + ", " : "") + (city != null ? "city=" + city + ", " : "")
				+ (municipality != null ? "municipality=" + municipality + ", " : "")
				+ (demarcation != null ? "demarcation=" + demarcation : "") + "]";
	}

}
