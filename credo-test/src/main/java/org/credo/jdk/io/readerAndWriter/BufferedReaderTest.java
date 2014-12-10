package org.credo.jdk.io.readerAndWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest
{

	public static void main(String[] args) throws IOException
	{
		testBufferedReader();
	}

	public static void testBufferedReader() throws IOException
	{
		// 创建BufferedReader字符流，内容是ArrayLetters数组
		File file = new File("bufferedreader.txt");

		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		for (int i = 0; i < 5; i++)
		{
			if (bufferedReader.ready())
			{
				int temp = bufferedReader.read();
				System.out.printf("%d : %c\n", i, temp);
			}
		}
		// 若“该字符流”不支持标记功能，则直接退出
		if (!bufferedReader.markSupported())
		{
			System.out.println("make not supported!");
			return;
		}
		// 标记“当前索引位置”，即标记第6个位置的元素--“f”
		// 1024对应marklimit
		bufferedReader.mark(1024);

		// 跳过22个字符。
		bufferedReader.skip(10);

		// 读取5个字符
		char[] buf = new char[5];
		bufferedReader.read(buf, 0, 5);
		System.out.printf("buf=%s\n", String.valueOf(buf));
		// 读取该行剩余的数据
		System.out.printf("readLine=%s\n", bufferedReader.readLine());
		// 重置“输入流的索引”为mark()所标记的位置，即重置到“f”处。
		bufferedReader.reset();
		// 从“重置后的字符流”中读取5个字符到buf中。即读取“fghij”
		bufferedReader.read(buf, 0, 5);
		System.out.printf("buf=%s\n", String.valueOf(buf));

		bufferedReader.close();
	}

}
