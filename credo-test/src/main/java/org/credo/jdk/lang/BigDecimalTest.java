package org.credo.jdk.lang;
import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		double totalPrice = 1.12;
		for(int i=0;i<6;i++){
			totalPrice=totalPrice+1.13534;
		}
		BigDecimal b = new BigDecimal(Double.toString(totalPrice * 0.17));
		BigDecimal one = new BigDecimal("1");
		double varPrice = b.divide(one, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(totalPrice);
		System.out.println(varPrice);
		System.out.println(totalPrice * 0.17);
	}

}
