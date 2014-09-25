package org.credo.datetime;

import org.joda.time.DateTime;


public class jodaTime50 {
	public static void main(String[] args) {

		DateTime now =new DateTime();
		DateTime before=now.minusDays(50);
		System.out.println(now.toString("YY-MM-dd"));
		System.out.println(before.toString("YY-MM-dd"));
	}
}
