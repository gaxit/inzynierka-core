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
		Session session = null;
		Transaction tx = null;
		List<Offer> offerList = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			offerList = (List<Offer>) session.createCriteria(Offer.class).list();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return offerList;
	}

	// ?
	public Offer getOfferById(Long id) {
		Session session = null;
		Transaction tx = null;
		Offer returnOffer = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			returnOffer = (Offer) session.get(Offer.class, new Long(id));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return returnOffer;
	}
	
	// ?
	public void updateOffer(Offer offer) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			session.saveOrUpdate(offer);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	// ?
	public void deleteOfferById(Long id) {
		Session session = null;
		Transaction tx = null;
		Offer returnOffer = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			returnOffer = (Offer) session.get(Offer.class, new Long(id));
			session.delete(returnOffer);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	// ? do przeróbki, dobre wyniki
	public String getOfferOwnerLogin(Offer offer) {
		Session session = null;
		Transaction tx = null;
		String returnOwnerLogin = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(User.class, "userek");
			criteria.createAlias("userek.offers", "offers");
			User user = ((List<User>) criteria.list()).get(0);
			returnOwnerLogin = user.getLogin();

			tx.commit();
		} catch (Exception e) {
			System.out.println("Wyjatek podczas pobierania wlasciciela: "
					+ e.getMessage());
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return returnOwnerLogin;
	}

}
