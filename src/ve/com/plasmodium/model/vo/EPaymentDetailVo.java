package ve.com.plasmodium.model.vo;
//IS
public class EPaymentDetailVo {

	private String cardNumber;
	private String securityCode; 
	private String validThruDate; 
	private String cardholderName; 
	private String cardholderId;
	private String amount;
	private String responseCode;
	private String logCode;
	private String receipt;
	
	public EPaymentDetailVo() {
		super();
	}
	
	public EPaymentDetailVo(String cardNumber, String securityCode, String validThruDate, String cardholderName, String cardholderId, String amount, String responseCode, String logCode) {
		super();
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.validThruDate = validThruDate;
		this.cardholderName = cardholderName;
		this.cardholderId = cardholderId;
		this.amount = amount;
		this.responseCode = responseCode;
		this.logCode = logCode;
		this.receipt =  new String();
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getValidThruDate() {
		return validThruDate;
	}

	public void setValidThruDate(String validThruDate) {
		this.validThruDate = validThruDate;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getCardholderId() {
		return cardholderId;
	}

	public void setCardholderId(String cardholderId) {
		this.cardholderId = cardholderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getLogCode() {
		return logCode;
	}

	public void setLog_code(String logCode) {
		this.logCode = logCode;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getReceipt() {
		return receipt;
	}
}
