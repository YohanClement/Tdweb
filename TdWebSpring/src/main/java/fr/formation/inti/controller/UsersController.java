package fr.formation.inti.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.dao.UserService;
import fr.formation.inti.entity.Users;

@Controller
public class UsersController {
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	UserService userservice;

	@Autowired
	private Validator userValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	
	@GetMapping("/adduser")
	public ModelAndView createForm() {
		logger.debug("New user being registered");
		return new ModelAndView("adduser", "user", new Users());
	}

	@PostMapping("/adduser")
	public String ajoutuser(@Validated @ModelAttribute("user") Users user, BindingResult br) {
		if (br.hasErrors()) {
			logger.info("incorrect values input");
			return "adduser";
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String Encrypt = encoder.encode(user.getPassword());
		user.setPassword(Encrypt);
		user.setDroit("user");
		userservice.save(user);
		logger.info("New user created");
		return "redirect:/welcome";
	}

}
