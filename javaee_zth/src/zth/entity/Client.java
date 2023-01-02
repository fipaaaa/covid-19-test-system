package zth.entity;
import javax.persistence.*;
import java.util.*;

public class Client {


 public static void main(String[] args) throws Exception 
  {   	  
     EntityManagerFactory factory =
       Persistence.createEntityManagerFactory("javaee_zth",null);
       EntityManager manager = factory.createEntityManager();
      try 
      {         
    	         testsave1(manager);
    	         
				 //showAll(manager);
      } 
      finally 
      {
         manager.close();
         factory.close();
      }
   }
   public static void testsave1(EntityManager manager) 
   {
	   UserInfo s=new UserInfo();
	   s.setName("abc");
	   s.setStuNumber(55190828);
//	   Teacher t1=new Teacher();
//	   t1.setTeacherName("王一");
//	   t1.setAge(31);
//	   t1.setGender("male");
//	   s.getTeachers().add(t1);
//	   Teacher t2=new Teacher();
//	   t2.setTeacherName("王二");
//	   t2.setAge(36);
//	   t2.setGender("female");
//	   s.getTeachers().add(t2);
     EntityTransaction transaction = manager.getTransaction();
     transaction.begin();
      manager.persist(s);
      
      transaction.commit();
   }
   
  
//  public static void showAll(EntityManager manager)
//   {
//   	     EntityTransaction transaction = manager.getTransaction();
//   	     transaction.begin();
//  	     Query q=manager.createQuery("from Student c");
//         List results=q.getResultList();
//        transaction.commit();
//         Iterator it=results.iterator();
//         while(it.hasNext())
//        {
//        	 Student p=(Student)it.next();
//        	  System.out.print(p.getId()+"\t");
//         	  System.out.print(p.getName()+"\t");
//        		  System.out.println(p.getGender()+"\t");
//         }
//   }
}






