package com.serbernal.hexagonaldemo.adapters.controller;

import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serbernal.hexagonaldemo.application.ProductService;
import com.serbernal.hexagonaldemo.domain.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductRestController {
	
	private final ProductService service;
	
	
	
	public ProductRestController(ProductService service) {
		super();
		this.service = service;
	}


	/**
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product){
		try {
			return ResponseEntity.ok(service.save(product));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(service.findById(id));
		}catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		} 
		catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<Product>> getAll(Pageable pageable){
		try {
			return ResponseEntity.ok(service.getAll(pageable));
		}
		catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	/**
	 * 
	 * @param id
	 * @param product
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
		try {
			return ResponseEntity.ok(service.update(id, product));
		}catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		} 
		catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		try {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		} 
		catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
