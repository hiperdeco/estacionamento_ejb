package br.com.dex.estacionamento.vo;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="pessoa_fisica")
@DiscriminatorValue(value="F")

public class PessoaFisica extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3911509636110776418L;
	private long rg;
	private long cpf;
	
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	
}
