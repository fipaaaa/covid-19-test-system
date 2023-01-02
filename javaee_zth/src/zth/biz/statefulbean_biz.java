package zth.biz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.*;

import zth.entity.*;
import zth.dao.JPA_db;

/**
 * Session Bean implementation class statefulbean_biz
 */
@Stateful
@LocalBean
public class statefulbean_biz {

    /**
     * Default constructor. 
     */
    public statefulbean_biz() {
        // TODO Auto-generated constructor stub 
    }
    private List<UserInfo> users=new ArrayList<UserInfo>();
    public List<UserInfo> gettester(){
    	  return users;
      }
    public void addtester(String stu_number){
      JPA_db db=new JPA_db();
      UserInfo user=db.find_stu_number(stu_number);
  	 users.add(user);
    }
    public void removetester(String stu_number){
    	int flag=0;
    	for(int i = 0;i < users.size(); i++){
   		   if(users.get(i).getStuNumber().equals(stu_number)){
   			   users.remove(users.get(i));
   			   System.out.println("删除成功");
   			   flag=1;
   		   }
   	   }
    	  if(flag==0){
    	  System.out.println("列表中没有该同学");
    	  }
    }
    public void uploadtester(String test_no){
    	JPA_db db=new JPA_db();
        db.tester_sample(test_no, users);
        System.out.println("提交成功");
        users.clear();
    }
}
