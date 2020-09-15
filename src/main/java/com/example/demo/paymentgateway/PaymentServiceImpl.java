package com.example.demo.paymentgateway;

import java.util.Date;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.model.Logs;
import com.example.demo.model.PaymentRequest;
import com.example.demo.model.PaymentResponse;
import com.example.demo.repository.LogsRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private LogsRepository logsRepository;

	@Override
	public PaymentResponse doPayment(@Valid final PaymentRequest paymentRequest) {
		final PaymentResponse paymentResponse = this.preparePaymentResponse(paymentRequest);
		final Logs logs = new Logs();
		logs.setRequest(paymentRequest.toString());
		logs.setResponse(paymentResponse.toString());
		logs.setStatus(HttpStatus.OK.value());
		this.logsRepository.save(logs);
		return paymentResponse;
	}

	private PaymentResponse preparePaymentResponse(@Valid final PaymentRequest paymentRequest) {
		final PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setAmount(paymentRequest.getAmount());
		paymentResponse.setCurrency(paymentRequest.getCurrency());
		paymentResponse.setStatus("success");
		paymentResponse.setTime(new Date());
		paymentResponse.setType(paymentRequest.getType());
		paymentResponse.setCard(paymentRequest.getCard());
		paymentResponse.setAuthorizationCode(this.getSaltString());
		return paymentResponse;
	}

	public String getSaltString() {
		final String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		final StringBuilder salt = new StringBuilder();
		final Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			final int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		final String saltStr = salt.toString();
		return saltStr;

	}
}
