package org.credo.jdk.io.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Sender implements Runnable
{
	private PipedOutputStream out=new PipedOutputStream();
	
	@Override
	public void run()
	{
		writeShortMessage();
	}
	
	// 向“管道输出流”中写入一则较简短的消息："this is a short message"   
	public void writeShortMessage() {
		String message="this is a short message.";
		try
		{
			System.out.printf("%s --will send this message: %s \n",Thread.currentThread().getName(),message);  
			out.write(message.getBytes("UTF-8"));
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	// 向“管道输出流”中写入一则较长的消息
	public void writeLongMessage() {
		StringBuilder sb = new StringBuilder();  
        // 通过for循环写入1020个字节  
        for (int i=0; i<102; i++)  
            sb.append("0123456789");  
        // 再写入26个字节。  
        sb.append("abcdefghijklmnopqrstuvwxyz");  
        // str的总长度是1020+26=1046个字节  
        String str = sb.toString();  
        try {  
            // 将1046个字节写入到“管道输出流”中  
            out.write(str.getBytes());  
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}

	public PipedOutputStream getOut()
	{
		return out;
	}

	public void setOut(PipedOutputStream out)
	{
		this.out = out;
	}

}
