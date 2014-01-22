package it.lido.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.lido.listener.listenerbagnino;





public class pannellobagnino extends JFrame{
	/*
	 * Classe che contiene l'interfaccia e i vari metodi per la scelta delle operazioni del bagnino
	 */
	public static JFrame scelta;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton chiudi;
	public static JButton indietro;
	public static JButton ombrellone;
	public static JButton addcliente;
	
	private Box gruppo;
	
	private listenerbagnino ascoltatore;
	

	public pannellobagnino(){
		
		scelta = new JFrame("Selezionare operazione desiderata");
		scelta.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scelta.setVisible(true);
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		sotto = new JPanel();
		gruppo =  Box.createVerticalBox();
		chiudi = new JButton("chiudi");
		indietro = new JButton("indietro");
		ombrellone = new JButton("Noleggia Ombrellone");
		addcliente = new JButton("Aggiungi Cliente");
		
		ascoltatore = new listenerbagnino();
		
		indietro.addActionListener(ascoltatore);
		chiudi.addActionListener(ascoltatore);
		ombrellone.addActionListener(ascoltatore);
		addcliente.addActionListener(ascoltatore);
		

		ombrellone.setAlignmentX(CENTER_ALIGNMENT);
		addcliente.setAlignmentX(CENTER_ALIGNMENT);
		
		operazioni.add(ombrellone);
		operazioni.add(addcliente);
		
		sotto.add(indietro);
		sotto.add(chiudi);
		gruppo.add(operazioni);
		gruppo.add(sotto);
		scelta.add(gruppo);
		scelta.pack();
	}	

}