package pl.rea.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import pl.rea.hibernate.HibernateUtil;
import pl.rea.model.Role;
import pl.rea.model.User;

public class UserDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
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
			if (userList.size()>0){
				returnUser = userList.get(0);
			}
			else{
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
			if (userList.size()>0){
				returnUser = userList.get(0);
			}
			else{
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
	
	 public void updateUser(User user){
		  Session session = null;
		  Transaction tx = null;
		  try{  
		   session = sessionFactory.openSession();  
		   tx = session.beginTransaction();  
		   
		   session.saveOrUpdate(user);
		   tx.commit(); 

		  }
		  catch(Exception e){ 
		   tx.rollback();
		  }
		  finally{
		   session.close();  
		  }
		 }
	 
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
		
		public void deleteUserByName(String name) {
			Session session = null;
			Transaction tx = null;
			User returnUser = null;
			try {
				session = sessionFactory.openSession();
				tx = session.beginTransaction();
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Expression.eq("name", name));
				List<User> userList = criteria.list();
				if (userList.size()>0){
					returnUser = userList.get(0);
				}
				else{
					returnUser = null;
				}
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
		
	
		public String signIn(String login, String password) {
			Session session = null;
			Transaction tx = null;
			User returnUser = null;
			String sessionId = null;
			try {
				session = sessionFactory.openSession();
				tx = session.beginTransaction();
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Expression.eq("login", login));
				List<User> userList = criteria.list();
				if (userList.size()>0){
					returnUser = userList.get(0);
				}
				else{
					returnUser = null;
				}
				
				if (returnUser.getPassword().equals(password))
				{
					sessionId=returnUser.getSessionId();
				}
				
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
			} finally {
				if (session != null && session.isOpen()) {
	                session.close();
	            }
			}
			return sessionId;
		}
		
}
