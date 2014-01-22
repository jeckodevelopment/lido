package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import it.lido.gui.aggiungicabina;
import it.lido.gui.login;
import it.lido.gui.pannelloadmin;
import it.lido.business.addcab;
import it.lido.business.nuovacabina;
import it.lido.business.nuovonoleggio;


public class listeneraggiungicabina implements ActionListener{
	/*
	 * Classe che contiene le azioni da compiere per i vari pulsanti  presenti nell'interfaccia aggiungicabina.  
	 * Viene usato l'oggetto Object per definire quale pulsante  e stato attivato
	 */
	private Object source;// definizione dell'oggetto usato per riconoscere la sorgente dell'attivazione dell'ascoltatore
	
	
	private pannelloadmin scelta;
	
	
	private aggiungicabina aggiungiaula;
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if (source == aggiungicabina.indietro){
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent close = new WindowEvent(aggiungicabina.aggiungicabina, WindowEvent.WINDOW_CLOSING);
			aggiungicabina.aggiungicabina.dispatchEvent(close);// chiusura della finestra
			scelta = new pannelloadmin();/* apertura della finestra per la scelta dell'operazione da parte dell'amministratore*/
		}
		if (source == aggiungicabina.conferma){
			// operazioni da compiere nel caso in cui si attiva il tasto conferma
			WindowEvent close = new WindowEvent(aggiungicabina.aggiungicabina, WindowEvent.WINDOW_CLOSING);
			aggiungicabina.aggiungicabina.dispatchEvent(close);// chiusura della finestra
			
			addcab.aggiungi(aggiungicabina.getDimensione(), aggiungicabina.getPrezzo());
			
			scelta = new pannelloadmin();/* apertura della finestra per la scelta dell'operazione da parte dell'amministratore*/
		}
		
	}

}
