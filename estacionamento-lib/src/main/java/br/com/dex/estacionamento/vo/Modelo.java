package br.com.dex.estacionamento.vo;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name="seqModelo",sequenceName="seq_modelo",allocationSize=1)
@NamedQueries({
	@NamedQuery(name="Modelo.findByDesc",
	query="select m from Modelo m join fetch m.marca where upper(m.descricao) like :desc"),
	@NamedQuery(name="Modelo.findAll",
	query="select o from Modelo o join fetch o.marca ")
})
public class Modelo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8046271565274751627L;

	@Id
	@GeneratedValue(generator="seqModelo",strategy=GenerationType.SEQUENCE)
	@Resource(name="ID", description="Código")
	private long id;
	
	@Resource(name="DESCRICAO", description="Descrição")
	private String descricao;
	
	@Column(name="ano_modelo")
	@Resource(name="ANO_MODELO", description="Ano Modelo")
	private int anoModelo;
	
	@Column(name="ano_fabricacao")
	@Resource(name="ANO_FABRICACAO", description="Ano Fab.")
	private int anoFabricacao;
	
	@Resource(name="COMBUSTIVEL", description="Combustível")
	private Combustivel combustivel;
	
	@Resource(name="MOTOR", description="Motor")
	private float motor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@Resource(name="MARCA", description="Marca")
	private Marca marca;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public int getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Combustivel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getMotor() {
		return motor;
	}
	public void setMotor(float motor) {
		this.motor = motor;
	}
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	

}
