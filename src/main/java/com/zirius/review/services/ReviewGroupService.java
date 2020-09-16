package com.zirius.review.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zirius.review.dto.ReviewGroupResponse;
import com.zirius.review.error.ErrorDetails;
import com.zirius.review.repository.ReviewGroupRepository;
import com.zirius.review.repository.model.ReviewGroup;
import com.zirius.review.util.Constants;

@Service
public class ReviewGroupService {

	@Autowired
	private ReviewGroupRepository repository;

	@Transactional
	public ResponseEntity<ReviewGroupResponse> createReviewGroup(ReviewGroup reviewGroup) {
		ReviewGroupResponse reviewGroupResponse;
		ReviewGroup savedEntity = repository.save(reviewGroup);
		if (null != savedEntity) {
			reviewGroupResponse = getReviewGroupResponse(HttpStatus.CREATED,
					Constants.REVIEW_GROUP_CREATED_SUCCESSFULLY, savedEntity.getId(), null);
		} else {
			reviewGroupResponse = getReviewGroupResponse(HttpStatus.INTERNAL_SERVER_ERROR,
					Constants.FAILED_TO_CREATE_REVIEW_GROUP, null,
					ErrorDetails.builder().errorMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build());
		}
		return ResponseEntity.status(reviewGroupResponse.getStatus()).body(reviewGroupResponse);
	}

	private ReviewGroupResponse getReviewGroupResponse(HttpStatus status, String message, Long reviewGroupId, ErrorDetails errors)
	{
		ReviewGroupResponse reviewGroupResponse = new ReviewGroupResponse();
		reviewGroupResponse.setStatus(status);
		reviewGroupResponse.setMessage(message);
		reviewGroupResponse.setReviewGroupId(reviewGroupId);
		reviewGroupResponse.setErrors(errors);
		return reviewGroupResponse;
	}
}
