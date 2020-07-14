package com.spring.reviewapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

@Service
public class ReviewServiceImpl implements ReviewService {	
	
	@Value("${com.sping.reviewapi.review.success.msg}")
	private String REVIEW_SUCCESS_MSG ; 

	@Value("${com.sping.reviewapi.reviewgroup.success.msg}")
	private String REVIEW_GROUP_SUCCESS_MSG ;

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	ReviewGroupRepository groupRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<ReviewResponse> getReviewResponse() {
		List<Review> review = reviewRepository.findAllByOrderByRatings();
		List<ReviewResponse> response = new ArrayList<ReviewResponse>();
		for(Review l:review){
			ReviewResponse reviewResponse = new ReviewResponse();
			reviewResponse.setComments(l.getComments());
			reviewResponse.setProductName(l.getGroup().getProduct().getProductName());
			reviewResponse.setProductType(l.getGroup().getProduct().getProductType());
			reviewResponse.setPrice(l.getGroup().getProduct().getPrice());
			reviewResponse.setSpecification(l.getGroup().getProduct().getSpecification());
			reviewResponse.setRating(l.getRatings());
			response.add(reviewResponse);
		}
		return response;
	}

	@Override
	public AvgReviewResponse getAvgReviewResponse(long groupId) {
		ReviewGroup group = groupRepository.findById(groupId).get();
		int avgRating = reviewRepository.getAverageRating(groupId);
		AvgReviewResponse response = new AvgReviewResponse();
		response.setAvgReview(avgRating);
		response.setPrice(group.getProduct().getPrice());
		response.setProductName(group.getProduct().getProductName());
		response.setProductType(group.getProduct().getProductType());
		response.setSpecification(group.getProduct().getSpecification());
		response.setReviewGroupId(group.getId());
		return response;
	}

	@Override
	public SuccessResponse createReviewGroup(long productId) {
		Optional<Product> product = productRepository.findById(productId);
		Product productToBeAdded = null;
		if(product.isPresent()){
			productToBeAdded = product.get();
		}
		ReviewGroup group = new ReviewGroup();
		group.setProduct(productToBeAdded);	
		ReviewGroup groupAdded = groupRepository.save(group);
		SuccessResponse response = new SuccessResponse();
		response.setId(groupAdded.getId());
		response.setMsg(REVIEW_GROUP_SUCCESS_MSG);
		return response ;
	}

	@Override
	public SuccessResponse createReview(ReviewRequest reviewRequest) {
		ReviewGroup group = groupRepository.findByProductId(reviewRequest.getProductId());;
		Review review = new Review();
		review.setComments(reviewRequest.getComments());
		review.setGroup(group);
		review.setRatings(reviewRequest.getRatings());
		Review reviewAdded = reviewRepository.save(review);
		SuccessResponse response = new SuccessResponse();
		response.setId(reviewAdded.getId());
		response.setMsg(REVIEW_SUCCESS_MSG);
		return response;
	}

	@Override
	public ReviewByProductResponse getReviewResponseById(long productId) {
		ReviewByProductResponse response = new ReviewByProductResponse();
		Product product = productRepository.findById(productId).get();
		ReviewGroup group = groupRepository.findByProductId(productId);
		List<Review> review = reviewRepository.findByGroupId(group.getId());
		int avgRating = reviewRepository.getAverageRating(group.getId());
		response.setAvgRating(avgRating);
		response.setPrice(product.getPrice());
		response.setProductId(product.getId());
		response.setProductName(product.getProductName());
		response.setProductType(product.getProductType());
		response.setReviews(review);
		response.setSpecification(product.getSpecification());
		return response;
	}

}
