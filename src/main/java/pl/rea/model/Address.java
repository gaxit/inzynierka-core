package pl.rea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "address")
public class Address {
	@Id
	@Column
	private int id;
	
	private String province;
	
	private String town;
	
	private String postalCode;
	
	private String street;
	
	private int houseNo;
	
	private int apartmentNo;

}
