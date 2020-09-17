package com.zirius.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zirius.review.repository.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
