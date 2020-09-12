package com.zirius.reviewAPI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zirius.reviewAPI.entity.Review;

@Repository
public interface ReviewDao extends JpaRepository<Review,Integer> {

	@Query("SELECT AVG(r.starRatings) FROM Review r where r.reviewGroup.groupId = :groupID")
	public Integer getAverageStarRatings(@Param("groupID") Integer groupId);
	
	@Query("SELECT r FROM Review r where r.reviewGroup.groupId = :groupID")
	public List<Review> findAlLReviewsByGroupId(@Param("groupID") Integer groupId);
	
}
