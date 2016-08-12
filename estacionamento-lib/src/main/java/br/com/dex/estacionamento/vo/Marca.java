package br.com.dex.estacionamento.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
	@NamedQuery(name="Marca.findByDesc",
				query="select m from Marca m where upper(m.descricao) like :desc")
	,//virgula para separar o array
	@NamedQuery(name="Marca.findById",
				query="select m from Marca m where m.id = :id")
})
@Cacheable
public class Marca extends Base implements Serializable{

 /**
	 * 
	 */
	private static final long serialVersionUID = 6944253336222126339L;

public Marca(){
	super();
 }
	
 public Marca(int id, String descricao) {
		super(id, descricao);
 }
 
 
 @Override
 public String toString(){
	 return this.descricao;
 }
 
 @OneToMany( mappedBy="marca")
 private List<Modelo> modelos;
  
 public List<Modelo> getModelos(){
	 return this.modelos;
 }
 

}
