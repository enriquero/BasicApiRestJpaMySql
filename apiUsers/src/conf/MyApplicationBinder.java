package conf;

import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

import dao.impl.DAOUtil;
import dao.impl.UserDao;
import dao.interfaces.CrudDaoInt;
import model.User;

public class MyApplicationBinder extends AbstractBinder {
	@Override
	protected void configure() {
		
		bind(DAOUtil.class).to(DAOUtil.class);
		//bind(UserDao.class).to(CrudDaoInt.class).in(RequestScoped.class);
		// para usar genericos...
		bind(UserDao.class).to(new TypeLiteral<CrudDaoInt<User>>() {}).in(RequestScoped.class);

		//.to(new TypeLiteral<IProcessor<SomeType1, SomeType2>>(){})
		//.to(new GenericType<IProcessor<SomeType1, SomeType2>>(){})
	}
}
