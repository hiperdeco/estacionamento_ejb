package br.com.dex.estacionamento.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.dex.estacionamento.constants.DAOConstants;


public class DAOManager {
	
	private static EntityManagerFactory emf
	=			Persistence.createEntityManagerFactory(DAOConstants.PST_UNIT); 
	
	private static DAOManager _instance;
	
	
	private DAOManager(){
		
	}
	
	public static DAOManager getInstance(){
		
		if (_instance == null){
			_instance = new DAOManager();
		}
		return _instance;
	}
	
	public EntityManagerFactory getFactory(){
		
		return emf;
	}

}
