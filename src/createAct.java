import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class createAct implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel title;
	JLabel usr,pss,pss0,fname,lname;
	JButton btnSub,btnCan,btnBack;
	JPasswordField pss1;
	JTextArea usr1,fname1,lname1,email1;
	Connection cn;
	Statement st,st2;
	ResultSet rs;
	public static String usern;
	public String setuser;
	
	public createAct()
	{
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		frame = new JFrame("CREATE ACCOUNT");
		panel = new JPanel();
		
		title = new JLabel("CREATE NEW ACCOUNT");
			title.setBounds(50,30,250,50);
			panel.add(title);
			title.setFont(new Font("SansSerif",Font.BOLD,21));
			title.setForeground(Color.BLACK);

			
		usr = new JLabel("USERNAME: ");
			usr.setBounds(50,100,100,20);
			panel.add(usr);
			usr.setFont(new Font("Tahoma",Font.BOLD,14));
			usr.setForeground(Color.DARK_GRAY);
		
			
		pss = new JLabel("PASSWORD: ");
			pss.setBounds(50,140,100,20);
			panel.add(pss);	
			pss.setFont(new Font("Tahoma",Font.BOLD,14));
			pss.setForeground(Color.DARK_GRAY);
			
		fname = new JLabel("FIRST NAME: ");
			fname.setBounds(50,180,100,20);
			panel.add(fname);	
			fname.setFont(new Font("Tahoma",Font.BOLD,14));
			fname.setForeground(Color.DARK_GRAY);
			
		lname = new JLabel("LAST NAME: ");
			lname.setBounds(50,220,100,20);
			panel.add(lname);
			lname.setFont(new Font("Tahoma",Font.BOLD,14));
			lname.setForeground(Color.DARK_GRAY);
	
		usr1 = new JTextArea();
			usr1.setBounds(150,100,120,20);
			panel.add(usr1);
			usr1.setFont(new Font("SansSerif",Font.BOLD,12));
			
		pss1 = new JPasswordField();	
			pss1.setBounds(150,140,120,20);
			panel.add(pss1);
			pss1.setFont(new Font("SansSerif",Font.BOLD,12));
			
		fname1 = new JTextArea();
			fname1.setBounds(150,180,120,20);
			panel.add(fname1);	
			fname1.setFont(new Font("SansSerif",Font.BOLD,12));
			
		lname1 = new JTextArea();
			lname1.setBounds(150,220,120,20);
			panel.add(lname1);	
			lname1.setFont(new Font("SansSerif",Font.BOLD,12));
		
			
		btnSub = new JButton("REGISTER");
			btnSub.setBounds(35,310,115,30);
			panel.add(btnSub);
			btnSub.setFont(new Font("SansSerif",Font.BOLD,15));
			btnSub.setBackground(Color.white);
			btnSub.setForeground(Color.gray);
			btnSub.setCursor(cursor);
			
		btnBack = new JButton("CANCEL");
			btnBack.setBounds(170,310,115,30);
			panel.add(btnBack);
			btnBack.setFont(new Font("SansSerif",Font.BOLD,15));
			btnBack.setBackground(Color.white);
			btnBack.setForeground(Color.gray);
			btnBack.setCursor(cursor);
			
			
		ImageIcon Iconn = new ImageIcon (new ImageIcon("images (57).jpeg").getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT));
			JLabel pIcon = new JLabel(Iconn);
			panel.add(pIcon);
			pIcon.setBounds(0,0,400,500);
			
			frame.add(panel);
			frame.setBounds(400,0,400,500);
			panel.setLayout(null);
			frame.setVisible(true);
		
		btnSub.addActionListener(this);	
			
			
			btnBack.addActionListener(new ActionListener()
			{
				
						public void actionPerformed(ActionEvent ex)
						{	
							
							
							frame.setVisible(false);		
							new finals_proj();
									
									
								
						
						}
						
			
			});
	}
	
	

	public void actionPerformed(ActionEvent e)
	{
		cn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName= "proj_db";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String pass = "";
		
		try {//database connection attempt
			Class.forName(driver).newInstance();
			cn = DriverManager.getConnection(url + dbName, user, pass);
			try
			{// for the query
				//st = cn.createStatement();
				if(e.getSource() == btnSub)
				{		// check user and pass in dbase					
				st = cn.createStatement();
				String logg = ("SELECT user_uname FROM users WHERE user_uname='"+usr1.getText()+"'");
				rs = st.executeQuery(logg);
				if(usr1.getText().contentEquals("")||lname1.getText().contentEquals("")||
					fname1.getText().contentEquals("")||pss1.getText().contentEquals(""))
				{
					JOptionPane.showMessageDialog(null, "Please fill up the form correctly!");	
				}
				else 
				{
					if(rs.next())
					{
						String use = rs.getString("USERNAME");
						if(use.contentEquals(usr1.getText()))
						{
							JOptionPane.showMessageDialog(null, "Username Already taken!");	
							frame.setVisible(false);
							new createAct();
						}
					}else 
					{
						st2 = cn.createStatement();
						String logg1 = ("INSERT INTO users (user_uname,user_pass,user_fname,user_lname)VALUES('"+usr1.getText()+"','"+pss1.getText()+"','"+fname1.getText()+"','"+lname1.getText()+"');");
						st2.executeUpdate(logg1);
						JOptionPane.showMessageDialog(null, "Successfully Registered!");
						this.frame.setVisible(false);
						new finals_proj();
					}
				}
				

				}
			}catch(Exception ex)
			{
				
			}
			
			
		}catch(Exception ex)
		{
		
		}
		
	
	}
	
	

}
