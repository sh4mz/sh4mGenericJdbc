/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.repository;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import net.sh4m.genericjdbc.obj.ColumnPropertiesObj;
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
			List<ColumnPropertiesObj> columnPropList, String[] column) {
		String selectSQL = sqlGeneratorService.selectAll(tblProject,columnPropList, column);
		logger.info("selectAll : " + selectSQL);
		List<Map<String, Object>> res = jdbcTemplate.queryForList(selectSQL);
		return res;
	}

}
