package com.example.psbogroup3.web.controller;

import com.example.psbogroup3.entity.Person;
import com.example.psbogroup3.enums.Status;
import com.example.psbogroup3.helper.AddressHelper;
import com.example.psbogroup3.helper.EducationHelper;
import com.example.psbogroup3.helper.JobHelper;
import com.example.psbogroup3.helper.ObjectHelper;
import com.example.psbogroup3.repository.AddressRepository;
import com.example.psbogroup3.repository.EducationRepository;
import com.example.psbogroup3.repository.JobRepository;
import com.example.psbogroup3.repository.PersonRepository;
import com.example.psbogroup3.validation.PersonMustExist;
import com.example.psbogroup3.web.model.request.CreatePersonRequest;
import com.example.psbogroup3.web.model.request.UpdatePersonRequest;
import com.example.psbogroup3.web.model.response.PersonResponse;
import com.example.psbogroup3.web.model.response.Response;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muhammad.reyhan
 */

@Api
@Validated
@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    AddressHelper addressHelper;

    @Autowired
    EducationHelper educationHelper;

    @Autowired
    JobHelper jobHelper;

    @Autowired
    ObjectHelper objectHelper;

    @GetMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<PersonResponse>> findAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonResponse> personResponseList = personList.stream().map(this::toResponse).collect(
                Collectors.toList());
        return Response.<List<PersonResponse>>builder()
                .status(true)
                .data(personResponseList)
                .build();

    }

    @GetMapping(value = "/api/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<PersonResponse> findById(
            @PersonMustExist(message = "Must Exist", path = "id") @PathVariable String id) {
        Person person = personRepository.findById(id).get();
        return Response.<PersonResponse>builder()
                .status(true)
                .data(toResponse(person))
                .build();
    }

    @PostMapping(value = "/api/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<PersonResponse> create(@Validated @RequestBody CreatePersonRequest createPersonRequest) {
        Person person = personRepository.save(toPerson(createPersonRequest));
        return Response.<PersonResponse>builder()
                .status(true)
                .data(toResponse(person))
                .build();
    }

    @PutMapping(value = "/api/persons/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<PersonResponse> updateById(
            @Validated @RequestBody UpdatePersonRequest updatePersonRequest,
            @PersonMustExist(message = "Must Exist", path = "id") @PathVariable String id) {
        Person person = personRepository.findById(id).get();
        objectHelper.copyProperties(updatePersonRequest, person);
        return Response.<PersonResponse>builder()
                .status(true)
                .data(toResponse(personRepository.save(person)))
                .build();
    }

    @DeleteMapping(value = "/api/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> deleteById(
            @PersonMustExist(message = "Must Exist", path = "id") @PathVariable String id) {
        personRepository.deleteById(id);
        return Response.<String>builder()
                .status(true)
                .data("Success Delete Person")
                .build();
    }

    private PersonResponse toResponse(Person person) {
        PersonResponse personResponse = PersonResponse.builder().build();
        BeanUtils.copyProperties(person, personResponse);
        personResponse.setAddress(addressHelper.toResponse(person.getAddress()));
        personResponse.setEducation(educationHelper.toResponse(person.getEducation()));
        personResponse.setJob(jobHelper.toResponse(person.getJob()));
        return personResponse;
    }

    private Person toPerson(CreatePersonRequest createPersonRequest) {
        Person person = Person.builder().build();
        BeanUtils.copyProperties(createPersonRequest, person);
        person.setStatus(Status.valueOf(createPersonRequest.getStatus()));
        setAddress(person, createPersonRequest);
        setEducation(person, createPersonRequest);
        setJob(person, createPersonRequest);
        return person;
    }

    private void setAddress(Person person, CreatePersonRequest createPersonRequest){
        if(createPersonRequest.getAddressId() != null){
            person.setAddress(addressRepository.findById(createPersonRequest.getAddressId()).get());
        }else {
            person.setAddress(addressHelper.toAddress(createPersonRequest.getAddress()));
        }
    }

    private void setEducation(Person person, CreatePersonRequest createPersonRequest){
        if(createPersonRequest.getEducationId() != null){
            person.setEducation(educationRepository.findById(createPersonRequest.getEducationId()).get());
        }else {
            person.setEducation(educationHelper.toEducation(createPersonRequest.getEducation()));
        }
    }

    private void setJob(Person person, CreatePersonRequest createPersonRequest){
        if(createPersonRequest.getJobId() != null){
            person.setJob(jobRepository.findById(createPersonRequest.getJobId()).get());
        }else {
            person.setJob(jobHelper.toJob(createPersonRequest.getJob()));
        }
    }

}
