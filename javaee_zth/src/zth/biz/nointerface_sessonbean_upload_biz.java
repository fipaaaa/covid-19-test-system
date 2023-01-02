package zth.biz;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import zth.dao.*;
import zth.entity.*;

/**
 * Session Bean implementation class nointerface_sessonbean_upload_biz
 */
@Stateless
@LocalBean
public class nointerface_sessonbean_upload_biz {

    /**
     * Default constructor. 
     */
    public nointerface_sessonbean_upload_biz() {
        // TODO Auto-generated constructor stub
    }
    public void upload_result(String test_no,String state){
    	JPA_db db=new JPA_db();
    	if(db.exist_sample(test_no)){
    		db.upload_sample(test_no, state);
    	}
    	else{
    		System.out.println("不存在试管编号为"+test_no+"的试管，该样本状态被丢弃");
    	}
    }

}
