package pl.rea.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;

import pl.rea.model.TransactionType;
import pl.rea.utils.HibernateUtil;

@Stateless
public class TransactionTypeDao {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	//ok
	public List<TransactionType> getTransactionTypeList() {
		List<TransactionType> transactionTypeList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			transactionTypeList = (List<TransactionType>) session.createCriteria(TransactionType.class).list();
		}
		catch(Exception e){
			System.out.println("TransactionTypeDao getTransactionTypeList exception: " + e.getMessage());
		}
		return transactionTypeList;
	}

	// ?
	public TransactionType getTransactionTypeByName(String transactionTypeName) {
		TransactionType returnTransactionType = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			
			Criteria criteria = session.createCriteria(TransactionType.class);
			criteria.add(Expression.eq("transactionType", transactionTypeName));
			List<TransactionType> transactionTypeList = criteria.list();
			if (transactionTypeList.size() > 0) {
				returnTransactionType = transactionTypeList.get(0);
			} else {
				returnTransactionType = null;
			}
		} catch (Exception e) {
			System.out.println("TransactionTypeDao getTransactionTypeByName exception: " + e.getMessage());
		}
		return returnTransactionType;
	}

}
