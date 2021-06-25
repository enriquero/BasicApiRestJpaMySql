package dao.interfaces;

import java.io.Serializable;
import java.util.List;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface CrudDaoInt<T extends Serializable> {

	void create(final T entity); // C

	T get(final Long id); // R
	
	void update(final T entity); // U

	void delete(final T entity); // D
	
	List<T> findAll(); // List
	
	void setClazz(Class<T> clazzToSet);
}