package com.example.demo.model;

import java.time.Year;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

	@NotBlank(message = "Card number is mandatory!")
	@Pattern(regexp = "[\\d]{12}", message = "card number should be of 12 digits")
	private String number;

	@JsonIgnore
	private String cvv;

	@JsonIgnore
	private int expirationMonth;

	@JsonIgnore
	private Year expirationYear;
}
