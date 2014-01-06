package pl.rea.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="addressSeq") 
  	@SequenceGenerator(name="addressSeq",sequenceName="addressSeq", initialValue=50)
	private Long id;
	
	@NotNull
	private String town;
	
	@NotNull
	private String postalCode;
	
	@NotNull
	private String street;
	
	@NotNull
	private int houseNo;
	
	private int apartmentNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public int getApartmentNo() {
		return apartmentNo;
	}

	public void setApartmentNo(int apartmentNo) {
		this.apartmentNo = apartmentNo;
	}

}
