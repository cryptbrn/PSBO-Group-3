package com.example.psbogroup3.helper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.psbogroup3.entity.Address;
import com.example.psbogroup3.entity.Timezone;
import com.example.psbogroup3.helper.AddressHelper;
import com.example.psbogroup3.web.model.request.CreateAddressRequest;
import com.example.psbogroup3.web.model.request.CreateTimezoneRequest;
import com.example.psbogroup3.web.model.request.UpdateAddressRequest;
import com.example.psbogroup3.web.model.request.UpdateTimezoneRequest;
import com.example.psbogroup3.web.model.response.AddressResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author muhammad.reyhan
 */
@SpringBootTest
class AddressHelperImplTest {

  //region dependency injection
  @Autowired
  private AddressHelper addressHelper;
  //end region depedency injection

  @Test
  void toAddress() {
    //region object preparation
    CreateTimezoneRequest createTimezoneRequest = CreateTimezoneRequest.builder()
        .location("Asia/Jakarta")
        .build();

    CreateAddressRequest createAddressRequest = CreateAddressRequest.builder()
        .houseNum("1")
        .city("CITY")
        .district("DISTRICT")
        .subDistrict("SUB-DISTRICT")
        .province("PROVINCE")
        .longitude(2.0)
        .latitude(2.0)
        .timezoneRequest(createTimezoneRequest)
        .build();
    //end region object preparation

    Address address = addressHelper.toAddress(createAddressRequest);

    //region assertion
    assertEquals(createAddressRequest.getHouseNum(), address.getHouseNum());
    assertEquals(createAddressRequest.getCity(), address.getCity());
    assertEquals(createAddressRequest.getDistrict(), address.getDistrict());
    assertEquals(createAddressRequest.getSubDistrict(), address.getSubDistrict());
    assertEquals(createAddressRequest.getProvince(), address.getProvince());
    assertEquals(createAddressRequest.getLongitude(), address.getLongitude());
    assertEquals(createAddressRequest.getTimezoneRequest().getLocation(), address.getTimezone().getLocation());
    assertEquals("GMT+07:00", address.getTimezone().getOffset());
    //end region assertion
  }

  @Test
  void toResponse() {
    //region object preparation
    Timezone timezone = Timezone.builder()
        .id("1")
        .location("Asia/Jakarta")
        .offset("GMT+07:00")
        .build();
    Address address = Address.builder()
        .houseNum("1")
        .city("CITY")
        .district("DISTRICT")
        .subDistrict("SUB-DISTRICT")
        .province("PROVINCE")
        .longitude(2.0)
        .latitude(2.0)
        .timezone(timezone)
        .build();
    //end region object preparation

    AddressResponse addressResponse =  addressHelper.toResponse(address);

    //region assertion
    assertEquals(address.getHouseNum(), addressResponse.getHouseNum());
    assertEquals(address.getCity(), addressResponse.getCity());
    assertEquals(address.getDistrict(), addressResponse.getDistrict());
    assertEquals(address.getSubDistrict(), addressResponse.getSubDistrict());
    assertEquals(address.getProvince(), addressResponse.getProvince());
    assertEquals(address.getLongitude(), addressResponse.getLongitude());
    assertEquals(address.getTimezone().getLocation(), addressResponse.getTimezone().getLocation());
    assertEquals("GMT+07:00", addressResponse.getTimezone().getOffset());
    //end region assertion
  }

  @Test
  void updateAddress() {
    //region object preparation
    UpdateTimezoneRequest updateTimezoneRequest = UpdateTimezoneRequest.builder()
        .location("Asia/Jakarta")
        .build();

    UpdateAddressRequest updateAddressRequest = UpdateAddressRequest.builder()
        .houseNum("1")
        .city("CITY")
        .district("DISTRICT")
        .subDistrict("SUB-DISTRICT")
        .province("PROVINCE")
        .longitude(2.0)
        .latitude(2.0)
        .updateTimezoneRequest(updateTimezoneRequest)
        .build();

    Timezone timezone = Timezone.builder()
        .id("1")
        .location("Asia/Jayapura")
        .offset("GMT+09:00")
        .build();

    Address address = Address.builder()
        .houseNum("1")
        .city("CITY")
        .district("DISTRICT")
        .subDistrict("SUB-DISTRICT")
        .province("PROVINCE")
        .longitude(2.0)
        .latitude(2.0)
        .timezone(timezone)
        .build();
    //end region object preparation

    Address addressUpdated = addressHelper.updateAddress(address, updateAddressRequest);

    //region assertion
    assertEquals(updateAddressRequest.getHouseNum(), addressUpdated.getHouseNum());
    assertEquals(updateAddressRequest.getCity(), addressUpdated.getCity());
    assertEquals(updateAddressRequest.getDistrict(), addressUpdated.getDistrict());
    assertEquals(updateAddressRequest.getSubDistrict(), addressUpdated.getSubDistrict());
    assertEquals(updateAddressRequest.getProvince(), addressUpdated.getProvince());
    assertEquals(updateAddressRequest.getLongitude(), addressUpdated.getLongitude());
    assertEquals(updateAddressRequest.getUpdateTimezoneRequest().getLocation(), addressUpdated.getTimezone().getLocation());
    assertEquals("GMT+07:00", addressUpdated.getTimezone().getOffset());
    //end region assertion

  }
}