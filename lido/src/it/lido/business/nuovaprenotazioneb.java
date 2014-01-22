package it.lido.business;

import java.util.Vector;

import it.lido.db.DbConnection;
import it.lido.gui.login;
import it.lido.gui.seldata;
import it.lido.gui.sceltacabina;
import it.lido.gui.serviziaggiuntivi;

import javax.swing.JOptionPane;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class nuovaprenotazioneb {
	/*
	 * Clsse utilizzata per aggiungere una prenotazione al database.
	 */

	private static boolean v;
	
	
	public nuovaprenotazioneb(){
		
		
			}
	
	public static void aggiungi(Object idutente , Object cabina, Object dataprenotazione, Object datainizio, Object datafine, Object x, Object z, Object y)
	{
		/*
		 * Metodo che richiamato aggiunge la prenotazione al database.
		 */
		/* 
		 * Connessione al database utilizzando la classe DbConnection
		 * 
		 * 
		 */
		DbConnection.getInstance();
		DbConnection.connetti("lido", "root", "root");
		
		// creazione della query da eseguire.
		String query = "INSERT INTO lido.cliente_prenota_cabina (cliente_idcliente, cabina_idcabina, data_prenotazione, data_inizio, data_fine, acqua, elettricita, asciugamani) VALUES ('" + login.getNomeUtente() + "' , '" + cabina + "', '" + dataprenotazione + "' , '" + datainizio + "' , '" + datafine + "' , '" + x + "' , '" + z + "' , '" + y + "');" ;
		v = DbConnection.getInstance().eseguiAggiornamento(query);// esecuzione della query
		if(v == true){
			//conferma della riuscita dell'inserimento della prenotazione
			JOptionPane.showMessageDialog(null, "Prenotazione registrata correttamente. "
					+ "Riceverai quanto prima le informazioni per il pagamento.");
		}
		// disconnessione dal database.
		DbConnection.disconnetti();
				}
	
	
	
	}

