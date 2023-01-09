package dev.arsystem.payment;

public interface PaymentGateway {
	
	public PaymentResponse requestPayment(PaymentRequest request);
}
