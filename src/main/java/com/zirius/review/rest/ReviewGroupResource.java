package com.zirius.review.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zirius.review.dto.ReviewGroupDTO;
import com.zirius.review.dto.ReviewGroupResponse;
import com.zirius.review.services.ReviewGroupService;

@RestController
@RequestMapping("/api/review-group")
public class ReviewGroupResource {

	@Autowired
	private ReviewGroupService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReviewGroupResponse> createReviewGroup(@RequestBody ReviewGroupDTO reviewGroupDTO) {
		return service.createReviewGroup(reviewGroupDTO);
	}
}
