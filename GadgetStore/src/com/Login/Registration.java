package com.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {
	

    public void RegisterUser(){

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(" Enter firstName => ");
            String firstName = scanner.nextLine();

            System.out.print(" Enter lastName => ");
            String lastName = scanner.nextLine();
            

            System.out.print(" Enter phoneNo => ");
            String phoneNo = scanner.nextLine();
     
            System.out.print(" Enter userName => ");
            String userName = scanner.nextLine();

            System.out.print(" Enter password => ");
            String password = scanner.nextLine();

            System.out.print(" Enter emailId => ");
            String emailId = scanner.nextLine();

            System.out.print(" Enter address => ");
            String address = scanner.nextLine();
            
        	Connection con =Connectivity.getConnection();
        	
            try { 
            	PreparedStatement pt = con.prepareStatement("select userName ,vchpassword from registeruser where username='"+userName+"' ");
				ResultSet rs = pt.executeQuery();
				 if (!rs.next()) {
					 
            	

    			String sql = "insert into ecommerce.RegisterUser (firstName,lastname,phoneno,username,vchpassword,emailid,address) values ('"+firstName +"',+'"+lastName +"','"+phoneNo +"','"+userName +"','"+password +"','"+emailId +"','"+address +"')";


    			Statement statement = con.createStatement();

    			statement.execute(sql);

    			System.out.println("registered successfully...");
    			
    			LoginPage lp = new LoginPage();
    			lp.login();
				 
    			// close the resources.
    			con.close();
    			statement.close();
    			}else {
    				System.out.println("UserName Already Exist");
    			}
    		} catch (Exception e) {
    			System.out.println(e);
    		}

        }
    }
}
