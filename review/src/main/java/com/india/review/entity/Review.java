package com.india.review.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "comments")
	private String comments;

	@Column(name = "startrating")
	private long startRating;

	@ManyToOne
	@JoinColumn(name = "siteaccountmappingid")
	@ToString.Exclude
	private ReviewGroup group;
}
