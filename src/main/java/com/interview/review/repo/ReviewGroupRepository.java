package com.interview.review.repo;

import com.interview.review.dto.Review;
import com.interview.review.dto.ReviewGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewGroupRepository extends JpaRepository<ReviewGroup,Integer> {


}
