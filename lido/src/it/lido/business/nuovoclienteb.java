package it.lido.business;

import javax.swing.JOptionPane;
import it.lido.db.DbConnection;
import it.lido.gui.nuovocliente;
import it.lido.listener.listenernc;





public class nuovoclienteb {
	/*
	 * Clsse utilizzata per aggiungere una cliente al database.
	 */

	private static boolean v;
	public nuovoclienteb(){
	}
	public static void aggiungi(Object idcliente , Object nomecliente, Object cognomecliente, Object passcliente)
	{
		/*
		 * Metodo che richiamato aggiunge il cliente al database.
		 */
		/* 
		 * Connessione al database utilizzando la classe DbConnection
		 */
		DbConnection.getInstance();
		DbConnection.connetti("lido", "root", "root");
		// creazione della query da eseguire.
		String query = "INSERT INTO lido.cliente (idcliente, nome, cognome, password) VALUES ('" + idcliente + "' , '" + nomecliente + "' , '" + cognomecliente + "' , '" + passcliente + "');" ;
		v = DbConnection.getInstance().eseguiAggiornamento(query);// esecuzione della query
		if(v == true){
			//conferma della riuscita dell'inserimento del cliente
			JOptionPane.showMessageDialog(null, "Cliente aggiunto correttamente");
		}
		// disconnessione dal database.
		DbConnection.disconnetti();
				}
	}