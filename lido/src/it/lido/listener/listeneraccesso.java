package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import it.lido.gui.Accesso;

import it.lido.gui.login;


public class listeneraccesso implements ActionListener{
	
	
	
	private Object source;// definizione dell'oggetto usato per riconoscere la sorgente dell'attivazione dell'ascoltatore
	
	
	private login login;
	// variabili booleane utilizzate per riconoscere quale tasto e stato attivato.
	public static boolean ammin;
	public static boolean bagn;
	public static boolean cli;

	public void actionPerformed(ActionEvent e){
		
		// settaggio delle varibili booleane a false come valore base.
		ammin = false;
		bagn = false;
		cli = false;
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		if ( source == Accesso.bagnino){
			
			WindowEvent close = new WindowEvent(Accesso.accesso, WindowEvent.WINDOW_CLOSING);
			Accesso.accesso.dispatchEvent(close);// chiusura della finestra
			bagn=true;
			login = new login();// attivazione della finestra relativa al login
			
		}
		if ( source == Accesso.amministratore){
			
			WindowEvent close = new WindowEvent(Accesso.accesso, WindowEvent.WINDOW_CLOSING);
			Accesso.accesso.dispatchEvent(close);// chiusura della finestra
			ammin = true;// settaggio della variabile boolean a true, per l'utilizzo nella relativa classe di logica.
			login = new login();// attivazione della finestra relativa al login
		}
		if ( source == Accesso.cliente){
			
			WindowEvent close = new WindowEvent(Accesso.accesso, WindowEvent.WINDOW_CLOSING);
			Accesso.accesso.dispatchEvent(close);// chiusura della finestra
			cli = true;// settaggio della variabile boolean a true, per l'utilizzo nella relativa classe di logica.
			login = new login();// attivazione della finestra relativa al login
		}
		
		
		if ( source == Accesso.chiudi){
			// operazioni da compiere nel caso in cui si attiva il tasto di chiusa del software
			WindowEvent close = new WindowEvent(Accesso.accesso, WindowEvent.WINDOW_CLOSING);
			Accesso.accesso.dispatchEvent(close);// chiusura della finestra
		}
	}

}

