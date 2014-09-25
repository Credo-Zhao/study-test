package org.credo.jdk.io.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamTest
{

	public static void main(String[] args) throws Exception
	{
		//创建字节输入流
        @SuppressWarnings("resource")
        FileInputStream fis=new FileInputStream("D://test.txt");
        FileOutputStream fos=new FileOutputStream("D://test2.txt");
         
        byte[] bytes=new byte[1024];
        int hasRead=0;
        while ((hasRead=fis.read(bytes))>0) {
            fos.write(bytes, 0, hasRead);
        }
        fos.close();
	}

}
