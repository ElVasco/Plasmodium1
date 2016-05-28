package ve.com.plasmodium.model.vo;

import javax.faces.model.SelectItem;

public class AccountToPayDetailVo extends SelectItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private short payerCompany;
	private short serviceCompany;
	private String payerCompanyName;
	private String serviceCompanyName;
	private int sellerUser; 
	private int agentUser;
	private String sellerUserName;
	private int accountToPay;
	private float amount ;
	private String date;
	private int ePos;

	/* "account_type " is a special field use int the label creation for account to pay of external salemen this value is "VI" 
	 * for accounts to pay of seller companies the value is "CC"*/
	public AccountToPayDetailVo(
			short payerCompany,
			short serviceCompany,
			String payerCompanyName,
			String serviceCompanyName,
			int sellerUser,
			int agentUser,
			String sellerUserName,
			int accountToPay,
			float amount ,
			String date,
			int ePos, 
			String account_type){
		 this.payerCompany=payerCompany;
		 this.serviceCompany=serviceCompany;
		 this.payerCompanyName=payerCompanyName;
		 this.serviceCompanyName=serviceCompanyName;
		 this.sellerUser=sellerUser;
		 this.agentUser=agentUser;
		 this.sellerUserName=sellerUserName;
		 this.accountToPay=accountToPay;
		 this.amount=amount;
		 this.date=date;
		 this.ePos=ePos;
		 super.setValue(accountToPay+","+payerCompany+","+agentUser+","+ePos+","+amount+","+date);
		 if (account_type.equals("VI"))
			super.setLabel("Compañía de servicio: "+serviceCompanyName+" | Cadena comercial: "+payerCompanyName + " | Bs. " + amount + " | Fecha: " + date);
		 else if (account_type.equals("CC"))
			super.setLabel("Compañía de servicio: "+serviceCompanyName+" | Cadena comercial: "+payerCompanyName + " | Usuario:" + sellerUserName + " | POS: " + ePos + " | Bs. " + amount + " | Fecha: " + date);
	}

	public AccountToPayDetailVo(AccountToPayDetailVo element){
		payerCompany = element.payerCompany;
		serviceCompany = element.serviceCompany;
		payerCompanyName = element.payerCompanyName;
		serviceCompanyName = element.serviceCompanyName;
		sellerUser = element.sellerUser;
		agentUser = element.agentUser;
		sellerUserName = element.sellerUserName;
		accountToPay = element.accountToPay;
		amount = element.amount;
		date = element.date;
		ePos = element.ePos;
		super.setValue(element.accountToPay+","+element.payerCompany+","+element.sellerUser+","+element.ePos+","+element.amount);
		super.setLabel("Compañía de servicio: "+element.serviceCompanyName+" | Cadena comercial: "+element.payerCompanyName + " | Usuario:" + element.sellerUserName + " | POS: " + element.ePos + " | Bs. " + element.amount);
	}

	public short getPayerCompany() {
		return payerCompany;
	}

	public void setPayerCompany(short payerCompany) {
		this.payerCompany = payerCompany;
	}

	public short getServiceCompany() {
		return serviceCompany;
	}

	public void setServiceCompany(short serviceCompany) {
		this.serviceCompany = serviceCompany;
	}

	public String getPayerCompanyName() {
		return payerCompanyName;
	}

	public void setPayerCompanyName(String payerCompanyName) {
		this.payerCompanyName = payerCompanyName;
	}

	public String getServiceCompanyName() {
		return serviceCompanyName;
	}

	public void setServiceCompanyName(String serviceCompanyName) {
		this.serviceCompanyName = serviceCompanyName;
	}

	public int getSellerUser() {
		return sellerUser;
	}

	public void setSellerUser(int sellerUser) {
		this.sellerUser = sellerUser;
	}

	public int getAgentUser() {
		return agentUser;
	}

	public void setAgentUser(int agentUser) {
		this.agentUser = agentUser;
	}

	public String getPayerUserName() {
		return sellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}

	public int getAccountToPay() {
		return accountToPay;
	}

	public void setAccountToPay(int accountToPay) {
		this.accountToPay = accountToPay;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getEPos() {
		return ePos;
	}

	public void setEPos(int ePos) {
		this.ePos = ePos;
	}
}
