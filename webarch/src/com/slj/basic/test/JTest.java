package com.slj.basic.test;

import org.junit.Test;

public class JTest {
	
	@Test
	public void testThread() {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		ThreadTest t3 = new ThreadTest();
		t1.start();
		t2.start();
		t3.start();
	}
}
