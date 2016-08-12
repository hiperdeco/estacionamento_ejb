package br.com.dex.estacionamento.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;



@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name="idbase", sequenceName="seq_base",allocationSize=1)
public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5430938124424832239L;

	@Id
	@GeneratedValue(generator="idbase",strategy=GenerationType.SEQUENCE)
	protected int id;
	
	protected String descricao;
	
	
	public Base(){
		
	}
	
	public Base(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id ;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao(){
		return this.descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Base other = (Base) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
