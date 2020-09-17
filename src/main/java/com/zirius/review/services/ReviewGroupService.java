package com.zirius.review.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zirius.review.dto.ReviewGroupDTO;
import com.zirius.review.dto.ReviewGroupResponse;
import com.zirius.review.error.ErrorDetails;
import com.zirius.review.repository.ReviewGroupRepository;
import com.zirius.review.repository.model.ReviewGroup;
import com.zirius.review.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewGroupService {

	@Autowired
	private ReviewGroupRepository repository;

	@Transactional
	public ResponseEntity<ReviewGroupResponse> createReviewGroup(ReviewGroupDTO reviewGroupDTO) {
		log.info("START:> createReviewGroup");
		ReviewGroupResponse reviewGroupResponse = null;
		ReviewGroup reviewGroup = ReviewGroup.builder().topic(reviewGroupDTO.getTopic()).build();
		ReviewGroup savedEntity = repository.save(reviewGroup);
		reviewGroupResponse = setReviewGroupResponse(HttpStatus.CREATED, Constants.REVIEW_GROUP_CREATED_SUCCESSFULLY,
				savedEntity.getId(), null);
		log.info("END:> createReviewGroup");
		return ResponseEntity.status(reviewGroupResponse.getStatus()).body(reviewGroupResponse);
	}

	private ReviewGroupResponse setReviewGroupResponse(HttpStatus status, String message, Long reviewGroupId,
			ErrorDetails errors) {
		ReviewGroupResponse reviewGroupResponse = new ReviewGroupResponse();
		reviewGroupResponse.setStatus(status);
		reviewGroupResponse.setMessage(message);
		reviewGroupResponse.setReviewGroupId(reviewGroupId);
		reviewGroupResponse.setErrors(errors);
		return reviewGroupResponse;
	}
}
