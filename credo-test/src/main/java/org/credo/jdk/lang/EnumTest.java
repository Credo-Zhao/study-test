package org.credo.jdk.lang;

import org.credo.model.EnumUsed;

/**
 * 循环枚举
 * @author Credo
 *
 */
public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(EnumUsed temp:EnumUsed.values()){
			System.out.println(temp);
			System.out.println(temp.toString());
		}

	}

}
