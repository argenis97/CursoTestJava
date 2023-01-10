package dev.arsystem.test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import dev.arsystem.price.PriceCalculator;

public class PriceCalculatorShould {
	
	@Before
	public void setup() {
		calculator = new PriceCalculator();
	}
	
	@Test
	public void total_zero_where_are_prices() {
		assertThat(calculator.getPrice(), is(0.0));
	}
	
	@Test
	public void total_equals_prices() {
		calculator.addPrice(1.0);
		calculator.addPrice(10.0);
		calculator.addPrice(10.0);
		
		assertThat(calculator.getPrice(), is(21.0));
	}
	
	@Test
	public void apply_discount() {
		calculator.addPrice(1.0);
		calculator.addPrice(10.0);
		calculator.addPrice(10.0);
		calculator.setDiscount(10.0);
		
		assertThat(calculator.getPrice(), is(18.9));
	}
	
	private PriceCalculator calculator;
}
