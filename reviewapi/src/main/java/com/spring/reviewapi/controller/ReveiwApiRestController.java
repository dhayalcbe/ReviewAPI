package com.spring.reviewapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.reviewapi.dto.AvgReviewResponse;
import com.spring.reviewapi.dto.ReviewByProductResponse;
import com.spring.reviewapi.dto.ReviewRequest;
import com.spring.reviewapi.dto.ReviewResponse;
import com.spring.reviewapi.dto.SuccessResponse;
import com.spring.reviewapi.model.Product;
import com.spring.reviewapi.model.Review;
import com.spring.reviewapi.model.ReviewGroup;
import com.spring.reviewapi.repo.ProductRepository;
import com.spring.reviewapi.repo.ReviewGroupRepository;
import com.spring.reviewapi.repo.ReviewRepository;
import com.spring.reviewapi.service.ReviewService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReveiwApiRestController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ReviewGroupRepository reviewGroupRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	ReviewService service;
	
	@PostMapping("/review/Group/{id}")
	public SuccessResponse createGroup(@PathVariable("id") long id){
		return service.createReviewGroup(id);
	}
	
	@PostMapping("/review")
	public SuccessResponse createReview(@RequestBody ReviewRequest reviewRequest){
		System.out.println("Hi");
		return service.createReview(reviewRequest);
	}
	
	@GetMapping("/review")
	public List<ReviewResponse> getReview(){
		return service.getReviewResponse();
	}
	
	@GetMapping("/review/avgreview/{id}")
	public AvgReviewResponse getAverageReview(@PathVariable("id") long groupId){
		return service.getAvgReviewResponse(groupId);
	}
	
	@GetMapping("/review/{id}")
	public ReviewByProductResponse getReviewById(@PathVariable("id") long productId){
		return service.getReviewResponseById(productId);
	}
}
