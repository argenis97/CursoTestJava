package dev.arsystem.payment;

import java.math.BigDecimal;

import dev.arsystem.enums.PaymentStatus;

public class PaymentProcessor {
	
	public PaymentProcessor(PaymentGateway gateWay) {
		this.gateWay = gateWay;
	}
	
	public boolean makePayment(BigDecimal amount) {
		return gateWay.requestPayment(new PaymentRequest(amount))
				.getStatus() == PaymentStatus.OK;
	}
	
	private PaymentGateway gateWay;
}
