package dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public abstract class CrudDaoAbst<T extends Serializable> {

	@Inject
	private DAOUtil daoUtil;
	private Class<T> clazz;
	private EntityManager entityManager;

	@PostConstruct
	public void postContruct() {
		entityManager = daoUtil.getEntityManager();
	}

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public void create(T entity) {
		EntityTransaction etx = entityManager.getTransaction();
		etx.begin();
		entityManager.persist(entity);
		etx.commit();
	}

	public T get(Long id) {
		return entityManager.find(clazz, id);
	}

	public void update(T entity) {
		EntityTransaction etx = entityManager.getTransaction();
		etx.begin();
		entityManager.refresh(entity);
		etx.commit();
	}

	public void delete(T entity) {
		EntityTransaction etx = entityManager.getTransaction();
		etx.begin();
		entityManager.remove(entity);
		etx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}
}
