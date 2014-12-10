package org.credo.jdk.thread.synchronizedtest;

/**
 * @author ZhaoQian
 *         当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“
 *         该对象”的非同步代码块。
 */
 class Runer
{
	public void synchronizedMethod()
	{
		synchronized (this)
		{
			for (int i = 0; i < 5; i++)
			{
				try
				{
					Thread.sleep(100);
					// 休眠100ms
					System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public void noSynchronizedMethod()
	{
		try
		{
			for (int i = 0; i < 5; i++)
			{
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);
			}
		} catch (InterruptedException ie)
		{
		}
	}
}
public class Test3 {

	public static void main(String[] args)
	{
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
				runner.noSynchronizedMethod();
			}
		});
		
		t1.start();
		t2.start();
	}
	
}