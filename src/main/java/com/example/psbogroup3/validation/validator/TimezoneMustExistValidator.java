package com.example.psbogroup3.validation.validator;

import com.example.psbogroup3.repository.TimezoneRepository;
import com.example.psbogroup3.validation.TimezoneMustExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TimezoneMustExistValidator implements
        ConstraintValidator<TimezoneMustExist, String> {

    @Autowired
    private TimezoneRepository timezoneRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtils.hasText(value)) {
            return true;
        }

        return timezoneRepository.existsById(value);
    }
}
