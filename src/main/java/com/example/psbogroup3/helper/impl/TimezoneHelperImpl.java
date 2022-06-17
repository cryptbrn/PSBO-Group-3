package com.example.psbogroup3.helper.impl;

import com.example.psbogroup3.helper.TimezoneHelper;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author muhammad.reyhan
 */
@Component
@Slf4j
public class TimezoneHelperImpl implements TimezoneHelper {

  @Override
  public String generateOffset(String location) {
    TimeZone timeZone = TimeZone.getTimeZone(location);
    if(!timeZone.getID().equals(location)){
      return "TIME-ZONE-NOT-VALID";
    }
    Calendar calendar = GregorianCalendar.getInstance(timeZone);
    int offsetInMillis = timeZone.getOffset(calendar.getTimeInMillis());
    String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000),
        Math.abs((offsetInMillis / 60000) % 60));
    return "GMT" + (offsetInMillis >= 0 ? "+" : "-") + offset;
  }
}
