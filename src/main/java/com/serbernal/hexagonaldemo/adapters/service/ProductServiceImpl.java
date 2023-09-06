package com.serbernal.hexagonaldemo.adapters.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.serbernal.hexagonaldemo.application.ProductService;
import com.serbernal.hexagonaldemo.domain.entity.Product;
import com.serbernal.hexagonaldemo.domain.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
		this.repository= repository;
	}
	
	@Override
	public Product save(Product product) {
		return repository.save(product);
		}

	@Override
	public Product findById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public Page<Product> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Product update(Long id, Product product) {
		repository.findById(id).orElseThrow();
		return repository.save(product);
	}

	@Override
	public void delete(Long id) {
		repository.findById(id).orElseThrow();
		repository.deleteById(id);
	}

}
