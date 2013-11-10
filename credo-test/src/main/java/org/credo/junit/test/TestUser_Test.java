package org.credo.junit.test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.credo.junit.TestUser;
import org.junit.Test;

public class TestUser_Test {

	@Test
	public void testGetName() {
		System.out.println("test name");
		String name = new TestUser().getName();
		assertThat(name, is("石雪"));
		assertThat(name, is("shixue"));
	}

}
