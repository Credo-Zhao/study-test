package org.credo.jdk.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileStreamTest
{

	public static void main(String[] args)
	{
		try
		{
			testWrite();
			testRead();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static final String FileName = "FileStreamTest.txt";

	public static void testWrite() throws IOException
	{
		File file = new File(FileName);

		// 创建文件“file.txt”对应的FileOutputStream对象，默认是关闭“追加模式”
		FileOutputStream fileOutStream = new FileOutputStream(file);
		// 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
		PrintStream ps = new PrintStream(fileOutStream);
		ps.print("abcde");
		ps.close();

		// 创建文件“file.txt”对应的FileOutputStream对象，打开“追加模式”
		FileOutputStream fileOut2 = new FileOutputStream(file, true);
		PrintStream ps2 = new PrintStream(fileOut2);
		ps2.print("123456789");
		ps2.close();

	}

	public static void testRead() throws IOException
	{
		File file = new File(FileName);

		FileInputStream in1 = new FileInputStream(file);
		FileInputStream in2 = new FileInputStream(FileName);

		// 方法3：新建FileInputStream对象 , 获取文件“file.txt”对应的“文件描述符”
		FileDescriptor fdin = in2.getFD();
		// 根据“文件描述符”创建“FileInputStream”对象
		FileInputStream in3 = new FileInputStream(fdin);

		// 测试read()，从中读取一个字节
		char c1 = (char) in1.read();
		System.out.println("c1=" + c1);
		
		// 测试skip(long byteCount)，跳过4个字节  
        in1.skip(4);  

        // 测试read(byte[] buffer, int byteOffset, int byteCount)  
        byte[] buf = new byte[4];  
        in1.read(buf, 0, buf.length);  
        System.out.println("buf="+(new String(buf)));  


        // 创建“FileInputStream”对象对应的BufferedInputStream  
        BufferedInputStream bufIn = new BufferedInputStream(in3);  
        // 读取一个字节  
        char c2 = (char)bufIn.read();  
        System.out.println("c2="+c2);  

        in1.close();  
        in2.close();  
        in3.close();  
	}

}
