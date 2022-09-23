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



public class cart implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel lbl,totallbl,amountlbl,moneylbl,changelbl,change,qtylbl,pIcon;
	JTextField money;
	JTable table;
	Connection cn;
	Statement st,st1,st2;
	ResultSet rs;
	JButton viewbtn,btnBack,calculate,chkout,delete;
	int price=0,total=0,totalqty=0,moneyin=0,change1=0;
	String a,b,c,f;
	int d,e;
	String usern;
	DefaultTableModel mdlCart = new DefaultTableModel(new String[]{"Brand","Name","Description","Color","Price","Quantity"}, 0);
	
	
	public cart(String usern)
	{
		this.usern=usern;
		frame = new JFrame("CART");
		panel = new JPanel();
		lbl = new JLabel("ITEMS IN CART");
			lbl.setBounds(300,30,100,20);
			panel.add(lbl);
	
		
		
		
		
		viewbtn = new JButton("VIEW");
			viewbtn.setBounds(300,300,70,30);
			panel.add(viewbtn);
		/*delete = new JButton("DELETE");
			delete.setBounds(530,300,90,30);
			panel.add(delete);*/
			
		totallbl = new JLabel("Total Amount: ");	
			totallbl.setBounds(420,380,120,20);
			totallbl.setBackground(Color.black);
			totallbl.setForeground(Color.white);
			panel.add(totallbl);
		amountlbl = new JLabel("");	
			amountlbl.setBounds(510,380,120,20);
			amountlbl.setBackground(Color.black);
			amountlbl.setForeground(Color.white);
			panel.add(amountlbl);	
		moneylbl = new JLabel("Enter Payment:");	
			moneylbl.setBounds(420,460,120,20);
			moneylbl.setBackground(Color.black);
			moneylbl.setForeground(Color.white);
			panel.add(moneylbl);

		money = new JTextField("0");
			money.setBounds(520,460,90,20);
			panel.add(money);
	
		
			
		qtylbl = new JLabel("Total Quantity:  "+totalqty);	
			qtylbl.setBounds(420,420,120,20);
			qtylbl.setBackground(Color.black);
			qtylbl.setForeground(Color.white);
			panel.add(qtylbl);
			
		btnBack = new JButton("Back");
			btnBack.setBounds(540,580,90,20);
			panel.add(btnBack);
			
		chkout = new JButton("Checkout");
				chkout.setBounds(420,540,90,20);
				chkout.setEnabled(false);
				panel.add(chkout);
		changelbl = new JLabel("Change: ");
			changelbl.setBounds(420,490,200,20);
			changelbl.setBackground(Color.black);
			changelbl.setForeground(Color.white);
			panel.add(changelbl);

			
		table = new JTable();
		table.setModel(mdlCart);
		table.setPreferredScrollableViewportSize(new Dimension(435,120));
		table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,70,600,200);
		panel.add(scrollPane);	

		ImageIcon Iconn = new ImageIcon (new ImageIcon("cart.jpg").getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT));
		pIcon = new JLabel(Iconn);
		panel.add(pIcon);
		pIcon.setBounds(0,0,700,700);
		
		
		btnBack.addActionListener(new ActionListener()
		{
			
					public void actionPerformed(ActionEvent ex)
					{	
						frame.setVisible(false);
						new firstpage(usern);
					}
					
		
		});		
	
chkout.addActionListener(new ActionListener()
		{
				
			public void actionPerformed(ActionEvent ex)
			{	
				moneyin = Integer.parseInt(money.getText());
				//JOptionPane.showMessageDialog(null, "Confirm checkout?"+moneyin);
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
						if(totalqty!=0)
						{
							
						if(total > moneyin)
						{
							JOptionPane.showMessageDialog(null, "Not enough payment!");
						}else
						{
							try
							{
							
							//rs = st.executeUpdate(display1);
							//rs.next();
								
							change1 = moneyin - total;
							changelbl.setText("Change: "+change1);
							JOptionPane.showMessageDialog(null, "Thank you for the payment!");
							JOptionPane.showMessageDialog(null, "Your Change is "+change1);
							st1 = cn.createStatement();
							st1.executeUpdate("UPDATE prod_added SET prod_stat='0' WHERE prod_user='"+usern+"'");
							frame.setVisible(false);
							new firstpage(usern);
							
							}catch(Exception ffd){}
							
							
						}
						}else
						{
							JOptionPane.showMessageDialog(null, "Nothing in cart");
						}
						}catch(Exception i){}
				}catch(Exception p){}
			}
		});		
	
	
	


viewbtn.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent ex)
	{	
		cn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName= "proj_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "";
		totalqty = 0;
		total = 0;
		try 
		{
			Class.forName(driver).newInstance();
			cn = DriverManager.getConnection(url + dbName, user, pass);
			try 
			{		
				chkout.setEnabled(true);
				st = cn.createStatement();
				String display = ("SELECT * FROM prod_added WHERE prod_user='"+usern+"' AND prod_stat = '1'");
				rs = st.executeQuery(display);
				mdlCart.setRowCount(0);
				while(rs.next()) 
				{
					a = rs.getString("prod_name");
					b = rs.getString("prod_brand");
					c = rs.getString("prod_desc");
					f = rs.getString("prod_color");
					d = rs.getInt("prod_price");
					e = rs.getInt("prod_qty");
					price = d * e;
					mdlCart.addRow(new Object[]{b, a, c, f, d, e});
					table.setModel(mdlCart);
					
					totalqty += e;
					total += price;
			}
			amountlbl.setText(""+total);
			qtylbl.setText("Total Quantity:  "+totalqty);
	}catch(Exception i){}
}catch(Exception p){}
	}
});
	

frame.add(panel);
frame.setBounds(650,100,700,700);
panel.setLayout(null);
frame.setVisible(true);

	
}	

	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
