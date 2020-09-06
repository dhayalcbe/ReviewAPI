package com.india.review.service.dto.custom;

import java.util.List;

import com.india.review.service.dto.ReviewDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomDTO {

	private Long groupId;
	private double rating;
	List<ReviewDTO> reviews;

}
