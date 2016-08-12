package br.com.dex.estacionamento.iu;

import javax.swing.JOptionPane;

/**
 * Classe responsavel pela caixa de dialogo
 * 
 * @author java04
 *
 */
public class Dialogo {
	
	/**
	 *  Mostra uma caixa de input
	 * @param mensagem (aparecera para o usuario)
	 * @return  o valor digitado
	 */
	public static String leia(String mensagem){
		return leia(mensagem,1);
	}
	
	/**
	 * Mostra uma caixa de input
	 * @param mensagem (aparecera para o usuario)
	 * @param tentativas (quantidade de tentativas
	 * @return o valor digitado
	 */
	public static String leia(String mensagem, int tentativas){
		String valor = null;
		for(int i=0; i< tentativas; i++){
			valor = JOptionPane.showInputDialog(mensagem);
			if (valor != null && !valor.trim().isEmpty()) break;
		}
		return valor;
	}
	
	
	/**
	 * Exibe um caixa de mensagem
	 * @param mensagem (aparecera para o usuario)
	 */
	public static void mostre(String mensagem){
		JOptionPane.showMessageDialog(null, mensagem);
	}

}
