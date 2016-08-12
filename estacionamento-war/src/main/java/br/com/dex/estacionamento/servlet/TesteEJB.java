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

import br.com.dex.estacionamento.ejb.DefaultCRUDBeanLocal;
import br.com.dex.estacionamento.vo.Marca;

/**
 * Servlet implementation class TesteEJB
 */
@WebServlet("/TesteEJB")
public class TesteEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DefaultCRUDBeanLocal<Marca,Long> local;
	
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
		try {
			local = (DefaultCRUDBeanLocal<Marca,Long>) InitialContext.doLookup("java:app/estacionamento-ejb/DefaultCRUDBean!br.com.dex.estacionamento.ejb.bean.DefaultCRUDBeanLocal");
			local.findAll(Marca.class);
			
			if (request.getParameter("incluir")!= null){
				Marca m = new Marca();
				m.setDescricao(request.getParameter("incluir"));
				local.incluir(m);
				
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
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
