package test;

import javax.faces.bean.ManagedBean;

import java.util.List;







import pl.rea.dao.EstateTypeDao;
import pl.rea.dao.RoleDao;
import pl.rea.dao.UserDao;

import pl.rea.model.Address;
import pl.rea.model.EstateType;
import pl.rea.model.Role;
import pl.rea.model.User;

@ManagedBean(name = "testBean")
public class TestBean {

	public void test() {
		
		/*
		//RoleDao
		RoleDao dao = new RoleDao();
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
		
		
		//UserDao
		UserDao dao = new UserDao();
		
		//INSERT INTO userek (id,email,login,name,password,phonenumber,address_id,role_id) 
		//VALUES (43,'email2','test2','Testowy2','test','2345',3,2);
		User newUser = new User();
		newUser.setId((long)44);
		newUser.setEmail("email3");
		newUser.setLogin("PanMateusz");
		newUser.setName("Adam Miśkiweicz");
		newUser.setPassword("test3");
		newUser.setPhoneNumber("123456");
		newUser.setAddress(new Address());
		newUser.setRole(new Role());
		
		
		dao.insertUser(newUser);  //póki co odmawia współpracy, ale dopiero co te metode
									//dodałem więc jeszcze nie ma powodu do paniki.

		
		List<User> userlist = dao.getUserList();
		for (int i = 0; i < userlist.size(); i++) {
			System.out.println(userlist.get(i).getLogin());
		}
		
		System.out.println("User name (not login) by id: " + dao.getUserById((long)42).getName());
		System.out.println("User id found by name: " + dao.getUserByName("Testowy1").getId());
		System.out.println("User id found by login: " + dao.getUserByLogin("test2").getId());
		
	}

}
