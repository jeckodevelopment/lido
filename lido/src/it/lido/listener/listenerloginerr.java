package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import it.lido.gui.Accesso;
import it.lido.gui.loginerr;

public class listenerloginerr implements ActionListener{
	/*
	 * metodo usato per definire le operazioni da associare ad ogni tasto dell'interfaccia.
	
	 */
	private Object source;// definizione dell'oggetto usato per riconoscere la sorgente dell'attivazione dell'ascoltatore
	
	
	private Accesso accesso;
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		if (source == loginerr.riprova){
			// operazioni da compiere nel caso in cui si attiva il tasto riprova
			WindowEvent close = new WindowEvent(loginerr.bad, WindowEvent.WINDOW_CLOSING);
			loginerr.bad.dispatchEvent(close);// chiusura della finestra
			accesso = new Accesso();// apertura dell'interfaccia per l'accesso al sistema.
		}
	}
	

}

