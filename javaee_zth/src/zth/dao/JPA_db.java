package zth.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import zth.entity.*;

public class JPA_db {
      public void insert_user(String username,String password,String name,String stu_number,String level){
    	  EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
			      try 
			      {         
			    	   UserInfo user=new UserInfo();
			    	   user.setUsername(username);
			    	   user.setStuNumber(stu_number);
			    	   user.setPassword(password);
			    	   user.setName(name);
			    	   user.setLevel(level);
			    	   EntityTransaction transaction = manager.getTransaction();
			    	      transaction.begin();
			    	       manager.persist(user);
			    	       transaction.commit();
			      } 
			      finally 
			      {
			         manager.close();
			         factory.close();
			      }
      }
      public boolean exist_stu_number(String stu_number){
    	  EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
    	  Query query = manager.createQuery("Select u from UserInfo u where u.stuNumber=?1");
    	  query.setParameter(1,stu_number);
    	  List<UserInfo> results=query.getResultList();
    	  if(results.isEmpty()){
    		  return false;
    	  }
    	  
		return true;
    	  
      }
      public boolean exist_username(String username){
    	  EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
    	  Query query = manager.createQuery("Select u from UserInfo u where u.username=?1");
    	  query.setParameter(1,username);
    	  List<UserInfo> results=query.getResultList();
    	  if(results.isEmpty()){
    		  return false;
    	  }
    	  
		return true;
    	  
      }
      public List<UserInfo> find_alluser(){
    	  EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
   	  Query query = manager.createQuery("Select u from UserInfo u ");
   	  List<UserInfo> results=query.getResultList();
    	  
		return results;
    	  
      }
      public UserInfo find_username(String username){
    	  EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
    	  Query query = manager.createQuery("Select u from UserInfo u where u.username=?1");
    	  query.setParameter(1,username);
    	  List<UserInfo> results=query.getResultList();
    	  UserInfo user=results.get(0);
    	  return user;
      }
      public UserInfo find_stu_number(String stu_number){
    	  EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
    	  Query query = manager.createQuery("Select u from UserInfo u where u.stuNumber=?1");
    	  query.setParameter(1,stu_number);
    	  List<UserInfo> results=query.getResultList();
    	  UserInfo user=results.get(0);
    	  return user;
      }
      
      public void tester_sample(String test_no,List<UserInfo> users){
    	  Date date=new Date(); //获取一个Date对象
			DateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //创建一个格式化日期对象
			String datetime= simpleDateFormat.format(date);
    	  EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
			       Sample sample=new Sample();
			  	   sample.setTestNo(test_no);
			  	   sample.setState("unknow");
			  	   sample.setSampleTime(datetime);
			 	   sample.setUserInfos(users);
			 	  EntityTransaction transaction = manager.getTransaction();
			      transaction.begin();
			       manager.persist(sample);
			       transaction.commit();
      }
      public boolean exist_sample(String test_no){
    	  EntityManagerFactory factory =
    	    	  Persistence.createEntityManagerFactory("javaee_zth",null);
    		       EntityManager manager = factory.createEntityManager();
    	           Query query = manager.createQuery("Select s from Sample s where s.testNo=?1");
    	            query.setParameter(1,test_no);
    	           List<Sample> samples=query.getResultList();
    	           if(samples.isEmpty()){
    	     		  return false;
    	     	  }
    	     	  
    	 		return true;
      }
      public Sample find_sample(String test_no){
    	  EntityManagerFactory factory =
    	  Persistence.createEntityManagerFactory("javaee_zth",null);
	       EntityManager manager = factory.createEntityManager();
           Query query = manager.createQuery("Select s from Sample s where s.testNo=?1");
            query.setParameter(1,test_no);
           List<Sample> samples=query.getResultList();
           Sample sample=samples.get(0);
    	  return sample;
      }
      public void upload_sample(String test_no,String state){
    	  Date date=new Date(); //获取一个Date对象
			DateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //创建一个格式化日期对象
			String datetime= simpleDateFormat.format(date);
    	  EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
			       Sample sample=find_sample(test_no);
			  	   sample.setState(state);
			  	   sample.setUploadTime(datetime);
			 	  EntityTransaction transaction = manager.getTransaction();
			      transaction.begin();
			       manager.merge(sample);
			       transaction.commit();
      }
}
