package br.com.dex.estacionamento.ws;

import java.io.Serializable;
import javax.ejb.Remote;

import br.com.dex.estacionamento.vo.Marca;

@Remote
public interface MarcaServiceRemote<T ,I extends Serializable> {
	
	public Marca getMarca(int id);
		
	
}
