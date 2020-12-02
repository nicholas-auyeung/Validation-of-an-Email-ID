package emailvalidation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailIdValidation {
	
	public static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9_.-]+$";
	
	public static void main(String[] args) {
		
		boolean stillRunning = true;
		
		while(stillRunning = true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to Email Validation" + "\n");
			System.out.println("Please enter the number of emails to validate'");
			int numEmails = scan.nextInt();
			String[] arrEmails = new String[numEmails];
			System.out.println("Type the " + numEmails + "proceed by pressing 'Enter' after each one");
			for(int i = 0; i < arrEmails.length; i++) {
				arrEmails[i] = scan.next();
			}
			Pattern pattern = Pattern.compile(regex);
			for(String email : arrEmails) {
				Matcher matcher = pattern.matcher(email);
				System.out.println("E-mail: " + email + "is" + (matcher.matches() ? "valid":"invalid"));
			}
			
			
			scan.close();
		
	}
}
