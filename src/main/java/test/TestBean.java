package test;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.hibernate.HibernateUtil;
import pl.rea.model.Role;
import pl.rea.model.Status;

@ManagedBean(name="testBean")
public class TestBean {
	public void test(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Role status = new Role();
		status.setId(3);
		status.setRole("trołŁ");
		session.save(status);
		
		tx.commit();
		session.close();
	}

}