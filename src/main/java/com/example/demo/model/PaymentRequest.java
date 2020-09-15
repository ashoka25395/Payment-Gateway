package com.example.demo.model;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

	@NotNull(message = "Amount is mandatory!")
	@DecimalMin("1")
	private int amount;

	@NotBlank(message = "Type is mandatory!")
	private String type;

	@NotBlank(message = "Currency is mandatory!")
	private String currency;

	@Valid
	private Card card;

}
