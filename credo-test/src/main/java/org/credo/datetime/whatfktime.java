package org.credo.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;


public class whatfktime {
	public static void main(String[] args) throws ParseException {
		
//		//16-9月-2014 13:28:37  UTC
//		DateTime dateTime = new DateTime();
//		String dt = dateTime.toString("dd-M月-yyyy hh:mm:ss z", Locale.CHINESE);
//		System.out.println(dt);
////		/dd-M月-yyyy hh:mm:ss z yyyy-MM-dd hh:mm:ss
//		DateTime dateTime2=new DateTime(dt);
//		System.out.println(dateTime2.toString("dd-M月-yyyy hh:mm:ss z"));
		
		
		String s1 = "16-9月-2014 13:28:37 UTC";
        java.text.DateFormat df1 = new SimpleDateFormat("dd-M月-yyyy HH:mm:ss 'UTC'");
        Date d = df1.parse(s1);
        java.text.DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2 = df2.format(d);
        System.out.println("Debug: s2=" + s2);
	}
}
