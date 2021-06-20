package conf;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

import dao.impl.UserDao;
import dao.interfaces.CrudDaoInt;

public class MyApplicationBinder extends AbstractBinder {
	@Override
	protected void configure() {

		bind(UserDao.class).to(CrudDaoInt.class).in(RequestScoped.class);
	}
}
