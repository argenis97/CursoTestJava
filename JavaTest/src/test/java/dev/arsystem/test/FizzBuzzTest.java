package dev.arsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.arsystem.util.FizzBuzz;

public class FizzBuzzTest {
	
	@Test
	public void fizz_when_divisible_by_3() {
		assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
		assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
		assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
	}
	
	@Test
	public void buzz_when_divisible_by_5() {
		assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
		assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
		assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
	}
	
	@Test
	public void number_when_is_not_divisible() {
		assertEquals("2", FizzBuzz.fizzBuzz(2));
		assertEquals("4", FizzBuzz.fizzBuzz(4));
		assertEquals("8", FizzBuzz.fizzBuzz(8));
	}
}
