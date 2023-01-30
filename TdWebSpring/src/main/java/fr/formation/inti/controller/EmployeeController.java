package fr.formation.inti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        binder.setValidator(validator);
    }

	@GetMapping("/employee")
	public String showemp(Model model) {
		List<Employee> emps = employeeservice.findAll();
		model.addAttribute("emps", emps);
		return "employee";
	}

	@GetMapping("/update")
	public String update(Model model, @RequestParam("id") Integer ID) {

		Employee e = employeeservice.findById(ID).get();
		model.addAttribute("emp", e);
		return "update";
	}

	@PostMapping("/update")
	public String submit(@ModelAttribute("emp") Employee employee, @RequestParam("id") Integer id, BindingResult br) {
		// model attribute must be equal to the one in get method
//		if (br.hasErrors()) {
//			return "zodiac";
//		}
		
		Employee emp = employeeservice.findById(id).get();
		System.out.println("ouiiiiii");

		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setTitle(employee.getTitle());
		emp.setStartDate(employee.getStartDate());
		System.out.println(emp.toString());

		employeeservice.save(emp);

		System.out.println("Saved");
		return "redirect:/employee";
	}

	@GetMapping("/delete")
	public String supress(@RequestParam("id") Integer id) {
		employeeservice.deleteById(id);
		return "redirect:/employee";
	}

	@GetMapping("/add")
	public ModelAndView showForm() {
		return new ModelAndView("add", "employee", new Employee());
	}

	@PostMapping("/add")
	public String ajout(@ModelAttribute("emp") Employee employee, BindingResult result) {
		Employee emp = new Employee();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setTitle(employee.getTitle());
		emp.setStartDate(employee.getStartDate());

		employeeservice.save(emp);
//		employeeservice.save(employee);
		return "employee";
	}

}
