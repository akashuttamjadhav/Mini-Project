package com.Login;
import java.util.Formatter;  
import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ProductDetails {
	Connection con =Connectivity.getConnection();
	Scanner sc = new Scanner(System.in) ;
	Formatter fmt = new Formatter();  
	public void getProduct (int userid){
	
	try {
		PreparedStatement pt = con.prepareStatement("select *  from ProductDetail order by pname asc ");
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
		 System.out.println(" Press 1  Shopping Else Press 2 see Cart ");
		 int number = sc.nextInt();
		 ProductDetails pd = new ProductDetails();
		switch(number){  
	     
	    case 1: System.out.println("Select Items"); 
	    
	    pd.cartDetail(userid);
	    break;  
	    case 2: System.out.println("See Cart");
	    pd.seeCartDetail(userid);
	    break;   
	    //Default case statement  
	    default:System.out.println("");  
		
	}	
	}catch (Exception e) {
		System.out.println(e);
	}
 }
	
public void cartDetail(int userid)  {
	System.out.print(" Enter ProductName => ");
    String prdname = sc.nextLine();
    
    System.out.print(" Enter ProductId => ");
    int pid = sc.nextInt();

    System.out.print(" Enter Quantity => ");
    int pquantity = sc.nextInt();
    try { 
    //System.out.println("select *  from ProductDetail where pid= "+pid+" ");
    PreparedStatement pt = con.prepareStatement("select *  from ProductDetail where pid= "+pid+" ");
	ResultSet rs1 = pt.executeQuery();
	// System.out.println(rs1.getInt("price"));
	int amount =0 ;
	 if (rs1.next()) {
	 //System.out.println(rs1.getInt(4));
	 amount =(rs1.getInt(4) * pquantity);
	 }
	 System.out.println("Amount to pay is "+amount);
    /*System.out.println("insert into ecommerce.cartDetails (userid,pid,pname,quantity,amount,isdone) values"
    		+ " ("+userid +","+pid +",'"+prdname +"',"+pquantity +","+false +")");*/
    
    String sql = "insert into ecommerce.cartDetails"
    		+ " (userid,pid,pname,quantity,amount,isdone) values ("+userid +","+pid +",'"+prdname +"',"+pquantity +","+amount +","+false +")";
    Statement statement = con.createStatement();
	statement.execute(sql);

	System.out.println("successfully added in cart...");
	 System.out.println(" Press 1  for Continue Shopping Else Press 2 Payment ");
	 ProductDetails pd = new ProductDetails();
	 int number = sc.nextInt();
	switch(number){  
    
   case 1: System.out.println("Select Items"); 
   
   pd.cartDetail(userid);
   break;  
   case 2: System.out.println("Payment");

   pd.paymentDetail(userid);
   
   break;   
   //Default case statement  
   default:System.out.println("Not in 10, 20 or 30");  
	
}	
  }catch (Exception e) {
		System.out.println(e);
	}
}

public void paymentDetail(int userid) {
	try {
	String getPurchaseDetail = "select pid ,pname ,quantity ,amount  from cartDetails where userid= "+userid+"  and isdone=false";
	String totalAmount = "select sum(amount),isdone as TotalAmount from  Ecommerce.cartDetails where isdone= false group by userid having userid="+userid+"";
	PreparedStatement pt = con.prepareStatement(getPurchaseDetail);
	ResultSet rs1 = pt.executeQuery();
	PreparedStatement pt2 = con.prepareStatement(totalAmount);
	ResultSet rs2 = pt2.executeQuery();
	System.out.println("-----Please Review Below item list and do payment-----");
	fmt.format("%15s %20s %15s %15s\n", "ProductId", "ProductName","Quantity","Amount");

	while (rs1.next()) {
	    int s = rs1.getInt("pid");
	    String p = rs1.getString("pname");
	    float quantity = rs1.getFloat("quantity");
	    int amount  = rs1.getInt("amount");
	   fmt.format("%14s %20s %15s %14s\n", s, p,quantity,amount); 
	}
	System.out.println(fmt);
	if(rs2.next()) {
		System.out.println("You have to pay given amount ==>"+rs2.getInt(1) );
		System.out.println("Please press 1 for 'Proceed to buy above items' Press 2 for 'save it later'" );
		int number = sc.nextInt();
		switch(number){  
	    case 1: System.out.println("Proceed to buy above items");
	    System.out.println("Please do payment via phonpay googlePay" );
	    String updateCart = "update cartDetails set isdone = true where userid= "+userid+" ";
	    Statement statement = con.createStatement();
		statement.execute(updateCart);

	    System.out.println("Payment successfull!!!");
	    break;  
	    case 2: System.out.println("Save It Later");
	    break;   
	    //Default case statement  
	    default:System.out.println("");  
		
	}	
		
		
	}
	   
	}catch(Exception e) {
		System.out.println(e);
	}
}

public void seeCartDetail(int userid)  {
    try { 
    String query ="select pid ,pname ,quantity ,amount  from cartDetails where userid= "+userid+" and isdone = false ";
    PreparedStatement pt = con.prepareStatement(query);
	ResultSet rs1 = pt.executeQuery();
	fmt.format("%15s %20s %15s %15s\n", "ProductId", "ProductName","Quantity","Amount");
	 
		 while (rs1.next()) {
			 System.out.println("Here it is");
			    int s = rs1.getInt("pid");
			    String p = rs1.getString("pname");
			    float quantity = rs1.getFloat("quantity");
			    int amount  = rs1.getInt("amount");
			   fmt.format("%14s %20s %15s %14s\n", s, p,quantity,amount); 
			}
		 
		if (rs1.next()) {
			System.out.println("Please see your cart Detail is below");
			 System.out.println(fmt);
			 System.out.println(" Press 1  for Continue Shopping Else Press 2 Payment ");

	 }
	 else {
		 System.out.println("There is no any item you added in Cart before Please Press one for continue shopping");
		 System.out.println("Press 1  for Continue Shopping");

	 }
	 	 ProductDetails pd = new ProductDetails();
	 int number = sc.nextInt();
	switch(number){  
    
   case 1: System.out.println("Select Items"); 
   
   pd.getProduct(userid);
   break;  
   case 2: System.out.println("Payment");

   pd.paymentDetail(userid);
   
   break;   
   //Default case statement  
   default:System.out.println("");  
	
}	
  }catch (Exception e) {
		System.out.println(e);
	}
}

}


