package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JOptionPane;





import it.lido.db.DbConnection;
import it.lido.gui.login;
import it.lido.gui.serviziaggiuntivi;
import it.lido.gui.sceltacabina;
import it.lido.business.nuovaprenotazioneb;
import it.lido.business.nuovoclienteb;
import it.lido.gui.pannellocliente;
import it.lido.gui.seldata;





public class listenerag implements ActionListener{
	
	private Object source;
	
	private serviziaggiuntivi serviziaggiuntivi;
	private sceltacabina sceltacabina;
	private pannellocliente pannellocliente;
	
	
	private nuovaprenotazioneb nuovaprenotazioneb;
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == serviziaggiuntivi.annulla){
			// operazioni da compiere nel caso in cui si attiva il tasto indietro
			WindowEvent close = new WindowEvent(serviziaggiuntivi.serviziaggiuntivi, WindowEvent.WINDOW_CLOSING);
			serviziaggiuntivi.serviziaggiuntivi.dispatchEvent(close);// chiusura della finestra attiva
			sceltacabina = new sceltacabina();// apre la finestra scelta cabina.
		}
		if(source == serviziaggiuntivi.conferma){
			// operazioni da compiere nel caso in cui si attiva il tasto conferma
			WindowEvent close = new WindowEvent(serviziaggiuntivi.serviziaggiuntivi, WindowEvent.WINDOW_CLOSING);
			serviziaggiuntivi.serviziaggiuntivi.dispatchEvent(close);// chiusura della finestra attiva
			nuovaprenotazioneb.aggiungi(login.getNomeUtente(), sceltacabina.getCabina(), serviziaggiuntivi.getdataprenotazione(), seldata.getdatainizio(), seldata.getdatafine(), serviziaggiuntivi.getAcqua(), serviziaggiuntivi.getElettricita(), serviziaggiuntivi.getAsciugamani() );
		}
	

}
}
