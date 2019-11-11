package com.LTI.ColProHib;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

public class InstOp {

	

	public static void insert()
    {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
       EntityManager em=emf.createEntityManager();
       System.out.println("Starting Transaction");
       em.getTransaction().begin();
  
       Department d=new Department();
       d.getId();
       em.persist(d);
       Instructor ins=new Instructor();
       ins.setName("Mushtari");
       ins.setPhno(99480);
       ins.setRmno(401);
       ins.setD(d);
       
   
   		em.persist(ins);
   		em.getTransaction().commit();
   		System.out.println("Generated Instructor Id= " +ins.getId());
   		Instructor inst=em.find(Instructor.class, ins.getId());
   		System.out.println("got object " +inst.getName()+ " "+inst.getPhno()+ " "+ inst.getRmno());
 
   		em.close();
   		emf.close();
}
	
	
	public static void update()
    {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
       EntityManager em=emf.createEntityManager();
       
       
       
       System.out.println("Starting Transaction");
       em.getTransaction().begin();

       Query query = (Query) em.createQuery("UPDATE Instructor e SET e.odet =:enter WHERE e.InstructorId = :n ");
       query.setParameter("enter", "Khan");
       query.setParameter("n", 461);
       int rowsUpdated = query.executeUpdate();
       System.out.println("entities Updated: " + rowsUpdated);
       em.getTransaction().commit();
       System.out.println("Updating Instructor to DB");
       
       @SuppressWarnings("unchecked")
       List<Instructor> listInstructor=em.createQuery("SELECT e FROM Instructor e").getResultList();
       
       
       if(listInstructor == null){
    	   System.out.println("No Instructor Found");
       }
       else
       {
    	   for(Instructor i : listInstructor)
    	   {
    		   System.out.println("Instructor ID="+i.getId()+", Instructor Name= "+i.getName()+" Phno= "+i.getPhno()+" Rmno= "+i.getRmno());
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
	       List<Instructor> listInstructor=em.createQuery("SELECT e FROM Instructor e").getResultList();
	       
	       
	       if(listInstructor == null){
	    	   System.out.println("No Instructor Found");
	       }
	       else
	       {
	    	   for(Instructor i : listInstructor)
	    	   {
	    		   System.out.println("Instructor ID="+i.getId()+", Instructor Name= "+i.getName()+" Phno= "+i.getPhno()+" Rmno= "+i.getRmno());
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

        Instructor o= em.find(Instructor.class, 441);
        em.remove(o);
        em.getTransaction().commit();
  
        @SuppressWarnings("unchecked")
	       List<Instructor> listInstructor=em.createQuery("SELECT e FROM Instructor e").getResultList();
	       
	       
	       if(listInstructor == null){
	    	   System.out.println("No Instructor Found");
	       }
	       else
	       {
	    	   for(Instructor i : listInstructor)
	    	   {
	    		   System.out.println("Instructor ID="+i.getId()+", Instructor Name= "+i.getName()+" Phno= "+i.getPhno()+" Rmno= "+i.getRmno());
	    	   }
	       }
	       em.close();
	       emf.close();
    }	
	
}
