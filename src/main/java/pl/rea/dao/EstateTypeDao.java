package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import pl.rea.model.EstateType;
import pl.rea.model.Role;
import pl.rea.utils.HibernateUtil;

@Stateless
public class EstateTypeDao {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	// ? do przeróbki, dobre wyniki
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
	
	// ? do przeróbki, dobre wyniki
	public EstateType getEstateTypeByName(String estateTypeName) {
		Session session = null;
		Transaction tx = null;
		EstateType returnEstateType = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(EstateType.class);
			criteria.add(Expression.eq("estateType",estateTypeName));
			List<EstateType> estateTypeList = criteria.list();
			if (estateTypeList.size()>0){
				returnEstateType = estateTypeList.get(0);
			}
			else{
				returnEstateType = null;
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return returnEstateType;
	}
	
}
