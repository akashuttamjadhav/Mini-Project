package com.Login;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("-------------------ECommerce Project------------------------");
		System.out.println("-------------------Welcome TO GadgetStore------------------------");
		Scanner sc = new Scanner(System.in) ;
	            System.out.println(" Press 1  If Already Register Else Press 2 for Register ");
	            int number = sc.nextInt();
	            LoginPage lp = new LoginPage();
	            Registration reg=new Registration();
	    switch(number){  
	     
	    case 1: System.out.println("Please SignIn"); 
	    lp.login();
	    break;  
	    case 2: System.out.println("Please signUP");
	    reg.RegisterUser();
	    break;   
	    //Default case statement  
	    default:System.out.println("Please signUP");  
	    reg.RegisterUser();
		
	}

}
}