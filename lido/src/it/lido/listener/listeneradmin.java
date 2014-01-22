package it.lido.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import it.lido.gui.Accesso;
import it.lido.gui.gestiscicabine;
import it.lido.gui.listaprenotazioni;
import it.lido.gui.pannelloadmin;
import it.lido.gui.nuovocliente;
import it.lido.gui.listanoleggi;
import it.lido.gui.aggiungicabina;





public class listeneradmin implements ActionListener {
	
	// definizione delle variabili
	private Object source;// definizione dell'oggetto usato per riconoscere la sorgente dell'attivazione dell'ascoltatore
	
	
	private Accesso accesso;
	private gestiscicabine gestiscicabine;
	private listaprenotazioni listaprenotazioni;
	private nuovocliente nuovocliente;
	private pannelloadmin pannelloadmin;
	private listanoleggi listanoleggi;
	private aggiungicabina aggiungicabina;
	
	


	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == pannelloadmin.indietro){
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent close = new WindowEvent(pannelloadmin.scelta, WindowEvent.WINDOW_CLOSING);
			pannelloadmin.scelta.dispatchEvent(close);// chiusura della finestra attiva
			accesso = new Accesso();// apre la finestra di accesso.
		}
	
		if(source == pannelloadmin.manutenzione){
			// operazioni da compiere nel caso in cui si attiva il tasto manutenzione
			WindowEvent close = new WindowEvent(pannelloadmin.scelta, WindowEvent.WINDOW_CLOSING);
			pannelloadmin.scelta.dispatchEvent(close);// chiusura della finestra attiva
			gestiscicabine = new gestiscicabine(); 
		}
		if(source == pannelloadmin.addcliente){
			// operazioni da compiere nel caso in cui si attiva il tasto aggiungi cliente
			WindowEvent close = new WindowEvent(pannelloadmin.scelta, WindowEvent.WINDOW_CLOSING);
			pannelloadmin.scelta.dispatchEvent(close);// chiusura della finestra attiva
			nuovocliente = new nuovocliente();
		}
		if(source == pannelloadmin.addcabina){
			// operazioni da compiere nel caso in cui si attiva il tasto aggiungi cabina
			WindowEvent close = new WindowEvent(pannelloadmin.scelta, WindowEvent.WINDOW_CLOSING);
			pannelloadmin.scelta.dispatchEvent(close);// chiusura della finestra attiva
			aggiungicabina = new aggiungicabina();
			
	}
		
		if(source == pannelloadmin.vediprenotazioni){
			// operazioni da compiere nel caso in cui si attiva il tasto vedi prenotazioni
			WindowEvent close = new WindowEvent(pannelloadmin.scelta, WindowEvent.WINDOW_CLOSING);
			pannelloadmin.scelta.dispatchEvent(close);// chiusura della finestra attiva
			listaprenotazioni = new listaprenotazioni();
			
	}
		if(source == pannelloadmin.vedinoleggio){
			// operazioni da compiere nel caso in cui si attiva il tasto vedi noleggi
			WindowEvent close = new WindowEvent(pannelloadmin.scelta, WindowEvent.WINDOW_CLOSING);
			pannelloadmin.scelta.dispatchEvent(close);// chiusura della finestra attiva
			listanoleggi = new listanoleggi();
			
	}
		
	

}
}
