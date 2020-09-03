package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.ResourceNotFoundExceptions;
import com.example.demo.model.ReviewGroup;
import com.example.demo.services.ReviewGroupServices;

@RestController
@RequestMapping("/api/review-groups")
public class ReviewGroupController {

	@Autowired
	private ReviewGroupServices reviewGroupServices;

	@PostMapping("/create")
	public Long createReviewGroup(@RequestBody ReviewGroup reviewGroup) throws ResourceNotFoundExceptions {

		return reviewGroupServices.createReviewGroup(reviewGroup);
	}

}
