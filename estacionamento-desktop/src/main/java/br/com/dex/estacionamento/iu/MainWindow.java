package br.com.dex.estacionamento.iu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMarcas = new JButton("Marcas");
		btnMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcaForm.main(null);
			}
		});
		btnMarcas.setBounds(158, 53, 117, 25);
		frame.getContentPane().add(btnMarcas);
		
		JButton btnModelos = new JButton("Modelos");
		btnModelos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModeloWindow.main(null);
			}
		});
		btnModelos.setBounds(158, 141, 117, 25);
		frame.getContentPane().add(btnModelos);
	}
}
