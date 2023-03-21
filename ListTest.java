import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ListTest extends JFrame
{

	Container c;
	TextArea custdetails;
	JButton logout,delete,userdetails;
	JTextField deletearea;
	JLabel deleteid;
	
	ListTest()
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

			JLabel heading = new JLabel("Customer Details");
			heading.setBounds(580,110,450,100);
			Font f3 = new Font("Times New Roman",Font.ITALIC,55);
			heading.setForeground(Color.CYAN);
			heading.setFont(f3);
			c.add(heading);

			Font f = new Font("monospaced",Font.BOLD,25);
			
			custdetails=new TextArea(8,30);
			custdetails.append("\n"+"                  Welcome to Yash Restaurant Database  \n\n");

			custdetails.setFont(f);
			custdetails.setBounds(200,200,1000,450);

			JScrollPane scrollpane = new JScrollPane(custdetails);
			add(scrollpane);
			scrollpane.setBorder(BorderFactory.createEmptyBorder());
			scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			c.add(custdetails);
			custdetails.setEditable(false);
			
			Font f1 = new Font("Times New Roman",Font.PLAIN,30);
			logout = new JButton("Logout");
			logout.setFont(f1);
			logout.setBounds(200,660,200,80);
			c.add(logout);

			userdetails = new JButton("User Details");
			userdetails.setFont(f1);
			userdetails.setBounds(1100,660,200,80);
			c.add(userdetails);
					

			deleteid = new JLabel("Delete CustId: ");
			deleteid.setForeground(Color.WHITE);
			deleteid.setFont(f1);
			deleteid.setBounds(480,620,250,150);
			c.add(deleteid);
	
			deletearea = new JTextField(10);
			deletearea.setForeground(Color.BLACK);
			deletearea.setFont(f1);
			deletearea.setBounds(680,670,100,50);
			c.add(deletearea);

			delete = new JButton("Delete");
			delete.setFont(f1);
			delete.setBounds(820,660,200,80);
			c.add(delete);


/*=================================================================================*/
	try
		{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/billing_system";
			Connection con = DriverManager.getConnection(url,"root","yash");
			String sql = "select * from bill";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			StringBuffer info = new StringBuffer();
			while(rs.next())
				info.append("\n"+"Customer Id : " +rs.getInt(1) + "\n" +"Food Items:" +rs.getString(2) + "\n" +"Total Price:" + rs.getString(3)+ "\n");
			custdetails.setText(info.toString());
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
	User u = new User();
	dispose();

};
userdetails.addActionListener(a33);
/*===================================================================================*/

ActionListener a32 = (ae)->
{
 try {
            String custid = deletearea.getText();
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/billing_system";
            Connection con = DriverManager.getConnection(url,"root","yash");
            String sql = "SELECT * FROM bill WHERE custid = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, custid);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                // ID exists in the database, proceed with deletion
                sql = "DELETE FROM bill WHERE custid = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, custid);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record deleted successfully!");
	      ListTest l = new ListTest(); 
            } else {
                // ID does not exist in the database
                JOptionPane.showMessageDialog(null, "ID does not exist in the database!");
            }
            con.close();
        }
	 catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"issue"+ex);
        }

};
delete.addActionListener(a32);



/*=================================================================================*/
			setTitle("Success Story App");
			setSize(1400,800);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			 Color color=new Color(164,0,3);
			c.setBackground(color);
	}
}


