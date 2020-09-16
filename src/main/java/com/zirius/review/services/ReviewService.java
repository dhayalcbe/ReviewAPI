package com.zirius.review.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zirius.review.dto.AverageRatingResponse;
import com.zirius.review.dto.ReviewResponse;
import com.zirius.review.dto.ReviewsDTO;
import com.zirius.review.error.ErrorDetails;
import com.zirius.review.mapper.ReviewMapper;
import com.zirius.review.repository.CustomReviewRepository;
import com.zirius.review.repository.ReviewRepository;
import com.zirius.review.repository.model.Review;
import com.zirius.review.util.Constants;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private CustomReviewRepository customReviewRepository;

	@Autowired
	private ReviewMapper reviewMapper;

	@Transactional
	public ResponseEntity<ReviewResponse> createReviews(ReviewsDTO reviewsDTO) {
		ReviewResponse reviewResponse = null;
		List<Review> reviews = reviewMapper.toReviews(reviewsDTO.getReviews());
		if (!CollectionUtils.isEmpty(reviews)) {
			reviewRepository.saveAll(reviews);
			reviewResponse = getReviewResponse(HttpStatus.CREATED, Constants.REVIEWS_SAVE_SUCCESSFUL, reviewsDTO, null);
		} else {
			reviewResponse = getReviewResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.REVIEWS_SAVE_FAILED, null,
					ErrorDetails.builder().errorMessage(Constants.REVIEWS_SAVE_FAILED).build());
		}

		return ResponseEntity.status(reviewResponse.getStatus()).body(reviewResponse);
	}

	public ResponseEntity<ReviewResponse> getReviews(Long reviewGroupId) {
		List<Review> reviews = null;
		ReviewResponse reviewResponse = null;
		ReviewsDTO reviewsDTO = new ReviewsDTO();
		if (null != reviewGroupId) {
			reviews = customReviewRepository.getReviewsByReviewGroupId(reviewGroupId);
		} else {
			reviews = reviewRepository.findAll();
		}
		reviewsDTO.setReviews(reviewMapper.toReviewDTOs(reviews));
		reviewResponse = getReviewResponse(HttpStatus.OK, Constants.REVIEW_RETRIEVED_SUCCESSFULLY, reviewsDTO, null);
		return ResponseEntity.status(reviewResponse.getStatus()).body(reviewResponse);
	}

	public ResponseEntity<AverageRatingResponse> getAverageRating(Long reviewGroupId) {
		AverageRatingResponse averageRatingresponse = null;
		List<Review> reviews = customReviewRepository.getReviewsByReviewGroupId(reviewGroupId);
		if (!CollectionUtils.isEmpty(reviews)) {
			int noOfRatings = reviews.size();
			float sumOfRatings = 0;
			for (Review review : reviews) {
				sumOfRatings = sumOfRatings + review.getStarRating();
			}
			float average = sumOfRatings / noOfRatings;
			String averageRating = String.format("%.2f", average);
			averageRatingresponse = getAverageRatingResponse(HttpStatus.OK, Constants.RETRIEVE_AVERAGE_RATING_SUCCESSFUL, averageRating, null);
		} else {
			averageRatingresponse = getAverageRatingResponse(HttpStatus.BAD_REQUEST, Constants.RETRIEVE_AVERAGE_RATING_UNSUCCESSFUL, null,
					ErrorDetails.builder().errorMessage(Constants.NO_REVIEWS_FOUND).build());
		}
		return ResponseEntity.status(averageRatingresponse.getStatus()).body(averageRatingresponse);
	}

	private ReviewResponse getReviewResponse(HttpStatus status, String message, ReviewsDTO reviewsDTO,
			ErrorDetails errors) {
		ReviewResponse reviewResponse = new ReviewResponse();
		reviewResponse.setStatus(status);
		reviewResponse.setMessage(message);
		reviewResponse.setReviews(reviewsDTO);
		reviewResponse.setErrors(errors);
		return reviewResponse;
	}

	private AverageRatingResponse getAverageRatingResponse(HttpStatus status, String message, String averageRating,
			ErrorDetails errors) {
		AverageRatingResponse averageRatingResponse = new AverageRatingResponse();
		averageRatingResponse.setStatus(status);
		averageRatingResponse.setMessage(message);
		averageRatingResponse.setAverageRating(averageRating);
		averageRatingResponse.setErrors(errors);
		return averageRatingResponse;
	}

}
