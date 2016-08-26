package br.com.dex.estacionamento.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dex.estacionamento.dao.DAOManager;
import br.com.dex.estacionamento.ejb.DefaultCRUDBeanLocal;
import br.com.dex.estacionamento.ejb.TesteStateFulBeanLocal;
import br.com.dex.estacionamento.ejb.TesteStateFulBeanRemote;
import br.com.dex.estacionamento.vo.Marca;

/**
 * Servlet implementation class TesteEJB
 */
@WebServlet("/TesteEJB")
public class TesteEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DefaultCRUDBeanLocal<Marca,Long> local;
	
	@EJB
	private DefaultCRUDBeanLocal<Marca,Long> local1;
	
	private TesteStateFulBeanRemote local2;
	
	private TesteStateFulBeanRemote local3;
	
	@EJB
	private TesteStateFulBeanLocal local4;
	
	@EJB
	private DAOManager mgr;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteEJB() {
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
			
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			local = (DefaultCRUDBeanLocal<Marca,Long>) InitialContext.doLookup("java:app/estacionamento-ejb/DefaultCRUDBean!br.com.dex.estacionamento.ejb.DefaultCRUDBeanLocal");
			local.findAll(Marca.class);
			local1 = (DefaultCRUDBeanLocal<Marca,Long>) InitialContext.doLookup("java:app/estacionamento-ejb/DefaultCRUDBean!br.com.dex.estacionamento.ejb.DefaultCRUDBeanLocal");
			local1.findAll(Marca.class);
			System.out.println("verificar valor do stateless");
			local.findAll(Marca.class);
			local1.findAll(Marca.class);
			if (request.getParameter("incluir")!= null){
				Marca m = new Marca();
				m.setDescricao(request.getParameter("incluir"));
				local.incluir(m);
				
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			System.out.println("stateful");
			local2 = (TesteStateFulBeanRemote) ctx.lookup("ejb:estacionamento/estacionamento-ejb/TesteStateFulBean!br.com.dex.estacionamento.ejb.TesteStateFulBeanRemote?stateful");
			local2.teste();
			local3 = (TesteStateFulBeanRemote) ctx.lookup("ejb:estacionamento/estacionamento-ejb/TesteStateFulBean!br.com.dex.estacionamento.ejb.TesteStateFulBeanRemote?stateful");
			local3.teste();
			
			System.out.println("verificar valor do stateful");
			local3.teste();
			local2.teste();
			
			System.out.println("Bean local");
			local4.teste();
			local4.teste();
				
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			System.out.println("UserTransaction");
			mgr.find(Marca.class, 1);
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
