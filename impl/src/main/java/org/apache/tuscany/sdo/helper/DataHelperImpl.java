/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import commonj.sdo.helper.DataHelper;

/**
 * Data helper methods.
 */
public class DataHelperImpl implements DataHelper
{
  /**
   * @param dateString - Must comply to the pattern of yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'
   * @return null if dataString couldn't be parsed
   */
  public synchronized Date toDate(String dateString)
  {
    Date result = null;
    dateString = dateString.trim();
    boolean negative = false;
    
    if (dateString == null)
    {
      return null;
    }
    
    // Determine if it is a negative Date, DateTime, or Duration
    if (dateString.length() > 2 && dateString.charAt(0) == '-' && dateString.charAt(1) != '-')
    {
      negative = true;
      dateString = dateString.substring(1);
    }
    
    // SDO Date Format ends with a Z
    
    if (dateString.endsWith("Z"))
    {
      SimpleDateFormat[] SDO_DATE_FORMATS = 
      {
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'"),
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
      };
    
      for (int i = 0; i < SDO_DATE_FORMATS.length; i++)
      {
        SDO_DATE_FORMATS[i].setTimeZone(TimeZone.getTimeZone("GMT"));
      }
      
      result = checkFormats(dateString, SDO_DATE_FORMATS);
      
      // If no match, continue to try further possibilities
      
      if (result != null)
      {
        if (negative)
          return handleBCE(result);
        else
          return result;
      }
      
    }
    
    // Duration format begins with a P
    
    if (dateString.startsWith("P"))
    {
      // Remove any spaces in the dateString
        
      String durationString = dateString.replaceAll(" ", "");

      // For Duration format, there are so many possibilities due to so many optional
      // inclusions, that we will build the format string rather than create
      // a potential SimpleDateFormat for each possibility.   
        
      SimpleDateFormat[] DURATION_FORMATS = obtainDurationFormats(durationString);
      result = checkFormats(durationString, DURATION_FORMATS);
      if (result != null)
      {
        if (negative)
          return handleNegative(result); 
        else
          return result;
      }
    }
    
    // Check the remaining possibilities.  Note that time zone is optional for each.
    
    SimpleDateFormat [] DATE_PATTERNS =
    {
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS z"),
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z"),
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm z"), 
      new SimpleDateFormat("'--'MM'-'dd z"),
      new SimpleDateFormat("'--'MM z"),
      new SimpleDateFormat("'---'dd zzzz"),
      new SimpleDateFormat("HH:mm:ss'.'SSS z"),
      new SimpleDateFormat("HH:mm:ss z"),
      new SimpleDateFormat("yyyy-MM-dd z"),
      new SimpleDateFormat("yyyy-MM z"),
      new SimpleDateFormat("yyyy z"),
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS"),
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"),
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"),
      new SimpleDateFormat("'--'MM'-'dd"),
      new SimpleDateFormat("'--'MM"),
      new SimpleDateFormat("'---'dd"),
      new SimpleDateFormat("HH:mm:ss'.'SSS"),
      new SimpleDateFormat("HH:mm:ss"),
      new SimpleDateFormat("yyyy-MM-dd"),
      new SimpleDateFormat("yyyy-MM"),
      new SimpleDateFormat("yyyy")      
    };
    
    result = checkFormats(dateString, DATE_PATTERNS);
    if (result != null)
    {
      if (negative)
        return handleBCE(result);   
      else
        return result;
    }
    
    return null;
  }
  
  private synchronized Date checkFormats (String dateString, SimpleDateFormat[] format_array)
  {
    for (int i = 0; i < format_array.length; ++i)
    {      
      try
      {
        format_array[i].setLenient(false);
        return format_array[i].parse(dateString);
      }
      catch (ParseException parseException)
      {
      }    
    }
      
    return null;
  }
  
  public synchronized SimpleDateFormat[] obtainDurationFormats(String dateString)
  {
    String first_part, second_part;
    StringBuffer format_buffer = new StringBuffer("'P'");

    // Must divide it into two parts to distinguish between Months and Minutes
      
    int time_index = dateString.indexOf("T");
    if (time_index != -1)
    {
      first_part = dateString.substring(0, time_index + 1);    
      second_part = dateString.substring(time_index);
    }
    else
    {
      first_part = dateString;
      second_part = null;
    }
      
    if (first_part.indexOf("Y") != -1)
      format_buffer.append("yyyy'Y'");
    if (first_part.indexOf("M") != -1)
      format_buffer.append("MM'M'");
    if (first_part.indexOf("D") != -1)
      format_buffer.append("dd'D'");
    if (time_index != -1)
    {
      format_buffer.append("'T'");
       
      if (second_part.indexOf("H") != -1)
        format_buffer.append("HH'H'");
      if (second_part.indexOf("M") != -1)
        format_buffer.append("mm'M'");
      if (second_part.indexOf("S.") != -1)
        format_buffer.append("ss'S'.S");
      else if (second_part.indexOf("S") != -1)
        format_buffer.append("ss'S'");
    }

    String format_string = format_buffer.toString().replaceAll("''", "");
     
    SimpleDateFormat [] DURATION_FORMATS = 
    {
      new SimpleDateFormat(format_string)
    };

    return DURATION_FORMATS;
  }
  
  // Return a negative Duration if a negative sign existed in dateString
  public synchronized Date handleNegative(Date output)
  {
    return new Date(0 - output.getTime());
  }
  
  // Return the date in BCE if a negative sign existed in dateString
  
  public synchronized Date handleBCE(Date output)
  {
    GregorianCalendar temp = new GregorianCalendar();
    temp.setTime(output);
    temp.set(GregorianCalendar.ERA, GregorianCalendar.BC);
        
    return temp.getTime();
  }
  
  public synchronized Calendar toCalendar(String dateString)
  {
    if (dateString == null)
    {
      return null;
    }
    
    Date date = toDate(dateString);
    if (date == null)
    {
      return null;
    }
    
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    
    return calendar;
  }
  
  public synchronized Calendar toCalendar(String dateString, Locale locale)
  {
    if (dateString == null || locale == null)
    {
      return null;
    }
    
    Date date = toDate(dateString);
    if (date == null)
    {
      return null;
    }
    
    Calendar calendar = new GregorianCalendar(locale);
    calendar.setTime(date);
    return calendar;
  }

  public synchronized String toDateTime(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS zz");
    
    return f.format(date);
  }
  
  public synchronized String toDuration(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("'P'yyyy'Y' MM'M' dd'D' 'T' HH'H' mm'M' ss'S.'SSS");
    
    return f.format(date);
  }

  public synchronized String toTime(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss'.'SSS zz");
    
    return f.format(date);
  }
  
  public synchronized String toDay(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("---dd zz");
    
    return f.format(date);
  }
  
  public synchronized String toMonth(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("--MM zz");
    
    return f.format(date);
  }

  public synchronized String toMonthDay(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("--MM-dd zz");
    
    return f.format(date);
  }

  public synchronized String toYear(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("yyyy zz");
    
    return f.format(date); 
  }

  public synchronized String toYearMonth(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM zz");
    
    return f.format(date);
  }

  public synchronized String toYearMonthDay(Date date)
  {
    if (date == null)
    {
      return null;
    }
    
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd zz");
    
    return f.format(date);
  }

  public synchronized String toDateTime(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toDateTime(calendar.getTime());
  }

  public synchronized String toDuration(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toDuration(calendar.getTime());
  }

  public synchronized String toTime(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toTime(calendar.getTime());
  }

  public synchronized String toDay(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toDay(calendar.getTime());
  }

  public synchronized String toMonth(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toMonth(calendar.getTime());
  }

  public synchronized String toMonthDay(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toMonthDay(calendar.getTime());
  }

  public synchronized String toYear(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toYear(calendar.getTime());
  }

  public synchronized String toYearMonth(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toYearMonth(calendar.getTime());
  }

  public synchronized String toYearMonthDay(Calendar calendar)
  {
    if (calendar == null)
    {
      return null;
    }
    
    return toYearMonthDay(calendar.getTime());
  }
}
