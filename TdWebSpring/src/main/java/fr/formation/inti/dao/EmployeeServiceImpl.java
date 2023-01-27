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
	
	public Employee save(Employee entity) {
		Employee emp = dao.save(entity);
		return emp;
	}

	public Optional<Employee> findById(Integer id) {
		Optional<Employee> emp = findById(id);
		return emp;
	}

	public List<Employee> findAll() {
		List<Employee> list = (List<Employee>) dao.findAll();
		return list;
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}


	public void delete(Employee entity) {
		dao.delete(entity);
	}

}