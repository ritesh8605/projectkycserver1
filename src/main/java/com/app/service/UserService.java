package com.app.service;



import com.app.payload.MyApiResponse;
import com.app.dto.SignupRequest;
import com.app.entities.User;

public interface UserService {

	User getById(Long uId);
	MyApiResponse updateUser(Long uId, SignupRequest user);
}
