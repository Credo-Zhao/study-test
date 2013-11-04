package org.credo.lang;
import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
			BigDecimalTest aaa = null;
			System.out.println("aaa:"+aaa);
			//System.out.println("2:"+aaa.intValue()); java.lang.NullPointerException
			
			BigDecimal bbb=new BigDecimal(0);
			System.out.println("bbb:"+bbb);
			System.out.println("2:"+bbb.intValue());
	}

}
