/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.sh4m.genericjdbc.obj.ColumnPropertiesObj;
import net.sh4m.genericjdbc.obj.ConditionPropertiesObj;
import net.sh4m.genericjdbc.obj.QueryPropertiesObj;


public interface SqlGeneratorService {

	/**
	 * @param tblProject
	 * @return
	 */
	String selectAll(String tblProject);

	/**
	 * @param tblProject
	 * @param column
	 * @return
	 */
	String selectAll(String tblProject, String[] column);

	/**
	 * @param tblProject
	 * @param columnPropList
	 * @param column
	 * @param whereConditionList 
	 * @return
	 */
	QueryPropertiesObj selectAll(String tblProject, List<ColumnPropertiesObj> columnPropList, String[] column, List<ConditionPropertiesObj> whereConditionList);

	
    
}
