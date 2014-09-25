package org.credo.jdk.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledExecutorService2 {

	public static void main(String[] args) {
		final List<String> mailList = new ArrayList<String>();
		final List<String> smsList = new ArrayList<String>();
		final List<String> faxList = new ArrayList<String>();

		mailList.add(" mail-zhaoqian@qq.com");
		mailList.add(" mail-zhaoqian@foxmail.com");
		mailList.add(" mail-zhaoqian@163.com");
		mailList.add(" mail-zhaoqian@126.com");
		mailList.add(" mail-zhaoqian@gmail.com");

		smsList.add(" sms-110");
		smsList.add(" sms-120");
		smsList.add(" sms-119");

		faxList.add(" fax-11122233");
		faxList.add(" fax-00099988");
		
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(3);
//		execService.scheduleWithFixedDelay(new Runnable() {
//
//			@Override
//			public void run() {
//				for ( int i=0;i<mailList.size();i++ )
//				{
//					System.out.println("任务Mail：" + Thread.currentThread().getName()+"---"+mailList.get(i)+"时间为： " + System.currentTimeMillis());
//					mailList.remove(i);
//				}
//			}
//		}, 2, 2, TimeUnit.SECONDS);
//
		execService.scheduleWithFixedDelay(new Runnable() {

			public void run() {
				List<String> smsList = new ArrayList<String>();
				smsList.add(" sms-110");
				for ( int i=0;i<smsList.size();i++ )
				{
					System.out.println("任务Sms：" + Thread.currentThread().getName()+"---"+smsList.get(i)+"时间为： " + System.currentTimeMillis());
				}
			}
		}, 2, 2, TimeUnit.SECONDS);

		execService.scheduleWithFixedDelay(new Runnable() {

			public void run() {
				System.out.println("begin");
				List<String> faxList = new ArrayList<String>();
				faxList.add(" fax-11122233");
				faxList.add(" fax-00099988");
				for ( int i=0;i<faxList.size();i++ )
				{
					System.out.println("任务Fax：" + Thread.currentThread().getName()+"---"+faxList.get(i)+"时间为： " + System.currentTimeMillis());
				}
				System.out.println("end");
			}
		}, 2, 2, TimeUnit.SECONDS);
	}
}
