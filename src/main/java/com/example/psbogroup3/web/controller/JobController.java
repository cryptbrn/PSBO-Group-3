package com.example.psbogroup3.web.controller;

import com.example.psbogroup3.entity.Job;
import com.example.psbogroup3.helper.ObjectHelper;
import com.example.psbogroup3.repository.JobRepository;
import com.example.psbogroup3.validation.JobMustExist;
import com.example.psbogroup3.web.model.request.CreateJobRequest;
import com.example.psbogroup3.web.model.request.UpdateJobRequest;
import com.example.psbogroup3.web.model.response.JobResponse;
import com.example.psbogroup3.web.model.response.Response;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.stream.Collectors;

@Api
@Validated
@RestController
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    ObjectHelper objectHelper;

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

    @GetMapping(
            value = "/api/job/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<JobResponse> findById(
            @JobMustExist(message = "Must Exist", path = "id")
            @PathVariable
            String id
    ){
        Job job = jobRepository.findById(id).get();
        return Response.<JobResponse>builder()
                .status(true)
                .data(toResponse(job))
                .build();
    }

    @PostMapping(
            value = "/api/job",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<JobResponse> create(@Validated @RequestBody CreateJobRequest createJobRequest){
        Job job = jobRepository.save(toJob(createJobRequest));
        return Response.<JobResponse>builder()
                .status(true)
                .data(toResponse(job))
                .build();
    }

    @PutMapping(
            value = "/api/job/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<JobResponse> updateById(
            @Validated
            @RequestBody
            UpdateJobRequest updateJobRequest,
            @JobMustExist(message = "Must Exist", path = "id")
            @PathVariable
            String id
    ){
        Job job = jobRepository.findById(id).get();
        objectHelper.copyProperties(updateJobRequest, job);
        return Response.<JobResponse>builder()
                .status(true)
                .data(toResponse(jobRepository.save(job)))
                .build();
    }

    @DeleteMapping(
            value = "api/job/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<String> deleteById(
            @JobMustExist(message = "Must Exist", path = "id")

            @PathVariable
            String id
    ){
        jobRepository.deleteById(id);
        return Response.<String>builder()
                .status(true)
                .data("Success Delete Job")
                .build();
    }

    private JobResponse toResponse(Job job){
        JobResponse jobResponse = JobResponse.builder().build();
        BeanUtils.copyProperties(job, jobResponse);
        return jobResponse;
    }

    private Job toJob(CreateJobRequest createJobRequest){
        Job job = Job.builder().build();
        BeanUtils.copyProperties(createJobRequest, job);
        return job;
    }

}
