package org.credo.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;


public class joda11Oct14
{

	public static void main(String[] args) throws ParseException
	{
		String dateTime="11-Oct-14 04:31:31";
		
//		SimpleDateFormatmat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		java.util.Date date11 = df1.parse("2010-6-2 16:10:38.00");
//		String time = df1.format(date11);
//		Timestamp ts = Timestamp.valueOf(time);
//		System.out.println(ts);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy hh:mm:ss",Locale.ENGLISH);
		Date date=sdf.parse(dateTime);
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		String date2=sdf2.format(date);
		System.out.println(date2);
		DateTime dt=new DateTime();
		String date3=dt.toString("yyyy-MM-dd");
		System.out.println(date3);
		System.out.println(StringUtils.equalsIgnoreCase(date2, date3));
		
	}
}
