package zth.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import zth.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zth.dao.JPA_db;

/**
 * Servlet implementation class manageallservlet
 */
@WebServlet("/manageallservlet")
public class manageallservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageallservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
   		PrintWriter out=response.getWriter();
   		out.println("<!DOCTYPE html>");
   		out.println("<html>");
   		out.println("<head>");
   		out.println("<meta charset=\"UTF-8\">");
   		out.println("<title>welcome</title>");
   		out.println("</head>");
   		out.println("<body style=\"text-align: center;\">");
   		JPA_db db=new JPA_db();
   	    List<UserInfo> result =db.find_alluser();
   	    if(result.isEmpty()){
   	    	out.println("<h1 style=\"text-align: center;color: blue;\">���ݿⲻ�����û�</h1><br>");
   	    }
   	    else{
   	    	out.println("<h1 style=\"text-align: center;color: blue;\">�û��б�����</h1><br>");
   	   for (Iterator it = result.iterator(); it.hasNext();) {
   		   UserInfo user=(UserInfo)it.next();
   		out.println("<p>�û���:" +user.getUsername()+ "</p>");
   		out.println("<p>����:" +user.getName()+ "</p>");
   		out.println("<p>���:" +user.getStuNumber()+ "</p>");
   		out.println("<p>Ȩ�޵ȼ�:" +user.getLevel()+ "</p>");
   		out.println("<br>");
   	   }
   	    }
   		out.println("<br>");
   		out.println("<a href=\"user_management.jsp\">�����û�����ҳ��</a>");
   		out.println("</body>");
   		out.println("</html>");
   		System.out.println("ok");
   		out.flush();
   		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); 
	}

}
