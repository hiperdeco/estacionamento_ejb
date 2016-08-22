package br.com.dex.estacionamento.control;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dex.estacionamento.ejb.DAORemote;
import br.com.dex.estacionamento.ejb.DefaultCRUDBeanRemote;

public class Controle<T ,I extends Serializable> {
	
	private static InitialContext ctx;
	DAORemote<T,I> dao = null;
	
	private Class<T> classe;
	public Controle(Class<T> classe){
		this.classe = classe;
		System.out.println("instanciou denovo");
	}
	
	public T findBydId(I chave){
		return getCRUD().findById( chave);
	}
	
	public List<T> findAll(){
		return getCRUD().findAll();
	}
	
	public List<T> findByDesc(String description){
		return getCRUD().findByDesc(description);
	}
	
	public void insert(T objeto){
		getCRUD().insert(objeto);
	}
	
	public void update(T objeto){
		getCRUD().update(objeto);
	}
	
	public void delete(T objeto){
		getCRUD().delete(objeto);
	}
	
	public List<T> findByMap(Map<String, Object> values){
		for(String chave: values.keySet()){
			Object item = values.get(chave);
			if (item instanceof String){
				item = ((String) item).replace('*', '%');
				values.put(chave, item);
			}
		}
		return getCRUD().findByMap(values);
	}
	
	private DAORemote<T, I> getCRUD(){
		if (dao == null){
			try {
				ctx = new InitialContext();
				dao =  (DAORemote<T, I>) ctx.doLookup("java:estacionamento/estacionamento-ejb/DAOImpl!br.com.dex.estacionamento.ejb.DAORemote");
				dao.setClass(classe);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return dao;
	}
		
}
