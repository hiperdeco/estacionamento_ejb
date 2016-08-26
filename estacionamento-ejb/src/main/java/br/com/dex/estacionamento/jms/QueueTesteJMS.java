package br.com.dex.estacionamento.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: QueueTesteJMS
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "jms/queue/A"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "QueueTesteJMS")
public class QueueTesteJMS implements MessageListener {

    /**
     * Default constructor. 
     */
    public QueueTesteJMS() {
        // TODO Auto-generated constructor stub
    	System.out.println("instanciou jms");
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	
        String msg;
		try {
			msg = ((TextMessage) message).getText();
			System.out.println("mensagem recebida: " +  msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
    }

}
