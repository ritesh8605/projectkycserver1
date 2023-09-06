package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Comment;
import com.app.entities.User;
import com.app.repository.CommentRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CommentService implements CommentServiceInterface{
	
	@Autowired
	CommentRepository cRepo;
	
	
	@Autowired
	UserRepository userRepo;

	@Override
	public List<Comment> getSensationalCmt() {
		// TODO Auto-generated method stub
		return cRepo.getSensationalCmt();
	}

	@Override
	public List<Comment> getRecentComment() {
		// TODO Auto-generated method stub
		return cRepo.getRecentComment();
	}

	@Override
	public void giveSensationalTag(Long CommentId) {
		// TODO Auto-generated method stub
			cRepo.giveSensationalTag(CommentId);
	}

	@Override
	public void giveWarningMsg(Long CommentId, String Warning) {
		// TODO Auto-generated method stub
		cRepo.giveWarningMsg(CommentId, Warning);
	}

	@Override
	public List<User> getCommentByCandidateName(String CandidateName) {
		// TODO Auto-generated method stub
		
		return userRepo.findByName(CandidateName);
	}

	@Override
	public void giveLikeToCmt(Long CommentId, Integer LikedCount) {
		// TODO Auto-generated method stub
		cRepo.giveLikeToCmt(CommentId, LikedCount);
	}

	@Override
	public void giveDislikeToCmt(Long CommentId , Integer DisLikedCount) {
		// TODO Auto-generated method stub
		cRepo.giveDislikeToCmt(CommentId, DisLikedCount);
	}

	@Override
	public List<Comment> getYoursCmt(Long UserIdVoter) {
		// TODO Auto-generated method stub
		return cRepo.getYoursCmt(UserIdVoter);
	}

	@Override
	public List<Comment> getMyRecentAndLikedCmt(Long UserIdCandidate) {
		// TODO Auto-generated method stub
		return cRepo.getMyRecentAndLikedCmt(UserIdCandidate);
	}

	@Override
	public List<Comment> getMyRecentAndSensationalCmt(Long UserIdCandidate) {
		// TODO Auto-generated method stub
		return cRepo.getMyRecentAndSensationalCmt(UserIdCandidate);
	}

	@Override
	public List<Comment> getMyRegionMostLikedCmt(String Region) {
		// TODO Auto-generated method stub
		return cRepo.getMyRegionMostLikedCmt(Region);
	}

	@Override
	public List<Comment> getMyRegionMostUnlikedCmt(String Region) {
		// TODO Auto-generated method stub
		return cRepo.getMyRegionMostUnlikedCmt(Region);
	}

	@Override
	public List<Comment> getGlobalMostLikedCmt() {
		// TODO Auto-generated method stub
		return cRepo.getGlobalMostLikedCmt();
	}

	@Override
	public List<Comment> getGlobalMostUnlikedCmt() {
		// TODO Auto-generated method stub
		return cRepo.getGlobalMostUnlikedCmt();
	}

	

}
