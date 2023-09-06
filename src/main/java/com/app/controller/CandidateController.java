package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MsgResponse;
import com.app.dto.SearchCandiRequest;
import com.app.dto.SearchedCandiResponse;
import com.app.dto.UserGetdataReq;
import com.app.entities.User;
import com.app.entities.UserType;
import com.app.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	UserRepository userRepo;

	@PostMapping("/searchByName")
	public List<SearchedCandiResponse> SearchByName(@RequestBody SearchCandiRequest searchCandiRequest) {

		List<User> users = userRepo.findByName(searchCandiRequest.getFirstName());
		List<SearchedCandiResponse> response = new ArrayList<SearchedCandiResponse>();

		for (User user : users) {

			if (user.getUsertype() == UserType.CANDIDATE) {
				System.out.println(1);
				response.add(new SearchedCandiResponse(user.getUserId(), user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getCandidatedetail().getOccupation(), user.getAddress().getRegion()));
			}
		}
		return response;
	}
	
	@PostMapping("/voteCandidate")
	public MsgResponse VoteCandidate(@RequestBody UserGetdataReq getUserreq ) {
		
		Optional<User> userResult = userRepo.findByEmail(getUserreq.getEmail());
		User user;
		if(userResult.isPresent()) {
			user = userResult.get();
			
			double popu=user.getCandidatedetail().getPolularity();
			
			user.getCandidatedetail().setPolularity(popu+0.1);
			
			userRepo.save(user);
			System.out.println(user.getCandidatedetail().getPolularity());
			return new MsgResponse("OK");
			
		}
		
		return new MsgResponse("NOT VOTED");
	}
	
}
