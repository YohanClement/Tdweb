package fr.formation.inti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.dao.EmployeeService;
import fr.formation.inti.entity.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
//	@Autowired
//	@Qualifier("stringValidator") // nom du validator
//	private Validator validator;
//
//	public Validator getValidator() {
//		return validator;
//	}
//
//	public void setValidator(Validator validator) {
//		this.validator = validator;
//	}
	

	@ModelAttribute("emp")
	public Employee createEmpleeModel() {
		return new Employee();
	}

//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/employee")
	public String showemp(Model model) {
		List<Employee> emps = employeeservice.findAll();
		model.addAttribute("emps", emps);
		return "employee";
	}
	
	
	@GetMapping("/update")
	public String update(Model model, @RequestParam("id") Integer ID) {

		Optional<Employee> e =employeeservice.findById(ID);
		Employee E =e.get();
		model.addAttribute("emp", E);
		return "update";
	}
	
	@PostMapping("/update")
	public String submit(@ModelAttribute("emp") Employee employee, Model model) { 
		// model attribute must be equal to the one in get method
//		if (br.hasErrors()) {
//			return "zodiac";
//		}
		
		employeeservice.save(employee);
		model.addAttribute("firstname", employee.getFirstName());
		model.addAttribute("lastname", employee.getLastName());
		model.addAttribute("title", employee.getTitle());
		model.addAttribute("startdate", employee.getStartDate());

		return showemp(model);
	}
	
	@GetMapping("/delete")
	public String supress(Model model, @RequestParam("id") Integer id) {
		employeeservice.deleteById(id);
		return "/employee";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
		
	}
}
