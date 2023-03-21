import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class LoginTest extends JFrame
{
	Container c;
	JLabel labuname,labpass;
	JButton Login,Admin,Sign;
	JTextField txtName;
	

	LoginTest()
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

			JLabel heading = new JLabel("Cashier Login");
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

			JPasswordField txtPass = new JPasswordField(20);
			txtPass.setEchoChar('*');
			txtPass.setFont(f);
			txtPass.setBounds(600,410,500,50);
			c.add(txtPass);

			Login = new JButton("Login");
			Font f1 = new Font("Times New Roman",Font.BOLD,45);
			Login.setBounds(580,500,200,60);
			Login.setFont(f1);
			c.add(Login);

			Admin = new JButton("Admin");

			Admin.setBounds(580,580,200,60);
			Admin.setFont(f1);
			c.add(Admin);

			Sign = new JButton("Sign Up");

			Sign.setBounds(580,660,200,60);
			Sign.setFont(f1);
			c.add(Sign);





			ActionListener a1 = (ae)->
			{
				AdminTest a = new AdminTest();
				dispose();
			};
			Admin.addActionListener(a1);

			ActionListener a2 = (ae)->
			{

				String un = txtName.getText();
				String pw = String.valueOf(txtPass.getText());

				try
				{
					DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
					String url="jdbc:mysql://localhost:3306/billing_system";
					Connection con = DriverManager.getConnection(url,"root","yash");
					String sql = "select * from register where un=? and pw=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,un);
					pst.setString(2,pw);
					ResultSet rs = pst.executeQuery();
					if(rs.next())
					{
						
						Order o = new Order();
						dispose();

					}
							
					else
					{
						JOptionPane.showMessageDialog(c,"Invalid Login");
						txtName.setText("");
						 txtPass.setText("");

					}
						con.close();
				
				}
		
					catch(SQLException ex)
					{
						JOptionPane.showMessageDialog(c,"Unable To Login");
					}

				

			};
			Login.addActionListener(a2);


			ActionListener a3 = (ae)->
			{
				Sign s = new Sign();
				dispose();
			};
			Sign.addActionListener(a3);



			setTitle("Success Story App");
			setSize(1400,800);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			 Color color=new Color(164,0,3);
			c.setBackground(color);
	}
}

