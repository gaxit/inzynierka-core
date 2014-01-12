package pl.rea.transform;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import pl.rea.canonical.UserCanonical;
import pl.rea.dao.RoleDao;
import pl.rea.dao.UserDao;
import pl.rea.model.Address;
import pl.rea.model.Role;
import pl.rea.model.User;

@Stateless
public class UserTransform {
	
	UserDao userDao = new UserDao();
	RoleDao roleDao = new RoleDao();
	
	public UserCanonical userToUserCanonical(User user){
		UserCanonical userCanon = new UserCanonical();
		
		userCanon.setEmail(user.getEmail());
		userCanon.setId(user.getId());
		userCanon.setLogin(user.getLogin());
		userCanon.setName(user.getName());
		userCanon.setPassword(user.getPassword());
		userCanon.setPhoneNumber(user.getPhoneNumber());
		userCanon.setRole(user.getRole().getRole());
		userCanon.setSessionId(user.getSessionId());
		
		userCanon.setAddressId(user.getAddress().getId());
		if (user.getAddress().getApartmentNo() != null && user.getAddress().getApartmentNo() > 0)
			userCanon.setApartmentNo(user.getAddress().getApartmentNo());
		userCanon.setHouseNo(user.getAddress().getHouseNo());
		userCanon.setPostalCode(user.getAddress().getPostalCode());
		userCanon.setStreet(user.getAddress().getStreet());
		userCanon.setTown(user.getAddress().getTown());
		
		return userCanon;
	}
	
	public User userCanonicalToUser(UserCanonical userCanon){
		User user = null;
		if (userCanon.getId()==null){
			user = new User();
		}
		else{
			user = userDao.getUserByLogin(userCanon.getLogin());
			user.setId(userCanon.getId());
		}
		
		user.setEmail(userCanon.getEmail());
		user.setLogin(userCanon.getLogin());
		user.setName(userCanon.getName());
		user.setPassword(userCanon.getPassword());
		user.setPhoneNumber(userCanon.getPhoneNumber());
		user.setSessionId(userCanon.getSessionId());
		
		Role role = roleDao.getRoleByName(userCanon.getRole());
		user.setRole(role);
		
		Address address = new Address();
		if (userCanon.getApartmentNo() != null && userCanon.getApartmentNo() > 0)
			address.setApartmentNo(userCanon.getApartmentNo());
		address.setHouseNo(userCanon.getHouseNo());
		address.setId(userCanon.getAddressId());
		address.setPostalCode(userCanon.getPostalCode());
		address.setStreet(userCanon.getStreet());
		address.setTown(userCanon.getTown());
		
		user.setAddress(address);
		
		return user;
	}
	
	public List<User> userCanonicalListToUserList(List<UserCanonical> userCanonList){
		List<User> userList = new LinkedList<User>();
		for (UserCanonical userCanon : userCanonList) {
			User user = userCanonicalToUser(userCanon);
			userList.add(user);
		}
		return userList;
	}
	
	public List<UserCanonical> userListToUserCanonicalList(List<User> userList){
		List<UserCanonical> userCanonList = new LinkedList<UserCanonical>();
		for (User user : userList) {
			UserCanonical userCanon = userToUserCanonical(user);
			userCanonList.add(userCanon);
		}
		return userCanonList;
	}
	
	

}
