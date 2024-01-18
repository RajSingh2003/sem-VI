import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Project extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3;
	String sql;
	JPanel p,p1; 
	PreparedStatement ps;
	Connection con;
	
	JTable t,ts;
	JScrollPane js;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;

	int columns;
	Vector colName=new Vector();
	Vector data=new Vector();
	
	Project()
	{
	  
          l1=new JLabel("Enter Project ID");
	  l2=new JLabel("Enter Project Name\n");
	l2.setLayout(new FlowLayout());
	  l3=new JLabel("Enter Project Description\n");
	l3.setLayout(new FlowLayout());
	  l4=new JLabel("Enter Project Status\n");
	l4.setLayout(new FlowLayout());
	
	  t1= new JTextField(20);
	  t2= new JTextField(20);
	  t3= new JTextField(30);
	  t4= new JTextField(20);
	  t4.setLayout(new FlowLayout());
	  b1=new JButton("Save");
	  b2=new JButton("Display");
	  b3=new JButton("Clear");
	  
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
		
	  p=new JPanel();
	  p.setLayout(new FlowLayout());
	  p1=new JPanel();
	  
	
	 	 p.add(l1);
	  	 p.add(t1);
		 p.add(l2);
		 p.add(t2);
		 p.add(l3);
		 p.add(t3);
		 p.add(l4);
		 p.add(t4);
		 p.add(b1);
		 p.add(b2);
		 p.add(b3);
	  	
		add(p);
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	public void actionPerformed(ActionEvent e){
		if((JButton)b1==e.getSource())
		{
			int pno=Integer.parseInt(t1.getText());
			String pname=t2.getText();
			String pdescription=t3.getText();
			String pstatus=t4.getText();
			System.out.println("Accept values");
			try{
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection("jdbc:postgresql://192.168.1.254/ty52","ty52","");
				sql="insert into Project values(?,?,?,?)";
				ps=con.prepareStatement(sql);
				ps.setInt(1,pno);
				ps.setString(2,pname);
				ps.setString(3,pdescription);
				ps.setString(4,pstatus);
				System.out.println("Values Set");
				int n=ps.executeUpdate();
				if(n!=0){
				 JOptionPane.showMessageDialog(null,"Record insered...");
				}
				else{
				  JOptionPane.showMessageDialog(null,"Record not insered...");
				}
			}
			catch(Exception ex){
				System.out.println(ex);
			}
		}
		else if((JButton)b2 ==e.getSource())
		{
			try{
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection("jdbc:postgresql://192.168.1.254/ty52","ty52","");
				System.out.println("Connected");
				stmt= con.createStatement();
				rs=stmt.executeQuery("Select * from Project");
				rsmd=rs.getMetaData();
				columns=rsmd.getColumnCount();
				for(int i=1;i<=columns;i++){
					colName.addElement(rsmd.getColumnName(i));
				}
				while(rs.next()){
				 Vector row=new Vector(columns);
				 for(int i=1;i<=columns;i++){
					row.addElement(rs.getObject(i));
				}
				data.addElement(row);
				}
				t=new JTable(data,colName);
				js=new JScrollPane(t);
				p1.add(js);
				add(p1);
				setSize(400,400);
				setVisible(true);
				
			}
			catch(Exception e1){
			System.out.println(e1);
			}
		}
		else{
		  t1.setText("");
		  t2.setText("");
		  t3.setText("");
		  t4.setText("");
		}
	}
	public static void main(String ar[])
	{
		Project po=new Project();
	}
}
