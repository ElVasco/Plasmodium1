package ve.com.plasmodium.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wsadmin
 */

public class RouteStatusVo implements Serializable {
   
	private static final long serialVersionUID = 1L;

	private short company;
	private short distributer;
	private short route;
    private short status;
    private List<StatusCardsVo> statusTotalList;
    public static final short INACTIVE = 0;
    public static final short ACTIVE = 1;
    public static final short INCOSISTENT = 2;
    public static final short UNKNOWN = 3;
    
    public RouteStatusVo() {
    	resetStatusTotalList();
    }
    
    public RouteStatusVo(short company, short distributer, short route, short status) {
    	this.setCompany(company);
    	this.setDistributer(distributer);
    	this.setRoute(route);
    	this.setStatus(status);
    	resetStatusTotalList();
    }

    public RouteStatusVo(short company, short distributer, short route, short status, List<StatusCardsVo> statusTotalList) {
    	this.setCompany(company);
    	this.setDistributer(distributer);
    	this.setRoute(route);
    	this.setStatus(status);
    	resetStatusTotalList();
    	this.statusTotalList.addAll(statusTotalList);
    }

	public short getCompany() {
		return company;
	}

	public void setCompany(short company) {
		this.company = company;
	}

	public short getDistributer() {
		return distributer;
	}

	public void setDistributer(short distributer) {
		this.distributer = distributer;
	}

	public short getRoute() {
		return route;
	}

	public void setRoute(short route) {
		this.route = route;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public List<StatusCardsVo> getStatusTotalList() {
		return statusTotalList;
	}

	public void setStatusTotalList(List<StatusCardsVo> statusTotalList) {
		resetStatusTotalList();
		if (statusTotalList!=null){
			this.statusTotalList.addAll(statusTotalList);
		}
	}
	
	public void resetStatusTotalList(){
		if(statusTotalList==null){
			statusTotalList  =  new ArrayList<StatusCardsVo>();
		}else{
			statusTotalList.clear();
		}
	}
	
	public int getStatusTotal(short status) {
		int result = -1;
		for(int i=0; i<statusTotalList.size(); i++){
			StatusCardsVo item = statusTotalList.get(i);
			if(status==item.getStatus()){
				result = item.getTotalCards();
				break;
			}
		}
		return result;
	}
	
	public void addStatusTotal(short status) {
		int i;
		StatusCardsVo item;
		for(i=0; i<statusTotalList.size(); i++){
			item = statusTotalList.get(i);
			if(status==item.getStatus()){
				item.setTotalCards(item.getTotalCards()+1);
				break;
			}
		}if(i==statusTotalList.size()){
			item = new StatusCardsVo(status, 1);
			statusTotalList.add(item);
		}
	}
	
	public void updateStatusTotal(short status, int totalCards) {
		for(int i=0; i<statusTotalList.size(); i++){
			StatusCardsVo item = statusTotalList.get(i);
			if(status==item.getStatus()){
				item.setTotalCards(totalCards);
				break;
			}
		}
	}
	
	public boolean hasStatusTotal(){
		return statusTotalList.size()>0;
	}
   
}
