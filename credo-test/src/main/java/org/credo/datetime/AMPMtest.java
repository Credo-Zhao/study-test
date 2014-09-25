package org.credo.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class AMPMtest {
	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd aah:mm", Locale.CHINESE);
		String dateTime1 = sdf.format(new Date());
		System.out.println(dateTime1);
		String[] result = dateTime1.split(" ");
		System.out.println(result[0]);
		System.out.println(result[1]);

		System.out.println("===============");
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		String dateTime2 = df.format(new Date());
		String[] result2 = dateTime2.split(" ");

		System.out.println(result2[0]);
		System.out.println(result2[1]);

		System.out.println("===============");
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

		// 时间解析
		// DateTime dateTime = SystemFactory.getClock().getDateTime();
		DateTime dateTime = new DateTime();
		String string_c11 = dateTime.toString("yy-MM-dd aah:mm", Locale.CHINESE);
		System.out.println(string_c11);
		String[] result3 = string_c11.split(" ");
		System.out.println(result3[0]);
		System.out.println(result3[1]);

		// 时间格式化，输出==> 2012/12/21 23:22:45 Fri
		String string_u = dateTime.toString("yyyy/MM/dd HH:mm:ss EE");
		System.out.println(string_u);

		// 格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五
		String string_c = dateTime.toString("yyyy年MM月dd日 HH:mm:ss EE", Locale.CHINESE);
		System.out.println(string_c);

	}
}
