package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;






import it.lido.db.DbConnection;
import it.lido.gui.storiconoleggio;
import it.lido.gui.pannellocliente;




public class listenernolcli implements ActionListener{
	
	private Object source;
	
	private pannellocliente pannellocliente;
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == storiconoleggio.indietro){
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent close = new WindowEvent(storiconoleggio.storico, WindowEvent.WINDOW_CLOSING);
			storiconoleggio.storico.dispatchEvent(close);// chiusura della finestra attiva
			pannellocliente = new pannellocliente();// apre il pannello cliente.
		}
		
	

}
}
