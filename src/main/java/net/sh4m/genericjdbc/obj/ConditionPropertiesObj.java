/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.obj;

import java.util.List;

import net.sh4m.genericjdbc.ConditionEnum;
import net.sh4m.genericjdbc.OperatorEnum;

public class ConditionPropertiesObj {
	private ConditionEnum condition;
	private OperatorEnum operator;
	private String column1;
	private Object column2orValue;
	private List<Object> inListValue;
	
	
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	
	public Object getColumn2orValue() {
		return column2orValue;
	}
	public void setColumn2orValue(Object column2orValue) {
		this.column2orValue = column2orValue;
	}
	public ConditionEnum getCondition() {
		return condition;
	}
	public void setCondition(ConditionEnum condition) {
		this.condition = condition;
	}
	public OperatorEnum getOperator() {
		return operator;
	}
	public void setOperator(OperatorEnum operator) {
		this.operator = operator;
	}
	public List<Object> getInListValue() {
		return inListValue;
	}
	public void setInListValue(List<Object> inListValue) {
		this.inListValue = inListValue;
	}
	
	
	
}
