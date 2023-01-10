package dev.arsystem.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

public class RomanNumerals {
	
	public static String arabicToRoman(int number) {
		int decimal = getDecimal(number);
		int module = number % decimal;
		number = decimal;
		
		String retVal = getRomanValue(number);
		
		return retVal + (module > 0 ? arabicToRoman(module) : "");
	}
	
	public static String getRomanValue(int number) {
		
		return Optional.ofNullable(getRomanValueWithAdd(number))
				.filter(val -> !val.isEmpty())
				.orElseThrow(() -> new RuntimeException("No se pudo calcular el valor, posiblemente deba indicar más información"));
	}
	
	public static String getRomanValueWithAdd(int number) {
		Entry<Integer, String> nearLetter = getNearLetter(number, true);
		int cumulated = 0;
		String retVal = nearLetter.getValue();
		
		if (nearLetter.getKey().equals(number))
			return retVal;
		
		for (Entry<Integer, String> letter = nearLetter; cumulated != number && letter != null;
				letter = cumulated != number ? getNearLetter(letter.getKey(), false) : letter)
		{
			cumulated = nearLetter.getKey();
			retVal = nearLetter.getValue();
			
			int maxRepeat = letter.getValue().equals(nearLetter.getValue())
					? MAX_REPEAT_LETTER -1 : MAX_REPEAT_LETTER;
			
			for (int i = 0; i < maxRepeat && cumulated < number; i++)
			{
				cumulated += letter.getKey();
				retVal += letter.getValue();
			}
		}
		
		return cumulated == number ? retVal : "";
	}
	
	public static int getDec(int number) {
		int dec = 1;
		
		for (; dec * 10 <= number; dec *= 10);
		
		return dec;
	}
	
	public static int getDecimal(int number) {
		int decimal = getDec(number);
		
		return (number / decimal) * decimal;
	}
	
	public static Entry<Integer, String> getNearLetter(int number, boolean includeEquals) {
		return romanMap
				.entrySet()
				.stream()
				.filter(entry -> includeEquals ? entry.getKey().compareTo(number) <= 0 : entry.getKey().compareTo(number) < 0)
				.sorted((entry1, entry2) -> entry2.getKey().compareTo(entry1.getKey()))
				.findFirst()
				.orElse(null);
	}
	
	@SuppressWarnings("serial")
	private static Map<Integer, String> romanMap = new HashMap<Integer, String>() {{
		put(1, "I");
		put(5, "V");
		put(10, "X");
		put(50, "L");
		put(100, "C");
		put(500, "D");
		put(1000, "M");
		put(4, "IV");
		put(9, "IX");
		put(40, "XL");
		put(90, "XC");
		put(400, "CD");
		put(900, "CM");
	}};
	
	private static int MAX_REPEAT_LETTER = 3;
}
