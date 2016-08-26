package br.com.dex.estacionamento.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.persistence.EntityManager;

@Local
public interface DAO<T ,I extends Serializable> {
	
	public List<T> findAll();
	public T findById( I chave);
	public List<T> findByDesc(String description);
	public void insert(T objeto);
	public void update(T objeto);
	public void delete(T objeto);
	public List<T> findByMap(Map<String,Object> values);
	public void setClass(Class<T> classe);
		
	
}
