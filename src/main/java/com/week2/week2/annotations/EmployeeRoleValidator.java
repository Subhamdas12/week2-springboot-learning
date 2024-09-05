package com.week2.week2.annotations;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {

    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext arg1) {
        List<String> roles = List.of("ADMIN", "USER");
        return roles.contains(inputRole);
    }

}
