package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxInvValidator implements ConstraintValidator<ValidMaxInv, Part> {
    @Autowired
    private ApplicationContext context;
    public static ApplicationContext myContext;

    @Override
    public void initialize(ValidMaxInv constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (context == null) {
            return true;
        }
        if (context != null) {
            myContext = context;
        }

        // checks inv is less than or equal to maxInv
        if (part.getInv() <= part.getMaxInv()) {
            return true;
        }
        else {
            // constrains error to match inv field of the given part
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    constraintValidatorContext.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("inv").addConstraintViolation();
            return false;
        }
    }
}
