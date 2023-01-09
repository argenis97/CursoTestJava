package dev.arsystem.payment;

import java.math.BigDecimal;

public class PaymentRequest {
	
	public PaymentRequest(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	private BigDecimal amount;
}
