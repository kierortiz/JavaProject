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

public class deleteUser {

	JFrame frame;
	JPanel panel;
	JLabel lbl,idlbl,addlbl;
	JTextArea idtxt,addtxt;
	JButton delusr;
	Connection cn;
	Statement st,st1,st2;
	ResultSet rs;
	int ad,sum;
	
	
	public deleteUser()
	{
		frame = new JFrame("DELETE USER");
		panel = new JPanel();
		lbl = new JLabel("<html>Please use USER ID when <center>deleting users</center></html>");
			lbl.setBounds(50,0,200,100);
			panel.add(lbl);
		idlbl = new JLabel("USER ID:");
			idlbl.setBounds(30,120,100,20);
			panel.add(idlbl);
		idtxt = new JTextArea("0");
			idtxt.setBounds(90,120,100,20);
			panel.add(idtxt);
			idtxt.setFocusable(true);
		delusr = new JButton("DELETE");
			delusr.setBounds(100,180,100,30);
			panel.add(delusr);
		//ad = Integer.parseInt(delusr.getText());
			
		delusr.addActionListener(new ActionListener()
			{
				
						public void actionPerformed(ActionEvent ex)
						{	
							cn = null;
							String url = "jdbc:mysql://localhost:3306/";
							String dbName= "proj_db";
							String driver = "com.mysql.jdbc.Driver";
							String user = "root";
							String pass = "";
							try 
							{
								Class.forName(driver).newInstance();
								cn = DriverManager.getConnection(url + dbName, user, pass);
								try
								{
									st1 = cn.createStatement();
									st1.executeUpdate("UPDATE users SET user_pos='3' WHERE user_id='"+idtxt.getText()+"'");
									JOptionPane.showMessageDialog(null, "Deleted");
									frame.setVisible(false);
									
									
								}catch(Exception rere) {}
							}catch(Exception dss) {}
							
							
						}
			});		
			
			
			
			
		
		frame.add(panel);
		frame.setBounds(1350,200,300,340);
		panel.setLayout(null);
		frame.setVisible(true);	
	}

	public static void main (String [] args)
	{
		deleteUser proj = new deleteUser();	
	}
	
	
	
}
