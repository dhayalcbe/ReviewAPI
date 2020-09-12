package com.zirius.reviewAPI.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ReviewGroup {

	public ReviewGroup() {
		
	}
	
	public ReviewGroup(String topic) {
		this.topic = topic;
	}
	
	@Id
	@GeneratedValue
	public Integer groupId;
	public String topic;
	
	
	public Integer getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@JsonIgnore
	@OneToMany
	public List<Review> reviews = new ArrayList<Review>();

}
