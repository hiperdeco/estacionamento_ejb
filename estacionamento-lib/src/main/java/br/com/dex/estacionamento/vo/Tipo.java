package br.com.dex.estacionamento.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(sequenceName="seq_tipo",name="seqtipo",allocationSize=1)
public class Tipo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5686363381943876564L;

	@Id
	@GeneratedValue(generator="seqtipo",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column
	private String descricao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
