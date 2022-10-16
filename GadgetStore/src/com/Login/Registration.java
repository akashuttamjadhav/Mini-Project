package com.Login;

import java.sql.Connection;
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
            	//System.out.println( "insert into ecommerce.RegisterUser (firstName,lastname,phoneno,username,vchpassword,emailid,address) values ('"+firstName +"',+'"+lastName +"','"+phoneNo +"','"+userName +"','"+password +"','"+emailId +"','"+address +"')");


    			String sql = "insert into ecommerce.RegisterUser (firstName,lastname,phoneno,username,vchpassword,emailid,address) values ('"+firstName +"',+'"+lastName +"','"+phoneNo +"','"+userName +"','"+password +"','"+emailId +"','"+address +"')";


    			// create the sql statement
    			Statement statement = con.createStatement();

    			// submit the sql statement to database..

    			//statement.executeUpdate(sql);
    			statement.execute(sql);

    			System.out.println("registered successfully...");

    			// close the resources.
    			con.close();
    			statement.close();
    		} catch (Exception e) {
    			System.out.println(e);
    		}

        }
    }
}


//class Register {
//	 private String firstName;
//	private String lastName;
//    private String userName;
//    private String password;
//    private String emailId;
//    private long phoneNo;
//   
//    public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getEmailId() {
//		return emailId;
//	}
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
//	public long getPhoneNo() {
//		return phoneNo;
//	}
//	public void setPhoneNo(long phoneNo) {
//		this.phoneNo = phoneNo;
//	}
//	
//    
//    @Override
//    public String toString() {
//        return "Register [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password=" +
//            password + ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
//    }
//}
