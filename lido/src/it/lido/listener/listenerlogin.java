package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import it.lido.gui.Accesso;
import it.lido.gui.login;
import it.lido.business.logincheck;

public class listenerlogin implements ActionListener {
	/*  Classe che contiene le azioni da compiere per i vari pulsanti  presenti nell'interfaccia login.  
	 * Viene usato l'oggetto Object per definire quale pulsante e stato attivato
	 
	 */
	
	private Object source;// definizione dell'oggetto usato per riconoscere la sorgente dell'attivazione dell'ascoltatore
	
	
	private Accesso accesso;
	
	
	private logincheck controllo;

	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		if(source == login.indietro)
		{
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent chiusura = new WindowEvent(login.login, WindowEvent.WINDOW_CLOSING);
			login.login.dispatchEvent(chiusura);// chiusura della finestra
			accesso = new Accesso();
		}
		if(source == login.conferma)
		{
			// operazioni da compiere nel caso in cui si attiva il tasto conferma
			WindowEvent chiusura = new WindowEvent(login.login, WindowEvent.WINDOW_CLOSING);
			login.login.dispatchEvent(chiusura);// chiusura della finestra
			controllo = new logincheck();// esegue il controllo delle credenziali
			}
		
	}
	

}
