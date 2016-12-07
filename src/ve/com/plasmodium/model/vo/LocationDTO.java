package ve.com.plasmodium.model.vo;

import java.io.Serializable;

public class LocationDTO implements Serializable {

	private static final long serialVersionUID = 3287347008117589066L;
	public int idLocation;
	public String latitude;
	public String longitude;
	public String country;
	public String administrative_area_level_1;
	public String locality;
	public String administrative_area_level_2;
	public String route;
	public String demarcation;
	
	
	public LocationDTO () {}
	


	public int getIdLocation() {
		return idLocation;
	}



	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}



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
		return administrative_area_level_1;
	}



	public void setState(String state) {
		this.administrative_area_level_1 = state;
	}



	public String getCity() {
		return locality;
	}



	public void setCity(String city) {
		this.locality = city;
	}



	public String getMunicipality() {
		return administrative_area_level_2;
	}



	public void setMunicipality(String municipality) {
		this.administrative_area_level_2 = municipality;
	}



	public String getDemarcation() {
		return demarcation;
	}



	public void setDemarcation(String demarcation) {
		this.demarcation = demarcation;
	}



	public String getRoute() {
		return route;
	}



	public void setRoute(String route) {
		this.route = route;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administrative_area_level_1 == null) ? 0 : administrative_area_level_1.hashCode());
		result = prime * result + ((administrative_area_level_2 == null) ? 0 : administrative_area_level_2.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((demarcation == null) ? 0 : demarcation.hashCode());
		result = prime * result + idLocation;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((locality == null) ? 0 : locality.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
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
		if (administrative_area_level_1 == null) {
			if (other.administrative_area_level_1 != null)
				return false;
		} else if (!administrative_area_level_1.equals(other.administrative_area_level_1))
			return false;
		if (administrative_area_level_2 == null) {
			if (other.administrative_area_level_2 != null)
				return false;
		} else if (!administrative_area_level_2.equals(other.administrative_area_level_2))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (demarcation == null) {
			if (other.demarcation != null)
				return false;
		} else if (!demarcation.equals(other.demarcation))
			return false;
		if (idLocation != other.idLocation)
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (locality == null) {
			if (other.locality != null)
				return false;
		} else if (!locality.equals(other.locality))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return (country != null ? "country=" + country + ", " : "")
				+ (administrative_area_level_1 != null
						? "administrative_area_level_1=" + administrative_area_level_1 + ", " : "")
				+ (locality != null ? "locality=" + locality + ", " : "")
				+ (administrative_area_level_2 != null
						? "administrative_area_level_2=" + administrative_area_level_2 + ", " : "")
				+ (route != null ? "route=" + route + ", " : "")
				+ (demarcation != null ? "demarcation=" + demarcation : "");
	}





}
