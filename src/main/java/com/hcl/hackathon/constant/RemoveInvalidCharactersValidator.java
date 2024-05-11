package com.hcl.hackathon.constant;

import com.hcl.hackathon.annotation.RemoveInvalidCharacters;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RemoveInvalidCharactersValidator implements ConstraintValidator<RemoveInvalidCharacters, String> {

    @Override
    public void initialize(RemoveInvalidCharacters constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s == null || s.matches("[a-zA-Z0-9]+"); // Allow only alphanumeric characters
    }


}