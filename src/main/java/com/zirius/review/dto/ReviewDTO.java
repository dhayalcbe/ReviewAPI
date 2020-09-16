package com.zirius.review.dto;

import javax.validation.constraints.NotBlank;

import com.zirius.review.util.Constants;
import com.zirius.review.util.StarRating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

	private Long reviewGroupId;
	
	@NotBlank(message = Constants.COMMENTS_MANDATORY)
	private String comments;
	
	private StarRating starRating;
	
}
