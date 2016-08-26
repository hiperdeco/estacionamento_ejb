package br.com.dex.estacionamento.iu.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import br.com.dex.estacionamento.control.Controle;
import br.com.dex.estacionamento.vo.Marca;

public class TabelaMarcaModel extends AbstractTableModel 
implements ActionListener, TableModelListener {

	List<String> colunas = new ArrayList<String>();
	List<Marca> linhas = new ArrayList<Marca>();
	Controle<Marca, Integer> controle = null;
	
	public TabelaMarcaModel(){
		colunas.add("ID");
		colunas.add("DESCRICAO");
		
		
	  addTableModelListener(this);
		
	}
	
	
	public int getRowCount() {
		
		return linhas.size();
	}

	
	public int getColumnCount() {
		return colunas.size();
	}

	
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Marca item = linhas.get(rowIndex);
		switch(columnIndex){
		case 0:
			return item.getId();
		case 1:
			return item.getDescricao();
		}
		
		return null;
	}
	
	public String getColumnName(int column){
		return colunas.get(column);
	}
	
	public Object getRow(int index){
		return linhas.get(index);
	}
	
	public void insert(Marca item){
		System.out.println("Enviado: " + item);
		getControle().insert(item);
		System.out.println("Recebido: " + item);
		linhas.add(item);
		fireTableDataChanged();
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void tableChanged(TableModelEvent e) {
		System.out.println("mudou a grid");
		
	}
	
	public void getLines(Marca filter) throws Exception{
		Controle<Marca, Integer> controle2 = 
				getControle();
		
		if (filter != null && ! filter.getDescricao().trim().isEmpty()){
			this.linhas = controle2.findByDesc(filter.getDescricao());
		}else{
			this.linhas = controle2.findAll();
		}
		
		fireTableDataChanged();
	}
	
	public void alterar(Marca item){
		Controle<Marca, Integer> controle2 = 
				getControle();
		controle2.update(item);
		fireTableDataChanged();
	}
	
	private Controle<Marca,Integer> getControle(){
		if (controle == null){
			controle = new Controle<Marca, Integer>(Marca.class);
		}
		return controle;
	}

}
