

     import java.awt.*;
     import java.sql.*;
     import java.util.*;
     import javax.swing.*;

   public class Retrieve extends JFrame{

      static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
      static final String DATABASE_URL ="jdbc:odbc:JIT";
      GregorianCalendar c = new GregorianCalendar();
      private Connection con;
      private Statement state;
      public ResultSet rs;
      StringBuffer result = new StringBuffer();
     public Retrieve(){

     // super("LIST");

      try{

        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(DATABASE_URL);    
        state = con.createStatement();
        String t="First Name";
        String s = "yatharth";
        int d = c.get(Calendar.DATE);
        int m = c.get(Calendar.MONTH)+1;
       // System.out.println(d);
        rs = state.executeQuery("SELECT NAME FROM JIT WHERE DAY ="+d+"AND MONTH ="+m);// WHERE"+t+"='"+s+"'");

        
        ResultSetMetaData md = rs.getMetaData();
        StringBuffer res = new StringBuffer();

        int numberOfColoumns = md.getColumnCount();

        // for(int i=1;i<=numberOfColoumns;i++)
        //  result.append(md.getColumnName(i)+"\t");

          // result.append("\n");

        while( rs.next()){

           for(int i=1;i<=numberOfColoumns;i++)
             
            result.append(rs.getObject(i)+"\t");
              
             // result.append("\n");
           // System.out.println((String)(rs.getObject(0)));
        }
          //res.append(rs.getObject(1));
         //String p = res.toString();
         // System.out.println(result.toString());
         

    /*     JTextArea textArea = new JTextArea(result.toString());
         Container container = getContentPane();

         container.add(new JScrollPane(textArea));

           setSize(300,200);
           setVisible(true);*/
       }

       catch(SQLException s){

         JOptionPane.showMessageDialog(null,s.getMessage(),"Database                       Error",JOptionPane.ERROR_MESSAGE);

         System.exit(1);
       
      }

     catch(ClassNotFoundException c){
       
         JOptionPane.showMessageDialog(null,c.getMessage(),"Driver not found                         Error",JOptionPane.ERROR_MESSAGE);

          System.exit(1);
       
      }
    
     }
     String getName1(){
     
     	return result.toString();
     }
        public static void main(String args[]){

           Display2 d = new Display2();
            d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
      }
             
