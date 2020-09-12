package com.zirius.reviewAPI.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	public Review(){
		
	}
	
	public Review(String comments, Integer star_ratings, ReviewGroup reviewGroup) {
		super();
		this.comments = comments;
		this.starRatings = star_ratings;
		this.reviewGroup = reviewGroup;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getStar_ratings() {
		return starRatings;
	}

	public void setStar_ratings(Integer star_ratings) {
		this.starRatings = star_ratings;
	}

	public ReviewGroup getReviewGroup() {
		return reviewGroup;
	}

	public void setReviewGroup(ReviewGroup reviewGroup) {
		this.reviewGroup = reviewGroup;
	}

	@Id
	@GeneratedValue
	public Integer reviewId;
	public String comments;
	public Integer starRatings;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public ReviewGroup reviewGroup;
	
}
