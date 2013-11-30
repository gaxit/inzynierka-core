package pl.rea.webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.dao.TransactionTypeDao;
import pl.rea.model.TransactionType;
import pl.rea.transform.DicsTransform;
import pl.rea.utils.HibernateUtil;

@WebService(serviceName = "dicsService")
@Stateless
public class DicsService {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	private TransactionTypeDao transTypeDao = new TransactionTypeDao();
	private DicsTransform dicsTransform = new DicsTransform();
	
	@WebMethod(operationName = "getTransactionTypeList", action="getTransactionTypeList")
	public List<String> getTransactionTypeList(){
		Session session = null;
		Transaction tx = null;
		List<TransactionType> transTypeList = null;
		List<String> stringList = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			transTypeList = transTypeDao.getTransactionTypeList();
			stringList = dicsTransform.transactionTypeListToStringList(transTypeList);
			
			tx.commit();
		}
		catch(Exception e){
			System.out.println("Exception in getTransactionTypeList service: " + e.getMessage());
			tx.rollback();
		}
		finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return stringList;
	}

}
