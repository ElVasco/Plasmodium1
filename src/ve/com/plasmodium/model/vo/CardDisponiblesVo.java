package ve.com.plasmodium.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.log4j.Logger;

public class CardDisponiblesVo implements Serializable{

	public static final Logger logger = Logger.getLogger(CardDisponiblesVo.class);
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1327443033215389796L;
	
	private short denom;
    private BigDecimal value;
    private int cantidad;
    private BigDecimal monto;
    private String facing;
    private int cluster;
    
    public CardDisponiblesVo() {
	super();
    }
    
    public CardDisponiblesVo(short denom, BigDecimal value, int cantidad, BigDecimal monto, String facing, int cluster) {
	super();
	this.denom = denom;
	this.value = value;
	this.cantidad = cantidad;
	this.monto = monto;
	this.facing=facing;
	this.cluster=cluster;
    }
    
    public CardDisponiblesVo(BigDecimal value, int cantidad, BigDecimal monto) {
    	super();
    	this.value = value;
    	this.cantidad = cantidad;
    	this.monto = monto;
    }
    
    public String printCardDisponiblesVo(){
    	return new String("CardDisponiblesVo: Denom: " + this.denom +" Value: " + this.value +" Cantidad: " + this.cantidad +" Monto: " + this.monto +" Facing: " + this.facing+" Cluster: " + this.cluster);
    }
    
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public short getDenom() {
        return denom;
    }
    public void setDenom(short denom) {
        this.denom = denom;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public int getCluster() {
		return cluster;
	}

	public void setCluster(int cluster) {
		this.cluster = cluster;
	}
    
    
}
