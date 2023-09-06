package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "candidatedetail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CandidateDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CandidateDetailId;

	@Column(length = 50)
	private String Occupation;

	@Column(length = 50)
	private String Assembly;

	@Column(length = 400)
	private String Work;

	@Column(length = 100)
	private String SocialHandel;

	@Column(length = 200)
	private String Quote;

	@Column
	private boolean CandidateApproval;

	@Column
	private String region;

	@Column
	private String image;

	@Column
	private double polularity;
	
	@Column(length = 500)
	private String messageForLogin;

	public CandidateDetail(String occupation, String assembly, String work, String socialHandel, String quote,
			boolean candidateApproval, String region, String image, double polularity , String messageForLogin) {
		super();
		this.Occupation = occupation;
		this.Assembly = assembly;
		this.Work = work;
		this.SocialHandel = socialHandel;
		this.Quote = quote;
		this.CandidateApproval = candidateApproval;
		this.region = region;
		this.image = image;
		this.polularity = polularity;
		this.messageForLogin=messageForLogin;
	}

}
