package com.spring.reviewapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.reviewapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
