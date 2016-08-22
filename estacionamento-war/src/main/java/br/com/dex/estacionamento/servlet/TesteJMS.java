package br.com.dex.estacionamento.servlet;

import java.io.IOException;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TesteJMS
 */
@WebServlet("/TesteJMS")
public class TesteJMS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TesteJMS() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		javax.jms.ConnectionFactory factory = null;
		javax.jms.Connection conn = null;
		javax.jms.Session session = null;
		javax.jms.MessageProducer publisher = null;

		try {
			InitialContext ctx = new InitialContext();
			factory = (ConnectionFactory) ctx.lookup("java:/ConnectionFactory");
			conn = factory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			javax.jms.Queue queue = (javax.jms.Queue) ctx
					.lookup("jms/queue/A");
			publisher = session.createProducer(queue);
			javax.jms.TextMessage msg = session
					.createTextMessage("mensagem do servlet");
			publisher.send(msg);

		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				publisher.close();
				session.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
