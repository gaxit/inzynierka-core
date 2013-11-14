package pl.rea.model;

import javax.persistence.Entity;

@Entity(name = "user")
public class User {
	private String login;  //PK
	
	private String password;
	
	private String sessionId;
	
	private String name;
	
	private String phoneNumber;
	
	private String email;
	
	private Address address;
	
	private Role role;

}
