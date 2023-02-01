package fr.formation.inti.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.inti.dao.UserService;

@Controller
public class MainController {
	private static final Logger logger = Logger.getLogger(MainController.class);
	@Autowired
	UserService userservice;

	@GetMapping(value = { "/", "/welcome" })
	public String welcomePage(Model model) {

		logger.info("getWelcome is executed!");

		model.addAttribute("title", "Welcome");
		return "welcomePage";

	}

	@GetMapping(value = "/admin")
	public String adminPage(Model model) {
		logger.info("admin access");
		return "adminPage";
	}

	@GetMapping(value = "/login")
	public String loginPage(Model model) {
		logger.info("connection in progress");
		return "loginPage";
	}

	@GetMapping(value = "/logoutSuccessful")
	public String logoutSuccessfulPage(Model model) {
		logger.info("logout");
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@GetMapping(value = "/userInfo")
	public String userInfo(Model model, Principal principal) {
		logger.info("succesful access");
		// After user login successfully.
		String userName = principal.getName();

		model.addAttribute("message", userName + "<br>");

		return "userInfoPage";
	}

	@GetMapping(value = "/403")
	public String accessDenied(Model model, Principal principal) {
		logger.info("access denied");
		if (principal != null) {
			model.addAttribute("message", principal.getName() + "<br> ");
		} else {
			
		}
		return "403Page";
	}

}
