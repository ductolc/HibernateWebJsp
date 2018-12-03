package dao;

import org.hibernate.SessionFactory;

import ulti.HibernateUtil;

public class GenericDao {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public static SessionFactory getFactory() {
		return factory;
	}
}
