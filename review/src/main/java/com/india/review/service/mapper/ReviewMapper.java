package com.india.review.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.india.review.entity.Review;
import com.india.review.service.dto.ReviewDTO;

@Mapper(componentModel = "spring", uses = { ReviewGroupMapper.class })
public interface ReviewMapper extends BaseMapper<ReviewDTO, Review> {

	@Mapping(source = "group.id", target = "groupId")
	ReviewDTO toDto(Review review);

	@Mapping(source = "groupId", target = "group")
	Review toEntity(ReviewDTO dto);

	default Review fromId(Long id) {
		if (id == null) {
			return null;
		}
		Review review = new Review();
		review.setId(id);
		return review;
	}

}
