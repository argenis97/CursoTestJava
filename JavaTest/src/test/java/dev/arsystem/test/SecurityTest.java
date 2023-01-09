package dev.arsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.arsystem.enums.SecurityLevel;
import dev.arsystem.util.PasswordUtil;

public class SecurityTest {
	
	@Test
	public void low_when_than_less_8_letters() {
		assertEquals(SecurityLevel.LOW, PasswordUtil.access("1234567"));
	}
	
	@Test
	public void low_when_only_letters() {
		assertEquals(SecurityLevel.LOW, PasswordUtil.access("abcdef"));
	}
	
	@Test
	public void low_when_only_symbols() {
		assertEquals(SecurityLevel.LOW, PasswordUtil.access("!@#$%^&*("));
	}
	
	@Test
	public void medium_when_has_number_and_symbols() {
		assertEquals(SecurityLevel.MEDIUM, PasswordUtil.access("123456789#$%^&"));
	}
	
	@Test
	public void medium_when_has_letters_and_numbers() {
		assertEquals(SecurityLevel.MEDIUM, PasswordUtil.access("abc123456"));
	}
	
	@Test
	public void hight_when_has_letter_numbers_and_symbols() {
		assertEquals(SecurityLevel.HIGHT, PasswordUtil.access("abc1234$"));
	}
	
	@Test
	public void test_pass_regular_expression() {
		assertTrue("**)".matches(PasswordUtil.STRONG_PATTERN));
	}
}
