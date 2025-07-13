/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beb.otp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseHelper {
    public static final String DB_URL = "jdbc:sqlite:otp_db.db";
    
    public DatabaseHelper()
    {
        createTableIfNotExist();
    }
    public void createTableIfNotExist()
    {
        String sql = "CREATE TABLE IF not EXISTS users("
           + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
           + "phone_number TEXT NOT NULL,"
           + "otp INTEGER,"
           + "is_verified INTEGER DEFAULT 0"
           + ");";
        
        try(Connection conn = DriverManager.getConnection(DB_URL);
                Statement st = conn.createStatement())
        {
            st.execute(sql);
            System.out.println("It's ready!");
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}
