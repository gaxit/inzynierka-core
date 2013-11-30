package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import pl.rea.model.User;
import pl.rea.utils.HibernateUtil;

@Stateless
public class UserDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	// ?
	public List<User> getUserList() {
		List<User> userList = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			userList = (List<User>) session.createCriteria(User.class).list();
		} catch (Exception e) {
			System.out.println("UserDao getUserList exception: " + e.getMessage());
		}
		return userList;
	}
	
	// ?
	public User getUserById(Long id) {
		User returnUser = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			returnUser = (User) session.get(User.class, new Long(id));
		} catch (Exception e) {
			System.out.println("UserDao getUserById exception: " + e.getMessage());
		}
		return returnUser;
	}
	
	// ?
	public User getUserByName(String name) {
		User returnUser = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Expression.eq("name", name));
			List<User> userList = criteria.list();
			if (userList.size() > 0) {
				returnUser = userList.get(0);
			} else {
				returnUser = null;
			}
		} catch (Exception e) {
			System.out.println("UserDao getUserByName exception: " + e.getMessage());
		}
		return returnUser;
	}
	
	// ?
	public User getUserByLogin(String login) {
		User returnUser = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
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
	
	// ?
	public void updateUser(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();

			session.saveOrUpdate(user);
		} catch (Exception e) {
			System.out.println("UserDao updateUser exception: " + e.getMessage());
		}
	}
	
	// ?
	public void saveUser(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			session.save(user);
		} catch (Exception e) {
			System.out.println("UserDao saveUser exception: " + e.getMessage());
		}
	}
	
	// ?
	public void deleteUser(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			session.delete(user);
		} catch (Exception e) {
			System.out.println("UserDao deleteUser exception: " + e.getMessage());
		}
	}

}
