package com.interview.review.models;

import lombok.Data;

import java.util.List;

@Data
public class ReviewGroupRequestModel {
    String groupName;

    List<String> qualityName;
}
