package com.interview.review.controller;

import com.interview.review.models.RatingRequestModel;
import com.interview.review.models.ReviewGroupRequestModel;
import com.interview.review.models.ReviewModel;
import com.interview.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewApiController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/creategroup")
    public ResponseEntity<Integer> createReviewGroup(@RequestBody ReviewGroupRequestModel requestModel){
        return ResponseEntity.ok().body(reviewService.createReviewGroup(requestModel));
    }

    @PostMapping("/addreview/{groupId}")
    public ResponseEntity<String> createReviewGroup(@PathVariable("groupId") int groupId, @RequestBody List<ReviewModel> requestModels){
        reviewService.insertReviewByGroupId(groupId,requestModels);
        return ResponseEntity.ok("Review Group Created");
    }

    @GetMapping("/viewall")
    public ResponseEntity<List<ReviewModel>> viewAllReviews(){
        return ResponseEntity.ok().body(reviewService.viewRatingList());
    }

    @GetMapping("/average/{groupId}")
    public ResponseEntity<Double> calculateAverage(@PathVariable("groupId") int groupId){
        return ResponseEntity.ok().body(reviewService.calculateAverage(groupId));
    }


}
