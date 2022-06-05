package com.example.psbogroup3.web.controller;

import com.example.psbogroup3.entity.Job;
import com.example.psbogroup3.repository.JobRepository;
import com.example.psbogroup3.web.model.response.JobResponse;
import com.example.psbogroup3.web.model.response.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api
@Validated
@RestController
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping(
            value = "/api/job",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<List<JobResponse>> findAll(){
        List<Job> jobList = jobRepository.findAll();
        List<JobResponse> jobResponseList = jobList.stream().map(this::toResponse).collect(
                Collectors.toList());
        return Response.<List<JobResponse>>builder()
                .status(true)
                .data(jobResponseList)
                .build();
    }

    private JobResponse toResponse(Job job){
        JobResponse jobResponse = JobResponse.builder().build();
        BeanUtils.copyProperties(job, jobResponse);
        return jobResponse;
    }

}
