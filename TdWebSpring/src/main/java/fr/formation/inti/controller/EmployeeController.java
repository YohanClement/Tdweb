package fr.formation.inti.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
	private Validator stringValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(stringValidator);
	}

	/**
	 * SERVLET TO REDIRECTY WITH THE LIST OF EMPLOYEE
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/employee")
	public String showemp(Model model) {
		logger.info("charging all employees");
		List<Employee> emps = employeeservice.findAll();
		model.addAttribute("emps", emps);
		return "employee";
	}

	/**
	 * GET THE emp by using the id and filling the different input in the next form
	 * 
	 * @param model
	 * @param ID
	 * @return
	 */
	@GetMapping("/update")
	public ModelAndView showForm(Model model, @RequestParam("id") Integer ID) {
		
		logger.info("updating");
		Employee e = employeeservice.findById(ID).get();
		return new ModelAndView("update", "emp", e);
	}

	/**
	 * updating employee or redirecting to the form if errors occured
	 * 
	 * @param employee
	 * @param br
	 * @param id
	 * @return
	 */
	@PostMapping("/update")
	public String submit(Model model, @Validated @ModelAttribute("emp") Employee employee, BindingResult br) {

		if (br.hasErrors()) {
//			model.addAttribute("startDate", employee.getStartDate());
			model.addAttribute("emp", employee);
			logger.info("field not field correctly");
			return "update";

		}

		Employee emp = employeeservice.findById(employee.getEmpId()).get();

		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setTitle(employee.getTitle());
		emp.setStartDate(employee.getStartDate());

		employeeservice.save(emp);
		logger.info("Update executed");
		return "redirect:/employee";
	}

	/**
	 * deleting the user after confirmation on page
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public String supress(@RequestParam("id") Integer id) {
		employeeservice.deleteById(id);
		logger.info("deletion completed");
		return "redirect:/employee";
	}

	/**
	 * sent to add form
	 * 
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView showForm() {
		logger.info("New user being registered");
		return new ModelAndView("add", "emp", new Employee());
	}

	/**
	 * registering a new entry to database or redirect to form if fields contains errors
	 * @param emp
	 * @param br
	 * @return
	 */
	@PostMapping("/add")
	public String ajout(Model model,@Validated @ModelAttribute("emp") Employee emp, BindingResult br) {
		if (br.hasErrors()) {
			model.addAttribute("emp", emp);
			logger.info("incorrect values input");
			return "add";
		}
		employeeservice.save(emp);
		logger.info("New employee in database");
		return "redirect:/employee";
	}

}
