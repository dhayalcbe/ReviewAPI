package com.zirius.reviewAPI.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zirius.reviewAPI.dao.ReviewDao;
import com.zirius.reviewAPI.dao.ReviewGroupDao;
import com.zirius.reviewAPI.entity.Review;
import com.zirius.reviewAPI.entity.ReviewGroup;

@Service
public class ReviewService {

	@Autowired
	ReviewGroupDao reviewGroupDao;
	@Autowired
	ReviewDao reviewDao;
	
	public Integer addReviewGroup(ReviewGroup rg){
		
		ReviewGroup obj = reviewGroupDao.save(rg);
		return obj.getGroupId();
		
	}
	
	public Integer addReview(Review review, ReviewGroup reviewGroup){
		

		reviewGroup.getReviews().add(review);
		review.setReviewGroup(reviewGroup);
		reviewDao.save(review);
		
		return reviewGroup.getGroupId();
		
	}
	
	public List<Review> getAllReviewsByRatings(){
		
		return reviewDao.findAll(Sort.by(Sort.Direction.DESC, "starRatings"));
		
	}
	
	
	public Integer getAverageStarRating(Integer groupId){
		
		
		return reviewDao.getAverageStarRatings(groupId);
	}
	
	public List<Review> findAlLReviewsByGroupId(Integer groupId){
		
		return reviewDao.findAlLReviewsByGroupId(groupId);
		
	}
	
	
}
