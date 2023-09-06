package com.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SignupRequest {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	
	private LocalDate DOB;
	
	private String Contact;
	
	private String AgeProof;
	
	
	private String password;
	

	
	  
	}
