package ve.com.plasmodium.model.vo;

import java.math.BigDecimal;

public class DispoVo {
    
    private short denom;
    private BigDecimal value;
    
    public DispoVo(short denom, BigDecimal value) {
	super();
	this.denom = denom;
	this.value = value;
    }
    public short getDenom() {
        return denom;
    }
    public void setDenom(short denom) {
        this.denom = denom;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
