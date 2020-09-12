package com.zirius.reviewAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zirius.reviewAPI.entity.ReviewGroup;

@Repository
public interface ReviewGroupDao extends JpaRepository<ReviewGroup,Integer> {

}
