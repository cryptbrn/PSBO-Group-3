package com.example.psbogroup3.web.model.request;

import com.example.psbogroup3.enums.Gender;
import com.example.psbogroup3.enums.Status;
import com.example.psbogroup3.validation.StringEnumeration;
import javax.validation.constraints.Min;
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

  @NotBlank
  private String address;

  @NotBlank
  private String email;

  @NotNull
  private Long birthDate;

  @NotBlank
  private String education;

  @NotNull
  @StringEnumeration(message = "Must Status Enum", enumClass = Status.class)
  private String status;

  @NotBlank
  private String photo;

  @NotBlank
  private String religion;

  @NotBlank
  private String nationality;

  @NotBlank
  private String job;
}
