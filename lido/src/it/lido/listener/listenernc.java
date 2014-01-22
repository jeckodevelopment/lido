package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;






import it.lido.gui.Accesso;
import it.lido.db.DbConnection;
import it.lido.gui.nuovocliente;
import it.lido.business.nuovoclienteb;




public class listenernc implements ActionListener{
	
	private Object source;
	
	private Accesso accesso;
	
	private nuovocliente nuovocliente;
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == nuovocliente.annulla){
			// operazioni da compiere nel caso in cui si attiva il tasto annulla
			WindowEvent close = new WindowEvent(nuovocliente.nuovocliente, WindowEvent.WINDOW_CLOSING);
			nuovocliente.nuovocliente.dispatchEvent(close);// chiusura della finestra attiva
			accesso = new Accesso();// apre la finestra di accesso.
		}
		if(source == nuovocliente.conferma){
			// operazioni da compiere nel caso in cui si attiva il tasto conferma
			
			WindowEvent close = new WindowEvent(nuovocliente.nuovocliente, WindowEvent.WINDOW_CLOSING);
			nuovocliente.nuovocliente.dispatchEvent(close);// chiusura della finestra attiva
			nuovoclienteb.aggiungi(nuovocliente.getidcliente(), nuovocliente.getnomecliente(), nuovocliente.getcognomecliente(), nuovocliente.getpass());
			accesso = new Accesso();
		}
	

}
}