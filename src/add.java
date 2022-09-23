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

public class add {

	JFrame frame;
	JPanel panel;
	JLabel lbl,idlbl,addlbl;
	JTextArea idtxt,addtxt;
	JButton addst;
	Connection cn;
	Statement st,st1,st2;
	ResultSet rs;
	int ad,sum;
	
	
	public add()
	{
		frame = new JFrame("ADD STOCK");
		panel = new JPanel();
		lbl = new JLabel("<html>Please use PRODUCT ID when <center>adding stock</center></html>");
			lbl.setBounds(50,0,200,100);
			panel.add(lbl);
		idlbl = new JLabel("PRODUCT ID:");
			idlbl.setBounds(30,120,100,20);
			panel.add(idlbl);
		idtxt = new JTextArea("0");
			idtxt.setBounds(110,120,100,20);
			panel.add(idtxt);
			idtxt.setFocusable(true);
		
		addlbl = new JLabel("ADD STOCK: ");
			addlbl.setBounds(30,170,100,20);
			panel.add(addlbl);
		addtxt = new JTextArea("0");
			addtxt.setBounds(110,170,100,20);
			panel.add(addtxt);
			idtxt.setFocusable(true);
		addst = new JButton("CONFIRM");
			addst.setBounds(90,230,100,30);
			panel.add(addst);
			
			addst.addActionListener(new ActionListener()
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
									st = cn.createStatement();
									String display4 = ("SELECT * FROM products WHERE prod_id ='"+idtxt.getText()+"'");
									rs = st.executeQuery(display4);
									while(rs.next()) 
									{
										int a = rs.getInt("prod_stock");
										ad = Integer.parseInt(addtxt.getText());
										sum = a + ad;
									}	
									
									
									try 
									{
										st1 = cn.createStatement();
										st1.executeUpdate("UPDATE products SET prod_stock='"+sum+"' WHERE prod_id='"+idtxt.getText()+"'");
										JOptionPane.showMessageDialog(null, "Successfully added, new Total stock is: "+sum);
										frame.setVisible(false);
									}catch(Exception sd) {}
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
		add proj = new add();	
	}
	
	
	
}
