package com.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddProblemRequest;
import com.app.dto.MsgResponse;

import com.app.entities.Problem;
import com.app.entities.User;
import com.app.repository.ProblemRepository;
import com.app.repository.UserRepository;
import com.app.service.ProblemService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/problem")
public class ProblemController  {
	
	
	@Autowired
	ProblemService pService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProblemRepository problemRepo;
	
	
	@PostMapping("/addProblem")
	public MsgResponse addProblem(@RequestBody AddProblemRequest addPrbReq) {
		
		Problem problem = new Problem(addPrbReq.getProblem(),
								0,
								0,
								false,
								addPrbReq.getRegion(),
								20.00,
								LocalDate.now(),
								addPrbReq.getUserIdVoter(),
								addPrbReq.getUserIdCandidate());
		
		problemRepo.save(problem);
		
		return new MsgResponse("OK");
		
	}

	@GetMapping("/getCndMstLikePrb/{Region}")
	public List<Problem> getCandidateregionMostLikedPrb(@PathVariable String Region) {
		
		return pService.getCandidateregionMostLikedPrb(Region);
	}

	@GetMapping("/getMstSensaPrb")
	public List<Problem> getMostSensationalPrb() {
		// TODO Auto-generated method stub
		return pService.getMostSensationalPrb();
	}

	@GetMapping("/getMostpolplaCandiPrb")
	public List<Problem> getMostPopularCandidate() {
		// TODO Auto-generated method stub
		return pService.getMostPopularCandidate();
	}

	@GetMapping("/getMostLikePrb")
	public List<Problem> getMostLikedPrb() {
		// TODO Auto-generated method stub
		return pService.getMostLikedPrb();
	}


	@GetMapping("/getMostUnlikePrb")
	public List<Problem> getMostUnlikedPrb() {
		// TODO Auto-generated method stub
		return pService.getMostUnlikedPrb();
	}


	@GetMapping("/getMostRecentPrb")
	public List<Problem> getMostRecentPrb() {
		// TODO Auto-generated method stub
		return pService.getMostRecentPrb();
	}


	@GetMapping("/giveSensationalTag/{ProblemId}")
	public MsgResponse giveSensationalTag(@PathVariable Long ProblemId) {
		pService.giveSensationalTag(ProblemId);
		
		return new MsgResponse("OK");
		
	}

	@GetMapping("/giveWarning/{ProblemId}/{Warning}")
	public MsgResponse giveWarningMsg(@PathVariable Long ProblemId,@PathVariable String Warning) {
		// TODO Auto-generated method stub
		pService.giveWarningMsg(ProblemId, Warning);
		
		return new MsgResponse("OK");
	}

	@GetMapping("/searchPrbByName/{Name}")
	public List<Problem> searchPrbByCandidatename(@PathVariable String Name) {
		// TODO Auto-generated method stub
		
		List<User> user=userRepo.findByName(Name);
		List<Problem> allProblems = new ArrayList<Problem>(20);
		
		for (User tempUser : user) {
			
			List<Problem> prb =pService.searchPrbByCandidatename(tempUser.getUserId());
			allProblems.addAll(prb);
		}
		
		return allProblems;
	}

	@GetMapping("/sensatPrbByRegion/{Region}")
	public List<Problem> sensationalProblemByRegion(@PathVariable String Region) {
		// TODO Auto-generated method stub
		return pService.sensationalProblemByRegion(Region);
	}


	@GetMapping("/getMyPrb/{UserIdCandidate}")
	public List<Problem> getMyPrb(@PathVariable Long UserIdCandidate) {
		// TODO Auto-generated method stub
		return pService.getMyPrb(UserIdCandidate);
	}


	@GetMapping("/myMostRencetLikedPrb/{UserIdCandidate}")
	public List<Problem> myMostrecentLikedPrb(@PathVariable Long UserIdCandidate) {
		// TODO Auto-generated method stub
		return pService.myMostrecentLikedPrb(UserIdCandidate);
	}


	@GetMapping("/myRegionMostUnlike/{Region}")
	public List<Problem> myRegionMostUnlikedPrb(@PathVariable String Region) {
		// TODO Auto-generated method stub
		return pService.myRegionMostUnlikedPrb(Region);
	}
	
	

}
