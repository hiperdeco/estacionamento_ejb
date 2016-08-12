package br.com.dex.estacionamento.iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


import br.com.dex.estacionamento.iu.model.TabelaMarcaModel;
import br.com.dex.estacionamento.vo.Marca;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;

public class MarcaForm {

	private JFrame frmMarca;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JButton btnFiltrar;
	private JTable tblMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcaForm window = new MarcaForm();
					window.frmMarca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarcaForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	    final TabelaMarcaModel modelo = new TabelaMarcaModel(); 
		  
		frmMarca = new JFrame();
		frmMarca.setTitle("Marca");
		frmMarca.setBounds(100, 100, 450, 300);
		frmMarca.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMarca.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(30, 12, 70, 15);
		frmMarca.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(118, 10, 114, 19);
		frmMarca.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setBounds(30, 52, 70, 15);
		frmMarca.getContentPane().add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(118, 41, 114, 19);
		frmMarca.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Marca m = new Marca();
				String descricao = txtDescricao.getText().trim();
				if (!descricao.isEmpty()){
					m.setDescricao(descricao);
					
					modelo.insert(m);
					
					
					Dialogo.mostre("Inclusão realizada");
					txtDescricao.setText("");
					txtDescricao.requestFocus();
				}else{
					Dialogo.mostre("Descrição vazia");
				}
			}
		});
		btnIncluir.setBounds(43, 97, 117, 25);
		frmMarca.getContentPane().add(btnIncluir);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Marca filtro = new Marca();
				if (! txtId.getText().trim().isEmpty()){
					try{
						filtro.setId(Integer.parseInt(txtId.getText()));
					}catch(Exception ex){
						Dialogo.mostre("Id inválido!!!");
						txtId.selectAll();
						txtId.requestFocus();
					}
				}
				filtro.setDescricao(txtDescricao.getText());
				//buscar e mostrar na table
				try{
					modelo.getLines(filtro);
				}catch(Exception erro){
					erro.printStackTrace();
					Dialogo.mostre("Erro ao filtrar");
					
				}
				
			}
		});
		btnFiltrar.setBounds(188, 97, 117, 25);
		frmMarca.getContentPane().add(btnFiltrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 134, 298, 125);
		frmMarca.getContentPane().add(scrollPane);
		
		
		
		tblMarca = new JTable(modelo);
		//tblMarca.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblMarca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tblMarca.getSelectedRow();
				
				Marca m = (Marca) modelo.getRow(linha);
				//txtId.setEnabled(false);
				txtId.setText(String.valueOf(m.getId()));
				txtDescricao.setText(m.getDescricao());
				
			}
		});
		scrollPane.setViewportView(tblMarca);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = tblMarca.getSelectedRow();
				if (linha < 0){ 
					Dialogo.mostre("Selecione uma Marca");
					return;
				}
				
				Marca m = (Marca) modelo.getRow(linha);
				String descricao = txtDescricao.getText().trim();
				if (descricao.trim().isEmpty()){
					Dialogo.mostre("Descricao não preenchida");
					return;
				}
				m.setDescricao(descricao);
				modelo.alterar(m);
				
			}
		});
		btnAlterar.setBounds(265, 38, 117, 25);
		frmMarca.getContentPane().add(btnAlterar);
		
		
	}
}
