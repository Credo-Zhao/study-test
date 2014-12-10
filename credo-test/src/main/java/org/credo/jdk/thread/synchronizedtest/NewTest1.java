package org.credo.jdk.thread.synchronizedtest;

public class NewTest1
{
	
	public synchronized void syncMethod() {
		for(int i=0; i<1000000; i++)
            ;
	}
	
	public void syncBlock() {
		synchronized(this) {
			for(int i=0; i<1000000; i++)
	            ;
		}
	}

	public static void main(String[] args)
	{
		NewTest1 n1=new NewTest1();
		
		long start, diff;
		
		start = System.currentTimeMillis();
		n1.syncMethod();
		diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synMethod() : "+ diff);
        
        start = System.currentTimeMillis();                // 获取当前时间(millis)
        n1.syncBlock();                                // 调用“synchronized方法块”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synBlock()  : "+ diff);
	}

}
