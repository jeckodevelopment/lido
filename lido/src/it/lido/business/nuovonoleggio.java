package it.lido.business;

import java.util.Vector;

import it.lido.db.DbConnection;
import it.lido.gui.login;
import it.lido.gui.noleggiaombrellone;
import it.lido.gui.sceltacabina;
import it.lido.gui.serviziaggiuntivi;

import javax.swing.JOptionPane;

public class nuovonoleggio {
	
	// classe per aggiungere un nuovo noleggio


	private static boolean v3;
	private static String ID;
	
	
	public nuovonoleggio(){
		
	}
	
	public static void aggiungi(Object idbagnino, Object ombrellone, Object datanoleggio, Object lettini, Object idc){
		
		DbConnection.getInstance();
		DbConnection.connetti("lido", "root", "root");
		
		String agg = "INSERT INTO lido.bagnino_noleggia_ombrellone (bagnino_idbagnino, ombrellone_idombrellone, data_noleggio, num_lettini, cliente_idcliente) VALUES ('" + login.getNomeUtente() + "' , '" + ombrellone + "' , '" + datanoleggio + "' , '" + lettini + "' , '" + idc + "')";
	
		v3 = DbConnection.getInstance().eseguiAggiornamento(agg);// esecuzione dell'update
		if (v3 == true){
			// segnalazione che il noleggio è stato aggiunto correttamente.
			JOptionPane.showMessageDialog(null, "Noleggio Registrato correttamente");
		}
	
		
		else{
			
				JOptionPane.showMessageDialog(null, "Errore");
}
			// disconnessione dal database.
			DbConnection.disconnetti();
}
	}

	
	