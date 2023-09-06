package com.serbernal.hexagonaldemo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PRODUCTS")
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "ID_PRODUCT")
	private Long id;
	
	@Column(name = "NAME_PRODUCT", length = 256)
	private String name;
	
	@Column(name = "PRICE_PRODUCT")
	private Double price;
	
}
