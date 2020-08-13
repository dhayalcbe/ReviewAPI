package com.interview.review.repo;

import com.interview.review.dto.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {

    List<Review> getAllByOrderByRatingDesc();
}
