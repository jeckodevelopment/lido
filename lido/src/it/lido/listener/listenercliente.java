package it.lido.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import it.lido.gui.Accesso;
import it.lido.gui.seldata;
import it.lido.gui.storicocliente;
import it.lido.gui.pannellocliente;
import it.lido.gui.storiconoleggio;



public class listenercliente implements ActionListener {
	
	// definizione delle variabili
	private Object source;// definizione dell'oggetto usato per riconoscere la sorgente dell'attivazione dell'ascoltatore
	
	
	private Accesso accesso;
	
	
	private seldata seldata;
	
	
	private storicocliente storicocliente;
	
	
	private pannellocliente pannellocliente;

	private storiconoleggio storiconoleggio;
	


	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == pannellocliente.indietro){
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent close = new WindowEvent(pannellocliente.scelta, WindowEvent.WINDOW_CLOSING);
			pannellocliente.scelta.dispatchEvent(close);// chiusura della finestra attiva
			accesso = new Accesso();// apre la finestra di accesso.
		}
	
		if(source == pannellocliente.nuovaprenotazione){
			// operazioni da compiere nel caso in cui si attiva il tasto nuova prenotazione
			WindowEvent close = new WindowEvent(pannellocliente.scelta, WindowEvent.WINDOW_CLOSING);
			pannellocliente.scelta.dispatchEvent(close);// chiusura della finestra attiva
			seldata = new seldata();
		}
		if(source == pannellocliente.storicoprenotazioni){
			// operazioni da compiere nel caso in cui si attiva il tasto viasualizza storico
			WindowEvent close = new WindowEvent(pannellocliente.scelta, WindowEvent.WINDOW_CLOSING);
			pannellocliente.scelta.dispatchEvent(close);// chiusura della finestra attiva
			storicocliente = new storicocliente();
		}
		
		if(source == pannellocliente.storiconoleggio){
			// operazioni da compiere nel caso in cui si attiva il tasto viasualizza storico noleggi
			WindowEvent close = new WindowEvent(pannellocliente.scelta, WindowEvent.WINDOW_CLOSING);
			pannellocliente.scelta.dispatchEvent(close);// chiusura della finestra attiva
			storiconoleggio = new storiconoleggio();
		}
	}
	

}
