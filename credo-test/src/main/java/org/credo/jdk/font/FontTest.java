package org.credo.jdk.font;

import java.awt.GraphicsEnvironment;

public class FontTest {

	public static void main(String[] args) {
		String[] fontnames = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();// 获得当前系统字体

		for (int i = 0; i < fontnames.length; i++) {// 输出所有字体
			//System.out.println(fontnames[i]);
		}
		
		String systemRoot = System.getenv().get("SystemRoot");
		System.out.println(systemRoot);

	}
	

}
