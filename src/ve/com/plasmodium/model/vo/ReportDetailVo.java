package ve.com.plasmodium.model.vo;

import java.util.ArrayList;
import java.util.List;


public class ReportDetailVo {

	private List<Boolean> types = new ArrayList<Boolean>();
	private List<String> labels = new ArrayList<String>();
	private List<ReportFieldsVo> fields = new ArrayList<ReportFieldsVo>();

	public ReportDetailVo(){
		
	}
	
	public void copyLabelsAndTypes(ReportDetailVo r) {
		this.labels = r.labels;
		this.types = r.types;
	}

	public int size() {
		return this.fields.size();
	}

	public void addAllToFields(List<ReportFieldsVo> fieldsList) {
		fields.addAll(fieldsList);
	}

	public void addToFields(ReportFieldsVo field) {
		fields.add(field);
	}

	public void removeFromFields(int i) {
		fields.remove(i);		
	}

	public ReportFieldsVo get(int i) {
		return fields.get(i);
	}
	
	public void setField(int i, String content) {
		((ReportFieldsVo) this.fields).setField(i, content);
	}
	
	public void setFieldLabel(int fieldLabel, String content) {
		labels.add(fieldLabel, content);
	}

	public void setFieldType(int fieldType, boolean type) {
		types.add(fieldType, type);
	}


	public List<ReportFieldsVo> getFields() {
		return fields;
	}
	public void setFields(List<ReportFieldsVo> fields) {
		this.fields = fields;
	}
	public void clearFields() {
		this.fields.clear();
	}

	public String getFieldLabel(int i) {
		return labels.get(i);
	}

	public boolean getFieldType(int i) {
		return types.get(i);
	}

	public List<Boolean> getTypes() {
		return types;
	}

	public void setTypes(List<Boolean> types) {
		this.types = types;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
}