package pl.rea.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import pl.rea.hibernate.HibernateUtil;
import pl.rea.model.Role;

public class RoleDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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
			returnRole = (Role) criteria.list().get(0);
//			returnRole = (Role) session.get(Role.class, new Long(id));
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