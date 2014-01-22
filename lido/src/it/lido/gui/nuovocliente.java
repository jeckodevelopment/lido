package it.lido.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.lido.listener.listenernc;


// Interfaccia per l'aggiunta di un nuovo cliente. (Bagnino, Amministratore)


public class nuovocliente extends JFrame {
	
	public static JFrame nuovocliente;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton annulla;
	public static JButton conferma;
	
	public static JLabel idc;
	public static JTextField idcliente;
	public static JLabel nomec;
	public static JTextField nomecliente;
	public static JLabel cognomec;
	public static JTextField cognomecliente;
	public static JLabel passc;
	public static JTextField passcliente;
	
	private listenernc ascoltatore;
	
	private Box gruppo;
	
	public nuovocliente(){
		
		nuovocliente = new JFrame("Nuovo Cliente");
		nuovocliente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		nuovocliente.setVisible(true);
		
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
		

		idc = new JLabel("Inserisci l'id del cliente:");
		idcliente = new JTextField();

		nomec = new JLabel("Inserisci il nome del cliente:");
		nomecliente = new JTextField();
		

		cognomec = new JLabel("Inserisci il cognome del cliente:");
		cognomecliente = new JTextField();
		

		passc = new JLabel("Inserisci la password del cliente:");
		passcliente = new JTextField();
		
		sotto = new JPanel();
		gruppo = Box.createVerticalBox();
		
		ascoltatore = new listenernc();
		
		annulla = new JButton("Annulla");
		conferma = new JButton("Conferma");
		annulla.addActionListener(ascoltatore);
		conferma.addActionListener(ascoltatore);
		
		operazioni.add(idc);
		operazioni.add(idcliente);
		operazioni.add(nomec);
		operazioni.add(nomecliente);
		operazioni.add(cognomec);
		operazioni.add(cognomecliente);
		operazioni.add(passc);
		operazioni.add(passcliente);
		
		sotto.add(annulla);
		sotto.add(conferma);
		
		gruppo.add(operazioni);
		gruppo.add(sotto);
		
		nuovocliente.add(gruppo);
		nuovocliente.pack();
		
		
		
		

	}
	
	public static Object getidcliente()
	{
		return idcliente.getText();
		
	}
	
	public static Object getnomecliente()
	{
		return nomecliente.getText();
		
	}
	public static Object getcognomecliente()
	{
		return cognomecliente.getText();
		
	}
	public static Object getpass()
	{
		return passcliente.getText();
		
	}

}
