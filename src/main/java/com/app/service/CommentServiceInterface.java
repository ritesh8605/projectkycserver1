package com.app.service;

import java.util.List;

import com.app.entities.Comment;
import com.app.entities.User;

public interface CommentServiceInterface {

	
	List<Comment> getSensationalCmt();
	
//	List<Comment> getMostLikedCmt();
	
//	//List<Comment> getMostDislikedCmt();
//	
	List<Comment> getRecentComment();
	
	void giveSensationalTag(Long CommentId);
	
	void giveWarningMsg(Long CommentId , String Warning);
	
	List<User> getCommentByCandidateName(String CandidadateName);
	
	void giveLikeToCmt(Long CommentId , Integer LikedCount);
	
	void giveDislikeToCmt(Long CommentId , Integer DisLikedCount);
		
	List<Comment> getYoursCmt(Long UserIdVoter);
	
	List<Comment> getMyRecentAndLikedCmt(Long UserIdCandidate);
	
	List<Comment> getMyRecentAndSensationalCmt(Long UserIdCandidate);
	
	List<Comment> getMyRegionMostLikedCmt(String Region);
	
	List<Comment> getMyRegionMostUnlikedCmt(String Region);
	
	List<Comment> getGlobalMostLikedCmt();
	
	List<Comment> getGlobalMostUnlikedCmt();
}
