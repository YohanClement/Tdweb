package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entity.User;

public interface UserService {

	User findById(Integer id);
	
	User findbyemail(String email);
	
	User findbylog(String Email, String Password);

	List<User> findAll();

	Integer save(User c);

	void delete(User entiy);

	void deleteById(Integer id);

}
