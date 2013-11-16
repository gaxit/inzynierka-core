package test;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.hibernate.HibernateUtil;
import pl.rea.model.Address;
import pl.rea.model.Status;

@ManagedBean(name="testBean")
public class TestBean {
	public void test(){
		System.out.println("Trollllll");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
//		session.close();
		Transaction tx = session.beginTransaction();
		Address address = new Address();
		Status status = new Status();
		status.setStatus("trol");
//		session.save(status);
		tx.commit();
		session.close();
	}

}