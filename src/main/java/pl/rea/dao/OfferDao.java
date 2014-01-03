package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import pl.rea.model.Offer;
import pl.rea.model.User;
import pl.rea.utils.HibernateUtil;

@Stateless
public class OfferDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	// ok
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

	// ok
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
	
	// ok
	public void updateOffer(Offer offer) {
		try {
			Session session = sessionFactory.getCurrentSession();

			session.saveOrUpdate(offer.getAddress());
			session.saveOrUpdate(offer);
		} catch (Exception e) {
			System.out.println("OfferDao updateOffer exception: " + e.getMessage());
		}
	}
	
	// ok
	public void deleteOfferById(Long id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			Criteria criteria = session.createCriteria(Offer.class);
			criteria.add(Expression.eq("id", id));
			List<Offer> offerList = criteria.list();
			Offer offer = null;
			if (offerList.size() > 0) {
				offer = offerList.get(0);
				session.delete(offer);
			}			
		} catch (Exception e) {
			System.out.println("OfferDao deleteOffer exception: " + e.getMessage());
		}
	}
	
	// ok
	public String getOfferOwnerLogin(Offer offer) {
		String returnOwnerLogin = null;
		try {
			Session session = sessionFactory.getCurrentSession();

			Criteria criteria = session.createCriteria(User.class, "userek");
//			criteria.createAlias("userek.offers", "offers");
			String stringQuery = "SELECT u.login FROM userek u JOIN owner_offer o ON u.user_id=o.user_id WHERE o.offer_id=" + offer.getId() + ";";
			returnOwnerLogin = ((List<String>) session.createSQLQuery(stringQuery).list()).get(0);
//			User user = ((List<User>) criteria.list()).get(0);
		} catch (Exception e) {
			System.out.println("OfferDao getOfferOwnerLogin exception: " + e.getMessage());
		}
		return returnOwnerLogin;
	}
	
	// ok
	public void saveOffer(Offer offer){
		try{
			Session session = sessionFactory.getCurrentSession();
			
			for (int i=0;i<offer.getImages().size();i++){
				session.save(offer.getImages().get(i));
			}
			session.save(offer.getAddress());
			session.save(offer);
			
		} catch (Exception e) {
			System.out.println("OfferDao saveOffer exception: " + e.getMessage());
		}
	}
	
	// ok
	public void deleteFavouritesByOfferId(Long offerId, Long userId){
		try{
			Session session = sessionFactory.getCurrentSession();
			
			session.createSQLQuery("DELETE FROM favourites WHERE offer_id=" + (long)offerId + " AND user_id=" + (long)userId).executeUpdate();
		} catch (Exception e) {
			System.out.println("OfferDao deleteFavouritesByOfferId exception: " + e.getMessage());
		}
	}
	
	public List<Offer> getOffersByCriteria(Integer minPrice, Integer maxPrice,
			Integer minArea, Integer maxArea, Integer minFloor, Integer maxFloor, 
			Boolean isGarage, String town, String estateType, String transactionType){
		List<Offer> offerList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			
			Criteria criteria = session.createCriteria(Offer.class, "offer");
			
			if (minPrice != null && minPrice!=0){
				criteria.add(Expression.ge("price", minPrice));
			}
			if (maxPrice != null && maxPrice!=0){
				criteria.add(Expression.le("price", maxPrice));
			}
			if (minArea != null && minArea!=0){
				criteria.add(Expression.ge("area", minArea));
			}
			if (maxArea != null && maxArea!=0){
				criteria.add(Expression.le("area", maxArea));
			}
			if (minFloor != null && minFloor!=0){
				criteria.add(Expression.ge("floor", minFloor));
			}
			if (maxFloor != null && maxFloor !=0){
				criteria.add(Expression.le("floor", maxFloor));
			}
			if (isGarage != null){
				criteria.add(Expression.eq("garage", isGarage));
			}
			if (town != null && !town.equals("")){
				criteria.createAlias("offer.address", "address");
				criteria.add(Expression.eq("address.town", town));
			}
			if (estateType != null && !estateType.equals("")){
				criteria.createAlias("offer.estateType", "estateType");
				criteria.add(Expression.eq("estateType.estateType", estateType));
			}
			if (transactionType != null && !transactionType.equals("")){
				criteria.createAlias("offer.transactionType", "transType");
				criteria.add(Expression.eq("transType.transactionType", transactionType));
			}
			
			offerList = criteria.list();
			
		} catch (Exception e) {
			System.out.println("OfferDao getOffersByCriteria exception: " + e.getMessage());
		}
		return offerList;
	}

}
