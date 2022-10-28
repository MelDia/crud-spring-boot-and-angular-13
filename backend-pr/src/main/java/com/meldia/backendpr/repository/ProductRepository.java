package com.meldia.backendpr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meldia.backendpr.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

	List<ProductModel> findByStatus(boolean status);
	List<ProductModel> findByTitle(String title);
}
