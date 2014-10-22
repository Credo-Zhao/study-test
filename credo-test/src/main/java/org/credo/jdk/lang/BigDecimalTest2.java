package org.credo.jdk.lang;

import java.math.BigDecimal;

public class BigDecimalTest2
{
	public static void main(String[] args)
	{
		BigDecimal price = new BigDecimal(50);
		BigDecimal quantity = new BigDecimal(2);
		BigDecimal percentageSum = new BigDecimal(100);
		BigDecimal amountSum = new BigDecimal(0);
		for (int i = 0; i < 2; i++)
		{
			percentageSum=percentageSum.add(new BigDecimal(2));
			amountSum=amountSum.add(new BigDecimal(2));
		}
		System.out.println("percentageSum:" + percentageSum);
		System.out.println("amountSum:" + amountSum);
		BigDecimal result = new BigDecimal(0);
		result = price.multiply(percentageSum).divide(new BigDecimal(100)).multiply(quantity).add(amountSum);
		System.out.println(result);
	}
}
