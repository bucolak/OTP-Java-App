/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beb.otp;
import java.sql.*;
public class Verify {
    public boolean verifyOTP(String phoneNum, int otp)
    {
        String sql = "SELECT * FROM users WHERE phone_number=? AND otp=?";
        try(Connection con = DriverManager.getConnection(DatabaseHelper.DB_URL);
                PreparedStatement pst = con.prepareStatement(sql))
        {
            pst.setString(1, phoneNum);
            pst.setInt(2, otp);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                String updateSql = "UPDATE users SET is_verified=1 WHERE phone_number=?";
                try(PreparedStatement updatePst = con.prepareStatement(updateSql))
                {
                    updatePst.setString(1, phoneNum);
                    updatePst.execute();
                }
                System.out.println("OTP verified!");
                return true;
            }
            else
            {
                System.out.println("OTP wrong!");
                return false;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
