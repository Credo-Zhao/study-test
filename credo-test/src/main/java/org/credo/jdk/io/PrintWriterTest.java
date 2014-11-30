package org.credo.jdk.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest
{

	public static void main(String[] args)
	{
		testPrintWriterConstrutor1();
		testPrintWriterAPIS();
	}

	private static void testPrintWriterConstrutor1()
	{
		final char[] arr = { 'a', 'b', 'c', 'd', 'e' };
		try
		{
			// 创建文件“file.txt”的File对象
			File file = new File("file.txt");
			// 创建文件对应FileOutputStream
			PrintWriter out = new PrintWriter(new FileOutputStream(file));
			// 将“字节数组arr”全部写入到输出流中
			out.write(arr);
			// 关闭输出流
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void testPrintWriterConstrutor2()
	{
		final char[] arr = { 'a', 'b', 'c', 'd', 'e' };
		try
		{
			File file = new File("file.txt");
			PrintWriter out = new PrintWriter(file);
			out.write(arr);
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void testPrintWriterConstrutor3()
	{
		final char[] arr = { 'a', 'b', 'c', 'd', 'e' };
		try
		{
			PrintWriter out = new PrintWriter("file.txt");
			out.write(arr);
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void testPrintWriterAPIS() {  
        final char[] arr={'a', 'b', 'c', 'd', 'e' };  
        try {  
            // 创建文件对应FileOutputStream  
            PrintWriter out = new PrintWriter("other.txt");  
 
            // 将字符串“hello PrintWriter”+回车符，写入到输出流中  
            out.println("hello PrintWriter");  
            // 将0x41写入到输出流中  
            // 0x41对应ASCII码的字母'A'，也就是写入字符'A'  
            out.write(0x41);  
            // 将字符串"65"写入到输出流中。  
            // out.print(0x41); 等价于 out.write(String.valueOf(0x41));  
            out.print(0x41);  
            // 将字符'B'追加到输出流中  
            out.append('B').append("CDEF");  
 
            // 将"CDE is 5" + 回车  写入到输出流中  
            String str = "GHI";  
            int num = 5;  
            out.printf("%s is %d\n", str, num);  
 
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

}
