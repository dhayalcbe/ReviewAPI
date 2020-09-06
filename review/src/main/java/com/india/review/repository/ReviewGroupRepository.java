package com.india.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.india.review.entity.ReviewGroup;

@Repository
public interface ReviewGroupRepository extends JpaRepository<ReviewGroup, Long> {

}
