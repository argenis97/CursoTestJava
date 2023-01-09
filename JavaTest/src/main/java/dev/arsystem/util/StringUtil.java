package dev.arsystem.util;

import java.util.stream.IntStream;

public class StringUtil {
	
	public static String repeat(String str, int repeat) {
		
		if (repeat < 0)
			throw new IllegalArgumentException("Repeat can't not be negative");
		
		return IntStream.range(0, repeat)
			.mapToObj(i -> str)
			.reduce("", String::concat);
	}
}
