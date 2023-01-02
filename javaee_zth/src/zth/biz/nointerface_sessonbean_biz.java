package zth.biz;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import zth.dao.*;
import zth.entity.*;

/**
 * Session Bean implementation class nointerface_sessonbean_biz
 */
@Stateless
@LocalBean
public class nointerface_sessonbean_biz {

    /**
     * Default constructor. 
     */
    public nointerface_sessonbean_biz() {
        // TODO Auto-generated constructor stub
    	
    }
    public UserInfo get_user(String stu_number){
    	JPA_db db=new JPA_db();
   		UserInfo user=db.find_stu_number(stu_number);
   		return user;
	}
    public boolean exist_user(String stu_number){
    	JPA_db db=new JPA_db();
    	return db.exist_stu_number(stu_number);
    }

}
