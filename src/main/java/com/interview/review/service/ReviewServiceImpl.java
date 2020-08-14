package com.interview.review.service;

import com.interview.review.dto.Review;
import com.interview.review.dto.ReviewGroup;
import com.interview.review.dto.ReviewGroupDetails;
import com.interview.review.models.ReviewGroupRequestModel;
import com.interview.review.models.ReviewModel;
import com.interview.review.repo.ReviewGroupDetailsRepository;
import com.interview.review.repo.ReviewGroupRepository;
import com.interview.review.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewGroupRepository reviewGroupRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReviewGroupDetailsRepository reviewGroupDetailsRepository;

    @Override
    public int createReviewGroup(ReviewGroupRequestModel reviewGroupModel){
        return reviewGroupRepository.save(convertReviewGroupModelToDto(reviewGroupModel)).getId();
    }

    @Override
    public void insertReviewByGroupId(int groupId,List<ReviewModel> reviewModel){
        reviewModel.stream()
                .filter(reviewDetails ->reviewGroupDetailsRepository.findById(reviewDetails.getQualityId()).isPresent())
                .forEach(reviewDetails -> {
                    reviewRepository.save(buildReviewDto(reviewDetails,reviewGroupDetailsRepository.getOne(reviewDetails.getQualityId()).getId()));
                });
    }
    
    @Override
    public List<ReviewModel> viewRatingList(){
        return reviewRepository.getAllByOrderByRatingDesc().stream()
                .map(ReviewServiceImpl::buildReviewModel)
                .collect(Collectors.toList());
    }

    @Override
    public double calculateAverage(int id){
        List<ReviewGroupDetails> groupDetails = reviewGroupDetailsRepository.findAllByReviewGroupId(id);
        if(groupDetails.isEmpty()) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid group id"); 
        }
        List<Review> ratingList = new ArrayList<>();
        groupDetails.stream().forEach(reviewGroupDetails ->
            ratingList.addAll(reviewGroupDetails.getReview())
        );
        return ratingList.stream().mapToInt(val -> val.getRating()).average().orElse(0.0);
    }

    private static ReviewGroup convertReviewGroupModelToDto(ReviewGroupRequestModel reviewGroupModel){
        return ReviewGroup.builder().groupName(reviewGroupModel.getGroupName())
                .reviewGroupDetails(reviewGroupModel.getQualityName().stream().map(ReviewServiceImpl::convertReviewDetailsModelToDto).collect(Collectors.toList())).build();
    }

    private static Review buildReviewDto(ReviewModel reviewModel, int reviewGroupDetailId){
        return Review.builder().detailId(reviewGroupDetailId)
                .rating(reviewModel.getRatings())
                .comments(reviewModel.getComments()).build();
    }
    private static ReviewModel buildReviewModel(Review review){
        return ReviewModel.builder().comments(review.getComments()).ratings(review.getRating()).build();
    }

    private static ReviewGroupDetails convertReviewDetailsModelToDto(String qualityName){
        return ReviewGroupDetails.builder().qualityName(qualityName).build();
    }
    
}
