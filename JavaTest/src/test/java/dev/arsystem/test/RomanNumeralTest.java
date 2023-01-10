package dev.arsystem.test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import dev.arsystem.util.RomanNumerals;

public class RomanNumeralTest {
	
	@Test
	public void testDecimalNumber() {
		assertThat(RomanNumerals.getDec(102), is(100));
		assertThat(RomanNumerals.getDec(285), is(100));
		assertThat(RomanNumerals.getDec(588), is(100));
		assertThat(RomanNumerals.getDec(1024), is(1000));
		assertThat(RomanNumerals.getDec(2050), is(1000));
	}
	
	@Test
	public void testLastDecimalNumber() {
		assertThat(RomanNumerals.getDecimal(2500), is(2000));
		assertThat(RomanNumerals.getDecimal(3480), is(3000));
		assertThat(RomanNumerals.getDecimal(3540), is(3000));
		assertThat(RomanNumerals.getDecimal(8750), is(8000));
		assertThat(RomanNumerals.getDecimal(9800), is(9000));
		assertThat(RomanNumerals.getDecimal(10680), is(10000));
		assertThat(RomanNumerals.getDecimal(595), is(500));
	}
	
	@Test
	public void testNearLetter() {
		assertEquals("I", RomanNumerals.getNearLetter(3, true).getValue());
		assertEquals("V", RomanNumerals.getNearLetter(6, true).getValue());
		assertEquals("V", RomanNumerals.getNearLetter(8, true).getValue());
		assertEquals("X", RomanNumerals.getNearLetter(10, true).getValue());
		assertEquals("I", RomanNumerals.getNearLetter(2, true).getValue());
	}
	
	@Test
	public void testArabicToRomanWithSum() {
		assertEquals("I", RomanNumerals.arabicToRoman(1));
		assertEquals("V", RomanNumerals.arabicToRoman(5));
		assertEquals("VI", RomanNumerals.arabicToRoman(6));
		assertEquals("XI", RomanNumerals.arabicToRoman(11));
		assertEquals("XII", RomanNumerals.arabicToRoman(12));
		assertEquals("XV", RomanNumerals.arabicToRoman(15));
		assertEquals("XVI", RomanNumerals.arabicToRoman(16));
		assertEquals("LXXXVI", RomanNumerals.arabicToRoman(86));
		assertEquals("CXXVI", RomanNumerals.arabicToRoman(126));
		assertEquals("MMDXXV", RomanNumerals.arabicToRoman(2525));
		assertEquals("MMDVII", RomanNumerals.arabicToRoman(2507));
	}
	
	@Test
	public void testArabicToRomanWithSubtract() {
		assertEquals("IV", RomanNumerals.arabicToRoman(4));
		assertEquals("IX", RomanNumerals.arabicToRoman(9));
		assertEquals("XIV", RomanNumerals.arabicToRoman(14));
		assertEquals("XIX", RomanNumerals.arabicToRoman(19));
		assertEquals("XXIV", RomanNumerals.arabicToRoman(24));
		assertEquals("XL", RomanNumerals.arabicToRoman(40));
		assertEquals("XLIX", RomanNumerals.arabicToRoman(49));
		assertEquals("XC", RomanNumerals.arabicToRoman(90));
		assertEquals("MMMDXIV", RomanNumerals.arabicToRoman(3514));
		assertEquals("CM", RomanNumerals.arabicToRoman(900));
		assertEquals("XCIX", RomanNumerals.arabicToRoman(99));
	}
}
