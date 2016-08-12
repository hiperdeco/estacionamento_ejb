package br.com.dex.estacionamento.iu.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import br.com.dex.estacionamento.control.Controle;
import br.com.dex.estacionamento.vo.Modelo;


public class TabelaModeloModel extends AbstractTableModel
implements TableModelListener{

	private List<String> colunas = new ArrayList<String>();
	private List<Modelo> linhas = new ArrayList<Modelo>();
	
	private Modelo ModeloSelecionada = null;
	
	
	public TabelaModeloModel(){
		this.colunas.add("ID");
		this.colunas.add("DESCRICAO");
		this.colunas.add("COMBUSTIVEL");
		this.colunas.add("ANO_FAB");
		this.colunas.add("ANO_MOD");
		this.colunas.add("MOTOR");
		this.colunas.add("MARCA"); 
		 
	/*	 Modelo m = new Modelo();
		 //navegar entre os atributos
		 Class<?> p = m.getClass().getSuperclass();
		 Class<?> c = m.getClass();
		 List<Field> fields = new ArrayList<Field>();
		 fields.addAll(Arrays.asList(p.getDeclaredFields()));
		 fields.addAll(Arrays.asList(c.getDeclaredFields()));
		 
		 this.colunas.clear();
		 for (Field f: fields){
			 this.colunas.add(f.getAnnotation(Resource.class).description());
		 }
		*/
		this.addTableModelListener(this);
		
		
	}
	
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.linhas.size();
	}

	
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.colunas.get(column);
	}

	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.colunas.size();
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Modelo m = this.linhas.get(rowIndex);
		
		Object value = null;
		
		switch(columnIndex){
		case 0:
			return m.getId();
		case 1:
			return m.getDescricao();
		case 2:
			return m.getCombustivel();
		case 3:
			return m.getAnoFabricacao();
		case 4:
			return m.getAnoModelo();
		case 5:
			return m.getMotor();
		case 6:
			return m.getMarca();
		}
		
		
		
		return value;
	}
	
	public Modelo getRow(int rowIndex){
		
		return this.linhas.get(rowIndex);
	}
	
	public void filtrar(Modelo modelo) throws Exception{
		Controle<Modelo, Integer> control = 
				new Controle<Modelo, Integer>(Modelo.class);
		if (modelo != null && ! modelo.getDescricao().trim().isEmpty()){
			linhas = control.findByDesc(modelo.getDescricao());
		}else{
			linhas = control.findAll();
		}
		
		fireTableDataChanged();
	}
	
	public void filtrar(Map<String,Object> values){
		Controle<Modelo, Integer> control = 
				new Controle<Modelo, Integer>(Modelo.class);
		if (values != null){
			linhas = control.findByMap(values);
			fireTableDataChanged();
		}
	}

	
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void add(Modelo Modelo){
		
	}

	public void atualiza(Modelo Modelo) {
		
		
	}

	public Modelo getModeloSelecionada() {
		return ModeloSelecionada;
	}

	public void setModeloSelecionada(Modelo ModeloSelecionada) {
		this.ModeloSelecionada = ModeloSelecionada;
	}
	
	public void excluir(Modelo Modelo){
		
	}

}
