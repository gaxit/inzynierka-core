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
	
	// ok
	public List<EstateType> getEstateTypeList() {
		List<EstateType> estateTypeList = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			estateTypeList = (List<EstateType>) session.createCriteria(EstateType.class).list();
		} catch (Exception e) {
			System.out.println("EstateTypeDao getEstateTypeList exception: " + e.getMessage());
		}
		return estateTypeList;
	}
	
	// ok
	public EstateType getEstateTypeByName(String estateTypeName) {
		EstateType returnEstateType = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			
			Criteria criteria = session.createCriteria(EstateType.class);
			criteria.add(Expression.eq("estateType",estateTypeName));
			List<EstateType> estateTypeList = criteria.list();
			if (estateTypeList.size()>0){
				returnEstateType = estateTypeList.get(0);
			}
			else{
				returnEstateType = null;
			}
		} catch (Exception e) {
			System.out.println("EstateTypeDao getEstateTypeByName exception: " + e.getMessage());
		}
		return returnEstateType;
	}
	
}
