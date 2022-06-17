package com.example.psbogroup3.validation.validator;

import com.example.psbogroup3.helper.TimezoneHelper;
import com.example.psbogroup3.validation.TimezoneMustValid;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author muhammad.reyhan
 */
public class TimezoneMustValidValidator implements
    ConstraintValidator<TimezoneMustValid, String> {

  @Autowired
  private TimezoneHelper timezoneHelper;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (!StringUtils.hasText(value)) {
      return true;
    }

    return !timezoneHelper.generateOffset(value).equals("TIME-ZONE-NOT-VALID");
  }
}
