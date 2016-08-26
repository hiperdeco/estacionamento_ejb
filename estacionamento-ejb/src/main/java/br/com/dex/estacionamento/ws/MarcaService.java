package br.com.dex.estacionamento.ws;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import br.com.dex.estacionamento.ejb.DefaultCRUDBeanLocal;
import br.com.dex.estacionamento.vo.Marca;

@Stateless
@Remote(MarcaServiceRemote.class)

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MarcaService {
	
	@EJB
	DefaultCRUDBeanLocal<Marca, Integer> crud;
	
	public Marca getMarca(int id){
		
		return crud.findById(Marca.class, id);
		
	}
	
	

}
