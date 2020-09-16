package com.zirius.review.dto;

import org.springframework.http.HttpStatus;

import com.zirius.review.error.ErrorDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	private String message;

	private HttpStatus status;

	private ErrorDetails errors;

}
