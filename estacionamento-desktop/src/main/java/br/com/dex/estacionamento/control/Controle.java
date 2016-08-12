package br.com.dex.estacionamento.control;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dex.estacionamento.ejb.DefaultCRUDBeanRemote;

public class Controle<T ,I extends Serializable> {
	
	private static InitialContext ctx;
	
	private Class<T> classe;
	public Controle(Class<T> classe){
		this.classe = classe;
	}
	
	public T findBydId(I chave){
		return getCRUD().findById(classe, chave);
	}
	
	public List<T> findAll(){
		return getCRUD().findAll(classe);
	}
	
	public List<T> findByDesc(String description){
		return getCRUD().findByDesc(description,classe);
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
		return getCRUD().findByMap(values,this.classe);
	}
	
	private DefaultCRUDBeanRemote<T, I> getCRUD(){
		try {
			ctx = new InitialContext();
			return (DefaultCRUDBeanRemote<T, I>) ctx.doLookup("java:estacionamento/estacionamento-ejb/DefaultCRUDBean!br.com.dex.estacionamento.ejb.DefaultCRUDBeanRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
}
