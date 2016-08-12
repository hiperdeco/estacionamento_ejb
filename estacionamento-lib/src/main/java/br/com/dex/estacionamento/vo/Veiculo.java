package br.com.dex.estacionamento.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqveiculo",sequenceName="seq_veiculo",allocationSize=1)
public class Veiculo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2052193896055612411L;
	@Id
	@GeneratedValue(generator="seqveiculo",strategy=GenerationType.SEQUENCE)
	private long id;
	private String placa;
	
	@ManyToOne
	private Cliente cliente;
	
	private String cor;
	@ManyToOne
	private Modelo modelo;
	@ManyToOne
	private Tipo tipo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
