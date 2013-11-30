package test;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import java.util.Date;
import java.util.List;














import pl.rea.dao.EstateTypeDao;
import pl.rea.dao.OfferDao;
import pl.rea.dao.RoleDao;
import pl.rea.dao.TransactionTypeDao;
import pl.rea.dao.UserDao;
import pl.rea.model.Address;
import pl.rea.model.EstateType;
import pl.rea.model.Offer;
import pl.rea.model.Role;
import pl.rea.model.TransactionType;
import pl.rea.model.User;
import pl.rea.webservices.DicsService;

@ManagedBean(name = "testBean")
public class TestBean {

	@EJB
	private RoleDao roleDao;
	
	@EJB
	private EstateTypeDao estateTypeDao;
	
	@EJB
	private TransactionTypeDao transTypeDao;
	
	@EJB
	private UserDao userDao;
	
	@EJB
	private OfferDao offerDao;
	
//	@EJB
//	private DicsService dicsService;
	private DicsService dicsService = new DicsService();
	
	public String test() {
		System.out.println("Test bean start");
		List<String> transTypeList = dicsService.getTransactionTypeList();
		for (String stringg : transTypeList) {
			System.out.println(stringg);
		}
		
		
		
		
//		EstateType domType = estateTypeDao.getEstateTypeByName("DOM");
//		System.out.println(domType.getEstateType());
//		
//		TransactionType transType = transTypeDao.getTransactionTypeByName("WYNAJEM");
//		System.out.println(transType.getTransactionType());
//		
//		Role role = roleDao.getRoleByName("ADMIN");
//		System.out.println(role.getRole());
//		
//		Address address = new Address();
//		address.setApartmentNo(10);
//		address.setHouseNo(10);
//		address.setPostalCode("33-333");
//		address.setStreet("Floriańska");
//		address.setTown("Kraków");
//		
//		User user = new User();
//		user.setAddress(address);
//		user.setEmail("trol@trol.pl");
//		user.setLogin("admin");
//		user.setName("Administrator systemu");
//		user.setPassword("haslo");
//		user.setPhoneNumber("666666666");
//		user.setRole(role);
//		
//		Offer offer1 = new Offer();
//		offer1.setAddress(address);
//		offer1.setArea(200);
//		offer1.setCreationDate(new Date());
//		offer1.setDescription("Opis");
//		offer1.setEstateType(domType);
//		offer1.setFinishDate(new Date());
//		offer1.setFloor(2);
//		offer1.setGarage(true);
//		offer1.setPrice(200000);
//		offer1.setTransactionType(transType);
//		
//		user.getOffers().add(offer1);
//		
//		System.out.println("Dodano oferte i uzytkownika w testBeanie");
//		
//		userDao.createUser(user);
//		
//		System.out.println("Zapisano uzytkownika");
//		
//		System.out.println("Offer owner: " + offerDao.getOfferOwnerLogin(offer1));
		
		
		
		
		
		
		
		
		
//		List<Role> roleList = roleDao.getRoleList();
//		for (int i=0;i<roleList.size();i++){
//			System.out.println(roleList.get(i).getRole());
//		}
		
		
		
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
//		OfferDao dao = new OfferDao();
//		List<Offer> offers = dao.getOfferList();
//		for (int i=0;i<offers.size(); i++)
//		{
//			System.out.println(offers.get(i).getId());
//		}
		
		return null;
	}

}
