package org.credo.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class Str2time {

	public static void main(String[] args) throws ParseException {

		String s1 = "2014-03-13 06:47:08 UTC";
		java.text.DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 'UTC'");
		Date d = df1.parse(s1);
		java.text.DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s2 = df2.format(d);
		System.out.println("Debug: s2=" + s2);

	}
}
