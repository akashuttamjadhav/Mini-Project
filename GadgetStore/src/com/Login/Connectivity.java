package com.Login;

import java.sql.Connection;
import java.sql.DriverManager;
public class Connectivity {
 static Connection con =null ;
 
 public static Connection getConnection() {
	 String dbUrl ="jdbc:mysql://localhost:3306/ecommerce";
	 String dbUsername ="root";
	 String dbPassword ="123456";
	 
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		 
	 }
	 catch (Exception e) {
		 e.printStackTrace();
	 }
	 return con;
 }
}
