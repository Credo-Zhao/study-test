package org.credo.jdk.io.input;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * InputStream和Reader是所有输入流的抽象基类.本身并不能创建实例来执行输入.但它们是所有输入流的模板.它们的方法是所有输入流可使用的方法.
 * @author Credo
 */
public class InputStreamTest
{
	public static void main(String[] args) throws IOException
	{
		// 创建字节输入流
        FileInputStream fis = new FileInputStream("D://test.txt");
        // 创建一个长度为1024的竹筒,放字节流
        byte[] bbuf = new byte[50];
        System.out.println(fis.markSupported());
        System.out.println(bbuf.length);
        // 用于保存实际读取的字节数
        int hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0) {
            // 取出竹筒中的字节,将字节数组转换为字符串输入.
            System.out.println("AAA:"+new String(bbuf, 0, hasRead));
            System.out.println(fis.read(bbuf) );
        }
        // 如果bbuf是全部的字节,而非1024这么的,可以这样字节输出windows系统下的文件内容,win7默认中文GBK.
        System.out.println(new String(bbuf, "GBK"));
        fis.close();
	}
}
