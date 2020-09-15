package com.example.demo.paymentgateway;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PaymentRequest;
import com.example.demo.model.PaymentResponse;

@RestController
@RequestMapping("/api")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/doPayment")
	public PaymentResponse doPayment(@Valid @RequestBody final PaymentRequest paymentRequest) {
		return this.paymentService.doPayment(paymentRequest);
	}
}
