package com.app.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddCommentRequest;
import com.app.dto.MsgResponse;
import com.app.entities.Comment;
import com.app.entities.User;
import com.app.repository.CommentRepository;
import com.app.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/add")
	public MsgResponse AddNewCommment(@RequestBody AddCommentRequest addcmtreq) {
		
		
		Comment cmt = new Comment(addcmtreq.getComment(),
								  1,
								  addcmtreq.getRegion(),
								  false,
								  LocalDate.now(),
								  addcmtreq.getUserIdVoter(),
								  addcmtreq.getUserIdCandidate());
		
		commentRepo.save(cmt);
		
		return new MsgResponse("OK");
		
		
	}
	
	@GetMapping("/getsensationalcomment")
	public List<Comment> getSensationalCmt() {
		
		return commentRepo.getSensationalCmt();
	}
	
	@GetMapping("/getrecentcomment")
	public List<Comment> getRecentComment(){
		
		return commentRepo.getRecentComment();
	}
	
	@PutMapping("givesensationaltag/{CommentId}")
	public MsgResponse giveSensationalTag(@PathVariable Long  CommentId) {
		
		commentRepo.giveSensationalTag(CommentId);
		return new MsgResponse("OK");
		
	}
	
	@PutMapping("/givewarningmsg/{CommentId}/{Warning}")
	public MsgResponse giveWarningMsg(@PathVariable Long  CommentId,@PathVariable String  Warning) {
		
		commentRepo.giveWarningMsg(CommentId, Warning);
		return new MsgResponse("OK");
	}
	
	@GetMapping("/searchcandidate/{CandidadateName}")
	public List<User> getCommentByCandidateName(@PathVariable String  CandidadateName)
	{
		
		return userRepo.findByName(CandidadateName);

	}
	
	@GetMapping("/givelike/{CommentId}/{LikedCount}")
	public MsgResponse giveLike(@PathVariable Long  CommentId,@PathVariable Integer  LikedCount) {
		
		commentRepo.giveLikeToCmt(CommentId, LikedCount);
		
		return new MsgResponse("OK");
	}
	@GetMapping("/givedislike/{CommentId}/{DisLikedCount}")
	public MsgResponse giveDislikeToCmt(@PathVariable Long  CommentId,@PathVariable Integer  DisLikedCount)
	{
		commentRepo.giveDislikeToCmt(CommentId, DisLikedCount);
		
		return new MsgResponse("OK");
		
	}
	
	@GetMapping("/myallcomments/{UserIdVoter}")
	public List<Comment> getMyComment(@PathVariable Long UserIdVoter){
		
		return commentRepo.getYoursCmt(UserIdVoter);
	}
	
	@GetMapping("/myrecentandmostlikecmt/{UserIdCandidate}")
	public List<Comment> myRecentMostLikedCmt(@PathVariable Long UserIdCandidate){
		
		return commentRepo.getMyRecentAndLikedCmt(UserIdCandidate);
	}
	
	@GetMapping("/myrecentsensationalcmt/{UserIdCandidate}")
	public List<Comment> getMyRecentAndSensationalCmt(@PathVariable Long UserIdCandidate){
		
		return commentRepo.getMyRecentAndSensationalCmt(UserIdCandidate);
	}
	
	@GetMapping("/myregionmostliked/{Region}")
	public List<Comment> getMyRegionMostLikedCmt(@PathVariable String Region){
		
		return commentRepo.getMyRegionMostLikedCmt(Region);
	}
	
	@GetMapping("/myregionmostunliked/{Region}")
	public List<Comment> getMyRegionMostUnlikedCmt(@PathVariable String Region){
		
		return commentRepo.getMyRegionMostUnlikedCmt(Region);
	}
	
	@GetMapping("/globalmostlikedcmt")
	public List<Comment> getGlobalMostLikedCmt(){
		
		return commentRepo.getGlobalMostLikedCmt();
	}
	
	@GetMapping("/globalmostunlikedcmt")
	public List<Comment> getGlobalMostUnLikedCmt(){
		
		return commentRepo.getGlobalMostUnlikedCmt();
	}

}
