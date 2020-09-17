package com.zirius.review.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.zirius.review.util.Constants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsDTO {

	@Valid
	@NotEmpty(message = Constants.REVIEWS_IS_MANDATORY)
	private List<ReviewDTO> reviews;
}
