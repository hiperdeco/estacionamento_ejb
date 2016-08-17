package br.com.dex.estacionamento.dao;

import javax.annotation.Resource;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import br.com.dex.estacionamento.constants.DAOConstants;


@TransactionManagement(TransactionManagementType.BEAN)
public class DAOManager {
	
	@Resource
	UserTransaction userTx;
	
	@PersistenceContext
	EntityManagerFactory emf;
	
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
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

	public void find(Class<?> objeto, Object value){
		EntityManager em = getEntityManager();
		try {
			userTx.begin();
			em.find(objeto, value);
			userTx.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
