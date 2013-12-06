package pl.rea.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.canonical.OfferCanonical;
import pl.rea.dao.OfferDao;
import pl.rea.model.Offer;
import pl.rea.transform.OfferTransform;
import pl.rea.utils.HibernateUtil;

@WebService(serviceName = "offerService")
@Stateless
public class OfferService {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	private OfferDao offerDao = new OfferDao();
	private OfferTransform offerTransform = new OfferTransform();
	
	// ok
	public List<OfferCanonical> getAllOffers(){
		// pobranie wszystkich ofert dostepnych w bazie
		Session session = null;
		Transaction tx = null;
		List<OfferCanonical> offerList = null;
		try{
			session = sessionFactory.openSession();
			tx = sessionFactory.getCurrentSession().getTransaction();
			tx.begin();
			
			List<Offer> offers = offerDao.getOfferList();
			offerList = offerTransform.offerListToOfferCanonicalList(offers);
			
			tx.commit();
		}
		catch(Exception e){
			System.out.println("offerService getAllOffers exception: " + e.getMessage());
			tx.rollback();
		}
		finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}		
		return offerList;
	}
	
	// ok
	public OfferCanonical getOffer(Long id){
		// pobranie informacji o jednej ofercie
		Session session = null;
		Transaction tx = null;
		OfferCanonical offer = null;
		try{
			session = sessionFactory.openSession();
			tx = sessionFactory.getCurrentSession().getTransaction();
			tx.begin();
			
			Offer offerDB = offerDao.getOfferById(id);
			offer = offerTransform.offerToOfferCanonical(offerDB);
			
			tx.commit();
		}
		catch(Exception e){
			System.out.println("offerService getOffer exception: " + e.getMessage());
			tx.rollback();
		}
		finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return offer;
	}

	public void addOfferToUserFavourites(String login, String sessionId,
			Long offerId, String userLoginToAddOffer) {
		// sprawdzanie, czy dany uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin lub login i userLoginToAddOffer jest taki sam
		// pobranie uzytkownika userLoginToAddOffer
		// pobranie oferty o podanym id
		// dodanie do jego listy ulubionych pobranej oferty
		// update uzytkownika
	}

	public List<OfferCanonical> getUserFavouritesOffers(String login,
			String sessionId, String userFavouritesLogin) {
		// sprawdzenie, czy uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin albo login i userFavouritesLogin sa takie same
		// pobranie uzytkownika o podanym loginie
		// pobranie jego listy ulubionych
		// konwersja tej listy do listy OfferCanonical - metoda z pakietu
		// transform
		// zwrocenie tej listy

		return null;
	}

	public void deleteOfferFromUserFavourites(String login, String sessionId,
			Long offerId, String userFavouritesLogin) {
		// sprawdzenie, czy uzytkownik jest zalogowany
		// sprawdzenie, czy zalogowany jest admin badz login i userFavouritesLogin sa takie same
		// pobranie uzytkownika o podanym loginie
		// pobranie jego listy ulubionych
		// usuniecie z jego listy ulubionych oferty o podanym id
	}
	
	// dodanie oferty
	
	// update oferty
	
	// usuniecie oferty

	public List<OfferCanonical> findOffers(int minPrice, int maxPrice,
			int minArea, int maxArea, String estateType, String town,
			boolean isGarage, int floor) {
		// wyszukanie ofert o podanych kryteriach

		return null;
	}

}
