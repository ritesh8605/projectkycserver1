package com.app.entities;

import java.time.LocalDate;
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
@Table(name = "problem")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Problem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProblemId;
	
	@Column(length = 500)
	private String Problem;
	
	@Column(name = "likedcount")
	private Integer LikedCount;
	
	@Column(name = "dislikedcount")
	private Integer DislikedCount = 0;
	
	@Column(name = "sensational")
	private boolean Sensational;
	
	@Column(length = 200 ,name = "warning")
	private String Warning;
	
	@Column(length = 50 ,name = "region")
	private String Region;
	
	@Column(name = "popularity")
	private double Popularity;
	
	@Column(name = "date")
	private LocalDate Date;
	
	@Column(name = "useridvoter")
	private  Long UserIdVoter;
	
	@Column(name = "useridcandidate")
	private Long UserIdCandidate;

	public Problem(String problem, Integer likedCount, Integer dislikedCount, boolean sensational, String region,
			double popularity, LocalDate date, Long userIdVoter, Long userIdCandidate) {
		super();
		Problem = problem;
		LikedCount = likedCount;
		DislikedCount = dislikedCount;
		Sensational = sensational;
		Region = region;
		Popularity = popularity;
		Date = date;
		UserIdVoter = userIdVoter;
		UserIdCandidate = userIdCandidate;
	}


}
