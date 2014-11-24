package org.credo.jdk.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamTest
{

	public static void main(String[] args) throws IOException
	{
		bufferedInputStreamTest();
	}
	
	public static void bufferedInputStreamTest() throws IOException {
		File file = new File("FileStreamTest.txt");
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file),512);
		 // 从字节流中读取5个字节。“abcde”，a对应0x61，b对应0x62，依次类推...  
        for (int i=0; i<5; i++) {  
            // 若能继续读取下一个字节，则读取下一个字节  
            if (bis.available() >= 0) {  
                // 读取“字节流的下一个字节”  
                int tmp = bis.read();  
                System.out.printf("%d : 0x%s\n", i, Integer.toHexString(tmp));  
            }  
        }
     // 若“该字节流”不支持标记功能，则直接退出  
        if (!bis.markSupported()) {  
            System.out.println("make not supported!");  
            return ;  
        }  
            
        // 标记“当前索引位置”，即标记第6个位置的元素--“f”  
        // 1024对应marklimit  
        bis.mark(1024);  

        // 跳过22个字节。  
        bis.skip(22);  

        // 读取5个字节  
        byte[] buf = new byte[5];  
        bis.read(buf, 0, 5);  
        // 将buf转换为String字符串。  
        String str1 = new String(buf);  
        System.out.printf("str1=%s\n", str1);  

        // 重置“输入流的索引”为mark()所标记的位置，即重置到“f”处。  
        bis.reset();  
        // 从“重置后的字节流”中读取5个字节到buf中。即读取“fghij”  
        bis.read(buf, 0, 5);  
        // 将buf转换为String字符串。  
        String str2 = new String(buf);  
        System.out.printf("str2=%s\n", str2);  

        bis.close(); 
	}

}
