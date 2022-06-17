package com.example.psbogroup3.helper.impl;

import com.example.psbogroup3.entity.Job;
import com.example.psbogroup3.helper.JobHelper;
import com.example.psbogroup3.web.model.request.CreateJobRequest;
import com.example.psbogroup3.web.model.response.JobResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author muhammad.reyhan
 */
@Component
@Slf4j
public class JobHelperImpl implements JobHelper {

  @Override
  public Job toJob(CreateJobRequest createJobRequest) {
    Job job = Job.builder().build();
    BeanUtils.copyProperties(createJobRequest, job);
    return job;
  }

  @Override
  public JobResponse toResponse(Job job) {
    JobResponse jobResponse = JobResponse.builder().build();
    BeanUtils.copyProperties(job, jobResponse);
    return jobResponse;
  }

}
