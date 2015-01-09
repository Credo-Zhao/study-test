package org.credo.jdk.thread.jdklock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock
{
	private int money = 0;
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {  
		TestReentrantLock mDepot = new TestReentrantLock();
        ProducerA mPro = new ProducerA(mDepot);
        CustomerA mCus = new CustomerA(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
        
    }

	public void produce(int val)
	{
		lock.lock();
		try
		{
			money = money + val;
			System.out.printf("%s produce(%d) --> size=%d\n",Thread.currentThread().getName(), val, money);
		} finally
		{
			lock.unlock();
		}
	}

	public void consume(int val)
	{
		lock.lock();
		try
		{
			money = money - val;
			System.out.printf("%s consume(%d) <-- size=%d\n",Thread.currentThread().getName(), val, money);
		} finally
		{
			lock.unlock();
		}
	}
}

class ProducerA
{
	private TestReentrantLock test;

	public ProducerA(TestReentrantLock test)
	{
		this.test = test;
	}

	public void produce(final int number)
	{
		new Thread()
		{
			public void run()
			{
				test.produce(number);
			}
		}.start();
	}
}

class CustomerA
{
	private TestReentrantLock test;

	public CustomerA(TestReentrantLock test)
	{
		this.test = test;
	}

	public void consume(final int number)
	{
		new Thread()
		{
			public void run()
			{
				test.consume(number);
			}
		}.start();
	}
}
