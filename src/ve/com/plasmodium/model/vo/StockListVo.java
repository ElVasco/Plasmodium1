package ve.com.plasmodium.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class StockListVo implements Serializable{

	public static final Logger logger = Logger.getLogger(StockListVo.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1327443033215389796L;
	private short distributer;
	private List<CardDisponiblesVo> stockDetailList;
	
	
	public StockListVo() {
	}

	public StockListVo(short distributer, List<CardDisponiblesVo> stockDetailList){
		this.distributer=distributer;
		resetStockDetailList();
		this.stockDetailList.addAll(stockDetailList);
	}	

	private void resetStockDetailList() {
		if(stockDetailList==null){
			stockDetailList  =  new ArrayList<CardDisponiblesVo>();
		}else{
			stockDetailList.clear();
		}
	}

	public List<CardDisponiblesVo> getStockDetailList() {
		return stockDetailList;
	}

	public void setStockDetailList(List<CardDisponiblesVo> stockDetailList) {
		this.stockDetailList = stockDetailList;
	}

	public short getDistributer() {
		return distributer;
	}

	public void setDistributer(short distributer) {
		this.distributer = distributer;
	}
	
	public List<Integer> getDenomStockIndex( short denom){
		List<Integer> index= new ArrayList<Integer>();
		for(int e=0; e<this.stockDetailList.size(); e ++){
			if(this.stockDetailList.get(e).getDenom()==denom)
				index.add(e);
		}
		return index;
	}

}