package com.meldia.backendpr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.meldia.backendpr.exception.ResourceException;
import com.meldia.backendpr.model.ProductModel;
import com.meldia.backendpr.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository prodRep;

	// Retrieve all products
	@GetMapping("/products")
	public ResponseEntity<List<ProductModel>> getAllProducts(@RequestParam(required = false) String title) {

		List<ProductModel> products = new ArrayList<ProductModel>();

		if (title == null) {
			prodRep.findAll().forEach(products::add);
		} else {
			prodRep.findByTitle(title).forEach(products::add);
		}

		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(products, HttpStatus.OK);

	}

	// Retrieve a product by :id
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable("id") long id) {

		ProductModel product = prodRep.findById(id)
				.orElseThrow(() -> new ResourceException("Not found Product with id " + id));

		return new ResponseEntity<>(product, HttpStatus.OK);

//		Optional<ProductModel> productData = prodRep.findById(id);
//
//		if (productData.isPresent()) {
//			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
	}

	// Create a new Product
	@PostMapping("/products")
	public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {

		ProductModel _product = prodRep
				.save(new ProductModel(product.getTitle(), product.getDescription(), product.getPrice(), false, product.getImages()));

		return new ResponseEntity<>(_product, HttpStatus.CREATED);

//		try {
//			ProductModel _product = prodRep
//					.save(new ProductModel(product.getTitle(), product.getDescription(), product.getPrice(), false)); // status
//			System.out.println("PRODUCT ->" + _product);
//			return new ResponseEntity<>(_product, HttpStatus.CREATED);
//
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	// Update a Product
	@PutMapping("/products/{id}")
	public ResponseEntity<ProductModel> updateProduct(@PathVariable("id") long id, @RequestBody ProductModel product) {

		ProductModel _product = prodRep.findById(id)
				.orElseThrow(() -> new ResourceException("Not found Product with id " + id));

		_product.setTitle(product.getTitle());
		_product.setDescription(product.getDescription());
		_product.setPrice(product.getPrice());
		_product.setStatus(product.isStatus());

		return new ResponseEntity<>(prodRep.save(_product), HttpStatus.OK);

//		Optional<ProductModel> productData = prodRep.findById(id);
//
//		if (productData.isPresent()) {
//			ProductModel _product = productData.get();
//			_product.setTitle(product.getTitle());
//			_product.setDescription(product.getDescription());
//			_product.setPrice(product.getPrice());
//			_product.setStatus(product.isStatus());
//
//			return new ResponseEntity<>(prodRep.save(_product), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
	}

	// Delete a Product
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {

		prodRep.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

//		try {
//			prodRep.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	// Delete all Products
	@DeleteMapping("/products")
	public ResponseEntity<HttpStatus> deleteAllProducts() {

		prodRep.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

//		try {
//			prodRep.deleteAll();
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	// Get Products stock
	@GetMapping("/products/stock")
	public ResponseEntity<List<ProductModel>> findByStatus() {

//		try {
		List<ProductModel> products = prodRep.findByStatus(true);

		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(products, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

}
