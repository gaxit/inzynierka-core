package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import pl.rea.canonical.UserCanonical;
import pl.rea.model.User;
import pl.rea.transform.UserTransform;
import pl.rea.utils.HibernateUtil;

@Stateless
public class UserDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	// ?
	public List<User> getUserList() {
		List<User> userList = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			userList = (List<User>) session.createCriteria(User.class).list();
		} catch (Exception e) {
			System.out.println("UserDao getUserList exception: " + e.getMessage());
		}
		return userList;
	}
	
	// ok
	public User getUserByLogin(String login) {
		User returnUser = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Expression.eq("login", login));
			List<User> userList = criteria.list();
			if (userList.size() > 0) {
				returnUser = userList.get(0);
			} else {
				returnUser = null;
			}
		} catch (Exception e) {
			System.out.println("UserDao getUserByLogin exception: " + e.getMessage());
		}
		return returnUser;
	}
	
	// ok
	public void updateUser(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();

			session.merge(user);
			System.out.println("Ok, update uzytkownika");
			session.merge(user.getAddress());
			System.out.println("Ok, update adresu uzytkownika");
		} catch (Exception e) {
			System.out.println("UserDao updateUser exception: " + e.getMessage());
		}
	}
	
	// ok
	public void saveUser(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			session.save(user.getAddress());
			session.save(user);
		} catch (Exception e) {
			System.out.println("UserDao saveUser exception: " + e.getMessage());
		}
	}
	
	// ?
	public void deleteUser(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			session.delete(user);
		} catch (Exception e) {
			System.out.println("UserDao deleteUser exception: " + e.getMessage());
		}
	}
	
	// ok
	public void deleteUserByLogin(String login) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			User user = null;
			
			System.out.println("User dao login?: " + login);
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Expression.eq("login", login));
			List<User> userList = criteria.list();
			if (userList.size() > 0) {
				user = userList.get(0);
				
				OfferDao offerDao = new OfferDao();
				for (int i=0;i<user.getOffers().size();i++){
					offerDao.deleteOfferById(user.getOffers().get(i).getId());
				}
				String queryString = "DELETE FROM favourites WHERE user_id=" + user.getId() + ";";
				Query query = session.createSQLQuery(queryString);
				query.executeUpdate();
				
				session.delete(user);
				session.delete(user.getAddress());
			} else {
				user = null;
			}
			
		} catch (Exception e) {
			System.out.println("UserDao deleteUserByLogin exception: " + e.getMessage());
		}
	}

}
