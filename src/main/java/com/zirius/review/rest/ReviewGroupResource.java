package com.zirius.review.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zirius.review.dto.ReviewGroupResponse;
import com.zirius.review.repository.model.ReviewGroup;
import com.zirius.review.services.ReviewGroupService;

@RestController
@RequestMapping("/api/review-group")
public class ReviewGroupResource {

	@Autowired
	private ReviewGroupService service;

	@PostMapping
	public ResponseEntity<ReviewGroupResponse> createReviewGroup(@RequestBody ReviewGroup reviewGroup) {
		return service.createReviewGroup(reviewGroup);
	}
}
