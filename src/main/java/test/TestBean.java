package test;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;























import pl.rea.canonical.UserCanonical;
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
import pl.rea.utils.HibernateUtil;
import pl.rea.utils.LoggedUserUtils;
import pl.rea.webservices.DicsService;
import pl.rea.webservices.OfferService;
import pl.rea.webservices.UserService;

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
	private UserService userService = new UserService();
	private OfferService offerService = new OfferService();
	
	private LoggedUserUtils loggedUserUtils = new LoggedUserUtils();
	
	public String test() {
		System.out.println("Test bean start");
		
//		System.out.println("All offer size: " + offerService.getAllOffers().size());
//		System.out.println("Offer estaet type: " + offerService.getOffer((long)10001).getEstateType());
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println("User zalogowany?: " + userService.isUserLogged("admin1", "sessionid1"));
//		System.out.println("Logowanie: " + userService.logIn(null, "admin"));
//		System.out.println("Wylogowywanie: " + userService.logOut("admin1", "sessioni1"));
		
//		UserCanonical user = new UserCanonical();
//		user.setAddressId(10001);
//		user.setApartmentNo(1);
//		user.setEmail("user1");
//		user.setSessionId("sessionid1");
//		user.setHouseNo(1);
//		user.setId((long)10002);
//		user.setLogin("user1");
//		user.setName("name");
//		user.setPassword("password");
//		user.setPhoneNumber("phone");
//		user.setPostalCode("postal");
//		user.setRole("Administrator");
//		user.setStreet("street");
//		user.setTown("town");
//		System.out.println("Dodawanie uzytkownika: " + userService.createUser(user));
//		System.out.println("Edytowanie uzytkownika: " + userService.editUser("admin1", "sessionid1", user));
//		System.out.println("Usuwanie uzytkownika: " + userService.deleteUser("admin1", "sessionid1", "user1"));
//		System.out.println("User name: " + userService.getUser("admin1", "sessionid1", "user1").getName());
		
		
		
		
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = sessionFactory.getCurrentSession().getTransaction();
//		tx.begin();
//		
//		//something...
//		
//		tx.commit();
//		session.close();
		
		System.out.println("Test bean end");
		return null;
	}

}
