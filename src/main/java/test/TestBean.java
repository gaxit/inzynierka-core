package test;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.hibernate.HibernateUtil;

@ManagedBean(name="testBean")
public class TestBean {
	public void test(){
		System.out.println("Trollllll");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Test test = new Test();
		test.setId(5);
		Session session = sessionFactory.openSession();
		session.close();
//		Transaction tx = session.beginTransaction();
//		session.save(test);
//		sessionFactory.getCurrentSession();
//		tx.commit();
//		session.close();
	}

}