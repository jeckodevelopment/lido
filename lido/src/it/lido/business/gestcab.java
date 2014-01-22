package it.lido.business;
import java.util.Vector;

import it.lido.db.DbConnection;


public class gestcab {
	/*
	 * classe per ottenere la lista delle cabine presenti nel database.
	 */
	

	private static Vector<String[]> v;
	
	public static String[] cabine;
	
	public static int count;


	public static void getCabina(){
		/*
		 * metodo per ottenere la lista delle cabine presenti nel database.
		 */
		// connessione al database.
		
		
		DbConnection.connetti("lido", "root", "root");
		DbConnection.q.clear();
		// recupero delle cabine presenti nel databse.
		String query = "SELECT cabina.idcabina FROM lido.cabina";
		v = DbConnection.getInstance().eseguiQuery(query);
		cabine = new String[DbConnection.q.size()];// creazione array di stringhe che contiene la lista delle cabine.
		count = DbConnection.q.size();
		for(int i = 0 ; i < count ; i++)
		{
			// riempimento array con le cabine
			cabine[i] = DbConnection.q.peek();
			DbConnection.q.remove();
		}
		DbConnection.q.clear();// pulizia della coda.
		DbConnection.disconnetti();// disconnessione.
		
		
	
	}
}