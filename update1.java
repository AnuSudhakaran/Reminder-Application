

     import java.awt.*;
     import java.sql.*;//for connection with db
     import java.util.*;
     import javax.swing.*;//contain jframe

   public class update1 extends JFrame{

      static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
      static final String DATABASE_URL ="jdbc:odbc:JIT";

   public Connection con; //con is a connection type object
  public Statement state; //state is a statement type object
      ResultSet rs;
     public update1(String name,String d,String m,String y,String id){
      

      try{   
        int day = Integer.parseInt(d);//converts to int type
        int month = Integer.parseInt(m);
        int year = Integer.parseInt(y);
        Class.forName(JDBC_DRIVER);//name of driver
        con = DriverManager.getConnection(DATABASE_URL); //url of db   
        state = con.createStatement();//create query statement
        String query = ("INSERT INTO JIT(NAME,DAY,MONTH,YEAR,EMAIL_ID) VALUES('"+name+"',"+day+","+month+","+year+",'"+id+"')");
       int ry = state.executeUpdate(query);//execution of query
        
      
        rs = state.executeQuery("SELECT * FROM JIT");
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

       /*  JTextArea textArea = new JTextArea(result.toString());
         Container container = getContentPane();

         container.add(new JScrollPane(textArea));

           setSize(300,200);
           setVisible(true);*/

       }

       catch(SQLException s){

         JOptionPane.showMessageDialog(null,s.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);

         System.exit(1);
       
      }

     catch(ClassNotFoundException c){
       
         JOptionPane.showMessageDialog(null,c.getMessage(),"Driver not found                         Error",JOptionPane.ERROR_MESSAGE);

          System.exit(1);
       
      }
    
     }
      
      }
             
