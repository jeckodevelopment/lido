package it.lido.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;






import javax.swing.JOptionPane;







import it.lido.db.DbConnection;
import it.lido.gui.sceltacabina;
import it.lido.gui.pannellocliente;
import it.lido.gui.seldata;






public class listenersd implements ActionListener{
	
	private Object source;
	
	private sceltacabina sceltacabina;
	private pannellocliente pannellocliente;
	
	public static String sdata1;
	public static String sdata2;
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * metodo usato per definire le operazioni da associare ad ogni tasto.
		 */
		source = e.getSource();// definisce la sorgente dell'attivazione dell'ascoltatore.
		
		if(source == seldata.annulla){
			// operazioni da compiere nel caso in cui si attiva il tasto annulla
			WindowEvent close = new WindowEvent(seldata.seldata, WindowEvent.WINDOW_CLOSING);
			seldata.seldata.dispatchEvent(close);// chiusura della finestra attiva
			pannellocliente = new pannellocliente();// apre la finestra pannellocliente.
		}
		
		
		if(source == seldata.prosegui) // esegue il controllo sulle date inserite 
		{
			sdata1 = (String) seldata.getdatainizio();
			sdata2 = (String) seldata.getdatafine();
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			Date data1 = null;
			try {
				data1 = df.parse(sdata1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Date data2 = null;
			try {
				data2 = df.parse(sdata2);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			if (data2.after(data1) == true)
			{
				WindowEvent close = new WindowEvent(seldata.seldata, WindowEvent.WINDOW_CLOSING);
				seldata.seldata.dispatchEvent(close);
				sceltacabina = new sceltacabina();
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null, "ERRORE! Controllare le date inserite!");
				
			}
			
			
		
		}
	

}
}
