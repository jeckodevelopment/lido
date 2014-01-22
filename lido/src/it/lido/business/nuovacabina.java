package it.lido.business;


import javax.swing.JOptionPane;
import it.lido.db.DbConnection;




public class nuovacabina {
	/*
	 * Clsse utilizzata per aggiungere una cabina al database.
	 */

	private static boolean v;
	public nuovacabina(){
	}
	public static void aggiungi(String dimensione , String prezzo)
	{
		/*
		 * Metodo che richiamato aggiunge la cabina al database.
		 */
		/* 
		 * Connessione al database utilizzando la classe DbConnection
		 */
		DbConnection.getInstance();
		DbConnection.connetti("lido", "root", "root");
		// creazione della query da eseguire.
		String query = "INSERT INTO lido.cabina (dimensione, prezzo) VALUES ('" + dimensione + "' , '" + 
		prezzo + "');" ;
		v = DbConnection.getInstance().eseguiAggiornamento(query);// esecuzione della query
		if(v == true){
			//conferma della riuscita dell'inserimento della cabina
			JOptionPane.showMessageDialog(null, "Cabina Aggiunta correttamente");
		}
		// disconnessione dal database.
		DbConnection.disconnetti();
				}
	}