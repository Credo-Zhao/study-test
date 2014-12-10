package org.credo.jdk.thread.synchronizedtest;

/**
 * run()方法中存在“synchronized(this)代码块”，而且t1和t2都是基于"demo这个Runnable对象"创建的线程。这就意味着，
 * 我们可以将synchronized
 * (this)中的this看作是“r这个Runnable对象”；因此，线程t1和t2共享“demo对象的同步锁”。所以
 * ，当一个线程运行的时候，另外一个线程必须等待“运行线程”释放“demo的同步锁”之后才能运行。
 * 
 * @author ZhaoQian
 */
public class Test2
{

	public static void main(String[] args)
	{
//		Runnable r = new MyRunable2();
//
//		Thread t1 = new Thread(r, "aa");
//		Thread t2 = new Thread(r, "bb");
//
//		t1.start();
//		t2.start();
		
		Runnable r1 = new MyRunable2();
		Runnable r2 = new MyRunable2();
		Thread ta = new Thread(r1, "aa2");
		Thread tb = new Thread(r2, "bb2");
		ta.start();
		tb.start();
	}

}
//锁的对象是MyRunable,所以要确定是不是同一个MyRunable.
class MyRunable2 implements Runnable
{

	@Override
	public void run()
	{
		//获取了MyRunable对象的锁
		synchronized (this)
		{
			try
			{
				for (int i = 0; i < 5; i++)
				{
					Thread.sleep(100); // 休眠100ms
					System.out.println(Thread.currentThread().getName() + " loop " + i);
				}
			} catch (InterruptedException ie)
			{
			}
		}
	}
}