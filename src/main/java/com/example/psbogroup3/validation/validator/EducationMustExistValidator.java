package com.example.psbogroup3.validation.validator;

import com.example.psbogroup3.repository.EducationRepository;
import com.example.psbogroup3.validation.EducationMustExist;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author LINZ_IS_HERE
 */
public class EducationMustExistValidator implements
    ConstraintValidator<EducationMustExist, String> {

  @Autowired
  private EducationRepository educationRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if (!StringUtils.hasText(value)) {
      return true;
    }

    return educationRepository.existsById(value);
  }

}
