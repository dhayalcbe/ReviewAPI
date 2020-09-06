package com.india.review.service.dto;

import lombok.Data;

@Data
public class ReviewDTO {
	private Long id;

	private String comments;

	private long startRating;

	private long groupId;
}
