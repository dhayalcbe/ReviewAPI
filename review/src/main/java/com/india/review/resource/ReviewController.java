package com.india.review.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.india.review.entity.Review;
import com.india.review.entity.ReviewGroup;
import com.india.review.service.ReviewService;
import com.india.review.service.dto.ReviewDTO;
import com.india.review.service.dto.custom.ResponseCustomDTO;

@RestController
@RequestMapping("/api")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@PostMapping("/createReview")
	public long createReview(@RequestBody ReviewDTO reviewDTO) throws Exception {
		return reviewService.save(reviewDTO);
	}

	@PostMapping("/createReviewGroup")
	public long createReviewGroup(@RequestBody ReviewGroup reviewGroup) throws Exception {
		return reviewService.saveReviewGroup(reviewGroup);
	}

	@GetMapping("/getAllReviewsBasedOnStarRating")
	public List<Review> getAllReviewsBasedOnStarRating() {
		return reviewService.getAll();
	}

	@GetMapping("/averageStartRatingUnderGrp")
	public List<ResponseCustomDTO> averageStartRatingUnderGrp() throws Exception {
		return reviewService.getDataByReviewRating();
	}

	@GetMapping("/averageStartRatingByGrpId/{groupId}")
	public ResponseCustomDTO averageStartRatingByGrpId(@PathVariable Long groupId) throws Exception {
		return reviewService.getDataByReviewRatingByGroupId(groupId);
	}

}
