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

	//----1)helpful, but not directly used, methods
	
	public void listAddresses(Session session)
	{
		//lists some info about addresses to verify if they were added correctly
		List <Address> AddressList;
		AddressList= ((SharedSessionContract) session).createCriteria(Address.class).list();
		int size=AddressList.size();
		if (size>0)
		{
		//return AddressList;
		for (int i=0; i<size; i++){
			Address currentAddress = AddressList.get(i);
			System.out.println("This is a new address.");
			System.out.println(currentAddress.getTown());
			System.out.println(currentAddress.getId());
		}
		}
	}
	
	public List<Role> getUserRoles(Session session)
	{
		//returns a list of all roles
		List <Role> roleList;
	    roleList= ((SharedSessionContract) session).createCriteria(Role.class).list();
	    return roleList;

	}
	
	public void createTestRole (Session session)
	{
		Role newRole = new Role();
		newRole.setId((long) 8);
		newRole.setRole("USER");
		
		System.out.println("before save");
		//session.saveOrUpdate(newRole);	
		System.out.println("After save");
		
	}
	
	public void deleteTestRole (Session session, Long id) //ok
	{
		
		List <Role> roleList;
	    roleList= ((SharedSessionContract) session).createCriteria(Role.class).list();
		int size = roleList.size();
		if (size>0)
		{
		for (int i=0; i<size; i++){
			Role currentRole = roleList.get(i);
			System.out.println("Before deletion");
			if (currentRole.getId()==42)
			{
				session.delete(currentRole);
			}
			System.out.println("After deletion");
		}
		}
		
	}
	

	//----2) methods used to test actual methods (they have the prefix test in their names)
	
	
	public void testgetUserRoles(Session session)
	{
		List <Role> TestList = getUserRoles(session);

		int size = TestList.size();
		if (size>0)
		{
		for (int i=0; i<size; i++){
			Role currentRole = TestList.get(i);
			System.out.println(currentRole.getRole());
			System.out.println(currentRole.getId());
		}
		
		}
	}
	
	/*
	public void testgetUserRole(Session session, Long id)
	{
		Role TestRole = getUserRole(session,id);

		System.out.println(TestRole.getId());
	}
	*/
	/*
	public void testgetUsers(Session session)
	{
		List <User> TestList = getUsers(session);

		int size = TestList.size();
		if (size>0)
		{
		for (int i=0; i<size; i++){
			User currentU = TestList.get(i);
			System.out.println(currentU.getName());
			System.out.println(currentU.getLogin());
		}
		
		}
	}
	*/
	/*
	public void testgetUser(Session session, Long id)
	{
		User u=getUser(session,id);
		System.out.println(u.getLogin());
		System.out.println(u.getName());
	}
	*/
	/*
	public void testlogin(Session session, String login, String password)
	{
		String sessId=login(session,login,password);
		System.out.println(sessId);
	}
	*/
	//----3)space for generating actual methods


	
	//end ----space for generaing actual methods
	
	public void test(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Status status = new Status();
		
		status.setStatus("trol");
		
		testgetUserRoles(session);
		createTestRole(session);
		testgetUserRoles(session);
		System.out.println("successful test is successful");
		
		
		System.out.println("trololo");
//		session.save(status);

		
//		Role status2 = new Role();
//		status2.setId((long) 3);
//		status2.setRole("trołŁ");
//		session.save(status2);
		
		testgetUserRoles(session);
		
		
		tx.commit();
		session.close();
	}

}
