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

public class adminPage {
	JFrame frame;
	JPanel panel,panel1,panel2,panel3,panel4;
	JLabel ad,ordtotal,ordamount,pIcon;
	JButton viewusr,vieword,viewprod,addstock,logout,deluser;
	JTable usertbl,addedtbl,prodtbl;
	//users
	DefaultTableModel model = new DefaultTableModel(new String[]{"USER ID","USERNAME","FIRST NAME","LAST NAME"}, 0);
	//prod added
	DefaultTableModel model1 = new DefaultTableModel(new String[]{"BRAND","NAME","DESCRIPTION","COLOR","PRICE","AMOUNT","ORDERED BY"}, 0);
	//products
	DefaultTableModel model2 = new DefaultTableModel(new String[]{"PRODUCT ID","BRAND","NAME","DESCRIPTION","PRICE","STOCK"}, 0);
	Connection cn;
	Statement st,st1,st2;
	ResultSet rs;
	String a,b,c,e;
	int f,d,totalamt=0,totalprc=0;
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	public adminPage()
	{
		
		
		
		
		frame = new JFrame("ADMIN");
		panel = new JPanel();
		panel1 = new JPanel(); 
		panel2 = new JPanel(); 
		panel3 = new JPanel(); 
		panel4 = new JPanel(); 
		//panel users
		panel1.setLayout(null);
			panel1.setVisible(false);
			panel1.setBounds(30,240,620,300);
			frame.add(panel1);	
			panel1.setBackground(Color.LIGHT_GRAY);
			
		//panel users
		panel2.setLayout(null);
			panel2.setVisible(false);
			panel2.setBounds(30,240,620,300);
			frame.add(panel2);	
			panel2.setBackground(Color.LIGHT_GRAY);
		
		//panel users
		panel3.setLayout(null);
			panel3.setVisible(false);
			panel3.setBounds(30,240,620,300);
			frame.add(panel3);	
			panel3.setBackground(Color.LIGHT_GRAY);	
		
			
			
			
		ad = new JLabel("Welcome Admin!");
			ad.setBounds(280,50,150,20);
			panel.add(ad);
			ad.setFont(new Font("Serif",Font.BOLD,14));
			ad.setForeground(Color.BLACK);
			
		viewusr = new JButton("View Users");
			viewusr.setBounds(120,90,120,30);
			panel.add(viewusr);
			viewusr.setFont(new Font("SansSerif",Font.BOLD,13));
			viewusr.setForeground(Color.black);
			viewusr.setCursor(cursor);
			
			
		vieword = new JButton("View Orders");
			vieword.setBounds(280,90,140,30);
			panel.add(vieword);
			vieword.setFont(new Font("SansSerif",Font.BOLD,13));
			vieword.setForeground(Color.black);
			vieword.setCursor(cursor);
			
			
			
		viewprod = new JButton("View Products");
			viewprod.setBounds(460,90,140,30);
			panel.add(viewprod);
			viewprod.setFont(new Font("SansSerif",Font.BOLD,13));
			viewprod.setForeground(Color.black);
			viewprod.setCursor(cursor);
			
			
		addstock = new JButton("Add Stock");
			addstock.setBounds(280,570,120,30);
			panel.add(addstock);
			addstock.setVisible(false);
		deluser = new JButton("Delete");
		deluser.setBounds(280,570,120,30);
			panel.add(deluser);
			deluser.setVisible(false);	
		ordtotal = new JLabel("");
			ordtotal.setBounds(450,600,200,20);
			panel.add(ordtotal);
			ordtotal.setVisible(false);
		ordamount = new JLabel("");
			ordamount.setBounds(450,560,200,20);
			panel.add(ordamount);
			ordamount.setVisible(false);
			
			
			
		logout = new JButton("LOGOUT");
			logout.setBounds(540,20,90,20);
			panel.add(logout);
			
			
			logout.addActionListener(new ActionListener()
			{
				
						public void actionPerformed(ActionEvent ex)
						{	
							frame.setVisible(false);
							new finals_proj();
						}
						
			
			});	
			
			
		
		//user
		usertbl = new JTable();
		usertbl.setModel(model);
		usertbl.setPreferredScrollableViewportSize(new Dimension(435,120));
		usertbl.setFillsViewportHeight(true);
		usertbl.setDefaultEditor(Object.class, null);

		JScrollPane scrollPane = new JScrollPane(usertbl);
		scrollPane.setBounds(0,0,620,300);
		panel1.add(scrollPane);	
		
		
		//added
		addedtbl = new JTable();
		addedtbl.setModel(model1);
		addedtbl.setPreferredScrollableViewportSize(new Dimension(435,120));
		addedtbl.setFillsViewportHeight(true);
		addedtbl.setDefaultEditor(Object.class, null);

		JScrollPane scrollPane1 = new JScrollPane(addedtbl);
		scrollPane1.setBounds(0,0,620,300);
		panel2.add(scrollPane1);
		
		//product
		prodtbl = new JTable();
		prodtbl.setModel(model2);
		prodtbl.setPreferredScrollableViewportSize(new Dimension(435,120));
		prodtbl.setFillsViewportHeight(true);
		prodtbl.setDefaultEditor(Object.class, null);

		JScrollPane scrollPane2 = new JScrollPane(prodtbl);
		scrollPane2.setBounds(0,0,620,300);
		panel3.add(scrollPane2);
			
		
		ImageIcon Iconn = new ImageIcon (new ImageIcon("adminbg.jpg").getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT));
		pIcon = new JLabel(Iconn);
		panel.add(pIcon);
		pIcon.setBounds(0,0,700,700);
		
	viewusr.addActionListener(new ActionListener()
		{
			
					public void actionPerformed(ActionEvent ex)
					{	
						cn = null;
						String url = "jdbc:mysql://localhost:3306/";
						String dbName= "proj_db";
						String driver = "com.mysql.jdbc.Driver";
						String user = "root";
						String pass = "";
						panel2.setVisible(false);
						panel3.setVisible(false);
						panel1.setVisible(true);	
						try 
						{
							ordamount.setVisible(false);
							ordtotal.setVisible(false);
							addstock.setVisible(false);
							deluser.setVisible(true);
							Class.forName(driver).newInstance();
							cn = DriverManager.getConnection(url + dbName, user, pass);
							try
							{
								//JOptionPane.showMessageDialog(null, "Success");
								st = cn.createStatement();
								String display1 = ("SELECT * FROM users WHERE user_pos='0'");
								rs = st.executeQuery(display1);
								model.setRowCount(0);
								//JOptionPane.showMessageDialog(null, "Success");
								while(rs.next()) 
								{
									f = rs.getInt("user_id");
									a = rs.getString("user_uname");
									b = rs.getString("user_fname");
									c = rs.getString("user_lname");
									d = rs.getInt("user_pos");
									
									
									model.addRow(new Object[]{f, a, b, c});
									usertbl.setModel(model);
									
								}	
								
							}catch(Exception rere) {}
						}catch(Exception dss) {}
						
						
					}
		});		
		
		
	vieword.addActionListener(new ActionListener()
	{
		
				public void actionPerformed(ActionEvent ex)
				{	
					cn = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbName= "proj_db";
					String driver = "com.mysql.jdbc.Driver";
					String user = "root";
					String pass = "";
					panel2.setVisible(true);
					panel3.setVisible(false);
					panel1.setVisible(false);	
					try 
					{
						totalamt = 0;
						totalprc = 0;
						addstock.setVisible(false);
						deluser.setVisible(false);
						ordamount.setVisible(true);
						ordtotal.setVisible(true);
						Class.forName(driver).newInstance();
						cn = DriverManager.getConnection(url + dbName, user, pass);
						try
						{
						
							st = cn.createStatement();
							String display2 = ("SELECT * FROM prod_added WHERE prod_stat='0'");
							rs = st.executeQuery(display2);
							model1.setRowCount(0);
							
							while(rs.next()) 
							{
								String aa = rs.getString("prod_name");
								String ab = rs.getString("prod_brand");
								String ac = rs.getString("prod_desc");
								String ad = rs.getString("prod_color");
								String ae = rs.getString("prod_user");
								int af = rs.getInt("prod_id");
								int ag = rs.getInt("prod_price");
								int ah = rs.getInt("prod_qty");
								
								
								totalamt += ah;
								totalprc += ag * ah;
								model1.addRow(new Object[]{ab, aa, ac, ad, ag, ah, ae});
								addedtbl.setModel(model1);
								
							}	
							ordtotal.setText("Total Orders: "+totalamt);
							ordamount.setText("Total Amount: "+totalprc);
						}catch(Exception rere) {}
					}catch(Exception dss) {}
					
					
				}
	});	
	
	viewprod.addActionListener(new ActionListener()
	{
		
				public void actionPerformed(ActionEvent ex)
				{	
					cn = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbName= "proj_db";
					String driver = "com.mysql.jdbc.Driver";
					String user = "root";
					String pass = "";
					panel2.setVisible(false);
					panel3.setVisible(true);
					panel1.setVisible(false);	
					try 
					{
						Class.forName(driver).newInstance();
						cn = DriverManager.getConnection(url + dbName, user, pass);
						try
						{
							ordamount.setVisible(false);
							ordtotal.setVisible(false);
							addstock.setVisible(true);
							deluser.setVisible(false);
							st = cn.createStatement();
							String display3 = ("SELECT * FROM products");
							rs = st.executeQuery(display3);
							model2.setRowCount(0);
							while(rs.next()) 
							{
								
								String ba = rs.getString("prod_name");
								String bb = rs.getString("prod_brand");
								String bc = rs.getString("prod_desc");
								//String bd = rs.getString("prod_color");
								int bf = rs.getInt("prod_id");
								int bg = rs.getInt("prod_price");
								int bh = rs.getInt("prod_stock");
								
								
								
								model2.addRow(new Object[]{bf, bb, ba, bc, bg, bh});
								prodtbl.setModel(model2);
								
							}	
							
						}catch(Exception rere) {}
					}catch(Exception dss) {}
					
					
				}
	});		
		
	addstock.addActionListener(new ActionListener()
	{
		
				public void actionPerformed(ActionEvent ex)
				{	
					new add();
				}
	});	
	
	deluser.addActionListener(new ActionListener()
	{
		
				public void actionPerformed(ActionEvent ex)
				{	
					new deleteUser();
				}
	});	
	
		frame.add(panel);
		frame.setBounds(650,100,700,700);
		panel.setLayout(null);
		frame.setVisible(true);	
		
		
	}
	
	
	
	


}
