package com.example.psbogroup3.helper.impl;

import com.example.psbogroup3.helper.TimezoneHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author muhammad.reyhan
 */
@SpringBootTest
class TimezoneHelperImplTest {

  @Autowired
  private TimezoneHelper timezoneHelper;

  @Test
  void generateOffset() {
    Assertions.assertEquals("TIME-ZONE-NOT-VALID", timezoneHelper.generateOffset("TEST"));
  }

  @Test
  void generateOffset2(){
    Assertions.assertEquals("GMT+07:00", timezoneHelper.generateOffset("Asia/Jakarta"));
  }
}