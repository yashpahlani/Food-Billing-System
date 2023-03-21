import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class User extends JFrame
{

	Container c;
	TextArea userdetails;
	JButton logout,custdetails11,delete,update;
	JTextField deletearea;
	JLabel deleteun;
	User()
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

			JLabel heading = new JLabel("User Details");
			heading.setBounds(580,110,450,100);
			Font f3 = new Font("Times New Roman",Font.ITALIC,55);
			heading.setForeground(Color.CYAN);
			heading.setFont(f3);
			c.add(heading);


			Font f = new Font("monospaced",Font.BOLD,25);
			
			userdetails=new TextArea(8,30);
	

			userdetails.setFont(f);
			userdetails.setBounds(200,200,1000,450);

			JScrollPane scrollpane = new JScrollPane(userdetails);
			add(scrollpane);
			scrollpane.setBorder(BorderFactory.createEmptyBorder());
			scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			c.add(userdetails);
			userdetails.setEditable(false);
			
			Font f1 = new Font("Times New Roman",Font.PLAIN,30);
			logout = new JButton("Logout");
			logout.setFont(f1);
			logout.setBounds(200,660,200,80);
			c.add(logout);

			custdetails11 = new JButton("Customer Details");
			custdetails11.setFont(f1);
			custdetails11.setBounds(450,660,300,80);
			c.add(custdetails11);

			deleteun = new JLabel("Delete Cust UN: ");
			deleteun.setForeground(Color.WHITE);
			deleteun.setFont(f1);
			deleteun.setBounds(800,620,250,150);
			c.add(deleteun);
	
			deletearea = new JTextField(10);
			deletearea.setForeground(Color.BLACK);
			deletearea.setFont(f1);
			deletearea.setBounds(1000,670,100,50);
			c.add(deletearea);

			delete = new JButton("Delete");
			delete.setFont(f1);
			delete.setBounds(1150,660,200,80);
			c.add(delete);
/*
			update = new JButton("Update");
			update.setFont(f1);
			update.setBounds(820,660,200,80);
			c.add(update);			*/
	/*=================================================================================*/
	try
		{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/billing_system";
			Connection con = DriverManager.getConnection(url,"root","yash");
			String sql = "select * from register";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			StringBuffer info = new StringBuffer();
			while(rs.next())
				info.append("\n"+"Username : " +rs.getString(1) + "\n" +"Password:" +rs.getString(2) + "\n");
			userdetails.setText(info.toString());
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(c,"issue "+e);
		}


/*=================================================================================*/

ActionListener a31 = (ae)->
{
	AdminTest a = new AdminTest();
	dispose();

};
logout.addActionListener(a31);

ActionListener a33 = (ae)->
{
	ListTest l = new ListTest();
	dispose();

};
custdetails11.addActionListener(a33);
/*==========================================================================================*/

ActionListener a32 = (ae)->
{
 try {
            String un = deletearea.getText();
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/billing_system";
            Connection con = DriverManager.getConnection(url,"root","yash");
            String sql = "SELECT * FROM register WHERE un = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, un);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
          
                sql = "DELETE FROM register WHERE un = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, un);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record deleted successfully!");
            } else {

                JOptionPane.showMessageDialog(null, "Username does not exist in the database!");
            }
            con.close();
        }
	 catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"issue"+ex);
        }


};
delete.addActionListener(a32);

/*==========================================================================================*/
/*==========================================================================================*/
/*
ActionListener a34 = (ae)->
{
	
			

		try
		{
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://localhost:3306/billing_system";
				Connection con = DriverManager.getConnection(url,"root","yash");
				String sql = "update  set pw= ? where un =?";
				PreparedStatement pst = con.prepareStatement(sql);
				String newun =JOptionPane.showInputDialog("Enter Updated Username:");
				String newpw =JOptionPane.showInputDialog("Enter Updated Password:");
				pst.setString(1,newun);
				pst.setString(2,newpw);
				long r = pst.executeUpdate();
				JOptionPane.showMessageDialog(c,"Details Updated!!");

				
				con.close();
				
			}
		
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(c,"issue"+ex );
			}

};
update.addActionListener(a34);*/

/*==========================================================================================*/


			setTitle("Success Story App");
			setSize(1400,800);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			 Color color=new Color(164,0,3);
			c.setBackground(color);
	}
}
