/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import me.woemler.sqlbuilder.ComplexTableDescription;
import me.woemler.sqlbuilder.Condition;
import me.woemler.sqlbuilder.Conditions;
import me.woemler.sqlbuilder.Evaluation;
import me.woemler.sqlbuilder.Conditions.Operation;
import me.woemler.sqlbuilder.SqlBuilder;
import net.sh4m.genericjdbc.ConditionEnum;
import net.sh4m.genericjdbc.OperatorEnum;
import net.sh4m.genericjdbc.constant.ProjectTableConstant;
import net.sh4m.genericjdbc.obj.ColumnPropertiesObj;
import net.sh4m.genericjdbc.obj.ConditionPropertiesObj;
import net.sh4m.genericjdbc.repository.Sh4mGenericJdbcRepository;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private Sh4mGenericJdbcRepository sh4mGenericJdbcRepi;
    
    
	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.service.MainService#selectAllProject()
	 */
	public List<Map<String, Object>> selectAllProject() {
		List<Map<String, Object>> res = null;
		String[] column = {ProjectTableConstant.COL_PROJID,ProjectTableConstant.COL_PROJNAME,ProjectTableConstant.COL_PROJCELL, "TORNADO_CLIENT.CLIENT_NAME"};
		
		
		//res = sh4mGenericJdbcRepi.selectAll(jdbcTemplate,ProjectTableConstant.TBL_PROJECT);
		
		//res = sh4mGenericJdbcRepi.selectAll(jdbcTemplate, ProjectTableConstant.TBL_PROJECT,column);
		List<ColumnPropertiesObj> columnPropList = new ArrayList<ColumnPropertiesObj>();
		ColumnPropertiesObj colProp = new ColumnPropertiesObj();
		colProp.setTableName("TORNADO_LOCATION");
		colProp.setJoinType("JOIN");
		List<ConditionPropertiesObj> conditionPropList = new ArrayList<ConditionPropertiesObj>();
		//join location
		ConditionPropertiesObj conditionProp = new ConditionPropertiesObj();
		conditionProp.setOperator(OperatorEnum.EQ);
		conditionProp.setColumn1("TORNADO_LOCATION.LOCATION_ID");
		conditionProp.setColumn2orValue("TORNADO_PROJECT.FK_LOCATION_ID");
		conditionPropList.add(conditionProp );
		colProp.setCondition(conditionPropList );
		columnPropList.add(colProp);
		
		//join client
		ColumnPropertiesObj colProp2 = new ColumnPropertiesObj();
		colProp2.setTableName("TORNADO_CLIENT");
		colProp2.setJoinType("JOIN");
		List<ConditionPropertiesObj> colProp2conditionProp1List = new ArrayList<ConditionPropertiesObj>();
		ConditionPropertiesObj colProp2ConditionProp = new ConditionPropertiesObj();
		colProp2ConditionProp.setOperator(OperatorEnum.EQ);
		colProp2ConditionProp.setColumn1("TORNADO_CLIENT.CLIENT_ID");
		colProp2ConditionProp.setColumn2orValue("TORNADO_PROJECT.FK_CLIENT_ID");
		colProp2conditionProp1List.add(colProp2ConditionProp );
		colProp2.setCondition(colProp2conditionProp1List );
		
		columnPropList.add(colProp2 );
		
		
		List<ConditionPropertiesObj> whereConditionList = new ArrayList<ConditionPropertiesObj>();
		ConditionPropertiesObj whereCondition1 = new ConditionPropertiesObj();
		whereCondition1.setCondition(ConditionEnum.AND);
		whereCondition1.setOperator(OperatorEnum.EQ);
		whereCondition1.setColumn1("TORNADO_LOCATION.LOCATION_ID");
		whereCondition1.setColumn2orValue(1);
		whereConditionList.add(whereCondition1  );
		
		res = sh4mGenericJdbcRepi.selectAll(jdbcTemplate ,ProjectTableConstant.TBL_PROJECT ,columnPropList ,column,whereConditionList );
		return res;
	}


	/* (non-Javadoc)
	 * @see net.sh4m.genericjdbc.service.MainService#selectTest1()
	 */
	@Override
	public List<Map<String, Object>> selectTest1() {
		String mainTableName = "TORNADO_PROJECT";
//		String[] column = {ProjectTableConstant.COL_PROJID,ProjectTableConstant.COL_PROJNAME,ProjectTableConstant.COL_PROJCELL};
//		List<ColumnPropertiesObj> joinPropList = new ArrayList<ColumnPropertiesObj>();
//		List<ConditionPropertiesObj> wherePropList = new ArrayList<ConditionPropertiesObj>();
//		ConditionPropertiesObj whereCondPropObj = new ConditionPropertiesObj();
//		whereCondPropObj.setColumn1("TORNADO_PROJECT.PROJECT_ID");
//		//whereCondPropObj.setColumn2orValue(Long.valueOf(239));
//		whereCondPropObj.setOperator(OperatorEnum.IN);
//		List<Object> listValue = new ArrayList<Object>();
//		listValue.add("PGCHaircarePri_CN_v004");
//		listValue.add("ProjZDSnack_US_V001");
//		whereCondPropObj.setInListValue(listValue );
//		wherePropList.add(whereCondPropObj);
		List<Map<String, Object>> res = sh4mGenericJdbcRepi.select(jdbcTemplate, mainTableName, null,null,null);
		
		
				    
		return res;
	}

}
