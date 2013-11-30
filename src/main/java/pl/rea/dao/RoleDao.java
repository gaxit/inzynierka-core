package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import pl.rea.model.Role;
import pl.rea.utils.HibernateUtil;

@Stateless
public class RoleDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	// ? do przeróbki, dobre wyniki
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

	public Role getRoleByName(String role) {
		Session session = null;
		Transaction tx = null;
		Role returnRole = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Role.class);
			criteria.add(Expression.eq("role", role));
			List<Role> roleList = criteria.list();
			if (roleList.size() > 0) {
				returnRole = roleList.get(0);
			} else {
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
