package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;





import it.lido.gui.gestiscicabine;
import it.lido.gui.pannellocliente;
import it.lido.db.DbConnection;

import it.lido.gui.storicocliente;




public class listenerstcliente implements ActionListener{
	
	private Object source;
	
	private pannellocliente pannellocliente;
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == storicocliente.indietro){
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent close = new WindowEvent(storicocliente.storico, WindowEvent.WINDOW_CLOSING);
			storicocliente.storico.dispatchEvent(close);// chiusura della finestra attiva
			pannellocliente = new pannellocliente();// apre il pannello cliente.
		}
		
	

}
}