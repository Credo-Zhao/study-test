package org.credo.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class number {

	public static void main(String[] args) {

//		System.out.println(("123123123").matches("^\\d+$"));
//		System.out.println(("12312aaa3123").matches("^\\d+$"));
		
		List<String> list=new ArrayList<String>();
		System.out.println(list.isEmpty());
		list.add("");
		System.out.println(list.isEmpty());
		
		List<String> list1=null;
		System.out.println(list1.isEmpty());
	}
	
	public void initCountry() {

		String[] locales = Locale.getISOCountries();
		for ( String countryCode : locales )
		{
			Locale obj = new Locale("", countryCode);
		}
	}

}
