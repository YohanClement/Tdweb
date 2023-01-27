package fr.formation.inti.dao;

import org.springframework.data.repository.CrudRepository;

import fr.formation.inti.entity.Users;

public interface Userdao extends CrudRepository<Users, Integer> {
	
	Users findByemail(String email);

}
