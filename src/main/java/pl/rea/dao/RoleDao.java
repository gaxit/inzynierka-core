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
	
	// ?
	public List<Role> getRoleList() {
		List<Role> roleList = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			roleList = (List<Role>) session.createCriteria(Role.class).list();
		} catch (Exception e) {
			System.out.println("RoleDao getRoleList exception: " + e.getMessage());
		}
		return roleList;
	}
	
	// ?
	public Role getRoleByName(String role) {
		Role returnRole = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			Criteria criteria = session.createCriteria(Role.class);
			criteria.add(Expression.eq("role", role));
			List<Role> roleList = criteria.list();
			if (roleList.size() > 0) {
				returnRole = roleList.get(0);
			} else {
				returnRole = null;
			}
		} catch (Exception e) {
			System.out.println("RoleDao getRoleByName exception: " + e.getMessage());
		}
		return returnRole;
	}

}
