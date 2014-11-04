package org.credo.jdk.io.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;

public class FileReaderTest2
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream fileIn=new FileInputStream("D://周报.txt");
		System.out.println(IOUtils.toString(fileIn,"GBK"));
		System.out.println("=========="+System.getProperty("file.encoding"));
		
		InputStreamReader isr=new InputStreamReader(new FileInputStream("D://周报.txt"),"GBK");
		System.out.println(IOUtils.toString(isr));
		
	}

}
