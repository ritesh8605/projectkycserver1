

package com.app.dto;


import java.util.Date;



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
public class ExDetailRequest {
	
	
	private String Email;
	private Date StartDate;
	private Date EndDate;
	private String ReasonToRetire;

	

}
