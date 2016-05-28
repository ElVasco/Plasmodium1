package ve.com.plasmodium.model.vo;
//IS
public class PinDetailVo {
    
	private int company;
	private int denom;
	private int cluster;
	private int lot;
	private int sublot;
	private int serial;
	private String pin;
	private int client;
	private int ePos;
    private float amount;
    private String accountNumber;
    //IS
    public PinDetailVo(int company, int denom, int cluster, int lot, int sublot, int serial, String pin, int client, int ePos, float amount, String accountNumber) {
		super();
		this.company = company;
		this.denom = denom;
		this.cluster = cluster;
		this.lot = lot;
		this.sublot = sublot;
		this.serial = serial;
		this.pin = pin;
		this.client = client;
		this.ePos = ePos;
		this.amount = amount;
		this.accountNumber = accountNumber;
    }
    
    public PinDetailVo(int company, int denom, int cluster, int lot, int sublot, int serial) {
		super();
		this.company = company;
		this.denom = denom;
		this.cluster = cluster;
		this.lot = lot;
		this.sublot = sublot;
		this.serial = serial;
    }
    
    public PinDetailVo(){
    	super();
    }
    
    public void setCompany(short company) {
		this.company = company;
	}
	public int getCompany() {
		return company;
	}
	public void setDenom(int denom) {
        this.denom = denom;
    }
	public int getDenom() {
        return denom;
    }
    public void setCluster(int cluster) {
		this.cluster = cluster;
	}
	public int getCluster() {
		return cluster;
	}
	public void setLot(int lot) {
		this.lot = lot;
	}
	public int getLot() {
		return lot;
	}
    public void setSublot(int sublot) {
		this.sublot = sublot;
	}
	public int getSublot() {
		return sublot;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getSerial() {
		return serial;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPin() {
		return pin;
	}
	public void setClient(int client) {
		this.client = client;
	}
	public int getClient() {
		return client;
	}
	public void setePos(int ePos) {
		this.ePos = ePos;
	}
	public int getePos() {
		return ePos;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getAmount() {
		return amount;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

}
