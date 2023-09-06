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
public class SearchedCandiResponse {

	
	private Long UserId;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Occupation;
	private String Region;
}
