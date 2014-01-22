package it.lido.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import it.lido.listener.listeneraccesso;


public class Accesso extends JFrame {
	/*
	 * Classe che contiene il costruttore per l'interfaccia di Accesso al sistema
	 */

	private static final long serialVersionUID = 1L;
	public static JFrame accesso;
	
	
	public JPanel panel;
	
	
	private JLabel benvenuto;
	public static JButton bagnino;
	public static JButton amministratore;
	public static JButton cliente;
	public static JButton chiudi;
	
	
	private JPanel sotto;
	
	
	private listeneraccesso ascoltatore;

	public Accesso(){
		/*
		 * Costruisce l'interfaccia di accesso al sistema, utilizzando i pacchetti Swing
		 */
		
		accesso = new JFrame("Lido Balneare");//crea la finestra dandole un titolo
		accesso.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//imposta l'opzione di chiusura della finestra
		accesso.setVisible(true);//imposta la finestra come visibile in primo piano
		accesso.setSize(new Dimension(500,400));//imposta le dimensioni della finestra
		panel = new JPanel();// crea il pannello per inserire gli oggetti nella finestra
		sotto = new JPanel(new BorderLayout());
		Box gruppo = Box.createVerticalBox();// crea il Box per sistemare i pannelli in modo verticale
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));// Setta il Layout del pannello come un BoxLayout
		//Crea i Pulsanti dell'interfaccia
		bagnino = new JButton("Bagnino");
		amministratore = new JButton("Amministratore");
		cliente = new JButton("Cliente");
		chiudi = new JButton("chiudi");
		// crea la Label dell'interfaccia
		benvenuto = new JLabel("Benvenuto, seleziona tipo utente");
		// Posiziona i pulsanti all'interno dell'interfaccia in modo centrale
		bagnino.setAlignmentX(CENTER_ALIGNMENT);
		amministratore.setAlignmentX(CENTER_ALIGNMENT);
		cliente.setAlignmentX(CENTER_ALIGNMENT);
		benvenuto.setAlignmentX(CENTER_ALIGNMENT);
		// creazione dell'ascoltatore per i pulsanti
		ascoltatore = new listeneraccesso();
		// associazione dell'ascoltatore
		bagnino.addActionListener(ascoltatore);
		amministratore.addActionListener(ascoltatore);
		cliente.addActionListener(ascoltatore);
		chiudi.addActionListener(ascoltatore);
		//aggiunta componenti ai pannelli
		panel.add(benvenuto);
		panel.add(bagnino);
		panel.add(amministratore);
		panel.add(cliente);
	
		sotto.add(chiudi, BorderLayout.LINE_END);
		//aggiunta pannelli al Box
		gruppo.add(panel);
		gruppo.add(sotto);
		// aggiunta Box al frame
		accesso.add(gruppo);
		accesso.pack();// imposta la finestra perche si adatti al suo contenuto
		
	}
}
