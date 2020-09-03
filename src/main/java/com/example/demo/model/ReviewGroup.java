package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name ="reviewgroups")
public class ReviewGroup {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long  id;
	private  String groupName;
	


	public ReviewGroup() {
		
	}
	public Long  getId() {
		return id;
	}
	public void setId(Long  id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	

}
