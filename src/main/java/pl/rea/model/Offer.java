package pl.rea.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "offer")
public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="offer_id")
	private Long id;
	
	@NotNull
	private Date creationDate;
	
	@NotNull
	private Date finishDate;
	
	@OneToOne
	@NotNull
	private Address address;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@NotNull
	private EstateType estateType;
	
	@OneToOne
	@NotNull
	private TransactionType transactionType;
	
	@OneToMany
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
		this.creationDate = null;
		this.description = null;
		this.estateType = null;
		this.finishDate = null;
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

}
