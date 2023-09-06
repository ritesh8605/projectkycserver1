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
@Table(name = "feedback")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long FeedbackId;
	
	@Column
	private String Feedback;
	
	@Column
	private String FirstName;
	
	@Column
	private String LastName;
	
	@Column(name = "userid")
	private Long UserId;

	public Feedback(String feedback, String firstName, String lastName, Long userId) {
		super();
		Feedback = feedback;
		FirstName = firstName;
		LastName = lastName;
		UserId = userId;
	}
	



	
	
	
	
	

}
