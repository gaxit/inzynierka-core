package pl.rea.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;
import org.hibernate.SharedSessionContract;

@Entity(name = "userek")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	@OneToOne
	@NotNull
	private Address address;
	
	@OneToOne
	@NotNull
	private RoleDao role;
	
	@OneToMany
	private List<Offer> favourites;

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

	public RoleDao getRole() {
		return role;
	}

	public void setRole(RoleDao role) {
		this.role = role;
	}

	public List<Offer> getFavourites() {
		return favourites;
	}

	public void setFavourites(List<Offer> favourites) {
		this.favourites = favourites;
	}
	
	public List<User> getUsers(Session session)
	{
		//returns a list of all users
		List <User> UserList;
		UserList= ((SharedSessionContract) session).createCriteria(User.class).list();
		return UserList;
	}
	
	public User getUser(Session session, Long id)
	{
		//returns user with specific id
		User returnUser = new User();
		List <User> userList;
	    userList= ((SharedSessionContract) session).createCriteria(User.class).list();
	    int size = userList.size();
		if (size>0)
		{
			for (int i=0; i<size; i++){
				User currentU = userList.get(i);
				if (currentU.getId()==id)
				{
					returnUser=currentU;
				}
			}
		}
		return returnUser;
	}
	
	public void deleteUser (Session session, Long id)
	{
		//removes user with given id
		List <User> uList;
	    uList= ((SharedSessionContract) session).createCriteria(User.class).list();
		int size = uList.size();
		if (size>0)
		{
		for (int i=0; i<size; i++){
			User currentU = uList.get(i);
			if (currentU.getId()==id)
			{
				session.delete(currentU);
			}
		}
		}
		
	}
	
	
	public String login(Session session, String login, String password)
	{
		//returns session id
		String sessionId="defaultid";
		List <User> userList;
	    userList= ((SharedSessionContract) session).createCriteria(User.class).list();
	    int size = userList.size();
		if (size>0)
		{
			for (int i=0; i<size; i++){
				User currentU = userList.get(i);
				if (currentU.getLogin()==login)
				{
					if (currentU.getPassword()==password)
					{
						sessionId=currentU.getSessionId();
					}
				}
			}
		}
		return sessionId;
	}


}
