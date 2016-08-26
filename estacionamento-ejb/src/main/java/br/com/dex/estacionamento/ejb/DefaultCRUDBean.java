package br.com.dex.estacionamento.ejb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Init;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateless;

import br.com.dex.estacionamento.dao.DAO;

/**
 * Session Bean implementation class DefaultCRUDBean
 */
@Stateless(name = "DefaultCRUDBean")
@Local(DefaultCRUDBeanLocal.class)
@Remote(DefaultCRUDBeanRemote.class)
public class DefaultCRUDBean<T ,I extends Serializable> implements DefaultCRUDBeanRemote<T,I>, DefaultCRUDBeanLocal<T,I> {

	private Class<T> classe;
	
	@EJB
	DAO<T, I> dao;
	
	private int cont= 0;
    /**
     * Default constructor. 
     */
    public DefaultCRUDBean() {
    	System.out.println("instanciou EJB");
    }
    
    
	public List<T> findAll(Class<T> classe ) {
		this.classe = classe;
		System.out.println("procurando tudo da classe" + classe.getSimpleName());
		System.out.println("cont: " + cont);
		cont++;
		dao.setClass(classe);
		return dao.findAll();
	}
   
	public void incluir(T objeto) {
		this.classe = (Class<T>) classe;
		dao.setClass(classe);
		dao.insert(objeto);
		
	}


	public T findById(Class<T> classe, I chave) {
		dao.setClass(classe);
		return dao.findById(chave) ;
	}


	public List<T> findByDesc(String description, Class<T> classe) {
		dao.setClass(classe);
		return dao.findByDesc(description);
	}


	public void insert(T objeto) {
		dao.setClass(classe);
		dao.insert(objeto);
	}


	public void update(T objeto) {
		dao.setClass(classe);
		dao.update(objeto);
		
	}


	public void delete(T objeto) {
		dao.setClass(classe);
		dao.delete(objeto);
		
	}

	public List<T> findByMap(Map<String, Object> values, Class<T> classe) {
		dao.setClass(classe);
		return dao.findByMap(values);
	}
	
	@Init
	public void iniciou(){
		System.out.println("Bean iniciado");
	}
	
	@PostConstruct
	public void contruiu(){
		System.out.println("Bean construido");
	}
	
	@PreDestroy
    public void destruiu(){
		System.out.println("Bean destruido");
	}
	
	@Remove
	public void removido(){
	  System.out.println("bean removido do pool");
    }
    

}
