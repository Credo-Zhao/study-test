package org.credo.jdk.thread.synchronizedtest;

/**
 * @author ZhaoQian
 */
public class Test1
{

	public static void main(String[] args)
	{
		//下面的t1,t2都是属于r的子线程.共用r,因此获取的锁对象都是r
		Thread r = new MyThread("TTTTT");

		Thread t1 = new Thread(r, "aa");
		Thread t2 = new Thread(r, "bb");

		t1.start();
		t2.start();
		
		//下面new了2个myThread对象,获取的锁对象分别都是t1,t2
//		Thread t1 = new MyThread("t1"); // 新建“线程t1”
//		Thread t2 = new MyThread("t2"); // 新建“线程t2”
//		t1.start(); // 启动“线程t1”
//		t2.start(); // 启动“线程t2”
	}

}

class MyThread extends Thread
{
	public MyThread(String name) {
        super(name);
    }
	
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