package com.kakaruto.test.calcTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CalcTest {
	
	Calc calc;
	String numFilePath;
	
	@Before	public void before() {
		this.calc = new Calc();
		this.numFilePath = getClass().getResource("test.txt").getPath();
	}

	@Test public void testSum() {
		int ret = calc.sum(1,1,1,1,1);
		assertThat(ret, is(5));
		
	}
	
	@Test public void testMultiply() {
		int ret = calc.multiply(5,5);
		
		assertThat(ret, is(25));
	}
	
	@Test public void testFileReadSum() throws IOException {
		Integer ret = calc.fileReadSum(this.numFilePath);
		assertThat(ret, is(9));
	}

}
