package zth.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zth.dao.JPA_db;
import zth.entity.*;

/**
 * Servlet implementation class student_getsample_servlet
 */
@WebServlet("/student_getsample_servlet")
public class student_getsample_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_getsample_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB 
    private zth.biz.nointerface_sessonbean_biz getsource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stu_number=request.getParameter("stu_number");
		System.out.println(stu_number);
		if(getsource.exist_user(stu_number)==false){
			response.sendRedirect("error_3.html");
		}
		else{
			 UserInfo user=getsource.get_user(stu_number);
		   	    List<Sample> result=user.getSamples();
			if(result.isEmpty()){
				response.setContentType("text/html;charset=UTF-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<!DOCTYPE html>");
		   		out.println("<html>");
		   		out.println("<head>");
		   		out.println("<meta charset=\"UTF-8\">");
		   		out.println("<title>������</title>");
		   		out.println("</head>");
		   		out.println("<h1>ѧ�ţ�"+stu_number+"δ���κκ����¼</h1>");
		   		out.println("<body style=\"text-align: center;\">");	   
		        
		   		out.println("</body>");
		   		out.println("</html>");
		   		System.out.println("ok");
		   		out.flush();
		   		out.close();
	   	    }
	   	    else{
		response.setContentType("text/html;charset=UTF-8");
   		PrintWriter out=response.getWriter();
   		out.println("<!DOCTYPE html>");
   		out.println("<html>");
   		out.println("<head>");
   		out.println("<meta charset=\"UTF-8\">");
   		out.println("<title>������</title>");
   		out.println("</head>");
   		out.println("<body style=\"text-align: center;\">");
   		out.println("<h1 style=\"color: blue;\">��������</h1>");
     for(int i = 0;i < result.size(); i++){
    	 out.println("<h2 style=\"color: green;\">��������: " +result.get(i).getState()+ "</h2>");
    	    out.println("<p>ѧ��: " +user.getStuNumber()+ "</p>");
    	    out.println("<p>����: " +user.getName()+ "</p>");
		    out.println("<p>�����Թܱ��: " +result.get(i).getTestNo()+ "</p>");
		    out.println("<p>����ʱ��: " +result.get(i).getSampleTime()+ "</p>");
		    out.println("<p>����ύʱ��: " +result.get(i).getUploadTime()+ "</p>");
		    out.println("<br><br>");
		    //out.println("<p>���: " +result.get(i).getRole()+ "</p><br>");
		    }
        out.println("<a href=\"stu_test_result.jsp\">���ز�ѯ����</a>");
   		out.println("<br>");
   		out.println("</body>");
   		out.println("</html>");
   		System.out.println("ok");
   		out.flush();
   		out.close();
		}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
