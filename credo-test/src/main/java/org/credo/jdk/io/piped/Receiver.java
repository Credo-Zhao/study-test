package org.credo.jdk.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 接收线程.
 */
public class Receiver implements Runnable
{
	private PipedInputStream in = new PipedInputStream();

	@Override
	public void run()
	{
		// this.readMessageOnce();
		this.readMessageContinued();
	}

	// 从管道输入流中读取一次数据
	public void readMessageOnce()
	{
		// 虽然bytes的大小是2048个字节，但最多只会从“管道输入流”中读取1024个字节。
		// 因为，“管道输入流”的缓冲区大小默认只有1024个字节。
		byte[] bytes = new byte[2048];
		try
		{
			int len = in.read(bytes);
			System.out.printf("%s --receive this message: %s \n", Thread.currentThread().getName(), new String(bytes,
					0, len));
			in.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	// 从“管道输入流”读取>1024个字节时，就停止读取
	public void readMessageContinued()
	{
		int total = 0;
		byte[] bytes = new byte[1024];
		while (Boolean.TRUE)
		{
			try
			{
				int len = in.read(bytes);
				if (len > 0)
				{
					total += len;
					System.out.printf("%s --receive this message: %s \n", Thread.currentThread().getName(), new String(bytes,
							0, len));
				}else {
					System.out.println("len -1 ,break");
					break;
				}
				// 若读取的字节总数>1024，则退出循环。
//				if (total > 1024)
//				{
//					System.out.println("total > 1024 ,break");
//					break;
//				}

			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		try
		{
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
