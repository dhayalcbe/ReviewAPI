package com.zirius.review.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.zirius.review.repository.model.Review;

@Repository
public class CustomReviewRepositoryImpl implements CustomReviewRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Review> getReviewsByReviewGroupId(Long reviewGroupId) {
		TypedQuery<Review> query = em.createQuery("select r from Review r join r.reviewGroup rg where rg.id = :reviewGroupId", Review.class);
		query.setParameter("reviewGroupId", reviewGroupId);
		List<Review> reviews = query.getResultList();
		return reviews;
	}

}
