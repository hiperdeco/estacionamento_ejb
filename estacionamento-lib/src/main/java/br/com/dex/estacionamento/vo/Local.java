package br.com.dex.estacionamento.vo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Local extends Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8775476589742433560L;

	public Local() {
		super();
	}

	public Local(int id, String descricao) {
		super(id, descricao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.id + " - " + this.descricao;
	}

}
