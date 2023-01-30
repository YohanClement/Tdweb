package fr.formation.inti.dao;

import java.util.List;
import java.util.Optional;

import fr.formation.inti.entity.Employee;

public interface EmployeeService {
	
	
	Employee save(Employee emp);

	List<Employee> findAll();

	void deleteById(Integer id);

	Optional<Employee> findById(Integer id);

}