package com.spring.reviewapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="group_id",nullable = false)
	@JsonIgnore
	private ReviewGroup group;
	private String comments;
	@Column(name = "STAR_RATINGS")
	private int ratings;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ReviewGroup getGroup() {
		return group;
	}

	public void setGroup(ReviewGroup group) {
		this.group = group;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", group=" + group + ", comments=" + comments + ", ratings=" + ratings + "]";
	}

	
}
