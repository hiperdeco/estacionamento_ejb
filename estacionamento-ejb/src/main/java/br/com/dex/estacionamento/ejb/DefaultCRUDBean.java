package br.com.dex.estacionamento.ejb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
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
    /**
     * Default constructor. 
     */
    public DefaultCRUDBean() {
    	System.out.println("instanciou EJB");
    }
    
    
	public List<T> findAll(Class<T> classe ) {
		this.classe = classe;
		System.out.println("procurando tudo da classe" + classe.getSimpleName());
		dao.setClass(classe);
		return dao.findAll();
	}
   
	public void incluir(T objeto) {
		this.classe = (Class<T>) objeto.getClass();
		dao.setClass(objeto.getClass());
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
		dao.setClass(objeto.getClass());
		dao.insert(objeto);
	}


	public void update(T objeto) {
		dao.setClass(objeto.getClass());
		dao.update(objeto);
		
	}


	public void delete(T objeto) {
		dao.setClass(objeto.getClass());
		dao.delete(objeto);
		
	}

	public List<T> findByMap(Map<String, Object> values, Class<T> classe) {
		dao.setClass(classe);
		return dao.findByMap(values);
	}
    
    

}
