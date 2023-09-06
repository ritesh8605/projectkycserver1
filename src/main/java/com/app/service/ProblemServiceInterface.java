package com.app.service;

import java.util.List;

import com.app.entities.Problem;

public interface ProblemServiceInterface {
	
	List<Problem> getCandidateregionMostLikedPrb(String Region);
	
	List<Problem> getMostSensationalPrb();
	
	List<Problem> getMostPopularCandidate();
	
	List<Problem> getMostLikedPrb();
	
	List<Problem> getMostUnlikedPrb();
	
	List<Problem> getMostRecentPrb();
	
	void giveSensationalTag(Long ProblemId);
	
	void giveWarningMsg(Long ProblemId,String Warning);
	
	List<Problem> searchPrbByCandidatename(Long UserIdCandidate);
	
	List<Problem> sensationalProblemByRegion(String Region);
	
	List<Problem> getMyPrb(Long UserIdCandidate);
	
	List<Problem> myMostrecentLikedPrb(Long UserIdCandidate);
	
	List<Problem> myRegionMostUnlikedPrb(String Region);
	
	
	
	
 
}
