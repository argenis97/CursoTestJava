package dev.arsystem.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dev.arsystem.enums.PaymentStatus;
import dev.arsystem.payment.PaymentGateway;
import dev.arsystem.payment.PaymentProcessor;
import dev.arsystem.payment.PaymentResponse;

public class PaymentTest {
	
	@Before
	public void setup() {
		gateWay = Mockito.mock(PaymentGateway.class);
		processor = new PaymentProcessor(gateWay);
	}
	
	@Test
	public void payment_is_correct() {
		Mockito.when(gateWay.requestPayment(Mockito.any()))
			.thenReturn(new PaymentResponse(PaymentStatus.OK));
		
		assertTrue(processor.makePayment(new BigDecimal(200)));
	}
	
	@Test
	public void payment_is_wrong() {
		Mockito.when(gateWay.requestPayment(Mockito.any()))
			.thenReturn(new PaymentResponse(PaymentStatus.ERROR));
		
		assertFalse(processor.makePayment(new BigDecimal(200)));
	}
	
	private PaymentGateway gateWay;
	private PaymentProcessor processor;
}
