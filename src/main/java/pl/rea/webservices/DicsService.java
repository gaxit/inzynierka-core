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

import pl.rea.dao.EstateTypeDao;
import pl.rea.dao.RoleDao;
import pl.rea.dao.TransactionTypeDao;
import pl.rea.model.EstateType;
import pl.rea.model.Role;
import pl.rea.model.TransactionType;
import pl.rea.transform.DicsTransform;
import pl.rea.utils.HibernateUtil;
import pl.rea.utils.LoggedUserUtils;

@WebService(serviceName = "dicsService", targetNamespace="dictionaries")
@Stateless
public class DicsService {
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	private DicsTransform dicsTransform = new DicsTransform();
	private TransactionTypeDao transTypeDao = new TransactionTypeDao();
	private EstateTypeDao estateTypeDao = new EstateTypeDao();
	private RoleDao roleDao = new RoleDao();
	
	
	@WebMethod(operationName = "getTransactionTypeList", action="getTransactionTypeList")
	public List<String> getTransactionTypeList(){
		Session session = null;
		Transaction tx = null;
		List<TransactionType> transTypeList = null;
		List<String> stringList = null;
		try{
			session = sessionFactory.openSession();
			tx = sessionFactory.getCurrentSession().getTransaction();
			tx.begin();
			
			transTypeList = transTypeDao.getTransactionTypeList();
			stringList = dicsTransform.transactionTypeListToStringList(transTypeList);
			
			tx.commit();
		}
		catch(Exception e){
			System.out.println("DicsService getTransactionTypeList exception: " + e.getMessage());
			tx.rollback();
		}
		finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return stringList;
	}
	
	@WebMethod(operationName = "getEstateTypeList", action="getEstateTypeList")
	public List<String> getEstateTypeList(){
		Session session = null;
		Transaction tx = null;
		List<EstateType> estateTypeList = null;
		List<String> stringList = null;
		try{
			session = sessionFactory.openSession();
			tx = sessionFactory.getCurrentSession().getTransaction();
			tx.begin();
			
			System.out.println("Is user logged?: " + (new LoggedUserUtils()).isUserLogged("x", "x"));
			estateTypeList = estateTypeDao.getEstateTypeList();
			stringList = dicsTransform.estateTypeListToStringList(estateTypeList);
			
			tx.commit();
		}
		catch(Exception e){
			System.out.println("DicsService getEstateTypeList exception: " + e.getMessage());
			tx.rollback();
		}
		finally {
			if (session != null && session.isOpen()) {
                session.close();
            }
		}
		return stringList;
	}
	
	
	@WebMethod(operationName = "getRoleList", action="getRoleList")
	public List<String> getRoleList(){
		Session session = null;
		Transaction tx = null;
		List<Role> roleList = null;
		List<String> stringList = null;
		try{
			session = sessionFactory.openSession();
			tx = sessionFactory.getCurrentSession().getTransaction();
			tx.begin();
			
			roleList = roleDao.getRoleList();
			stringList = dicsTransform.roleListToStringList(roleList);
			
			tx.commit();
		}
		catch(Exception e){
			System.out.println("DicsService getRoleList exception: " + e.getMessage());
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
