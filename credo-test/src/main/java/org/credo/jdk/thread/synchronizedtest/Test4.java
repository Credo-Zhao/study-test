package org.credo.jdk.thread.synchronizedtest;

/**
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“
 * synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 * 
 * @author ZhaoQian
 */
public class Test4
{
	public static void main(String[] args)
	{
		//两个线程都使用runner一个对象
		final Runer runner=new Runer();
		Thread t1=new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				runner.synchronizedMethod();
			}
		});
		
		Thread t2=new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				runner.synchronizedMethod();
			}
		});
		
		t1.start();
		t2.start();
	}
}
