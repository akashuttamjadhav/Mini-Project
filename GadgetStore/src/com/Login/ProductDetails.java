package com.Login;
import java.util.Formatter;  

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDetails {
	public void getProduct (){
	Connection con =Connectivity.getConnection();
	Formatter fmt = new Formatter();  
	try {
		PreparedStatement pt = con.prepareStatement("select *  from ProductDetail ");
		ResultSet rs = pt.executeQuery();
		fmt.format("%15s %20s %35s %15s %15s\n", "pid", "pname", "vchdescription","price","quantity"); 
		while (rs.next()) {
		    int s = rs.getInt("pid");
		    String p = rs.getString("pname");
		    String d = rs.getString("vchdescription");
		    float prise = rs.getFloat("price");
		    int quantity  = rs.getInt("quantity");
		    fmt.format("%14s %20s %35s %14s %17s\n", s, p, d,prise,quantity); 
		    //System.out.println(s + "       " + p + "       " + d + "       " + prise + "       " + quantity);
		}
		System.out.println("-------------If you want to buy any item then please select items from below list------------");
		System.out.println(fmt);  
		//return fmt;
		
		
		
	}catch (Exception e) {
		System.out.println(e);
	}
}

}
