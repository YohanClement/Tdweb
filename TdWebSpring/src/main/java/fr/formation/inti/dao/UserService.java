package fr.formation.inti.dao;

import java.util.List;
import java.util.Optional;

import fr.formation.inti.entity.Users;

public interface UserService {
	
	Optional<Users> findById(Integer id);
	
	List<Users> findAll();
	
	Users save(Users user);

	void deleteById(Integer id);

	void delete(Users entity);

	Users findByemail(String email);

}
