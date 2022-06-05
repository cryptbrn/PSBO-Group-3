package com.example.psbogroup3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author muhammad.reyhan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
  private String name;
  private String gender;
  private String address;
}
