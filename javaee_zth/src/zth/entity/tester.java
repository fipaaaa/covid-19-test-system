package zth.entity;
import java.util.ArrayList;
import java.util.List;

import zth.entity.*;

public class tester {
	  public static List<UserInfo> line=new ArrayList<UserInfo>();
      public void addtester(UserInfo user){
    	  line.add(user);
      }
      public void removetester(UserInfo user){
    	  line.remove(user);
      }
      public void cleartester(){
    	  line.clear();
      }
}
