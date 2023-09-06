package com.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Feedback;

@Repository
@Transactional
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
	
	List<Feedback> findAll();
	
	@Modifying
	@Query(value = "DELETE FROM feedback  where userid = :UserId",nativeQuery = true)
	void DeleteById(@Param("UserId") Long UserId);
	
	
	

}
