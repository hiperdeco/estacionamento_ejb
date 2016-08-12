package br.com.dex.estacionamento.iu.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import br.com.dex.estacionamento.control.Controle;
import br.com.dex.estacionamento.vo.Marca;


public class ComboMarcaModel extends AbstractListModel 
implements ComboBoxModel,ListDataListener {

	public void contentsChanged(ListDataEvent e) {
		// TODO Auto-generated method stub

	}


	private List<Marca> lista = new ArrayList<Marca>();
	private Marca selecionada = null;
	
	public ComboMarcaModel() {
		this.addListDataListener(this);
		
		try {
			Controle<Marca, Integer> control = 
									new Controle<Marca, Integer>(Marca.class);
			lista = control.findAll();
			Collections.sort(lista, new Comparator<Marca>() {
		        
		        public int compare(Marca m1, Marca m2)
		        {
		            return  m1.getDescricao().compareTo(m2.getDescricao());
		        }
		    });
			lista.add(0,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	
	
	
	public int getSize() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	
	public Object getElementAt(int index) {
		
		return lista.get(index);
	}


	
	public void setSelectedItem(Object anItem) {
		this.selecionada = (Marca) anItem;
		fireContentsChanged(this, 0, getSize());
		
	}


	
	public Object getSelectedItem() {
		return this.selecionada;
	}

	
	
	public void intervalAdded(ListDataEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	public void intervalRemoved(ListDataEvent e) {
		// TODO Auto-generated method stub
		
	}

}
