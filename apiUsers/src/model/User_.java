package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-06-20T19:59:26.198-0300")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Integer> age;
}
