package com.zirius.reviewAPI.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zirius.reviewAPI.entity.Review;
import com.zirius.reviewAPI.entity.ReviewGroup;
import com.zirius.reviewAPI.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/addReviewGroup")
	public Integer addReviewGroup(@RequestBody ReviewGroup rg){

		return reviewService.addReviewGroup(rg);
		
	}
	
	@PostMapping("/addReview")
	public Integer addReview(@RequestBody HashMap<?, ?> rg){
		
		ObjectMapper mapper = new ObjectMapper();
		
		Review review = null;
		ReviewGroup reviewGroup = null;
		try {
			review = mapper.convertValue(rg.get("review") , Review.class);
			reviewGroup = mapper.convertValue(rg.get("reviewGroup") , ReviewGroup.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reviewService.addReview(review,reviewGroup );
	}
	
	@GetMapping("/getAllReviewsByRatings")
	public List<Review> getAllReviewsByRatings(){
		
		return reviewService.getAllReviewsByRatings();
	}
	
	@GetMapping("/getAllReviews/{groupId}")
	public HashMap<String, Object> getAllReviews(@PathVariable Integer groupId){
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		response.put("ListOfReviews", reviewService.findAlLReviewsByGroupId(groupId));
		response.put("AverageStarRatings", reviewService.getAverageStarRating(groupId));
		
		return response;
	}
	
	@GetMapping("/getAverageStarRatings/{groupId}")
	public Integer getAverageStarRatings(@PathVariable Integer groupId){
		
		return reviewService.getAverageStarRating(groupId);
	}
	
	@GetMapping("/getReviewGroup")
	public ReviewGroup getReviewGroup(){

		ReviewGroup rg = new ReviewGroup();
		rg.setTopic("Entertainment");
		rg.setGroupId(1);
		rg.setReviews(null);
		
		return rg;
		
	}
}
