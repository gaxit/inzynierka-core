package pl.rea.canonical;

public class OfferCanonical {
	
	private long id;
	private String offerName;
	private String estateType;
	private String transactionType;
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
	
	public OfferCanonical(){
		this.addressId = 0;
		this.apartmentNo = 0;
		this.area = 0;
		this.offerName = null;
		this.description = null;
		this.estateType = null;
		this.floor = 0;
		this.garage = false;
		this.houseNo = 0;
		this.id = 0;
		this.owner = null;
		this.postalCode = null;
		this.price = 0;
		this.street = null;
		this.town = null;
		this.transactionType = null;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public boolean getGarage() {
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

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

}
