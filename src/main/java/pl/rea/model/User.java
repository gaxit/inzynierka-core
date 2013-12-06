package pl.rea.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "userek")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	
	@NotNull
	@Column(unique=true)
	private String login;
	
	@NotNull
	private String password;
	
	private String sessionId;
	
	@NotNull
	private String name;
	
	private String phoneNumber;
	
	@NotNull
	private String email;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@NotNull
	private Address address;
	
	@OneToOne
	@NotNull
	private Role role;
	
	@ManyToMany
	@JoinTable(name = "favourites", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "offer_id") })
	private List<Offer> favourites;
	
	@ManyToMany
	@JoinTable(name = "owner_offer", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "offer_id") })
	private List<Offer> offers;
	
	public User(){
		this.address = null;
		this.email = null;
		this.favourites = new LinkedList<Offer>();
		this.id = null;
		this.login = null;
		this.name = null;
		this.offers = new LinkedList<Offer>();
		this.password = null;
		this.phoneNumber = null;
		this.role = null;
		this.sessionId = null;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Offer> getFavourites() {
		return favourites;
	}

	public void setFavourites(List<Offer> favourites) {
		this.favourites = favourites;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

}
