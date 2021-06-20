package dao.interfaces;

import java.util.List;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface CrudDaoInt {

	<T> void create(T entity); // C

	<T> T get(Class<T> entityClass, Long id); // R

	<T> void update(T entity); // U

	<T> void delete(T entity); // D

	<T> List<T> getAll(Class<T> entityClass); // List
}