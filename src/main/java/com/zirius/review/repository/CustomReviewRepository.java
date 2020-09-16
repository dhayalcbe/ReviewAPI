package com.zirius.review.repository;

import java.util.List;

import com.zirius.review.repository.model.Review;

public interface CustomReviewRepository {

	List<Review> getReviewsByReviewGroupId(Long reviewGroupId);
}
