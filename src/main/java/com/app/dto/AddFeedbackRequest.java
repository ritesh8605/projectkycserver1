package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddFeedbackRequest {
	

	private Long UserId;
	private String FirstName;
	private String LastName;
	private String Feedback;
	

}
