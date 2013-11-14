package pl.rea.model;

import java.awt.Image;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity(name = "offer")
public class Offer {
	private int id;
	
	private Date creationDate;
	
	private String status;
	
	private Address address;
	
	private EstateType estateType;
	
	private TransactionType transactionType;
	
	private List<Image> images;
	
	private List<Offer> favourites;
	
	private List<Comment> comments;
	
	private boolean garage;
	
	private int floor;
	
	private int area;
	
	private int price;
	
	private String description;
	
	private User owner;

}
