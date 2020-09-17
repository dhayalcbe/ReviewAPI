package com.zirius.review.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class ReviewDTO implements Comparable<ReviewDTO> {

	@NotNull(message = Constants.REVIEW_GROUP_ID_MANDATORY)
	private Long reviewGroupId;
	
	@NotBlank(message = Constants.COMMENTS_MANDATORY)
	private String comments;
	
	@NotNull(message = Constants.STAR_RATING_MANDATORY)
	private StarRating starRating;

	@Override
	public int compareTo(ReviewDTO reviewDTO) {
		if(this.getStarRating().getValue() > reviewDTO.getStarRating().getValue()) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
