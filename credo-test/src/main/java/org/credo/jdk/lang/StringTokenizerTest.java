package org.credo.jdk.lang;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringTokenizer tokenizer = new StringTokenizer("updatedOn.arr", ".");
		while (tokenizer.hasMoreTokens())
			System.out.println(tokenizer.nextToken());

	}

}
