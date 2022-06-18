package com.example.psbogroup3.helper;

import com.example.psbogroup3.entity.Job;
import com.example.psbogroup3.web.model.request.CreateJobRequest;
import com.example.psbogroup3.web.model.response.JobResponse;

/**
 * @author muhammad.reyhan
 */
public interface JobHelper {

  Job toJob(CreateJobRequest createJobRequest);

  JobResponse toResponse(Job job);

}
