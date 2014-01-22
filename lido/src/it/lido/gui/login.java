package it.lido.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import it.lido.listener.listenerlogin;


// Interfaccia per effettuare il login



public class login extends JFrame{
	
	
	public static JFrame login;


	private JLabel idutente;
	
	private JLabel pw;
	
	private JPanel label;
	
	private JPanel text;
	
	private JPanel toto;

	private static JTextField nome;

	private static JPasswordField password;
	public static JButton indietro;


	private Box gruppo;

	public static JButton conferma;

	
	private listenerlogin ascoltatore;
	
	public login (){
		/*
		 * Costruttore dell'interfaccia
		 */
		login = new JFrame("login");
		login.setVisible(true);
		login.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		login.setSize(new Dimension(500,400));
		//creazione dei campi per l'inserimento dei dati
		nome = new JTextField(10);
		password = new JPasswordField(10);
		//Creazione dei Pulsanti dell'interfaccia
		indietro = new JButton("Indietro");
		conferma = new JButton("Conferma");
		idutente = new JLabel("Nome utente");
		pw = new JLabel("Password");
		//Creazione dell'ascoltatore
		ascoltatore = new listenerlogin();
		//associazione dell'ascoltatore
		indietro.addActionListener(ascoltatore);
		conferma.addActionListener(ascoltatore);
		//Creazione dei pannelli per gli oggetti grafici
		label = new JPanel(new GridLayout(2,1));
		text = new JPanel(new GridLayout(2,1));
		toto = new JPanel(new BorderLayout());
		//creazione del box verticale
		gruppo = Box.createHorizontalBox();
		//aggiunta degli oggetti grafici alla finestra
		login.add(label);
		label.add(idutente);
		label.add(pw);
		text.add(nome);
		text.add(password);
		label.add(indietro);
		gruppo.add(label);
		gruppo.add(text);
		toto.add(gruppo, BorderLayout.NORTH);
		toto.add(indietro);
		toto.add(conferma, BorderLayout.AFTER_LAST_LINE);
		login.add(toto);
		login.pack();
	}
	public static String getNomeUtente(){
		/*
		 * restituisce il nome utente contenuto nella TextField 
		 */
		return nome.getText();
	}
	public static char[] getPassword(){
		/*
		 * restituisce la password contentuta nella JPasswordField
		 */
		return password.getPassword();
	}

}
