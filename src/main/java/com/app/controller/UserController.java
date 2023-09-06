package com.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressRequest;
import com.app.dto.AddressResponse;
import com.app.dto.CandidateRequest;
import com.app.dto.ExDetailRequest;
import com.app.dto.JwtResponse;
import com.app.dto.LoginRequest;
import com.app.dto.MsgResponse;
import com.app.dto.SignupRequest;
import com.app.dto.UserDtlResponse;
import com.app.dto.UserGetdataReq;
import com.app.entities.Address;
import com.app.entities.CandidateDetail;
import com.app.entities.ExDetail;
import com.app.entities.Region;
import com.app.entities.User;
import com.app.entities.UserType;
import com.app.jwt.JwtUtils;
import com.app.payload.MyApiResponse;
import com.app.repository.RegionRepository;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;
import com.app.service.UserDetailsImpl;
import com.app.service.UserService;

import org.springframework.security.access.prepost.PreAuthorize;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authorize")
public class UserController {
	@Autowired
	private UserService service;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	RegionRepository regionRepo;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		System.out.println(userDetails.getEmail() + "in user controller");

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getFirstName(),
				userDetails.getLastName(), userDetails.getEmail(), userDetails.getUserType()));
	}

	@PostMapping("/signupforvoter")
	public User registerUservoter(@Valid @RequestBody SignupRequest signUpRequest) {
	
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return null;
		}

		// Create new user's account
		User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getDOB(), signUpRequest.getContact(),
				signUpRequest.getAgeProof(), false);

		

		user.setUsertype(UserType.VOTER);
		user.setBlockStatus(false);

		System.out.println(user);

		return userRepository.save(user);

	}
	
	@PostMapping("/signupforcandidate")
	public User registerUsercandidate(@Valid @RequestBody SignupRequest signUpRequest) {
		System.out.println(signUpRequest.getPassword() +" password");

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return null;
		}

		// Create new user's account
		User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getDOB(), signUpRequest.getContact(),
				signUpRequest.getAgeProof(), true);

		

		user.setUsertype(UserType.CANDIDATE);
		user.setBlockStatus(true);

		System.out.println(user);

		return userRepository.save(user);

	}
	
	@PostMapping("/addAddress")
	public AddressResponse AddAddress(@RequestBody AddressRequest addressrequest) {
		System.out.println("hi ");
		Optional<User> userResult = userRepository.findByEmail(addressrequest.getEmail());
		System.out.println(addressrequest.getEmail());
		User user;
		if(userResult.isPresent()) {
			user = userResult.get();
			
			Address address= new Address(addressrequest.getCountry(),addressrequest.getState(),addressrequest.getDistrict(),
					addressrequest.getCity(),addressrequest.getPincode(),addressrequest.getRegion());
			
			user.setAddress(address);
			userRepository.save(user);
			
			return new AddressResponse("Address updated");
		}
		else {
			return new AddressResponse("User Not Found");
		}
		
	}
	
	@GetMapping("/getRegion")
	public List<Region> GetRegions(){
		
		return  regionRepo.findAll();
	}
	
	
	@PostMapping("/getUserDtl")
	public User getUserDtl(@RequestBody UserGetdataReq userReq) {
		
		
		Optional<User> userResult = userRepository.findByEmail(userReq.getEmail());
		User user;
		if(userResult.isPresent()) {
			user = userResult.get();
			return user;
		}
		return new User();
			
		
	}
	
	@PostMapping("/addCandidateDetail")
	public MsgResponse AddCandidateDetail(@RequestBody CandidateRequest candidatereq) {
		Optional<User> userResult = userRepository.findByEmail(candidatereq.getEmail());
		User user;
		if(userResult.isPresent()) {
			user = userResult.get();
			
			CandidateDetail candidtl= new CandidateDetail(candidatereq.getOccpation(),
															candidatereq.getAssembly(),
															candidatereq.getWork(),
															candidatereq.getSocialHandel(),
															candidatereq.getQuote(),
															false,
															candidatereq.getRegion(),
															candidatereq.getImage(),
															20.00,"YOUR APPLICATION IS IN PROCESS...");
			
			user.setCandidatedetail(candidtl);
			userRepository.save(user);
			
			return new MsgResponse("CandidateDetail updated");
		}
		else {
			return new MsgResponse("User Not Found");
		}
	}
	
	@PostMapping("/exToCandidate")
	public MsgResponse ActiveToEx (@RequestBody ExDetailRequest exDetaiilreq) {
		System.out.println("1");
		Optional<User> userResult = userRepository.findByEmail(exDetaiilreq.getEmail());
		User user;
		System.out.println("2");
		if(userResult.isPresent()) {
			user = userResult.get();
			System.out.println("3");
			ExDetail exdtl= new ExDetail(exDetaiilreq.getStartDate(),exDetaiilreq.getEndDate(),
											exDetaiilreq.getReasonToRetire());
			
			
			user.setUsertype(UserType.EXUSER);
			user.setExdetail(exdtl);
			userRepository.save(user);
			
			return new MsgResponse("Candidate is now Ex-Candidate");
		}
		else {
			return new MsgResponse("User Not Found");
		}
	}

	@PreAuthorize("hasAuthority('CUSTOMER')")
	@PutMapping("/{id}")
	public MyApiResponse updateUserr(@PathVariable Long id, @RequestBody SignupRequest user) {
		return service.updateUser(id, user);
	}
}