import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class firstpage extends JFrame {
	/**
	 * 
	 */
	JFrame frame;
	JPanel panel,panel1,panel2,panel3,panel4,panel5;
	JLabel title,cout,loginuser,testing,bgframe,samlabel,sellbl;
	JButton btnAdd,btnRemove,btnCancel,btnNext,butOppo,butSam,butIp,butXiao,butVivo;
	JButton cartbtn,logoutbtn;
	//samsung labels and buttons
	JLabel samlbl,samvar,samlbl1,samlbl2;
	JButton samlblbut,samadd1,samlblbut1,samlblbut2;
	//samsung labels  and buttons
	
	//oppo labels and buttons
	JLabel oppolbl,oppolbl1,oppolbl2;
	JButton btnOppo,btnOppo1,btnOppo2;
	//oppo labels and buttons
	
	//xiaomi labels and buttons
	JLabel xiaolbl,xiaolbl1,xiaolbl2;
	JButton btnXiao,btnXiao1,btnXiao2;
	//xiaomi labels and buttons
	
	//iPhone labels and buttons
	JLabel iplbl,iplbl1,iplbl2;
	JButton btnIp,btnIp1,btnIp2;
	//iPhone labels and buttons
		
	//vivo labels and buttons
	JLabel vilbl,vilbl1,vilbl2;
	JButton btnVi,btnVi1,btnVi2;
	//vivo labels and buttons	
	
	
	Connection cn;
	Statement st;
	ResultSet rs;
	
	
	String usern;
	
	public firstpage(String usern) /**/
	{
		
		this.usern = usern;
		frame = new JFrame("CHOOSE PHONE");
		panel = new JPanel();
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
		cartbtn = new JButton("VIEW CART");
			cartbtn.setBounds(410,20,160,30);
			panel.add(cartbtn);
			cartbtn.setFont(new Font("SansSerif",Font.BOLD,18));
			cartbtn.setBackground(Color.LIGHT_GRAY);
			cartbtn.setForeground(Color.black);
			cartbtn.setCursor(cursor);
			
		logoutbtn = new JButton("LOGOUT");
			logoutbtn.setBounds(800,30,140,25);
			panel.add(logoutbtn);
			logoutbtn.setFont(new Font("SansSerif",Font.BOLD,18));
			logoutbtn.setBackground(Color.LIGHT_GRAY);
			logoutbtn.setForeground(Color.black);
			logoutbtn.setCursor(cursor);
			
			
		loginuser = new JLabel("WELCOME "+usern);	
			loginuser.setBounds(20,20,200,20);
			panel.add(loginuser);
			loginuser.setFont(new Font("Arial black",Font.BOLD,18));
			loginuser.setForeground(Color.LIGHT_GRAY);
			
		testing = new JLabel("");
			testing.setBounds(50,50,500,50);
			panel.add(testing);
			
		//TOP ICONS AND BUTTONS
		ImageIcon icon1 = new ImageIcon (new ImageIcon("samsung.jpeg").getImage().getScaledInstance(140, 120, Image.SCALE_DEFAULT));
		butSam = new JButton(icon1);
			butSam.setBounds(40,80,140,120);
			panel.add(butSam);
			butSam.setCursor(cursor);
			
			ImageIcon icon2 = new ImageIcon (new ImageIcon("oppo.png").getImage().getScaledInstance(140, 120, Image.SCALE_DEFAULT));
		butOppo = new JButton(icon2);
			butOppo.setBounds(230,80,140,120);
			panel.add(butOppo);
			butOppo.setCursor(cursor);
			
		ImageIcon icon3 = new ImageIcon (new ImageIcon("xiaomi.png").getImage().getScaledInstance(140, 120, Image.SCALE_DEFAULT));
		butXiao = new JButton(icon3);
			butXiao.setBounds(423,80,140,120);
			panel.add(butXiao);
			butXiao.setCursor(cursor);
			
		ImageIcon icon4 = new ImageIcon (new ImageIcon("iphone.jpeg").getImage().getScaledInstance(140, 120, Image.SCALE_DEFAULT));
		butIp = new JButton(icon4);
			butIp.setBounds(615,80,140,120);
			panel.add(butIp);	
			butIp.setCursor(cursor);
			
		ImageIcon icon5 = new ImageIcon (new ImageIcon("vivo.jpeg").getImage().getScaledInstance(140, 120, Image.SCALE_DEFAULT));
		butVivo = new JButton(icon5);
			butVivo.setBounds(800,80,140,120);
			panel.add(butVivo);	
			butVivo.setCursor(cursor);
			
		//TOP ICONS AND BUTTONS
			
			
		//panels	
		panel1 = new JPanel(); //Samsung panel
		panel1.setLayout(null);
			panel1.setVisible(false);
			panel1.setBounds(30,240,920,300);
			frame.add(panel1);
			panel1.setBackground(Color.LIGHT_GRAY);
			
			
		panel2 = new JPanel(); //Oppo panel
			panel2.setLayout(null);
				panel2.setVisible(false);
				panel2.setBounds(30,240,920,300);
				frame.add(panel2);	
				panel2.setBackground(Color.LIGHT_GRAY);
				
		panel3 = new JPanel(); //Xiaomi Panel
				panel3.setLayout(null);
				panel3.setVisible(false);
				panel3.setBounds(30,240,920,300);
				frame.add(panel3);
				panel3.setBackground(Color.LIGHT_GRAY);
				
		panel4 = new JPanel(); //iPhone panel
				panel4.setLayout(null);
				panel4.setVisible(false);
				panel4.setBounds(30,240,920,300);
				frame.add(panel4);	
				panel4.setBackground(Color.LIGHT_GRAY);
				
		panel5 = new JPanel(); //Vivo panel
				panel5.setLayout(null);
				panel5.setVisible(false);
				panel5.setBounds(30,240,920,300);
				frame.add(panel5);
				panel5.setBackground(Color.LIGHT_GRAY);
						
		//panels
				
		//SAMSUNG PANEL1		
		ImageIcon sam4 = new ImageIcon (new ImageIcon("samsung ultra.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
		samlblbut = new JButton(sam4);
			samlblbut.setBounds(90,25,180, 210);
			panel1.add(samlblbut);
			samlblbut.setCursor(cursor);
			
		ImageIcon sam5 = new ImageIcon (new ImageIcon("samsung S10.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			samlblbut1 = new JButton(sam5);
				samlblbut1.setBounds(370,25,180, 210);
				panel1.add(samlblbut1);
				samlblbut1.setCursor(cursor);
		
		ImageIcon sam6 = new ImageIcon (new ImageIcon("A30.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
				samlblbut2 = new JButton(sam6);
				samlblbut2.setBounds(650,25,180, 210);
				panel1.add(samlblbut2);
				samlblbut2.setCursor(cursor);
					
		
	
		samlbl = new JLabel("Samsung S20 Ultra");
			samlbl.setBounds(105,250,160,20);
			panel1.add(samlbl);
			samlbl.setFont(new Font("sansserif",Font.BOLD,17));
			samlbl.setForeground(Color.black);
			
			
		samlbl1 = new JLabel("Samsung S10");
			samlbl1.setBounds(400,250,130,20);
			panel1.add(samlbl1);
			samlbl1.setFont(new Font("sansserif",Font.BOLD,17));
			samlbl1.setForeground(Color.black);
			
		samlbl2 = new JLabel("Samsung A30s");
			samlbl2.setBounds(665,250,150,20);
			panel1.add(samlbl2);
			samlbl2.setFont(new Font("sansserif",Font.BOLD,17));
			samlbl2.setForeground(Color.black);
		//SAMSUNG PANEL1

			
		//OPPO PANEL2
			ImageIcon oppocp = new ImageIcon (new ImageIcon("oppo find.jpeg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			btnOppo = new JButton(oppocp);
			btnOppo.setBounds(90,25,180, 210);
				panel2.add(btnOppo);	
				btnOppo.setCursor(cursor);
				
			ImageIcon oppocp1 = new ImageIcon (new ImageIcon("oppo reno.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			btnOppo1 = new JButton(oppocp1);
			btnOppo1.setBounds(370,25,180, 210);
					panel2.add(btnOppo1);
					btnOppo1.setCursor(cursor);
			ImageIcon oppocp2 = new ImageIcon (new ImageIcon("oppocp3.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
					btnOppo2 = new JButton(oppocp2);
					btnOppo2.setBounds(650,25,180, 210);
					panel2.add(btnOppo2);
					btnOppo2.setCursor(cursor);			
		
		
			oppolbl = new JLabel("OPPO Find x2 PRO");
				oppolbl.setBounds(105,250,160,20);
				panel2.add(oppolbl);
				oppolbl.setFont(new Font("sansserif",Font.BOLD,17));
				oppolbl.setForeground(Color.black);
				
			oppolbl1 = new JLabel("OPPO Reno2");
				oppolbl1.setBounds(400,250,130,20);
				panel2.add(oppolbl1);
				oppolbl1.setFont(new Font("sansserif",Font.BOLD,17));
				oppolbl1.setForeground(Color.black);	
			oppolbl2 = new JLabel("OPPO F15");
				oppolbl2.setBounds(665,250,150,20);
				panel2.add(oppolbl2);
				oppolbl2.setFont(new Font("sansserif",Font.BOLD,17));
				oppolbl2.setForeground(Color.black);		
			
		//OPPO PANEL2
				
		//XIAOMI PANEL3
			ImageIcon xiaocp = new ImageIcon (new ImageIcon("poco.jpeg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			btnXiao = new JButton(xiaocp);
			btnXiao.setBounds(90,25,180, 210);
				panel3.add(btnXiao);	
				btnXiao.setCursor(cursor);
				
			ImageIcon xiaocp1 = new ImageIcon (new ImageIcon("redmi.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			btnXiao1 = new JButton(xiaocp1);
			btnXiao1.setBounds(370,25,180, 210);
					panel3.add(btnXiao1);
					btnXiao1.setCursor(cursor);
			ImageIcon xiaocp2 = new ImageIcon (new ImageIcon("mi8.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
					btnXiao2 = new JButton(xiaocp2);
					btnXiao2.setBounds(650,25,180, 210);
					panel3.add(btnXiao2);
					btnXiao2.setCursor(cursor);
					
					
					
			xiaolbl = new JLabel("POCOPHONE F1");
				xiaolbl.setBounds(105,250,160,20);
				panel3.add(xiaolbl);
				xiaolbl.setFont(new Font("sansserif",Font.BOLD,17));
				xiaolbl.setForeground(Color.black);
				
			xiaolbl1 = new JLabel("Redmi mi10");
				xiaolbl1.setBounds(400,250,130,20);
				panel3.add(xiaolbl1);
				xiaolbl1.setFont(new Font("sansserif",Font.BOLD,17));
				xiaolbl1.setForeground(Color.black);
			xiaolbl2 = new JLabel("Redmi 8");
				xiaolbl2.setBounds(675,250,150,20);
				panel3.add(xiaolbl2);
				xiaolbl2.setFont(new Font("sansserif",Font.BOLD,17));
				xiaolbl2.setForeground(Color.black);	
				
				
		//XIAOMI PANEL3		
		
		//iPhone PANEL4
			ImageIcon ipcp = new ImageIcon (new ImageIcon("iphone11.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			btnIp = new JButton(ipcp);
			btnIp.setBounds(90,25,180,210);
				panel4.add(btnIp);	
				btnIp.setCursor(cursor);
				
			ImageIcon ipcp1 = new ImageIcon (new ImageIcon("iphone10.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			btnIp1 = new JButton(ipcp1);
			btnIp1.setBounds(370,25,180,210);
					panel4.add(btnIp1);
					btnIp1.setCursor(cursor);
					
			ImageIcon ipcp2 = new ImageIcon (new ImageIcon("ip8.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
					btnIp2 = new JButton(ipcp2);
					btnIp2.setBounds(650,25,180, 210);
							panel4.add(btnIp2);
							btnIp2.setCursor(cursor);
					
					
			iplbl = new JLabel("iPhone 11 PRO max");
			iplbl.setBounds(105,250,160,20);
				panel4.add(iplbl);
				iplbl.setFont(new Font("sansserif",Font.BOLD,17));
				iplbl.setForeground(Color.black);
				
			iplbl1 = new JLabel("iPhone 10");
				iplbl1.setBounds(400,250,130,20);
				panel4.add(iplbl1);
				iplbl1.setFont(new Font("sansserif",Font.BOLD,17));
				iplbl1.setForeground(Color.black);
			
			iplbl2 = new JLabel("iPhone 8");
				iplbl2.setBounds(675,250,150,20);
				panel4.add(iplbl2);
				iplbl2.setFont(new Font("sansserif",Font.BOLD,17));
				iplbl2.setForeground(Color.black);
			
		//iPhone PANEL4			
				
		//Vivo PANEL5
			ImageIcon vicp = new ImageIcon (new ImageIcon("vivo 19.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			btnVi = new JButton(vicp);
			btnVi.setBounds(90,25,180,210);
				panel5.add(btnVi);	
				btnVi.setCursor(cursor);
				
			ImageIcon vicp1 = new ImageIcon (new ImageIcon("vivo nex.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
			btnVi1 = new JButton(vicp1);
			btnVi1.setBounds(370,25,180,210);
					panel5.add(btnVi1);
					btnVi1.setCursor(cursor);
			ImageIcon vicp2 = new ImageIcon (new ImageIcon("vivos5.jpg").getImage().getScaledInstance(180, 210, Image.SCALE_DEFAULT));	
					btnVi2 = new JButton(vicp2);
					btnVi2.setBounds(650,25,180, 210);
							panel5.add(btnVi2);
							btnVi2.setCursor(cursor);
					
			vilbl = new JLabel("Vivo v19");
				vilbl.setBounds(120,250,130,20);
				panel5.add(vilbl);
				vilbl.setFont(new Font("sansserif",Font.BOLD,17));
				vilbl.setForeground(Color.black);
				
			vilbl1 = new JLabel("Vivo Nex 3");
				vilbl1.setBounds(400,250,130,20);
				panel5.add(vilbl1);
				vilbl1.setFont(new Font("sansserif",Font.BOLD,17));
				vilbl1.setForeground(Color.black);
			vilbl2 = new JLabel("Vivo S5");
				vilbl2.setBounds(675,250,150,20);
				panel5.add(vilbl2);
				vilbl2.setFont(new Font("sansserif",Font.BOLD,17));
				vilbl2.setForeground(Color.black);
		//Vivo PANEL5
	
			
			//samsung icon on top
			butSam.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{	
										panel2.setVisible(false);
										panel1.setVisible(true);	
						}
			});
			
			//samsung 1st phone
			samlblbut.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new samsung(usern);
						}
			});
			
			//samsung 2nd phone
			samlblbut1.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new samsung1(usern);
						}
			});
			
			//samsung 3nd phone
			samlblbut2.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new samsung2(usern);
						}
			});
			
			//Oppo icon on top
			butOppo.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{	
									panel1.setVisible(false);
										panel2.setVisible(true);	
						}
			});
			
			//oppo 1st phone
			btnOppo.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new oppo(usern);
						}
			});
			//oppo 2st phone
			btnOppo1.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{				
							new oppo1(usern);
						}
			});
						
			//oppo 3st phone
			btnOppo2.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{				
							new oppo2(usern);
						}
			});
			//Xiaomi icon on top
			butXiao.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{	
									panel1.setVisible(false);
										panel2.setVisible(false);	
										panel3.setVisible(true);
						}
			});
			
			//Xiaomi phone 1
			btnXiao.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new poco1(usern);
						}
			});
			
			//Xiaomi phone 2
			btnXiao1.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new poco2(usern);
						}
			});
			
			btnXiao2.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new poco3(usern);
						}
			});
			
			//iPhone ICON top
			butIp.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{		
										panel1.setVisible(false);
										panel2.setVisible(false);	
										panel3.setVisible(false);
										panel4.setVisible(true);
						}
			});
			
			//iPhone phone 1
			btnIp.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new ip(usern);
						}
			});
			
			//iPhone phone 2
			btnIp1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ex)
						{			
							new ip1(usern);
						}
			});
			//iPhone phone 3
			btnIp2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ex)
						{			
							new ip2(usern);
						}
			});
			

			//iPhone ICON top
			butVivo.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ex)
						{	
							panel4.setVisible(false);
									panel1.setVisible(false);
										panel2.setVisible(false);	
										panel3.setVisible(false);
										panel5.setVisible(true);
						}
			});
			
			//Vivo phone 1
			btnVi.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new vivo1(usern);
						}
			});
			
			//Vivo phone 2
			btnVi1.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new vivo2(usern);
						}
			});
			//Vivo phone 3
			btnVi2.addActionListener(new ActionListener()
			{
						public void actionPerformed(ActionEvent ex)
						{			
							new vivo3(usern);
						}
			});
			logoutbtn.addActionListener(new ActionListener()
			{
				
						public void actionPerformed(ActionEvent ex)
						{	
							
							
									
							frame.setVisible(false);
							new finals_proj();
									
									
								
						
						}
						
			
			});
			
			cartbtn.addActionListener(new ActionListener()
			{
				
						public void actionPerformed(ActionEvent ex)
						{	
							
							
							frame.setVisible(false);		
							new cart(usern);
									
									
								
						
						}
						
			
			});
			
			ImageIcon Iconn = new ImageIcon (new ImageIcon("space.jpg").getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT));
			JLabel pIcon = new JLabel(Iconn);
			panel.add(pIcon);
			pIcon.setBounds(0,0,1000,900);
			
			
			
			
		frame.add(panel);
		frame.setBounds(400,60,1000,900);
		panel.setLayout(null);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "Please choose Cellphone Brand above");
	}
	
	
	
}


