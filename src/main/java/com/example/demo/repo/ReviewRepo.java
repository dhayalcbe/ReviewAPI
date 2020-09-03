package com.example.demo.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Review;

@Repository
public interface ReviewRepo  extends JpaRepository<Review, Long>
{


	@Query("select avg(r.starRating) from Review  r  INNER JOIN r.reviewGroup p  where p.id = :groupId")
	public Optional<Double> getAverageStarRatingByGroupId(@Param("groupId") Long groupId);
	
	@Query("select r from Review  r  INNER JOIN r.reviewGroup p  where p.id = :groupId order by r.starRating  desc")
	public Optional <List<Review>> findAllReviewOrderByRating(@Param("groupId") Long groupId);
	
	
}
