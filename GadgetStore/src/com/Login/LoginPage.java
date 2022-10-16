package com.Login;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class LoginPage {
	    public void login() {
	    	//Get Input from User
			Scanner sc = new Scanner(System.in);
			System.out.print("Please Enter Your Username => ");
			String userName = sc.nextLine();
			System.out.print("Please Enter Your Password => ");
			String password = sc.nextLine();	
	    	Connection con =Connectivity.getConnection();
			try {
				PreparedStatement pt = con.prepareStatement("select userName ,vchpassword from registeruser where username='"+userName+"' and vchpassword='"+password+"'");
				ResultSet rs = pt.executeQuery();
			
		 if (rs.next()) {
					 if(userName.equals(rs.getString(1))&& password.equals(rs.getString(2))) {
						 System.out.println("Login Successfull !!!");
						 ProductDetails pd = new ProductDetails();
						 pd.getProduct();
					 }
					 else {
						 System.out.println("Incorrect Username or Password");
					 }

				 }
		 else {
			 System.out.println("Incorrect Username or Password");
		 }

			} catch (Exception e) {
				System.out.println(e);
			}
	    
	    }

	    }

