package com.danco.util;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionFactoryHibernate.
 */
public class ConnectionFactoryHibernate {
	
	/** The Constant EXCEPTION. */
	private static final String EXCEPTION = "Exception";
	
	/** The Constant LOG1. */
	private final static Logger LOG1 = Logger
			.getLogger(ConnectionFactoryHibernate.class.getName());

	/** The timer. */
	public static long timer = 0;
	
	/** The session factory. */
	public static SessionFactory sessionFactory = null;

	/**
	 * Inits the connection factory.
	 */
	
	public static void initConnectionFactory() {
		Date dt = new Date();
		timer = dt.getTime();
		try {
			
			
		//	sessionFactory = new Configuration().configure().buildSessionFactory();
			Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             System.out.println("Configuration load");
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
			
			
			
			
			
			
		} catch (MappingException e) {
			LOG1.error(EXCEPTION, e);
		} catch (HibernateException e) {
			LOG1.error(EXCEPTION, e);
			destroy();
		}
	}

	/**
	 * Gets the or init session.
	 *
	 * @return the or init session
	 */
	public static Session getOrInitSession() {
		try {
			Date curDate = new Date();
			long curTime = curDate.getTime();
			long tenminutes = 10 * 60 * 1000;
			if (curTime - timer > tenminutes) {
				destroy();
			} else {
				curDate = new Date();
				timer = curDate.getTime();
			}
			if (sessionFactory == null) {
				initConnectionFactory();
			}
			return sessionFactory.openSession();
		} catch (HibernateException e) {
			LOG1.error(EXCEPTION, e);
			destroy();
			return null;
		}
	}

	/**
	 * Destroy.
	 */
	public static void destroy() {
		timer = 0;
		try {
			sessionFactory.close();
		} catch (Exception e) {
			LOG1.error(EXCEPTION, e);
		}
		sessionFactory = null;
	}
}
