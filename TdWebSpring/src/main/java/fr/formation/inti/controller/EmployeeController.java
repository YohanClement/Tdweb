package fr.formation.inti.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.dao.EmployeeService;
import fr.formation.inti.entity.Employee;

@Controller
public class EmployeeController {
	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeservice;

	@Autowired
	@Qualifier("stringValidator") // nom du validator
	private Validator validator;

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@GetMapping("/employee")
	public String showemp(Model model) {
		logger.info("charging all employees");
		List<Employee> emps = employeeservice.findAll();
		model.addAttribute("emps", emps);
		return "employee";
	}

	@GetMapping("/update")
	public String update(Model model, @RequestParam("id") Integer ID) {
		logger.info("updating");
		Employee e = employeeservice.findById(ID).get();
		model.addAttribute("emp", e);
		return "update";
	}

	@PostMapping("/update")
	public String submit(@Validated @ModelAttribute("emp") Employee employee, BindingResult br,
			@RequestParam("empId") Integer id) {

		if (br.hasErrors()) {
			logger.info("field not field correctly");
			return "update";
			
		}
		
		Employee emp = employeeservice.findById(id).get();

		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setTitle(employee.getTitle());
		emp.setStartDate(employee.getStartDate());
	
		employeeservice.save(emp);
		logger.info("Update executed");
		return "redirect:/employee";
	}

	@GetMapping("/delete")
	public String supress(@RequestParam("id") Integer id) {
		employeeservice.deleteById(id);
		logger.info("deletion completed");
		return "redirect:/employee";
	}

	@GetMapping("/add")
	public ModelAndView showForm() {
		logger.debug("New employee being registered");
		return new ModelAndView("add", "employee", new Employee());
	}

	@PostMapping("/add")
	public String ajout(@Validated @ModelAttribute("emp") Employee emp, BindingResult br) {
		if (br.hasErrors()) {
			logger.info("incorrect values input");
			return "add";
		}
		employeeservice.save(emp);
		logger.info("New employee in database");
		return "redirect:/employee";
	}

}
