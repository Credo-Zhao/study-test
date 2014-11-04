package org.credo.jdk.io.output;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest
{

	public static void main(String[] args) throws FileNotFoundException
	{
		PrintStream ps=new PrintStream("D://123.txt");
		ps.print("aaaaa");
	}

}
