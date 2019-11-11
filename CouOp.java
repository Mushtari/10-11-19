package com.LTI.ColProHib;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

public class CouOp {
	
	
	public static void insert()
    {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
       EntityManager em=emf.createEntityManager();
       System.out.println("Starting Transaction");
       em.getTransaction().begin();
  
       Department d=em.find(Department.class, 1);
       Instructor i=em.find(Instructor.class, 1);
       
       Course co=new Course();
       co.setName("JAVA");
       co.setPreq("OOPS");
       co.setDur(3);
       co.setD(d);
       co.setI(i);
       
       
      	em.persist(co);
   		em.getTransaction().commit();
   		System.out.println("Generated Course Id= " +co.getCouid());
   		Course c=em.find(Course.class, co.getCouid());
   		System.out.println("got object " +c.getName()+ " "+co.getPreq()+" "+co.getDur()+" "+co.getD()+" "+co.getI());
 
   		@SuppressWarnings("unchecked")
   		List<Course> listCourse=em.createQuery("SELECT e FROM Course e").getResultList();
 
 
   		if(listCourse == null){
   			System.out.println("No Course Found");
   		}
   		else
   		{
   			for(Course employ : listCourse)
   			{
   				System.out.println("Course Detail="+employ.getOdet()+", Courseid= "+employ.getCourseId()+",Date= "+employ.getCourseDate());
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

//       Query query = em.createQuery("UPDATE Course e SET e.odet ='OutForDelivery' WHERE e.CourseId = :or");
//       query.setParameter("or", 421);
       Query query = (Query) em.createQuery("UPDATE Course e SET e.odet =:det WHERE e.CourseId = :or ");
       query.setParameter("det", "Shipped");
       query.setParameter("or", 461);
       int rowsUpdated = query.executeUpdate();
       System.out.println("entities Updated: " + rowsUpdated);
       em.getTransaction().commit();
       System.out.println("Updating Course to DB");
       
       @SuppressWarnings("unchecked")
       List<Course> listCourse=em.createQuery("SELECT e FROM Course e").getResultList();
       
       
       if(listCourse == null){
    	   System.out.println("No Course Found");
       }
       else
       {
    	   for(Course employ : listCourse)
    	   {
    		   System.out.println("Course Detail="+employ.getOdet()+", Courseid= "+employ.getCourseId()+",Date= "+employ.getCourseDate());
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
	       List<Course> listCourse=em.createQuery("SELECT e FROM Course e").getResultList();
	       
	       
	       if(listCourse == null){
	    	   System.out.println("No Course Found");
	       }
	       else
	       {
	    	   for(Course employ : listCourse)
	    	   {
	    		   System.out.println("Course Detail="+employ.getOdet()+", Courseid= "+employ.getCourseId()+",Date= "+employ.getCourseDate());
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

        Course o= em.find(Course.class, 441);
        em.remove(o);
        em.getTransaction().commit();
  
        @SuppressWarnings("unchecked")
	       List<Course> listCourse=em.createQuery("SELECT e FROM Course e").getResultList();
	       
	       
	       if(listCourse == null){
	    	   System.out.println("No Course Found");
	       }
	       else
	       {
	    	   for(Course employ : listCourse)
	    	   {
	    		   System.out.println("Course Detail="+employ.getOdet()+", Courseid= "+employ.getCourseId()+",Date= "+employ.getCourseDate());
	    	   }
	       }
	       em.close();
	       emf.close();
    }
	

}
