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
public class AddProblemRequest {
	
	private String Problem;
	private String Region;
	private Long UserIdVoter;
	private Long UserIdCandidate;

}
