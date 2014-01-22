package it.lido.business;

import java.util.Vector;

import it.lido.db.DbConnection;

public class listaprenotazioni {

	/*
	 * classe per ottenere la lista delle prenotazioni presenti nel database.
	 */
	
	private static Vector<String[]> v;
	public static String[] prenotazioni;
	public static int count;

	public static void getPrenotazioni(){
		/*
		 * metodo per ottenere la lista delle prenotazioni presenti nel databse.
		 */
		// connessione ald databse.
		DbConnection.connetti("lido", "root", "root");
		// recupero delle prenotazioni presenti nel databse.
		String query = "SELECT cliente_prenota_cabina.idprenotazioni FROM lido.cliente_prenota_cabina";
		v = DbConnection.getInstance().eseguiQuery(query);
		prenotazioni = new String[DbConnection.q.size()];// creazione array di stringhe che contiene la lista delle prenotazioni
		count = DbConnection.q.size();
		for(int i = 0 ; i < count ; i++)
		{
			// riempimento array con le prenotazioni
			prenotazioni[i] = DbConnection.q.peek();
			DbConnection.q.remove();
		}
		DbConnection.q.clear();// pulizia della coda.
		DbConnection.disconnetti();// disconnessione.
	}
}
