package br.com.dex.estacionamento.iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import br.com.dex.estacionamento.iu.model.ComboCombustivelModel;
import br.com.dex.estacionamento.iu.model.ComboMarcaModel;
import br.com.dex.estacionamento.iu.model.TabelaModeloModel;
import br.com.dex.estacionamento.vo.Combustivel;
import br.com.dex.estacionamento.vo.Marca;
import br.com.dex.estacionamento.vo.Modelo;

import javax.swing.JScrollBar;
import javax.swing.JTable;

import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;


public class ModeloWindow  {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtAnoFab;
	private JTextField txtAnoMod;
	private JTextField txtMotor;
	private JTable tblModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeloWindow frame = new ModeloWindow();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModeloWindow() {
		frame = new JFrame("Modelo"); 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 581, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(69, 14, 13, 15);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(90, 12, 335, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		txtId.setEnabled(false);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(13, 40, 69, 15);
		contentPane.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(90, 38, 335, 19);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(39, 69, 43, 15);
		contentPane.add(lblMarca);
		
		ComboMarcaModel m = new ComboMarcaModel();
		
		final JComboBox cboMarca = new JComboBox();
		cboMarca.setModel(m);
		
		cboMarca.setBounds(90, 64, 335, 24);
		contentPane.add(cboMarca);
		
		final JComboBox cboCombustivel = new JComboBox();
		final TabelaModeloModel modelModelo = new TabelaModeloModel();
		
		JButton btnNewButton = new JButton("Incluir");
		btnNewButton.setBounds(23, 204, 113, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnNewButton);
		
		cboCombustivel.setBounds(90, 100, 335, 24);
		cboCombustivel.setModel(new ComboCombustivelModel());
		contentPane.add(cboCombustivel);
		
		
		JLabel lblCombustivel = new JLabel("Combustível");
		lblCombustivel.setBounds(0, 104, 92, 15);
		contentPane.add(lblCombustivel);
		
		txtAnoFab = new JTextField();
		txtAnoFab.setColumns(10);
		txtAnoFab.setBounds(90, 136, 69, 19);
		contentPane.add(txtAnoFab);
		
		JLabel lblAnoFab = new JLabel("Ano Fab.");
		lblAnoFab.setBounds(13, 138, 69, 15);
		contentPane.add(lblAnoFab);
		
		txtAnoMod = new JTextField();
		txtAnoMod.setColumns(10);
		txtAnoMod.setBounds(261, 136, 69, 19);
		contentPane.add(txtAnoMod);
		
		JLabel lblAnoMod = new JLabel("Ano Mod");
		lblAnoMod.setBounds(184, 138, 69, 15);
		contentPane.add(lblAnoMod);
		
		txtMotor = new JTextField();
		txtMotor.setColumns(10);
		txtMotor.setBounds(90, 167, 69, 19);
		contentPane.add(txtMotor);
		
		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setBounds(13, 169, 69, 15);
		contentPane.add(lblMotor);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String,Object> valores = new HashMap<String,Object>();
				
				if (!txtDescricao.getText().trim().isEmpty()){
					valores.put("descricao", txtDescricao.getText());
				}
				if (!txtAnoFab.getText().trim().isEmpty()){
					valores.put("anoFabricacao",
							Integer.parseInt(txtAnoFab.getText()));
				}
				if (!txtAnoMod.getText().trim().isEmpty()){
					valores.put("anoModelo", 
							Integer.parseInt(txtAnoMod.getText()));
				}
				
				if (cboMarca.getSelectedIndex() != -1 
						&& cboMarca.getSelectedItem() != null){
					valores.put("marca", cboMarca.getSelectedItem());
				}
				
				if (cboCombustivel.getSelectedIndex() != -1 
						&& cboCombustivel.getSelectedItem() != null){
					valores.put("combustivel",
							cboCombustivel.getSelectedItem());
				}
				
				if (! txtId.getText().trim().isEmpty()){
					valores.put("id", Integer.parseInt(txtId.getText()));
				}
				
				if (! txtMotor.getText().trim().isEmpty()){
					valores.put("motor",Float.parseFloat(txtMotor.getText()));
				}
				try {
					modelModelo.filtrar(valores);
				} catch (Exception ex) {
					Dialogo.mostre("Erro ao filtar");
				}
				
			}
		});
		btnBuscar.setBounds(194, 167, 113, 25);
		contentPane.add(btnBuscar);
		
		
		
		tblModelo = new JTable(modelModelo);
		tblModelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tblModelo.getSelectedRow();
				Modelo m = modelModelo.getRow(linha);
				modelModelo.setModeloSelecionada(m);
				
				txtId.setText(String.valueOf(m.getId()));
				txtDescricao.setText(m.getDescricao());
				txtAnoFab.setText(String.valueOf(m.getAnoFabricacao()));
				txtAnoMod.setText(String.valueOf(m.getAnoModelo()));
				txtMotor.setText(String.valueOf(m.getMotor()));
				
				cboCombustivel.setSelectedItem(m.getCombustivel());
				
				cboMarca.setSelectedItem(m.getMarca());
				
						
			}
		});
		tblModelo.setBounds(0, 0, 1, 1);
		//contentPane.add(tblModelo);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 251, 459, 208);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tblModelo);
		
	
		
		
		
		
		
	}
}
