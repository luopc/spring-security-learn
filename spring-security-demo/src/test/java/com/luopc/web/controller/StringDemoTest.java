package com.luopc.web.controller;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

public class StringDemoTest {
	
	@Test
	public void randomTest() {
		System.out.println(RandomStringUtils.randomNumeric(6));
	}

}
