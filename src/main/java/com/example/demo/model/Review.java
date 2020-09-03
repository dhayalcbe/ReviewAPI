package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="review")
public class Review  implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  id;
	private  String comments;
	private Integer starRating;
	
	public Review() {
	}
	   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "review_groupId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private  ReviewGroup reviewGroup;
	
	public Long  getId() {
		return id;
	}
	public void setId(Long  id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getStarRating() {
		return starRating;
	}
	public void setStarRating(Integer starRating) {
		this.starRating = starRating;
	}
	public ReviewGroup getReviewGroup() {
		return reviewGroup;
	}
	public void setReviewGroup(ReviewGroup reviewGroup) {
		this.reviewGroup = reviewGroup;
	}
	
	
	
	
	
	
	
	
}
