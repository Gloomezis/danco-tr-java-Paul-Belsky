package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IUserDAO;
import com.danco.model.User;

@Repository
public class UserDAO extends BaseDAO<User> implements IUserDAO {

	public UserDAO() {
		super(User.class);
		System.out.println("user dao created");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchByName(String name) {
		Criteria criteria = sf.getCurrentSession().createCriteria(User.class);
		List<User> userList = (List<User>) criteria
				.createCriteria("userDetails", JoinType.RIGHT_OUTER_JOIN)
				.add(Restrictions.like("userDetails.firstName", "%" + name
						+ "%")).list();
		return userList;
	}

	public boolean addFriend(long id1, long id2) {
		// TODO Auto-generated method stub

		int i;
		String hql = "select E.Friend_ID from PERSON_FRIEND E where E.Person_ID=id1";
		Query query = sf.getCurrentSession().createQuery(hql);
		List list = query.list();

		for (i = 0; i < list.size(); i++) {
			if (id2 == ((Long) list.get(i)).longValue()) {
				return false;
			}
		}

		User p1, p2;
		Query q = sf.getCurrentSession().createQuery(
				"from Person as E where E.id=id1");
		List l1 = q.list();

		Query q2 = sf.getCurrentSession().createQuery(
				"from Person as E where E.id=id2");
		List l2 = q2.list();

		p1 = (User) (l1.get(0));
		p2 = (User) (l2.get(0));

		p1.getFriends().add(p2);

		sf.getCurrentSession().save(p1);
		return true;
	}

	public boolean removeFriend(long id1, long id2) {
		// TODO Auto-generated method stub

		int i;
		String hql = "select E.Friend_ID from PERSON_FRIEND E where E.Person_ID=id1";
		Query query = sf.getCurrentSession().createQuery(hql);
		List list = query.list();

		int flag = 0;
		for (i = 0; i < list.size(); i++) {
			if (id2 == ((Long) list.get(i)).longValue()) {
				flag = 1;
			}
		}

		if (flag != 1) {
			return false;
		} else {
			User p1, p2;
			Query q = sf.getCurrentSession().createQuery(
					"from Person as E where E.id=id1");
			List l1 = q.list();

			Query q2 = sf.getCurrentSession().createQuery(
					"from Person as E where E.id=id2");
			List l2 = q2.list();

			p1 = (User) (l1.get(0));
			p2 = (User) (l2.get(0));

			p1.getFriends().remove(p2);

			sf.getCurrentSession().save(p1);
			return true;
		}

	}
	
	@Override
	public User gerByCredentials(String username, String password) throws Exception {

		Criteria cr = sf.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password));
		User u=(User) cr.uniqueResult();
		System.out.println("Getting user:"+u.getId() +" "+u.getUsername());
				
		return u;

	}

	@Override
	public User getByUsername(String username) throws Exception {
		Criteria cr = sf.getCurrentSession().createCriteria(User.class);
		User user = (User) cr
				.add(Restrictions.eq("username", username)).uniqueResult();
		

		return user;
	}

}
