package com.LTI.ColProHib;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.query.Query;

public class DepOp {
	

	public static void insert()
    {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
       EntityManager em=emf.createEntityManager();
       System.out.println("Starting Transaction");
       em.getTransaction().begin();
  
       Department dp=new Department();
       dp.setName("CSE");
       dp.setLocation("4F");
      
   		em.persist(dp);
   		em.getTransaction().commit();
   		System.out.println("Generated Department Id= " +dp.getId());
   		Department ol=em.find(Department.class, dp.getId());
   		System.out.println("got object " + ol.getName() + "  "+ol.getLocation());
   	    System.out.println("Inserted Department to DB");
 
   		em.close();
   		emf.close();
    }
	
	
	public static void update()
    {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
       EntityManager em=emf.createEntityManager();
       
            
       System.out.println("Starting Transaction");
       em.getTransaction().begin();

       Query query =(Query) em.createQuery("UPDATE Department e SET e.name =:enter WHERE e.id = :n ");
       query.setParameter("enter", "AERO");
       query.setParameter("n",1 );
       int rowsUpdated = query.executeUpdate();
       System.out.println("entities Updated: " + rowsUpdated);
       em.getTransaction().commit();
       System.out.println("Updated Department to DB");
      
       em.close();
       emf.close();
    }
	
	public void display() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistence");
	    EntityManager em=emf.createEntityManager();
	    System.out.println("Starting Transaction");
	    em.getTransaction().begin();
	    
        @SuppressWarnings("unchecked")
	       List<Department> listDepartment=em.createQuery("SELECT e FROM Department e").getResultList();
	       
	       
	       if(listDepartment == null){
	    	   System.out.println("No Department Found");
	       }
	       else
	       {
	    	   for(Department dpt : listDepartment)
	    	   {
	    		   System.out.println("Department Name="+dpt.getName()+", Departmentid= "+dpt.getId()+",Location= "+dpt.getLocation());
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

        Department o= em.find(Department.class, 441);
        em.remove(o);
        em.getTransaction().commit();
  
        @SuppressWarnings("unchecked")
	       List<Department> listDepartment=em.createQuery("SELECT e FROM Department e").getResultList();
	       
	       
	       if(listDepartment == null){
	    	   System.out.println("No Department Found");
	       }
	       else
	       {
	    	   for(Department dpt : listDepartment)
	    	   {
	    		   System.out.println("Department Name="+dpt.getName()+", Departmentid= "+dpt.getId()+",Location= "+dpt.getLocation());
	    	   }
	       }
	       em.close();
	       emf.close();
    }

}
