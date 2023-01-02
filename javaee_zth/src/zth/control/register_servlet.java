package zth.control;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zth.entity.*;
import zth.dao.JPA_db;
/**
 * Servlet implementation class register_servlet
 */
@WebServlet("/register_servlet")
public class register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String guest_username=request.getParameter("guest_username_new");
		String guest_password=request.getParameter("guest_password_new");
		String guest_name=request.getParameter("guest_name_new");
		String guest_stu_number=request.getParameter("guest_stu_number_new");
		String guest_level="student";
		System.out.println("username:"+guest_username);
		System.out.println("password:"+guest_password);
		System.out.println("name:"+guest_name);
		System.out.println("guest_stu_number:"+guest_stu_number);
		JPA_db db=new JPA_db();
		if(db.exist_stu_number(guest_stu_number)==false&&db.exist_username(guest_username)==false){
			System.out.println("已插入"+guest_stu_number);
			db.insert_user(guest_username,guest_password,guest_name,guest_stu_number,guest_level);
			response.sendRedirect("register_succ.html");
		}
		else{
			System.out.println(guest_stu_number+"已存在");
			response.sendRedirect("error_1.html");
		}
		//db.insert_user(guest_username,guest_password,guest_name,guest_stu_number,guest_level);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
