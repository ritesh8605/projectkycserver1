package com.app.dto;


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
public class AddressRequest {
	
	private String email;
	
	private String Country;
	
	private String State;
	
	private String District;
	
	private String City;
	
	private Long Pincode;
	
	private String Region;

}
