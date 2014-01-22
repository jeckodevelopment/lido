package it.lido.business;

import java.util.Vector;

import it.lido.db.DbConnection;
import it.lido.gui.seldata;

public class listacabine {
	/*
	 * classe per ottenere la lista delle cabine libere
	 */
	

	private static Vector<String[]> v;
	
	public static String[] cabine;
	
	public static int count;
	

	public static void getCabina(){
		
		// connessione al database.
		
		
		DbConnection.connetti("lido", "root", "root");
		DbConnection.q.clear();
		String query = "SELECT C.idcabina FROM lido.cabina as C WHERE C.idcabina NOT IN (SELECT P.cabina_idcabina FROM lido.cliente_prenota_cabina as P WHERE NOT ((P.data_inizio > '"+ seldata.getdatainizio() +"' AND P.data_inizio > '"+ seldata.getdatafine()  +"') || (P.data_fine < '"+ seldata.getdatainizio() +"' AND P.data_fine < '"+ seldata.getdatafine()  +"')))";
		v = DbConnection.getInstance().eseguiQuery(query);
		cabine = new String[DbConnection.q.size()];
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

