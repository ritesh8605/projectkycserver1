package com.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.ModelMapper;
import com.app.payload.MyApiResponse;
import com.app.dto.SignupRequest;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository uDao;

@Autowired
private ModelMapper mapper;

@Autowired
private PasswordEncoder encoder;


public User getById(Long uId) {
return uDao.findById(uId).orElseThrow(()->new com.app.custom_exception.ResourceNotFoundException("User Not Found") );
}

@Override
public MyApiResponse updateUser(Long uId, SignupRequest user) {

	User needToUpdate =uDao.findById(uId).orElseThrow(() -> new com.app.custom_exception.ResourceNotFoundException("User id not exists!"));
	mapper.map(user , needToUpdate);
	needToUpdate.setUserId(uId);
	needToUpdate.setPassword(encoder.encode(user.getPassword()));
	
	return new MyApiResponse("User updated successfully!");
}

}