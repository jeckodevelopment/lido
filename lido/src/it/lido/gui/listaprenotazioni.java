package it.lido.gui;

import javax.swing.*;  

import java.awt.Dimension;  
import java.awt.GridLayout;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.sql.*;  
import java.util.*;  

import it.lido.gui.login;
import it.lido.listener.listenersc;
import it.lido.listener.listenerlistaprenotazioni;
  

// Interfaccia per visualizzare lo storico di tutte le prenotazioni delle cabine. (Amministratore)

public class listaprenotazioni extends JFrame {  
	
	
	public static JFrame storicop;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton indietro;
	
	public static JTable table;
	


    public Connection con = null;  
    public Statement requete = null;  
    public ResultSet rs = null; 
    
    private listenerlistaprenotazioni ascoltatore;
	
	private Box gruppo;
	
    
    public listaprenotazioni(){  
    	
    	
    	storicop = new JFrame("Lista Completa delle Prenotazioni:");
		storicop.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		storicop.setVisible(true);
		
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
    	
		sotto = new JPanel();
		
		gruppo = Box.createVerticalBox();
		
		indietro = new JButton("Indietro");
		
		ascoltatore = new listenerlistaprenotazioni();
    	
		
		Object righe[][] = { { "ID Cliente", "# Cabina", "# Prenotazione", "Data Prenotazione", "Dal", "Al", "Acqua", "Elettricità", "Asciugamani",} };
		Object colonne[] = { "", "", "", "", "", "", "", "", ""};
		JTable tabella = new JTable(righe, colonne);
	
		
		
		
        try{  
            String url = "jdbc:mysql://127.0.0.1:3306/lido";  
            String userid = "root";  
            String paswordd = "root";      
            con = DriverManager.getConnection(url,userid,paswordd);  
            requete = con.createStatement();  
            rs = requete.executeQuery("SELECT * FROM lido.cliente_prenota_cabina");  
            ResultSetMetaData md = rs.getMetaData();  
            int columnCount = md.getColumnCount();  
      
            Vector columns = new Vector(columnCount);  
      
            //store column names  
            for(int i=1; i<=columnCount; i++)  
                columns.add(md.getColumnName(i));  
            Vector data = new Vector();  
            Vector row;  
      
            //store row data  
            while(rs.next())  
            {  
                row = new Vector(columnCount);  
                for(int i=1; i<=columnCount; i++)  
                {  
                    row.add(rs.getString(i));  
                }  
                data.add(row);  
            }  
            table = new JTable(data, columns);  
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));  
            table.setFillsViewportHeight(true);  
            table.setVisible(true);  
            table.validate();  
  
        }  
        catch(SQLException sqle){  
            //cf Comment gérer les erreurs ?   
            System.out.println(sqle);  
            sqle.printStackTrace();  
        }  
        
        indietro.addActionListener(ascoltatore);
		
       
        operazioni.add(tabella);
		operazioni.add(table);
		
		sotto.add(indietro);
		
		gruppo.add(operazioni);
		gruppo.add(sotto);
		storicop.add(gruppo);
		storicop.pack();
      
	}
}

