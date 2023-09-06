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
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CommentId;
	
	@Column(length = 500)
	private String Comment;

	@Column(name = "likedcount")
	private Integer LikedCount;
	
	@Column(name="dislikedcount")
	private Integer DisLikedCount;
	
	@Column(name = "region")
	private String Region;
	
	@Column(name = "sensational")
	private boolean Sensational;
	
	@Column(length = 200)
	private String Warning;
	
	@Column(name = "date")
	private LocalDate Date;
	
	@Column(name = "useridvoter")
	private Long UserIdVoter;
	
	@Column(name = "useridcandidate")
	private Long UserIdCandidate;

	public Comment(String comment, Integer likedCount, String region, boolean sensational, LocalDate date, Long userIdVoter,
			Long userIdCandidate) {
		super();
		Comment = comment;
		LikedCount = likedCount;
		Region = region;
		Sensational = sensational;
		Date = date;
		UserIdVoter = userIdVoter;
		UserIdCandidate = userIdCandidate;
	}
	
	
}
