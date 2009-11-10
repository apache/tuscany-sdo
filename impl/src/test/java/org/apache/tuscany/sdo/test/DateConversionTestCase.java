/**
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.tuscany.sdo.test;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import commonj.sdo.helper.DataHelper;

// DateConversionTestCase insures that the DataHelper conversions accurately
// retain the information in the specified fields (e.g. month, day or year).
// It also provides coverage for the DataHelper API.
// Note that toDate is called each time Test.initialize() is called.

public class DateConversionTestCase extends TestCase
{
    private static Calendar test_calendar;
    private static Date test_date;
    private static DataHelper data_helper;
    
    private static final TestType TO_DATE_TIME = new TestType("toDateTime", new int [] {Calendar.YEAR, Calendar.MONTH, 
            Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND});
    private static final TestType TO_DURATION = new TestType("toDuration", new int [] {Calendar.YEAR, Calendar.MONTH, 
            Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND});
    private static final TestType TO_TIME = new TestType("toTime", new int [] {Calendar.HOUR_OF_DAY, Calendar.MINUTE, 
            Calendar.SECOND, Calendar.MILLISECOND});
    private static final TestType TO_DAY = new TestType("toDay", new int[] {Calendar.DAY_OF_MONTH});
    private static final TestType TO_MONTH = new TestType("toMonth", new int[] {Calendar.MONTH});
    private static final TestType TO_MONTH_DAY = new TestType("toMonthDay", new int[] {Calendar.MONTH, Calendar.DAY_OF_MONTH});
    private static final TestType TO_YEAR = new TestType("toYear", new int[] {Calendar.YEAR});
    private static final TestType TO_YEAR_MONTH= new TestType("toYearMonth",  new int[] {Calendar.YEAR, Calendar.MONTH});
    private static final TestType TO_YEAR_MONTH_DAY = new TestType("toYearMonthDay",  new int[] {Calendar.YEAR, 
            Calendar.MONTH, Calendar.DAY_OF_MONTH});    
    
    public DateConversionTestCase() throws Exception
    {
        data_helper = DataHelper.INSTANCE;
        test_calendar = new GregorianCalendar();
        test_calendar.setTime(new Date(System.currentTimeMillis()));
        test_date = test_calendar.getTime();  
    }
    
    //Test for TUSCANY-1514
    public void testNullStringToDate() throws Exception {
    	Date result = data_helper.toDate(null);
    	assertEquals(null, result);
    }
    
    private static class TestType
    {
        private static final Class[] DATE_CLASS_ARRAY = {Date.class};
        private static final Class[] CALENDAR_CLASS_ARRAY = {Calendar.class};
        
        Method date_method;
        Method calendar_method;
        int [] compare_fields;  
        
        public TestType (String method_name, int [] compare_fields)
        {
            try
            {
                this.date_method = DataHelper.class.getMethod(method_name, DATE_CLASS_ARRAY);
            }
            catch (NoSuchMethodException e)
            {
                this.date_method = null;
            }
                
            this.compare_fields = compare_fields;    
            try
            {
                this.calendar_method = DataHelper.class.getMethod(method_name, CALENDAR_CLASS_ARRAY);
            }
            catch (NoSuchMethodException e)
            {
                this.calendar_method = null;
            }

        }
        
        public Method getDateMethod()
        {
            return this.date_method;
        }
        
        public Method getCalendarMethod()
        {
            return this.calendar_method;
        }
    }
    
    private static class Test
    {
        String from_type;
        Date from_date;    
        Calendar from_calendar;
        Class expected_exception;
        
        public Test ()
        {
            this.from_date = null;
            this.from_calendar = null;
            expected_exception = null;
        }
        
        public void initialize (TestType from_type)
        {            
            this.from_type = from_type.getDateMethod().getName();
            
            try
            {    
                String date_string = (String) from_type.getDateMethod().invoke(data_helper, new Object[] {test_date});
                
                this.from_date = data_helper.toDate(date_string);
                date_string = (String) from_type.getCalendarMethod().invoke(data_helper, new Object[] {test_calendar});
                this.from_calendar = data_helper.toCalendar(date_string);
            }
            catch (Exception e)
            {
                this.from_date = null;
                this.from_calendar = null;
            }
            
        }
        
        // This method is needed because there is not a toDate(Date) method in DataHelper.
        
        public void initializeToDate()
        {
            this.from_calendar = test_calendar;
            this.from_date = test_date;
            this.from_type = "toDate";
        }
        
        public void attemptConversion (TestType to_type) throws Exception
        {
            executeConversion(to_type.getDateMethod(), new Object[] {this.from_date}, to_type.compare_fields);
            executeConversion(to_type.getCalendarMethod(), new Object[] {this.from_calendar}, to_type.compare_fields);
        }
        
        private void executeConversion (Method conversion, Object[] parm, int [] compare_fields) throws Exception
        {
            String result;
            
            try
            {
                result = (String) conversion.invoke(data_helper, parm);
            }
            catch (Exception e)
            {
                System.err.println("An unexpected exception was thrown while calling " + conversion.getName() + 
                        " after initializing with " + this.from_type + ".");
                throw e;
            }

             assertTrue("The expected value did not result when calling " + conversion.getName() + 
                    " after initializing with " + this.from_type + ".", compareFields(parm[0], result, compare_fields));
        }
        
        private boolean compareFields(Object compare_to, String output, int [] compare_fields)
        {
            Calendar result = data_helper.toCalendar(output);
            Calendar expected;
            
            if (compare_to instanceof Calendar)
                expected = (GregorianCalendar) test_calendar;
            else
            {
                expected = new GregorianCalendar();
                expected.setTime((Date) test_date);
            }
            
            for (int i = 0; i < compare_fields.length; i++)
            {
                if (expected.get(compare_fields[i]) != result.get(compare_fields[i]))
                {
                   System.err.println("Failed: - expected '" + expected.get(compare_fields[i]) + "' got '" + result.get(compare_fields[i]) + "' for output: " + output);
                   return false;
                }
            }
            return true;
        }
        
    }

    public void testConversionsFromDay() throws Exception
    {
        Test FromDay = new Test();
        
        FromDay.initialize(TO_DAY);
        
        FromDay.attemptConversion(TO_DAY);
    }

    public void testConversionsFromDate() throws Exception
    {
        Test FromDate = new Test();
        
        FromDate.initializeToDate();
        
        FromDate.attemptConversion(TO_DATE_TIME);
        FromDate.attemptConversion(TO_DURATION);
        FromDate.attemptConversion(TO_TIME);
        FromDate.attemptConversion(TO_DAY);
        FromDate.attemptConversion(TO_MONTH);
        FromDate.attemptConversion(TO_MONTH_DAY);
        FromDate.attemptConversion(TO_YEAR);
        FromDate.attemptConversion(TO_YEAR_MONTH);
        FromDate.attemptConversion(TO_YEAR_MONTH_DAY);           
    }
  
    public void testConversionsFromDateTime() throws Exception
    {
        Test FromDateTime = new Test();
        
        FromDateTime.initialize(TO_DATE_TIME);

        FromDateTime.attemptConversion(TO_DATE_TIME);
        FromDateTime.attemptConversion(TO_DURATION);
        FromDateTime.attemptConversion(TO_TIME);
        FromDateTime.attemptConversion(TO_DAY);
        FromDateTime.attemptConversion(TO_MONTH);
        FromDateTime.attemptConversion(TO_MONTH_DAY);
        FromDateTime.attemptConversion(TO_YEAR);
        FromDateTime.attemptConversion(TO_YEAR_MONTH);
        FromDateTime.attemptConversion(TO_YEAR_MONTH_DAY);            
    }
    
    public void testConversionsFromDuration() throws Exception
    {
        Test FromDuration = new Test();
        
        FromDuration.initialize(TO_DURATION);

        FromDuration.attemptConversion(TO_DURATION);
        FromDuration.attemptConversion(TO_DATE_TIME);
        FromDuration.attemptConversion(TO_TIME);
        FromDuration.attemptConversion(TO_DAY);
        FromDuration.attemptConversion(TO_MONTH);
        FromDuration.attemptConversion(TO_MONTH_DAY);
        FromDuration.attemptConversion(TO_YEAR);
        FromDuration.attemptConversion(TO_YEAR_MONTH);
        FromDuration.attemptConversion(TO_YEAR_MONTH_DAY);                   
    }
    
    public void testConversionsFromMonth() throws Exception
    {
        Test FromMonth = new Test();
        
        FromMonth.initialize(TO_MONTH);

        FromMonth.attemptConversion(TO_MONTH);           
    } 
    
    public void testConversionsFromMonthDay() throws Exception
    {
        Test FromMonthDay = new Test();
        
        FromMonthDay.initialize(TO_MONTH_DAY);
        FromMonthDay.attemptConversion(TO_MONTH_DAY);
        FromMonthDay.attemptConversion(TO_MONTH);
        FromMonthDay.attemptConversion(TO_DAY);       
    } 

    public void testConversionsFromTime() throws Exception
    {
        Test FromTime = new Test();
        
        FromTime.initialize(TO_TIME);

        FromTime.attemptConversion(TO_TIME);     
    } 

    public void testConversionsFromYear() throws Exception
    {
        Test FromYear = new Test();

        FromYear.initialize(TO_YEAR);

        FromYear.attemptConversion(TO_YEAR);         
    } 
 
    public void testConversionsFromYearMonth() throws Exception
    {
        Test FromYearMonth = new Test();
        
        FromYearMonth.initialize(TO_YEAR_MONTH);

        FromYearMonth.attemptConversion(TO_YEAR_MONTH);
        FromYearMonth.attemptConversion(TO_MONTH);
        FromYearMonth.attemptConversion(TO_YEAR);       
    } 
    
    public void testConversionsFromYearMonthDay() throws Exception
    {
        Test FromYearMonthDay = new Test();
        
        FromYearMonthDay.initialize(TO_YEAR_MONTH_DAY);

        FromYearMonthDay.attemptConversion(TO_YEAR_MONTH_DAY);
        FromYearMonthDay.attemptConversion(TO_YEAR_MONTH);
        FromYearMonthDay.attemptConversion(TO_MONTH_DAY);
        FromYearMonthDay.attemptConversion(TO_YEAR);        
        FromYearMonthDay.attemptConversion(TO_MONTH);
        FromYearMonthDay.attemptConversion(TO_DAY);      
    } 

    // Ensure that strings that should be recognized by toDate do not 
    // result in a null Date value.
    
    public void testToDateFormats() throws Exception
    {
        String[] validStrings = 
        {
            "2006-03-31T03:30:45.123Z",
            "-2006-03-31T03:30:45.1Z",
            "2006-03-31T03:30:45Z",
            "2006-03-31T03:30:45.123",
            "2006-03-31T03:30:45.1",
            "-2006-03-31T03:30:45",
            "2006-03-31T03:30:45.123 EDT",
            "2006-03-31T03:30:45.1 EDT",
            "2006-03-31T03:30:45 EDT",
            "---05 PST",
            "---04",
            "--12 GMT",
            "--12",
            "--08-08 EST",
            "--08-08",
            "1976-08-08 PDT",
            "1976-08-08",
            "88-12 CST",
            "1988-12",
            "2005 CDT",
            "1999",
            "P2006Y 08M 10D T 12H 24M 07S",
            "P2006Y 10D T 12H",
            "-P2006Y 08M 10D T 07S.2",
            "P08M 10D T 07H",
            "-P 04M 10DT12H 24S.88",
            "PT12H"
        };
        
        for (int i = 0; i < validStrings.length; i++)
        {
           assertNotNull("DataHelper.toData() should not return null for '" + validStrings[i] + "'.", 
                   data_helper.toDate(validStrings[i]));
        }

    }
    
    public void testDateTime(){
      // a small bolt on test case resulting from a fix for JIRA TUSCANY-1044
      String date = DataHelper.INSTANCE.toDateTime(DataHelper.INSTANCE.toCalendar("2007-02-04T00:00:00.200Z"));
      assertEquals("2007-02-04T00:00:00.200Z", date);
  }

}

