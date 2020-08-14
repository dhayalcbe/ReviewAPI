package com.interview.review.repo;

import com.interview.review.dto.ReviewGroupDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

@Repository
public interface ReviewGroupDetailsRepository extends JpaRepository<ReviewGroupDetails,Integer> {
	
	
	@Query(value ="SELECT * from review_group_details r where r.review_group_id = :id", nativeQuery = true)
    List<ReviewGroupDetails> findAllByReviewGroupId(@Param("id") int id);
}
