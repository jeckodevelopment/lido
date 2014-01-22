package it.lido.business;
import java.util.Vector;

import it.lido.db.DbConnection;
import it.lido.gui.noleggiaombrellone;
import it.lido.gui.seldata;

public class scegliombrellone {

	/*
	 * classe per ottenere la lista degli ombrelloni.
	 */
	
	private static Vector<String[]> v;
	public static String[] ombrelloni;
	public static int count;

	public static void getOmbrellone(){
		/*
		 * metodo per ottenere la lista degli ombrelloni.
		 */
	
		DbConnection.connetti("lido", "root", "root");
		
		String query = "SELECT idombrellone FROM lido.ombrellone WHERE idombrellone NOT IN (SELECT ombrellone_idombrellone FROM bagnino_noleggia_ombrellone WHERE NOT (data_noleggio = '"+ noleggiaombrellone.getdatanoleggio() +"'))";
		v = DbConnection.getInstance().eseguiQuery(query);
		ombrelloni = new String[DbConnection.q.size()];// creazione array di stringhe che contiene la lista degli ombrelloni
		count = DbConnection.q.size();
		for(int i = 0 ; i < count ; i++)
		{
			// riempimento array con gli ombrelloni
			ombrelloni[i] = DbConnection.q.peek();
			DbConnection.q.remove();
		}
		DbConnection.q.clear();// pulizia della coda.
		
		
		
		DbConnection.disconnetti();// disconnessione.
		
	}
}
