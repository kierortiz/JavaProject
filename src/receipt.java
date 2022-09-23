import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class receipt {
	JFrame frame;
	JPanel panel;
	

	public receipt()
	{
		frame = new JFrame("RECEIPT");
		panel = new JPanel();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	frame.add(panel);
	frame.setBounds(850,50,300,600);
	panel.setLayout(null);
	frame.setVisible(true);
	}

	public static void main (String [] args)
	{
		receipt proj = new receipt();	
	}
	
	
}
