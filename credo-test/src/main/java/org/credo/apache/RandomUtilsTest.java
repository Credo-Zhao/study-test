package org.credo.apache;

import org.apache.commons.lang.RandomStringUtils;

public class RandomUtilsTest {

	public static void main(String[] args) {

		String num = RandomStringUtils.random(6, false, true);
		System.out.println(num);
		
		String n2=RandomStringUtils.randomAlphanumeric(6);
		System.out.println(n2);
		
		String n3=RandomStringUtils.randomNumeric(6);
		System.out.println(n3);
		
		String num4 = RandomStringUtils.random(6, true, true);
		System.out.println(num4);
		
				
	}
}
