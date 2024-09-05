package com.week2.week2.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { EmployeeRoleValidator.class })
public @interface EmployeeRoleValidation {
    String message() default "Role of employee must be Admin or User";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
