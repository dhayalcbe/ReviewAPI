package com.spring.reviewapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.reviewapi.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	public List<Review> findAllByOrderByRatings();
	
	public List<Review> findByGroupId(long groupId);
	
	@Query("select AVG(ratings) from Review where group_id = :groupid")
	public int getAverageRating(@Param("groupid") long group_id);

}
