package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Problem;

@Transactional
@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {

	@Query(value ="SELECT * FROM problem WHERE region=:Region ORDER BY likedcount DESC LIMIT 10" ,nativeQuery = true)
	List<Problem> getCandidateregionMostLikedPrb(@Param("Region") String Region);

	@Query(value ="SELECT * FROM problem WHERE sensational = true ORDER BY likedcount DESC LIMIT 10" ,nativeQuery = true)
	List<Problem> getMostSensationalPrb();

	@Query(value ="SELECT * FROM problem ORDER BY popularity DESC LIMIT 10" ,nativeQuery = true)
	List<Problem> getMostPopularCandidate();

	@Query(value ="SELECT * FROM problem ORDER BY likedcount DESC LIMIT 10" ,nativeQuery = true)
	List<Problem> getMostLikedPrb();

	@Query(value ="SELECT * FROM problem ORDER BY dislikedcount DESC LIMIT 10" ,nativeQuery = true)
	List<Problem> getMostUnlikedPrb();

	@Query(value ="SELECT * FROM problem ORDER BY date DESC LIMIT 10" ,nativeQuery = true)
	List<Problem> getMostRecentPrb();

	@Modifying
	@Query(value ="UPDATE problem SET sensational = true WHERE problem_id =:ProblemId " ,nativeQuery = true)
	void giveSensationalTag(@Param("ProblemId") Long ProblemId);

	@Modifying
	@Query(value ="UPDATE problem SET warning =:Warning WHERE problem_id=:ProblemId" ,nativeQuery = true)
	void giveWarningMsg(@Param("ProblemId") Long ProblemId,@Param("Warning") String Warning);

	
	@Query(value ="SELECT * FROM probelm WHERE useridcandidate=:UserIdCandidate" ,nativeQuery = true)
	List<Problem> searchPrbByCandidatename(@Param("UserIdCandidate") Long UserIdCandidate);

	@Query(value ="SELECT * FROM problem WHERE region=:Region AND sensational = true ORDER BY likedcount DESC LIMIT 10" ,nativeQuery = true)
	List<Problem> sensationalProblemByRegion(@Param("Region") String Region);

	@Query(value ="SELECT * FROM problem WHERE useridcandidate=:UserIdCandidate" ,nativeQuery = true)
	List<Problem> getMyPrb(@Param("UserIdCandidate") Long UserIdCandidate);

	@Query(value ="SELECT * FROM problem WHERE useridcandidate=:UserIdCandidate ORDER BY date DESC LIMIT 20" ,nativeQuery = true)
	List<Problem> myMostrecentLikedPrb(@Param("UserIdCandidate") Long UserIdCandidate);

	@Query(value ="SELECT * FROM problem WHERE region=:Region AND sensational = true ORDER BY likedcount DESC LIMIT 10" ,nativeQuery = true)
	List<Problem> myRegionMostUnlikedPrb(@Param("Region") String Region);

}
