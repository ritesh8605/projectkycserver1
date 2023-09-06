package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Region;

@Transactional
@Repository
public interface RegionRepository extends JpaRepository<Region, Long>{
	
	
	List<Region> findAll();

}
