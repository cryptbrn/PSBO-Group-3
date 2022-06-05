package com.example.psbogroup3.validation.validator;

import com.example.psbogroup3.repository.PersonRepository;
import com.example.psbogroup3.validation.PersonMustExist;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author muhammad.reyhan
 */
public class PersonMustExistValidator implements
    ConstraintValidator<PersonMustExist, String> {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if (!StringUtils.hasText(value)) {
      return true;
    }

    return personRepository.existsById(value);
  }

}
