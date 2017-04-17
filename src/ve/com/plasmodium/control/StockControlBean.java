package ve.com.plasmodium.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ve.com.plasmodium.model.vo.RouteStatusVo;
import ve.com.plasmodium.model.vo.StatusCardsVo;
import ve.com.plasmodium.model.vo.StockListVo;


@ManagedBean(name="StockControlBean")
@SessionScoped
public class StockControlBean {

	public static final Logger logger = Logger.getLogger(StockControlBean.class);
	private List<RouteStatusVo> routeControlList;
	private List<StockListVo> stockList;

	public StockControlBean(){
		resetRouteControlList();
		resetStockList();
	}

	/**
	 * Retorna el indice en la lista stockList para el distribuidor dado
	 * @param distributer
	 * @return
	 */
	public int getStockIndex(short distributer){
		int index=-1;
		for(int i=0; i<this.stockList.size(); i++){
			if(this.stockList.get(i).getDistributer()==distributer){
				index=i;
				i=this.stockList.size();
			}
		}
		return index;
	}

	public void addToStockList(StockListVo element) {
		stockList.add(element);
	}

	public List<RouteStatusVo> getRouteControlList() {
		return routeControlList;
	}

	public void setRouteControlList(List<RouteStatusVo> routeControlList) {
		this.routeControlList = routeControlList;
	}

	public void resetRouteControlList(){
		if(routeControlList==null){
			routeControlList  =  new ArrayList<RouteStatusVo>();
		}else{
			routeControlList.clear();
		}
	}

	public List<StockListVo> getStockList() {
		return stockList;
	}

	public void setStockList(List<StockListVo> stockList) {
		this.stockList = stockList;
	}

	public void resetStockList(){
		if(stockList==null){
			stockList  =  new ArrayList<StockListVo>();
		}else{
			stockList.clear();
		}
	}

	public short getRouteStatus(short company, short distributer, short route) {
		short result = RouteStatusVo.UNKNOWN;
		for(int i=0; i<routeControlList.size(); i++){
			RouteStatusVo item = routeControlList.get(i);
			if(company==item.getCompany() && distributer==item.getDistributer() && route==item.getRoute()){
				result = item.getStatus();
				break;
			}
		}
		return result;
	}

	public RouteStatusVo getRouteStatusVo(Short company, Short distributer,short route) {
		RouteStatusVo result = null;
		for(int i=0; i<routeControlList.size(); i++){
			RouteStatusVo item = routeControlList.get(i);
			if(company==item.getCompany() && distributer==item.getDistributer() && route==item.getRoute()){
				result = item;
				break;
			}
		}
		return result;
	}

	public void addRoutestatus(RouteStatusVo routeStatusVo) {
		routeControlList.add(routeStatusVo);		
	}

	public void updateRouteStatus(short company, short distributer, short route, short status, List<StatusCardsVo> statusCardsVoList) {
		RouteStatusVo item;
		int i;
		for(i=0; i<routeControlList.size(); i++){
			item = routeControlList.get(i);
			if(company==item.getCompany() && distributer==item.getDistributer() && route==item.getRoute()){
				item.setStatus(status);
				item.setStatusTotalList(statusCardsVoList);
				break;
			}
		}
		if(i==routeControlList.size()){
			item = new RouteStatusVo(company,distributer,route,status,statusCardsVoList);
			routeControlList.add(item);
		}
	}

}