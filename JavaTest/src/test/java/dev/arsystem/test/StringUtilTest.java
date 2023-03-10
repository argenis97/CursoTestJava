package dev.arsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.arsystem.util.StringUtil;

public class StringUtilTest {
	
	@Test
	public void test() {
		assertEquals("abcabc", StringUtil.repeat("abc", 3));
	}
	
	@Test
	public void test2words() {
		assertEquals("holahola", StringUtil.repeat("hola", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		StringUtil.repeat("Anabella", -1);
	}
}
