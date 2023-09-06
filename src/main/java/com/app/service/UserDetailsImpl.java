package com.app.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entities.User;
import com.app.entities.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private String email;
	@JsonIgnore
	private String password;

	private LocalDate dob;
	

	private Collection<? extends GrantedAuthority> authorities;
	
	private UserType userType;

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserDetailsImpl(Long id, String fname, String lname, String email, String pass, LocalDate d,
			Collection<? extends GrantedAuthority> authority ,UserType userType) {
		super();
		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.password = pass;
		this.dob = d;
		this.authorities = authority;
		this.userType=userType;
		
	}

	public static UserDetailsImpl build(User user) {

		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		return new UserDetailsImpl(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPassword(), user.getDOB(), authorities , user.getUsertype());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDob() {
		return dob;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
