import java.util.Scanner;

public class Employee {
	private String fName, LName, email, pass;
	private int Department;
	Employee(String firstName, String lastName){
		this.fName = firstName;
		this.LName = lastName;
	}
	
	void getCredential(int department) {
		this.Department = department;
		CredentialService cs = new CredentialService(this.fName,this.LName,this.Department);
		this.email=cs.GenrateEmail();
		this.pass = cs.GenratePassword(16);
//		System.out.println(this.pass);
		cs.ShowPassword();
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the department from the following\n1. Technical\n2. Admin\n3. Human Resources\n4. Legal");
		Employee em = new Employee("Rishabh","Chauhan");
		int department = sc.nextInt();
		
		try {			
			em.getCredential(department);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}
}

class CredentialService {
	private String fName, lName, email, pass = "";
	private int Department;
	CredentialService(String firstName, String lastName, int department){
		this.fName = firstName;
		this.lName = lastName;
		this.Department = department;
	}
	
	String GenrateEmail() {
		switch(this.Department) {
		case 1:
			this.email = this.fName + this.lName + "@" + "tech.Oracle.com";
			break;
		case 2:
			this.email = this.fName + this.lName + "@" + "admin.Oracle.com";
			break;
		case 3:
			this.email = this.fName + this.lName + "@" + "hr.Oracle.com";
			break;
		case 4:
			this.email = this.fName + this.lName + "@" + "legal.Oracle.com";
			break;
		default:
			throw new IllegalStateException("You Have Input an Unavaiable Department");
		}
		return this.email;
	}
	
	String GenratePassword(int passLength) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz!@#$%^&*()_+";
		for(int i = 0; i < passLength; i++) {
			int num = (int)(AlphaNumericString.length() * Math.random());
			this.pass += AlphaNumericString.charAt(num);
		}
		return this.pass;
	}
	
	protected void ShowPassword() {
//		this.GenrateEmail();
//		this.GenratePassword(16);
		System.out.println("Dear " + this.fName + " your generated credentials are as follows");
		System.out.println("Email ---> " + this.email);
		System.out.println("Password ---> " + this.pass);
	}
}
