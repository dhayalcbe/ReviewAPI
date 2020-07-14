package com.spring.reviewapi.dto;

public class ReviewResponse {
	private String productName;
	private String productType;
	private float price;
	private String Specification;
	private String comments;
	private int rating;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSpecification() {
		return Specification;
	}

	public void setSpecification(String specification) {
		Specification = specification;
	}

	@Override
	public String toString() {
		return "ReviewResponse [productName=" + productName + ", productType=" + productType + ", price=" + price
				+ ", Specification=" + Specification + ", comments=" + comments + ", rating=" + rating + "]";
	}

}
