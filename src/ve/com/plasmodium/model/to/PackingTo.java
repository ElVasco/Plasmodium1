package ve.com.plasmodium.model.to;

import java.math.BigDecimal;

public class PackingTo {

    private short company;

    private short denom;

    private BigDecimal value;

    private int lotsPerCluster;

    private int sublotsPerLot;

    private short cardsPerSublot;

    public PackingTo() {
    }

    public PackingTo(short company, short denom, BigDecimal value, int lotsPerCluster, int sublotsPerLot, short cardsPerSublot) {
	this.company = company;
	this.denom = denom;
	this.value = value;
	this.lotsPerCluster = lotsPerCluster;
	this.sublotsPerLot = sublotsPerLot;
	this.cardsPerSublot = cardsPerSublot;
    }

    public short getCardsPerSublot() {
        return cardsPerSublot;
    }

    public void setCardsPerSublot(short cardsPerSublot) {
        this.cardsPerSublot = cardsPerSublot;
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

    public int getLotsPerCluster() {
        return lotsPerCluster;
    }

    public void setLotsPerCluster(int lotsPerCluster) {
        this.lotsPerCluster = lotsPerCluster;
    }

    public int getSublotsPerLot() {
        return sublotsPerLot;
    }

    public void setSublotsPerLot(int sublotsPerLot) {
        this.sublotsPerLot = sublotsPerLot;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
