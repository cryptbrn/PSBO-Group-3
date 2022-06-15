package com.example.psbogroup3.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.example.psbogroup3.validation.validator.EducationMustExistValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author LINZ_IS_HERE
**/
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EducationMustExistValidator.class)
@Documented
public @interface EducationMustExist {

  String message();

  String[] path() default {};

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
