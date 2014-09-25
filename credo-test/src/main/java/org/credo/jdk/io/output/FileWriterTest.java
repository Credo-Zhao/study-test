package org.credo.jdk.io.output;

import java.io.FileWriter;

public class FileWriterTest
{
	public static void main(String[] args) throws Exception
	{
		FileWriter fw = new FileWriter("D://test3.txt");
		// windows下使用\r\n换行.Linux下使用\n.
		fw.write("你是谁?你是谁?\r\n");
		fw.write("我!");
		fw.close();
	}
}
