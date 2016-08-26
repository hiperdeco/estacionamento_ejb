package br.com.dex.estacionamento.ejb;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

/**
 * Session Bean implementation class TimeOutBean
 */
@Stateless
public class TimeOutBean implements TimeOutBeanLocal {

    @Resource 
    TimerService tm;
	
	/**
     * Default constructor. 
     */
    public TimeOutBean() {
    	System.out.println("instanciou o timer"); 
    }
    
    @Timeout
    public void timeout(Timer timer){
    	System.out.println("Executou timeout: " + timer.getInfo());
    }

    public void inicia(){
    	tm.createTimer(5000, "teste timeout");
    	System.out.println("sera que agendou?");
    }
    
    @Schedule(second="*/3", minute="*", hour="*")
    public void testeAutomatico(){
    	System.out.println("teste automatica de 3 segundos ");
    }
}
