package org.credo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;

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

	public static void main(String[] args) {

		Date startDate = new Date();
		Date endDate=new Date(114, 6, 8);
		System.out.println(endDate);
		DateTime dt=new DateTime(endDate);
		System.out.println(dt.toString("yyyy-MM-dd hh:mm:ss"));
		
		Long la=endDate.getTime()-startDate.getTime();
		System.out.println(la);
		double d=la/1000/3600;
		System.out.println("D:"+d);
		String result0=String.format("%.2f", d);
		System.out.println("---"+result0);
		System.out.println("D:"+d/24);
		String result=String.format("%.2f", -11.23644);
		System.out.println(Double.parseDouble(result));
		

//		Interval interval = new Interval(startDate.getTime(), endDate.getTime());
//		Period period = interval.toPeriod();
//
//		System.out.printf("%d years, %d months, %d days, %d hours, %d minutes, %d seconds%n", period.getYears(), period.getMonths(), period.getDays(), period.getHours(),
//				period.getMinutes(), period.getSeconds());

	}
}
