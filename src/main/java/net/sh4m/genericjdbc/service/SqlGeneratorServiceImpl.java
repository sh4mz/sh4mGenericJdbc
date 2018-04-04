/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import net.sh4m.genericjdbc.obj.ColumnPropertiesObj;
import net.sh4m.genericjdbc.obj.ConditionPropertiesObj;
import net.sh4m.genericjdbc.obj.QueryPropertiesObj;

@Service
public class SqlGeneratorServiceImpl implements SqlGeneratorService {

	public static final String WHERE = " WHERE ";
	public static final String AND = " AND ";
	public static final String OR = " OR ";
	public static final String SELECT = "SELECT ";
	public static final String FROM = "FROM ";
	public static final String DELETE = "DELETE ";
	public static final String UPDATE = "UPDATE ";
	public static final String INSERT_INTO = "INSERT INTO ";
	public static final String COMMA = ", ";
	public static final String PARAM = " = ?";
	public static final String LIKE = " LIKE ?";
	public static final String LIKEHASH = "#LIKE#";
	public static final String STAR = " * ";
	    
	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.service.SqlGeneratorService#selectAll(java.lang.String)
	 */
	public String selectAll(String tblProject) {
		
		return SELECT + STAR + FROM +  tblProject;
	}

	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.service.SqlGeneratorService#selectAll(java.lang.String, java.lang.String[])
	 */
	public String selectAll(String tblProject, String[] column) {
		String colString = String.join(",", column);
		
		String sql = SELECT + " " + colString + " " + FROM +  tblProject;
		return sql;
	}

	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.service.SqlGeneratorService#selectAll(java.lang.String, java.util.List, java.lang.String[])
	 */
	public QueryPropertiesObj selectAll(String tblProject, List<ColumnPropertiesObj> columnPropList, String[] column, List<ConditionPropertiesObj> whereConditionList) {
		QueryPropertiesObj queryObj = new QueryPropertiesObj();
		String colString = String.join(",", column);
		String sql = SELECT + " " + colString + " " + FROM +  tblProject;
		if(columnPropList != null && !columnPropList.isEmpty()){
			
			for(ColumnPropertiesObj eachColProp : columnPropList){
				String colPropSql = "";
				String joinTbl = eachColProp.getTableName();
				String joinType = eachColProp.getJoinType();
				colPropSql = " " + joinType + " " + joinTbl + " ON ";
				if(eachColProp.getCondition() != null && !eachColProp.getCondition().isEmpty()){
					int conditionLoop = 0;
					for(ConditionPropertiesObj eachCondition : eachColProp.getCondition()){
						if(conditionLoop > 0){
							colPropSql += " AND ";
						}
						String condition = eachCondition.getCondition();
						String column1 = eachCondition.getColumn1();
						
						//parameterList.add(eachCondition.getColumn2orValue());
						colPropSql += column1 + " " + condition + " " + eachCondition.getColumn2orValue() ;
						conditionLoop++;
					}
				} else {
					continue;
				}
				
				sql += colPropSql;
			}
			
			
			
		}
		
		if(whereConditionList != null && !whereConditionList.isEmpty()){
			String colPropSql = "";
			List<Object> parameterList = new ArrayList<Object>();
			
			for(ConditionPropertiesObj eachCondition : whereConditionList ){
				if(eachCondition.isAnd()){
					colPropSql += " AND ";
				} else {
					colPropSql += " OR ";
				}
				String condition = eachCondition.getCondition();
				String column1 = eachCondition.getColumn1();
				
				parameterList.add(eachCondition.getColumn2orValue());
				colPropSql += column1 + " " + condition + " ? " ;
				
			}
			queryObj.setParameterList(parameterList);
			sql += colPropSql;
		}
		
		queryObj.setSql(sql);
		return queryObj;
	}

}
