package com.example.psbogroup3.web.model.request;

import com.example.psbogroup3.enums.Gender;
import com.example.psbogroup3.enums.Status;
import com.example.psbogroup3.validation.AddressMustExist;
import com.example.psbogroup3.validation.EducationMustExist;
import com.example.psbogroup3.validation.JobMustExist;
import com.example.psbogroup3.validation.StringEnumeration;
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
public class UpdatePersonRequest {
  private String name;

  @StringEnumeration(message = "Must Gender Enum", enumClass = Gender.class)
  private String gender;

  private UpdateAddressRequest address;

  private String email;

  private Long birthDate;

  private UpdateEducationRequest education;

  @StringEnumeration(message = "Must Status Enum", enumClass = Status.class)
  private String status;

  private String religion;

  private String nationality;

  private UpdateJobRequest job;

  @AddressMustExist(message = "Must Exist", path = "addressId")
  private String addressId;

  @EducationMustExist(message = "Must Exist", path = "educationId")
  private String educationId;

  @JobMustExist(message = "Must Exist", path = "jobId")
  private String jobId;
}
