package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.jvnet.hk2.annotations.Service;

@Service
@RequestScoped
public class DAOUtil {

	private String persistenceUnitName = "TP6"; // nombre en el archivo persistence.xml
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	private EntityManager entityManager = emf.createEntityManager();

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
