package it.lido.gui;

import it.lido.business.listacabine;
import it.lido.business.scegliombrellone;
import it.lido.listener.listenerag;
import it.lido.listener.listenersd;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.lido.listener.listenernolombr;

// Interfaccia per noleggiare un ombrellone. (Bagnino)

public class noleggiaombrellone extends JFrame {
	
	
	public static JFrame noleggio;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton annulla;
	public static JButton conferma;
	
	public static JTextField idc;
	public static JTextField numombr;
	


	public static JLabel selezione;
	public static JLabel idcli;
	public static JLabel num;
	
	


	public static JLabel idnol;
	public static JComboBox lettini;
	
	public static DefaultComboBoxModel listamodel;
	public static JComboBox lista;
	
	
	
	public static String datanoleggio;
	
	private listenernolombr ascoltatore;
	
	private Box gruppo;
	
	java.util.Date dt = new java.util.Date();
	
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	public noleggiaombrellone()
	{
		noleggio = new JFrame("Noleggio Ombrellone");
		noleggio.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		noleggio.setVisible(true);
		
		listamodel = new DefaultComboBoxModel();
		
		datanoleggio = sdf.format(dt);
		
		idcli = new JLabel("Inserisci l'id del cliente:");
		idc = new JTextField();
		num = new JLabel("Seleziona ombrellone:");
		
		
		
		scegliombrellone.getOmbrellone();
		int count = scegliombrellone.ombrelloni.length;
		for(int i = 0 ; i < count ; i++){
		listamodel.addElement(scegliombrellone.ombrelloni[i]);
		}
		
		lista = new JComboBox(listamodel);
		
		
		selezione = new JLabel("Seleziona il numero di lettini (max 2):");
		
		lettini = new JComboBox();
		lettini.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		
	

		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		
		sotto = new JPanel();
		
		gruppo = Box.createVerticalBox();
		
		annulla = new JButton("Annulla");
		conferma = new JButton("Conferma");
		
		ascoltatore = new listenernolombr();
		
		annulla.addActionListener(ascoltatore);
		conferma.addActionListener(ascoltatore);
		
	
		operazioni.add(idcli);
		operazioni.add(idc);
		operazioni.add(num);
		operazioni.add(lista);
		operazioni.add(selezione);
		operazioni.add(lettini);
		
		sotto.add(annulla);
		sotto.add(conferma);
		gruppo.add(operazioni);
		gruppo.add(sotto);
		noleggio.add(gruppo);
		noleggio.pack();
		
	}
	
	public static Object getidcliente()
	{
		return idc.getText();
		
	}
	
	public static Object getnumlett()
	{
		return lettini.getSelectedItem();
		
	}
	public static Object getOmbr(){
		
		return listamodel.getElementAt(lista.getSelectedIndex());
	}
	
	
	public static Object getdatanoleggio()
	{
		return datanoleggio;
	}


}
