package user_management;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import common.DBUtils;

public class UserManagementMain {
	public static void usermanagement() throws SQLException {
		Scanner sc = new Scanner(System.in);
		User user = new User();
		boolean continue_running = true;
		while(continue_running) {
			System.out.println("*************** WELCOME TO USER MANAGEMENT ******************");
			System.out.println(" WHAT WOULD YOU LIKE TODAY?");
			System.out.println("1. Add User ");
			System.out.println("2. Update User ");
			System.out.println("3. Search User ");
			System.out.println("4. Delete User ");
			System.out.println("5. Print User Details ");
			System.out.println("9. Exit User Management ");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter First Name : ");
				user.firstname = sc.next();
				
				System.out.println("Enter Last Name : ");
				user.lastname = sc.next();
				
				System.out.println("Enter Age : ");
				user.age = sc.nextInt();
				
				System.out.println("Enter Gender : ");
				user.gender = sc.next();
				
				System.out.println("Enter Password : ");
				String password = sc.next();
				
				System.out.println("Enter Confirm Password : ");
				String confirmpassword = sc.next();
				
				
				
				if(password.equals(confirmpassword)) {
					password = user.password;
				}else {
						System.out.println("ERROR!!Password doesn't match Confirm Password!!");
						System.out.println("Please Try Again !!");
					}
					
				
				
				System.out.println("Enter Email : ");
				user.email = sc.next();
				
				System.out.println("Enter Mobile NO. : ");
				user.mobile = sc.nextInt();
				
				String query = "insert into user (firstname, lastname, age, gender, finalPassword, email, mobile) values ('" + user.firstname + "', '"
						+ user.lastname + "', '" + user.age + "','" + user.gender + "','" + user.password + "','" + user.email + "','" + user.mobile + "')";

				DBUtils.executeQuery(query);

				break;
				
			case 2:
				
				System.out.println(" Enter User's name to update:");

				Scanner scToUpdate = new Scanner(System.in);
				String userNameToUpdate = scToUpdate.next();

				String selectQuery = "Select count(*) from user where firstname = '" + userNameToUpdate+"'";

				ResultSet rs = DBUtils.executeSelectQuery(selectQuery);
				rs.next();
				int countOfuser = rs.getInt(1);

				if (countOfuser == 1) {
					scToUpdate = new Scanner(System.in);

					System.out.println("Updated User firstname : ");
					String updatedFirstname = scToUpdate.next();

					System.out.println("Updated User lastname : ");
					String updatedLastname = scToUpdate.next();

					System.out.println("Updated User age : ");
					int updatedAge = scToUpdate.nextInt();
					
					System.out.println("Updated User gender : ");
					String updatedGender = scToUpdate.next();
					
					System.out.println("Updated User password : ");
					String updatedpassword = scToUpdate.next();
					
					System.out.println("Updated User confirmpassword : ");
					String updatedconfirmpassword = scToUpdate.next();
					
					String finalPassword = "";
					if(updatedpassword.equals(updatedconfirmpassword)) {
						updatedpassword = finalPassword;
					}else {
							System.out.println("ERROR!!Password doesn't match Confirm Password!!");
							System.out.println("Please Try Again !!");
						}
					System.out.println("Updated User email : ");
					String updatedemail = scToUpdate.next();
					
					System.out.println("Updated User mobile : ");
					int updatedmobile = scToUpdate.nextInt();

					String userUpdateQuery = "update user set firstname='" + updatedFirstname + "', lastname='"
							+ updatedLastname + "', age='" + updatedAge + "', gender='" + updatedGender + "', finalPassword='" + finalPassword + "', "
									+ "email='" + updatedemail +"', mobile='" + updatedmobile + "'";
					
					DBUtils.executeQuery(userUpdateQuery);
					
				} else {
					System.out.println("User Not found");
				}
				
				
				break;
				
			case 3:
				System.out.println(" Enter User name to search:");

				Scanner scToSearch = new Scanner(System.in);
				String userNameToSearch = scToSearch.next();

				String selectQueryForSearch = "Select * from user where firstname='"+userNameToSearch+"'";
				ResultSet searchResultSet = DBUtils.executeSelectQuery(selectQueryForSearch);

				while (searchResultSet.next()) {
					System.out.println(searchResultSet.getString(1)+" "+searchResultSet.getString(2)+" "+searchResultSet.getString(3)+" "+searchResultSet.getString(4)+" "+searchResultSet.getString(5)+" "+searchResultSet.getString(6)+" "+searchResultSet.getString(7)+" "+searchResultSet.getString(8));
				}
				
				break;
				
			case 4:
				System.out.println(" Enter User name to Delete:");

				Scanner scToDelete = new Scanner(System.in);
				String userNameToDelete = scToDelete.next();

				String deleteQuery = "delete from user where firstname='"+userNameToDelete+"'";
				DBUtils.executeQuery(deleteQuery);
				break;
				
			case 5:
				String selectAllQueryForSearch = "Select * from user";
				ResultSet printResultSet = DBUtils.executeSelectQuery(selectAllQueryForSearch);

				while (printResultSet.next()) {
					System.out.println(printResultSet.getString(1)+" "+printResultSet.getString(2)+" "+printResultSet.getString(3)
					+" "+printResultSet.getString(4)+" "+printResultSet.getString(5)+" "+printResultSet.getString(6)+" "+printResultSet.getString(7)+" "+printResultSet.getString(8));
				}

				break;
				
			case 9:
				System.out.println("************** EXITING USER MANAGEMENT ****************");
				continue_running = false;
				break;
				
				default:
					System.out.println("ERROR!!!This option doesn't exists!!!");
		}
				
		
	}

	}
}
