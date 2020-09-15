package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "logs")
public class Logs {

	/** auto generated id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String request;
	private String response;
	private int status;
}
