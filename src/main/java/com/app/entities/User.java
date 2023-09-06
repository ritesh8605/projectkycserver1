package com.app.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password" )
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(length = 20,nullable = false)
	private String firstName;
	
	@Column(length = 20,nullable = false)
	private String lastName;
	
	@Column(length = 30,nullable = false,unique = true)
	private String email;
	
	@JsonIgnore
	@Column(length = 300,nullable = false)
	private String password;
	
	@Column
	private LocalDate DOB;
	
	@Column
	private String Contact;
	
	@Column(length = 50)
	private String AgeProof;
	
	@Column
	private boolean BlockStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private UserType usertype;
	
	@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	private CandidateDetail candidatedetail;
	
	@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	private Address address;
	
	@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	private ExDetail exdetail;
	
	@OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	  private Set<Role> roles = new HashSet<>();
	
	public User( String firstName, String lastName, String email, String password, LocalDate dOB,
			String contact, String ageProof, boolean blockStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		DOB = dOB;
		Contact = contact;
		AgeProof = ageProof;
		BlockStatus = blockStatus;
	}

//	public Collection<? extends GrantedAuthority> getRoles() {
//		// TODO Auto-generated method stub
//		return getRoles();
//	}
	
//	@ManyToMany(cascade = CascadeType.PERSIST) // mandatory!
//	@JoinTable(name="user_hotels",
//	joinColumns = @JoinColumn(name="user_id"),
//	inverseJoinColumns = @JoinColumn(name="hotel_id")
//	)
//	private Set<Hotel> hotels =new HashSet<>();
	
//	@ManyToMany
//	@JoinTable(name ="booking",
//	joinColumns = @JoinColumn(name="user_id"),
//	inverseJoinColumns =@JoinColumn(name="package_id")
//	)
//	private Set<TourPackage> assignPackage= new HashSet<TourPackage>();
	
	
//	
//	@ManyToMany(cascade = CascadeType.MERGE)
//	  @JoinTable(  name = "user_roles", 
//	        joinColumns = @JoinColumn(name = "user_id"), 
//	        inverseJoinColumns = @JoinColumn(name = "role_id"))
//	  private Set<Role> roles = new HashSet<>();
	

}
