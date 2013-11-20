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
		  TestDao dao = new TestDao();
		  Role role1 = new Role();
		  role1.setRole("Trol");
		  dao.insertRole(role1);
		  List<Role> role = dao.getRoles();
		  for (int i=0;i<role.size();i++){
		   System.out.println(role.get(i).getRole());
		  }
		  Role role2 = new Role();
		  role2.setRole("Dupa");
		  dao.insertRole(role2);
		  role = dao.getRoles();
		  for (int i=0;i<role.size();i++){
		   System.out.println(role.get(i).getRole());
		  }
		 }

}
