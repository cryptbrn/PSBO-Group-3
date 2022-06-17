package com.example.psbogroup3.web.model.request;

import com.example.psbogroup3.enums.Gender;
import com.example.psbogroup3.enums.Status;
import com.example.psbogroup3.validation.AddressMustExist;
import com.example.psbogroup3.validation.EducationMustExist;
import com.example.psbogroup3.validation.JobMustExist;
import com.example.psbogroup3.validation.StringEnumeration;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class CreatePersonRequest {
  @NotBlank
  private String name;

  @NotNull
  @StringEnumeration(message = "Must Gender Enum", enumClass = Gender.class)
  private String gender;

  @Valid
  private CreateAddressRequest address;

  @NotBlank
  private String email;

  @NotNull
  private Long birthDate;

  @Valid
  private CreateEducationRequest education;

  @NotNull
  @StringEnumeration(message = "Must Status Enum", enumClass = Status.class)
  private String status;

  @NotBlank
  private String religion;

  @NotBlank
  private String nationality;

  @Valid
  private CreateJobRequest job;

  @AddressMustExist(message = "Must Exist", path = "addressId")
  private String addressId;

  @EducationMustExist(message = "Must Exist", path = "educationId")
  private String educationId;

  @JobMustExist(message = "Must Exist", path = "jobId")
  private String jobId;
}
