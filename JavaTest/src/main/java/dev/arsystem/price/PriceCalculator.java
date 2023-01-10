package dev.arsystem.price;

import java.util.ArrayList;

public class PriceCalculator {
	
	public PriceCalculator() {
		prices = new ArrayList<Double>();
		discount = 0.0;
	}
	
	public Double getPrice() {
		Double price = prices.stream().reduce(0.0, Double::sum);
		return price - price * (discount / 100);
	}
	
	public void addPrice(Double price) {
		prices.add(price);
	}
	
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	private ArrayList<Double> prices;
	private Double discount;
}
