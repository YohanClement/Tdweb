package fr.formation.inti.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.entity.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	/**
	 * save employee in data base
	 */
	public Employee save(Employee entity) {
		Employee emp = dao.saveAndFlush(entity);
		return emp;
	}
	/**
	 * read an employee in data base
	 */
	public Optional<Employee> findById(Integer id) {
		Optional<Employee> emp = dao.findById(id);
		return emp;
	}
	/**
	 * get the list of all employees
	 */
	public List<Employee> findAll() {
		List<Employee> list = (List<Employee>) dao.findAll();
		return list;
	}
	/**
	 * delete a specific employee
	 */
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
