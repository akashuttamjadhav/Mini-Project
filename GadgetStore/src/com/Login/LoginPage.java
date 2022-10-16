package com.Login;
import java.util.Scanner;
public class LoginPage {
	

	

	    public void login() {

	        try (Scanner scanner = new Scanner(System.in)) {
	            System.out.print(" Enter user name => ");
	            String userName = scanner.nextLine();

	            System.out.print(" Enter password => ");
	            String password = scanner.nextLine();

	            if (userName.equals(userName) && password.equals(password)) {
	                System.out.println(" User successfully logged-in.. ");
	            } else {
	                System.out.println(" In valid userName of password ");
	            }
	        }
	    }
	}


