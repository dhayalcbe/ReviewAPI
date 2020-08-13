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
public class ReviewGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String groupName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "review_group_id",referencedColumnName = "id")
    private  List<ReviewGroupDetails> reviewGroupDetails;

}
