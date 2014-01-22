package it.lido.business;

import java.util.Vector;

import it.lido.listener.listeneraccesso;


import it.lido.gui.loginerr;
import it.lido.gui.login;
import it.lido.gui.pannellocliente;
import it.lido.gui.pannelloadmin;
import it.lido.gui.pannellobagnino;
import it.lido.db.DbConnection;



public class logincheck {
	public static String idl; 
	/*
	  Classe che esegue il controllo sulle credenziali di login inserite.

	 */
	
	private String nome;
	
	private char[] pw;
	
	private String pass;
	
	
	private pannellobagnino bagnino;
	
	private pannelloadmin amministratore;
	
	private pannellocliente cliente;
	
	
	private loginerr bad;

	public logincheck(){
		
		nome = new String();
		DbConnection.getInstance();
		DbConnection.connetti("lido", "root", "root");
		nome = login.getNomeUtente();
		pw = login.getPassword();
		pass = new String(pw);
		// controllo del utente che sta cercando di loggarsi.
			if (listeneraccesso.ammin == true){
				// creazione query da eseguire.
				String query = "SELECT * FROM lido.amministratore WHERE idamministratore = '" + nome + "' AND password = '" + pass + "'";
				Vector<String[]> v = DbConnection.getInstance().eseguiQuery(query);// esecuzione query
				DbConnection.q.clear();// pulizia della coda che contiene il risultato della query
				if(v.size() == 0)
				{
					// credenziali inserite sono errate, quindi viene visualizzato il messaggio.
					bad = new loginerr();
				}
				if(v.size() != 0)
				{
					// credenziali inserite sono corrette, viene aperta la fienstra relativa all'aministratore.
					amministratore = new pannelloadmin();
				}
												}
			
			if (listeneraccesso.bagn == true)
			{
				// creazione query da eseguire.
				String query2 = "SELECT * FROM lido.bagnino WHERE idbagnino = '" + nome + "' AND password = '" + pass + "'";
				Vector<String[]> v2 = DbConnection.getInstance().eseguiQuery(query2);// esecuzione query
				DbConnection.q.clear();// pulizia della coda che contiene il risultato della query
				if(v2.size() == 0)
				{
					// credenziali inserite sono errate, quindi viene visualizzato il messaggio.
					bad = new loginerr();
				}
				if(v2.size() != 0)
				{
					// credenziali inserite sono corrette, viene aperta la relativa finestra
					bagnino = new pannellobagnino();
				}
			}
			if (listeneraccesso.cli == true)
			{
				// creazione query da eseguire.
				String query3 = "SELECT * FROM lido.cliente WHERE idcliente = '" + nome + "' AND password = '" + pass + "'";
				Vector<String[]> v3 = DbConnection.getInstance().eseguiQuery(query3);// esecuzione query
				idl = DbConnection.q.peek();
				DbConnection.q.clear();// pulizia della coda che contiene il risultato della query
				if(v3.size() == 0)
				{
					// credenziali inserite sono errate, quindi viene visualizzato il messaggio.
					bad = new loginerr();
				}
				if(v3.size() != 0)
				{
					// credenziali inserite sono corrette, viene aperta la relativa finestra
					cliente = new pannellocliente();
				}
			}
			// Disconnessione dal databse.
			DbConnection.disconnetti();
			
	}
}
