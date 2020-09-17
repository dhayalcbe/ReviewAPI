CREATE TABLE Review (
	id INT NOT NULL AUTO_INCREMENT,
    review_Group_Id INT NOT NULL,
	comments VARCHAR(5000) NOT NULL,
	star_Rating ENUM('1','2','3','4','5') NOT NULL,
	PRIMARY KEY(id),
    FOREIGN KEY (review_Group_Id)
    REFERENCES review_group(id)
	ON DELETE RESTRICT
    ON UPDATE RESTRICT
);