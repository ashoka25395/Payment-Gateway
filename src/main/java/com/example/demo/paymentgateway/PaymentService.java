package com.example.demo.paymentgateway;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.example.demo.model.PaymentRequest;
import com.example.demo.model.PaymentResponse;

@Service
public interface PaymentService {

	PaymentResponse doPayment(@Valid PaymentRequest paymentRequest);

}
