package com.danco.gloomezis.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
	
	//проверка на существование записи в базе данных
	public static Boolean studentExists(String login) {
	Session session =
	ConnectionFactoryHibernate.getOrInitSession();
	Student _student = null;
	try {
	// создание запроса к Ѕƒ
	Query query =
	session.createQuery(
	"from Student a where a.login = :login");
	query.setParameter("login", login);
	/*этот метод позвол€ет получать уникальные результаты. Ќеобходимо обеспе-
	чить уникальность результатов на уровне Ѕƒ, если используетс€ данна€ функци€ */
	_student = (Student) query.uniqueResult();
	} catch (HibernateException e) {
	e.printStackTrace();
	ConnectionFactoryHibernate.destroy();
	} finally {
	if (session != null) {
	try {
	session.close();
	} catch (HibernateException e) {
	e.printStackTrace();
	ConnectionFactoryHibernate.destroy();
	}
	}
	}
	if (_student != null) {
	return new Boolean(true);
	} else {
	return null;
	}
	}
	public static Student getStudent(String login,
	String password) {
	Session session =
	ConnectionFactoryHibernate.getOrInitSession();
	Student _student = null;
	try {
	Query query =
	session.createQuery(
	"from Student a where a.login = :login");
	query.setParameter("login", login);
	_student = (Student) query.uniqueResult();
	} catch (HibernateException e) {
	e.printStackTrace();
	ConnectionFactoryHibernate.destroy();
	} finally {
	if (session != null) {
	try {
	session.close();
	} catch (HibernateException e) {
	e.printStackTrace();
	ConnectionFactoryHibernate.destroy();
	}
	}
	}
	if (_student != null) {
	if (password.equals(_student.getPassword())) {
	return _student;
	} else
	return null;
	} else
	return null;
	}
	//обновление учетной записи студента
	//дл€ возможности таких обновлений прописывалс€ тег id в mapping
	public static void updateStudent(Student _student) {
	Session session =
	ConnectionFactoryHibernate.getOrInitSession();
	try {
	Transaction tx = null;
	tx = session.beginTransaction();
	session.update(_student);
	tx.commit();
	} catch (HibernateException e) {
	e.printStackTrace();
	tx.rollback();
	ConnectionFactoryHibernate.destroy();
	} finally {
	if (session != null) {
	try {
	session.close();
	} catch (Exception e) {
	e.printStackTrace();
	ConnectionFactoryHibernate.destroy();
	}
	}
	}
	}
	//добавление учетной записи студента
	// в этом случае работает директива native из mapping
	public static Boolean addStudent(Student _student) {
	Session session =
	ConnectionFactoryHibernate.getOrInitSession();
	try {
	Transaction tx = null;
	tx = session.beginTransaction();
	session.save(_student);
	tx.commit();
	} catch (HibernateException e) {
	e.printStackTrace();
	tx.rollback();
	ConnectionFactoryHibernate.destroy();
	return null;
	} finally {
	if (session != null) {
	try {
	session.close();
	} catch (Exception e) {
	e.printStackTrace();
	ConnectionFactoryHibernate.destroy();
	return null;
	}
	}
	}
	return new Boolean(true);
	}
	//удаление учетной записи студента
	public static void deleteStudent(Student _student) {
	Session session =
	ConnectionFactoryHibernate.getOrInitSession();
	try {
	Transaction tx = null;
	tx = session.beginTransaction();
	session.delete(_student);
	tx.commit();
	} catch (HibernateException e) {
	e.printStackTrace();
	tx.rollback();
	ConnectionFactoryHibernate.destroy();
	} finally {
	if (session != null) {
	try {
	session.close();
	} catch (Exception e) {
	e.printStackTrace();
	ConnectionFactoryHibernate.destroy();
	}
	}
	}
	}
	}
	
	

}
