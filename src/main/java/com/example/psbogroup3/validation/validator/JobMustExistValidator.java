package com.example.psbogroup3.validation.validator;

import com.example.psbogroup3.repository.JobRepository;
import com.example.psbogroup3.validation.JobMustExist;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class JobMustExistValidator implements
        ConstraintValidator<JobMustExist, String> {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtils.hasText(value)) {
            return true;
        }

        return jobRepository.existsById(value);
    }
}
