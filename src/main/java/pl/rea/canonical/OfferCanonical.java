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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getEstateType() {
		return estateType;
	}
	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public List<ImageCanonical> getImages() {
		return images;
	}
	public void setImages(List<ImageCanonical> images) {
		this.images = images;
	}
	public boolean isGarage() {
		return garage;
	}
	public void setGarage(boolean garage) {
		this.garage = garage;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
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
