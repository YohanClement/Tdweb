package fr.formation.inti.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	List<Employee> findAll();
	void deleteById(Integer id);
	<S extends Employee> S save(Employee emp);
	Optional<Employee> findById(Integer ID);

}
