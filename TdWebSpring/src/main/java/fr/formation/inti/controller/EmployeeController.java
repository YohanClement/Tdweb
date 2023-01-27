package fr.formation.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.inti.dao.EmployeeService;
import fr.formation.inti.entity.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/employee")
	public String showemp(Model model) {
		List<Employee> emps = employeeservice.findAll();
		model.addAttribute("emps", emps);
		return "employee";
	}
}
