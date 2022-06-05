package com.example.psbogroup3.web.controller;

import com.example.psbogroup3.web.model.PersonRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muhammad.reyhan
 */

@RestController
public class PersonController {

  @GetMapping(
      value = "/api/person",
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public void createPerson(PersonRequest personRequest){
    System.out.println("CEK");
  }

}
