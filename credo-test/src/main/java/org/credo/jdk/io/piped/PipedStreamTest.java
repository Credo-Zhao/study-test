package org.credo.jdk.io.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamTest
{

	public static void main(String[] args) throws IOException
	{
		Sender sender=new Sender();
		Receiver receiver=new Receiver();
		
		PipedOutputStream out=sender.getOut();
		PipedInputStream in=receiver.getIn();
		
		//管道连接。下面2句话的本质是一样。  
        //out.connect(in);     
		in.connect(out);
		
		new Thread(sender,"sender").start();
		new Thread(receiver,"receiver").start();
	}

}
