package it.lido.gui;

import it.lido.business.gestcab;



// Interfaccia per la gestione delle cabine da parte dell'amministratore

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.lido.listener.listenergest;

public class gestiscicabine extends JFrame {
	
	public static JFrame gestione;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton annulla;
	public static JButton conferma;
	
	public static DefaultComboBoxModel listamodel;
	public static JComboBox lista;
	public static JLabel selezione;
	public static JLabel stato;
	
	public static String dataprenotazione;
	public static JTextField datainizio;
	public static JTextField datafine;
	public static JLabel di;
	public static JLabel df;
	
	public static JLabel idfasullo;
	public static JTextField idman;
	
	private listenergest ascoltatore;
	
	private Box gruppo;
	
	java.util.Date dt = new java.util.Date();
	
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public gestiscicabine()
	{
		gestione = new JFrame("Gestisci Cabine");
		gestione.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		gestione.setVisible(true);
		
		dataprenotazione = sdf.format(dt);

		
		selezione = new JLabel("Seleziona la cabina:");
		listamodel = new DefaultComboBoxModel();
		
		gestcab.getCabina();
		int count = gestcab.cabine.length;
		for(int i = 0 ; i < count ; i++){
		listamodel.addElement(gestcab.cabine[i]);
		}
		
		lista = new JComboBox(listamodel);
		
		di = new JLabel("Data Inizio:");
		datainizio = new JTextField();
		df = new JLabel("Data Fine:");
		datafine = new JTextField();
		
		idfasullo = new JLabel("Inserisci l'id per la manutenzione:");
		idman = new JTextField();
		
		stato = new JLabel("Clicca conferma per mettere in manutenzione.");
		
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		
		sotto = new JPanel();
		
		gruppo = Box.createVerticalBox();
		
		annulla = new JButton("Annulla");
		conferma = new JButton("Conferma");
		
		ascoltatore = new listenergest();
		
		annulla.addActionListener(ascoltatore);
		conferma.addActionListener(ascoltatore);
		
		
		
		
		operazioni.add(selezione);
		operazioni.add(lista);
		operazioni.add(di);
		operazioni.add(datainizio);
		operazioni.add(df);
		operazioni.add(datafine);
		operazioni.add(idfasullo);
		operazioni.add(idman);
		
		operazioni.add(stato);
		
		sotto.add(annulla);
		sotto.add(conferma);
		gruppo.add(operazioni);
		gruppo.add(sotto);
		gestione.add(gruppo);
		gestione.pack();
		
	}
	
	
		
	
	public static Object getdataprenotazione()
	{
		return dataprenotazione;
	}
	
	

	public static Object getdatainizio()
	{
		
		return datainizio.getText();
	}
	
	
	public static Object getdatafine()
	{
		return datafine.getText();
	}

	public static Object getidcliente()
	{
		String text = idman.getText();
		int idutente = Integer.parseInt(text);
		return idutente;
	}
	public static Object getAcqua()
	{
		int x=0;
		return x;
	
	}
	public static Object getElettricita()
	{
		int z=0;
		return z;
		
	}
	public static Object getAsciugamani()
	{
			int y=0;
	return y;
		
	}
	
	public static Object getCabina(){
		
		return listamodel.getElementAt(lista.getSelectedIndex());
	}
	
	

}
