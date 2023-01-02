package zth.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.Date;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Servlet implementation class upload_servlet
 */
@WebServlet("/upload_servlet")
public class upload_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final Logger log = Logger.getLogger(upload_servlet.class.getName());

	private static final String DEFAULT_MESSAGE = "Welcome to JMS queue!";
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_DESTINATION = "jms/topic/test";
	private static final String DEFAULT_MESSAGE_COUNT = "10";

	private static final String DEFAULT_USERNAME = "zthtopic";
	private static final String DEFAULT_PASSWORD = "123456";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "remote://localhost:4447";
	public static void send(String text) throws Exception {
		Context context=null;
		Connection connection=null;
		try {
			// 设置上下文的JNDI查找
			System.out.println("设置JNDI访问环境信息也就是设置应用服务器的上下文信息!");
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);// 该KEY的值为初始化Context的工厂类,JNDI驱动的类名
			env.put(Context.PROVIDER_URL,  PROVIDER_URL);// 该KEY的值为Context服务提供者的URL.命名服务提供者的URL
			env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
			env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD);//应用用户的登录名,密码.
			// 获取到InitialContext对象.
			context = new InitialContext(env);
			System.out.println ("获取连接工厂!");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
			System.out.println ("获取目的地!");
			Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);

			// 创建JMS连接、会话、生产者和消费者
			connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);
			connection.start();

			    TextMessage message = null;
				message = session.createTextMessage(text);
				producer.send(message);
				//System.out.println ("message:"+message);
				//System.out.println ("message:"+DEFAULT_MESSAGE);
			// 等待30秒退出
			CountDownLatch latch = new CountDownLatch(1);
			latch.await(60, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			//log.severe(e.getMessage());
			throw e;
		} finally {
			if (context != null) {
				context.close();
			}
			// 关闭连接负责会话,生产商和消费者
			if (connection != null) {
				connection.close();
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String test_no=request.getParameter("test_no");
		String test_state=request.getParameter("test_state");
		String text=test_no+"#"+test_state;
		try {
			send(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
