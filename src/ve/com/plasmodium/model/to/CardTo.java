package ve.com.plasmodium.model.to;

import java.util.Date;

public class CardTo {

    private short company;

    private short denom;

    private short cluster;

    private int lot;

    private int sublot;

    private short serial;

    private String pin;

    private Integer manufNo;

    private short distributer;

    private Date distribDate;

    private Integer distribUser;

    private short sellingRoute;

    private Date routeDate;

    private Integer routeUser;

    private Integer bill;

    private boolean approved;

    public CardTo() {
    }

    public CardTo(short company, short denom, short cluster, int lot, int sublot, short serial, 
	    String pin, Integer manufNo, short distributer, Date distribDate, Integer distribUser, 
	    short sellingRoute, Date routeDate, Integer routeUser, Integer bill, boolean approved) {
		this.company = company;
		this.denom = denom;
		this.cluster = cluster;
		this.lot = lot;
		this.sublot = sublot;
		this.serial = serial;
		this.pin = pin;
		this.manufNo = manufNo;
		this.distributer = distributer;
		this.distribDate = distribDate;
		this.distribUser = distribUser;
		this.sellingRoute = sellingRoute;
		this.routeDate = routeDate;
		this.routeUser = routeUser;
		this.bill = bill;
		this.approved = approved;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public short getCluster() {
        return cluster;
    }

    public void setCluster(short cluster) {
        this.cluster = cluster;
    }

    public short getCompany() {
        return company;
    }

    public void setCompany(short company) {
        this.company = company;
    }

    public short getDenom() {
        return denom;
    }

    public void setDenom(short denom) {
        this.denom = denom;
    }

    public Date getDistribDate() {
        return distribDate;
    }

    public void setDistribDate(Date distribDate) {
        this.distribDate = distribDate;
    }

    public Integer getDistribUser() {
        return distribUser;
    }

    public void setDistribUser(Integer distribUser) {
        this.distribUser = distribUser;
    }

    public short getDistributer() {
        return distributer;
    }

    public void setDistributer(short distributer) {
        this.distributer = distributer;
    }

    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public Integer getManufNo() {
        return manufNo;
    }

    public void setManufNo(Integer manufNo) {
        this.manufNo = manufNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Date getRouteDate() {
        return routeDate;
    }

    public void setRouteDate(Date routeDate) {
        this.routeDate = routeDate;
    }

    public Integer getRouteUser() {
        return routeUser;
    }

    public void setRouteUser(Integer routeUser) {
        this.routeUser = routeUser;
    }

    public short getSellingRoute() {
        return sellingRoute;
    }

    public void setSellingRoute(short sellingRoute) {
        this.sellingRoute = sellingRoute;
    }

    public short getSerial() {
        return serial;
    }

    public void setSerial(short serial) {
        this.serial = serial;
    }

    public int getSublot() {
        return sublot;
    }

    public void setSublot(int sublot) {
        this.sublot = sublot;
    }


}
