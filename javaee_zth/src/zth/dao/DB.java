package zth.dao;
import java.sql.*;
import java.util.ArrayList;
import zth.entity.*;

public class DB {
	public Connection conn=null;
	static DB visit = null;
  DB(){
    try {
      Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Success loading Mysql Driver!");
    }
    catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zth_1","root","123456");
      
           
      System.out.println("Success connect Mysql server!");
//while (rs.next()) {
  //      System.out.println(rs.getString("name"));
    //  }
    }
    catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
  }
  
  public static DB getDB(){
	  if(visit==null){
		  visit=new DB();
	  }
	  return visit;
  }
  
//  public user_info finduser(String username){
//	  user_info reuser=new user_info();
//      Statement stmt;
//      ResultSet rs;
//	  String sql="select * from user_info where username='";
//      sql=sql+username+"'";
//	try {
//		stmt = conn.createStatement();
//		rs = stmt.executeQuery(sql); 
//		while (rs.next()) {
//		   reuser.setname(rs.getString("name"));
//		   reuser.setstu_number(rs.getInt("stu_number"));
//		   reuser.setpassword(rs.getString("password"));
//		   reuser.setusername(rs.getString("username"));
//		   reuser.setlevel(rs.getInt("level"));
//		}
//		rs.close(); 
//	    stmt.close(); 
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return reuser;
//  }
//  public ArrayList<user> getalluser(){
//	  ArrayList<user> userlist=new ArrayList<user>();
//      Statement stmt;
//      ResultSet rs;
//	  String sql="select * from table_1 ";
//	try {
//		stmt = conn.createStatement();
//		rs = stmt.executeQuery(sql); 
//		while (rs.next()) {
//		   user reuser=new user();
//		   reuser.setName(rs.getString("name"));
//		   reuser.setRole(rs.getString("role"));
//		   reuser.setPassword(rs.getString("password"));
//		   reuser.setId(rs.getInt("id"));
//		   userlist.add(reuser);
//		}
//		rs.close(); 
//	    stmt.close(); 
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return userlist;
//  }
  
//  public boolean insertuser(String name,String password){
//	  PreparedStatement pstmt;
//      Statement stmt;
//      ResultSet rs;
//	  String sql2="select 1 from table_1 where name='";
//      sql2=sql2+name+"'";
//      try {
//		stmt = conn.createStatement();
//		rs = stmt.executeQuery(sql2); 
//	      if(rs.absolute(1)){//查询用户是否存在
//	    	  //System.out.println("1");
//	    	  rs.close();
//	    	  stmt.close();
//	    	  return false;
//	      }
//	      else{
//	    	  //System.out.println("0");
//	    	  rs.close();
//	    	  stmt.close();
//		String sql="insert into table_1(name,password,id,role) values(?,?,?,?)";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, name);
//		pstmt.setString(2, password);
//		pstmt.setInt(3, 1);
//		pstmt.setString(4, "user");
//		pstmt.executeUpdate(); 
//		pstmt.close();
//		return true;
//	      }
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//      return false;
//  }
  
  
//  public ArrayList<message> getallmessage(){
//	  ArrayList<message> messagelist=new ArrayList<message>();
//      Statement stmt;
//      ResultSet rs;
//	  String sql="select * from table_2 ";
//	try {
//		stmt = conn.createStatement();
//		rs = stmt.executeQuery(sql); 
//		while (rs.next()) {
//		   message messages=new message();
//		   messages.setDate(rs.getString("datetime"));
//		   messages.setMessage(rs.getString("message"));
//		   messagelist.add(messages);
//		}
//		rs.close(); 
//	    stmt.close(); 
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return messagelist;
//  }
//  public void insertmessage(String datetime ,String message){
//	  try{
//	  PreparedStatement pstmt = null;
//	  //for(int i=0;i<num;i++){
//		  //System.out.println("datatime:"+datetime);
//		  //System.out.println("datamess:"+message);
//		String sql="insert into table_2(datetime,message) values(?,?)";
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, datetime);
//		pstmt.setString(2, message);
//	  pstmt.executeUpdate(); 
//        
//        pstmt.close();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//  }
//  public void close(){
//	  if(conn!=null){
//   	   try {
//		conn.close();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//   }
//  }
  }
