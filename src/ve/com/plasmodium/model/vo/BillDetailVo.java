package ve.com.plasmodium.model.vo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.faces.model.SelectItem;

public class BillDetailVo extends SelectItem{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private short company;
    private short distributer;
    private short route;
    private int bill;
    private String controlNumber;
    private float amount ;
    private String date;
    private String dated;
    private String distrib;
    private String rout;
    private String controlNumberDeposit;
    private String bank;
    private String status;
	private String client_name;
    private String nuc;
    
    	public BillDetailVo(short company, short distributer, short route, int bill, String controlNumber, float amount, String date){
    	    this.setCompany(company);
    	    this.setDistributer(distributer);
    	    this.setRoute(route);
    	    this.setBill(bill);
    	    this.controlNumber = controlNumber;
    	    this.amount = amount;
    	    this.date = date;
    	    super.setValue(bill);
    	    super.setLabel(controlNumber+" | "+date+" | Bs. "+amount);
    	}

    	public BillDetailVo(String distrib, String route, String dateb, String control_number_bill, String control_number_deposit, String bank, String dated, String ap, String client_name, String nuc){    	    
    	    this.setDistrib(distrib);
    	    this.setRout(route);
    	    this.setControlNumber(control_number_bill);
    	    this.setControlNumberDeposit(control_number_deposit);
    	    this.setBank(bank);
    	    this.setDate(dateb);
    	    this.setDated(dated);
    	    this.setStatus(ap);
    	    this.setClient_name(client_name);
    	    this.setNuc(nuc);
    	}
    	
	public void setCompany(short company) {
	    this.company = company;
	}

	public short getCompany() {
	    return company;
	}

	public void setDistributer(short distributer) {
	    this.distributer = distributer;
	}

	public short getDistributer() {
	    return distributer;
	}

	public void setRoute(short route) {
	    this.route = route;
	}

	public short getRoute() {
	    return route;
	}

	public void setBill(int bill) {
	    this.bill = bill;
	}

	public int getBill() {
	    return bill;
	}
	
	public void setControlNumber(String controlNumber) {
	    this.controlNumber = controlNumber;
	}

	public String getControlNumber() {
	    return controlNumber;
	}
	
	public void setAmount(float amount) {
	    this.amount = amount;
	}

	public float getAmount() {
	    return amount;
	}
	
	public void setDate(String date) {
	    this.date = date;
	}

	public String getDate() {
	    return date;
	}	
	
	/**
	 * @return the dated
	 */
	public String getDated() {
		return dated;
	}

	/**
	 * @param dated the dated to set
	 */
	public void setDated(String dated) {
		this.dated = dated;
	}

	/**
	 * @return the distrib
	 */
	public String getDistrib() {
		return distrib;
	}

	/**
	 * @param distrib the distrib to set
	 */
	public void setDistrib(String distrib) {
		this.distrib = distrib;
	}

	/**
	 * @return the rout
	 */
	public String getRout() {
		return rout;
	}

	/**
	 * @param rout the rout to set
	 */
	public void setRout(String rout) {
		this.rout = rout;
	}

	/**
	 * @return the controlNumberDeposit
	 */
	public String getControlNumberDeposit() {
		return controlNumberDeposit;
	}

	/**
	 * @param controlNumberDeposit the controlNumberDeposit to set
	 */
	public void setControlNumberDeposit(String controlNumberDeposit) {
		this.controlNumberDeposit = controlNumberDeposit;
	}

	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
    /**
	 * @return the client_name
	 */
	public String getClient_name() {
		return client_name;
	}

	/**
	 * @param client_name the client_name to set
	 */
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	/**
	 * @return the nuc
	 */
	public String getNuc() {
		return nuc;
	}

	/**
	 * @param nuc the nuc to set
	 */
	public void setNuc(String nuc) {
		this.nuc = nuc;
	}



	public String toString(){
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("###,###,###,###,##0.00");
		
		return controlNumber+" | "+date+" | Bs. "+df.format(Double.parseDouble(Float.toString(amount)));
    }
    
}
