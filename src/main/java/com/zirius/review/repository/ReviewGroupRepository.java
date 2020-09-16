package com.zirius.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zirius.review.repository.model.ReviewGroup;

public interface ReviewGroupRepository extends JpaRepository<ReviewGroup, Long>{

}
