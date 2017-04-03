package ve.com.plasmodium.model.vo;

import java.math.BigDecimal;


public class DepositDetailVo extends javax.faces.model.SelectItem{
    
    /**
     * 
     */
    private static final long serialVersionUID = -38444542547238259L;
    private int bill;
    private String rafaga;
    private String control_number;
    private int depositNum;
    private BigDecimal value;  
    private String date;
    private String bill_Date;
    private Short bankId;
    private int count;
    private boolean aux;
    private Short route;
    private Short distributer;
    private boolean approved;
    
    public DepositDetailVo(int bill, String rafaga, String control_number, BigDecimal value, String date, Short BankId, String bill_Date, short route, short distributer) {
	super();
	this.bill = bill;
	this.rafaga = rafaga;
	this.control_number= control_number;
	this.value = value;
	this.date = date;
	this.bankId = BankId;
	this.bill_Date = bill_Date;
	this.route = route;
	this.distributer = distributer;
    }
    
    public DepositDetailVo(String rafaga, BigDecimal value, String date, Short BankId, int deposit, int count, boolean approved) {
    	super();
    	this.rafaga = rafaga;
    	this.date = date;
    	this.bankId = BankId;
    	this.depositNum = deposit;
    	this.value = value;
    	this.count = count;
    	this.approved=approved;
    }
    
    public DepositDetailVo() {
    	super();

        }


	public void setBill(int bill) {
		this.bill = bill;
	}

	public int getBill() {
		return bill;
	}

	public void setRafaga(String rafaga) {
		this.rafaga = rafaga;
	}

	public String getRafaga() {
		return rafaga;
	}

	public void setControl_number(String control_number) {
		this.control_number = control_number;
	}

	public String getControl_number() {
		return control_number;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}
	
	public void setBankId(Short bankId) {
		this.bankId = bankId;
	}


	public int getDepositNum() {
		return depositNum;
	}

	public void setDepositNum(int depositNum) {
		this.depositNum = depositNum;
	}

	public Short getRoute() {
		return route;
	}

	public void setRoute(Short route) {
		this.route = route;
	}

	public Short getBankId() {
		return bankId;
	}

	public void setBill_Date(String bill_Date) {
		this.bill_Date = bill_Date;
	}


	public String getBill_Date() {
		return bill_Date;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setAux(boolean aux) {
		this.aux = aux;
	}

	public boolean isAux() {
		return aux;
	}

	public void setDistributer(Short distributer) {
		this.distributer = distributer;
	}

	public Short getDistributer() {
		return distributer;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public boolean isApproved() {
		return approved;
	}


}
