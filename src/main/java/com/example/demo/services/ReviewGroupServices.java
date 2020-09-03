package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.ResourceNotFoundExceptions;
import com.example.demo.model.ReviewGroup;
import com.example.demo.repo.ReviewGroupRepo;

@Service
public class ReviewGroupServices {
	
	@Autowired
	private ReviewGroupRepo reviewGroupRepo;
	
	
	public Long createReviewGroup(ReviewGroup reviewGroup) throws ResourceNotFoundExceptions
	{
		try {
			return reviewGroupRepo.save(reviewGroup).getId();

		} catch (IllegalArgumentException e) {
           throw new ResourceNotFoundExceptions(e.getMessage());
		}
	}
	
}
