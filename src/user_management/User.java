package user_management;

public class User {
	String firstname;
	String lastname;
	int age;
	String gender;
	String password;
	String confirmpassword;
	String email;
	int mobile;
	
	public void printuser() {
		System.out.println("**** USER DETAILS ****");
		System.out.println("User's First Name : " + firstname);
		System.out.println("User's Last Name : " + lastname);
		System.out.println("User's Age : " + age);
		System.out.println("User's Gender : " + gender);
		System.out.println("User's Email : " + email);
		System.out.println("User's Mobile no. : " + mobile);
		
	}
}
