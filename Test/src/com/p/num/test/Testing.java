package com.p.num.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.p.num.NumTest;





public class Testing {
	
	@Test
	public void testNullInput() {
		
		//assertTrue(true);
		assertTrue("Invalid", NumTest.sum(2, 2)==4);
	   
	}

}
