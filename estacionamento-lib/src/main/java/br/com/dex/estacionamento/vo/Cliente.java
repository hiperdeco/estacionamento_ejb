package br.com.dex.estacionamento.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name="seqcliente",sequenceName="seq_cliente",allocationSize=1)
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3315139001315310712L;

	@Id
	@GeneratedValue(generator="seqcliente",strategy=GenerationType.SEQUENCE)
	private long id;
	
	@OneToOne
	private Pessoa pessoa;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY)
	private List<Veiculo> veiculos;

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
