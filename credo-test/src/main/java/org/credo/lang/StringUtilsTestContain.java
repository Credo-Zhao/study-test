package org.credo.lang;

import org.apache.commons.lang.StringUtils;


public class StringUtilsTestContain {
	
	public static void main(String[] args) {

		Boolean bol=StringUtils.contains("您好确认成功确认了这个零件", "成功确认");
		System.out.println(bol);
		
		Boolean bol0=StringUtils.contains("您好确认成功123确认了这个零件", "成功确认");
		System.out.println(bol0);
		
		Boolean bol1=StringUtils.contains("零件号无效", "成功确认");
		System.out.println(bol1);
	}
}
