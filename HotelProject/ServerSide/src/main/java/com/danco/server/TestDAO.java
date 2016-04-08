package com.danco.server;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.danco.dao.api.IGuestDAO;
import com.danco.gloomezis.dependencyInjection.DependencyInjectionManager;
import com.danco.model.Guest;

public class TestDAO {


public static void main(String[] args) {
	 final String LOGER_PROPERTY_FILE_PATH = "log4j.properties";
	 PropertyConfigurator.configure(LOGER_PROPERTY_FILE_PATH);
	
		/*
	 SessionFactory sessionFactory = cfg.buildSessionFactory();
	 Session session = sessionFactory.openSession();
	 */
	 
	 SessionFactory sessionFactory=null;
		try {
			 Configuration configuration = new Configuration().configure();
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	             System.out.println("Configuration load");
	            // builds a session factory from the service registry
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
	            System.out.println("Session factory create");
		} catch (Throwable e) {
			 System.out.println("Initial SessionFactory creation failed. :" + e);
			
	            throw new ExceptionInInitializerError(e);
		}		
		
	Session session = sessionFactory.openSession();
	 
	 
	 IGuestDAO guestDAO = (IGuestDAO) DependencyInjectionManager
	.getClassInstance(IGuestDAO.class);
	 
	 
	Guest g = new Guest("Vika");
	try {
		guestDAO.create(session, g);
		System.out.println("Operation complite");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
