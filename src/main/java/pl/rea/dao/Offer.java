package pl.rea.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;
import org.hibernate.SharedSessionContract;

@Entity(name = "offer")
public class Offer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Date creationDate;
	
	@NotNull
	private Date finishDate;
	
	@OneToOne
	@NotNull
	private Status status;
	
	@OneToOne
	@NotNull
	private Address address;
	
	@OneToOne
	@NotNull
	private EstateTypeDao estateType;
	
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EstateTypeDao getEstateType() {
		return estateType;
	}

	public void setEstateType(EstateTypeDao estateType) {
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

	public List<Offer> getOffers(Session session)
	{
		//returns a list of all offers
		List <Offer> OfferList;
		OfferList= ((SharedSessionContract) session).createCriteria(Offer.class).list();
		return OfferList;
	}
	
	public Offer getOffer(Session session, Long id)
	{
		//returns offer with specific id
		Offer returnOffer = new Offer();
		List <Offer> offerList;
	    offerList= ((SharedSessionContract) session).createCriteria(Offer.class).list();
	    int size = offerList.size();
		if (size>0)
		{
			for (int i=0; i<size; i++){
				Offer currentO = offerList.get(i);
				if (currentO.getId()==id)
				{
					returnOffer=currentO;
				}
			}
		}
		return returnOffer;
	}
	
	public List<Offer> searchOffers(Session session)
	{
		//returns a list of all offers
		List <Offer> OfferList;
		OfferList= ((SharedSessionContract) session).createCriteria(Offer.class).list();
		
		//tutaj następowałaby selekcja po parametrach. jesli rzeczywiscie uda sie z tymi filtrami primefaces...
		
		return OfferList;	//odpowiednio przerzedzona
	}

}
