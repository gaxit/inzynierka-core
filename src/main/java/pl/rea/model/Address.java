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
	private Integer houseNo;
	
	private Integer apartmentNo;

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

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}

	public Integer getApartmentNo() {
		return apartmentNo;
	}

	public void setApartmentNo(Integer apartmentNo) {
		this.apartmentNo = apartmentNo;
	}

}
