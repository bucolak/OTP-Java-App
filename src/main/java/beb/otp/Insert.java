/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beb.otp;
import java.sql.*;
import java.util.Random;
public class Insert {
    public void insertUser(String phoneNum)
    {
        Random r = new Random();
        int o = 100000 + r.nextInt(900000);
        String sql = "INSERT INTO users(phone_number, otp) VALUES(?,?)";
        try(Connection con = DriverManager.getConnection(DatabaseHelper.DB_URL);
                PreparedStatement pst = con.prepareStatement(sql))
        {
            pst.setString(1, phoneNum);
            pst.setInt(2, o);
            pst.execute();
            System.out.println("User OTP saved!");
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
