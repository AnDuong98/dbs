package com.dbsfinal.store.dto.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.dbsfinal.store.dto.UserDTO;
import com.dbsfinal.store.dto.validate.annotation.ValidMatchingPassword;

public class PasswordMatchesValidator
	implements ConstraintValidator<ValidMatchingPassword, Object> {

	@Override
	public void initialize(ValidMatchingPassword constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDTO user = (UserDTO) obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}

}
