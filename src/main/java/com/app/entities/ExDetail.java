package com.app.entities;

import java.util.Date;

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
@Table(name = "extable")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ExDtlId;
	
	@Column
	private Date StartDate;
	
	@Column
	private Date EndDate;
	
	@Column(length = 400)
	private String Reason;

	public ExDetail(Date startDate, Date endDate, String reason) {
		super();
		StartDate = startDate;
		EndDate = endDate;
		Reason = reason;
	}
	
	
	
	
	

}
