package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.UserDaoImpl;
import fr.formation.inti.entity.User;

public class UserServiceImpl implements UserService {
	UserDaoImpl dao;

	public UserServiceImpl() {
		super();
		this.dao = new UserDaoImpl();
	}

	public User findById(Integer id) {
		dao.beginTransaction();
		User c = dao.findById(id);
		dao.commit(true);
		return c;
	}
	public User findbyemail(String Email) {
		dao.beginTransaction();
		User c = dao.findbyemail(Email);
		dao.commit(true);
		return c;
	}
	public User findbylog(String Email, String Password) {
		dao.beginTransaction();
		User c = dao.findbylog(Email, Password);
		dao.commit(true);
		return c;
	}

	public List<User> findAll() {
		dao.beginTransaction();
		List<User> list = dao.findAll();
		dao.commit(true);
		return list;
	}

	public Integer save(User c) {
		dao.beginTransaction();
		User cust = dao.save(c);

		dao.commit(true);
		return cust.getIduser();
	}

	public void delete(User entiy) {
		dao.beginTransaction();
		dao.delete(entiy);
		dao.commit(true);

	}

	public void deleteById(Integer id) {
		dao.beginTransaction();
		dao.deleteById(id);
		dao.commit(true);
	}
}
