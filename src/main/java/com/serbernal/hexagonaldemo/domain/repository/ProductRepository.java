package com.serbernal.hexagonaldemo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serbernal.hexagonaldemo.domain.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
