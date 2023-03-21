import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Sign extends JFrame
{
	Container c;
	JLabel labuname,labpass,labPhone,labpass2;
	JButton Login,Admin,Signup;
	JTextField txtName,txtPass,conpass;
	

	Sign()
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
	
			JLabel heading = new JLabel("Registration");
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
			txtName.setBounds(630,310,500,50);
			c.add(txtName);

			labpass = new JLabel("Enter Password");
			
			labpass.setFont(f);
			labpass.setForeground(Color.WHITE);
			labpass.setBounds(250,380,500,100);
			c.add(labpass);

			txtPass = new JTextField(20);
			txtPass.setFont(f);
			txtPass.setBounds(630,410,500,50);
			c.add(txtPass);

			labpass2 = new JLabel(" ReEnter Password");
			
			labpass2.setFont(f);
			labpass2.setForeground(Color.WHITE);
			labpass2.setBounds(250,480,500,100);
			c.add(labpass2);

			conpass = new JTextField(20);
			conpass.setFont(f);
			conpass.setBounds(630,510,500,50);
			c.add(conpass);

			


			Admin = new JButton("Admin");
			Font f1 = new Font("Times New Roman",Font.BOLD,45);
			Admin.setBounds(580,670,200,60);
			
			Admin.setFont(f1);
			c.add(Admin);

			Signup = new JButton("Register");

			Signup.setBounds(580,590,200,60);
			Signup.setFont(f1);
			c.add(Signup);





			ActionListener a6 = (ae)->
			{
				AdminTest a = new AdminTest();
				dispose();
			};
			Admin.addActionListener(a6);


			ActionListener a7 = (ae)->
			{
			
						String un = txtName.getText();
						String pw1 = txtPass.getText();
						String pw2 =conpass.getText();
						if(!pw1.equals(pw2))
						{
							JOptionPane.showMessageDialog(c,"Password didnot match");
							txtPass.setText("");
							conpass.setText("");
							return;
						}
						if(pw1.length()<8)
						{
							JOptionPane.showMessageDialog(c,"Password Should have minimum 8 characters");
							return;
						}

						try
						{
							DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
							String url="jdbc:mysql://localhost:3306/billing_system";
							Connection con = DriverManager.getConnection(url,"root","yash");
							String sql = "insert into register values(?,?)";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setString(1,un);
							pst.setString(2,pw1);
							 pst.executeUpdate();
							JOptionPane.showMessageDialog(c,"Registeration Successful");
							con.close();
							LoginTest a = new LoginTest();
							dispose();
				
						}
		
					catch(SQLException ex)
					{
						JOptionPane.showMessageDialog(c,"User Already Registered");
						txtPass.setText("");
						conpass.setText("");
						txtName.setText("");
					}

				
		

				
			};
			Signup.addActionListener(a7);



			setTitle("Billing App");
			setSize(1400,800);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			 Color color=new Color(164,0,3);
			c.setBackground(color);
	}
}

