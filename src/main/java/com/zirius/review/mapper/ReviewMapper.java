package com.zirius.review.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zirius.review.dto.ReviewDTO;
import com.zirius.review.repository.model.Review;
import com.zirius.review.util.StarRating;

@Mapper(config = ReviewMapperConfig.class)
public interface ReviewMapper {

	@Mapping(source = "reviewGroupId", target = "reviewGroup.id")
	@Mapping(source = "starRating.value", target = "starRating")
	Review toReview(ReviewDTO reviewDTO);
	
	List<Review> toReviews(List<ReviewDTO> reviewDTOList);
	
	default ReviewDTO toReviewDTO(Review review) {
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setComments(review.getComments());
		reviewDTO.setStarRating(StarRating.StarRatingMap.get(review.getStarRating()));
		reviewDTO.setReviewGroupId(review.getReviewGroup().getId());
		return reviewDTO;
	}
	
	List<ReviewDTO> toReviewDTOs(List<Review> review);
}
