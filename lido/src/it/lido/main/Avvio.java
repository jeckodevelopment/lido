package it.lido.main;

import it.lido.gui.Accesso;

public class Avvio {

	
	private static Accesso finestra;
	/*
	 * avvia la finestra principale richiamando la classe Accesso
	 * e avviando la gui del programma.
	 */
	public static void main(String[] args) {
		finestra = new Accesso();
	}
}
