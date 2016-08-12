package br.com.dex.estacionamento.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="pessoa_juridica")
@DiscriminatorValue(value="J")
public class PessoaJuridica extends Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2584524036046018444L;
	private long cnpj;
	private long ie;
	private long im;
	
	@Column(name="nome_fantasia")
	private String nomeFantasia;
	
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public long getIe() {
		return ie;
	}
	public void setIe(long ie) {
		this.ie = ie;
	}
	public long getIm() {
		return im;
	}
	public void setIm(long im) {
		this.im = im;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
}
