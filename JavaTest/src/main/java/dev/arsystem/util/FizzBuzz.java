package dev.arsystem.util;

import java.util.Optional;

public class FizzBuzz {
	
	public static String fizzBuzz(int number) {
		
		String retVal = (number % 3 == 0 ? "Fizz" : "")
				+ (number % 5 == 0 ? "Buzz" : "");
		
		return Optional.ofNullable(retVal)
				.filter(ret -> !ret.isEmpty())
				.orElse(Integer.toString(number));
	}
}
