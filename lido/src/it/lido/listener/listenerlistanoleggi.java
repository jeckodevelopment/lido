package it.lido.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;






import it.lido.db.DbConnection;
import it.lido.gui.listanoleggi;
import it.lido.gui.pannelloadmin;




public class listenerlistanoleggi implements ActionListener{
	
	private Object source;
	
	private pannelloadmin pannelloadmin;
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == listanoleggi.indietro){
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent close = new WindowEvent(listanoleggi.storiconol, WindowEvent.WINDOW_CLOSING);
			listanoleggi.storiconol.dispatchEvent(close);// chiusura della finestra attiva
			pannelloadmin = new pannelloadmin();// apre il pannello admin.
		}
		
	

}
}