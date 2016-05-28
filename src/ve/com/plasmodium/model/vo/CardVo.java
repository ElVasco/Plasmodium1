package ve.com.plasmodium.model.vo;

public class CardVo {
    
    private short company;
    private short distributer;
    //private Date distribDate;
    private String distribUsr;
    private int desde;
    private int hasta;
    
    public short getCompany() {
        return company;
    }

    public void setCompany(short company) {
        this.company = company;
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public String getDistribUsr() {
        return distribUsr;
    }

    public void setDistribUsr(String distribUsr) {
        this.distribUsr = distribUsr;
    }

    public short getDistributer() {
        return distributer;
    }

    public void setDistributer(short distributer) {
        this.distributer = distributer;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public CardVo(short company, short distributer, String distribUsr, int desde, int hasta) {
	super();
	this.company = company;
	this.distributer = distributer;
	this.distribUsr = distribUsr;
	this.desde = desde;
	this.hasta = hasta;
    }
    

}
