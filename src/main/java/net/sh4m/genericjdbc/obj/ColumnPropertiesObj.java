/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.obj;

import java.util.List;

public class ColumnPropertiesObj {
	private String tableName;
	private String joinType;
	private List<ConditionPropertiesObj> condition;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getJoinType() {
		return joinType;
	}
	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}
	public List<ConditionPropertiesObj> getCondition() {
		return condition;
	}
	public void setCondition(List<ConditionPropertiesObj> condition) {
		this.condition = condition;
	}
	
	
	
}
