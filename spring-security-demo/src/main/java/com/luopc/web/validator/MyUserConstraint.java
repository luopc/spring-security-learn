package com.luopc.web.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyUserConstraintValidator.class)
public @interface MyUserConstraint {

	String message() default "自定义校验器";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
