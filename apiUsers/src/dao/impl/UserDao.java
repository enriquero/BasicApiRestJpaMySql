package dao.impl;

import java.io.Serializable;

import org.jvnet.hk2.annotations.Service;

import dao.interfaces.CrudDaoInt;

@Service
public class UserDao<T extends Serializable> extends CrudDaoAbst<T> implements CrudDaoInt<T> {

}
