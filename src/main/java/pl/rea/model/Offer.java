package pl.rea.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name = "offer")
public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="offerSeq") 
  	@SequenceGenerator(name="offerSeq",sequenceName="offerSeq", initialValue=50)
	@Column(name="offer_id")
	private Long id;
	
	@NotNull
	private String offerName;
	
	@OneToOne
	@NotNull
	private Address address;
	
	@OneToOne
	@NotNull
	private EstateType estateType;
	
	@OneToOne
	@NotNull
	private TransactionType transactionType;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Images> images;
	
	@NotNull
	private boolean garage;
	
	private int floor;
	
	@NotNull
	private int area;
	
	@NotNull
	private int price;
	
	private String description;
	
	public Offer(){
		this.address = null;
		this.area = 0;
		this.offerName = null;
		this.description = null;
		this.estateType = null;
		this.floor = 0;
		this.garage = false;
		this.id = null;
		this.images = new LinkedList<Images>();
		this.price = 0;
		this.transactionType = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EstateType getEstateType() {
		return estateType;
	}

	public void setEstateType(EstateType estateType) {
		this.estateType = estateType;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
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

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

}
