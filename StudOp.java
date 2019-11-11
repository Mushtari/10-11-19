package com.LTI.ColProHib;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class StudOp {
	

	public static void insert()
    {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
       EntityManager em=emf.createEntityManager();
       System.out.println("Starting Transaction");
       em.getTransaction().begin();
  
       Student o=new Student();
       o.setOdet("Shipping");
       
       @SuppressWarnings("deprecation")
   		Date d=new Date("05/26/2019");
   		o.setStudentDate(d);
   		em.persist(o);
   		em.getTransaction().commit();
   		System.out.println("Generated Student Id= " +o.getStudentId());
   		Student ol=em.find(Student.class, o.getStudentId());
   		System.out.println("got object " + ol.getOdet()+ " "+ol.getStudentId());
 
   		@SuppressWarnings("unchecked")
   		List<Student> listStudent=em.createQuery("SELECT e FROM Student e").getResultList();
 
 
   		if(listStudent == null){
   			System.out.println("No Student Found");
   		}
   		else
   		{
   			for(Student employ : listStudent)
   			{
   				System.out.println("Student Detail="+employ.getOdet()+", Studentid= "+employ.getStudentId()+",Date= "+employ.getStudentDate());
	   }
   		}
   		em.close();
   		emf.close();
}
	
	
	public static void update()
    {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
       EntityManager em=emf.createEntityManager();
       
       
       
       System.out.println("Starting Transaction");
       em.getTransaction().begin();

//       Query query = em.createQuery("UPDATE Student e SET e.odet ='OutForDelivery' WHERE e.StudentId = :or");
//       query.setParameter("or", 421);
       Query query = (Query) em.createQuery("UPDATE Student e SET e.odet =:det WHERE e.StudentId = :or ");
       query.setParameter("det", "Shipped");
       query.setParameter("or", 461);
       int rowsUpdated = query.executeUpdate();
       System.out.println("entities Updated: " + rowsUpdated);
       em.getTransaction().commit();
       System.out.println("Updating Student to DB");
       
       @SuppressWarnings("unchecked")
       List<Student> listStudent=em.createQuery("SELECT e FROM Student e").getResultList();
       
       
       if(listStudent == null){
    	   System.out.println("No Student Found");
       }
       else
       {
    	   for(Student employ : listStudent)
    	   {
    		   System.out.println("Student Detail="+employ.getOdet()+", Studentid= "+employ.getStudentId()+",Date= "+employ.getStudentDate());
    	   }
       }
       em.close();
       emf.close();
    }
	
	public void display() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
	    EntityManager em=emf.createEntityManager();
	    System.out.println("Starting Transaction");
	    em.getTransaction().begin();
	    
        @SuppressWarnings("unchecked")
	       List<Student> listStudent=em.createQuery("SELECT e FROM Student e").getResultList();
	       
	       
	       if(listStudent == null){
	    	   System.out.println("No Student Found");
	       }
	       else
	       {
	    	   for(Student employ : listStudent)
	    	   {
	    		   System.out.println("Student Detail="+employ.getOdet()+", Studentid= "+employ.getStudentId()+",Date= "+employ.getStudentDate());
	    	   }
	       }
	       em.close();
	       emf.close();
	}
	
	public void delete() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
	    EntityManager em=emf.createEntityManager();
	    System.out.println("Starting Transaction");
	    em.getTransaction().begin();

        Student o= em.find(Student.class, 441);
        em.remove(o);
        em.getTransaction().commit();
  
        @SuppressWarnings("unchecked")
	       List<Student> listStudent=em.createQuery("SELECT e FROM Student e").getResultList();
	       
	       
	       if(listStudent == null){
	    	   System.out.println("No Student Found");
	       }
	       else
	       {
	    	   for(Student employ : listStudent)
	    	   {
	    		   System.out.println("Student Detail="+employ.getOdet()+", Studentid= "+employ.getStudentId()+",Date= "+employ.getStudentDate());
	    	   }
	       }
	       em.close();
	       emf.close();
    }
		 
	    
	}


