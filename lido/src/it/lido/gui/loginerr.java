package it.lido.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import java.awt.event.ActionListener;

import it.lido.listener.listenerloginerr;


public class loginerr extends JFrame{
	/*
	 * Classe che contiene il costruttore per la finesrta del login errato
	 */
	
	public static JFrame bad;
	
	private JLabel label;
	public static JButton riprova;
	
	private JPanel panel;

	public loginerr(){
		
		// Creazione componenti
		bad = new JFrame("Errore");
		label = new JLabel("Credenziali errate!!!");
		riprova = new JButton("Riprova");
		panel = new JPanel(new BorderLayout());
		listenerloginerr ascoltatore = new listenerloginerr();
		riprova.addActionListener(ascoltatore);
		// Inserimento componenti nella finestra
		panel.add(label, BorderLayout.NORTH);
		panel.add(riprova, BorderLayout.SOUTH);
		bad.add(panel);
		bad.setVisible(true);
		bad.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		bad.pack();
	}
}
