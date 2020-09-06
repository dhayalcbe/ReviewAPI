package com.india.review.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviewgroup")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReviewGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "topic")
	private String topic;

	@Column(name = "review")
	private String review;
}
