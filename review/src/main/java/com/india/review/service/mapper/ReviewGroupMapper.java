package com.india.review.service.mapper;

import org.mapstruct.Mapper;

import com.india.review.entity.ReviewGroup;
import com.india.review.service.dto.ReviewGroupDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ReviewGroupMapper extends BaseMapper<ReviewGroupDTO, ReviewGroup> {
	default ReviewGroup fromId(Long id) {
		if (id == null) {
			return null;
		}
		ReviewGroup reviewGroup = new ReviewGroup();
		reviewGroup.setId(id);
		return reviewGroup;
	}
}
