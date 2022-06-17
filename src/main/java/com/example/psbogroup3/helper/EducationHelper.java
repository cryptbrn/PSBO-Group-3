package com.example.psbogroup3.helper;

import com.example.psbogroup3.entity.Education;
import com.example.psbogroup3.web.model.request.CreateEducationRequest;
import com.example.psbogroup3.web.model.response.EducationResponse;

/**
 * @author muhammad.reyhan
 */
public interface EducationHelper {

  Education toEducation(CreateEducationRequest createEducationRequest);

  EducationResponse toResponse(Education education);

}
