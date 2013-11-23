package pl.rea.canonical;

import java.util.Date;
import java.util.List;

public class OfferCanonical {
	
	private long id;
	private Date creationDate;
	private Date finishDate;
	private String estateType;
	private String transactionType;
	private List<ImageCanonical> images;
	private boolean garage;
	private int floor;
	private int area;
	private int price;
	private String description;
	private String owner;
	
	private long addressId;
	private String town;
	private String postalCode;
	private String street;
	private int houseNo;
	private int apartmentNo;

}
