/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import net.sh4m.genericjdbc.obj.ColumnPropertiesObj;

public interface Sh4mGenericJdbcRepository {

	/**
	 * @param jdbcTemplate
	 * @param mainTableName
	 * @return
	 */
	List<Map<String, Object>> selectAll(JdbcTemplate jdbcTemplate, String mainTableName);

	/**
	 * @param jdbcTemplate
	 * @param tblProject
	 * @param column
	 * @return
	 */
	List<Map<String, Object>> selectAll(JdbcTemplate jdbcTemplate, String tblProject, String[] column);

	/**
	 * @param jdbcTemplate
	 * @param tblProject
	 * @param columnPropList
	 * @param column
	 * @return
	 */
	List<Map<String, Object>> selectAll(JdbcTemplate jdbcTemplate, String tblProject,
			List<ColumnPropertiesObj> columnPropList, String[] column);

}
