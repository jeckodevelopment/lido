package it.lido.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;




import it.lido.listener.listenerag;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Interfaccia per la scelta dei servizi aggiuntivi


public class serviziaggiuntivi extends JFrame {
	
	public static JFrame serviziaggiuntivi;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton annulla;
	public static JButton conferma;
	public static JCheckBox acqua;
	public static JCheckBox elettricita;
	public static JCheckBox asciugamani;
	private listenerag ascoltatore;
	public static String dataprenotazione;
	public static JLabel prezzi;
	
	
	private Box gruppo;
	

	java.util.Date dt = new java.util.Date();
	
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	public serviziaggiuntivi()
	{
		serviziaggiuntivi = new JFrame("Servizi Aggiuntivi");
		serviziaggiuntivi.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		serviziaggiuntivi.setVisible(true);
		
		dataprenotazione = sdf.format(dt);

		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		
		sotto = new JPanel();
		
		gruppo = Box.createVerticalBox();
		
		annulla = new JButton("Annulla");
		conferma = new JButton("Conferma");
		
		ascoltatore = new listenerag();
		
		annulla.addActionListener(ascoltatore);
		conferma.addActionListener(ascoltatore);
		
		prezzi = new JLabel("Ciascun servizio aggiuntivo costa € 5.00 al giorno!");
		
		acqua = new JCheckBox("acqua");
		elettricita = new JCheckBox("elettricità");
		asciugamani = new JCheckBox("asciugamani");
		
		
		operazioni.add(prezzi);
		operazioni.add(acqua);
		operazioni.add(elettricita);
		operazioni.add(asciugamani);
		sotto.add(annulla);
		sotto.add(conferma);
		gruppo.add(operazioni);
		gruppo.add(sotto);
		serviziaggiuntivi.add(gruppo);
		serviziaggiuntivi.pack();
		
		
		
		
	}
	
	public static Object getAcqua()
	{
		int x;
		
		if ( acqua.isSelected() == true)
			{
				x=1;
				
				
			}
		else
		{
			x=0;
			
		}
		return x;
	
		
		
	}
	public static Object getElettricita()
	{
		int z;
		
		if ( elettricita.isSelected() == true)
			{
				z=1;
				
				
			}
		else
		{
			z=0;
			
		}
		return z;
		
	}
	public static Object getAsciugamani()
	{
			int y;
		
		if ( asciugamani.isSelected() == true)
			{
				y=1;
				
				
			}
		else
		{
			y=0;
			
		}
	return y;
		
	}
	
	public static Object getdataprenotazione()
	{
		return dataprenotazione;
	}
	

}
