package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddFeedbackRequest;
import com.app.dto.MsgResponse;
import com.app.entities.Feedback;
import com.app.repository.FeedbackRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	
	@Autowired
	FeedbackRepository feedbackRepo;
	
	
	
	@PostMapping("/addFeedback")
	public MsgResponse AddFeedback (@RequestBody AddFeedbackRequest addreq) {
		
		Feedback feedback= new Feedback(addreq.getFeedback(),
										addreq.getFirstName(),
										addreq.getLastName(),
										addreq.getUserId());
		
		feedbackRepo.save(feedback);
		
		return new MsgResponse("Feedback Added");
		
	}
	
	@GetMapping("/getAllFeedback")
	public List<Feedback> AllFeedback() {
		
			return	feedbackRepo.findAll();
	}
	
	@DeleteMapping("/{UserId}")
	public MsgResponse DeleteFeedback(@PathVariable Long  UserId) {
		
		feedbackRepo.DeleteById(UserId);
		
		return new MsgResponse("Feedback deleted of" + UserId);
	}

}
