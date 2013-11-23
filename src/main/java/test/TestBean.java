package test;

import javax.faces.bean.ManagedBean;

import java.util.List;









import pl.rea.dao.EstateTypeDao;
import pl.rea.dao.OfferDao;
import pl.rea.dao.RoleDao;
import pl.rea.dao.UserDao;
import pl.rea.model.Address;
import pl.rea.model.EstateType;
import pl.rea.model.Offer;
import pl.rea.model.Role;
import pl.rea.model.User;

@ManagedBean(name = "testBean")
public class TestBean {

	public String test() {
		
		/*
		//RoleDao
		RoleDao dao = new RoleDao();
		
		//To akurat działa...
		
		 // Role newRole=new Role();
		 // newRole.setRole("Wolololo");
		 // dao.insertRole(newRole);
		
		List<Role> role = dao.getRoleList();
		for (int i = 0; i < role.size(); i++) {
			System.out.println(role.get(i).getRole());
		}
		
		System.out.println("Role by id: " + dao.getRoleById((long)1).getRole());
		
		System.out.println("Role id found by name: " + dao.getRoleByName("ADMIN").getId());
		*/
		
		/*
		//EstateTypeDao
		EstateTypeDao dao = new EstateTypeDao();
		List<EstateType> et = dao.getEstateTypeList();
		for (int i=0;i<et.size(); i++)
		{
			System.out.println(et.get(i).getEstateType());
		}
		*/
		
		/*
		//UserDao
		UserDao dao = new UserDao();
	
		User newUser = new User();
		newUser.setEmail("email3");
		newUser.setLogin("PanMateusz");
		newUser.setName("AdamMiśkiweicz");
		newUser.setPassword("test3");
		newUser.setPhoneNumber("123456");
		dao.updateUser(newUser);  //tworzenie userów w ten sposób jeszcze robi problemy...
		
		User changedUser=dao.getUserById((long)42);
		changedUser.setName("barabum");
		//dao.updateUser(changedUser);	//...ale update jest w porządku
		
		System.out.println("User name (not login) by id: " + dao.getUserById((long)42).getName());
		//System.out.println("User id found by name: " + dao.getUserByName("barabum").getId());
		System.out.println("User id found by login: " + dao.getUserByLogin("test2").getId());
		
		//dao.deleteUserByName("barabum");  //dziala
		
		//System.out.println("Testing login");
		System.out.println(dao.signIn("test1","test"));
		*/
		
		
		//OffereDao
		OfferDao dao = new OfferDao();
		List<Offer> offers = dao.getOfferList();
		for (int i=0;i<offers.size(); i++)
		{
			System.out.println(offers.get(i).getId());
		}
		
		return null;
	}

}
