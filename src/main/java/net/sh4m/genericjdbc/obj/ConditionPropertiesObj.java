/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.obj;

import java.util.List;

public class ConditionPropertiesObj {
	private String condition;
	private String column1;
	private Object column2orValue;
	private List<String> inListValue;
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	
	public List<String> getInListValue() {
		return inListValue;
	}
	public void setInListValue(List<String> inListValue) {
		this.inListValue = inListValue;
	}
	public Object getColumn2orValue() {
		return column2orValue;
	}
	public void setColumn2orValue(Object column2orValue) {
		this.column2orValue = column2orValue;
	}
	
	
	
}
