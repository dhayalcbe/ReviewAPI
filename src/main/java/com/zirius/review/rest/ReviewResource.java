package com.zirius.review.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zirius.review.dto.AverageRatingResponse;
import com.zirius.review.dto.ReviewResponse;
import com.zirius.review.dto.ReviewsDTO;
import com.zirius.review.services.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewResource {

	@Autowired
	private ReviewService reviewService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReviewResponse> createReviews(@RequestBody @Valid ReviewsDTO reviewsDTO) {
		return reviewService.createReviews(reviewsDTO);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReviewResponse> getReviews(
			@RequestParam(value = "reviewGroupId", required = false) Long reviewGroupId) {
		return reviewService.getReviews(reviewGroupId);
	}

	@GetMapping(value = "/average-rating", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AverageRatingResponse> getAverageRating(@RequestParam Long reviewGroupId) {
		return reviewService.getAverageRating(reviewGroupId);
	}
}
