package pl.rea.model;

import javax.persistence.Entity;

@Entity
public class Comment {
	private int id;
	
	private String comment;
	
	private User author;
}
