package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;




import it.lido.gui.Accesso;
import it.lido.gui.login;
import it.lido.gui.noleggiaombrellone;
import it.lido.gui.pannellobagnino;
import it.lido.db.DbConnection;
import it.lido.business.nuovonoleggio;





public class listenernolombr implements ActionListener{
	
	private Object source;
	
	private pannellobagnino pannellobagnino;
	
	private noleggiaombrellone noleggiaombrellone;
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == noleggiaombrellone.annulla){
			// operazioni da compiere nel caso in cui si attiva il tasto annulla
			WindowEvent close = new WindowEvent(noleggiaombrellone.noleggio, WindowEvent.WINDOW_CLOSING);
			noleggiaombrellone.noleggio.dispatchEvent(close);// chiusura della finestra attiva
			pannellobagnino = new pannellobagnino();// apre il pannello bagnino.
		}
		if(source == noleggiaombrellone.conferma){
			// operazioni da compiere nel caso in cui si attiva il tasto conferma
			
			nuovonoleggio.aggiungi(login.getNomeUtente(), noleggiaombrellone.getOmbr(), noleggiaombrellone.getdatanoleggio(), noleggiaombrellone.getnumlett(), noleggiaombrellone.getidcliente());
			WindowEvent close = new WindowEvent(noleggiaombrellone.noleggio, WindowEvent.WINDOW_CLOSING);
			noleggiaombrellone.noleggio.dispatchEvent(close);// chiusura della finestra attiva
			pannellobagnino = new pannellobagnino();// apre pannello bagnino
		}
	

}
}