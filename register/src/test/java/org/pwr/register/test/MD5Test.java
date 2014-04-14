package org.pwr.register.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.pwr.register.support.MD5;

public class MD5Test {

	@Test
	public void checkIfGoodHash()
	{
		assertEquals("0cc175b9c0f1b6a831c399e269772661", MD5.getHash("a"));
	}
}
