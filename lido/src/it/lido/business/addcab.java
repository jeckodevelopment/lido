package it.lido.business;

import java.util.Vector;

import it.lido.db.DbConnection;


import it.lido.gui.aggiungicabina;

import javax.swing.JOptionPane;




public class addcab {
	/*
	 * Clsse utilizzata per aggiungere una cabina al database.
	 */

	private static boolean v;
	
	
	public addcab(){
		
		
			}
	
	public static void aggiungi(Object dimcab, Object prezzo)
	{
		/*
		 * Metodo che richiamato aggiunge una cabina al database.
		 */
		/* 
		 * Connessione al database utilizzando la classe DbConnection
		 * 
		 * 
		 */
		DbConnection.getInstance();
		DbConnection.connetti("lido", "root", "root");
		
		// creazione della query da eseguire.
		String query = "INSERT INTO lido.cabina (dimensione, prezzo) VALUES ('" + aggiungicabina.getDimensione() + "' , '" + aggiungicabina.getPrezzo() + "');" ;
		v = DbConnection.getInstance().eseguiAggiornamento(query);// esecuzione della query
		if(v == true){
			//conferma della riuscita dell'inserimento della cabina
			JOptionPane.showMessageDialog(null, "Cabina aggiunta correttamente!");
		}
		// disconnessione dal database.
		DbConnection.disconnetti();
				}
	
	
	
	}
