package test;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

























import pl.rea.canonical.OfferCanonical;
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
		
		
		UserCanonical user = new UserCanonical();
		user.setAddressId(10001);
		user.setApartmentNo(1);
		user.setEmail("user1");
		user.setSessionId("sessionid1");
		user.setHouseNo(1);
		user.setId((long)10002);
		user.setLogin("user1");
		user.setName("name");
		user.setPassword("password");
		user.setPhoneNumber("phone");
		user.setPostalCode("postal");
		user.setRole("Administrator");
		user.setStreet("street");
		user.setTown("town");
		
		OfferCanonical offer = new OfferCanonical();
		offer.setAddressId(10002);
		offer.setApartmentNo(5);
		offer.setArea(50);
		offer.setCreationDate(new Date());
		offer.setDescription("Opis");
		offer.setEstateType("Dom");
		offer.setFinishDate(new Date());
		offer.setFloor(5);
		offer.setGarage(true);
		offer.setHouseNo(5);
		offer.setOwner("user1");
		offer.setPostalCode("39-200");
		offer.setPrice(200000);
		offer.setStreet("Ulica");
		offer.setTown("Dębica");
		offer.setTransactionType("Wynajem");
		offer.setId(10001);
		
//		System.out.println("Offer update: " + offerService.updateOffer("user1", "sessionid1", offer, "user1"));
//		System.out.println("Offer delete from userFavourites: " + offerService.deleteOfferFromUserFavourites("admin1", "sessionid1", (long)10003, "admin1"));
		
//		System.out.println("Is offer in userFavourites: " + offerService.isOfferInUserFavourites("admin1", "sessionid1", (long)10003, "admin1"));
		
//		System.out.println("User list size: " + userService.getUserList("admin1", "sessionid1").size());
		
//		System.out.println("Usuwanie oferty: " + offerService.deleteOffer("admin1", "sessionid1", (long)10003, "admin1"));
		
//		offerService.addOffer("user1", "sessionid1", offer, "user1");
//		offerService.addOfferToUserFavourites("admin1", "sessionid1", (long)10001, "admin1");
		
//		System.out.println("User favourites: " + offerService.getUserFavouritesOffers("admin1", "sessionid1", "admin1").size());
		
		// minPrice, maxPrice, minArea, maxArea, minFloor, maxFloor, isGarage, town, estateType, transactionType
		
		List<OfferCanonical> foundOffers = offerService.findOffersByCriteria(null, null, null, null, null, null, null, null, null, null);
		System.out.println("Found offer list size: " + foundOffers.size());
		for (OfferCanonical offerCanonical : foundOffers) {
			System.out.println("Found offer id: " + offerCanonical.getId());
		}
		
		
		
		
		
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
