package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import pl.rea.hibernate.HibernateUtil;
import pl.rea.model.Role;

@Stateless
public class RoleDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	//Metoda testowa
	 public void insertRole(Role role){
		  Session session = null;
		  Transaction tx = null;
		  try{  //jest po to, zeby wylapac, ze gdy cos pojdzie nie tak cofnac transakcje
		   session = sessionFactory.openSession();  //otwarcie sesji
		   tx = session.beginTransaction();  //otwarcie transakcji

		   //tutaj kod, ktory robi to, co metoda powinna robic, czyli np jakis select, insert, czy jak jest w przykladzie delete
		   session.save(role);


		   tx.commit(); //jesli kod doszedl do tego miejsca, to znaczy, ze wszystko poszlo ok i mozna commitowac transakcje

		  }
		  catch(Exception e){ //tu jest zamykana transakcja
		   tx.rollback();
		  }
		  finally{
		   session.close();  //sesja musi byc zamknieta, a ze finally wykonuje sie zawsze, wiec trzeba to umiescic tutaj
		  }
		  //gdyby zadaniem metody bylo zwrocenie czegos, t return powinien byc tutaj
		 }
	
	
	public List<Role> getRoleList() {
		Session session = null;
		Transaction tx = null;
		List<Role> roleList = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			roleList = (List<Role>) session.createCriteria(Role.class).list();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return roleList;
	}

	public Role getRoleById(Long id) {
		Session session = null;
		Transaction tx = null;
		Role returnRole = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			returnRole = (Role) session.get(Role.class, new Long(id));
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return returnRole;
	}

	public Role getRoleByName(String role) {
		Session session = null;
		Transaction tx = null;
		Role returnRole = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Role.class);
			criteria.add(Expression.eq("role",role));
			List<Role> roleList = criteria.list();
			if (roleList.size()>0){
				returnRole = roleList.get(0);
			}
			else{
				returnRole = null;
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return returnRole;
	}

}
