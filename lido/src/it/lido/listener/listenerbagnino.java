package it.lido.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import it.lido.gui.Accesso;
import it.lido.gui.noleggiaombrellone;
import it.lido.gui.nuovocliente;
import it.lido.gui.pannellobagnino;


public class listenerbagnino implements ActionListener {
	
	// definizione delle variabili
	private Object source;// definizione dell'oggetto usato per riconoscere la sorgente dell'attivazione dell'ascoltatore
	
	
	private Accesso accesso;
	
	
	private noleggiaombrellone noleggiaombrellone;
	
	
	private nuovocliente nuovocliente;
	
	
	private pannellobagnino pannellobagnino;


	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == pannellobagnino.indietro){
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent close = new WindowEvent(pannellobagnino.scelta, WindowEvent.WINDOW_CLOSING);
			pannellobagnino.scelta.dispatchEvent(close);// chiusura della finestra attiva
			accesso = new Accesso();// apre la finestra di accesso.
		}
		if(source == pannellobagnino.chiudi){
			// operazioni da compiere nel caso in cui si attiva il tasto chiudi
			WindowEvent close = new WindowEvent(pannellobagnino.scelta, WindowEvent.WINDOW_CLOSING);
			pannellobagnino.scelta.dispatchEvent(close);// chiusura della finestra attiva
		}
		if(source == pannellobagnino.ombrellone){
			// operazioni da compiere nel caso in cui si attiva il tasto nuovo noleggio
			WindowEvent close = new WindowEvent(pannellobagnino.scelta, WindowEvent.WINDOW_CLOSING);
			pannellobagnino.scelta.dispatchEvent(close);// chiusura della finestra attiva
			noleggiaombrellone = new noleggiaombrellone();
		}
		if(source == pannellobagnino.addcliente){
			// operazioni da compiere nel caso in cui si attiva il tasto aggiungicliente
			WindowEvent close = new WindowEvent(pannellobagnino.scelta, WindowEvent.WINDOW_CLOSING);
			pannellobagnino.scelta.dispatchEvent(close);// chiusura della finestra attiva
			nuovocliente = new nuovocliente();
		}
			
	}
	
}