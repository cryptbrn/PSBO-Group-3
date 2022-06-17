package com.example.psbogroup3.validation.validator;

import com.example.psbogroup3.repository.AddressRepository;
import com.example.psbogroup3.validation.AddressMustExist;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author Maxdha.Maxiwinata
 */
public class AddressMustExistValidator implements
    ConstraintValidator<AddressMustExist, String> {

  @Autowired
  private AddressRepository addressRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if (!StringUtils.hasText(value)) {
      return true;
    }

    return addressRepository.existsById(value);
  }

}
