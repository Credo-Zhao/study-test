package org.credo.jaxws.study1;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TimeServerThreadPoolPublisher extends ThreadPoolExecutor
{
	public static void main(String[] args)
	{

	}

	private static final int corePoolSize = 10;
	private static final int maximumPoolSize = 15;
	private static final long keepAliveTime = 3000;

	private boolean is_paused;

	private ReentrantLock pause_lock = new ReentrantLock();
	private Condition unpaused = pause_lock.newCondition();

	public TimeServerThreadPoolPublisher()
	{
		super(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(
				corePoolSize));
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r)
	{
		super.beforeExecute(t, r);
		pause_lock.lock();
		try
		{
			while (is_paused)
			{
				unpaused.await();

			}
		} catch (Exception e)
		{
		} finally
		{
			pause_lock.unlock();
		}
	}

	public void pause()
	{
		pause_lock.lock();
		try
		{
			is_paused = true;
		} finally
		{
			pause_lock.unlock();
		}
	}

	public void resume()
	{
		pause_lock.lock();
		try
		{
			is_paused = false;
			unpaused.signalAll();
		} finally
		{
			pause_lock.unlock();
		}
	}
}
