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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import commonj.sdo.helper.DataHelper;

/**
 * Data helper methods.
 */
public class DataHelperImpl implements DataHelper
{
  /**
   * @param dateString - Must comply to the pattern of yyyy-MM-dd'T'HH:mm:ss'.'SSS Z
   * @return null if dataString couldn't be parsed
   */
  public synchronized Date toDate(String dateString)
  {
    if (dateString == null)
    {
      return null;
    }
    
    DateFormat [] DATE_PATTERNS =
    {
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS Z"),
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS"),
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"),
      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"),
      new SimpleDateFormat("'P'yyyy'Y' MM'M' dd'D' 'T' HH'H' mm'M' ss'S.'SSS"),
      new SimpleDateFormat("--MM zz"),
      new SimpleDateFormat("--MM-dd zz"),
      new SimpleDateFormat("---dd zz"),
      new SimpleDateFormat("HH:mm:ss'.'SSS"),
      new SimpleDateFormat("yyyy-MM-dd"),
      new SimpleDateFormat("yyyy-MM"),
      new SimpleDateFormat("yyyy")
    };
    
    for (int i = 0; i < DATE_PATTERNS.length; ++i)
    {
      try
      {
        return DATE_PATTERNS[i].parse(dateString);
      }
      catch (ParseException parseException)
      {
      }
    }
    
    return null;
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
