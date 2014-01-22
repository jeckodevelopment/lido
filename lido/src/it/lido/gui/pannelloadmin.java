package it.lido.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.lido.listener.listeneradmin;





public class pannelloadmin extends JFrame{
	/*
	 * Classe che contiene l'interfaccia e i vari metodi per la scelta delle operazioni dell'amministratore
	 */
	public static JFrame scelta;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton chiudi;
	public static JButton indietro;
	public static JButton manutenzione;
	public static JButton vediprenotazioni;
	public static JButton vedinoleggio;
	public static JButton addcliente;
	public static JButton addcabina;
	
	
	private Box gruppo;
	
	private listeneradmin ascoltatore;
	

	public pannelloadmin(){
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
		chiudi = new JButton("chiudi");
		indietro = new JButton("indietro");
		manutenzione = new JButton("Gestisci cabine");
		addcliente = new JButton("Aggiungi Cliente");
		addcabina = new JButton("Aggiungi Cabina");
		vediprenotazioni = new JButton("Vedi Prenotazioni Cabine");
		vedinoleggio = new JButton("Vedi Noleggi Ombrelloni");
		
		ascoltatore = new listeneradmin();
		
		indietro.addActionListener(ascoltatore);
		chiudi.addActionListener(ascoltatore);
		manutenzione.addActionListener(ascoltatore);
		addcliente.addActionListener(ascoltatore);
		vediprenotazioni.addActionListener(ascoltatore);
		vedinoleggio.addActionListener(ascoltatore);
		addcabina.addActionListener(ascoltatore);
		
		
		
		manutenzione.setAlignmentX(CENTER_ALIGNMENT);
		addcliente.setAlignmentX(CENTER_ALIGNMENT);
		addcabina.setAlignmentX(CENTER_ALIGNMENT);
		vediprenotazioni.setAlignmentX(CENTER_ALIGNMENT);
		vedinoleggio.setAlignmentX(CENTER_ALIGNMENT);
		
		
		
		operazioni.add(manutenzione);
		operazioni.add(addcliente);
		operazioni.add(addcabina);
		operazioni.add(vediprenotazioni);
		operazioni.add(vedinoleggio);
		
		
		sotto.add(indietro);
		sotto.add(chiudi);
		gruppo.add(operazioni);
		gruppo.add(sotto);
		scelta.add(gruppo);
		scelta.pack();
	}	

}