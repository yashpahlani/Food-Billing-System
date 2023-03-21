import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AdminTest extends JFrame
{
	Container c;
	JLabel labuname,labpass,labphone;
	JButton Cashier,Admin;
	JTextField txtName,txtPass;
	

	AdminTest()
		{
			c=getContentPane();
			c.setLayout(null);

			ImageIcon imageIcon = new ImageIcon("image1.png"); 
			Image image = imageIcon.getImage(); 
			Image newimg = image.getScaledInstance(800, 300,100);
			ImageIcon newImageIcon = new ImageIcon(newimg); 
			JLabel iconLabel = new JLabel(newImageIcon);
			iconLabel.setBounds(200,-80,1000,300);
			c.add(iconLabel);

			JLabel heading = new JLabel("Admin Login");
			heading.setBounds(600,50,350,300);
			Font f3 = new Font("Times New Roman",Font.ITALIC,55);
			heading.setForeground(Color.CYAN);
			heading.setFont(f3);
			c.add(heading);

			labuname = new JLabel("Enter Username");
			Font f = new Font("Times New Roman",Font.ITALIC,45);
			labuname.setFont(f);
			labuname.setForeground(Color.WHITE);
			labuname.setBounds(250,280,500,100);
			c.add(labuname);

			txtName = new JTextField(20);
			txtName.setFont(f);
			txtName.setBounds(600,310,500,50);
			c.add(txtName);

			labpass = new JLabel("Enter Password");
			
			labpass.setFont(f);
			labpass.setForeground(Color.WHITE);
			labpass.setBounds(250,380,500,100);
			c.add(labpass);

			txtPass = new JTextField(20);
			txtPass.setFont(f);
			txtPass.setBounds(600,410,500,50);
			c.add(txtPass);


			Font f1 = new Font("Times New Roman",Font.BOLD,45);
		

			Admin = new JButton("Admin login");

			Admin.setBounds(580,510,450,60);
			Admin.setFont(f1);
			c.add(Admin);

			Cashier = new JButton("Cashier login");

			Cashier.setBounds(580,590,450,60);
			Cashier.setFont(f1);
			c.add(Cashier);


			ActionListener a4 = (ae)->
			{
				String uname = txtName.getText();
				String pass =  txtPass.getText();
			
				if(uname.equals("Yash") && pass.equals("Root"))		
				{
					ListTest I = new ListTest();
					dispose();
										

				}
				else
				{
					JOptionPane.showMessageDialog(c,"incorrect credentials");
					txtName.setText("");
					txtPass.setText("");
					txtName.requestFocus();
				}
			
			};
			Admin.addActionListener(a4);


			
			ActionListener a5 = (ae)->
			{
				LoginTest a = new LoginTest();
				dispose();
			};
			Cashier.addActionListener(a5);
	



			setTitle("Success Story App");
			setSize(1400,800);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			 Color color=new Color(164,0,3);
			c.setBackground(color);
	}
}

