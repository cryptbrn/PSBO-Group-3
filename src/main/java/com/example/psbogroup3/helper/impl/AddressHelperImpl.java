package com.example.psbogroup3.helper.impl;

import com.example.psbogroup3.entity.Address;
import com.example.psbogroup3.helper.AddressHelper;
import com.example.psbogroup3.helper.TimezoneHelper;
import com.example.psbogroup3.repository.TimezoneRepository;
import com.example.psbogroup3.web.model.request.CreateAddressRequest;
import com.example.psbogroup3.web.model.request.UpdateAddressRequest;
import com.example.psbogroup3.web.model.response.AddressResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author muhammad.reyhan
 */
@Component
@Slf4j
public class AddressHelperImpl implements AddressHelper {

  @Autowired
  private TimezoneRepository timezoneRepository;

  @Autowired
  private TimezoneHelper timezoneHelper;

  @Override
  public Address toAddress(CreateAddressRequest createAddressRequest) {
    Address address = Address.builder().build();
    BeanUtils.copyProperties(createAddressRequest, address);
    if(createAddressRequest.getTimeZoneId() != null){
      address.setTimezone(timezoneRepository.findById(createAddressRequest.getTimeZoneId()).get());
    } else {
      address.setTimezone(timezoneRepository.save(
          timezoneHelper.toTimezone(createAddressRequest.getTimezoneRequest())));
    }
    return address;
  }

  @Override
  public AddressResponse toResponse(Address address) {
    AddressResponse addressResponse = AddressResponse.builder().build();
    BeanUtils.copyProperties(address, addressResponse);
    addressResponse.setTimezone(timezoneHelper.toResponse(address.getTimezone()));
    return addressResponse;
  }

  @Override
  public Address updateAddress(Address address, UpdateAddressRequest updateAddressRequest) {
    if (updateAddressRequest.getTimeZoneId() != null) {
      address.setTimezone(timezoneRepository.findById(updateAddressRequest.getTimeZoneId()).get());
    } else {
      address.setTimezone(timezoneHelper.updateTimezone(address.getTimezone(),
          updateAddressRequest.getUpdateTimezoneRequest()));
    }

    return address;
  }
}
