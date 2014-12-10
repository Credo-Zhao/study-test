package org.credo.jdk.io.readerAndWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferedWriterTest
{

	public static void main(String[] args)
	{
		try
		{
			testBufferedWriter();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static final char[] ArrayLetters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void testBufferedWriter() throws IOException {
		File file = new File("bufferedreader.txt");
		BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));
		bufferedWriter.write(ArrayLetters);
		bufferedWriter.write('\n');  
		bufferedWriter.close(); 
		readUserInput();
	}
	
	private static void readUserInput() {  
        System.out.println("please input a text:");  
        Scanner reader=new Scanner(System.in);  
        // 等待一个输入  
        String str = reader.next();  
        System.out.printf("the input is : %s\n", str);  
    }  
}
