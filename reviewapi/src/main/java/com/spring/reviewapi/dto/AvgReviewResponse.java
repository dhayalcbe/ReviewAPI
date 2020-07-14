package com.spring.reviewapi.dto;

public class AvgReviewResponse {

	private String productName;
	private String productType;
	private float price;
	private String Specification;
	private long reviewGroupId;
	private int avgReview;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public long getReviewGroupId() {
		return reviewGroupId;
	}

	public void setReviewGroupId(long reviewGroupId) {
		this.reviewGroupId = reviewGroupId;
	}

	public int getAvgReview() {
		return avgReview;
	}

	public void setAvgReview(int avgReview) {
		this.avgReview = avgReview;
	}

	@Override
	public String toString() {
		return "AvgReviewResponse [productName=" + productName + ", productType=" + productType + ", price=" + price
				+ ", Specification=" + Specification + ", reviewGroupId=" + reviewGroupId + ", avgReview=" + avgReview
				+ "]";
	}

}
