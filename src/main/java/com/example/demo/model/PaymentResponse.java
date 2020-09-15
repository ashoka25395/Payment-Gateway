package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
	@NotNull(message = "Amount is mandatory!")
	private int amount;

	@NotBlank(message = "Type is mandatory!")
	private String type;

	@NotBlank(message = "Currency is mandatory!")
	private String currency;
	private Card card;
	private String status;
	private String authorizationCode;
	private Date time;
}
