package dev.arsystem.payment;

import dev.arsystem.enums.PaymentStatus;

public class PaymentResponse {
	
	public PaymentResponse(PaymentStatus status) {
		this.status = status;
	}
	
	public PaymentStatus getStatus() {
		return status;
	}
	
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	private PaymentStatus status;
}
