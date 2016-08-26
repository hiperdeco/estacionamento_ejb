package br.com.dex.estacionamento.ejb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

@Remote
public interface DAORemote<T ,I extends Serializable> {
	
	public List<T> findAll();
	public T findById( I chave);
	public List<T> findByDesc(String description);
	public void insert(T objeto);
	public void update(T objeto);
	public void delete(T objeto);
	public List<T> findByMap(Map<String,Object> values);
<<<<<<< HEAD
	public void setClass(Class classe);
=======
	public void setClass(Class<T> classe);
>>>>>>> d08b89f354ddc34222bf6afe982a089b10bcbcc7
		
	
}
