package org.credo.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.impl.cookie.DateUtils;

public class DateTest {

	public static void main(String[] args) {
		System.out.println((new Date().toString()));
		Date date=new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd-HH:mm:ss");
		System.out.println(format.format(date));
		System.out.println(DateUtils.formatDate(new Date(),"yyMMdd-HH:mm:ss"));
	}

}
