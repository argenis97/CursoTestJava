package dev.arsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.arsystem.util.StringUtil;

public class StringTest {
	
	@Test
	public void string_null_is_empty() {
		assertTrue(StringUtil.isEmpty(null));
	}
	
	@Test
	public void string_blank_is_empty() {
		assertTrue(StringUtil.isEmpty(""));
	}
	
	@Test
	public void string_space_is_empty() {
		assertTrue(StringUtil.isEmpty(" "));
	}
	
	@Test
	public void string_not_empty() {
		assertFalse(StringUtil.isEmpty("Argenis"));
	}
}
