package com.example.psbogroup3.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.example.psbogroup3.validation.validator.TimezoneMustExistValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * @author alvinamaharani
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = TimezoneMustExistValidator.class)
@Documented
public @interface TimezoneMustExist {
    String message();

    String[] path() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
