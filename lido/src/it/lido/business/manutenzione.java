package it.lido.business;

import java.util.Vector;

import it.lido.db.DbConnection;

import it.lido.gui.gestiscicabine;

import javax.swing.JOptionPane;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class manutenzione {
	/*
	 * Clsse utilizzata per mettere una cabina in manutenzione.
	 */

	private static boolean v;

	
	
	
	
	public manutenzione(){
		
		
			}
	
	public static void aggiungi(Object idutente , Object cabina, Object dataprenotazione, Object datainizio, Object datafine, Object x, Object z, Object y)
	{
		
		/* 
		 * Connessione al database utilizzando la classe DbConnection
		 
		 */
		DbConnection.getInstance();
		DbConnection.connetti("lido", "root", "root");
		
		// creazione della query da eseguire.
		String query = "INSERT INTO lido.cliente_prenota_cabina (cliente_idcliente, cabina_idcabina, data_prenotazione, data_inizio, data_fine, acqua, elettricita, asciugamani) VALUES ('" + idutente + "' , '" + cabina + "', '" + dataprenotazione + "' , '" + datainizio + "' , '" + datafine + "' , '" + x + "' , '" + z + "' , '" + y + "')" ;
		v = DbConnection.getInstance().eseguiAggiornamento(query);// esecuzione della query
		if(v == true){
			//conferma della riuscita dell'inserimento 
			JOptionPane.showMessageDialog(null, "Cabina posta in manutenzione!!!");
		}
		// disconnessione dal database.
		DbConnection.disconnetti();
				}
	
	
	
	}


