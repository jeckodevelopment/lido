package it.lido.gui;

import java.sql.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import it.lido.listener.listenersd;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.crypto.Data;


// Interfaccia per selezionare la data di prenotazione


public class seldata extends JFrame {

	public static JFrame seldata;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton annulla;
	public static JButton prosegui;
	
	public static JTextField datainizio;
	public static JTextField datafine;
	
	public static JLabel di;
	public static JLabel df;
	public static JLabel l;
	public static JLabel m;
	public static JLabel n;
	public static JLabel o;
	public static JLabel p;
	
	private listenersd ascoltatore;

	private Box gruppo;
	
	
	public seldata()
	{
		seldata = new JFrame("Intervallo date:");
		seldata.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		seldata.setVisible(true);
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		sotto = new JPanel();
		gruppo = Box.createVerticalBox();
		annulla = new JButton("Annulla");
		ascoltatore = new listenersd();
		prosegui = new JButton("Prosegui");
		
		di = new JLabel("Data Inizio:");
		datainizio = new JTextField();
		df = new JLabel("Data Fine:");
		datafine = new JTextField();
		l = new JLabel ("ATTENZIONE: Inserire le date nel formato aaaa-MM-gg !!!");
		m = new JLabel ("Prenotando per 30 giorni si ha diritto al 5% di sconto su tutte le cabine.");
		n = new JLabel ("Prezzo Cabina GRANDE 30 euro al giorno.");
		o = new JLabel ("Prezzo Cabina MEDIA 20 euro al giorno.");
		p = new JLabel ("Prezzo Cabina PICCOLA 10 euro al giorno.");
				
				
		
		annulla.addActionListener(ascoltatore);
		prosegui.addActionListener(ascoltatore);
		
		
		operazioni.add(di);
		operazioni.add(datainizio);
		operazioni.add(df);
		operazioni.add(datafine);
		operazioni.add(l);
		operazioni.add(m);
		operazioni.add(n);
		operazioni.add(o);
		operazioni.add(p);
		sotto.add(annulla);
		sotto.add(prosegui);
		gruppo.add(operazioni);
		gruppo.add(sotto);
		seldata.add(gruppo);
		seldata.pack();
		
		
		
	}
	
	
	public static Object getdatainizio()
	{
		
		return datainizio.getText();
	}
	
	
	public static Object getdatafine()
	{
		return datafine.getText();
	}


}
