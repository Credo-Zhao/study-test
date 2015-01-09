package org.credo.jdk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class number {

	public static void main(String[] args) throws ParseException {

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-12-12T17:36:42"));
	}
	
	public void initCountry() {

		String[] locales = Locale.getISOCountries();
		for ( String countryCode : locales )
		{
			Locale obj = new Locale("", countryCode);
		}
	}

}
