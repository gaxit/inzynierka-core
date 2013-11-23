package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pl.rea.model.Role;
import pl.rea.utils.HibernateUtil;

public class TestDao {

 private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

 public void insertRole(Role role){
  Session session = null;
  Transaction tx = null;
  try{  //jest po to, zeby wylapac, ze gdy cos pojdzie nie tak cofnac transakcje
   session = sessionFactory.openSession();  //otwarcie sesji
   tx = session.beginTransaction();  //otwarcie transakcji

   //tutaj kod, ktory robi to, co metoda powinna robic, czyli np jakis select, insert, czy jak jest w przykladzie delete
   session.save(role);


   tx.commit(); //jesli kod doszedl do tego miejsca, to znaczy, ze wszystko poszlo ok i mozna commitowac transakcje

  }
  catch(Exception e){ //tu jest zamykana transakcja
   tx.rollback();
  }
  finally{
   session.close();  //sesja musi byc zamknieta, a ze finally wykonuje sie zawsze, wiec trzeba to umiescic tutaj
  }
  //gdyby zadaniem metody bylo zwrocenie czegos, t return powinien byc tutaj
 }

 public List<Role> getRoles(){
  Session session = null;
  Transaction tx = null;
  List<Role> roleList = null;
  try{  //jest po to, zeby wylapac, ze gdy cos pojdzie nie tak cofnac transakcje
   session = sessionFactory.openSession();  //otwarcie sesji
   tx = session.beginTransaction();  //otwarcie transakcji

   //tutaj kod, ktory robi to, co metoda powinna robic, czyli np jakis select, insert, czy jak jest w przykladzie delete
   roleList = (List<Role>)session.createCriteria(Role.class).list();


   
   tx.commit(); //jesli kod doszedl do tego miejsca, to znaczy, ze wszystko poszlo ok i mozna commitowac transakcje

  }
  catch(Exception e){ //tu jest zamykana transakcja
	  
   tx.rollback();
  }
  finally{
   session.close();  //sesja musi byc zamknieta, a ze finally wykonuje sie zawsze, wiec trzeba to umiescic tutaj
  }
  return roleList;
  //gdyby zadaniem metody bylo zwrocenie czegos, t return powinien byc tutaj
 }

}