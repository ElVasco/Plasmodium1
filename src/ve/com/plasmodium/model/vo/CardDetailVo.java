package ve.com.plasmodium.model.vo;


public class CardDetailVo extends javax.faces.model.SelectItem{
    
    /**
     * 
     */
    private static final long serialVersionUID = -38444542547238259L;
    private short company;
    private String manuf_no;
    private float cardValue;
    private String companyserial;
    private String serialDetail;
    private String responseCode;
    private String logCodeConfirm;
    private String conf;
    private int status;
    
    public short getCompany() {
        return company;
    }

    public void setCompany(short company) {
        this.company = company;
    }

    public String getManuf_no() {
        return manuf_no;
    }

    public void setManuf_no(String manuf_no) {
        this.manuf_no = manuf_no;
    }

    public void setCardValue(float cardValue) {
	this.cardValue = cardValue;
    }

    public float getCardValue() {
	return cardValue;
    }
    
    public void setCompanyserial(String companyserial) {
		this.companyserial = companyserial;
	}

	public String getCompanyserial() {
		return companyserial;
	}

	public void setSerialDetail(String serialDetail) {
		this.serialDetail = serialDetail;
	}

	public String getSerialDetail() {
		return serialDetail;
	}
	
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setLogCodeConfirm(String logCodeConfirm) {
		this.logCodeConfirm = logCodeConfirm;
	}

	public String getLogCodeConfirm() {
		return logCodeConfirm;
	}

	public void setConf(String conf) {
		this.conf = conf;
	}

	public String getConf() {
		return conf;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public String toString(){
		return serialDetail;
	    }

	public CardDetailVo(short company, String manuf_no, float value) {
	super();
	this.company = company;
	this.manuf_no = manuf_no;
	this.setValue(value);
	super.setValue(manuf_no);
	super.setLabel(manuf_no);
    }
    
    public CardDetailVo(String serial ,int status, String responseCode, String logCodeConfirm) {
    	super();
    	this.companyserial = serial;
    	this.status = status;
    	this.responseCode = responseCode;
    	this.logCodeConfirm = logCodeConfirm;
    	super.setValue(companyserial);
        }
    
    public CardDetailVo(String companyserial, String serialDetail, int confirm) {
    	super();
    	this.companyserial = companyserial;
    	this.serialDetail = serialDetail;
    	this.status = confirm;
    	super.setValue(companyserial);
    	super.setLabel(serialDetail);
        }
    
    public CardDetailVo(String companyserial, String serialDetail, String conf) {
    	super();
    	this.companyserial = companyserial;
    	this.serialDetail = serialDetail;
    	this.conf = conf;
    	super.setValue(companyserial);
    	super.setLabel(serialDetail);
        }
    
    public CardDetailVo() {
    	super();
    }

}
