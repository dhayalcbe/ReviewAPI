package com.interview.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewGroupDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String qualityName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "review_detail_id",referencedColumnName = "id")
    private  List<Review> review;

}
