package com.spring.reviewapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.reviewapi.model.ReviewGroup;

public interface ReviewGroupRepository extends JpaRepository<ReviewGroup, Long> {

	public ReviewGroup findByProductId(long productId);
}
