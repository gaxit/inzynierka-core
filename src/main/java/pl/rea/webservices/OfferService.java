package pl.rea.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.canonical.ImageCanonical;
import pl.rea.canonical.OfferCanonical;
import pl.rea.dao.OfferDao;
import pl.rea.dao.UserDao;
import pl.rea.model.Offer;
import pl.rea.model.User;
import pl.rea.transform.ImagesTransform;
import pl.rea.transform.OfferTransform;
import pl.rea.utils.HibernateUtil;
import pl.rea.utils.LoggedUserUtils;

@WebService(serviceName = "offerService", targetNamespace="offers")
@Stateless
public class OfferService {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	private OfferDao offerDao = new OfferDao();
	private OfferTransform offerTransform = new OfferTransform();
	private ImagesTransform imageTransform = new ImagesTransform();
	private UserDao userDao = new UserDao();
	private LoggedUserUtils loggedUserUtils = new LoggedUserUtils();

	// ok
	@WebMethod(operationName="getAllOffers", action="getAllOffers")
	public List<OfferCanonical> getAllOffers() {
		// pobranie wszystkich ofert dostepnych w bazie
		Session session = null;
		Transaction tx = null;
		List<OfferCanonical> offerList = null;
		try {
			session = sessionFactory.openSession();
			tx = sessionFactory.getCurrentSession().getTransaction();
			tx.begin();

			List<Offer> offers = offerDao.getOfferList();
			offerList = offerTransform.offerListToOfferCanonicalList(offers);

			tx.commit();
		} catch (Exception e) {
			System.out.println("offerService getAllOffers exception: "
					+ e.getMessage());
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return offerList;
	}

	// ok
	@WebMethod(operationName="getOffer", action="getOffer")
	public OfferCanonical getOffer(Long id) {
		// pobranie informacji o jednej ofercie
		Session session = null;
		Transaction tx = null;
		OfferCanonical offer = null;
		try {
			session = sessionFactory.openSession();
			tx = sessionFactory.getCurrentSession().getTransaction();
			tx.begin();

			Offer offerDB = offerDao.getOfferById(id);
			offer = offerTransform.offerToOfferCanonical(offerDB);

			tx.commit();
		} catch (Exception e) {
			System.out.println("offerService getOffer exception: "
					+ e.getMessage());
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return offer;
	}

	// ok
	@WebMethod(operationName="addOfferToUserFavourites", action="addOfferToUserFavourites")
	public boolean addOfferToUserFavourites(String login, String sessionId,
			Long offerId, String userLoginToAddOffer) {
		// sprawdzanie, czy dany uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin lub login i
		// userLoginToAddOffer jest taki sam
		// pobranie uzytkownika userLoginToAddOffer
		// pobranie oferty o podanym id
		// dodanie do jego listy ulubionych pobranej oferty
		// update uzytkownika
		if (login != null && sessionId != null && offerId != null
				&& userLoginToAddOffer != null) {
			Session session = null;
			Transaction tx = null;
			boolean returnValue = false;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();

				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(
								login, sessionId, userLoginToAddOffer)) {

					User user = userDao.getUserByLogin(userLoginToAddOffer);
					Offer offer = offerDao.getOfferById(offerId);
					if (user != null && offer != null) {
						user.getFavourites().add(offer);
						userDao.updateUser(user);
						returnValue = true;
					}
				}
				tx.commit();
			} catch (Exception e) {
				System.out
						.println("UserService addOfferToUserFavourites exception: "
								+ e.getMessage());
				tx.rollback();
				returnValue = false;
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return returnValue;
		}
		return false;
	}
	
	// ok
	@WebMethod(operationName="getUserFavouritesOffers", action="getUserFavouritesOffers")
	public List<OfferCanonical> getUserFavouritesOffers(String login,
			String sessionId, String userFavouritesLogin) {
		// sprawdzenie, czy uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin albo login i
		// userFavouritesLogin sa takie same
		// pobranie uzytkownika o podanym loginie
		// pobranie jego listy ulubionych
		// konwersja tej listy do listy OfferCanonical - metoda z pakietu
		// transform
		// zwrocenie tej listy
		if (login != null && sessionId != null && userFavouritesLogin != null) {
			Session session = null;
			Transaction tx = null;
			List<OfferCanonical> offerList = null;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(
								login, sessionId, userFavouritesLogin)) {
					User user = userDao.getUserByLogin(userFavouritesLogin);
					List<Offer> favOfferList = user.getFavourites();
					offerList = offerTransform.offerListToOfferCanonicalList(favOfferList);
				}

				tx.commit();
			} catch (Exception e) {
				System.out
						.println("UserService getUserFavouritesOffers exception: "
								+ e.getMessage());
				tx.rollback();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return offerList;
		}
		return null;
	}
	
	// ok
	@WebMethod(operationName="deleteOfferFromUserFavourites", action="deleteOfferFromUserFavourites")
	public boolean deleteOfferFromUserFavourites(String login, String sessionId,
			Long offerId, String userFavouritesLogin) {
		// sprawdzenie, czy uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin badz login i
		// userFavouritesLogin sa takie same
		// pobranie uzytkownika o podanym loginie
		// pobranie jego listy ulubionych
		// usuniecie z jego listy ulubionych oferty o podanym id
		if (login != null && sessionId != null && userFavouritesLogin != null) {
			Session session = null;
			Transaction tx = null;
			boolean returnValue = false;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(
								login, sessionId, userFavouritesLogin)) {
					User user = userDao.getUserByLogin(userFavouritesLogin);
					List<Offer> userOffers = user.getFavourites();
					for (Offer offer2 : userOffers) {
						if (offer2.getId().equals(offerId)){
							userOffers.remove(offer2);
							break;
						}
					}
					userDao.updateUser(user);
					returnValue = true;
				}
				tx.commit();
			} catch (Exception e) {
				System.out
					.println("UserService deleteOfferFromUserFavourites exception: "
							+ e.getMessage());
			tx.rollback();
			returnValue = false;
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return returnValue;
		}	
		return false;
	}
	
	// ok
	@WebMethod(operationName="isOfferInUserFavourites", action="isOfferInUserFavourites")
	public boolean isOfferInUserFavourites(String login, String sessionId,
			Long offerId, String userLoginFavourites){
		if (login != null && sessionId != null && offerId != null
				&& userLoginFavourites != null) {
			Session session = null;
			Transaction tx = null;
			boolean returnValue = false;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();

				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(
								login, sessionId, userLoginFavourites)) {
					User user = userDao.getUserByLogin(userLoginFavourites);
					for (Offer offer2 : user.getFavourites()) {
						if (offer2.getId().equals(offerId)){
							returnValue = true;
							break;
						}
					}
				}
				tx.commit();
			} catch (Exception e) {
				System.out.println("UserService isOfferInUserFavourites exception: "	+ e.getMessage());
				tx.rollback();
				returnValue = false;
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return returnValue;
		}
		return false;
	}
	
	// ok
	@WebMethod(operationName="addOffer", action="addOffer")
	public boolean addOffer(String login, String sessionId,
			OfferCanonical offer, String userLoginToAddOffer, List<ImageCanonical> imageCanonList) {
		if (login != null && sessionId != null && offer != null
				&& userLoginToAddOffer != null) {
			Session session = null;
			Transaction tx = null;
			boolean returnValue = false;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();

				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(
								login, sessionId, userLoginToAddOffer)) {

					User user = userDao.getUserByLogin(userLoginToAddOffer);
					if (user != null && offer != null) {
						Offer offerDB = offerTransform
								.offerCanonicalToOffer(offer, imageCanonList);
						offerDao.saveOffer(offerDB);
						user.getOffers().add(offerDB);
						userDao.updateUser(user);
						returnValue = true;
					}
				}
				tx.commit();
			} catch (Exception e) {
				System.out
						.println("UserService addOffer exception: "	+ e.getMessage());
				tx.rollback();
				returnValue = false;
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return returnValue;
		}
		return false;
	}

	// ok
	@WebMethod(operationName="updateOffer", action="updateOffer")
	public boolean updateOffer(String login, String sessionId,
			OfferCanonical offer, String userLoginToAddOffer, List<ImageCanonical> imageCanonList) {
		if (login != null && sessionId != null && offer != null
				&& userLoginToAddOffer != null) {
			Session session = null;
			Transaction tx = null;
			boolean returnValue = false;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();

				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(
								login, sessionId, userLoginToAddOffer)) {
					Offer offerDB = offerTransform.offerCanonicalToOffer(offer, imageCanonList);
					offerDao.updateOffer(offerDB);
					returnValue = true;
				}
				tx.commit();
			} catch (Exception e) {
				System.out.println("OfferService updateOffer exception: "	+ e.getMessage());
				tx.rollback();
				returnValue = false;
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return returnValue;
		}
		return false;
	}
	
	@WebMethod(operationName="deleteOffer", action="deleteOffer")
	public boolean deleteOffer(String login, String sessionId,
			Long offerId, String userLoginToDeleteOffer){
		if (login != null && sessionId != null && offerId != null
				&& userLoginToDeleteOffer != null) {
			Session session = null;
			Transaction tx = null;
			boolean returnValue = false;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();

				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(
								login, sessionId, userLoginToDeleteOffer)) {
					// usuwanie oferty podanego uzytkownika
					// usuniecie oferty z ulubionych innych uzytkownikow
					// usuniecie oferty z ofert
					User user = userDao.getUserByLogin(userLoginToDeleteOffer);
					offerDao.deleteFavouritesByOfferId(offerId, user.getId());
					
					List<Offer> offerList = user.getOffers();
					for (Offer offer : offerList) {
						if (offer.getId().equals(offerId)){
							user.getOffers().remove(offer);
							break;
						}
					}
					userDao.updateUser(user);
					
					offerDao.deleteOfferById(offerId);
					
					returnValue = true;
				}
				tx.commit();
			} catch (Exception e) {
				System.out.println("UserService deleteOffer exception: "	+ e.getMessage());
				tx.rollback();
				returnValue = false;
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return returnValue;
		}
		return false;
	}
	
	// ok
	@WebMethod(operationName="findOffersByCriteria", action="findOffersByCriteria")
	public List<OfferCanonical> findOffersByCriteria(Integer minPrice, Integer maxPrice,
			Integer minArea, Integer maxArea, Integer minFloor, Integer maxFloor, 
			Boolean isGarage, String town, String estateType, String transactionType) {
		Session session = null;
		Transaction tx = null;
		List<OfferCanonical> foundOffers = null;
		try {
			session = sessionFactory.openSession();
			tx = sessionFactory.getCurrentSession().getTransaction();
			tx.begin();
			
			List<Offer> offerDbList = offerDao.getOffersByCriteria(minPrice, maxPrice,
					minArea, maxArea, minFloor, maxFloor, isGarage, town, estateType, transactionType);
			foundOffers = offerTransform.offerListToOfferCanonicalList(offerDbList);
			
			tx.commit();
		} catch (Exception e) {
			System.out.println("UserService findOffers exception: "	+ e.getMessage());
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return foundOffers;
	}
	
	
	@WebMethod(operationName="getUserOffers", action="getUserOffers")
	public List<OfferCanonical> getUserOffers(String login, String sessionId, String userToGetOffer){
		if (login != null && sessionId != null && userToGetOffer != null) {
			Session session = null;
			Transaction tx = null;
			List<OfferCanonical> offerList = null;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				if (loggedUserUtils.isLogged(login, sessionId)
						&& loggedUserUtils.isAdminLoggedOrLoginsAreTheSame(
								login, sessionId, userToGetOffer)) {
					User user = userDao.getUserByLogin(userToGetOffer);
					List<Offer> myOfferList = user.getOffers();
					offerList = offerTransform.offerListToOfferCanonicalList(myOfferList);
				}

				tx.commit();
			} catch (Exception e) {
				System.out
						.println("OfferService getUserOffers exception: "
								+ e.getMessage());
				tx.rollback();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return offerList;
		}
		return null;
	}
	
	
	@WebMethod(operationName="getOfferImages", action="getOfferImages")
	public List<ImageCanonical> getOfferImages(Long offerIdToGetImages){
		if (offerIdToGetImages != null) {
			Session session = null;
			Transaction tx = null;
			List<ImageCanonical> imageList = null;
			try {
				session = sessionFactory.openSession();
				tx = sessionFactory.getCurrentSession().getTransaction();
				tx.begin();
				
				Offer offer = offerDao.getOfferById(offerIdToGetImages);
				imageList = imageTransform.imagesListToCanonicalImageList(offer.getImages());
				
				tx.commit();
			} catch (Exception e) {
				System.out
						.println("OfferService getOfferImages exception: "
								+ e.getMessage());
				tx.rollback();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return imageList;
		}
		return null;
	}

}
