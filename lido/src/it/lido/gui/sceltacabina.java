package it.lido.gui;



import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




import it.lido.listener.listenersc;
import it.lido.business.listacabine;
import it.lido.business.listaprenotazioni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sceltacabina extends JFrame {
	
	// Classe contenente l'interfaccia e i metodi per selezionare la cabina da prenotare
	
	
	public static JFrame sceltacabina;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton annulla;
	public static JButton prosegui;
	
	public static DefaultComboBoxModel listamodel;
	public static JComboBox lista;
	public static JLabel scegli;
	public static JLabel legenda;
	
	
	private listenersc ascoltatore;
	
	private Box gruppo;
	
	public sceltacabina()
	{
	
		sceltacabina = new JFrame("Seleziona la cabina...");
		sceltacabina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		sceltacabina.setVisible(true);
		
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		
		listamodel = new DefaultComboBoxModel();
		
		sotto = new JPanel();
		scegli = new JLabel("Scegli la cabina tra quelle disponibili:");
		legenda = new JLabel("1 - Grande");
		
		gruppo = Box.createVerticalBox();
		
		annulla = new JButton("Annulla");
		
		ascoltatore = new listenersc();
		
		prosegui = new JButton("Prosegui");
		
		
		
		listacabine.getCabina();
		int count = listacabine.cabine.length;
		for(int i = 0 ; i < count ; i++){
		listamodel.addElement(listacabine.cabine[i]);
		}
		
		lista = new JComboBox(listamodel);
		
		prosegui.addActionListener(ascoltatore);
		annulla.addActionListener(ascoltatore);
		
		operazioni.add(scegli);
		operazioni.add(lista);
		operazioni.add(legenda);
		sotto.add(annulla);
		sotto.add(prosegui);
		gruppo.add(operazioni);
		gruppo.add(sotto);
		sceltacabina.add(gruppo);
		sceltacabina.pack();
	}
	
	
	public static Object getCabina(){
		
		return listamodel.getElementAt(lista.getSelectedIndex());
	}
	
	
	
	
}


		
		
	
	
	
	
	


