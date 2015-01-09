package org.credo.jdk.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAtomicLong implements Runnable
{
	public static AtomicLongArray atomicLongArray =new AtomicLongArray(new long[]{0,0,0});

	private String operator; // 操作人
	private long number; // 操作数额

	public TestAtomicLong(String operator, long number)
	{
		this.operator = operator;
		this.number = number;
	}

	@Override
	public void run()
	{
		atomicLongArray.addAndGet(0, number);
		atomicLongArray.getAndIncrement(0);
		atomicLongArray.set(2, number);
		System.out.println(Thread.currentThread().getName() + ":   " + operator + "执行了" + number + "，当前：" + atomicLongArray.toString());
	}

	public static void main(String[] args)
	{
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Runnable t1 = new TestAtomicLong("张三", 1);
		Runnable t2 = new TestAtomicLong("李四", 2);
		Runnable t3 = new TestAtomicLong("王五", 3);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.shutdown();
	}

}
