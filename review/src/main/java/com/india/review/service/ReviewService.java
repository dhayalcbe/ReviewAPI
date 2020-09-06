package com.india.review.service;

import java.util.List;

import com.india.review.entity.Review;
import com.india.review.entity.ReviewGroup;
import com.india.review.service.dto.ReviewDTO;
import com.india.review.service.dto.custom.ResponseCustomDTO;

public interface ReviewService {

	long save(ReviewDTO reviewDTO) throws Exception;

	List<Review> getAll();

	List<ResponseCustomDTO> getDataByReviewRating() throws Exception;

	ResponseCustomDTO getDataByReviewRatingByGroupId(Long groupId) throws Exception;

	long saveReviewGroup(ReviewGroup reviewGroup);

}
