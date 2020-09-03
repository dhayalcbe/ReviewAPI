package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.ResourceNotFoundExceptions;
import com.example.demo.model.Review;
import com.example.demo.services.ReviewServices;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	private ReviewServices reviewServices;

	@PostMapping("/create")
	public Review createReviewWithReviewGroup(@RequestBody Review review) {
		return reviewServices.createReviewWithGroupId(review);

	}

	@GetMapping("/findall/{groupId}")
	public List<Review> getReviewByStarRating(@PathVariable Long groupId) throws ResourceNotFoundExceptions {
		return reviewServices.getReviewsByStartRating(groupId);

	}

	@GetMapping("/findaverage/{groupId}")
	public Double  getAvergaStartRatingByGroupId(@PathVariable Long groupId) throws ResourceNotFoundExceptions {
		return reviewServices.getAvergaStartRatingByGroupId(groupId);

	}
	
	
	@GetMapping("/findreview/{reviewId}")
	public Review  getReviewById(@PathVariable Long reviewId) throws ResourceNotFoundExceptions {
		return reviewServices.getReviewById(reviewId);

	}
	
	
}
