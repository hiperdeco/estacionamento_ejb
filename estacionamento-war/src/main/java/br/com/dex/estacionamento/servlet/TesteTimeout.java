package br.com.dex.estacionamento.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dex.estacionamento.ejb.TimeOutBeanLocal;

/**
 * Servlet implementation class TesteEJB
 */
@WebServlet("/TesteTimeout")
public class TesteTimeout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private TimeOutBeanLocal tm;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteTimeout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InitialContext ctx = null;
		try{
			ctx = new InitialContext();
			tm = (TimeOutBeanLocal) InitialContext.doLookup("java:app/estacionamento-ejb/TimeOutBean!br.com.dex.estacionamento.ejb.TimeOutBeanLocal");
			tm.inicia();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
