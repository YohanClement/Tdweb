package fr.formation.inti.dao;

import org.springframework.data.repository.CrudRepository;

import fr.formation.inti.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	

}
