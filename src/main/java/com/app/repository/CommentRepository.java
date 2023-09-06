package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Comment;

@Transactional
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query(value =  "SELECT * FROM comment WHERE sensational = true",nativeQuery = true)
	List<Comment> getSensationalCmt();

	@Query(value = "SELECT * FROM comment ORDER BY date DESC limit 10",nativeQuery = true)
	List<Comment> getRecentComment();

	@Modifying
	@Query(value = "UPDATE comment  SET sensational = true WHERE comment_id=:CommentId",nativeQuery = true)
	void giveSensationalTag(@Param("CommentId") Long CommentId);

	@Modifying
	@Query(value ="UPDATE comment  SET warning = :Warning WHERE comment_id = :CommentId" ,nativeQuery = true)
	void giveWarningMsg(@Param("CommentId") Long CommentId, @Param("Warning") String Warning);

	@Query(value ="SELECT * FROM comment WHERE useridcandidate =:UserIdCandidate ",nativeQuery = true)
	List<Comment> getCommentByCandidateName(@Param("UserIdCandidate") Long UserIdCandidate);

	@Modifying
	@Query(value ="UPDATE comment  SET  likedcount =:LikedCount WHERE comment_id =:CommentId",nativeQuery = true)
	void giveLikeToCmt( @Param("CommentId") Long CommentId , @Param("LikedCount") Integer LikedCount);
	
	@Modifying
	@Query(value ="UPDATE comment  SET  dislikedcount =:DisLikedCount WHERE comment_id =:CommentId",nativeQuery = true)
	void giveDislikeToCmt( @Param("CommentId") Long CommentId , @Param("DisLikedCount") Integer DisLikedCount);


	@Query(value ="SELECT * FROM comment WHERE useridvoter =:UserIdVoter",nativeQuery = true)
	List<Comment> getYoursCmt( @Param("UserIdVoter") Long UserIdVoter);

	@Query(value ="SELECT * FROM comment WHERE useridcandidate=:UserIdCandidate ORDER BY date DESC LIMIT 10",nativeQuery = true)
	List<Comment> getMyRecentAndLikedCmt(@Param("UserIdCandidate") Long UserIdCandidate);

	@Query(value ="SELECT * FROM comment WHERE useridcandidate=:UserIdCandidate AND sensational = true ORDER BY date DESC ",nativeQuery = true)
	List<Comment> getMyRecentAndSensationalCmt( @Param("UserIdCandidate") Long UserIdCandidate);

	@Query(value ="SELECT * FROM comment WHERE region=:Region ORDER BY likedcount DESC LIMIT 20",nativeQuery = true)
	List<Comment> getMyRegionMostLikedCmt(@Param("Region") String Region);

	@Query(value ="SELECT * FROM comment WHERE region=:Region ORDER BY dislikedcount DESC LIMIT 20",nativeQuery = true)
	List<Comment> getMyRegionMostUnlikedCmt(@Param("Region") String Region);

	@Query(value ="SELECT * FROM comment ORDER BY likedcount DESC LIMIT 20",nativeQuery = true)
	List<Comment> getGlobalMostLikedCmt();

	@Query(value ="SELECT * FROM comment ORDER BY dislikedcount DESC LIMIT 20",nativeQuery = true)
	List<Comment> getGlobalMostUnlikedCmt();
}
