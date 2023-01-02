package zth.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.hc.client5.http.fluent.Request;

/**
 * Servlet implementation class restws_servlet_confirm
 */
@WebServlet("/restws_servlet_confirm")
public class restws_servlet_confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public restws_servlet_confirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stu_number=request.getParameter("test_stu_number");
		String URI = "http://localhost:8080/RESTWS_Hello/helloworld/sayHi?stunumber="+stu_number;
		String result = Request.get(URI)
					  .execute().returnContent().toString();
        System.out.println(result);
        response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>welcome</title>");
		out.println("</head>");
		out.println("<body style=\"text-align: center;\">");
		out.println("<h1>被测试者身份确认</h1>");
		out.println("<p>学号:"+stu_number+"</p>");
		if(result.equals("none")){
			out.println("<p>该学生不存在</p>");
			out.println("<a href=\"restws_servlet?confirm=no&stunumber=0&testno=no\">返回</a>");
		}
		else{
		out.println("<p>姓名:"+result+"</p>");
		out.println("<br>");
		out.println("<form action=\"/javaee_zth/restws_addtester_servlet\" method=\"post\">");
		out.println("<input type=\"hidden\" name=\"test_stu_number\" value=\""+stu_number+"\" />");
		out.println("<input  value=\"确认\" type=\"submit\"/>");
		out.println("</form>");
		out.println("<br><br><a href=\"restws_servlet?confirm=no&stunumber=0&testno=no\">返回</a>");
		}
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
