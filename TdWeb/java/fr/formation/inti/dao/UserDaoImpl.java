package fr.formation.inti.dao;

import org.hibernate.query.Query;

import fr.formation.inti.entity.User;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	public User findbylog(String Email, String Password) {
		String hql = "from User where Email = :email and Password= :password";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("email", Email);
		query.setParameter("password", Password);
		User user = (User) query.uniqueResult();
		return user;

	}

	public User findbyemail(String Email) {
		String hql = "from User where Email = :email";
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.setParameter("email", Email);
		User user = (User) query.uniqueResult();
		return user;
	}
}
