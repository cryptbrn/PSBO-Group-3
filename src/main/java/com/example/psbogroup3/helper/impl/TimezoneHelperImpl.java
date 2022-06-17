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
    TimeZone tz = TimeZone.getTimeZone(location);
    Calendar cal = GregorianCalendar.getInstance(tz);
    int offsetInMillis = tz.getOffset(cal.getTimeInMillis());
    String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000),
        Math.abs((offsetInMillis / 60000) % 60));
    return "GMT" + (offsetInMillis >= 0 ? "+" : "-") + offset;
  }
}
