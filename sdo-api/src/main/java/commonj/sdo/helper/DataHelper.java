/**
 * <copyright>
 *
 * Service Data Objects
 * Version 2.0
 * Licensed Materials - Property of BEA and IBM
 *
 * (c) Copyright BEA Systems, Inc. and International Business Machines Corp 2005.  All rights reserved.
 *
 * </copyright>
 * 
 */

package commonj.sdo.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import commonj.sdo.impl.HelperProvider;

/**
 * Data helper methods.
 */
public interface DataHelper
{
  /**
   * Convert from a String representation of an SDO date type to a Date.
   * @param dateString the String representation of an SDO date type
   * @return a Date representation of an SDO date type.
   * @throws IllegalArgumentException for invalid formats.
   */
  Date toDate(String dateString);
  
  /**
   * Convert from a String representation of an SDO date type to a Calendar using the
   * default locale.  Same as toCalendar(dateString, null).
   * @param dateString the String representation of an SDO date type
   * @return a Calendar representation of an SDO date type.
   * @throws IllegalArgumentException for invalid formats.
   */
  Calendar toCalendar(String dateString);
  
  /**
   * Convert from a String representation of an SDO date type to a Calendar using the
   * specified locale, or the default locale if the locale is null.
   * @param dateString the String representation of an SDO date type
   * @param locale the locale or null for default locale.
   * @return a Calendar representation of an SDO date type.
   * @throws IllegalArgumentException for invalid formats.
   */
  Calendar toCalendar(String dateString, Locale locale);

  /**
   * Convert from a Date to a String representation of the DateTime type.
   * @param date the date
   * @return a Date to a String representation of the DateTime type.
   */
  String toDateTime(Date date);
  
  /**
   * Convert from a Date to a String representation of the Duration type.
   * @param date the date
   * @return a Date to a String representation of the Duration type.
   */
  String toDuration(Date date);

  /**
   * Convert from a Date to a String representation of the Time type.
   * @param date the date
   * @return a Date to a String representation of the Time type.
   */
  String toTime(Date date);
  
  /**
   * Convert from a Date to a String representation of the Day type.
   * @param date the date
   * @return a Date to a String representation of the Day type.
   */
  String toDay(Date date);
  
  /**
   * Convert from a Date to a String representation of the Month type.
   * @param date the date
   * @return a Date to a String representation of the Month type.
   */
  String toMonth(Date date);

  /**
   * Convert from a Date to a String representation of the MonthDay type.
   * @param date the date
   * @return a Date to a String representation of the MonthDay type.
   */
  String toMonthDay(Date date);

  /**
   * Convert from a Date to a String representation of the Year type.
   * @param date the date
   * @return a Date to a String representation of the Year type.
   */
  String toYear(Date date);

  /**
   * Convert from a Date to a String representation of the YearMonth type.
   * @param date the date
   * @return a Date to a String representation of the YearMonth type.
   */
  String toYearMonth(Date date);

  /**
   * Convert from a Date to a String representation of the YearMonthDay type.
   * @param date the date
   * @return a Date to a String representation of the YearMonthDay type.
   */
  String toYearMonthDay(Date date);

  /**
   * Convert from a Calendar to a String representation of the DateTime type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the DateTime type.
   */
  String toDateTime(Calendar calendar);

  /**
   * Convert from a Calendar to a String representation of the Duration type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the Duration type.
   */
  String toDuration(Calendar calendar);

  /**
   * Convert from a Calendar to a String representation of the Time type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the Time type.
   */
  String toTime(Calendar calendar);

  /**
   * Convert from a Calendar to a String representation of the Day type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the Day type.
   */
  String toDay(Calendar calendar);

  /**
   * Convert from a Calendar to a String representation of the Month type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the Month type.
   */
  String toMonth(Calendar calendar);

  /**
   * Convert from a Calendar to a String representation of the MonthDay type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the MonthDay type.
   */
  String toMonthDay(Calendar calendar);

  /**
   * Convert from a Calendar to a String representation of the Year type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the Year type.
   */
  String toYear(Calendar calendar);

  /**
   * Convert from a Calendar to a String representation of the YearMonth type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the YearMonth type.
   */
  String toYearMonth(Calendar calendar);

  /**
   * Convert from a Calendar to a String representation of the YearMonthDay type.
   * @param calendar the calendar to convert
   * @return a Calendar to a String representation of the YearMonthDay type.
   */
  String toYearMonthDay(Calendar calendar);
  
  /**
   * The default TypeHelper.
   */
  DataHelper INSTANCE = HelperProvider.getDataHelper();
}
