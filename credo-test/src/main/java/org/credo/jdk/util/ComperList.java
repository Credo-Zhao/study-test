package org.credo.jdk.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class ComperList {
	
//	public static void main(String[] args) throws ParseException {
//
//		List<Users> list=new ArrayList<>();
//		
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String t5 = "2013-10-12";
//		Date time5= df.parse(t5);
//		list.add(new Users("5",time5));
//		
//		String t1 = "2008-10-12";
//		Date time1 = df.parse(t1);
//		list.add(new Users("1",time1));
//		
//		String t2 = "2009-10-12";
//		Date time2 = df.parse(t2);
//		list.add(new Users("2",time2));
//		
//		list.add(new Users("3",null));
//		list.add(new Users("4",null));
//		
//		Collections.sort(list, new compareReservationRate());
//		
//		for(Users users:list) {
//			System.out.println(users.getName()+users.getTime());
//		}
//	}
}
//class compareReservationRate implements Comparator<Users> {
//
//	@Override
//	public int compare(Users o1, Users o2) {
//		System.out.println("============="+o1.getName()+o1.getTime());
//		if(o1.getTime()==null) {
//			return -1;
//		}if(o2.getTime()==null) {
//			return 1;
//		}
//		return o1.getTime().compareTo(o2.getTime());
//	}
//}