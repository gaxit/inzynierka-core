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
	
	// ? do przeróbki, dobre wyniki
	public List<User> getUserList() {
		Session session = null;
		Transaction tx = null;
		List<User> userList = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			userList = (List<User>) session.createCriteria(User.class).list();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return userList;
	}
	
	// ? do przeróbki, dobre wyniki
	public User getUserById(Long id) {
		Session session = null;
		Transaction tx = null;
		User returnUser = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			returnUser = (User) session.get(User.class, new Long(id));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return returnUser;
	}
	
	// ? do przeróbki, dobre wyniki
	public User getUserByName(String name) {
		Session session = null;
		Transaction tx = null;
		User returnUser = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Expression.eq("name", name));
			List<User> userList = criteria.list();
			if (userList.size() > 0) {
				returnUser = userList.get(0);
			} else {
				returnUser = null;
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return returnUser;
	}
	
	// ? do przeróbki, dobre wyniki
	public User getUserByLogin(String login) {
		Session session = null;
		Transaction tx = null;
		User returnUser = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Expression.eq("login", login));
			List<User> userList = criteria.list();
			if (userList.size() > 0) {
				returnUser = userList.get(0);
			} else {
				returnUser = null;
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return returnUser;
	}
	
	// ? do przeróbki, dobre wyniki
	public void updateUser(User user) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			session.saveOrUpdate(user);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	// ? do przeróbki, dobre wyniki
	public void createUser(User user) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			session.save(user);
			
			tx.commit();

		} catch (Exception e) {
			System.out.println("Wyjatek: " + e.getMessage());
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	// ? przerobić na deleteUser(User user)
	public void deleteUserById(Long id) {
		Session session = null;
		Transaction tx = null;
		User returnUser = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			returnUser = (User) session.get(User.class, new Long(id));
			session.delete(returnUser);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
