package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MsgResponse;
import com.app.dto.UserProfileReq;
import com.app.entities.User;
import com.app.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/voter")
public class VoterController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/updateProfile")
	public MsgResponse UpdateProfile(@RequestBody UserProfileReq userReq) {

		Optional<User> userResult = userRepo.findByEmail(userReq.getEmail());
		User user;
		if (userResult.isPresent()) {
			user = userResult.get();

			user.setFirstName(userReq.getFirstName());
			user.setLastName(userReq.getLastName());
			user.setContact(userReq.getContact());
			user.setPassword(encoder.encode(userReq.getPassward()));

			userRepo.save(user);

			return new MsgResponse("OK");
		}
		return new MsgResponse("NOT OK");
	}
	
	
	
	
	
}
