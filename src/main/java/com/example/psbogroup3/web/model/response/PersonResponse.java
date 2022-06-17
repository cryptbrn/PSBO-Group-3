package com.example.psbogroup3.web.model.response;

import com.example.psbogroup3.entity.Education;
import com.example.psbogroup3.enums.Gender;
import com.example.psbogroup3.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author muhammad.reyhan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
  private String id;

  private String name;

  private Gender gender;

  private AddressResponse address;

  private String email;

  private Long birthDate;

  private EducationResponse education;

  private Status status;

  private String photo;

  private String religion;

  private String nationality;

  private JobResponse job;
}
