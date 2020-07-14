package com.spring.reviewapi.service;

import java.util.List;

import com.spring.reviewapi.dto.AvgReviewResponse;
import com.spring.reviewapi.dto.ReviewByProductResponse;
import com.spring.reviewapi.dto.ReviewRequest;
import com.spring.reviewapi.dto.ReviewResponse;
import com.spring.reviewapi.dto.SuccessResponse;
import com.spring.reviewapi.model.Review;

public interface ReviewService {
	public List<ReviewResponse> getReviewResponse();

	public AvgReviewResponse getAvgReviewResponse(long groupId);
	
	public SuccessResponse createReviewGroup(long productId);
	
	public SuccessResponse createReview(ReviewRequest reviewRequest);
	
	public ReviewByProductResponse getReviewResponseById(long productId);
}
