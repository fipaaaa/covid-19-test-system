package zth.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zth.dao.JPA_db;

/**
 * Servlet implementation class manage_register_servlet
 */
@WebServlet("/manage_register_servlet")
public class manage_register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manage_register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String guest_username=request.getParameter("worker_username");
		String guest_password=request.getParameter("worker_password");
		String guest_name=request.getParameter("worker_name");
		String guest_stu_number=request.getParameter("worker_number");
		String guest_level=request.getParameter("worker_level");
		System.out.println("username:"+guest_username);
		System.out.println("password:"+guest_password);
		System.out.println("name:"+guest_name);
		System.out.println("number:"+guest_stu_number);
		System.out.println("level:"+guest_level);
		JPA_db db=new JPA_db();
		if(db.exist_stu_number(guest_stu_number)==false&&db.exist_username(guest_username)==false){
			System.out.println("已插入"+guest_stu_number);
			db.insert_user(guest_username,guest_password,guest_name,guest_stu_number,guest_level);
			response.sendRedirect("manage_register_succ.html");
		}
		else{
			System.out.println(guest_stu_number+"已存在");
			response.sendRedirect("manage_error_1.html");
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
