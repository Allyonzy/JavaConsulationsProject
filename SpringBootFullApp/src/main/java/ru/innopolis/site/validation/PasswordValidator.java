package ru.innopolis.site.validation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;


public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() > 7 && value.matches(".*[A-Z].*") &&
                value.matches(".*[a-z].*")
                && value.matches(".*[0-9].*");
    }
}
