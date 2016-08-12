package br.com.dex.estacionamento.ejb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;


public interface DefaultCRUDBeanRemote<T ,I extends Serializable> {

	public List<T> findAll(Class<T> classe);
	public void incluir(T objeto);
	public T findById(Class<T> classe, I chave);
	public List<T> findByDesc(String description, Class<T> classe);
	public void insert(T objeto);
	public void update(T objeto);
	public void delete(T objeto);
	public List<T> findByMap(Map<String,Object> values,Class<T> classe);
}
