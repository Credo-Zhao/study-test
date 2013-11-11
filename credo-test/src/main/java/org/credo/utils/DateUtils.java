package org.credo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String dateToString(Date date, String formatStr) {
		if (date == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(date);
	}

	public static Date stringToDate(String str, String formatStr) {

		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			return format.parse(str);
		} catch (ParseException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
