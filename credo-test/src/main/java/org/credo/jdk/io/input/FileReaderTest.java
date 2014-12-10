package org.credo.jdk.io.input;

import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class FileReaderTest
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("D://周报.txt");
		// 创建一个长度为32的字符数组
		char[] cbuf = new char[32];
		int hasRead = 0;
		while ((hasRead = fr.read(cbuf)) > 0)
		{
			System.out.println(new String(cbuf, 0, hasRead));
		}
		
		FileReaderTest fileReaderTest=new FileReaderTest();
		//System.out.println(new String(fileReaderTest.getBytes(cbuf)));
		fr.close();
		// 这些也只是适合英文了.
	}

	private byte[] getBytes(char[] chars)
	{
		Charset cs = Charset.forName("UTF-8");
		CharBuffer cb = CharBuffer.allocate(chars.length);
		cb.put(chars);
		cb.flip();
		ByteBuffer bb = cs.encode(cb);

		return bb.array();
	}
}
