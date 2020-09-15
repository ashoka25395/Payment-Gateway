package com.example.demo;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

import java.time.Year;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.model.Card;
import com.example.demo.model.PaymentRequest;
import com.example.demo.model.PaymentResponse;
import com.example.demo.paymentgateway.PaymentController;
import com.example.demo.paymentgateway.PaymentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	PaymentController paymentController;

	@Mock
	PaymentService paymentService;

	@Test
	public void testDoPayment() {
		final MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		final PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setAmount(100);
		paymentRequest.setCurrency("USD");
		paymentRequest.setType("Credit Card");
		paymentRequest.setCard(this.getCard());
		final PaymentResponse paymentResponse = this.paymentController.doPayment(paymentRequest);

		when(this.paymentService.doPayment((@Valid PaymentRequest) any(PaymentRequest.class)))
				.thenReturn(paymentResponse);

	}

	private Card getCard() {
		final Card card = new Card();
		card.setCvv(123);
		card.setExpirationMonth(12);
		card.setNumber("121212121212");
		card.setExpirationYear(Year.now());
		return card;
	}

}
