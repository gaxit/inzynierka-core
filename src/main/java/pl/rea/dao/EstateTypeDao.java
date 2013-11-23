package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.model.EstateType;
import pl.rea.utils.HibernateUtil;

@Stateless
public class EstateTypeDao {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<EstateType> getEstateTypeList() {
		Session session = null;
		Transaction tx = null;
		List<EstateType> estateTypeList = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			estateTypeList = (List<EstateType>) session.createCriteria(EstateType.class).list();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return estateTypeList;
	}
	
}
