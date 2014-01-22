package it.lido.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import it.lido.listener.listenerbagnino;
import it.lido.listener.listenercliente;



public class pannellocliente extends JFrame {

	/*
	 * Classe che contiene il costrutto per la scelta delle cabine da parte del cliente
	 * e i metodi per le varie visualizzazioni
	 */
	
	public static JFrame scelta;
	public static JPanel operazioni;
	public static JPanel sotto;
	
	public static JButton indietro;
	public static JButton nuovaprenotazione;
	public static JButton storicoprenotazioni;
	public static JButton storiconoleggio;
	
	private Box gruppo;
	
	private listenercliente ascoltatore;

	
	public pannellocliente(){
		/*
		 * Costruttore per la creazione dell'interfaccia grafica
		 */
	
		scelta = new JFrame("Selezionare operazione desiderata");
		scelta.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scelta.setVisible(true);
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		sotto = new JPanel();
		gruppo =  Box.createVerticalBox();
		
		indietro = new JButton("indietro");
		nuovaprenotazione = new JButton("Nuova Prenotazione");
		storicoprenotazioni = new JButton("Storico Prenotazioni Cabine");
		storiconoleggio = new JButton("Storico Noleggio Ombrelloni");
		
		ascoltatore = new listenercliente();
	
		indietro.addActionListener(ascoltatore);
		
		nuovaprenotazione.addActionListener(ascoltatore);
		storicoprenotazioni.addActionListener(ascoltatore);
		storiconoleggio.addActionListener(ascoltatore);
		
		
		
		nuovaprenotazione.setAlignmentX(CENTER_ALIGNMENT);
		storicoprenotazioni.setAlignmentX(CENTER_ALIGNMENT);
		storiconoleggio.setAlignmentX(CENTER_ALIGNMENT);
		
		operazioni.add(nuovaprenotazione);
		operazioni.add(storicoprenotazioni);
		operazioni.add(storiconoleggio);
		
		
		sotto.add(indietro);
		
		gruppo.add(operazioni);
		gruppo.add(sotto);
		scelta.add(gruppo);
		scelta.pack();
		
		
	}
}
		
		