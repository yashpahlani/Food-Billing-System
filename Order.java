import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.swing.JTextArea;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import java.util.logging.*;

class Order extends JFrame
{
	Container c;
	JButton but1,but2,but3,but4,but5,but6,but7,but8,but9,but10,but11,but12;
	JButton Logout,newArea,subtotal,total,pay,print;
	JTextArea FoodArea;
	JTextField subtotalarea,custidarea,totalarea;
	JLabel custid,addgst;

	Order()
		{
			c=getContentPane();
			c.setLayout(null);
			
			but1 = new JButton("Pav Bhaji");
			but2 = new JButton("Butter papdi");
			but3 = new JButton("Pani Puri");	
			but4 = new JButton("Noodles");	
			but5 = new JButton("Pizza");	
			but6 = new JButton("Burger");	
			but7 = new JButton("Cheese Dosa");	
			but8 = new JButton("Idli");	
			but9 = new JButton("Vada Pav");	
			but10 = new JButton("Chilli Paneer");	
			but11 = new JButton("Cold Drink");	
			but12= new JButton("Ice Cream");		
			

			but1.setBounds( 0,0 ,200,150);
			but2.setBounds( 200,0 ,200 ,150);
			but3.setBounds(400 , 0,200 ,150);
			but4.setBounds(0 ,150 ,200 ,150);
			but5.setBounds(200 ,150 ,200 ,150);
			but6.setBounds( 400,150 , 200,150);
			but7.setBounds( 0, 300, 200,150);
			but8.setBounds(200 ,300 ,200 ,150);
			but9.setBounds( 400, 300,200 ,150);
			but10.setBounds( 0,450 ,200 ,150);
			but11.setBounds( 200, 450, 200,150);
			but12.setBounds( 400,450 ,200 ,150);
			

			Font f = new Font("Times New Roman",Font.ITALIC,30);			


			but1.setFont(f);
			but2.setFont(f);
			but3.setFont(f);
			but4.setFont(f);
			but5.setFont(f);
			but6.setFont(f);
			but7.setFont(f);
			but8.setFont(f);
			but9.setFont(f);
			but10.setFont(f);
			but11.setFont(f);
			but12.setFont(f);



			c.add(but1);
			c.add(but2);
			c.add(but3);
			c.add(but4);
			c.add(but5);
			c.add(but6);
			c.add(but7);
			c.add(but8);
			c.add(but9);
			c.add(but10);
			c.add(but11);
			c.add(but12);
/*==============================================================================================================*/

			Logout = new JButton("Log out");
			Logout.setBounds(0,650,200,60);
			Logout.setFont(f);
			Logout.setBackground(Color.CYAN);
			c.add(Logout);

			newArea = new JButton("New");
			newArea.setBounds(250,650,200,60);
			newArea.setFont(f);
			newArea.setBackground(Color.CYAN);
			c.add(newArea);


			subtotal= new JButton("Sub Total");
			subtotal.setBounds(550,650,200,60);
			subtotal.setFont(f);
			subtotal.setBackground(Color.YELLOW);
			c.add(subtotal);

			subtotalarea = new JTextField(10);
			subtotalarea.setFont(f);
			subtotalarea.setBounds(780,650,200,60);
			c.add(subtotalarea);

			addgst= new JLabel("GST=10%");
			addgst.setBounds(1000,650,200,60);
			addgst.setFont(f);
			addgst.setForeground(Color.YELLOW);
			c.add(addgst);

			
			custid = new JLabel("Customer Id");
			custid.setFont(f);
			custid.setForeground(Color.WHITE);
			custid.setBounds(1200,0,200,60);
			c.add(custid);

			custidarea = new JTextField(10);
			custidarea.setFont(f);
			custidarea.setBounds(1200,60,150,60);
			c.add(custidarea);

			total= new JButton("Total");
			total.setBounds(1200,150,150,60);
			total.setFont(f);
			total.setBackground(Color.YELLOW);
			c.add(total);

			totalarea = new JTextField(10);
			totalarea.setFont(f);
			totalarea.setBounds(1200,230,150,60);
			c.add(totalarea);

			pay= new JButton("Pay");
			pay.setBounds(1200,330,150,60);
			pay.setFont(f);
			pay.setBackground(Color.GREEN);
			c.add(pay);

			print= new JButton("Print");
			print.setBounds(1200,430,150,60);
			print.setFont(f);
			print.setBackground(Color.GREEN);
			c.add(print);



/*========================================================================================*/
		

			Font f2 = new Font("monospaced",Font.BOLD,20);

			FoodArea = new JTextArea(10,6);
			FoodArea.setFont(f2);
			FoodArea.setBounds(600,0,550,600);
			FoodArea.append( "              Yash Restaurant\n\n");
			
			FoodArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
			 FoodArea.append( "             Bill by Yash Restaurant\n\n");
 			
			FoodArea.setLineWrap(true);
			FoodArea.setWrapStyleWord(true);
			c.add(FoodArea);
/*===================================================================================================*/

			ArrayList<Integer> price = new ArrayList<>();
			ArrayList<String> food= new ArrayList<>();


/*=========================================================================================================*/

			ActionListener a8=(ae)->{
				LoginTest l =new LoginTest();
				dispose();
	
			};
			Logout.addActionListener(a8);

			ActionListener a9=(ae)->{
				FoodArea.setText("");
				FoodArea.append( "              Yash Restaurant\n\n");
				
				FoodArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				 FoodArea.append( "             Bill by Yash Restaurant\n\n");
 				
				FoodArea.setLineWrap(true);
				FoodArea.setWrapStyleWord(true);
				food.removeAll(food);
				price.removeAll(price);
				subtotalarea.setText("");
				totalarea.setText("");
				custidarea.setText("");
			};
			newArea.addActionListener(a9);



			ActionListener a10=(ae)->{
				
				int sum=0;
				for (Integer i : price)
           				 sum += i;
				subtotalarea.setText(sum+" ");
			};
			subtotal.addActionListener(a10);



			ActionListener a11=(ae)->{
				
				FoodArea.append("Pav Bhaji           Rs80\n");
				price.add(80);
				food.add("pav bhaji");
			};
			but1.addActionListener(a11);

			ActionListener a12=(ae)->{
				
				FoodArea.append("Butter Papdi        Rs30\n");
				price.add(30);
				food.add("Butter Papdi");
			};
			but2.addActionListener(a12);

			ActionListener a13=(ae)->{
				
				FoodArea.append("Pani Puri           Rs15\n");
				price.add(15);
				food.add("Pani Puri");
			};
			but3.addActionListener(a13);

			ActionListener a14=(ae)->{
				
				FoodArea.append("Noodles             Rs40\n");
				price.add(40);
				food.add("Noodles");
			};
			but4.addActionListener(a14);

			ActionListener a15=(ae)->{
				
				FoodArea.append("Pizza               Rs100\n");
				price.add(100);
				food.add("Pizza");
			};
			but5.addActionListener(a15);

			ActionListener a16=(ae)->{
				
				FoodArea.append("Burger              Rs60\n");
				price.add(60);
				food.add("Burger");
			};
			but6.addActionListener(a16);

			ActionListener a17=(ae)->{
				
				FoodArea.append("Cheese Dosa         Rs130\n");
				price.add(130);
				food.add("Cheese Dosa");
			};
			but7.addActionListener(a17);

			ActionListener a18=(ae)->{
				
				FoodArea.append("Idli                Rs30\n");
				price.add(30);
				food.add("Idli");
			};
			but8.addActionListener(a18);

			ActionListener a19=(ae)->{
				
				FoodArea.append("VadaPav             Rs13\n");
				price.add(13);
				food.add("Vadapav");
			};
			but9.addActionListener(a19);

			ActionListener a20=(ae)->{
				
				FoodArea.append("Chilli Paneer       Rs150\n");
				price.add(150);
				food.add("Chilli Paneer");
			};
			but10.addActionListener(a20);

			ActionListener a21=(ae)->{
				
				FoodArea.append("Cold Drink          Rs40\n");
				price.add(40);
				food.add("Cold Drink");
			};
			but11.addActionListener(a21);

			ActionListener a22=(ae)->{
				
				FoodArea.append("Ice Cream           Rs20\n");
				price.add(20);
				food.add("Ice Cream");
			};
			but12.addActionListener(a22);



			ActionListener a23=(ae)->{
				int sum=0;
				for (Integer i : price)
           				 sum += i;
				double total = (sum*10)/100;
				double realtotal = sum+total;
				String id = custidarea.getText();
				if(id.equals("")){  JOptionPane.showMessageDialog(c,"Enter Customerid"); }
				else{
				totalarea.setText(realtotal + "");
				FoodArea.append(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				FoodArea.append("Customer id is  "+id+"\n");
				FoodArea.append("  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				FoodArea.append("         Total with 10% gst is " +realtotal+"\n");
	
				}

			};
			total.addActionListener(a23);

			ActionListener a24=(ae)->{
		try
			{
				FoodArea.setLineWrap(true);
				FoodArea.setWrapStyleWord(true);
				FoodArea.print();
			}

			catch(Exception e)
			{
				Logger.getLogger(Order.class.getName()).log(Level.SEVERE,null,e);
			}
		};
			
			print.addActionListener(a24);


			ActionListener a25=(ae)->{
				String custid=custidarea.getText();
				StringBuffer sb = new StringBuffer();
				for(String s : food)
				{	
					
					sb.append(s);
					sb.append(",");
				}
				String fooditems = sb.toString();
				String totalprice = totalarea.getText();
				if(custidarea.getText().equals("")){
					JOptionPane.showMessageDialog(c,"Please Enter Custid");}
						try
						{
							DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
							String url="jdbc:mysql://localhost:3306/billing_system";
							Connection con = DriverManager.getConnection(url,"root","yash");
							String sql = "insert into bill values(?,?,?)";
							PreparedStatement pst = con.prepareStatement(sql);
							pst.setString(1,custid);
							pst.setString(2,fooditems);
							pst.setString(3,totalprice);
							 pst.executeUpdate();
							JOptionPane.showMessageDialog(c,"Payment Successful");
							con.close();
							
				
						}
		
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(c,"Customer id already existed\n");
					}

			
			};
			pay.addActionListener(a25);

			


		




/*=====================================================================================================*/	
			setTitle("Billing App");
			setSize(1400,800);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			 Color color=new Color(164,0,3);
			c.setBackground(color);
	}
}

