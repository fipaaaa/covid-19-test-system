package zth.dao;
import java.util.ArrayList;
import zth.entity.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    DB dbzth=DB.getDB();
    user_info cur=dbzth.finduser("zth");
    
    //for(int i = 0;i < visiter.size(); i++){
    //user cur=visiter.get(i);
    System.out.println(cur.getusername());
    System.out.println(cur.getpassword());
    System.out.println(cur.getname());
    System.out.println(cur.getstu_number());
    System.out.println(cur.getlevel());
    //}
	}
		
}
