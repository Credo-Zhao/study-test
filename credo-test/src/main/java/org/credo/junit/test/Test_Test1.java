package org.credo.junit.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.credo.junit.Test1;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Test1 {
	
//	First Class
//	before
//	add
//	end
//	before
//	remove
//	end
//	After Class
	
	//类加载前(所以用static),如开启数据库连接
	@BeforeClass
	public static void firstClass(){
		System.out.println("First Class");
	}
	
	//类加载后,如关闭数据库连接
	@AfterClass
	public static void endClass(){
		System.out.println("After Class");
	}
	
	//每个方法测试前
	@Before
	public void first(){
		System.out.println("before");
	}
	
	//每个方法测试后
	@After
	public void end(){
		System.out.println("end");
	}

	//hamcrest
	@Test
	public void testAdd() {
		System.out.println("add");
		int z=new Test1().add(5, 3);
		assertEquals(8, z);
		assertThat("判断错误,应该为8",z, is(8));
		assertThat(z,allOf(greaterThan(1),lessThan(10)));
		assertThat(z,anyOf(greaterThan(1),lessThan(10)));
	}
	
	//期望抛出异常,不抛出就测试失败.
	//期望100毫秒结束,超过就算测试失败.
	@Test(expected=java.lang.ArithmeticException.class,timeout=100)
	public void testRemove(){
		System.out.println("remove");
		long x=new Test1().remove(3, 1);
		assertEquals(2, x);
		assertTrue("x erro",x>1);
		assertTrue("x erro",x>1);
	}

}
