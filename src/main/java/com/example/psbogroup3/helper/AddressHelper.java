package com.example.psbogroup3.helper;

import com.example.psbogroup3.entity.Address;
import com.example.psbogroup3.web.model.request.CreateAddressRequest;
import com.example.psbogroup3.web.model.request.UpdateAddressRequest;
import com.example.psbogroup3.web.model.response.AddressResponse;

/**
 * @author muhammad.reyhan
 */
public interface AddressHelper {

  Address toAddress(CreateAddressRequest createAddressRequest);

  AddressResponse toResponse(Address address);

  Address updateAddress(Address address, UpdateAddressRequest updateAddressRequest);

}
