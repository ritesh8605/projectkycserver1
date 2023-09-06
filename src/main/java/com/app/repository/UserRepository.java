package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.User;
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
	  Optional<User> findByEmail(String email);

	  Boolean existsByEmail(String email);
	  
	  
	  @Query(value = "SELECT * FROM users WHERE first_name=:CandidateName",nativeQuery = true)
	  List<User> findByName(@Param("CandidateName") String CandidateName);
	  
	
//	    @Modifying
//		@Query(value = "DELETE FROM booking WHERE user_id = :customerid AND package_id = :tourPackageid", nativeQuery = true)
//		void deleteBookingByCustomerAndTourPackage(@Param("customerid") Long customerid, @Param("tourPackageid") Long tourPackageid);
//
//		@Modifying
//		@Query(value = "INSERT INTO cancelation (user_id, package_id) VALUES (:customerid, :tourPackageid)", nativeQuery = true)
//		void insertIntoCancelationByCustomerAndTourPackage(@Param("customerid") Long customerid, @Param("tourPackageid") Long tourPackageid);
//
//		@Modifying
//		@Query(value = "INSERT INTO booking (user_id, package_id) VALUES (:customerid, :tourPackageid)", nativeQuery = true)
//		void addBooking(@Param("customerid") Long customerid, @Param("tourPackageid") Long tourPackageid);
}
