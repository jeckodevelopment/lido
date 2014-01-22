package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;




import it.lido.gui.seldata;
//import it.lido.gui.aggiornaprenotazione;
import it.lido.db.DbConnection;
import it.lido.gui.sceltacabina;
import it.lido.gui.serviziaggiuntivi;




public class listenersc implements ActionListener{
	
	private Object source;
	
	private seldata seldata;
	
	private serviziaggiuntivi serviziaggiuntivi;
	
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == sceltacabina.annulla){
			// operazioni da compiere nel caso in cui si attiva il tasto annulla
			WindowEvent close = new WindowEvent(sceltacabina.sceltacabina, WindowEvent.WINDOW_CLOSING);
			sceltacabina.sceltacabina.dispatchEvent(close);// chiusura della finestra attiva
			seldata = new seldata();// apre la finestra scelta data.
		}
		if(source == sceltacabina.prosegui){
			// operazioni da compiere nel caso in cui si attiva il tasto prosegui
			WindowEvent close = new WindowEvent(sceltacabina.sceltacabina, WindowEvent.WINDOW_CLOSING);
			sceltacabina.sceltacabina.dispatchEvent(close);// chiusura della finestra attiva
			serviziaggiuntivi = new serviziaggiuntivi(); // apre la finestra servizi aggiuntivi
		}
	

}
}