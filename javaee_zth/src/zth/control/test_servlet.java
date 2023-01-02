package zth.control;

import java.io.IOException;

import javax.persistence.*;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zth.dao.JPA_db;
import zth.entity.*;

/**
 * Servlet implementation class test_servlet
 */
@WebServlet("/test_servlet")
public class test_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static void testsave1(EntityManager manager) 
    {
       Sample ss=new Sample();
  	   ss.setTestNo("test1");
  	   ss.setState("1");
 	   UserInfo s=new UserInfo();
 	   s.setStuNumber("55190827");
 	   s.setName("abc");
 	   s.setLevel("1");
 	  UserInfo s2=new UserInfo();
	   s2.setStuNumber("55190828");
	   s2.setName("abc");
	   s2.setLevel("1");
	   ss.getUserInfos().add(s);
	   ss.getUserInfos().add(s2);
// 	   Teacher t1=new Teacher();
// 	   t1.setTeacherName("王一");
// 	   t1.setAge(31);
// 	   t1.setGender("male");
// 	   s.getTeachers().add(t1);
// 	   Teacher t2=new Teacher();
// 	   t2.setTeacherName("王二");
// 	   t2.setAge(36);
// 	   t2.setGender("female");
// 	   s.getTeachers().add(t2);
      EntityTransaction transaction = manager.getTransaction();
      transaction.begin();
       manager.persist(ss);
       
       transaction.commit();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		EntityManagerFactory factory =
//			       Persistence.createEntityManagerFactory("javaee_zth",null);
//			       EntityManager manager = factory.createEntityManager();
//			      try 
//			      {         
//			    	         testsave1(manager);
//			    	         
//							 //showAll(manager);
//			      } 
//			      finally 
//			      {
//			         manager.close();
//			         factory.close();
//			      }
		
		JPA_db db=new JPA_db();
   	    List<Sample> result =db.find_sample("55190828");
   	    Sample sample=result.get(0);
   	    Sample sample1=result.get(1);
   	    System.out.println(sample.getTestNo());
   	    System.out.println(sample1.getTestNo());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); 
	}

}
