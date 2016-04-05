package com.danco.util;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactoryHibernate {

	public static long timer = 0;
	public static SessionFactory sessionFactory = null;

	public static void initConnectionFactory() {
		Date dt = new Date();
		timer = dt.getTime();
		try {
			// добавление mapping-файлов в конфигурацию подключения
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// создание подключения к БД
			sessionFactory = cfg.buildSessionFactory();
		} catch (MappingException e) {
			System.err.print(e);
		} catch (HibernateException e) {
			System.err.print(e);
			destroy();
		}
	}

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
			System.err.print(e);
			destroy();
			return null;
		}
	}

	public static void destroy() {
		timer = 0;
		try {
			// необходимо вызывать, т.к. иначе будут утечки памяти
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sessionFactory = null;
	}
}
