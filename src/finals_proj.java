import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class finals_proj implements ActionListener{

	JFrame frame;
	JPanel panel;
	JLabel title,user1,pass1,cr8,pIcon,logIcon,create,title1,title2;
	JButton btnOk, btnCan,btnCreate;
	JPasswordField pass2;
	JTextArea user2;
	Connection cn;
	Statement st;
	ResultSet rs;
	String setuser;
	Integer pos;
	
	public finals_proj()  //String usern
	{

		frame = new JFrame("LOG-IN");
		panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.white);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		
		
		
		title1 = new JLabel("WELCOME!");
			title1.setBounds(10,5,150,60);
			panel.add(title1);
			title1.setFont(new Font("Arial black",Font.BOLD,20));
			title1.setForeground(Color.GRAY);
			
		
		
		title = new JLabel("USER LOGIN");
			title.setBounds(45,85,160,60);
			panel.add(title);
			title.setFont(new Font("SansSerif",Font.BOLD,21));
			title.setForeground(Color.BLACK);
			
			
			title2 = new JLabel("Login here using your Username and Password");
			title2.setBounds(45,85,280,100);
			panel.add(title2);
			title2.setFont(new Font("Century Gothic",Font.BOLD,12));
			title2.setForeground(Color.DARK_GRAY);
			
			
			
		user1 = new JLabel("USERNAME:");
			user1.setBounds(80,155,100,50);
			panel.add(user1);
			user1.setFont(new Font("Tahoma",Font.BOLD,16));
			user1.setForeground(Color.white);
			
			
		pass1 = new JLabel("PASSWORD:");
			pass1.setBounds(80,218,130,50);
			panel.add(pass1);
			pass1.setFont(new Font("Tahoma",Font.BOLD,16));
			pass1.setForeground(Color.white);
						
		user2 = new JTextArea();
			user2.setBounds(190,168,150,25);
			panel.add(user2);
			user2.setFont(new Font("SansSerif",Font.BOLD,14));
			
			
		pass2 = new JPasswordField();
			pass2.setBounds(190,230,150,25);
			panel.add(pass2);
			pass2.setFont(new Font("SansSerif",Font.BOLD,12));
			
			
		btnOk = new JButton("LOG-IN");
			btnOk.setBounds(60,285,125,30);
			panel.add(btnOk);
			btnOk.setFont(new Font("SansSerif",Font.BOLD,15));
			btnOk.setBackground(Color.white);
			btnOk.setForeground(Color.gray);
			btnOk.setCursor(cursor);
					
			
		btnCan = new JButton("CANCEL");
			btnCan.setBounds(210,285,125,30);
			panel.add(btnCan);
			btnCan.setFont(new Font("SansSerif",Font.BOLD,15));
			btnCan.setBackground(Color.white);
			btnCan.setForeground(Color.gray);
			btnCan.setCursor(cursor);
			
			create = new JLabel("No account yet? Click ");
			create.setBounds(80,315,200,60);
			panel.add(create);
			create.setFont(new Font("sansserif",Font.BOLD,15));
			create.setForeground(Color.DARK_GRAY);
			
		btnCreate = new JButton("HERE");
			btnCreate.setBounds(210,315,100,60);
			panel.add(btnCreate);
			btnCreate.setFont(new Font("SansSerif",Font.BOLD,15));
			btnCreate.setBorder(null);
			btnCreate.setBorderPainted(false);
			btnCreate.setOpaque(false);
			btnCreate.setContentAreaFilled(false);
			btnCreate.setForeground(Color.black);
			btnCreate.setCursor(cursor);
			
			
			ImageIcon conn = new ImageIcon (new ImageIcon("account.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			pIcon = new JLabel(conn);
			panel.add(pIcon);
			pIcon.setBounds(55,170,20,20);
			
			ImageIcon connn = new ImageIcon (new ImageIcon("login.jpeg.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			pIcon = new JLabel(connn);
			panel.add(pIcon);
			pIcon.setBounds(55,230,20,20);


	
			ImageIcon Iconn = new ImageIcon (new ImageIcon("images (58).jpeg").getImage().getScaledInstance(500, 490, Image.SCALE_DEFAULT));
			pIcon = new JLabel(Iconn);
			panel.add(pIcon);
			pIcon.setBounds(0,0,500,490);
			
			
			
			
		btnOk.addActionListener(this);
		btnCan.addActionListener(this);
		btnCreate.addActionListener(this);			
			
		frame.add(panel);
		frame.setBounds(400,0,500,490);
		
		frame.setVisible(true);
		
		
		btnCreate.addActionListener(new ActionListener()
		{
			
					public void actionPerformed(ActionEvent ex)
					{	
						
						
						frame.setVisible(false);		
						new createAct();
								
								
							
					
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
				if(e.getSource() == btnOk)
				{		// check user and pass in dbase		
				st = cn.createStatement();
				String logg = ("SELECT * FROM users WHERE user_uname='"+user2.getText()+"' AND user_pass='"+pass2.getText()+"'");
				rs = st.executeQuery(logg);
				if(rs.next() == true)
				{
				do 
				{
					pos = rs.getInt("user_pos");
					String pos1 = pos.toString();
					String usern = user2.getText();
					if(user2.getText().equals("admin"))
					{
						if(pos1.contentEquals("1"))
						{
						this.frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Welcome "+usern);
					
						new adminPage(); //
						}
					}
					else
					{
					if(pos1.contentEquals("0"))
					{
					this.frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "Welcome "+usern);
						new firstpage(usern); 
					}else
					{
						JOptionPane.showMessageDialog(null, "Invalid User and Pass");
						user2.setText("");
						pass2.setText("");
					}
					
					}
				}
				while(rs.next());
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid User and Pass");
				user2.setText("");
				pass2.setText("");
			}
			}else if(e.getSource() == btnCan)
			{
				System.exit(0);
			}
				
			}
			
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "No table");
			}
			
			
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "No table");
		}
		
	
	}

	
	
	
public static void main (String [] args)
{
	finals_proj proj = new finals_proj();
	
}





}
