package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import pl.rea.model.Offer;
import pl.rea.model.User;
import pl.rea.utils.HibernateUtil;

@Stateless
public class OfferDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	// ?
	public List<Offer> getOfferList() {
		List<Offer> offerList = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			offerList = (List<Offer>) session.createCriteria(Offer.class).list();
		} catch (Exception e) {
			System.out.println("OfferDao getOfferList exception: " + e.getMessage());
		}
		return offerList;
	}

	// ?
	public Offer getOfferById(Long id) {
		Offer returnOffer = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			returnOffer = (Offer) session.get(Offer.class, new Long(id));
		} catch (Exception e) {
			System.out.println("OfferDao getOfferById exception: " + e.getMessage());
		}
		return returnOffer;
	}
	
	// ?
	public void updateOffer(Offer offer) {
		try {
			Session session = sessionFactory.getCurrentSession();

			session.saveOrUpdate(offer);
		} catch (Exception e) {
			System.out.println("OfferDao updateOffer exception: " + e.getMessage());
		}
	}
	
	// ?
	public void deleteOffer(Offer offer) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			session.delete(offer);
		} catch (Exception e) {
			System.out.println("OfferDao deleteOffer exception: " + e.getMessage());
		}
	}
	
	// ?
	public String getOfferOwnerLogin(Offer offer) {
		String returnOwnerLogin = null;
		try {
			Session session = sessionFactory.getCurrentSession();

			Criteria criteria = session.createCriteria(User.class, "userek");
			criteria.createAlias("userek.offers", "offers");
			User user = ((List<User>) criteria.list()).get(0);
			returnOwnerLogin = user.getLogin();
		} catch (Exception e) {
			System.out.println("OfferDao getOfferOwnerLogin exception: " + e.getMessage());
		}
		return returnOwnerLogin;
	}

}
