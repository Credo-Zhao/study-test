package org.credo.lang;

/**
 * 结论:Boolean类型默认可以设置为null.但在页面进行选择,一旦初始化,就无法返回为null.只有true/false.
 * 有三种选择的情况下还是放弃使用Boolean.
 *
 */
public class BooleanTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Boolean bb = null;
		System.out.println(bb);
	}

}
