package zth.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
 * Servlet implementation class restws_servlet
 */
@WebServlet("/restws_servlet")
public class restws_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public restws_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @EJB 
    private zth.biz.statefulbean_biz getline;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String add=request.getParameter("confirm");
		String stu_number=request.getParameter("stunumber");
		String test_no=request.getParameter("testno");
		if(add.equals("yes")){
			getline.addtester(stu_number);
			System.out.println(add);
			System.out.println("���ӵ�ѧ��Ϊ"+stu_number);
		}
		if(add.equals("yes2")){
			getline.removetester(stu_number);
			System.out.println(add);
			System.out.println("ɾ����ѧ��Ϊ"+stu_number);
		}
		if(add.equals("yes3")){
			getline.uploadtester(test_no);
			System.out.println(add);
			System.out.println("�ύ���Թ�Ϊ"+test_no);
		}
		response.setContentType("text/html;charset=UTF-8");
   		PrintWriter out=response.getWriter();
   		out.println("<!DOCTYPE html>");
   		out.println("<html>");
   		out.println("<head>");
   	    out.println("<title>�����������ɼ�ҳ��</title>");
   	    out.println("<link rel=\"stylesheet\" type=\"text/css\" >");
   	    out.println("<script   language=Javascript> function   go(url)   {form_test.action=url;form_test.submit();}</script>");
   	    out.println("</head>");
   	    out.println("<body style=\"text-align: center;\">");
   	    out.println("<form  method=\"post\" name=\"form_test\">");
   	    out.println("<h1 style=\"text-align: center;color: blue;\">�����������ɼ�</h1><br>");
   	    out.println("<p>�Թܱ��:<input id=\"guest_id\" type=\"text\" name=\"test_test_no\" required=\"required\"></p>");

   	    out.println("<p>ѧ��:  &nbsp;<input id=\"guest_stu_number\" type=\"text\" name=\"test_stu_number\" required=\"required\"><label id=\"password_trip\"></label></p>");
   	         
   	    out.println("<div margin-top: 30px;style=\"text-align: center;\">");
   	    out.println("<input value=\"��ӱ�����\" type=\"button\" onClick= \"javascript:go('/javaee_zth/restws_servlet_confirm')\"> <br><br>");
   	    out.println("<input value=\"ɾ��������\" type=\"button\" onClick= \"javascript:go('/javaee_zth/restws_servlet_confirm_2')\"> <br>");
   	    out.println("</div>");
   	          
   	    out.println("</form>");
   	  out.println("<h1 style=\"text-align: center;color: blue;\">�û��б�����</h1>");
   	    int i=1;
	   for (Iterator it = getline.gettester().iterator(); it.hasNext();) {
		   UserInfo user=(UserInfo)it.next();
		  
		out.println("<p>���:"+i+"ѧ��:" +user.getStuNumber()+ " ����:" +user.getName()+ "</p>");
		i++;
	   }
	   out.println("<input value=\"�ύ���б�����\" type=\"button\" onClick= \"javascript:go('/javaee_zth/restws_servlet_upload')\"> <br><br>");
	   out.println("<a href=\"login.jsp\">���ص�½����</a>");
   	    out.println("</body>");
   	    out.println("</html>");
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
