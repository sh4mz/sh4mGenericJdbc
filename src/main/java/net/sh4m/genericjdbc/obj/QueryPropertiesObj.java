/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.obj;

import java.util.List;

public class QueryPropertiesObj {
	private String sql;
	private List<Object> parameterList;
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public List<Object> getParameterList() {
		return parameterList;
	}
	public void setParameterList(List<Object> parameterList) {
		this.parameterList = parameterList;
	}
	
	
}
