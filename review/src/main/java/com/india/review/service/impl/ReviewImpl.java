package com.india.review.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.india.review.entity.Review;
import com.india.review.entity.ReviewGroup;
import com.india.review.repository.ReviewGroupRepository;
import com.india.review.repository.ReviewRepository;
import com.india.review.service.ReviewService;
import com.india.review.service.dto.ReviewDTO;
import com.india.review.service.dto.custom.ResponseCustomDTO;
import com.india.review.service.mapper.ReviewMapper;

@Service
public class ReviewImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	ReviewMapper reviewMapper;

	@Autowired
	ReviewGroupRepository reviewGroupRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public long save(ReviewDTO reviewDTO) throws Exception {
		try {
			Objects.requireNonNull(reviewDTO.getGroupId(), "Review Group Id Cannot Be null");
			Objects.requireNonNull(reviewDTO.getStartRating(), "Rating Cannot Be null");
			return reviewRepository.save(reviewMapper.toEntity(reviewDTO)).getId();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Review> getAll() {
		try {
			return reviewRepository.findAll().stream().sorted(Comparator.comparing(Review::getStartRating))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ResponseCustomDTO> getDataByReviewRating() throws Exception {
		List<ResponseCustomDTO> result = new ArrayList<ResponseCustomDTO>();
		try {
			reviewRepository.findAll().stream().collect(Collectors.groupingBy(data -> data.getGroup()))
					.forEach((key, values) -> {
						double average = values.stream().mapToLong(mapper -> mapper.getStartRating()).average()
								.orElse(0.0);
						result.add(new ResponseCustomDTO(key.getId(), average, reviewMapper.toDto(values)));
					});
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ResponseCustomDTO getDataByReviewRatingByGroupId(Long groupId) throws Exception {
		try {
			List<Review> reviews = reviewRepository.findByGroup_id(groupId);
			if (reviews.size() > 0) {
				double average = reviews.stream().mapToLong(mapper -> mapper.getStartRating()).average().orElse(0.0);
				return new ResponseCustomDTO(reviews.get(0).getGroup().getId(), average, reviewMapper.toDto(reviews));
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public long saveReviewGroup(ReviewGroup reviewGroup) {
		try {
			ReviewGroup savedReviewGroup = reviewGroupRepository.save(reviewGroup);
			return savedReviewGroup.getId();
		} catch (Exception e) {
			throw e;
		}
	}
}
