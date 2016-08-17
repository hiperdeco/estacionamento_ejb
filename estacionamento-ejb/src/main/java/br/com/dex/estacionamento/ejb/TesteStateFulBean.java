package br.com.dex.estacionamento.ejb;

import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.dex.estacionamento.constants.DAOConstants;
import br.com.dex.estacionamento.vo.Marca;

/**
 * Session Bean implementation class TesteStateFulBean
 */
@Stateful
@Remote(TesteStateFulBeanRemote.class)
public class TesteStateFulBean implements TesteStateFulBeanRemote, TesteStateFulBeanLocal {

	@PersistenceContext(unitName=DAOConstants.PST_UNIT,type=PersistenceContextType.EXTENDED)
	EntityManager em;
	
	private int numero = 0;
    /**
     * Default constructor. 
     */
    public TesteStateFulBean() {
        // TODO Auto-generated constructor stub
    }

    @Interceptors(InterceptorTeste.class)
	public void teste() {
		System.out.println("Teste realizado! Numero:" + numero);
		em.find(Marca.class, 2);
		numero++;
	}

	public void teste1() {
		// TODO Auto-generated method stub
		
	}
	
	@PrePassivate
	public void ativo(){
		System.out.println("ativou  pre-passivate");
	}
	
	@PostActivate
	public void postAtivo(){
		System.out.println("ativou pos-activate");
	}
	
	@BeforeCompletion
	public void beforeCompletion(){
		System.out.println("ativou o beforeCompletion");
	}
	
	@AfterCompletion
	public void afterCompletion(boolean commited){
		System.out.println("ativou o afterCompletion" + commited);
	}

}
