package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jvnet.hk2.annotations.Service;

import dao.interfaces.CrudDaoInt;

@Service
public class UserDao implements CrudDaoInt {

	private EntityManager entityManager;
	private String persistenceUnitName = "TP6"; // nombre en el archivo persistence.xml

	public UserDao() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.entityManager = emf.createEntityManager();
	}

	@Override
	public <T> void create(T entity) {
		EntityTransaction etx = entityManager.getTransaction(); // recupero una transaccion
		etx.begin(); // inicio la transaccion
		entityManager.persist(entity); // persisto la entidad en cuestion
		etx.commit(); // cierro la transaccion
	}

	@Override
	public <T> T get(Class<T> entityClass, Long id) {
		return (T) entityManager.createQuery("from " + entityClass + " e where e.id = :id", entityClass)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public <T> void update(T entity) {
		EntityTransaction etx = entityManager.getTransaction();
		etx.begin();
		entityManager.refresh(entity);
		etx.commit();
	}

	@Override
	public <T> void delete(T entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public <T> List<T> getAll(Class<T> entityClass) {
		return entityManager.createQuery("from " + entityClass.getName(), entityClass).getResultList();
	}

}
