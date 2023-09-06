package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AddressId;
	
	@Column(length = 40)
	private String Country;
	


	@Column(length = 40)
	private String State;

	@Column(length = 40)
	private String District;
	
	@Column(length = 40)
	private String City;
	
	@Column(length = 40)
	private Long Pincode;
	
	@Column(length = 40)
	private String  Region;
		
	
	public Address(String country, String state, String district, String city, Long pincode, String region) {
		super();
		Country = country;
		State = state;
		District = district;
		City = city;
		Pincode = pincode;
		Region = region;
	}

}
