package org.credo.jdk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class StreamConverterTest
{
	private static final String FileName = "file.txt";  
    private static final String CharsetName = "utf-8";  

	public static void main(String[] args) throws IOException
	{
		testWrite();
		testRead();
	}
	
	private static void testWrite() throws IOException {
		File file=new File(FileName);
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(file), CharsetName);
		outputStreamWriter.write("中国人民站起来啦!");
		outputStreamWriter.write("gogogo!\n");
		outputStreamWriter.close();
	}
	
	  private static void testRead() throws IOException {
		  File file = new File(FileName);
		  InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file), CharsetName);
		  char temp=(char) inputStreamReader.read();
		  System.out.println(temp+""+inputStreamReader.read());
		  inputStreamReader.skip(5);
		  if(!inputStreamReader.markSupported()){
			  System.out.println("不支持mark");
		  }
		  char[] buf = new char[2];
		  inputStreamReader.read(buf, 0, buf.length);  
          System.out.println("buf="+(new String(buf)));
		  System.out.println("temp3:"+(char)inputStreamReader.read());
//          inputStreamReader.reset();
//          char temp2=(char) inputStreamReader.read();
//		  System.out.println(temp2);
	  }

}
