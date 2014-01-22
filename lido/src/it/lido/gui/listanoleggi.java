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
import it.lido.listener.listenerlistanoleggi;

// Interfaccia per visualizzare tutti i noleggi. (Amministratore)

public class listanoleggi extends JFrame {  
	
	
	public static JFrame storiconol;
	public static JPanel operazioni;
	public static JPanel sotto;
	public static JButton indietro;
	
	public static JTable table;
	


    public Connection con = null;  
    public Statement requete = null;  
    public ResultSet rs = null; 
    
    private listenerlistanoleggi ascoltatore;
	
	private Box gruppo;
	
    
    public listanoleggi(){  
    	
    	
    	storiconol = new JFrame("Lista Noleggi");
		storiconol.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		storiconol.setVisible(true);
		
		operazioni = new JPanel();
		operazioni.setLayout(new BoxLayout(operazioni, BoxLayout.Y_AXIS));
    	
		sotto = new JPanel();
		
		gruppo = Box.createVerticalBox();
		
		indietro = new JButton("Indietro");
		
		ascoltatore = new listenerlistanoleggi();
    	
		
		Object righe[][] = { { "# Noleggio", "ID Bagnino", "# Ombrellone", "Data Noleggio", "Num. Lettini", "ID Cliente"} };
		Object colonne[] = { "", "", "", "", "", ""};
		JTable tabella = new JTable(righe, colonne);
		
		
		
        try{  
            String url = "jdbc:mysql://127.0.0.1:3306/lido";  
            String userid = "root";  
            String paswordd = "root";      
            con = DriverManager.getConnection(url,userid,paswordd);  
            requete = con.createStatement();  
            rs = requete.executeQuery("SELECT * FROM lido.bagnino_noleggia_ombrellone");  
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
            
            System.out.println(sqle);  
            sqle.printStackTrace();  
        }  
        
        indietro.addActionListener(ascoltatore);
		
        operazioni.add(tabella);
		operazioni.add(table);
		
		sotto.add(indietro);
		
		gruppo.add(operazioni);
		gruppo.add(sotto);
		storiconol.add(gruppo);
		storiconol.pack();
      
	}
}


