package com.meldia.backendpr.model;

import javax.persistence.*;

@Entity
@Table(name="product_pr")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="price")
	private String price;
	
	@Column(name="images")
	private String images;
	
	public ProductModel() {

	}

	public ProductModel(String title, String description, String price, boolean status, String images) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.price = price;
		this.images = images;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	

}
