package test;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.hibernate.HibernateUtil;
import pl.rea.model.Offer;
import pl.rea.model.Status;

@ManagedBean(name="testBean")
public class TestBean {
	

	public void doIt()
	{
		//test method
	}
	
	public void test(){
		System.out.println("Trollllll");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
//		session.close();
		Transaction tx = session.beginTransaction();
		Status status = new Status();
		status.setStatus("trol");
		
		doIt();
		
		System.out.println("trololo");
//		session.save(status);
		tx.commit();
		session.close();
	}

}