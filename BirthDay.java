
//Title:        BIRTH DAY ALERT SYSTEM 
//Copyright:    Copyright (c) 2004
//DEVELOPER     ANUVINDHA S A       
//Description:  To inform u about the birth of u r friend


import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

//import java.util.Date;
import java.util.*;

import javax.swing.JOptionPane;
 //this class is used to implement alert information
class alert extends JFrame
{
 java.util.Date d = new java.util.Date();
 int m;
 Calendar c= Calendar.getInstance();
 java.util.Date dat=new java.util.Date();
 Retrieve r = new Retrieve();
 
 String name = r.getName1();
 //Display1 d1 = new Display1();
  //String name = d1.getValue();

      static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
      static final String DATABASE_URL ="jdbc:odbc:JIT";

   public Connection con; //con is a connection type object
  public Statement state; //state is a statement type object
      ResultSet rs;
   alert()
  {
  	 dat =c.getTime();

   d=dat;
   m=10;
  

          if( dat==d)
    {
        JOptionPane.showMessageDialog(null,"Today is "+name+"  BirthDay","BIRTHDAY MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public static void main(String ar[]) {
        alert a=new alert();
  
        }
}


// This is the main class by which other classes are linked
  public class BirthDay extends JFrame {

  Label label1 = new Label();
  Button button1 = new Button();
  Button button2 = new Button();
  Button button3 = new Button();

  public BirthDay() {  //constructor
    try  {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }


  void jbInit() throws Exception {

    this.getContentPane().setLayout(null);
    this.setSize(500,400);
    this.setBackground(Color.white);
    label1.setBackground(Color.white);
    label1.setBounds(new Rectangle(34, 86, 430, 84));
    label1.setFont(new java.awt.Font("Monospaced", 1, 40));
    label1.setForeground(SystemColor.textHighlight);
    label1.setText(" HAPPY BIRTH DAY");
    button1.setBounds(new Rectangle(324, 161, 104, 32));
    button1.setFont(new java.awt.Font("Monospaced", 1, 12));
    button1.setForeground(Color.white);
    button1.setBackground(SystemColor.textHighlight);
    button1.setLabel("REGISTRATION");
   
    button2.setBackground(SystemColor.textHighlight);
    button2.setBounds(new Rectangle(324, 211, 102, 27));
    button2.setFont(new java.awt.Font("Monospaced", 1, 12));
    button2.setForeground(Color.white);
    button2.setLabel("List");
     button3.setBackground(SystemColor.textHighlight);
    button3.setBounds(new Rectangle(324, 261, 102, 22));
    button3.setFont(new java.awt.Font("Monospaced", 1, 12));
    button3.setForeground(Color.white);
    button3.setLabel("Exit");
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().add(button2, null);
    this.getContentPane().add(button3, null);
    this.getContentPane().add(button1, null);
    this.getContentPane().add(label1, null);
	   alert alt =new alert();



    button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
									Registration Fram =new Registration();
									Fram.setSize(600,500);
									Fram.setVisible(true);
									
								}
							});

	button2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
									List Fram =new List();
									Fram.setVisible(true);
								}
							});
							 button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
									System.exit(0);
								}
							});

    this.setTitle("Happy BirthDay");
    this.setResizable(false);

  }


  public static void main(String arg[]) {
  	BirthDay f=new BirthDay();
  	f.setVisible(true);

  }

}


 


  class List extends JFrame{

      static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
      static final String DATABASE_URL ="jdbc:odbc:JIT";

      private Connection con;
      private Statement state;

     public List(){

      super("LIST");

      try{

        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(DATABASE_URL);    
        state = con.createStatement();
        
        ResultSet rs = state.executeQuery("SELECT * FROM JIT");

        StringBuffer result = new StringBuffer();
        ResultSetMetaData md = rs.getMetaData();

        int numberOfColoumns = md.getColumnCount();

         for(int i=1;i<=numberOfColoumns;i++)
            result.append(md.getColumnName(i)+"\t");

           result.append("\n");

        while( rs.next()){

           for(int i=1;i<=numberOfColoumns;i++)
             
            result.append(rs.getObject(i)+"\t");
              
              result.append("\n");
        }

         JTextArea textArea = new JTextArea(result.toString());
         Container container = getContentPane();

         container.add(new JScrollPane(textArea));

           setSize(500,400);
           setVisible(true);

       }

       catch(SQLException s){

         JOptionPane.showMessageDialog(null,s.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);

         System.exit(1);
       
      }

     catch(ClassNotFoundException c){
       
         JOptionPane.showMessageDialog(null,c.getMessage(),"Driver not found Error",JOptionPane.ERROR_MESSAGE);

          System.exit(1);
       
      }
    
     }
       
      }
             



