package br.com.dex.estacionamento.iu.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import br.com.dex.estacionamento.vo.Combustivel;

public class ComboCombustivelModel extends AbstractListModel
implements ComboBoxModel {

	private List<Combustivel> lista = new ArrayList();
	private Combustivel selecionada = null;
		
	public ComboCombustivelModel() {
		lista.add(null);
		lista.addAll(Arrays.asList(Combustivel.values()));
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	public Object getElementAt(int index) {
		return lista.get(index);
	}


	public void setSelectedItem(Object anItem) {
		this.selecionada = (Combustivel) anItem;
		fireContentsChanged(this, 0, getSize());
		
	}

	public Object getSelectedItem() {
		return this.selecionada;
	}

}
