/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package beb.otp;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
       DatabaseHelper db = new DatabaseHelper();
       Insert i = new Insert();
       Scanner sc = new Scanner(System.in);
       Verify v = new Verify();
       while(true)
       {
           System.out.println("      MENU");
           System.out.println("1 - Add User");
           System.out.println("2 - OTP Verify");
           System.out.println("3 - Exit");
           String election = sc.nextLine();
           if(election.equals("1"))
           {
               System.out.print("Enter your phone : ");
               String no = sc.nextLine();
               i.insertUser(no);
               System.out.println("User added successfully!");
           }
           else if(election.equals("2"))
           {
               System.out.print("Enter your phone : ");
               String no = sc.nextLine();
               System.out.print("Enter your OTP : ");
               int o = sc.nextInt();
               System.out.println("    Verifying...");
               try {
                    Thread.sleep(3000);
                }catch(InterruptedException e){}
               v.verifyOTP(no, o);
           }
           else if(election.equals("3"))
           {
               return ;
           }
               
       }
    }
    
}
