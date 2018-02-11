package com.luopc.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyUserConstraintValidator implements ConstraintValidator<MyUserConstraint, Object>{

	@Override
	public void initialize(MyUserConstraint constraintAnnotation) {
		System.out.println("my validator init");
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println("my validator isValid");
		return false;
	}

}
