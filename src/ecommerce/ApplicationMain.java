package ecommerce;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import product_management.ProductManagementMain;
import user_management.UserManagementMain;

public class ApplicationMain {
	public static void main(String args[]) throws IOException, SQLException {
	System.out.println("############################## WELCOMR TO E-COMMERCE #############################");
	Scanner sc = new Scanner(System.in);
	boolean continue_running = true;
	
	while(continue_running) {
		System.out.println("        WHAT WOULD YOU LIKE TO DO TODAY?");
		System.out.println("           1. Product Management");
		System.out.println("           2. User Management");
		System.out.println("           9. Exit");
		
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			 ProductManagementMain.productManagement();
			break;
			
		case 2:
			UserManagementMain.usermanagement();
			break;
			
		case 9:
			System.out.println("####################### EXITING THE APPLICATION ########################");
			continue_running = false;
			break;
			
			default:
				System.out.println("ERROR!!This option is not available!!");
				
		}
	}
	
	}	
}
