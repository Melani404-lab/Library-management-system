
package View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MysqlConnection {
    
     private static final String URL = "jdbc:mysql://localhost:3306/library";
      private static final String USER = "root"; 
    private static final String PASSWORD = "";
    
     public static void main(String[] args) {
        Connection connection = null;
        
        
        
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            } catch (SQLException ex) {
                Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Connected to the database successfully!");
            
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
            try {
                // Step 3: Close the connection
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
}
