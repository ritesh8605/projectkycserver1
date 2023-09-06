package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Problem;
import com.app.repository.ProblemRepository;

@Service
@Transactional
public class ProblemService implements ProblemServiceInterface {
	
	@Autowired
	private ProblemRepository pRepo;

	@Override
	public List<Problem> getCandidateregionMostLikedPrb(String Region) {
		// TODO Auto-generated method stub
		return pRepo.getCandidateregionMostLikedPrb(Region);
	}

	@Override
	public List<Problem> getMostSensationalPrb() {
		// TODO Auto-generated method stub
		return pRepo.getMostSensationalPrb();
	}

	@Override
	public List<Problem> getMostPopularCandidate() {
		// TODO Auto-generated method stub
		return pRepo.getMostPopularCandidate();
	}

	@Override
	public List<Problem> getMostLikedPrb() {
		// TODO Auto-generated method stub
		return pRepo.getMostLikedPrb();
	}

	@Override
	public List<Problem> getMostUnlikedPrb() {
		// TODO Auto-generated method stub
		return pRepo.getMostUnlikedPrb();
	}

	@Override
	public List<Problem> getMostRecentPrb() {
		// TODO Auto-generated method stub
		return pRepo.getMostRecentPrb();
	}

	@Override
	public void giveSensationalTag(Long ProblemId) {
		// TODO Auto-generated method stub
		pRepo.giveSensationalTag(ProblemId);
	}

	@Override
	public void giveWarningMsg(Long ProblemId, String Warning) {
		// TODO Auto-generated method stub
		pRepo.giveWarningMsg(ProblemId, Warning);
	}

	@Override
	public List<Problem> searchPrbByCandidatename(Long UserIdCandidate) {
		// TODO Auto-generated method stub
		return pRepo.searchPrbByCandidatename(UserIdCandidate);
	}

	@Override
	public List<Problem> sensationalProblemByRegion(String Region) {
		// TODO Auto-generated method stub
		return pRepo.sensationalProblemByRegion(Region);
	}

	@Override
	public List<Problem> getMyPrb(Long UserIdCandidate) {
		// TODO Auto-generated method stub
		return pRepo.getMyPrb(UserIdCandidate);
	}

	@Override
	public List<Problem> myMostrecentLikedPrb(Long UserIdCandidate) {
		// TODO Auto-generated method stub
		return pRepo.myMostrecentLikedPrb(UserIdCandidate);
	}

	@Override
	public List<Problem> myRegionMostUnlikedPrb(String Region) {
		// TODO Auto-generated method stub
		return pRepo.myRegionMostUnlikedPrb(Region);
	}


	
}
