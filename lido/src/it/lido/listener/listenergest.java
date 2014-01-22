package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;






import it.lido.business.gestcab;
import it.lido.business.manutenzione;
import it.lido.gui.gestiscicabine;
import it.lido.gui.pannelloadmin;
import it.lido.gui.seldata;
import it.lido.db.DbConnection;





public class listenergest implements ActionListener{
	
	private Object source;
	
	private pannelloadmin pannelloadmin;
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == gestiscicabine.annulla){
			// operazioni da compiere nel caso in cui si attiva il tasto annulla
			WindowEvent close = new WindowEvent(gestiscicabine.gestione, WindowEvent.WINDOW_CLOSING);
			gestiscicabine.gestione.dispatchEvent(close);// chiusura della finestra attiva
			pannelloadmin = new pannelloadmin();// apre il pannello bagnino.
		}
		if(source == gestiscicabine.conferma){
			// operazioni da compiere nel caso in cui si attiva il tasto conferma
			WindowEvent close = new WindowEvent(gestiscicabine.gestione, WindowEvent.WINDOW_CLOSING);
			gestiscicabine.gestione.dispatchEvent(close);// chiusura della finestra attiva
			
			manutenzione.aggiungi(gestiscicabine.getidcliente(), gestiscicabine.getCabina(), gestiscicabine.getdataprenotazione(), gestiscicabine.getdatainizio(), gestiscicabine.getdatafine(), gestiscicabine.getAcqua(), gestiscicabine.getElettricita(), gestiscicabine.getAsciugamani() );
			
		}
	

}
}