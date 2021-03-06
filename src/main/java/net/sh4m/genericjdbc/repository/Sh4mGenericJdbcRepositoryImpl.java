/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import me.woemler.sqlbuilder.ComplexTableDescription;
import me.woemler.sqlbuilder.Condition;
import me.woemler.sqlbuilder.Conditions;
import me.woemler.sqlbuilder.Evaluation;
import me.woemler.sqlbuilder.SqlBuilder;
import net.sh4m.genericjdbc.obj.ColumnPropertiesObj;
import net.sh4m.genericjdbc.obj.ConditionPropertiesObj;
import net.sh4m.genericjdbc.obj.QueryPropertiesObj;
import net.sh4m.genericjdbc.service.SqlGeneratorService;
@Service
public class Sh4mGenericJdbcRepositoryImpl implements Sh4mGenericJdbcRepository {
	private static final Logger logger = Logger.getLogger(Sh4mGenericJdbcRepositoryImpl.class);
	
	@Autowired
	private SqlGeneratorService sqlGeneratorService;
	
	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.repository.Sh4mGenericJdbcRepository#selectAll(org.springframework.jdbc.core.JdbcTemplate, java.lang.String)
	 */
	public List<Map<String, Object>> selectAll(JdbcTemplate jdbcTemplate, String tblProject) {
		String selectSQL = sqlGeneratorService.selectAll(tblProject);
		
		logger.info("selectAll : " + selectSQL);
		List<Map<String, Object>> res = jdbcTemplate.queryForList(selectSQL);
		
		return res;
	}

	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.repository.Sh4mGenericJdbcRepository#selectAll(org.springframework.jdbc.core.JdbcTemplate, java.lang.String, java.lang.String[])
	 */
	public List<Map<String, Object>> selectAll(JdbcTemplate jdbcTemplate, String tblProject, String[] column) {
		String selectSQL = sqlGeneratorService.selectAll(tblProject,column);
		
		logger.info("selectAll : " + selectSQL);
		List<Map<String, Object>> res = jdbcTemplate.queryForList(selectSQL);
		return res;
	}

	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.repository.Sh4mGenericJdbcRepository#selectAll(org.springframework.jdbc.core.JdbcTemplate, java.lang.String, java.util.List, java.lang.String[])
	 */
	public List<Map<String, Object>> selectAll(JdbcTemplate jdbcTemplate, String tblProject,
			List<ColumnPropertiesObj> columnPropList, String[] column, List<ConditionPropertiesObj> whereConditionList) {
		//String selectSQL = sqlGeneratorService.selectAll(tblProject,columnPropList, column);
		QueryPropertiesObj queryProp = sqlGeneratorService.selectAll(tblProject,columnPropList, column, whereConditionList);
		logger.info("selectAll : " + queryProp.getSql());
		
		List<Map<String, Object>> res = null;
		if(queryProp.getParameterList() != null && !queryProp.getParameterList().isEmpty()){
			for(Object eachVal : queryProp.getParameterList()){
				logger.info("parameter : " + eachVal);
			}
			
			res = jdbcTemplate.queryForList(queryProp.getSql(),queryProp.getParameterList().toArray());
		} else {
			res = jdbcTemplate.queryForList(queryProp.getSql());
		}
		
		
		
		
		return res;
	}

	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.repository.Sh4mGenericJdbcRepository#select(org.springframework.jdbc.core.JdbcTemplate, java.lang.String, java.util.List, java.lang.String[], java.util.List)
	 */
	@Override
	public List<Map<String, Object>> select(JdbcTemplate jdbcTemplate, String mainTableName,
			List<ColumnPropertiesObj> joinPropList, String[] column, List<ConditionPropertiesObj> wherePropList) {
		//QueryPropertiesObj queryProp = sqlGeneratorService.selectAll(mainTableName,joinPropList, column, wherePropList);
		//logger.info("selectAll : " + queryProp.getSql());
		
		List<Map<String, Object>> res = null;
//		if(queryProp.getParameterList() != null && !queryProp.getParameterList().isEmpty()){
//			for(Object eachVal : queryProp.getParameterList()){
//				logger.info("parameter : " + eachVal);
//			}
//			
//			res = jdbcTemplate.queryForList(queryProp.getSql(),queryProp.getParameterList().toArray());
//		} else {
//			res = jdbcTemplate.queryForList(queryProp.getSql());
//		}
		
		
		ComplexTableDescription tableDescription = new ComplexTableDescription("TORNADO_PROJECT");
		SqlBuilder sqlBuilder = new SqlBuilder(tableDescription);
		List<Object> listValue = new ArrayList<Object>();
		listValue.add("PGCHaircarePri_CN_v004");
		listValue.add("ProjZDSnack_US_V001");
		Condition condition = new Condition("PROJECT_NAME", listValue, Evaluation.EQUALS);
		
		//Conditions conditions = new Conditions
		String sql = sqlBuilder.select("*").where(condition).toSql();
		res = jdbcTemplate.queryForList(sql);
		
		
		return res;
	}

}
