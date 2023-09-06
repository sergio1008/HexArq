package com.serbernal.hexagonaldemo.application;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.serbernal.hexagonaldemo.domain.entity.Product;

import jakarta.transaction.Transactional;


@Service
public interface ProductService {

	/**
	 * Permite agregar un nuevo producto
	 * @param product
	 * @return
	 */
	@Transactional
	Product save(Product product);
	
	/**
	 * Permite buscar un producto por id
	 * @param id
	 * @return
	 */
	Product findById(Long id);
	
	/**
	 * Permite obtener listado de productos paginados
	 * @param pageable
	 * @return
	 */
	Page<Product> getAll(Pageable pageable);
	
	/**
	 * Permite actualizar un producto
	 * @param id
	 * @param product
	 * @return
	 */
	@Transactional
	Product update(Long id, Product product);
	
	
	/**
	 * Permite eliminar un producto
	 * @param id
	 */
	void delete(Long id);
	
	
 }
