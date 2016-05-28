package ve.com.plasmodium.model.to;

public class DistributerTo {

    private Short company;

    private String name;

    private Short clientCompany;

    private boolean isDistributer;

    public DistributerTo() {
    }

    public DistributerTo(Short company, String name, Short clientCompany, boolean isDistributer) {
	this.company = company;
	this.name = name;
	this.clientCompany = clientCompany;
	this.isDistributer = isDistributer;
    }

    public Short getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(Short clientCompany) {
        this.clientCompany = clientCompany;
    }

    public Short getCompany() {
        return company;
    }

    public void setCompany(Short company) {
        this.company = company;
    }

    public boolean isDistributer() {
        return isDistributer;
    }

    public void setDistributer(boolean isDistributer) {
        this.isDistributer = isDistributer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
