package org.credo.jdk.lang;

import java.util.Locale;

import org.joda.time.DateTime;

public class ReplaceTest
{

	public static void main(String[] args)
	{
		DateTime dateTime = new DateTime();
		//dateTime = dateTime.minusHours(2);
		String dt = dateTime.toString("yy-MM-dd ah:mm", Locale.CHINESE);
		String[] result = dt.split(" ");
		System.out.println(result[0]);
		System.out.println(result[1]);

	}

}
