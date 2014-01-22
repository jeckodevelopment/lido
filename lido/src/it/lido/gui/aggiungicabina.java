package it.lido.gui;

import java.awt.GridLayout;

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
import javax.swing.border.TitledBorder;

import it.lido.listener.listeneradmin;
import it.lido.listener.listeneraggiungicabina;

public class aggiungicabina extends JFrame{
	/*
	 * Classe contenente il costruttore e i metodi relativi all'aggiunta di una nuova cabina
	 * nel sistema da parte dell'amministratore
	 */
	
	public static JFrame aggiungicabina;
	
		
	private final JPanel operazioni;
	private static JPanel sotto;
	
	private Box gruppo;
	public static JButton indietro;
	public static JButton conferma;
	public static JButton chiudi;
	
	
	public static JComboBox dimcab;
	
	public static JTextField prezzo;
	public static JLabel p;
	public static JLabel s;
		
	private listeneraggiungicabina ascoltatore;
	
	

	public aggiungicabina(){
		
		
		//Creazione degli oggetti swing
		aggiungicabina = new JFrame("Nuova Cabina");
		aggiungicabina.setVisible(true);
		aggiungicabina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		sotto = new JPanel();
		gruppo =  Box.createVerticalBox();
		
		s = new JLabel("Scegli la dimensione:");
		dimcab = new JComboBox();
		dimcab.setModel(new DefaultComboBoxModel(new String[] {"Piccola", "Media", "Grande"}));
		
		p = new JLabel("Inserisci il prezzo");
		prezzo = new JTextField();
		
		
		indietro = new JButton("Indietro");
		conferma = new JButton("Conferma");
		
		ascoltatore = new listeneraggiungicabina();
		// assegnazione degli ascoltatori
		indietro.addActionListener(ascoltatore);
		
		conferma.addActionListener(ascoltatore);
	
		indietro.setAlignmentX(CENTER_ALIGNMENT);
		
		conferma.setAlignmentX(CENTER_ALIGNMENT);
		
		
		
		operazioni.add(s);
		operazioni.add(dimcab);
		operazioni.add(p);
		operazioni.add(prezzo);
		
		
		sotto.add(indietro);
		sotto.add(conferma);
		gruppo.add(operazioni);
		gruppo.add(sotto);
		aggiungicabina.add(gruppo);
		aggiungicabina.pack();
		
	}
	
	public static String getPrezzo(){
		
		return prezzo.getText();
	}
	public static Object getDimensione()
	{
		return dimcab.getSelectedItem();
		
	}
	
}
