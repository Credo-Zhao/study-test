package org.credo.jdk.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 *接收线程.
 */
public class Receiver implements Runnable
{
	private PipedInputStream in=new PipedInputStream();
	
	@Override
	public void run()
	{
		this.readMessageOnce();
	}
	
	//从管道输入流中读取一次数据
	public void readMessageOnce() {
		// 虽然bytes的大小是2048个字节，但最多只会从“管道输入流”中读取1024个字节。  
        // 因为，“管道输入流”的缓冲区大小默认只有1024个字节。  
		byte[] bytes=new byte[2048];
		try
		{
			int len=in.read(bytes);
			System.out.printf("%s --receive this message: %s \n",Thread.currentThread().getName(),new String(bytes,0,len));  
            in.close(); 
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public PipedInputStream getIn()
	{
		return in;
	}

	public void setIn(PipedInputStream in)
	{
		this.in = in;
	}
	
	
	

	

}
