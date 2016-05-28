package ve.com.plasmodium.model.vo;

import java.io.Serializable;
import java.util.ArrayList;


public class ReportFieldsVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> fields = new ArrayList<String>();

	public ReportFieldsVo() {

	}

	public void setField(int field, String content) {
		fields.add(field, content);
	}
	
	public String getField(int index){
		return fields.get(index);
	}
	

}
