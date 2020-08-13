package com.interview.review.service;

import com.interview.review.models.ReviewGroupRequestModel;
import com.interview.review.models.ReviewModel;

import java.util.List;

public interface ReviewService {

    int createReviewGroup(ReviewGroupRequestModel reviewGroupModel);

    void insertReviewByGroupId(int groupId,List<ReviewModel> reviewModel);

    List<ReviewModel> viewRatingList();

    double calculateAverage(int groupId);
}
