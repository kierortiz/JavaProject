import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class oppo1 extends JFrame{
	JFrame frame;
	JPanel panel,panel1;
	JLabel sampic,desc,variant,price,p1,p2,color,qty,addLbl,qtycheck,stockcheck;
	JRadioButton rad1,rad2;
	JButton samAdd;
	String cmb[] = {"Black", "White","Space Grey"};
	JTextField qtytxt;
	JComboBox cmbColor;
	String cpname="Oppo Reno2";
	String cpbrand="Oppo";
	String descrip="";
	String colordb;
	int pricedb,qtydb,qnty,qnty2,stkchk,totalqty,prodid;
	String usern;
	
	Connection cn;
	Statement st,st2;
	ResultSet rs;
	
	
	public oppo1(String usern) {
		
		this.usern=usern;
		frame = new JFrame("OPPO");
		panel = new JPanel();
	
		
		
		ImageIcon pic1 = new ImageIcon (new ImageIcon("oppocp2.jpg").getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT));	
		sampic = new JLabel(pic1);
			sampic.setBounds(30,30,200,250);
			panel.add(sampic);
		desc = new JLabel("<html>Basic Parameters<br><br>\r\n" + 
				"Color: Luminous Black, Sunset Pink<br>\r\n" + 
				"Operating System: ColorOS 6.1, based on Android 9<br>\r\n" + 
				"Processor: Qualcomm SDM730G<br>\r\n" + 
				"GPU: Adreno™ 618<br>\r\n" + 
				"Battery: 3915/4000mAh (Min/Typ)<br>\r\n" + 
				"RAM: 8GB/12GB<br>\r\n" + 
				"Storage: 128/256GB<br>\r\n" + 
				"VOOC Flash Charge: 3.0<html>");
		desc.setBounds(250,10,260,250);
			panel.add(desc);
		variant = new JLabel("VARIANT");
			variant.setBounds(30,300,100,20);
			panel.add(variant);
		rad1 = new JRadioButton("128GB Storage + 8GB RAM");
			rad1.setBounds(30,330,200,20);
			panel.add(rad1);
		rad2 = new JRadioButton("256GB Storage + 12GB RAM");
			rad2.setBounds(30,355,200,20);
			panel.add(rad2);
		ButtonGroup group = new ButtonGroup();
		group.add(rad1);
		group.add(rad2);
		price = new JLabel("PRICE");
			price.setBounds(250,300,100,20);
			panel.add(price);
		color = new JLabel("COLOR");
			color.setBounds(400,300,100,20);
			panel.add(color);
		cmbColor = new JComboBox(cmb);
			cmbColor.setBounds(380,330,100,20);
			panel.add(cmbColor);
		p1 = new JLabel("28000 Pesos");
			p1.setBounds(250,330,100,20);
			panel.add(p1);
		p2 = new JLabel("39000 Pesos");
			p2.setBounds(250,355,100,20);
			panel.add(p2);
		qty = new JLabel("Quantity:");
			qty.setBounds(40,400,100,20);
			panel.add(qty);
		qtytxt = new JTextField("1");
			qtytxt.setBounds(100,400,100,20);
			panel.add(qtytxt);
		qtycheck = new JLabel("Available: ");
			qtycheck.setBounds(300,400,90,20);
			panel.add(qtycheck);
		stockcheck = new JLabel("#");
			stockcheck.setBounds(360,400,60,20);
			panel.add(stockcheck);
			
		
		samAdd = new JButton("ADD");
			samAdd.setBounds(230,470,100,20);
			panel.add(samAdd);
		addLbl = new JLabel("ADD TO CART");
			addLbl.setBounds(240,440,100,20);
			panel.add(addLbl);
			
		frame.add(panel);
		frame.setBounds(750,250,530,550);
		panel.setLayout(null);
		frame.setVisible(true);
		
		
		rad1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
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
					if(rad1.isSelected())
					{
						//JOptionPane.showMessageDialog(null, "dsdas"+qnty);
						descrip = "128GB Storage + 8GB RAM";
						pricedb = 28000;
						try
						{
						st = cn.createStatement();
						String logg1 = ("SELECT * FROM products WHERE prod_id='219'");
						rs = st.executeQuery(logg1);
						if(rs.next())
						{
							prodid = rs.getInt("prod_id");
		                    qnty = rs.getInt("prod_stock");
						}
						//stockcheck.setText(" ");
						stockcheck.setText(qnty+"");;
						}catch(Exception dfwr)
						{}			
					}
				}catch(Exception es)
				{}
			}
			
		});	
		
		
		rad2.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
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
					if(rad2.isSelected())
					{
						
						descrip = "256GB Storage + 12GB RAM";
						pricedb = 39000;
						try
						{
						st = cn.createStatement();
						String logg1 = ("SELECT * FROM products WHERE prod_id='220'");
						rs = st.executeQuery(logg1);
						if(rs.next())
						{
							prodid = rs.getInt("prod_id");
		                    qnty = rs.getInt("prod_stock");
						}
						
						stockcheck.setText(qnty+"");;
						}catch(Exception dfwr)
						{}			
					}
				}catch(Exception es)
				{}
			}
			
		});	
	
		
		
		

		samAdd.addActionListener(new ActionListener()
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
					if(descrip.equals("") || descrip.equals(" "))
						{
							JOptionPane.showMessageDialog(null, "Please choose a variant from 2 choices!");					
						}
							
						else 
						{
							qtydb = Integer.parseInt(qtytxt.getText());
							stkchk = Integer.parseInt(stockcheck.getText());
							if(qtydb <= stkchk)
							{
							try
							{
								totalqty = stkchk - qtydb;
								st2=cn.createStatement();
								st2.executeUpdate("UPDATE products SET prod_stock='"+totalqty+"' WHERE prod_id='"+prodid+"'");
								try 
								{
								
									
									if(cmbColor.getSelectedItem().equals("Black"))
									{
										colordb = "Black";				
									}else if(cmbColor.getSelectedItem().equals("White"))
									{
										colordb = "White";
									}else if(cmbColor.getSelectedItem().equals("Space Grey"))
									{
										colordb = "Space Grey";
									}
									
									JOptionPane.showMessageDialog(null, "Item added to cart!");
									frame.setVisible(false);
									st=cn.createStatement();
									st.executeUpdate("INSERT INTO prod_added(prod_name,prod_brand,prod_desc,prod_color,prod_price,prod_qty,prod_user,added_time,prod_stat) VALUES ('"+cpname+"','"+cpbrand+"','"+descrip+"','"+colordb+"','"+pricedb+"','"+qtydb+"','"+usern+"',NOW(),'1');");
									
								
								
								
								}catch(Exception b){}
							}catch(Exception re) {}	
							}else
							{
								JOptionPane.showMessageDialog(null, "Not enough stock!");		
							}
					
						}
					
					
					
						
					
				}catch(Exception a)
				{
					
				}
					
				}
		});
		
		
		
		
	}
	
	
	

}
