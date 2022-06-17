package com.example.psbogroup3.web.controller;

import com.example.psbogroup3.entity.Address;
import com.example.psbogroup3.helper.AddressHelper;
import com.example.psbogroup3.helper.ObjectHelper;
import com.example.psbogroup3.repository.AddressRepository;
import com.example.psbogroup3.validation.AddressMustExist;
import com.example.psbogroup3.web.model.request.CreateAddressRequest;
import com.example.psbogroup3.web.model.request.UpdateAddressRequest;
import com.example.psbogroup3.web.model.response.AddressResponse;
import com.example.psbogroup3.web.model.response.Response;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.stream.Collectors;
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
public class AddressController {

  @Autowired
  AddressRepository addressRepository;

  @Autowired
  AddressHelper addressHelper;

  @Autowired
  ObjectHelper objectHelper;

  @GetMapping(value = "/api/address", produces = MediaType.APPLICATION_JSON_VALUE)
  public Response<List<AddressResponse>> findAll() {
    List<Address> addressList = addressRepository.findAll();
    List<AddressResponse> addressResponseList = addressList.stream()
        .map(address -> addressHelper.toResponse(address)).collect(
            Collectors.toList());
    return Response.<List<AddressResponse>>builder()
        .status(true)
        .data(addressResponseList)
        .build();

  }

  @GetMapping(value = "/api/address/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Response<AddressResponse> findById(
      @AddressMustExist(message = "Must Exist", path = "id") @PathVariable String id) {
    Address address = addressRepository.findById(id).get();
    return Response.<AddressResponse>builder()
        .status(true)
        .data(addressHelper.toResponse(address))
        .build();
  }

  @PostMapping(value = "/api/address", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Response<AddressResponse> create(
      @Validated @RequestBody CreateAddressRequest createAddressRequest) {
    Address address = addressRepository.save(addressHelper.toAddress(createAddressRequest));
    return Response.<AddressResponse>builder()
        .status(true)
        .data(addressHelper.toResponse(address))
        .build();
  }

  @PutMapping(value = "/api/address/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Response<AddressResponse> updateById(
      @Validated @RequestBody UpdateAddressRequest updateAddressRequest,
      @AddressMustExist(message = "Must Exist", path = "id") @PathVariable String id) {
    Address address = addressRepository.findById(id).get();
    objectHelper.copyProperties(updateAddressRequest, address);
    return Response.<AddressResponse>builder()
        .status(true)
        .data(addressHelper.toResponse(
            addressRepository.save(addressHelper.updateAddress(address, updateAddressRequest))))
        .build();
  }

  @DeleteMapping(value = "/api/address/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Response<String> deleteById(
      @AddressMustExist(message = "Must Exist", path = "id") @PathVariable String id) {
    addressRepository.deleteById(id);
    return Response.<String>builder()
        .status(true)
        .data("Success Delete Address")
        .build();
  }

}
