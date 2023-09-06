package com.app.dto;





import com.app.entities.UserType;

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
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private UserType userType;



  public JwtResponse(String accessToken, Long id,String fname,String lname,String email,UserType userType) {
    this.token = accessToken;
    this.id = id;
	this.firstName = fname;
	this.lastName = lname;
	this.email = email;
	this.userType= userType;
	

  }

}
