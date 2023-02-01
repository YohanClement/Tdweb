package fr.formation.inti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.inti.entity.Employee;

@Component
public class StringValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "startDate.required");
		
		Employee emp = (Employee) target;
		int max_lenght = 20;
		if(emp.getFirstName().length()>max_lenght) {
			errors.rejectValue("firstName", "lenght");
		}
		
		if(emp.getLastName().length()>max_lenght) {
			errors.rejectValue("lastName", "lenght");
		}
		
		if(emp.getTitle().length()>max_lenght) {
			errors.rejectValue("title", "lenght");
		}
	

	}

}