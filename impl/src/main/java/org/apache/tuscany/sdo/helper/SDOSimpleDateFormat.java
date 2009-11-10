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

package org.apache.tuscany.sdo.helper;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Fixes the bug reported at JIRA TUSCANY-1659
 * This class ensures the time zone will be formatted as the abbreviation format.
 */
public class SDOSimpleDateFormat extends SimpleDateFormat {
	
	private static final long serialVersionUID = 2519728288048681529L;
	
	public SDOSimpleDateFormat() {
		super();
		setTimeZone(getTimeZone());
		
	}
	
	public SDOSimpleDateFormat(String pattern) {
		super(pattern);
		setTimeZone(getTimeZone());
		
	}
	
	public SDOSimpleDateFormat(String pattern, Locale locale) {
		super(pattern, locale);
		setTimeZone(getTimeZone());
		
	}
	
	public SDOSimpleDateFormat(String pattern, DateFormatSymbols formatSymbols) {
		super(pattern, formatSymbols);
		setTimeZone(getTimeZone());
		
	}

	/**
	 * Overrides the SimpleDateFormat.setTimeZone(TimeZone) method. 
	 * It checks if the TimeZone to be set is in the abbreviation format. 
	 * If not, it looks for its abbreviation format and set it.  
	 * 
	 * @param timeZone the time zone to be set
	 * 
	 */
	public void setTimeZone(TimeZone timeZone) {
		
		if (timeZone.getID().length() != 3) {
			String[] timeZoneNames = TimeZone.getAvailableIDs(timeZone.getRawOffset());
			
			for (int i = 0 ; i < timeZoneNames.length ; i++ ) {
				String actualTimeZoneName = timeZoneNames[i].trim();
				
				// if the time zone name has 3 letters and ends with a T character, 
				// it's considered to be the abbreviation format
				if (actualTimeZoneName.length() == 3 && actualTimeZoneName.charAt(actualTimeZoneName.length() - 1) == 'T') {
					timeZone = TimeZone.getTimeZone(timeZoneNames[i]);
					break;
					
				}
				
			}
			
		}
		
		super.setTimeZone(timeZone);
		
	}

}
