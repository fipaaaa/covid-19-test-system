package zth.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zth.dao.JPA_db;
import zth.entity.UserInfo;

/**
 * Servlet implementation class login_servlet
 */
@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String guest_username=request.getParameter("guest_username");
		String guest_password=request.getParameter("guest_password");
		System.out.println("username:"+guest_username);
		System.out.println("password:"+guest_password);
        JPA_db db=new JPA_db();
        if(db.exist_username(guest_username)){
        	System.out.println("用户名"+guest_username+"存在");
			UserInfo user=db.find_username(guest_username);
			String level=user.getLevel();
			if(level.equals("student")){
				//request.getRequestDispatcher("student_getsample_servlet").forward(request, response);
			    response.sendRedirect("error_4.html");
			}
			if(level.equals("doctor")){
				response.sendRedirect("restws_servlet?confirm=no&stunumber=0&&testno=no");
				}
			if(level.equals("uploader")){
				response.sendRedirect("acid_upload.jsp");
				}
			if(level.equals("admin")){
				response.sendRedirect("user_management.jsp");
				}
        }
        else{
        	System.out.println(guest_username+"不存在");
			response.sendRedirect("error_2.html");
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
