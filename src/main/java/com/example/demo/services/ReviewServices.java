package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.ResourceNotFoundExceptions;
import com.example.demo.model.Review;
import com.example.demo.repo.ReviewRepo;

@Service
public class ReviewServices {

	@Autowired
	private ReviewRepo reviewRepo;

	public Double getAvergaStartRatingByGroupId(Long groupId) throws ResourceNotFoundExceptions {
		Optional<Double> optionalAverage = reviewRepo.getAverageStarRatingByGroupId(groupId);
		return optionalAverage.map(i->i).orElseThrow(() -> new ResourceNotFoundExceptions("No data! with groupId:"+groupId));
	}

	public Review createReviewWithGroupId(Review review) {
		return reviewRepo.save(review);
	}

	public List<Review> getReviewsByStartRating(Long groupId) throws ResourceNotFoundExceptions {
		Optional<List<Review>> optionalAverage = reviewRepo.findAllReviewOrderByRating(groupId);
		return optionalAverage.map(i->i).orElseThrow(() -> new ResourceNotFoundExceptions("No data! with groupId:"+groupId));
	}
	
	
	public Review getReviewById(Long reviewId) throws ResourceNotFoundExceptions {
		Optional<Review> optionalAverage = reviewRepo.findById(reviewId);
		return optionalAverage.map(i->i).orElseThrow(() -> new ResourceNotFoundExceptions("No data! with reviewId:"+reviewId));
	}

}
