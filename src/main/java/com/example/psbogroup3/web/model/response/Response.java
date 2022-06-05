package com.example.psbogroup3.web.model.response;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author muhammad.reyhan
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
  private Boolean status;
  private T data;
  private Map<String, List<String>> errors;
}
