package test;

import javax.faces.bean.ManagedBean;

import java.util.List;  //test

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import pl.rea.hibernate.HibernateUtil;
import pl.rea.model.Address;
import pl.rea.model.EstateType;
import pl.rea.model.Offer;
import pl.rea.model.Role;
import pl.rea.model.Status;
import pl.rea.model.User;

@ManagedBean(name="testBean")
public class TestBean {

	
	public void test(){
		System.out.println("Trollllll");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
//		session.close();
		Transaction tx = session.beginTransaction();
		Status status = new Status();
		status.setStatus("trol");
		
		
		//listEstateTypes(session);
		
		System.out.println("trololo");
//		session.save(status);
		tx.commit();
		session.close();
	}

}