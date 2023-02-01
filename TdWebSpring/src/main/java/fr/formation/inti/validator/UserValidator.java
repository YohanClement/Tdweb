package fr.formation.inti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entity.Users;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Users.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rolename", "title.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		
		Users emp = (Users) target;
		int max_lenght = 20;
		if(emp.getFirstname().length()>max_lenght) {
			errors.rejectValue("firstname", "lenght");
		}
		
		if(emp.getLastname().length()>max_lenght) {
			errors.rejectValue("lastname", "lenght");
		}
		
		if(emp.getRolename().length()>max_lenght) {
			errors.rejectValue("rolename", "lenght");
		}
	

	}

}