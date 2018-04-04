package net.sh4m.genericjdbc.repository;


import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GenericJdbcRepository<T, ID extends Serializable> extends
		CrudRepository<T, ID> {

	
}
